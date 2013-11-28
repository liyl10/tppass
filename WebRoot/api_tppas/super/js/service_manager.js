
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
	});
});

function typeshow1(){
	upms.showOverLay();// 打开遮罩
	 var actionUrl= ""+ path +"/api/superadmin/mtype!initTypeSetting.action?now="+ new Date().getTime()+"&subPage=subNav1";
	 $("#content").load(actionUrl);
	 upms.hideOverLay();
}

function typeshow2(){
	var actionUrl= ""+ path +"/api/superadmin/mtype!initOtherSetting.action?now="+ new Date().getTime()+"&subPage=subNav2";;
	 $("#content").load(actionUrl);
}

function typeshow3(){
	upms.showOverLay();// 打开遮罩
	var actionUrl= ""+ path +"/api/superadmin/mitem!initContractSetting.action?now="+ new Date().getTime()+"&subPage=subNav3";;
	 $("#content").load(actionUrl);
	 upms.hideOverLay();
}
