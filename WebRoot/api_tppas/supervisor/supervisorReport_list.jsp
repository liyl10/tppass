<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/supervisor/js/supervisorReport_list.js"></script>
<label id="comfirmDelete" style="display: none"><s:text name="confirm_del_info"/></label>
<div id="resultDiv">
	<div align="center"
		style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
		<div style="text-align: left;">
			<div class="Servicel04">
				<div class="abuot02">
					<div class="abuot07">监理报告</div>
					<div style="border-bottom: 1px dashed #C9DEEE;"></div>
					<s:hidden id="supervisorId" value="%{supervisorId}"/>
					<s:hidden id="projectId" value="%{projectId}"/>
					<div style="text-align: right;">
						<input type="button" class="button" name="goExportBtn"
							id="goExportBtn" value="添加监理点" onclick="showPointInsert('${supervisorId}','${projectId}');" />
					</div>
					<!-- 查询结果列表S -->
					<div id="resultDiv">
						<table class="t-list">
							<tr align="center">
								<th>项目编号</th>
								<th>项目名称</th>
								<th>计划监理日期</th>
								<th>报告时间</th>
								<th>报告类型</th>
								<th>状态</th>
								<th align="center">操作</th>
							</tr>
							<s:if test="pager.list.size > 0">
								<s:iterator value="pager.list" status="rowData">
									<tr>
										<td><s:property value='%{projectApplication.projectNumber}' /></td>
										<td><s:property value='%{projectApplication.projectName}' /></td>
										<td>
											<s:if test="%{tsupervisorPoint!=null}">
												<s:date name="%{tsupervisorPoint.pointTime}" format="yyyy-MM-dd "></s:date>
											</s:if>
										</td>
										<td><s:date name="%{submitTime}" format="yyyy-MM-dd HH:mm:ss"></s:date></td>
										<td><!--<s:property value='%{reportType}' />-->${reportType==0?"自发报告":"监理点报告"}</td>
										<td>
											<s:if test="%{checkState==0}">
												未填写
											</s:if>
											<s:elseif test="%{checkState==1}">
												未审查
											</s:elseif>
											<s:elseif test="%{checkState==2}">
												已审查
											</s:elseif>
										</td>
										<td align="center">
											<s:if test="%{checkState==0}">
												<a href="javascript: void(0);" class="uline single" onclick="showPointModify('${tsupervisorPoint.pointId}','${supervisorId}','${projectApplication.projectId}');">
													修改监理点
												</a>
												<a href="javascript: void(0);" class="uline single" onclick="showPointDelete('${tsupervisorPoint.pointId}','${supervisorId}','${projectApplication.projectId}');">
													删除监理点
												</a>
											</s:if>
											<s:else>
												<a href="javascript: void(0);" class="uline single" onclick="showReportDetail('${reportId}','${supervisorId}','${projectApplication.projectId}');">
												报告详细
												</a>
												<s:if test="%{checkState==1}">
													<a href="javascript: void(0);" class="uline single" onclick="showReportAudit('${reportId}','${supervisorId}','${projectApplication.projectId}');">
														审查报告
													</a>
												</s:if>
											</s:else>
										</td>
									</tr>
								</s:iterator>
							</s:if>
							<s:else>
								<tr>
									<td colspan="7" align="left">没有查到任何记录!&nbsp;</td>
								</tr>
							</s:else>
						</table>
						<!-- 分页显示 -->
						<s:if test="pager.list.size > 0">
							<div class="page">
								<div class="pgtotal">
									共<em>${pager.totalCount}</em>条记录;
								</div>
								<div class="pgtotal">
									总共<em>${pager.pageCount}</em>页
								</div>
								<span> 跳转至第 <input type="text" id="goPageNo"
									name="goPageNo" style="width: 30px; height: 16px;"
									onkeyup='this.value=this.value.replace(/[^0-9]\D*$/,"")'
									autocomplete="off" /> 页 <input type="button" class="button"
									style="margin: -0.2em" value="确定" id="goBtn" name="goBtn" />
								</span> <span id="pgbtn"></span>
								<div class="clear"></div>
								<input type="hidden" id="pageNo" name="pager.pageNumber"
									value="${pager.pageNumber}" /> <input type="hidden"
									id="totalRecords" name="pager.totalCount"
									value="${pager.totalCount}" /> <input type="hidden"
									id="totalPages" name="pager.pageCount"
									value="${pager.pageCount}" />
							</div>
						</s:if>
					</div>
					<!-- 查询结果列表E -->
				</div>
			</div>
		</div>
	</div>
</div>

