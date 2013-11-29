
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
	});
});
$(function(){ 
	$("#mitem\\.itemName").blur(function(){ 
    	if($.trim($(this).val()) ==''){
         	$("#errItemName").html("类型名称"+UPLANG.input_must);
         } else {
        	 $("#errItemName").html("");
         }
    }) ;
 });
 
$(function(){ 
	$("#mitem\\.itemOrd").blur(function(){ 
    	if($(this).val() ==''){
         	$("#errItemOrd").html("类型顺序"+UPLANG.input_must);
         } else {
        	 $("#errItemOrd").html("");
         }
    }) ;
 });

function checkOrder(){
	 var flg = false;
	 if($.trim($("#mitem\\.itemName").val()) ==''){
      	$("#errItemName").html("类型名称"+UPLANG.input_must);
      	flg = true;
      } else {
     	 $("#errItemName").html("");
      }
	 if($("#mitem\\.itemOrd").val() ==''){
      	$("#errItemOrd").html("类型顺序"+UPLANG.input_must);
      	flg = true;
      } else {
     	 $("#errItemOrd").html("");
      }
	 
	return flg;
}

$(function() {

	$(document).ready(function() {
		 $("#mitem\\.pitemId").chosen({allow_single_deselect:true});		
	});
});
$("#btnSave").bind("click", function() {
	if (checkOrder()) {
		return;
	}
	var actionUrl=path +"/api/superadmin/mitem!modify.action";
	var val = confirm($("#comfirmSave").text());
	 if (!val) {
	    return; 
	 }
	upms.showOverLay();// 打开遮罩

	var $newPgDiv = $("#mainContent");

	var arrParams = [{
		name : "masterType",
		targetid : "masterType",
		type : "text"
	}, {
		name : "itemId",
		targetid : "itemId",
		type : "text"
	}, {
		name : "itemId",
		targetid : "itemId",
		type : "text"
	}, {
		name : "typeId",
		targetid : "mitem\\.typeId",
		type : "text"
	}, {
		name : "mitem.PItemId",
		targetid : "mitem\\.PItemId",
		type : "select"
	}, {
		name : "mitem.itemName",
		targetid : "mitem\\.itemName",
		type : "text"
	}, {
		name : "mitem.itemDesc",
		targetid : "mitem\\.itemDesc",
		type : "text"
	}, {
		name : "mitem.itemOrd",
		targetid : "mitem\\.itemOrd",
		type : "text"
	} ];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});

//返回
$("#reBtn").bind("click", function() {
var actionUrl= path +"/api/superadmin/mtype!initOtherSetting.action";
var $newPgDiv = $("#mainContent");
var arrParams =[{}];
var data = upms.transParsToObj(arrParams, $newPgDiv);
$newPgDiv.load(actionUrl, data, function() {
	upms.hideOverLay();
});
					});