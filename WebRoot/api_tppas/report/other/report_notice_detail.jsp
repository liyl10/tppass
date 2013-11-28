<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/report/other/js/report_notice_detail.js"></script>
<!-- 保存按钮提示信息 -->
<label id="comfirmSave" style="display: none"><s:text name="confirm_save_info"/></label>
<!-- 下一步按钮提示信息 -->
<label id="comfirmSaveNext" style="display: none"><s:text name="confirm_save_and_next_info"/></label>

<!-- 项目ID -->
<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
<s:hidden id="applyStatus" name="applyStatus" value="%{applyStatus}"></s:hidden>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">附件说明</div>
				<table width="100%">
				<tr><td>按照《申报指南》中各计划对“提交材料”的明确要求，添加可行性报告或商业计划书等申报材料及附件。</td></tr>
				<tr><td>&nbsp;</td></tr>
				<tr><td>特别对多个单位联合申报的项目，应提供合作协议，并在协议中明确各自的责任、技术合作方式、产权归属、投入比例、收益分配等。对申报单位</td></tr>
				<tr><td>&nbsp;</td></tr>
				<tr><td>对申报单位有自筹资金要求的项目，须提供自筹资金承诺函，并明确自筹资金来源。 </td></tr>
				<tr><td>&nbsp;</td></tr>
				<tr><td>附件无须上传，只是与纸质材料一起装订即可。 </td></tr>
				</table>
				<div align="center" style="width: 100%">
					<br> <br>
					<input id="nextBtn" class="button save" name="button" type="button" href="javascript: void(0);" value="下一步"/>
				</div>
			</div>
		</div>
	</div>
</div>