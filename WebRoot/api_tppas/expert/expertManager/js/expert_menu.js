	// 项目根目录
	var path="";
	
	$(function() {
	    $(document).ready(function () {
	    	path = $("#path").text();
			
			$(".subNav >a:first").css('background',"#e2f3fb url("+ path +"/api_tppas/images/bg_sub_list.gif) no-repeat 10px center");
			$(".subNav >a:first").css('color',"#10465f");
			
			var value = $(window).height() - 5;

			$(".leftNav").css("height", value);
			$(".rightWrap").css("height", value);
			$("#content").css("height", value);

 			$(".subNav >a").each(function(ind, elem) {
				var aqObj = $(elem);
				aqObj.parent("dd").bind("click", function() {
					$(".subNav >a").css('background',"#87baf0 url("+ path +"/api_tppas/images/bg_sub_list.gif) no-repeat 10px center");
					$(this).find("a").css('background',"#e2f3fb url("+ path +"/api_tppas/images/bg_sub_list.gif) no-repeat 10px center");
					
					$(".subNav >a").css('color',"#fff");
					$(this).find("a").css('color',"#10465f");
					
				});
			});
 			$("#content").load(path + "/api/expert/texpertInfoAction!getExpertInfo.action?expertId="+$('#expertId').val()+"&now="+new Date().getTime());
		});
	});


	//基本信息
	function showInfo(expertId){
		var actionUrl= path + "/api/expert/texpertInfoAction!getExpertInfo.action?expertId="+expertId+"&now="+new Date().getTime();
		rect(actionUrl);
	}
	
	//技术研究成果
	function showJsyjcg(expertId){
		var actionUrl= path + "/api/expert/texpertInfoAction!technologyGainList.action?expertId="+expertId+"&now="+new Date().getTime();
		rect(actionUrl);
	 }
	
	function rect(actionUrl) {
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		var data = {};
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	}