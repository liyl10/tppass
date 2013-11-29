
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
	url:path + "/api/contract/tappropriationSingle!init.action?&now="+new Date().getTime() 
			 + "&tcontractId=" + $("#tcontractId").val()
			 + "&mainFlag=" + $("#mainFlag").val()
});
	
//打印PDF
function printPDF(pdfUrl){
	var actionUrl= path + "/api/superadmin/tattachment!downLoadPdf.action?now="+new Date().getTime()
					+ "&pdfPath=" + pdfUrl + "&pdfNameType=2";
	window.location.href=actionUrl;
}

//新增拨款单
function insert(){
	var actionUrl= path + "/api/contract/tappropriationSingle!insert.action?now="+ new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	if ($("#mainFlag").val() == '1'){
		$newPgDiv = $("#mainContent");
	}
	var arrParams = [{name:"tcontractId",targetid:"tcontractId",type:"text"},
	                 {name:"mainFlag",targetid:"mainFlag",type:"text"}];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

//修改拨款单
function showUpdate(appropriationSingleId){
	var actionUrl= path + "/api/contract/tappropriationSingle!update.action?now="+ new Date().getTime()
						+ "&appropriationSingleId=" + appropriationSingleId;
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	if ($("#mainFlag").val() == '1'){
		$newPgDiv = $("#mainContent");
	}
	var arrParams = [{name:"tcontractId",targetid:"tcontractId",type:"text"},
	                 {name:"mainFlag",targetid:"mainFlag",type:"text"}];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

//删除拨款单
function showDelete(appropriationSingleId){
	if (confirm($("#comfirmDelete").text())){
		var actionUrl= path + "/api/contract/tappropriationSingle!deletetappropriationSingle.action?now="+ new Date().getTime()
							+ "&appropriationSingleId=" + appropriationSingleId;
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		if ($("#mainFlag").val() == '1'){
			$newPgDiv = $("#mainContent");
		}
		var arrParams = [{name:"tcontractId",targetid:"tcontractId",type:"text"},
		                 {name:"mainFlag",targetid:"mainFlag",type:"text"}];
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	}
}

$("#nextBtn").bind("click", function() {
	// 设置左侧菜单
 	upms.upmsUtils.setMenu();
 	if ($("#highOrOtherFlag").val() == '0'){
 		var actionUrl= path + "/api/contract/tcontract!importSubmit.action?now="+ new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		var arrParams = [{name:"tcontractId",targetid:"tcontractId",type:"text"}];
		arrParams[arrParams.length] = {name:"mainFlag",targetid:"mainFlag",type:"text"};
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
 	}
 	else{
 		var actionUrl= path + "/api/contract/tcontracthighTech!importSubmit.action?now="+ new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		var arrParams = [{name:"tcontractId",targetid:"tcontractId",type:"text"}];
		arrParams[arrParams.length] = {name:"mainFlag",targetid:"mainFlag",type:"text"};
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
 	}

	});
