	// 项目根目录
	var path="";
	
	$(document).ready(function(){
		path = $("#path").text();
		//项目分类
		upms.upmsUtils.initSelect("planFlag",'', 1 , 1 , 0);
		upms.upmsUtils.initSelect("typeId",'', 1 , 1 , 0);
	 	//监理状态
		upms.upmsUtils.initSelect("supervisorState",'', 1 , 1 , 0);
		//项目分类联动
		$("#planFlag").chosen().change(function(){
			getSecondData('typeId','planFlag');
		});
	
	 	$("#queryBtn").attr("disabled",true);
	 	var actionUrl=path + "/api/supervisor/tsupervisorAction!supervisorList.action?date=" + new Date().getTime();
		var params = [{name:"projectName",targetid:"projectName",type:"text"},
		              			{name:"applicationUnit",targetid:"applicationUnit",type:"text"},
		              			{name:"planFlag",targetid:"planFlag",type:"select"},
		              			{name:"typeId",targetid:"typeId",type:"select"},
		              			{name:"supervisorState",targetid:"supervisorState",type:"select"}];
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#resultDiv");
		var data = upms.transParsToObj(params, $("#searchForm"));
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
			$("#queryBtn").removeAttr("disabled");
		});
	}); 

	 $("#queryBtn").bind("click", function() {
		 var actionUrl=path + "/api/supervisor/tsupervisorAction!supervisorList.action?date=" + new Date().getTime();
		var params = [{name:"projectName",targetid:"projectName",type:"text"},
		              			{name:"applicationUnit",targetid:"applicationUnit",type:"text"},
		              			{name:"planFlag",targetid:"planFlag",type:"select"},
		              			{name:"typeId",targetid:"typeId",type:"select"},
		              			{name:"supervisorState",targetid:"supervisorState",type:"select"}];
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#resultDiv");
		var data = upms.transParsToObj(params, $("#searchForm"));
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	});
	 
	//下拉列表联动
	 var secondId = "";
	 function getSecondData(value, value1){
	     var pItemId=$('#'+ value1).val();
	     secondId = value;
	     $.ajax({
	        url:path + '/api/supervisor/tsupervisorAction!getSecondData.action',
	        type:'post',
	        dataType:'json',
	        data:{planFlag:pItemId},
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

	     var s_root=$("#" +secondId);
	     s_root.find("option").remove();
	     s_root.append("<option value=''>----请选择----</option>");
	     for(var i=0;i<datas.length;i++){
	     	 s_root.append("<option value='"+datas[i]+"'>"+datas[i+1]+"</option>");
	        	 i++;
	     }
	     s_root.trigger("liszt:updated");
	 }