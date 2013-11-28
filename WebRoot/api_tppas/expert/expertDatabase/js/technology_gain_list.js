	// 项目根目录
	var path="";
	
	$(function() {
		$(document).ready(function() {
			path = $("#path").text();
		});
	});
	
	// 分页
	upms.grid.gridHover($(".t-list"));
	upms.pagequery.initpaging({
		pgbtnid:"pgbtn",
		queryformid:"searchForm",
		resultdivid:"resultDiv",
		url:path + "/api/expert/ttechnologyGainAction!list.action?expertId="+$("#expertId").val()+"&now=" + new Date().getTime()
	});
	
	//添加专家专业技术研究成果
	function insertTechnology(expertId){
		var actionUrl= path + "/api/expert/ttechnologyGainAction!insertInit.action?expertId="+expertId+"&now="+new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		$newPgDiv.load(actionUrl, null, function() {
			upms.hideOverLay();
		});
	}
	
	//修改专家专业技术研究成果
	function editTechnology(gainId,isEdit){
		var actionUrl= path + "/api/expert/ttechnologyGainAction!modifyInit.action?gainId="+gainId+"&isEdit="+isEdit+"&now="+new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		$newPgDiv.load(actionUrl, null, function() {
			upms.hideOverLay();
		});
	}
	
	//查看专家专业技术研究成果
	function showTechnology(gainId,isEdit){
		var actionUrl= path + "/api/expert/ttechnologyGainAction!showInit.action?gainId="+gainId+"&isEdit="+isEdit+"&now="+new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		$newPgDiv.load(actionUrl, null, function() {
			upms.hideOverLay();
		});
	}
	
	//删除专家专业技术研究成果
	function delTechnology(gainId,expertId){
		var comfirmInfo = $("#comfirmDel").text();
		if (confirm(comfirmInfo)){
			var actionUrl= path + "/api/expert/ttechnologyGainAction!deleteTtechnologyGain.action?expertId="+expertId+"&gainId="+gainId+"&now="+new Date().getTime();
			upms.showOverLay();// 打开遮罩
			var $newPgDiv = $("#content");
			$newPgDiv.load(actionUrl, null, function() {
				upms.hideOverLay();
			});
		}
	}
