
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
	url:path + "/api/contract/tcontract!queryList.action?&now="+new Date().getTime()
});
	

function showDetail(tcontractId,url){
	var actionUrl=path + url + "?tcontractId="+ tcontractId +"&now="+ new Date().getTime();
	upms.showOverLay();// 打开遮罩
	upms.clearWebObj();
	var $newPgDiv = upms.createPageDiv();//$("#mainContent");
	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();});
}	

function showBkd(tcontractId){
	var actionUrl=path + "/api/contract/tappropriationSingle!init.action?tcontractId="+ tcontractId 
					   + "&mainFlag=" + "1" 
						+"&now="+ new Date().getTime();
	upms.showOverLay();// 打开遮罩
	upms.clearWebObj();
	var $newPgDiv = upms.createPageDiv();//$("#mainContent");
	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();});
}	

function typeBg(tcontractId){
	if(confirm($("#comfirmType").text())){
		if (confirm($("#comfirmChoose").text())){
			var actionUrl=path + "/api/contract/tcontract!typeChange.action?tcontractId="+ tcontractId + "&contractType=0" + "&now="+new Date().getTime();
			upms.showOverLay();// 打开遮罩
			upms.clearWebObj();
			var $newPgDiv = upms.createPageDiv();//$("#mainContent");
			var data = {};
			$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();});
		}
		else{
			var actionUrl=path + "/api/contract/tcontract!typeChange.action?tcontractId="+ tcontractId + "&contractType=1" + "&now="+new Date().getTime();
			upms.showOverLay();// 打开遮罩
			upms.clearWebObj();
			var $newPgDiv = upms.createPageDiv();//$("#mainContent");
			var data = {};
			$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();});
		}
	}

}

function issuedContract(tcontractId,type){
	if (confirm($("#comfirmSave").text())){
		if (type=='0'){
			var actionUrl=path + "/api/contract/tcontract!issuedContract.action?tcontractId="+ tcontractId 
								+"&now="+ new Date().getTime();
			upms.showOverLay();// 打开遮罩
			upms.clearWebObj();
			var $newPgDiv = upms.createPageDiv();//$("#mainContent");
			var data = {};
			$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();});
		}
		else{
			if (confirm($("#comfirmChoose").text())){
				var actionUrl=path + "/api/contract/tcontract!issuedContract.action?tcontractId="+ tcontractId 
									+"&contractType=0" 
									+"&now="+ new Date().getTime();
				upms.showOverLay();// 打开遮罩
				upms.clearWebObj();
				var $newPgDiv = upms.createPageDiv();//$("#mainContent");
				var data = {};
				$newPgDiv.load(actionUrl, data, function() {
					upms.hideOverLay();});
			}
			else{
				var actionUrl=path + "/api/contract/tcontract!issuedContract.action?tcontractId="+ tcontractId 
									+"&contractType=1" 
									+"&now="+ new Date().getTime();
				upms.showOverLay();// 打开遮罩
				upms.clearWebObj();
				var $newPgDiv = upms.createPageDiv();//$("#mainContent");
				var data = {};
				$newPgDiv.load(actionUrl, data, function() {
				upms.hideOverLay();});
			}
		}
	}
}	

