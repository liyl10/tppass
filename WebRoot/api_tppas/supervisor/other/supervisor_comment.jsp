<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/supervisor/other/js/supervisor_comment.js"></script>
<div align="center" style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">填表说明</div>
				<table width="100%">
				<tr><td>
					1、数据应确切可靠，数据有小数时，按四舍五入精确到小数点后两位填写。
				</td></tr>
				<tr><td>&nbsp;</td></tr>
				<tr><td>
					2、随表应附材料包括：
				</td></tr>
					<tr><td>
					&nbsp;&nbsp;&nbsp;&nbsp;1）最近一个月的财务报表（现金流量、损益和资产负债表）；</td></tr>
						<tr><td>
						&nbsp;&nbsp;&nbsp;&nbsp;2）项目支出明细清单（参照合同的支出预算分类列出主要支出范围与资金）；
						</td></tr>
							<tr><td>
								&nbsp;&nbsp;&nbsp;&nbsp;3）报告期内购买固定资产的清单和发票复印件；产品销售证明（合同、发票）；
							</td></tr>
								<tr><td>&nbsp;</td></tr>
				<tr><td>
					3、表中“财政资金”为科技局拨款，“配套资金”为项目归口管理部门拨款。
				</td></tr>
				</table>
				<s:hidden id="supervisorId" name="supervisorId" value="%{supervisorId}"></s:hidden>
				<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
				<s:hidden id="isEdit" name="isEdit" value="%{isEdit}"></s:hidden>
			</div>
			<div align="center" style="width: 95%">
				<a class="button" id="nextBut" name="nextBut">下一步</a>
			</div>
		</div>
		
	</div>
</div>