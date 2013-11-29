// 项目根目录
var path="";

$(document).ready(function(){
	path = $("#path").text();
	
	/*// 部门一览
	upms.upmsUtils.initSelect("selectedProject1", "", 1, 3, 0);
	// 计划类别
	upms.upmsUtils.initSelect("selectedProject2", "", 1, 3, 0);
	// 计划类别
	upms.upmsUtils.initSelect("selectedProject3", "", 1, 3, 0);*/
	// 部门一览
	selectInit("selectedProject1");
	// 计划类别
	selectInit("selectedProject2");
	// 计划类别
	selectInit("selectedProject3");

	$("#selectedProject1").chosen().change(function(){
		getNextData('selectedProject2','selectedProject1',"dept");
	});
	
	$("#selectedProject2").chosen().change(function(){
		getNextData('selectedProject3','selectedProject2',"projectType");
	});
	
	$("#selectedProject3").chosen().change(function(){
		if($("#selectedProject3").val()==""){
			$("#errorselectedProject3").remove();
			var span = $("<div id='errorselectedProject3"+ "'><span style='color:red;'>"+ "项目分类不能为空！</span></div>");
			$("#selectedProject3").parent().append(span);
		}
		if($("#selectedProject3").val().length>0){
			$("#errorselectedProject3").remove();
		}
	});
});

$("#comitBtn").bind("click", function() {
	// 验证text
	var result = upms.upmsUtils.inputCheck();
	if(result){
		return;
	}

	// 调配前项目分类
	var beforeTypeId = $("#beforeTypeId").val();
	// 调配后项目分类
	var afterTypeId = $("#selectedProject3").val();
	
	// 调配前部门ID
	var beforeDeptId = $("#beforeDeptId").val();
	// 高新处部门ID
	var highTechDeptId = $("#highTechDeptId").val();
	// 调配后部门ID
	var afterDeptId = $("#selectedProject1").val();
	// 跨模板调配区分
	var jumpFlag = "false";
	// 判断调配前后模板是否变化
	var deptRes = false;
	if(beforeDeptId == afterDeptId){
		deptRes = true;
	}else if(beforeDeptId != highTechDeptId && afterDeptId != highTechDeptId){
		deptRes = true;
	}
	// 判断调配前的项目分类和调配后的项目分类是否一致，
	// 如果一致，弹出确认框，点确定继续，点返回重新选择
	if(beforeTypeId == afterTypeId){
		var truthBeTold = window.confirm("调配后的项目分类和调配前的项目分类相同！\n\n如果继续请点击【确定】按钮、\n重新选择请点击【取消】按钮。");
		if(!truthBeTold){
			return false;
		}
	}
	// 调配前后的部门对应的模板如果不匹配，
	// 例如：
	// 调配前为高新处，调配后为农科处，或者调配前为农科处，调配后为高新处
	// 这种不匹配的情况下，弹出确认框，点击确定后，该项目将被设置为归档状态，
	else if(!deptRes){
		var truthBeTold = window.confirm("跨模板调配将会删除该项目信息！确定要跨模板调配吗？");
		if(!truthBeTold){
			return false;
		}else{
			jumpFlag = "true";
		}
	}
	
	// 调配后的项目分类和调配前的项目分类对应的模板不同，如果点击【确定】按钮，该项目将被删除，请联系企业进行重新申报、重新选择请点击【取消】按钮。
	// 上面情况以外的情况，弹出确认框，点确定进行更新
	else if(!confirm("确定要提交该项目调配吗？")){
		return false;
	}

	// 检索跳转处理
	var actionUrl=path + "/api/report/projectDeployAction!updateDeployProject.action?jumpFlag=" + jumpFlag + "&date=" + new Date().getTime();
	var params = [{name:"projectId",targetid:"projectId",type:"text"},
	              {name:"deployComment",targetid:"deployComment",type:"text"},
	              {name:"selectedProjectTypeFirst",targetid:"selectedProject2",type:"select"},
	              {name:"selectedProjectTypeSecond",targetid:"selectedProject3",type:"select"}
	              ];
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var data = upms.transParsToObj(params, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
		//$("#queryBtn").removeAttr("disabled");
	});
});

function selectInit(selectId, flag) {
	// 添加【请选择】选项
	$("#" + selectId).prepend("<option value=''>----请选择----</option>");
	// 初期选择值设定
	$("#" + selectId).attr("value", '');
	$("#" + selectId).chosen();
}

// 下拉列表联动
var secondId = "";
function getNextData(value, value1,searchFlag){
    var pItemId=$('#'+ value1).val();
    secondId = value;
    $.ajax({
       url:path + '/api/report/projectDeployAction!getSecondData.action',
       type:'post',
       dataType:'json',
       data:{pitemId:pItemId,searchFlag:searchFlag},
       success:setNextData
    });
}

// 下拉列表联动
function setNextData(json){
    var data=json.backStr; 
    var datas="";
    if(data!=""){
       datas=data.split(",");
    }
    var tempStr = secondId.substr(0,secondId.length-1);
    
    var tempIndex = parseInt(secondId.substr(secondId.length-1)) +1;
    for(;tempIndex < 5; tempIndex ++){
    	var s_root1=$("#" +tempStr + tempIndex);
    	if(s_root1.length > 0){
    		s_root1.find("option").remove();
    	    s_root1.append("<option value=''>----请选择----</option>");
    	    s_root1.trigger("liszt:updated");
    	}
    }
    var s_root=$("#" +secondId);
    s_root.find("option").remove();
    s_root.append("<option value=''>----请选择----</option>");
    for(var i=0;i<datas.length;i++){
    	 s_root.append("<option value='"+datas[i]+"'>"+datas[i+1]+"</option>");
       	 i++;
    }
    s_root.trigger("liszt:updated");
}
//返回
function backbt(){
	var actionUrl="";
	actionUrl= path + "/api/report/projectDeployAction!showDeploySearch.action?&now=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var arrParams = [];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

