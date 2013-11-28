// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
	});
});


// 全选
function checkAll(){
	$("input[type='checkbox'][name='mapList']").each(function(){
		$(this).attr( 'checked',true);
	});
}
//全不选
function noCheckAll(){
	$("input[type='checkbox'][name='mapList']").each(function(){
		$(this).attr( 'checked',false);
    });
}

// 导出按钮
function exportDatas(){
	var data="";
	var mapList = "";
	var isChecked = false;
	$("input[name='mapList']").each(function(){
		if($(this).attr("checked")=="checked"){
			isChecked = true;
			mapList = mapList + "mapList=" + $(this).val() + "&";
		}
	});
	
	if(!isChecked){
		alert('请选择导出字段！');
		return;
	}
	data = data + "tprojectApplication.projectName=" + encodeURIComponent($("#projectName").val())+"&";
	data = data + "tprojectApplication.applicationUnit=" + encodeURIComponent($("#applicationUnit").val())+"&";
	data = data + "tprojectApplication.centralizedType=" + encodeURIComponent($("#centralizedType").val())+"&";
	data = data + "tprojectApplication.reportYear=" + encodeURIComponent($("#reportYear").val())+"&";
	data = data + "planningFlag=" + encodeURIComponent($("#planningFlag").val())+"&";
	if ($("#planningFlag").val() == '1'){
		data = data + "typeId1=" + encodeURIComponent($("#typeId1").val())+"&";
		data = data + "typeId2=" + encodeURIComponent($("#typeId2").val())+"&";
		data = data + "typeId3=" + encodeURIComponent($("#typeId3").val())+"&";
	}
	else{
		if ($("#projecTypeManager").val() == 'true'){
			data = data + "typeId2=" + encodeURIComponent($("#typeId2").val())+"&";
			data = data + "typeId3=" + encodeURIComponent($("#typeId3").val())+"&";
		}
	}
	data = data + "tprojectInfob.regionId1=" + encodeURIComponent($("#regionId1").val())+"&";
	data = data + "tprojectInfob.regionId2=" + encodeURIComponent($("#regionId2").val())+"&";
	data = data + "tprojectInfob.regionId3=" + encodeURIComponent($("#regionId3").val())+"&";
	data = data + "tprojectInfob.unitAddress=" + encodeURIComponent($("#unitAddress").val())+"&";
	data = data + "tprojectInfob.industries1=" + encodeURIComponent($("#industries1").val())+"&";
	data = data + "tprojectInfob.industries2=" + encodeURIComponent($("#industries2").val())+"&";
	data = data + "tprojectInfob.industries3=" + encodeURIComponent($("#industries3").val())+"&";
	data = data + "tprojectInfob.industries4=" + encodeURIComponent($("#industries4").val())+"&";
	data = data + "tprojectInfob.unitProperties=" + encodeURIComponent($("#unitProperties").val())+"&";
	data = data + "tprojectInfob.assistUnit=" + encodeURIComponent($("#assistUnit").val())+"&";
	data = data + "tprojectInfob.technicalFisld1=" + encodeURIComponent($("#technicalFisld1").val())+"&";
	data = data + "tprojectInfob.technicalFisld2=" + encodeURIComponent($("#technicalFisld2").val())+"&";
	data = data + "tprojectInfob.technicalFisld3=" + encodeURIComponent($("#technicalFisld3").val())+"&";
	data = data + "tprojectInfob.intellectualProperty=" + encodeURIComponent($("#intellectualProperty").val())+"&";
	data = data + "tprojectInfob.technologySource=" + encodeURIComponent($("#technologySource").val())+"&";
//	
//	upms.showOverLay();// 打开遮罩
//	var actionUrlSetData = path + "/api/statistics/statisticsProject!setMapList.action"+ "?now=" + new Date().getTime();
//	$.post(actionUrlSetData, mapList, function(){
//		var actionUrl = path + "/api/statistics/statisticsProject!exportDatas.action"+ "?now=" + new Date().getTime();
//		window.location.href= actionUrl + "&" + (data);
//		upms.hideOverLay();
//	});
	
	upms.showOverLay();// 打开遮罩
	//var actionUrl=path + "/api/industry/industryAction!exportData.action?"+ data + "columnName=" + columnName +"&now=" + new Date().getTime();
	$("#exportForm").get(0).action = path + "/api/statistics/statisticsProject!exportDatas.action?"+ data  +"now=" + new Date().getTime();
	$("#exportForm").get(0).submit();
	upms.showOverLay();// 打开遮罩
	//window.location.href= actionUrl;
	setTimeout(function(){upms.hideOverLay();},3000);
}
