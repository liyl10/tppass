<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/expert/expertManager/js/technology_gain_list.js"></script>
<!-- 删除按钮提示信息 -->
<label id="comfirmDel" style="display: none"><s:text name="confirm_del_info"/></label>	
<div align="center" style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">专业技术研究成果</div>
				<div>
					<div style="float: right;">
				  		<input type="button" class="button" href="javascript: void(0);" onclick="insertTechnology('${expertId}');" value="新增"/>
					</div>
					<table id='testtab' border=0 cellSpacing=0 cellPadding=0 width="100%" class="t-list" >
				        <tr >
				          <th width="8%">序号</th>
						  <th width="30%">项目或课题名称</th>
						  <th width="30%">项目或课题来源</th>
						  <th width="10%">添加日期</th>
						  <th width="22%">操作</th>
				        </tr >
         				<s:if test="pager.list.size > 0">
        					<s:iterator value="pager.list" status="rowData">
						        <tr align=middle>
								  <td align="left">${(pager.pageNumber-1)*pager.pageSize+rowData.count}</td>
								  <td align="left"><s:property value="%{gainName}" escape="true"/></td>
						          <td align="left"><s:property value="%{gainSource}" escape="true"/></td>
								  <td align="left"><s:property value="%{getText('{0,date,yyyy-MM-dd}',{createTime})}" escape="true"/></td>
								  <td align="center">
								  		<a href="javascript: void(0);" onClick="editTechnology('${gainId}','1');">编辑</a>
								  		<a href="javascript: void(0);" onClick="delTechnology('${gainId}','${expertId}');">删除</a>
										<a href="javascript: void(0);" onClick="showTechnology('${gainId}','${isEdit}','0');">查看</a>
								  </td>
						        </tr>
        					</s:iterator>
        				</s:if>
        				<s:else>
        					<tr>
								<td colspan="9">
									没有查到任何记录!&nbsp;
								</td>
							</tr>
        				</s:else>
 					</table>
					<s:if test="pager.list.size > 0">
						<div class="page">
							<div class="pgtotal">共<em>${pager.totalCount}</em>条记录;</div>
							<div class="pgtotal">总共<em>${pager.pageCount}</em>页</div>
							<span> 
								跳转至第
								<input type="text" id="goPageNo" name="goPageNo" style="width: 30px; height: 16px;" onkeyup='this.value=this.value.replace(/[^0-9]\D*$/,"")' autocomplete="off" />
								 页 
								<input type="button" class="button" style="margin: -0.2em" value="确定" id="goBtn" name="goBtn" />
							</span>
							<span id="pgbtn"></span>
							<div class="clear"></div>
							<input type="hidden" id="pageNo" name="pager.pageNumber" value="${pager.pageNumber}" />
							<input type="hidden" id="totalRecords" name="pager.totalCount" value="${pager.totalCount}" /> 
							<input type="hidden" id="totalPages" name="pager.pageCount" value="${pager.pageCount}" />
						</div>
					</s:if>
				</div>
			</div>
		</div>
	</div>
</div>