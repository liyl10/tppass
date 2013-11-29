
// 工程根目录
var path="";

$(function(){ 
	$("#mtype\\.typeName").blur(function(){ 
    	if($.trim($(this).val()) ==''){
         	$("#errTypeName").html("类型名称"+UPLANG.input_must);
         } else {
        	 $("#errTypeName").html("");
         }
    }) ;
 }); 
 
$(function() {

	$(document).ready(function() {
		 path = $("#path").text();
		if($("#PTypeFlag").val()=="1"){
			
			$("#mtype\\.PTypeFlag").attr("checked","checked");
			$("#dspSel").show();
		}else{
			$("#dspSel").hide();
		}
		$("#mtype\\.PTypeId").chosen({allow_single_deselect:true});		
	});
});

$("#mtype\\.PTypeFlag").bind("click", function() {
	if($("#mtype\\.PTypeFlag").attr("checked")=='checked'){
		$("#dspSel").show();
	}else{
		$("#dspSel").hide();
	}
	
});

$("#btnSave").bind("click", function() {
	if($.trim($("#mtype\\.typeName").val()) ==''){
     	$("#errTypeName").html("类型名称"+UPLANG.input_must);
     	return;
     } else {
    	 $("#errTypeName").html("");
     }
	var actionUrl=path +"/api/superadmin/mtype!saveType.action";
	var val = confirm($("#comfirmSave").text());
	 if (!val) {
	    return; 
	 }
	upms.showOverLay();// 打开遮罩
	//upms.clearWebObj();// 清空webObj对象
	var $newPgDiv = $("#mainContent");
	//alert(actionUrl);

	if ($("#mtype\\.PTypeFlag").attr("checked") == 'checked') {
		$("#hPtypeFlag").val("1");
	} else {
		$("#hPtypeFlag").val("0");
	}
	//alert($("#hPtypeFlag").val());
	var arrParams = [ {
		name : "typeId",
		targetid : "typeId",
		type : "text"
	}, {
		name : "mtype.PTypeId",
		targetid : "mtype\\.PTypeId",
		type : "select"
	}, {
		name : "mtype.typeName",
		targetid : "mtype\\.typeName",
		type : "text"
	}, {
		name : "mtype.PTypeFlag",
		targetid : "hPtypeFlag",
		type : "text"
	}, {
		name : "mtype.typeDsc",
		targetid : "mtype\\.typeDsc",
		type : "text"
	} ];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	//alert($("#mtype\\.ptypeFlag").attr("checked"));

	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});

//返回
$("#reBtn").bind("click", function() {
var actionUrl= path +"/api/superadmin/mtype!initTypeSetting.action";
var $newPgDiv = $("#mainContent");
var arrParams =[{}];
var data = upms.transParsToObj(arrParams, $newPgDiv);
$newPgDiv.load(actionUrl, data, function() {
	upms.hideOverLay();
});
					});
