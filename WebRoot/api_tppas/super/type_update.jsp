<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/super/js/type_update.js"></script>
<label id="comfirmSave" style="display: none"><s:text name="confirm_save_info"/></label>
<s:hidden id="PTypeFlag" name="PTypeFlag" value="%{mtype.PTypeFlag}"></s:hidden>
<div align="center"
	style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">

		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">代码类型配置维护</div>
				<div class="abuot03">
					<input type="hidden" id="typeId" name="typeId"
						value="<s:property value='%{mtype.typeId}' escape='true'/>" />
					<table width="100%" border="0" cellspacing="0" cellpadding="0"
						class="t-list">
						<tr >
							<td width="40%" style="padding: 4px 8px; text-align: right"><FONT color=red>*</FONT><label
								for="mtype.typeName">类型名称 </label>&nbsp;</td>
							<td width="60%" style="padding: 4px 8px; text-align: left">
								<input class="inputA" name="mtype.typeName" type="text" onfocus="if(this.value=='无'){this.value=''}" onblur="if(this.value==''){this.value='无'}"
								id="mtype.typeName" maxlength="30" value="<s:property value='%{mtype.typeName}' escape='true'/>" />
								<em class=requirecolor id="errTypeName" name="errTypeName"></em>
							&nbsp;</td>
						</tr>
						<tr >
							<td width="40%" style="padding: 4px 8px; text-align: right"><label
								for="mtype.typeDsc">类型描述 </label>&nbsp;</td>
							<td width="60%" style="padding: 4px 8px; text-align: left">
								<input class="inputA" name="mtype.typeDsc" type="text" onfocus="if(this.value=='无'){this.value=''}" onblur="if(this.value==''){this.value='无'}"
								id="mtype.typeDsc" maxlength="300" value="<s:property value='%{mtype.typeDsc}' escape='true'/>" />
							&nbsp;</td>
						</tr>
						<tr >
							<td width="40%" style="padding: 4px 8px; text-align: right"><label
								for="mitem.pitemId">存在父类型 </label>&nbsp;</td>
							<td width="60%" style="padding: 4px 8px; text-align: left">
								<table style="border:0px">
									<tr style="border:0px">
										<td style="border:0px"><input type="checkbox" id="mtype.PTypeFlag"
											name="mtype.PTypeFlag" />&nbsp;</td>
										<td style="border:0px"><div id="dspSel" style="display: block">
												<s:select list="resultList" label="父项目" class="inputA"
													listKey="typeId"
													style="width:15em"
													listValue="typeName" id="mtype.PTypeId"
													name="mtype.PTypeId"></s:select>
											</div></td>
									</tr>
								</table>
							</td>
						</tr>

					</table>

					<div style="display: block; text-align: center; margin-top: 8px">
					<tag:auth code="ss.typeEdit.save">
					<a class="button save" name="btnSave"
							id="btnSave"  >保存</a>
					</tag:auth>
					<tag:auth code="ss.typeEdit.return">
					<a class="button back" name="reBtn"
							id="reBtn"  >返回</a>	
					</tag:auth>	
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<input type="hidden" id="hPtypeFlag" />