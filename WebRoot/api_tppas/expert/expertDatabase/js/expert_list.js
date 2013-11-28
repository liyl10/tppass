	// 项目根目录
	var path="";
	
	$(function() {
		$(document).ready(function() {
			path = $("#path").text();
		});
	});
	
	//分页
	upms.grid.gridHover($(".t-list"));
	upms.pagequery.initpaging({// 分页
		pgbtnid:"pgbtn",
		queryformid:"searchForm",
		resultdivid:"resultDiv",
		url:path + "/api/expert/texpertAction!list.action?now=" + new Date().getTime()
	});
	
	// 全选
	function selectAll(){
		if($("#selectAll").attr("checked")=="checked"){
			$("input[type='checkbox']").attr("checked",true);
		}
		else{
			$("input[type='checkbox']").removeAttr("checked");
		}
	}
	
	//新增专家
	function saveExpert(){
	    var arrParams={};
		var actionUrl= path + "/api/expert/texpertAction!forwardInsert.action?"+"now="+new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#mainContent");
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	}
	//编辑专家信息
	function editExpert(expertId,isEdit){
		var actionUrl= path + "/api/expert/texpertAction!forwardInsert.action?expertId="+expertId+"&isEdit="+isEdit+"&now="+new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#mainContent");
		$newPgDiv.load(actionUrl, null, function() {
			upms.hideOverLay();
		});
	}
	
	//查看专家信息
	function showExpert(expertId,isEdit){
		var actionUrl= path + "/api/expert/texpertAction!forwardInsert.action?expertId="+expertId+"&isEdit="+isEdit+"&now="+new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#mainContent");
		$newPgDiv.load(actionUrl, null, function() {
			upms.hideOverLay();
		});
	}
	
	//删除专家信息
	function delExpert(expertId){
		var comfirmInfo = $("#comfirmDel").text();
		if (confirm(comfirmInfo)){
			var actionUrl= path + "/api/expert/texpertAction!deleteExpert.action?expertId="+expertId+"&now="+new Date().getTime();
			upms.showOverLay();// 打开遮罩
			var $newPgDiv = $("#mainContent");
			$newPgDiv.load(actionUrl, null, function() {
				upms.hideOverLay();
			});
		}
	}