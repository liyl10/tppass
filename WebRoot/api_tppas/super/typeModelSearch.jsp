<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<s:hidden id="hiddendepartmentId" name="hiddendepartmentId" value="%{departmentId}"></s:hidden>
<s:hidden id="hiddenisShow" name="hiddenisShow" value="%{isShow}"></s:hidden>						
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/super/js/typeModelSearch.js"></script>
<div align="center"
	style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">项目分类</div>
				<div>
					<form id="searchForm">
						<br>
						<table style="width:100%">
							<tr>
<!-- 								<td
									style="width: 1%; text-align: right; padding: 2 2 10 10; font-size: 105%; word-break: keep-all; white-space: nowrap;">
								</td> -->
								<td align="right">真实名称&nbsp;</td>
								<td>		
									<input type="text" id="realName" name="realName" class="inputA"/>
								&nbsp;</td>
<!-- 								<td
									style="width: 1%; text-align: right; padding: 2 2 10 10; font-size: 105%; word-break: keep-all; white-space: nowrap;">
								</td> -->
								<td align="right">显示名称&nbsp;</td>
								<td><input type="text" id="showName" name="showName" class="inputA"/>
								&nbsp;</td>
								<td></td>
							</tr>
							<tr>
							<td align="right">所属部门&nbsp;</td>
							<td style="width: 20%; padding: 2px"><s:select
										list="typeLst" listKey="deptId"
										style="width:15em" listValue="deptName" id="departmentId"
										name="departmentId" value="%{departmentId}"></s:select></td>
								<td align="right">是否显示&nbsp;</td>
							<td style="width: 20%; padding: 2px">
							<select
										style="width:15em" id="isShow"
										name="isShow" value="%{isShow}">
										        <option value="0">是</option>
       										    <option value="1">否</option>
										</select>
										</td>
								<td align="right">
								<input class="button" type="button" id="querybtn" value="查询" />
<%-- 								<tag:auth code="ss.contractModelSearch.search">

								</tag:auth> --%>
								</td>
							</tr>
						</table>

					</form>
				</div>
				<!-- 查询结果列表S -->
				<div id="resultDiv" style="padding-top: 10px;"></div>
				<!-- 查询结果列表E -->
			</div>
		</div>
	</div>
</div>
