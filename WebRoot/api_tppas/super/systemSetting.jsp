<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/super/js/systemSetting.js"></script>
<label id="comfirmSave" style="display: none"><s:text name="confirm_save_info"/></label>
<s:hidden id="typeKey" name="typeKey" value="%{typeKey}"></s:hidden>
<div align="center"
	style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">
						系统信息管理
					</div>
				<div class="abuot03">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<s:iterator value="resultList" status="rowData">
							<tr>
								<td width="40%" style="padding: 4px 8px; text-align: right"><FONT color=red>*</FONT>
									<s:property value='%{itemName}' escape='true' /> <s:hidden
										id="itemName" name="itemName" value="%{itemName}" /> <s:hidden
										id="itemIdLst" name="itemIdLst" value="%{itemId}" />
								</td>
								<td width="60%" style="padding: 4px 8px; text-align: left">
									<input class="inputA" name="itemValueLst" type="text"
									onfocus="if(this.value=='无'){this.value=''}"
									onblur="if(this.value==''){this.value='无'}" id="itemValueLst"
									maxlength="50"
									value="<s:property value='%{itemDesc}' escape='true'/>" />
									<em class=requirecolor id="errItemValueLst"
										name="errItemValueLst"></em>
									
								</td>
							</tr>
						</s:iterator>
					</table>
					<div style="padding-top: 5px; display: block; text-align: center">
					<tag:auth code="ss.sysSetting.save">
						 <a class="button save" name="savePwd" id="savePwd">保存</a>
					</tag:auth>					
					</div>
				</div>
			</div>
		</div>
	</div>
</div>