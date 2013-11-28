<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/super/js/contractModel_insert.js"></script>
<label id="comfirmSave" style="display: none"><s:text name="confirm_save_info"/></label>
<div align="center"
	style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
 			<s:if  test="%{contractTemplateId == '' || contractTemplateId == null}">
				<div class="abuot07">合同申报模板_新增</div>
			</s:if>
			<s:else>
				<div class="abuot07">合同申报模板_修改</div>
			</s:else>
				<div class="abuot03">
					<input type="hidden" id="contractTemplateId" name="contractTemplateId" value="<s:property value='%{contractTemplateId}' escape='true'/>" />
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="40%" style="padding: 4px 8px; text-align: right">
								合同模板名称
							</td>
							<td width="60%" style="padding: 4px 8px; text-align: left">
								<input id="tprojectContractTemplate.contractTemplateName" value="<s:property value='%{tprojectContractTemplate.contractTemplateName}' escape='true'/>"  name="tprojectContractTemplate.contractTemplateName" type="text" style="width: 23em; height:1.6em;" class="inputA"/>
							</td>
						</tr>	
						<tr>
							<td width="40%" style="padding: 4px 8px; text-align: right">
								保存地址
							</td>
							<td width="60%" style="padding: 4px 8px; text-align: left">
								<input id="tprojectContractTemplate.saveUrl" value="<s:property value='%{tprojectContractTemplate.saveUrl}' escape='true'/>" name="tprojectContractTemplate.saveUrl" type="text" style="width: 23em; height:1.6em;" class="inputA"/>
							</td>
						</tr>
						<tr>
							<td width="40%" style="padding: 4px 8px; text-align: right">
								修改地址
							</td>
							<td width="60%" style="padding: 4px 8px; text-align: left">
								<input id="tprojectContractTemplate.updateUrl" value="<s:property value='%{tprojectContractTemplate.updateUrl}' escape='true'/>" name="tprojectContractTemplate.updateUrl" type="text" style="width: 23em; height:1.6em;" class="inputA"/>
							</td>
						</tr>
						<tr>
							<td width="40%" style="padding: 4px 8px; text-align: right">
								查看地址
							</td>
							<td width="60%" style="padding: 4px 8px; text-align: left">
								<input id="tprojectContractTemplate.viewUrl" value="<s:property value='%{tprojectContractTemplate.viewUrl}' escape='true'/>" name="tprojectContractTemplate.viewUrl" type="text" style="width: 23em; height:1.6em;" class="inputA"/>
							</td>
						</tr>
						<tr>
							<td width="40%" style="padding: 4px 8px; text-align: right">
								删除地址
							</td>
							<td width="60%" style="padding: 4px 8px; text-align: left">
								<input id="tprojectContractTemplate.deleteUrl" value="<s:property value='%{tprojectContractTemplate.deleteUrl}' escape='true'/>" name="tprojectContractTemplate.deleteUrl" type="text" style="width: 23em; height:1.6em;" class="inputA"/>
							</td>
						</tr>
						<tr>
							<td width="40%" style="padding: 4px 8px; text-align: right">
								审核地址
							</td>
							<td width="60%" style="padding: 4px 8px; text-align: left">
								<input id="tprojectContractTemplate.auditUrl" value="<s:property value='%{tprojectContractTemplate.auditUrl}' escape='true'/>" name="tprojectContractTemplate.auditUrl" type="text" style="width: 23em; height:1.6em;" class="inputA"/>
							</td>
						</tr>
					<div style="display: block; text-align: center; margin-top: 12px">
<%-- 					<tag:auth code="ss.contractModel_insert.save"> --%>
							<a class="button save" name="btnSave"
							id="btnSave"  >保存</a>
<%-- 					</tag:auth> --%>
<%-- 					<tag:auth code="ss.contractModel_insert.return"> --%>
							<a class="button back" name="reBtn"
							id="reBtn"  >返回</a>	
<%-- 					</tag:auth> --%>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>
