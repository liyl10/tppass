
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
	});
});

//新增附件
function insertIndex(){
	var actionUrl= path + "/api/contract/tcontracthighTech!showIndexInsert.action?now="+ new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [{name:"tcontractId",targetid:"tcontractId",type:"text"},
	                 {name:"Flag",targetid:"Flag",type:"text"},
	                 {name:"tableName",targetid:"tableName",type:"text"}];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

//下载附件
function downfile(attachmentId){
	var actionUrl= path + "/api/superadmin/tattachment!downLoadFile.action?now="+new Date().getTime()
			+ "&attachmentId=" + attachmentId;
	window.location.href=actionUrl;
}

//删除附件
function deleteFile(attachmentId){
	if(confirm($("#comfirmDelete").text())){
		var actionUrl= path + "/api/superadmin/tattachment!deleDataAndFile.action?now="+new Date().getTime()
						+ "&attachmentId=" + attachmentId;
		$("#retUrl").attr("value",path + "/server/contract/tcontract!showIndexList.action?&tcontractId="+$("#tcontractId").val()+"&Flag="+$("#Flag").val()+"&now=" + new Date().getTime());
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		var arrParams = [{name:"retUrl",targetid:"retUrl",type:"text"}];
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	}
}

//更新附件
function updateFile(attachmentId){
	var actionUrl= path + "/api/contract/tcontracthighTech!showIndexUpdate.action?now="+ new Date().getTime() + "&attachmentId=" + attachmentId;
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [{name:"tcontractId",targetid:"tcontractId",type:"text"},
	                 {name:"Flag",targetid:"Flag",type:"text"},
	                 {name:"tableName",targetid:"tableName",type:"text"}];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

//下一步
$("#nextBtn").bind("click", function() {
// 设置左侧菜单
	upms.upmsUtils.setMenu();
var actionUrl= path + "/api/contract/tcontracthighTech!getSubmitInfoList.action?&now=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [{name:"tcontractId",targetid:"tcontractId",type:"text"}];
	arrParams[arrParams.length] = {name:"Flag",targetid:"Flag",type:"text"};
	arrParams[arrParams.length] = {name:"contractStatus",targetid:"contractStatus",type:"text"};
	arrParams[arrParams.length] = {name:"modelType",targetid:"modelType",type:"text"};
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});


upms.grid.gridHover($(".t-list"));
upms.pagequery.initpaging({// 分页
	pgbtnid:"pgbtn",
	queryformid:"frmA",
	resultdivid:"resultDiv",
	url:path + "/api/contract/tcontracthighTech!showIndexList.action?tcontractId="
			+ $("#tcontractId").val()
			+ "&Flag=" + $("#Flag").val()
			+ "&contractStatus="+$("#contractStatus").val()
			+ "&modelType="+ $("#modelType").val()
			+ "&tableName=" + $("#tableName").val()
			+ "&now="+new Date().getTime()
});

