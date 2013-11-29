// 项目根目录
var path="";

$(document).ready(function(){
	path = $("#path").text();
	
	// 公司性质
	upms.upmsUtils.initSelect("companyType","", 1, 1, 0);
	
	// 部门
	upms.upmsUtils.initSelect("selectedProject1", "", 1, 2, 0);
	// 计划类别
	upms.upmsUtils.initSelect("selectedProject2", "", 1, 2, 0);
	// 计划类别
	upms.upmsUtils.initSelect("selectedProject3", "", 1, 2, 0);

	// 审核状态
	//upms.upmsUtils.initSelect("auditStatus", "", 1, 1, 0);
	
	$("#selectedProject1").chosen().change(function(){
		getSecondData('selectedProject2','selectedProject1','dept');
	});
	
	$("#selectedProject2").chosen().change(function(){
		getSecondData('selectedProject3','selectedProject2','projectType');
	});
	
	// 查询按钮制域
 	//$("#queryBtn").attr("disabled",true);
 	// 检索跳转处理
 	pageDirect();
});

$("#queryBtn").bind("click", function() {
	// 检索跳转处理
	var actionUrl=path + "/api/report/projectDeployAction!getDeployList.action?date=" + new Date().getTime();
	var params = [{name:"projectName",targetid:"projectName",type:"text"},
	              {name:"companyType",targetid:"companyType",type:"select"},
	              {name:"selectedDeptId",targetid:"selectedProject1",type:"select"},
	              {name:"selectedProjectTypeFirst",targetid:"selectedProject2",type:"select"},
	              {name:"selectedProjectTypeSecond",targetid:"selectedProject3",type:"select"}
	              //{name:"auditStatus",targetid:"auditStatus",type:"select"}
	              ];
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#resultDiv");
	var data = upms.transParsToObj(params, $("#searchForm"));
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
		//$("#queryBtn").removeAttr("disabled");
	});
});


// 画面跳转：一览画面
function pageDirect(){
	var actionUrl=path + "/api/report/projectDeployAction!getDeployList.action?date=" + new Date().getTime();
	var params = [{name:"projectName",targetid:"projectName",type:"text"},
	              {name:"companyType",targetid:"companyType",type:"select"},
	              {name:"selectedDeptId",targetid:"selectedProject1",type:"select"},
	              {name:"selectedProjectTypeFirst",targetid:"selectedProject2",type:"select"},
	              {name:"selectedProjectTypeSecond",targetid:"selectedProject3",type:"select"}
	              //{name:"auditStatus",targetid:"auditStatus",type:"select"}
	              ];
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#resultDiv");
	var data = upms.transParsToObj(params, $("#searchForm"));
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
		//$("#queryBtn").removeAttr("disabled");
	});
}

//下拉列表联动
var secondId = "";
function getSecondData(value, value1,flag){
    var pItemId=$('#'+ value1).val();
    secondId = value;
    $.ajax({
       url:path + '/api/report/projectDeployAction!getSecondData.action',
       type:'post',
       dataType:'json',
       data:{pitemId:pItemId,searchFlag:flag},
       success:setSecondData
    });
}

// 下拉列表联动
function setSecondData(json){
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