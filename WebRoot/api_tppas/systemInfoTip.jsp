<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<style type="text/css">
<!--
.c {
        font-family: Verdana, Arial, Helvetica, sans-serif;
        font-size: 18px;
        font-weight: normal;
        color: red;
        line-height: 20px;
        text-align: center;
        border: 1px solid #CCCCCC;
        background-color: #FFFFEC;
        
}
-->
</style>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07"></div>
				<div class="abuot03" style="text-align:center">
				<div class="c"><br><s:property value='%{retMsg}' escape='true'/><br>&nbsp;</div>
				
					<div style="display:block;text-align:center;margin-top:8px">
					<input type="button" class="button" name="btnReturn" id="btnReturn" value="返回 "></div>
					
				</div>
			</div>
		</div>
	</div>
	<input type="hidden" id="hidKey"/>
</div>
<script type="text/javascript">

function autoRef(){
	
	if($("#hidKey").length >0){
		
	
		$("#btnReturn").attr("disabled",true);
		var actionUrl="<s:property value='%{retUrl}' escape='true'/>";
		actionUrl = actionUrl.replace(/\&amp;/g,"&");
		//alert(actionUrl);
	 	upms.showOverLay();// 打开遮罩
		var $newPgDiv = $("#content");
		//alert("actionUrl=="+actionUrl);
		var data =  "&dd=" + new Date().getTime();
		//alert( $("#content").length);

		$newPgDiv.load(actionUrl + data,"", function() {		
			upms.hideOverLay();
			}); 
		}	
}

$(function() {
	$(document).ready(function() {
		window.setTimeout("autoRef()",3000); 
	});
});

$("#btnReturn").bind("click", function() {
	var actionUrl="<s:property value='%{retUrl}' escape='true'/>";
	actionUrl = actionUrl.replace(/\&amp;/g,"&");
	//alert(actionUrl);
 	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#content");

	//var data =  "?dd=" + new Date().getTime();
	var data =  "&dd=" + new Date().getTime();
	//alert( $("#content").length);
	$newPgDiv.load(actionUrl + data,"", function() {		
		upms.hideOverLay();
		}); 
});
</script>
