
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
		 upms.upmsUtils.initSelect("typeId1", $("#hiddendepartmentId1").val(),1,2,3);
		 upms.upmsUtils.initSelect("typeId2", $("#hiddenparentTypeId1").val(),1,2,4);
		 upms.upmsUtils.initSelect("isShow", $("#hiddenisShow1").val(),1,1,1);

		 upms.upmsUtils.initSelect("isWrite", $("#hiddenisWrite1").val(),1,1,1);
		 upms.upmsUtils.initSelect("timeArea", $("#hiddentimeArea1").val(),1,1,1);

		 upms.upmsUtils.initSelect("reportTemplateId", $("#hiddenreportTemplateId1").val(),1,1,0);
		 upms.upmsUtils.initSelect("contractTemplateId", $("#hiddencontractTemplateId1").val(),1,1,0);
		 upms.upmsUtils.initSelect("supervisionTemplateId", $("#hiddensupervisionTemplateId1").val(),1,1,0);
		 upms.upmsUtils.initSelect("acceptanceTemplateId", $("#hiddenacceptanceTemplateId1").val(),1,1,0);
		 initSelect2();
	});
});

$("#typeId2").chosen().change(function(){
	// 选择【请选择】时显示提示信息
	initSelect2();
});

$("#btnSave").bind("click", function() {
	if($("#typeId2").val() ==""){
		if (upms.upmsUtils.selectCheck(new Array("typeId1","isShow"))) {
			return false;
		}
	 }
	else{
		if (upms.upmsUtils.selectCheck(new Array("typeId1","isShow","isWrite","timeArea"))) {
			return false;
		}
	}
	var actionUrl=path +"/api/superadmin/typeModel!modify.action";
	var val = confirm($("#comfirmSave").text());
	 if (!val) {
	    return; 
	 }
	upms.showOverLay();// 打开遮罩

	var $newPgDiv = $("#mainContent");

	var arrParams = [{
		name : "typeId",
		targetid : "typeId",
		type : "text"
	}, {
		name : "tprojectType.typeRealName",
		targetid : "typeRealName",
		type : "text"
	}, {
		name : "tprojectType.typeShowName",
		targetid : "typeShowName",
		type : "text"
	}, {
		name : "tprojectType.departmentId",
		targetid : "typeId1",
		type : "select"
	}, {
		name : "tprojectType.parentTypeId",
		targetid : "typeId2",
		type : "select"
	}, {
		name : "tprojectType.isShow",
		targetid : "isShow",
		type : "select"
	}, {
		name : "tprojectType.tprojectReportTemplate.reportTemplateId",
		targetid : "reportTemplateId",
		type : "select"
			
	}, {
		name : "tprojectType.tprojectContractTemplate.contractTemplateId",
		targetid : "contractTemplateId",
		type : "select"
	}, {
		name : "tprojectType.tprojectSupervisionTemplate.supervisionTemplateId",
		targetid : "supervisionTemplateId",
		type : "select"
	}, {
		name : "tprojectType.tprojectSupervisionTemplate.supervisionTemplateId",
		targetid : "supervisionTemplateId",
		type : "select"
	}, {
		name : "tprojectType.tprojectAcceptanceTemplate.acceptanceTemplateId",
		targetid : "acceptanceTemplateId",
		type : "select"
	}, {
		name : "tprojectType.isWrite",
		targetid : "isWrite",
		type : "select"
	}, {
		name : "tprojectType.remark",
		targetid : "remark",
		type : "text"
	}, {
		name : "tprojectType.timeArea",
		targetid : "timeArea",
		type : "select"
	}];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});

//返回
$("#reBtn").bind("click", function() {
var actionUrl= path +"/api/superadmin/typeModel!init.action";
var $newPgDiv = $("#mainContent");
var arrParams =[{}];
var data = upms.transParsToObj(arrParams, $newPgDiv);
$newPgDiv.load(actionUrl, data, function() {
	upms.hideOverLay();
});
					});

function initSelect2() {
	if($("#typeId2").val() =="" || $("#typeId2").val() == null){
		$("#reportTemplateId").attr("value",'');
		$("#reportTemplateId").trigger("liszt:updated");
		$("#reportTemplateDiv").hide();
		$("#contractTemplateId").attr("value",'');
		$("#contractTemplateId").trigger("liszt:updated");
		$("#contractTemplateDiv").hide();
		$("#supervisionTemplateId").attr("value",'');
		$("#supervisionTemplateId").trigger("liszt:updated");
		$("#supervisionTemplateDiv").hide();
		$("#acceptanceTemplateId").attr("value",'');
		$("#acceptanceTemplateId").trigger("liszt:updated");
		$("#acceptanceTemplateDiv").hide();
		$("#isWrite").attr("value",'');
		$("#isWrite").trigger("liszt:updated");
		$("#isWriteDiv").hide();
		$("#timeArea").attr("value",'');
		$("#timeArea").trigger("liszt:updated");
		$("#timeListDiv").hide();
		$("#remarkDiv").hide();
	} else {
		$("#contractTemplateDiv").show();
		$("#supervisionTemplateDiv").show();
		$("#reportTemplateDiv").show();
		$("#acceptanceTemplateDiv").show();
		$("#isWriteDiv").show();
		$("#remarkDiv").show();
		$("#timeListDiv").show();
	}
}

function initSelect1(selectId,value){
	 $("#" + selectId).prepend("<option value=''>----请选择----</option>");
	 if(value == ""){
	   $("#"+ selectId).attr("value",'');
	  }	
		$("#"+selectId).chosen();	
	}
