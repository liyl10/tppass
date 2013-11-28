<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/report/js/before_review_submit.js"></script>
<div align="center"
	style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">项目初审</div>
				<div class="abuot03">
					<s:hidden id="projectId" value="%{projectId}"></s:hidden>
					<table width="100%" border="0" class="t-entRegFrm" cellspacing="0"
						cellpadding="0">
						<tr>
							<td align="right" style="width: 20%"><FONT color=red>*</FONT>初审意见（1000字以内）</td>
							<td style="width: 80%"><s:textarea id="beforeReviewComment"
									value="%{beforeReviewComment}" rows="10" cols="80"
									cssStyle="resize: none;"
									onblur="upms.upmsUtils.blurTextCheck(this,'初审意见',1,8,1000)"
									onfocus="upms.upmsUtils.textFocus(this)"
									onKeyUp="upms.upmsUtils.checkTextareaLength(this, 1000);"></s:textarea>
								<s:hidden id="hiddenbeforeReviewComment" name="hidden"
									value="初审意见,1,8,1000"></s:hidden></td>
						</tr>
					</table>
				</div>
				<div align="center">
					<input type="button" class="button add"
						onClick="save('${projectId}')" value="保存"> <input
						type="button" class="button add" onClick="agree('${projectId}')"
						value="同意"> <input type="button" class="button add"
						onClick="disagree('${projectId}')" value="不同意（可修改）"> <input
						type="button" class="button add"
						onClick="disAgreeBeforeReviewUnedit('${projectId}')"
						value="不同意（不可修改）"> <input type="button" class="button add"
						onClick="applyRedistribute('${projectId}')" value="申请调配">

				</div>
			</div>
		</div>
	</div>
</div>
