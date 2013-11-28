<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_scenter/js/page.js" ></script>
<!-- 
@comment 分页页面
@author dulei(dulei@hopsun.cn)
@date 2013-01-10
@version 1.0
 -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="page">
  <tr>
    <td align="center" class="pn-sp"> 共<s:property value="pager.totalCount" /> 条&nbsp;
      每页
      <input type="text" id="page_size" name="pager.pageSize" value="${pager.pageSize}" style="width:30px" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" />
      条&nbsp;
      <input class="first-page" type="button" value="首 页" onClick="_gotoPage('1');" <s:if test="pager.pageCount<=1||pager.pageNumber<=1">disabled="disabled"</s:if> />
      <input class="pre-page" type="button" value="上一页" onClick="_gotoPage('<s:property value="pager.pageNumber-1" />');" <s:if test="pager.pageCount<=1||pager.pageNumber<=1">disabled="disabled"</s:if>/>
      <input class="next-page" type="button" value="&nbsp;&nbsp;下一页" onClick="_gotoPage('<s:property value="pager.pageNumber+1" />');" <s:if test="pager.pageNumber>=pager.pageCount">disabled="disabled"</s:if> />
      <input class="last-page" type="button" value="&nbsp;&nbsp;尾 页" onClick="_gotoPage('<s:property value="pager.pageCount" />');" <s:if test="pager.pageNumber>=pager.pageCount">disabled="disabled"</s:if> />
      &nbsp;
      当前 <s:property value="pager.pageNumber" />/<s:if test='pager.pageCount=="0"'>1</s:if><s:else>${pager.pageCount}</s:else>  页 &nbsp;
      转到第
      <input type="text" id="pageNumber" style="width:30px" value="${pager.pageNumber }" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" />
      页
      <input class="go" id="_goPage" type="button" onclick="skip();" value="转" />
    </td>
  </tr>
</table>
<input type="hidden" id="pageNum" name="pager.pageNumber" value="<s:property value="pager.pageNumber" />" />
<input type="hidden" name="pager.pageCount" value="<s:property value="pager.pageCount" />" />