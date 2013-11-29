// 项目根目录
var path="";

$(document).ready(function(){
	path = $("#path").text();
	
	// 公司性质
	upms.upmsUtils.initSelect("companyType","", 1, 1, 0);
	
	// 计划类别
	upms.upmsUtils.initSelect("selectedProjectTypeFirst", "", 1, 2, 0);
	// 计划类别
	upms.upmsUtils.initSelect("selectedProjectTypeSecond", "", 1, 2, 0);
	
	//upms.upmsUtils.initSelect("typeId2",$("#typeId2Value").val(), 1 , 2 , 4);
	//upms.upmsUtils.initSelect("typeId3",$("#typeId3Value").val(), 1 , 2 , 4);
	 
	// 审核状态
	//upms.upmsUtils.initSelect("auditStatus", "", 1, 1, 0);
	
	$("#selectedProjectTypeFirst").chosen().change(function(){
		getSecondData('selectedProjectTypeSecond','selectedProjectTypeFirst');
	});
	
	// 查询按钮制域
 	//$("#queryBtn").attr("disabled",true);
 	// 检索跳转处理
 	pageDirect();
});

$("#queryBtn").bind("click", function() {
	// 检索跳转处理
	var actionUrl=path + "/api/report/beforeReviewAction!beforeReviewList.action?date=" + new Date().getTime();
	var params = [{name:"projectName",targetid:"projectName",type:"text"},
	              {name:"applicationUnit",targetid:"applicationUnit",type:"text"},
	              {name:"companyType",targetid:"companyType",type:"select"},
	              {name:"selectedProjectTypeFirst",targetid:"selectedProjectTypeFirst",type:"select"},
	              {name:"selectedProjectTypeSecond",targetid:"selectedProjectTypeSecond",type:"select"}
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

//批量审核项目
function beforeReviewByList(){

	// 取得选中的项目id，组成项目idlist
	if($(":checkbox:checked").length == 0){
		alert("没有选中的项目，请选择待初审的项目！");
		return false;
	}
	
	// 组织选中的项目ID
	var projectIdList = "";
	$(":checkbox:checked").each(function(){
		projectIdList = projectIdList + $(this).val() + ",";
	});

	var actionUrl= path + "/api/report/beforeReviewAction!showBeforeReviewByList.action?projectIdList=" + projectIdList + "&now="+new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");
	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
}

// 画面跳转：一览画面
function pageDirect(){
	var actionUrl=path + "/api/report/beforeReviewAction!beforeReviewList.action?date=" + new Date().getTime();
	var params = [{name:"projectName",targetid:"projectName",type:"text"},
	              {name:"applicationUnit",targetid:"applicationUnit",type:"text"},
	              {name:"companyType",targetid:"companyType",type:"select"},
	              {name:"selectedProjectTypeFirst",targetid:"selectedProjectTypeFirst",type:"select"},
	              {name:"selectedProjectTypeSecond",targetid:"selectedProjectTypeSecond",type:"select"}
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
function getSecondData(value, value1){
    var pItemId=$('#'+ value1).val();
    secondId = value;
    $.ajax({
       url:path + '/api/report/beforeReviewAction!getSecondData.action',
       type:'post',
       dataType:'json',
       data:{pitemId:pItemId},
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