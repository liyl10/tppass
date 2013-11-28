	// 项目根目录
	var path="";
	
	$(function() {
		$(document).ready(function() {
			path = $("#path").text();
			
			$("input[type='text']").each(function(){
				$(this).attr("disabled",true);
			});
			$("textarea").each(function(){
				$(this).attr("readonly",true);
				$(this).css('background-color','#F0F0F0');
			});
		});
	});
	
	//返回
	function returnList(expertId){
		var actionUrl= path + "/api/expert/ttechnologyGainAction!list.action?isEdit="+$("#isUpdate").val()+"&expertId="+expertId+"&now="+new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		$newPgDiv.load(actionUrl, null, function() {
			upms.hideOverLay();
		});
	}