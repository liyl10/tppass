<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/super/js/expert_review_comments_copy.js"></script>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
<div style="text-align: left;">
	<div class="Servicel04">
		<div class="abuot02">
			<div class="abuot07">复用专家评估模板</div>
			<div class="abuot03">
<!-- 保存按钮提示信息 -->
<label id="comfirmSave" style="display: none"><s:text name="confirm_save_info"/></label>
<s:hidden id="typeId" name="typeId" value="%{typeId}"></s:hidden>
<s:hidden id="planFlagId" name="planFlagId" value="%{planFlagId}"></s:hidden>
<!-- 下一步按钮提示信息 -->
<label id="comfirmSaveNext" style="display: none"><s:text name="confirm_save_and_next_info"/></label>
<table width="100%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
	<tr>
		<td width="40%" style="white-space:nowrap;width:10%;text-align:right;padding:2 2 10 10;font-size:105%">
			项目分类
		&nbsp;</td>
		<td width="60%" style="white-space:nowrap;width:20%;padding:2px;">		
			<s:select style="width:15em;" list="copyList" label="abc" listKey="key"
				listValue="name" id="copyId1" name="texpertReviewComments.typeId" 
				value="%{texpertReviewComments.typeId}" onblur="upms.upmsUtils.blurTextCheck(this,'项目分类');" onfocus="upms.upmsUtils.textFocus(this);"></s:select>
				<s:hidden id="copyId1Value" value="%{texpertReviewComments.typeId}"></s:hidden>
			<s:hidden id="hiddencopyId1" name="hidden" value="项目分类"></s:hidden>	
		&nbsp;</td>
	</tr>
	<tr>
		<td width="40%" style="white-space:nowrap;width:10%;text-align:right;padding:2 2 10 10;font-size:105%">
			专家评估模板类型
		&nbsp;</td>
		<td width="60%" style="white-space:nowrap;width:20%;padding:2px;">		
			<s:select style="width:15em;" list="modelList" label="abc" listKey="key1"
				listValue="name1" id="copyId2" name="texpertReviewComments.expertType" 
				value="%{texpertReviewComments.expertType}" onblur="upms.upmsUtils.blurTextCheck(this,'专家评估模板');" onfocus="upms.upmsUtils.textFocus(this);"></s:select>
				<s:hidden id="copyId2Value" value="%{texpertReviewComments.expertType}"></s:hidden>
			<s:hidden id="hiddencopyId2" name="hidden" value="专家评估模板"></s:hidden>	
		&nbsp;</td>
	</tr>

 </table>
<div align="left">
	<em class=requirecolor id="errexpertReview" name="errexpertReview"></em><br/>
</div>
<div align="center">
	<!-- <tag:auth code="ss.expertreviewcomments.insertBtn"> -->
		<input type="button" id="okBtn" class="button add" href="javascript: void(0);" value="保存">
	<!-- </tag:auth> -->
	<input type="button" id="backBtn" class="button add" href="javascript: void(0);"  value="返回">
</div>

</div>
</div>
</div>
</div>
</div>
