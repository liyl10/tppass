// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
		 
		if("<s:property value='%{allBtn}' escape='true'/>"=="true"){
			$("#allBtn").attr("disabled",false);
		} else {
			$("#allBtn").attr("disabled",true);
		}
	});
});

upms.grid.gridHover($(".t-list"));
upms.pagequery.initpaging({// 分页
	pgbtnid:"pgbtn",
	queryformid:"searchForm",
	resultdivid:"resultDiv",
	url:path + "/api/reportingunit/TreportingUnitAction!list.action?now="+new Date().getTime()
});

//打开设置信誉度画面
function showCreidtDetai1(unitID){
	var actionUrl=path + "/api/reportingunit/TreportingUnitAction!creditInit.action";
	var arrParams = "&unitID=" + unitID;
	upms.showOverLay();// 打开遮罩
	upms.clearWebObj();
	var $newPgDiv = upms.createPageDiv();//$("#mainContent");
	$newPgDiv.load(actionUrl+"?now="+ new Date().getTime()+arrParams, null, function() {
		upms.hideOverLay();});
}

//打开单位编辑画面
function showUnitDetai1(unitID){
	var actionUrl=path + "/api/reportingunit/TreportingUnitAction!unitupdateInit.action";
	var arrParams = "&unitID=" + unitID;
	upms.showOverLay();// 打开遮罩
	upms.clearWebObj();
	var $newPgDiv = upms.createPageDiv();//$("#mainContent");
	$newPgDiv.load(actionUrl+"?now="+ new Date().getTime()+arrParams, null, function() {
		upms.hideOverLay();});
}	
	
//打印PDF
function printPDF(pdfUrl){
	var actionUrl= path + "/api/superadmin/tattachment!downLoadPdf.action?now="+new Date().getTime()
					+ "&pdfPath=" + pdfUrl + "&pdfNameType=2";
	window.location.href=actionUrl;
}