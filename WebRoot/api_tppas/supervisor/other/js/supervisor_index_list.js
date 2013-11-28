	// 工程根目录
	var path="";
	
	$(function() {
		$(document).ready(function() {
			path=$("#path").text();
		});
	});
	
	// 分页信息
	upms.grid.gridHover($(".t-list"));
	upms.pagequery.initpaging({// 分页
		pgbtnid:"pgbtn",
		queryformid:"frmA",
		resultdivid:"resultDiv",
		url:path + "/server/supervisor/supervisorOtherAction!showIndexList.action?supervisorId="
				+ $("#supervisorId").val()+ "&tableName=" + $("#tableName").val()+"&now="+new Date().getTime()
	});
	
	// 新增
	function insertIndex(){
		var actionUrl= path + "/api/supervisor/supervisorOtherAction!showIndexInsert.action?isEdit="+$("isEdit").val()+"&now="+ new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		var arrParams = [{name:"supervisorId",targetid:"supervisorId",type:"text"},
		                 {name:"tableName",targetid:"tableName",type:"text"}];
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	}
	
	// 下载附件
	function downfile(attachmentId){
		var actionUrl= path + "/api/superadmin/tattachment!downLoadFile.action?now="+new Date().getTime()
				+ "&attachmentId=" + attachmentId;
		window.location.href=actionUrl;
	}
	
	// 删除附件
	function deleteFile(attachmentId){
		
		if(confirm($("#comfirmDelete").text())){
			var actionUrl= path + "/api/superadmin/tattachment!deleDataAndFile.action?now="+new Date().getTime()
							+ "&attachmentId=" + attachmentId;
			$("#retUrl").attr("value",path + "/server/supervisor/supervisorOtherAction!showIndexList.action?supervisorId="+$("#supervisorId").val()
										+"&isEdit="+$("#isEdit").val()+"&now=" + new Date().getTime());
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
		var actionUrl= path + "/api/supervisor/supervisorOtherAction!showIndexUpdate.action?now="+ new Date().getTime() + "&attachmentId=" + attachmentId+"&isEdit="+$("isEdit").val();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		var arrParams = [{name:"supervisorId",targetid:"supervisorId",type:"text"},
		                 {name:"tableName",targetid:"tableName",type:"text"}];
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	}
	
	// 下一步按钮功能
	$("#nextBtn").bind("click", function() {
		// 设置左边菜单样式
		upms.upmsUtils.setMenu();
		var actionUrl;
		actionUrl= path + "/api/supervisor/supervisorOtherAction!getOtherSubmitInfoList.action?now="+ new Date().getTime();
		
			upms.showOverLay();// 打开遮罩
			var $newPgDiv = $("#content");
			var arrParams = [{name:"supervisorId",targetid:"supervisorId",type:"text"},
			                 			{name:"isEdit",targetid:"isEdit",type:"text"}];
			
			var data = upms.transParsToObj(arrParams, $newPgDiv);
			$newPgDiv.load(actionUrl, data, function() {
				upms.hideOverLay();
			});
	});