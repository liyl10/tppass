// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
	});
});


// 全选
function checkAll(){
	$("input[type='checkbox'][temp='checkFlag']").each(function(){
		$(this).attr('checked',true);
	});
}
//全不选
function noCheckAll(){
	$("input[type='checkbox'][temp='checkFlag']").each(function(){
		$(this).attr('checked',false);
    });
}

// 导出按钮
function exportDatas(){
	var data="";
	var columnName = "";
	var isChecked = false;
	$("input[name='columnName1']").each(function(){
		if($(this).attr("checked")=="checked"){
			isChecked = true;
			this.value = this.id;
		}
	});
	
	if(!isChecked){
		alert('请选择导出字段！');
		return;
	}
	
	data = data + "projectName=" + encodeURIComponent($("#projectName").val())+"&";
	data = data + "applicationUnit=" + encodeURIComponent($("#applicationUnit").val())+"&";
	data = data + "centralizedType=" + $("#centralizedType").val()+"&";
	data = data + "reportYear=" + $("#reportYear").val()+"&";
	//data = data + "planningFlag=" + encodeURIComponent($("#planningFlag").val())+"&";
	data = data + "typeId2=" + $("#typeId2").val()+"&";
	data = data + "typeId3=" + $("#typeId3").val()+"&";
	
	data = data + "regionId1=" + $("#regionId1").val()+"&";
	data = data + "regionId2=" + $("#regionId2").val()+"&";
	data = data + "regionId3=" + $("#regionId3").val()+"&";
	data = data + "unitAddress=" + encodeURIComponent($("#unitAddress").val())+"&";
	data = data + "industries1=" + $("#industries1").val()+"&";
	data = data + "industries2=" + $("#industries2").val()+"&";
	data = data + "industries3=" + $("#industries3").val()+"&";
	data = data + "industries4=" + $("#industries4").val()+"&";
	data = data + "unitProperties=" + $("#unitProperties").val()+"&";
	data = data + "assistUnit=" + encodeURIComponent($("#assistUnit").val())+"&";
	data = data + "technicalFisld1=" + $("#technicalFisld1").val()+"&";
	data = data + "technicalFisld2=" + $("#technicalFisld2").val()+"&";
	data = data + "technicalFisld3=" + $("#technicalFisld3").val()+"&";
	data = data + "intellectualProperty=" + $("#intellectualProperty").val()+"&";
	data = data + "technologySource=" + $("#technologySource").val()+"&";
	
	upms.showOverLay();// 打开遮罩
	//var actionUrl=path + "/api/industry/industryAction!exportData.action?"+ data + "columnName=" + columnName +"&now=" + new Date().getTime();
	$("#exportForm").get(0).action = path + "/api/industry/industryAction!exportData.action?"+ data + "columnName=" + columnName +"&now=" + new Date().getTime();
	$("#exportForm").get(0).submit();
	upms.showOverLay();// 打开遮罩
	//window.location.href= actionUrl;
	setTimeout(function(){upms.hideOverLay();},3000);
	/*var actionUrlSetData = path + "/api/statistics/statisticsProject!setMapList.action"+ "?now=" + new Date().getTime();
	$.post(actionUrlSetData, mapList, function(){
		var actionUrl = path + "/api/statistics/statisticsProject!exportDatas.action"+ "?now=" + new Date().getTime();
		window.location.href= actionUrl + "&" + (data);
		upms.hideOverLay();
	});*/

}

function printData(){
	
}
