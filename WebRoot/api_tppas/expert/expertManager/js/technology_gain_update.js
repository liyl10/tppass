	// 项目根目录
	var path="";
	
	$(function() {
		$(document).ready(function() {
			path = $("#path").text();
		});
	});
	
	//保存按钮-保存事件
	$("#saveBut").click(function(){
  		// 输入项验证
		if(upms.upmsUtils.inputCheck()){
			return;
		}
		
		var comfirmInfo = $("#comfirmUpdate").text();
		if (confirm(comfirmInfo)){
			//获取隐藏项
			var hiddenList = $("input[type='hidden']");
			//获取文本框项
			var inputList = $("input[type='text']");
			
			var actionUrl= path + "/api/expert/texpertInfoAction!updateTtechnologyGain.action?optType=0&now="+new Date().getTime();
			upms.showOverLay();// 打开遮罩
  			var $newPgDiv = $("#content");
  			var arrParams = [{name:"ttechnologyGain.gainFinish",targetid:"gainFinish",type:"textarea"},
      			             {name:"ttechnologyGain.gainCondition",targetid:"gainCondition",type:"textarea"}];
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
	
	//返回
	function returnList(expertId){
		var actionUrl= path + "/api/expert/texpertInfoAction!technologyGainList.action?expertId="+expertId+"&now="+new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		$newPgDiv.load(actionUrl, null, function() {
			upms.hideOverLay();
		});
	}