// 项目根目录
var path="";

$(document).ready(function(){
	path = $("#path").text();
	
	// 计划批次
	upms.upmsUtils.initSelect("planBatch", $("planBatchValue").val(), 1, 1, 1);
	
	upms.showOverLay();// 打开遮罩
 	var actionUrl= "";
 	if($("#planApplyStatus").val() == 0){
 		actionUrl = path + "/api/planManage/planManageAction!getPlanUpdateList1.action?planId=" + $("#planId").val() + "&date=" + new Date().getTime();
 	}
 	else{
 		actionUrl = path + "/api/planManage/planManageAction!getPlanUpdateList.action?planId=" + $("#planId").val() + "&date=" + new Date().getTime();
 	}
	var $newPgDiv = $("#resultDiv");
	$newPgDiv.load(actionUrl, null, function() {
		upms.hideOverLay();
	});
});


/**
 * 继续添加专家
 * @param projectId
 */
function selectProject(){
	var actionUrl= path + "/api/planManage/planManageAction!showSelectProjectManage.action?planId="+ $("#planId").val() +"&now="+new Date().getTime();
	art.dialog.open(
		actionUrl,
		{
			title: '项目选择',
			width: '1000px',
			height: '664px',
			left: '40%',
			top: '35%',
			lock:true,
			padding: 0,
			okVal: '保存',
			ok: function(){
				var iframe = this.iframe.contentWindow;
				var selectedProjectIds = iframe.document.getElementById("selectedId");

				$.ajax({
			       url: path + "/api/planManage/planManageAction!saveSelectProject.action?planId="+$("#planId").val() +
							"&selectedProjectIds="+ selectedProjectIds.value +"&date=" + new Date().getTime(),
			       type:'post',
			       dataType:'json',
			       data:{},
			       success:refreshQuery
				 });
			},
			cancelVal: '关闭',
			cancel: true
		}
	 );
}

/**
 * 刷新已选择的专家列表页面
 */
function refreshQuery(){
	
	var actionUrl=path + "/api/planManage/planManageAction!getPlanUpdateList.action?planId=" + $("#planId").val() +
					"&date=" + new Date().getTime();
	
	upms.showOverLay();// 打开遮罩
	//alert(actionUrl);
	var $newPgDiv = $("#resultDiv");
	$newPgDiv.load(actionUrl, null, function() {
		upms.hideOverLay();
		return true;
	});
}

/**
 * 提交分计划
 */
function savePlan(){
	var result = upms.upmsUtils.inputCheck();
	var idList = new Array("planBatch");
	var result2 = upms.upmsUtils.selectCheck(idList);
	if(result || result2){
		return;
	}
	if(confirm($("#comfirmSave").text())){
		var actionUrl= path + "/api/planManage/planManageAction!submitPlan.action?now="+new Date().getTime();
		//alert(actionUrl);
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#mainContent");
		var arrParams = [{name:"tplan.planBatch",targetid:"planBatch",type:"text"}];
		
		for(var i=1; i< $("#proAppListCount").val(); i++){
			nameTemp = "proAppList["+i+"].expertProofResearch";
			arrParams[arrParams.length] = {name:nameTemp,targetname:nameTemp,type:"radio"};
		}
		
		arrParams = upms.upmsUtils.setSubmitDatas(arrParams, 1, 0);
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	}
}

/**
 * 提交分计划
 */
function backPlan(){
	var actionUrl= path + "/api/planManage/planManageAction!showPlanManage.action?&now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

