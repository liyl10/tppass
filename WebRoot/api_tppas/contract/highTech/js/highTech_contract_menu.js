
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
			$(".subNav >a:first").css('background',"#e2f3fb url("+ path +"/api_tppas/images/bg_sub_list.gif) no-repeat 10px center");
			$(".subNav >a:first").css('color',"#10465f");
			
			var value = $(window).height() - 175;

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
		$("#content").load( path + "/api/contract/tcontractCoverhighTech!importCover.action?&tcontractId="+ $("#tcontractId").val()+ "&Flag="+ $("#Flag").val()+"&now=" + new Date().getTime());
	});
});

function showDetail(Flag, tcontractId , url){
	var actionUrl= path + url +"tcontractId="+ tcontractId+ "&Flag="+ Flag +"&now=" + new Date().getTime();
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