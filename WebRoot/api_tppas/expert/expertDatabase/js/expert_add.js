	// 项目根目录
	var path="";
	
	var idList = new Array("skillJob","expertIncumbency","expertType");

	
	$(function() {
		$(document).ready(function() {
			path = $("#path").text();
			if($("#isSelect").val()!=null&&$("#isSelect").val()!=''){
				upms.upmsUtils.initSelect("sex",$("#hiddensexTemp").val(), 1 , 1 , 0);
    	      	upms.upmsUtils.initSelect("schooling",$("#hiddenschoolingTemp").val(), 1 , 1 , 0);
    	      	upms.upmsUtils.initSelect("skillJob",$("#skillJob").val(), 1 , 1 , 1);
    	      	upms.upmsUtils.initSelect("expertPrestige",$("#hiddenexpertPrestigeTemp").val(), 1 , 1 , 0);
    	      	upms.upmsUtils.initSelect("expertMajor1",$("#hiddenexpertMajor1").val(), 1 , 1 , 0);
    	      	upms.upmsUtils.initSelect("expertMajor2",$("#hiddenexpertMajor2Temp").val(), 1 , 1 , 0);
    	      	upms.upmsUtils.initSelect("expertMajor3",$("#hiddenexpertMajor3Temp").val(), 1 , 1 , 0);
    	      	upms.upmsUtils.initSelect("deptType",$("#hiddendeptTypeTempTemp").val(), 1 , 1 , 0);
    	      	upms.upmsUtils.initSelect("expertDegree",$("#hiddenexpertDegreeTemp").val(), 1 , 1 , 0);
    	      	upms.upmsUtils.initSelect("expertIncumbency",$("#expertIncumbency").val(), 1 , 1 , 1);
    	      	upms.upmsUtils.initSelect("expertType",$("#expertType").val(), 1 , 1 , 1);
    		}else{
    			upms.upmsUtils.initSelect("sex","", 1 , 1 , 0);
    	      	upms.upmsUtils.initSelect("schooling","", 1 , 1 , 0);
    	      	upms.upmsUtils.initSelect("skillJob","", 1 , 1 , 1);
    	      	upms.upmsUtils.initSelect("expertPrestige","", 1 , 1 , 0);
    	      	upms.upmsUtils.initSelect("expertMajor1","", 1 , 1 , 0);
    	      	upms.upmsUtils.initSelect("expertMajor2","", 1 , 1 , 0);
    	      	upms.upmsUtils.initSelect("expertMajor3","", 1 , 1 , 0);
    	      	upms.upmsUtils.initSelect("deptType","", 1 , 1 , 0);
    	      	upms.upmsUtils.initSelect("expertDegree","", 1 , 1 , 0);
    	      	upms.upmsUtils.initSelect("expertIncumbency","", 1 , 1 , 1);
    	      	upms.upmsUtils.initSelect("expertType","", 1 , 1 , 1);
    		}
	      	
			if($("#isEdit").val() == "0"){
				$("input[type='text']").each(function(){
					$(this).attr("disabled",true);
				});
				$("textarea").each(function(){
					$(this).attr("readonly",true);
					$(this).css('background-color','#F0F0F0');
				});
			 }
		});
	});
	
	//保存按钮事件
	$("#saveBut").click(function(){
  		// 验证下拉列表
  		var result2 = upms.upmsUtils.selectCheck(idList);
  		var result3 = checkExpertMajor();
  		// 输入项验证
		if(upms.upmsUtils.inputCheck() || result2 || result3){
			return;
		}
		
		var comfirmInfo = $("#comfirmSave").text();
		//判断是保存还是修改
		if($("#expertId").val()!=null&&$("#expertId").val()!=''){
			comfirmInfo = $("#comfirmUpdate").text();
		}
		
		if (confirm(comfirmInfo)){
			//获取隐藏项
			var hiddenList = $("input[type='hidden']");
			//获取文本框项
			var inputList = $("input[type='text']");
			
			var actionUrl= path + "/api/expert/texpertAction!saveOrUpdateExpert.action?optType=0&now="+new Date().getTime();
  			upms.showOverLay();// 打开遮罩
  			var $newPgDiv = $("#content");
  			var arrParams = [{name:"texpert.sex",targetid:"sex",type:"select"},
			              {name:"texpert.schooling",targetid:"schooling",type:"select"},
			              {name:"texpert.expertDegree",targetid:"expertDegree",type:"select"},
  			              {name:"texpert.expertJob",targetid:"expertJob",type:"select"},
  			              {name:"texpert.skillJob",targetid:"skillJob",type:"select"},
			              {name:"texpert.expertMajor1",targetid:"expertMajor1",type:"select"},
			              {name:"texpert.expertMajor2",targetid:"expertMajor2",type:"select"},
			              {name:"texpert.expertMajor3",targetid:"expertMajor3",type:"select"},
			              {name:"texpert.expertPrestige",targetid:"expertPrestige",type:"select"},
  			              {name:"texpert.deptType",targetid:"deptType",type:"select"},
  			              {name:"texpert.expertIncumbency",targetid:"expertIncumbency",type:"select"},
  			              {name:"texpert.expertType",targetid:"expertType",type:"select"},
  			              {name:"texpert.researchFindings",targetid:"researchFindings",type:"textarea"}];
  			// 添加隐藏项
			for(var i=0; i< hiddenList.length; i++){
				if(hiddenList.eq(i).attr("name") !="hidden"){
					var params = {name:hiddenList.eq(i).attr("name"),targetid:hiddenList.eq(i).attr("id"),type:"text"};
					arrParams[arrParams.length] = params;
				}
			}
			//添加文本框项
			for(var i=0; i< inputList.length; i++){
				var params = {name:inputList.eq(i).attr("name"),targetid:inputList.eq(i).attr("id"),type:"text"};
				arrParams[arrParams.length] = params;
			}
			
  			var data = upms.transParsToObj(arrParams, $newPgDiv);
  			$newPgDiv.load(actionUrl, data, function() {
  				upms.hideOverLay();
  			});
		}
  		
  	});
	
	//下一步按钮事件
	$("#nextBut").click(function(){
  		// 验证下拉列表
  		var result2 = upms.upmsUtils.selectCheck(idList);
  		var result3 = checkExpertMajor();
  		// 输入项验证
		if(upms.upmsUtils.inputCheck() || result2 || result3){
			return;
		}
		
		var comfirmInfo = $("#comfirmSave").text();
		//判断是保存还是修改
		if($("#expertId").val()!=null&&$("#expertId").val()!=''){
			comfirmInfo = $("#comfirmUpdate").text();
		}
		
		if (confirm(comfirmInfo)){
			//设置左边菜单选中
			upms.upmsUtils.setMenu();
			//获取隐藏项
			var hiddenList = $("input[type='hidden']");
			//获取文本框项
			var inputList = $("input[type='text']");
			
			var actionUrl= path + "/api/expert/texpertAction!saveOrUpdateExpert.action?optType=1&now="+new Date().getTime();
  			upms.showOverLay();// 打开遮罩
  			var $newPgDiv = $("#content");
  			var arrParams = [{name:"texpert.sex",targetid:"sex",type:"select"},
			              {name:"texpert.schooling",targetid:"schooling",type:"select"},
			              {name:"texpert.expertDegree",targetid:"expertDegree",type:"select"},
  			              {name:"texpert.expertJob",targetid:"expertJob",type:"select"},
  			              {name:"texpert.skillJob",targetid:"skillJob",type:"select"},
			              {name:"texpert.expertMajor1",targetid:"expertMajor1",type:"select"},
			              {name:"texpert.expertMajor2",targetid:"expertMajor2",type:"select"},
			              {name:"texpert.expertMajor3",targetid:"expertMajor3",type:"select"},
			              {name:"texpert.expertPrestige",targetid:"expertPrestige",type:"select"},
  			              {name:"texpert.deptType",targetid:"deptType",type:"select"},
  			              {name:"texpert.expertIncumbency",targetid:"expertIncumbency",type:"select"},
  			              {name:"texpert.expertType",targetid:"expertType",type:"select"},
  			              {name:"texpert.researchFindings",targetid:"researchFindings",type:"textarea"}];
  			// 添加隐藏项
			for(var i=0; i< hiddenList.length; i++){
				if(hiddenList.eq(i).attr("name") !="hidden"){
					var params = {name:hiddenList.eq(i).attr("name"),targetid:hiddenList.eq(i).attr("id"),type:"text"};
					arrParams[arrParams.length] = params;
				}
			}
			//添加文本框项
			for(var i=0; i< inputList.length; i++){
				var params = {name:inputList.eq(i).attr("name"),targetid:inputList.eq(i).attr("id"),type:"text"};
				arrParams[arrParams.length] = params;
			}
			
  			var data = upms.transParsToObj(arrParams, $newPgDiv);
  			$newPgDiv.load(actionUrl, data, function() {
  				upms.hideOverLay();
  			});
		}
  		
  	});
	
	//验证专家擅长专业1、擅长专业2、擅长专业3不能重复
	function checkExpertMajor(){
		var expertMajor3Msg = $("#expertMajor3");
		$("#errorexpertMajor").remove();
		var flag = false;
		var expertMajor1 = $("#expertMajor1").val();
		var expertMajor2 = $("#expertMajor2").val();
		var expertMajor3 = $("#expertMajor3").val();
		if((expertMajor2!=null&&expertMajor2!="")&&(expertMajor3!=null&&expertMajor3!="")){
			if(expertMajor1==expertMajor2 || expertMajor1==expertMajor3 || expertMajor2==expertMajor3){
				var span = $("<div id='errorexpertMajor'><span style='color:red;font-style: normal;'>擅长专业不能重复！</span></div>");
				expertMajor3Msg.parent().append(span);
				flag = true;
			}
		}
		if((expertMajor2!=null&&expertMajor2!="")&&(expertMajor3==null||expertMajor3=="")){
			if(expertMajor1==expertMajor2 ){
				var span = $("<div id='errorexpertMajor'><span style='color:red;font-style: normal;'>擅长专业不能重复！</span></div>");
				expertMajor3Msg.parent().append(span);
				flag = true;
				flag = true;
			}
		}
		if((expertMajor2==null||expertMajor2=="")&&(expertMajor3!=null&&expertMajor3!="")){
			if(expertMajor1==expertMajor3){
				var span = $("<div id='errorexpertMajor'><span style='color:red;font-style: normal;'>擅长专业不能重复！</span></div>");
				expertMajor3Msg.parent().append(span);
				flag = true;
				flag = true;
			}
		}
		return flag;
	}
	
	//清除擅长专业信息提示
	function delExpertMajorMsg(){
		$("#errorexpertMajor").remove();
	}
	
	//查看的下一步
	function nextStep(expertId){
		//选中左边菜单
		upms.upmsUtils.setMenu();
		var actionUrl= path + "/api/expert/ttechnologyGainAction!list.action?expertId="+expertId+"&isEdit=0&now=" + new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		var arrParams = [];
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	}