	// 项目根目录
	var path = "";
	
	//打分项数组
	var scoreArray = new Array("companyStatusScore","projectTechnologyScore","projectBaseScore","projectMarketScore","projectBenefitScore");
	//平均分项
	var complexAverage = "complexAverage";
	//总分项
	var complexScore = "complexScore";
	//总分超过100消息提示
	var complexScoreMsg = "complexScoreMsg";
	$(function(){
		$(document).ready(function() {
			path = $("#path").text();
			$("input[moneyFlag='money']").each(function(){
				if($(this).val() == "" || $(this).val()==null){
					$(this).attr("value", 0);
				}
			});
		
		});
	});
	
	//返回按钮事件
	$("#backBut").bind("click",function() {
		var groupId = $("#groupId").val();
		var actionUrl = path + "/api/expert/texpertScoreWriteAction!projectListManager.action?groupId="+groupId+"&date="+ new Date().getTime();
		var arrParams = [];
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#mainContent");
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	});
	
	//计算平均值、计算总分 typeValue-0:技术专家 1:投资专家
	function countComplexScore(indexValue,typeValue){
		//得到集合大小
		var technologyList = $("#technologyList").text();
		var investmentList = $("#investmentList").text();
		var technologyListSize = parseInt(technologyList);
		var investmentListSize = parseInt(investmentList);
		
		var countValue = parseInt(0);
		for(var i=0; i<scoreArray.length; i++){
			countValue = countValue + parseInt(scoreDefault($("#"+scoreArray[i]+indexValue).val()));
		}
		//总分
		$("#"+complexScore+indexValue).val(countValue);
		
		//技术专家平均分
		if(typeValue==0){
			var technologyComplexAverage = parseInt(0);
			for(var n=1; n<=technologyListSize; n++){
				technologyComplexAverage = technologyComplexAverage + parseInt(scoreDefault($("#"+complexScore+n).val()));
			}
			var technologyExpertComplexAverage = technologyComplexAverage/technologyListSize;
			$("#projectTechnologyAverage").val(technologyExpertComplexAverage.toFixed(2));
		}
		//投资专家平均分
		if(typeValue==1){
			var investmentComplexAverage = parseInt(0);
			for(var t=technologyListSize+1; t<=technologyListSize+investmentListSize; t++){
				investmentComplexAverage = investmentComplexAverage + parseInt(scoreDefault($("#"+complexScore+t).val()));
			}
			var investmentExpertComplexAverage = investmentComplexAverage/investmentListSize;
			$("#projectInvestmentAverage").val(investmentExpertComplexAverage.toFixed(2));
		}
		//$("#"+complexAverage+indexValue).val(countValue/scoreArray.length);
		
		//如果总分超过100分，显示提示消息
		if(countValue>100){
			$("#"+complexScoreMsg+indexValue).remove();
			var spanMsg = $("<div id='"+complexScoreMsg+indexValue+"'><span style='color:red;'>总分不能超过100分</span></div>");
			$("#"+complexScore+indexValue).parent().append(spanMsg);
		}else{
			$("#"+complexScoreMsg+indexValue).remove();
		}
	}
	
	//验证总分不能超过100分
	function checkComplexScore(){
		var flag = false;
		//得到集合大小
		var technologyList = $("#technologyList").text();
		var investmentList = $("#investmentList").text();
		
		for(var c=1; c<=parseInt(technologyList)+parseInt(investmentList); c++){
			var countValue = parseInt(0);
			for(var i=0; i<scoreArray.length; i++){
				countValue = countValue + parseInt(scoreDefault($("#"+scoreArray[i]+c).val()));
			}
			
			//如果总分超过100分，显示提示消息
			if(countValue>100){
				$("#"+complexScoreMsg+c).remove();
				var spanMsg = $("<div id='"+complexScoreMsg+c+"'><span style='color:red;'>总分不能超过100分</span></div>");
				$("#"+complexScore+c).parent().append(spanMsg);
				flag = true;
			}
		}
		
		return flag;
	}
	
	//分项值为空默认是0
	function scoreDefault(scoreValue){
		if(scoreValue==null || scoreValue==""){
			return 0;
		}else{
			return scoreValue;
		}
	}
	
	function submitData(optType){
		//验证文本
		var result = upms.upmsUtils.inputCheck();
		//验证单选
		var radioParams = new Array();
		var technologyListSize = parseInt(0);
		var investmentListSize = parseInt(0); 
		var technologyList = $("#technologyListSize");
		var investmentList = $("#investmentListSize");
		if(technologyList.length>0){
			technologyListSize = technologyListSize + parseInt(technologyList.val());
			for(var t=1;t<=technologyListSize;t++){
				var technologyRadioName = "technologyList["+t+"].finalResult";
				radioParams[radioParams.length] = technologyRadioName;
			}
		}
		if(investmentList.length>0){
			investmentListSize = investmentListSize + parseInt(investmentList.val());
			for(var n=1;n<=investmentListSize;n++){
				var investmentRadioName = "investmentList["+n+"].finalResult";
				radioParams[radioParams.length] = investmentRadioName;
			}
		}
		var result1 = upms.upmsUtils.radioCheck(radioParams,1);
		//验证总分数
		var complexScoreResult = checkComplexScore();
	
		if(result || result1 || complexScoreResult){
			return;
		}
		var confirmInfo = $("#comfirmSave").text();
		if(optType=="1"){
			confirmInfo = $("#comfirmNext").text();
		}
		if (confirm(confirmInfo)){
			//var projectId = $("#projectId").val();
			//{name:"groupId",targetid:"groupId",type:"text"},
            //{name:"projectTechnologyAverage",targetid:"projectTechnologyAverage",type:"text"},
            //{name:"projectInvestmentAverage",targetid:"projectInvestmentAverage",type:"text"}
			var actionUrl = path + "/api/expert/texpertScoreWriteAction!saveExpertScore.action?date="+ new Date().getTime();
			if(optType=="0"){
				actionUrl = actionUrl + "&optType=0";
			}else{
				actionUrl = actionUrl + "&optType=1";
			}
			var arrParams = [];
			upms.showOverLay();// 打开遮罩
			var $newPgDiv = $("#mainContent");
			arrParams = upms.upmsUtils.setSubmitDatas(arrParams, 1, 0);
			var radioList = $("input[type='radio']");	
			// 添加动态项信息
			for(var i=0; i< radioList.length; i++){
				var params = {name:radioList.eq(i).attr("name"),targetname:radioList.eq(i).attr("name"),type:"radio"};
				arrParams[arrParams.length] = params;
			}
			var data = upms.transParsToObj(arrParams, $newPgDiv);
			$newPgDiv.load(actionUrl, data, function() {
				upms.hideOverLay();
			});
		}
	}