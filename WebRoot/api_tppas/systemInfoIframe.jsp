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
				<input type="hidden" value="<s:property value='%{retUrl}' escape='true'/>" id="retUrl" name="retUrl"> 
				<input type="hidden" id="nextFileHidden" value="<s:property value='%{nextFileHidden}' escape='true'/>"  name="nextFileHidden"> 
					<div style="display:block;text-align:center;margin-top:8px">
					<input type="button" class="button" name="btnReturn11" id="btnReturn11" value="返回 " onclick="retloadfile('<s:property value='%{retUrl}' escape='true'/>')"></div>
				</div>
			</div>
		</div>
	</div>
</div>
<input type="hidden" id="chkFlg" />
