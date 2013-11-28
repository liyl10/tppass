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
		
		var comfirmInfo = $("#comfirmSave").text();
		if (confirm(comfirmInfo)){
			var actionUrl= path + "/api/expert/texpertInfoAction!saveTtechnologyGain.action?optType=0&now="+new Date().getTime();
  			upms.showOverLay();// 打开遮罩
  			var $newPgDiv = $("#content");
  			var arrParams = [{name:"ttechnologyGain.expertId",targetid:"expertId",type:"text"},
    			             {name:"ttechnologyGain.gainName",targetid:"gainName",type:"text"},
    			             {name:"ttechnologyGain.gainSource",targetid:"gainSource",type:"text"},
      			             {name:"ttechnologyGain.gainFinish",targetid:"gainFinish",type:"textarea"},
      			             {name:"ttechnologyGain.gainCondition",targetid:"gainCondition",type:"textarea"}];
  			var data = upms.transParsToObj(arrParams, $newPgDiv);
  			$newPgDiv.load(actionUrl, data, function() {
  				upms.hideOverLay();
  			});
		}
  		
  	});
	
	//返回
	function returnList(expertId){
		var actionUrl= path + "/api/expert/texpertInfoAction!technologyGainList.action?optType=0&expertId="+expertId+"&now="+new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		$newPgDiv.load(actionUrl, null, function() {
			upms.hideOverLay();
		});
	}