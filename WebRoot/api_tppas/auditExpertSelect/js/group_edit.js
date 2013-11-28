// 项目根目录
var path="";

$(document).ready(function(){
	path = $("#path").text();

});

//分页初始化
upms.grid.gridHover($(".t-list"));
upms.pagequery.initpaging({// 分页
	pgbtnid:"pgbtn",
	queryformid:"searchForm",
	resultdivid:"mainContent",
	url:path + "/api/audit/projectApplication!editGroup.action?now="
		+ new Date().getTime()
});

//全选
function selectAll(){
	if($("#selectAll").attr("checked")=="checked"){
		$("input[type='checkbox']").attr("checked",true);
		$("#selectedId").attr("value","");
		$("input[type='checkbox']").each(
			function(){
				if(this.value != "true"){
					$("#selectedId").attr("value",$("#selectedId").val() + this.value + ",");
				}
			}
		);
		//alert($("#selectedId").val());
	}
	else{
		$("input[type='checkbox']").removeAttr("checked");
		$("#selectedId").attr("value","");
		//alert($("#selectedId").val());
	}
}

/**
 * 选择或取消选择checkbox
 * @param now
 */
function saveOrDelSelect(now){
	if($(now).attr("checked")=="checked"){
		$("#selectedId").attr("value",$("#selectedId").val() + now.value + ",");
	}
	else{
		$("#selectedId").attr("value",$("#selectedId").val().replace(now.value + ",",""));
	}
	//alert($("#selectedId").val());
}
//返回按钮
$("#backBtn").bind("click", function(){

	var actionUrl = path + "/api/audit/projectApplication!showAuditExpertManage.action?now=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");

	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});

// 批量将项目从分组中删除
function deleteGroupSelect(){
	var projectListStr = $("#selectedId").val();
	//alert(projectListStr + ":" + projectListStr.split(",").length);
	
	var groupId = $("#groupId").val();
	if(projectListStr.length < 1){
		alert("没有选中的项目，请先选择项目");
		return false;
	}
	if(!confirm("从分组中删除项目会同时删除该项目已有的数据，\n比如：项目评分、专家意见、立项建议、局办公会意见等，\n确定要从分组中删除该项目吗？")){
		return false;
	}
	var groupDeleteFlag = false;
	if(projectListStr.split(",").length-1 == $("#totalCount").val()){
		if(!confirm("删除分组下面所有的项目会同时删除该分组，确定要全部删除？")){
			return false;
		}else{
			groupDeleteFlag = true;
		}
	}
	
	var actionUrl= path + "/api/audit/projectApplication!deleteProjectListFromGroup.action?groupId="
		+ groupId
		+ "&selectedProjectIds="
		+ projectListStr
		+ "&groupDeleteFlag="
		+ groupDeleteFlag
		+ "&now="
		+ new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");

	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

// 选择项目按钮按下的处理
function selectProject(){
	var actionUrl=path + "/api/audit/projectApplication!showGroupSelectProjectManage.action?pageDirectFlag=" 
		+"edit" 
		+ "&groupId="
		+ $("#groupId").val()
		+ "&groupName="
		+ encodeURIComponent($("#groupName").val())
		+ "&date=" 
		+ new Date().getTime();

	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	$newPgDiv.load(actionUrl, null, function() {
		upms.hideOverLay();
	});
}

//删除单个项目
function deleteFromGroup(projectId,groupId){
	if(!confirm("从分组中删除项目会同时删除该项目已有的数据，\n比如：项目评分、专家意见、立项建议、局办公会意见等，\n确定要从分组中删除该项目吗？")){
		return false;
	}
	
	var groupDeleteFlag = false;
	if($("#totalCount").val()=="1"){
		if(!confirm("这是该分组的最后一个项目，如果删除后，该分组也将被删除，确定要删除吗？")){
			return false;
		}else{
			groupDeleteFlag = true;
		}
	}
	
	var actionUrl= path + "/api/audit/projectApplication!deleteProjectFromGroup.action?groupId="
	+ groupId
	+ "&projectId="
	+ projectId
	+ "&groupDeleteFlag="
	+ groupDeleteFlag
	+ "&now="
	+ new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");

	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}
/**
 * 保存、更新项目分组
 */
function saveGroup(){
	var result = upms.upmsUtils.inputCheck();
	if(result){
		return;
	}
	
	var actionUrl=path + "/api/audit/projectApplication!saveOrUpdateGroup.action?date=" + new Date().getTime();
	var params = [{name:"groupName",targetid:"groupName",type:"text"},
				  {name:"projectType1",targetid:"projectType1",type:"text"},
				  {name:"projectType2",targetid:"projectType2",type:"text"},
	              {name:"groupId",targetid:"groupId",type:"text"}];
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var data = upms.transParsToObj(params, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}