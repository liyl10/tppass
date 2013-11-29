// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();
		// 下拉列表初期化
		if($("#isPlanningDept").val() == 'true'){			
			upms.upmsUtils.initSelect("selectedProjectType0","", 1 , 3 ,3);
			upms.upmsUtils.initSelect("selectedProjectType1","", 1 , 3 , 4);
			upms.upmsUtils.initSelect("selectedProjectType2","", 1 , 3 , 4);
		}else{
			upms.upmsUtils.initSelect("selectedProjectType1","", 1 , 3 , 4);
			upms.upmsUtils.initSelect("selectedProjectType2","", 1 , 3 , 4);
		}
		
		
		upms.upmsUtils.initSelect("selectedReportYear",$("#defaultSelectedReportYear").val(), 0 , 1 , 1);
		
		upms.upmsUtils.initSelect("centralizedType","", 1 , 1 ,0);
		
		/*$("#selectedProjectTypeFirst").chosen().change(function(){
			getSecondData('selectedProjectTypeSecond','selectedProjectTypeFirst',"projectType");
		});
		
		$("#selectedDept").chosen().change(function(){
			getSecondData('selectedProjectTypeFirst','selectedDept',"dept");
		});*/
		 
		var actionUrl = path + "/api/statistics/vprojectResultCollectAction!getList.action"+ "?now=" + new Date().getTime();
		//upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#resultDiv");
		var params = [ {name:"selectedReportYear",targetid:"selectedReportYear",type:"select"},
		               {name:"selectedProjectTypeFirst",targetid:"selectedProjectType1",type:"select"},
		                {name:"selectedProjectTypeSecond",targetid:"selectedProjectType2",type:"select"},
		                {name:"projectName",targetid:"projectName",type:"text"},
		                {name:"applicationUnit",targetid:"applicationUnit",type:"text"},
		                {name:"centralizedType",targetid:"centralizedType",type:"select"}];
		
		if ($("#isPlanningDept").val() == 'true'){
			params[params.length] = {name:"selectedDept",targetid:"selectedProjectType0",type:"select"};
		}
		var data = upms.transParsToObj(params, $("#searchForm"));
		$newPgDiv.load(actionUrl, data, function() {
			//upms.hideOverLay();
		});
	});
});

// 查询按钮
$("#queryBtn").bind("click", function(){

	var actionUrl = path + "/api/statistics/vprojectResultCollectAction!getList.action"+ "?now=" + new Date().getTime();
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#resultDiv");
	
	var params = [  {name:"selectedReportYear",targetid:"selectedReportYear",type:"select"},
	                {name:"selectedProjectTypeFirst",targetid:"selectedProjectType1",type:"select"},
	                {name:"selectedProjectTypeSecond",targetid:"selectedProjectType2",type:"select"},
	                {name:"projectName",targetid:"projectName",type:"text"},
	                {name:"applicationUnit",targetid:"applicationUnit",type:"text"},
	                {name:"centralizedType",targetid:"centralizedType",type:"select"}];
	if ($("#isPlanningDept").val() == 'true'){
		params[params.length] = {name:"selectedDept",targetid:"selectedProjectType0",type:"select"};
	}
	var data = upms.transParsToObj(params, $("#searchForm"));
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});

// 点击导出按钮
$("#exportBtn").bind("click", function(){
		// 判断是否有数据，如果没有可以导出的数据则提示message
		if($("#printEnableFlag").val() =="false"){
			alert("没有查到任何可以导出的记录，请重新选择检索条件。");
			return false;
		}
	   	var actionUrl=path + "/api/statistics/vprojectResultCollectAction!exportDatas.action?jumpFlag=" + "resultCollect" +"&now=" + new Date().getTime();
		upms.showOverLay();// 打开遮罩
		window.location.href= actionUrl;
		setTimeout(function(){upms.hideOverLay();},1000); 
});

//下拉列表联动
var secondId = "";
function getSecondData(value, value1,flag){
    var pItemId=$('#'+ value1).val();
    secondId = value;
    $.ajax({
       url:path + '/api/statistics/vprojectResultCollectAction!getSecondData.action',
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
