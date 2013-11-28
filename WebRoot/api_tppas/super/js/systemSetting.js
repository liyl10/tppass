
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
	});
});
$(function(){ 
    $("input[name$='itemValueLst']").blur(function(){ 
    	checkOrder();
    }) ;
 }); 
 
 function checkOrder(){
	 var flg = false;
	 $("input[name$='itemValueLst']").each(function(item){
		
 		//非空检查
         if($.trim($(this).val())  ==''){
        	var strId = $("input[name$='itemName']:eq("+item+")").val();
         	$("em[name$='errItemValueLst']:eq("+item+")").html(strId+UPLANG.input_must);
         	flg = true;
         } else {
         	$("em[name$='errItemValueLst']:eq("+item+")").html("");
         }
       });
 	return flg;
 }
 
$("#savePwd").bind("click", function() {
	if (checkOrder()== true){
		return false;
	}
	var actionUrl="";
	actionUrl = path +"/api/superadmin/mitem!saveContractSetting.action";
	var val = confirm($("#comfirmSave").text());
	if (!val) {
	   return;	
	}
 	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");

	var data = "";
	$("input[name$='itemIdLst']").each(function(){
		data =data + "itemIdLst="+ encodeURIComponent($(this).val()) + "&";
	});
	$("input[name$='itemValueLst']").each(function(){
		data =data + "itemValueLst="+ encodeURIComponent($(this).val()) + "&";
	});
	data=data + "dd=" + new Date().getTime()+"&typeKey="+$("#typeKey").val();
	$newPgDiv.load(actionUrl+"?" + (data),"", function() {
		upms.hideOverLay();}); 
});