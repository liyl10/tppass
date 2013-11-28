<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/supervisor/other/js/supervisor_promise.js"></script>
<div align="center" style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">项目承担单位真实性承诺</div>
				<table width="100%">
					<tr>
						<td colspan="6">
							<h2 align="center">本单位保证上述填报内容及所提供的附件材料真实可靠。</h2>
						</td>
					</tr>
					<tr><td colspan="6">&nbsp;</td></tr>
					<tr><td colspan="6">&nbsp;</td></tr>
					<tr>
					  <td width="56%">
						<div align="center"><strong>单位负责人（签章）：&nbsp;&nbsp;</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </div></td>
					  <td colspan="5"><strong>填报单位公章：</strong></td>
					</tr>
					<tr>
						<td colspan="6">&nbsp;</td>
				  	</tr>
					<tr>
					  <td><div align="right"></div></td>
					  <td width="7%"><strong>年 </strong></td>
					  <td width="7%"><strong> 月</strong></td>
					  <td width="24%"><strong>日</strong></td>
					  <td width="3%">&nbsp;</td>
					  <td width="3%">&nbsp;</td>
				  </tr>
					<tr>
						<td colspan="6"><div align="right"></div></td>
				    </tr>
				</table>
			</div>
			<s:hidden id="isEdit" name="isEdit" value="%{isEdit}"></s:hidden>
			<s:hidden id="supervisorId" name="supervisorId" value="%{supervisorId}"></s:hidden>
			<div align="center">
				<input type="button" class="button save" id="nextBut" name="nextBtu" value="下一步"/>
			</div>
		</div>
	</div>
</div>