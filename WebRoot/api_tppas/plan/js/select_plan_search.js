// 项目根目录
var path="";

$(document).ready(function(){
	path = $("#path").text();
	
	// 业务部门
	upms.upmsUtils.initSelect("selectedDeptId","", 1, 2, 4);
	// 计划类别
	upms.upmsUtils.initSelect("projectType1","", 1, 2, 4);
	// 项目分类
	upms.upmsUtils.initSelect("projectType2","", 1, 2, 4);
	// 批次
	upms.upmsUtils.initSelect("planBatch", "", 1, 1, 0);
	// 分计划状态
	//upms.upmsUtils.initSelect("planState", "", 1, 1, 0);
	// 查询按钮制域
 	$("#queryBtn").attr("disabled",true);
 	
 	$("#projectType1").chosen().change(function(){
		getSecondData('projectType2','projectType1',"projectType");
	});
	
	$("#selectedDeptId").chosen().change(function(){
		getSecondData('projectType1','selectedDeptId',"dept");
	});
	
 	var actionUrl=path + "/api/planCollect/tplanCollectAction!getPlanList.action?date=" + new Date().getTime();
	var params = [{name:"planName",targetid:"planName",type:"text"},
	              {name:"planYear",targetid:"planYear",type:"text"},
	              {name:"planBatch",targetid:"planBatch",type:"text"},
	              {name:"selectedDeptId",targetid:"selectedDeptId",type:"text"},
	              {name:"projectType1",targetid:"projectType1",type:"text"},
	              {name:"projectType2",targetid:"projectType2",type:"text"}];
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#resultDiv");
	var data = upms.transParsToObj(params, $("#searchForm"));
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
		$("#queryBtn").removeAttr("disabled");
	});
}); 

// 查询按钮
 $("#queryBtn").bind("click", function() {
		var actionUrl=path + "/api/planCollect/tplanCollectAction!getPlanList.action?date=" + new Date().getTime();
		var params = [{name:"planName",targetid:"planName",type:"text"},
		              {name:"planYear",targetid:"planYear",type:"text"},
		              {name:"planBatch",targetid:"planBatch",type:"text"},
		              {name:"selectedDeptId",targetid:"selectedDeptId",type:"text"},
		              {name:"projectType1",targetid:"projectType1",type:"text"},
		              {name:"projectType2",targetid:"projectType2",type:"text"}];
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#resultDiv");
		var data = upms.transParsToObj(params, $("#searchForm"));
    	$newPgDiv.load(actionUrl, data, function() {
    		upms.hideOverLay();
    	});
});
 
//下拉列表联动
 var secondId = "";
 function getSecondData(value, value1,flag){
     var pItemId=$('#'+ value1).val();
     secondId = value;
     $.ajax({
        url:path + '/api/planCollect/tplanCollectAction!getSecondData.action',
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
