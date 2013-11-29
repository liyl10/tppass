<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/super/js/otherItem_insert.js"></script>
<label id="comfirmSave" style="display: none"><s:text name="confirm_save_info"/></label>
<s:hidden id="masterTypeName" name="masterTypeName" value='%{masterTypeName}' ></s:hidden>
<div align="center"
	style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">代码值配置管理维护</div>
				<div class="abuot03">
					<input type="hidden" id="itemId" name="itemId" value="<s:property value='%{itemId}' escape='true'/>" />
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr >
							<td width="40%" style="padding: 4px 8px; text-align: right"><label
								for="mitem.typeId">代码类型 </label>&nbsp;</td>
							<td width="60%" style="padding: 4px 8px; text-align: left">
								<input readonly="readonly" class="inputA" name="typeId"
								type="hidden" id="mitem.typeId" maxlength="50"
								value="<s:property value='%{itemType}' escape='true'/>" />
							<s:property value='%{masterTypeName}' escape='true' />
							<input readonly="readonly" class="inputA" name="mitem.typeId"
								type="hidden" id="masterType"  value="<s:property value='%{masterType}' escape='true' />" />
							&nbsp;</td>
						</tr>
						<s:if test="%{mtype.pTypeFlag==1}">
							<tr >
								<td width="40%" style="padding: 4px 8px; text-align: right"><label
									for="mitem.pitemId">父类型名称 </label>&nbsp;</td>
								<td width="60%" style="padding: 4px 8px; text-align: left">
									<s:select list="pitemLst" label="父类型名称 "  style="width:15em"
										listKey="itemId" 
										listValue="itemName" id="mitem.pitemId" name="mitem.pitemId"></s:select>
								&nbsp;</td>
							</tr>
						</s:if>
						<tr >
							<td width="40%" style="padding: 4px 8px; text-align: right"><FONT color=red>*</FONT><label
								for="mitem.itemName">代码值项目名称 </label>&nbsp;</td>
							<td width="60%" style="padding: 4px 8px; text-align: left">
								<input class="inputA" name="mitem.itemName" type="text"
								id="mitem.itemName" maxlength="50"  onfocus="if(this.value=='无'){this.value=''}" onblur="if(this.value==''){this.value='无'}"
								value="<s:property value='%{mitem.itemName}' escape='true'/>" />
								<em class=requirecolor id="errItemName" name="errItemName"></em>
							&nbsp;</td>
						</tr>
						<tr >
							<td width="40%" style="padding: 4px 8px; text-align: right"><label
								for="mitem.itemDesc">代码值项目描述 </label>&nbsp;</td>
							<td width="60%" style="padding: 4px 8px; text-align: left">
								<input class="inputA" name="mitem.itemDesc" type="text"
								id="mitem.itemDesc" maxlength="400"  onfocus="if(this.value=='无'){this.value=''}" onblur="if(this.value==''){this.value='无'}"
								value="<s:property value='%{mitem.itemDesc}' escape='true'/>" />
							&nbsp;</td>
						</tr>
						<tr >
							<td width="40%" style="padding: 4px 8px; text-align: right"><FONT color=red>*</FONT><label
								for="mitem.itemOrd">顺序 </label>&nbsp;</td>
							<td width="60%" style="padding: 4px 8px; text-align: left"><input
								autocomplete="off"
								onkeyup='this.value=this.value.replace(/[^0-9]\D*$/,"")'
								class="inputA" name="mitem.itemOrd" type="text"
								id="mitem.itemOrd" maxlength="3"  onfocus="if(this.value=='0'){this.value=''}" onblur="if(this.value==''){this.value='0'}"
								value="<s:property value='%{mitem.itemOrd}' escape='true'/>" />
								<em class=requirecolor id="errItemOrd" name="errItemOrd"></em>
								&nbsp;</td>
						</tr>
					</table>

					<div style="display: block; text-align: center; margin-top: 12px">
					<tag:auth code="ss.otherItemAdd.save">
							<a class="button save" name="btnSave"
							id="btnSave"  >保存</a>
					</tag:auth>
					<tag:auth code="ss.otherItemAdd.return">
							<a class="button back" name="reBtn"
							id="reBtn"  >返回</a>	
					</tag:auth>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>
