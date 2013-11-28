
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
		 initSelect("copyId1",$("#copyId1").val());
		 initSelect("copyId2",$("#copyId2").val());
		 $("#copyId1").chosen().change(function(){
			    getSecondData('copyId2','copyId1');
		 });
		 $("#copyId2").chosen().change(function(){
			    getSecondData($("#copyId2").val(),'copyId2');
		 });
	});
});
//初始化下拉列表
function initSelect(selectId,value){
	 if(value == ""){
		 $("#"+ selectId).attr("value",'');
	 }
}
//下拉列表联动
var secondId = "";
function getSecondData(value, value1){
    var pItemId=$('#'+ value1).val();
    secondId = value;
    $.ajax({
       url: path+'/api/superadmin/texpertreviewcommentsaction!getSecondData.action',
       type:'post',
       dataType:'json',
       data:{pitemId:pItemId},
       success:setSecondData
    });
}
//下拉列表联动
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
    	   
    	    s_root1.trigger("liszt:updated");
    	}
    	
    }
    var s_root=$("#" +secondId);
    s_root.find("option").remove();
   
    for(var i=0;i<datas.length;i++){
    	 s_root.append("<option value='"+datas[i]+"'>"+datas[i+1]+"</option>");
       	 i++;
    }
    s_root.trigger("liszt:updated");
    
}
$("#okBtn").bind("click", function() {

	// 验证下拉列表
	var idList = new Array("copyId1","copyId2");
	var result1 = upms.upmsUtils.selectCheck(idList);
	
	if(result1){
		return;
	}
	if(!checkExpertReview()){
		return;
	}
	if (confirm($("#comfirmSave").text())){	
		var actionUrl= path + "/api/superadmin/texpertreviewcommentsaction!copyTexpertReviewComments.action?now="+ new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#mainContent");
		var arrParams = [ {name : "texpertReviewComments.typeId",targetid : "copyId1",type : "select"},
		                  {name : "texpertReviewComments.expertType",targetid : "copyId2",type : "select"}
						];
		arrParams = upms.upmsUtils.setSubmitDatas(arrParams, 1, 0);
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	}
});
function checkExpertReview(){
	 var yesOrNoflag = false;
   $.ajax({
      url:path + '/api/superadmin/texpertreviewcommentsaction!checkExpertReview.action?typeId='+$("#typeId").val()+'&pitemId=' + $("#copyId2").val() + '&dd=' + new Date().getTime(),
      type:'post',
      dataType:'json',
      data:null,
      async:false,
      success:function(json){
   	   
   	   var yesOrNo=json.backStr;
   	   if(yesOrNo=='Exist'){
   			$("#errexpertReview").html("专家评估模板类型已存在！");
      	   		return;
   	   }else{
   		   
   		   $("#errexpertReview").html("");
   		   yesOrNoflag = true;
   		  
   	   }
      }
       });
	return yesOrNoflag;
}
//返回
$("#backBtn").bind("click", function() {
var actionUrl= path +"/api/superadmin/texpertreviewcommentsaction!list.action";
var $newPgDiv = $("#mainContent");
var arrParams = [];
arrParams = upms.upmsUtils.setSubmitDatas(arrParams, 1, 0);
var data = upms.transParsToObj(arrParams, $newPgDiv);
$newPgDiv.load(actionUrl, data, function() {
	upms.hideOverLay();
});
});