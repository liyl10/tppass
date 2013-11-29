
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
	});
});

//新增附件
function insertIndex(){
	var actionUrl= path + "/api/contract/tcontract!showIndexInsert.action?now="+ new Date().getTime();
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


//下一步
$("#nextBtn").bind("click", function() {
	// 设置左侧菜单
	upms.upmsUtils.setMenu();
	var actionUrl= path + "/api/contract/tappropriationSingle!init.action?&now=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");
	var arrParams = [{name:"tcontractId",targetid:"tcontractId",type:"text"}];
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
	url:path + "/api/contract/tcontract!showIndexList.action?tcontractId="
			+ $("#tcontractId").val()
			+ "&Flag=" + $("#Flag").val()
			+ "&contractStatus="+$("#contractStatus").val()
			+ "&modelType="+ $("#modelType").val()
			+ "&tableName=" + $("#tableName").val()
			+ "&now="+new Date().getTime()
});

