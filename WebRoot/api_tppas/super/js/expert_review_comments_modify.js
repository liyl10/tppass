
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
	});
});

$("#okBtn").bind("click", function() {
	// 验证text
	var result = upms.upmsUtils.inputCheck();
	
	if(result){
		return;
	}
	if(!checkScore3()){
		return;
	}
	if(!checkScore5()){
		return;
	}
	if(!checkScoreTotal()){
		return;
		}
	if (confirm($("#comfirmSave").text())){	
		
		var actionUrl= path + "/api/superadmin/texpertreviewcommentsaction!insertTexpertReviewCommen.action?now="+ new Date().getTime();
		upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#mainContent");
		var arrParams = [];
		arrParams = upms.upmsUtils.setSubmitDatas(arrParams, 1, 0);
		var data = upms.transParsToObj(arrParams, $newPgDiv);
		$newPgDiv.load(actionUrl, data, function() {
			upms.hideOverLay();
		});
	}
});
//备注重点推荐分数区间验证
function checkScore3(){
	var ScoreFlag = false;
	var remarksScore2 = "";
	var remarksScore3 = "";
	remarksScore2 = $("#remarksScore2").val();
	remarksScore3 = $("#remarksScore3").val();
	
	if(remarksScore2 != null && remarksScore2 != "" && remarksScore3 != null && remarksScore3 != ""){
		
		if(remarksScore2>remarksScore3){
			$("#errremarksScore2").html("开始重点推荐分数不能大于结束重点推荐分数！");
			return;
		}else{
			$("#errremarksScore2").html("");
			ScoreFlag = true;
		}
	}
	return ScoreFlag;

}
//  备注推荐分数区间验证
function checkScore5(){
	var ScoreFlag = false;
	var remarksScore4 = "";
	var remarksScore5 = "";
	remarksScore4 = $("#remarksScore4").val();
	remarksScore5 = $("#remarksScore5").val();
	
	if(remarksScore4 != null && remarksScore4 != "" && remarksScore5 != null && remarksScore5 != ""){
		
		if(remarksScore4>remarksScore5){
			$("#errremarksScore5").html("开始推荐分数不能大于结束推荐分数！");
			return;
		}else{
			$("#errremarksScore5").html("");
			ScoreFlag = true;
		}
	}
	return ScoreFlag;

}
//判断5个分值总分数是否超过100  
function checkScoreTotal(){
	 var ScoreTotalFlag = false;
   $.ajax({
      url:path + '/api/superadmin/texpertreviewcommentsaction!getScoreTotal.action?score1='+$("#score1").val()+'&score2='+$("#score2").val()+'&score3='+$("#score3").val()+'&score4='+$("#score4").val()+'&score5='+$("#score5").val()+'&now=' + new Date().getTime(),
      type:'post',
      dataType:'json',
      data:null,
      async:false,
      success:function(json){
   	   var yesOrNo=json.backStr;
   	   if(yesOrNo=='Exist'){
			$("#errrevealOrder").html("");
			ScoreTotalFlag = true;
   	   }else{
	   		$("#errrevealOrder").html("5个分值总分数不能超过100分！");
		    return;
   	   }
      }
       });
	return ScoreTotalFlag;
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