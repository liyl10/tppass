
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
	});
});

//分页信息
upms.grid.gridHover($(".t-list"));
upms.pagequery.initpaging({// 分页
	pgbtnid:"pgbtn",
	queryformid:"frmA",
	resultdivid:"resultDiv",
	url:path + "/server/contract/tcontract!execute.action?&now="+new Date().getTime()
});

//详细信息
function showDetail(modelType,tcontractId,contractStatus){
	var actionUrl=path + "/server/contract/tcontracthighTech!importTcontract.action?modelType="+modelType+"&tcontractId=" + tcontractId+ "&contractStatus=" + contractStatus;
	load(actionUrl);
}

function load(obj){
	upms.showOverLay();// 打开遮罩
	upms.clearWebObj();
	var $newPgDiv = upms.createPageDiv();//$("#mainContent");
	var data = {};
	$newPgDiv.load(obj+"&now="+new Date().getTime(), data, function() {
		upms.hideOverLay();});
}

//打印PDF
function printPDF(pdfUrl){
	var actionUrl= path + "/server/super/tattachment!downLoadPdf.action?now="+new Date().getTime()
					+ "&pdfPath=" + pdfUrl + "&pdfNameType=2";
	window.location.href=actionUrl;
}