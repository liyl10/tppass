<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/plan/js/plan_collection_add.js"></script>
<div align="center" style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">计划汇总</div>
				<div>&nbsp;</div>
				<div>
					<form id="searchForm">
						<table class="t-entRegFrm" style="width: 100%;border-collapse: collapse">
							<tr>
								<td align="right">计划汇总名称&nbsp;</td>
								<td><input type="text" id="planCollectName"
									name="planCollectName" class="inputA" autocomplete="off"
									style="width: 15em;" maxlength="40"
									onblur="upms.upmsUtils.blurTextCheck(this,'计划汇总名称',1,-1)"
									onfocus="upms.upmsUtils.textFocus(this);" /> 
									<s:hidden id="hiddenplanCollectName" name="hidden" value="计划汇总名称,1,-1"></s:hidden>
								</td>

							</tr>
							<tr>
								<td align="right">计划年度&nbsp;</td>
								<td><input class="txt w184p Wdate" type="text"
									name="planYear" id="planYear"
									onclick="WdatePicker({dateFmt:'yyyy'})" readonly="readonly"
									value="<s:property value="%{planYear}" escape="true"/>"
									onblur="upms.upmsUtils.blurTextCheck(this,'计划年度',1,-1);"
									onfocus="upms.upmsUtils.textFocus(this);" /> <s:hidden
										id="hiddenplanYear" name="hidden" value="计划年度,1,-1"></s:hidden>
								</td>
							</tr>
							<tr>
								<td align="right">计划批次&nbsp;</td>
								<td><s:select list="planBatchList" listKey="itemId"
										label="abc" listValue="itemName" id="planBatch"
										name="planBatch" style="width:15.5em;"
										onblur="upms.upmsUtils.blurTextCheck(this,'计划批次');"
										onfocus="upms.upmsUtils.textFocus(this);"></s:select> <s:hidden
										id="hiddenplanBatch" name="hidden" value="计划批次"></s:hidden>
								</td>
							</tr>
						</table>
					</form>
				</div>
				<div style="text-align: center">
					<input class="button" type="button" id="saveBtn" value="保存" /> <input
						class="button" type="button" id="backBtn" value="返回" />
				</div>
				<!-- 查询结果列表S -->
				<div id="resultDiv"></div>
				<!-- 查询结果列表E -->
			</div>
		</div>
	</div>
</div>