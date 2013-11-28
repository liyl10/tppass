<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/contract/other/js/contract_know.js"></script>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
<div style="text-align: left;">
	<div class="Servicel04">
		<div class="abuot02">
			<div class="abuot07">填表说明（不列入合同书）</div>
			<div class="abuot03">
<s:hidden id="tcontractId" name="tcontractId" value="%{tcontractId}"></s:hidden>
<s:hidden id="Flag" name="Flag" value="%{Flag}"></s:hidden>
<s:hidden id="contractStatus" name="contractStatus" value="%{contractStatus}"></s:hidden>
<s:hidden id="modelType" name="modelType" value="%{modelType}"></s:hidden>
<table width="100%">
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
1.封面：项目名称为两行，集团项目课题名称为楷体（字体改变以示区别），写在第二行；项目编号中以（n）标出课题次序，以示区别，不细分课题者不加“（）”。
</td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
2. 合同书封面、合同书“一、1.、2.”项目课题名称、财政科研经费、承担单位等信息与计划文件（发文）一致，项目有课题者名称间用“——”连接。 
</td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
3. 合同书“一、5.”项目（课题）实施进度以6个月为一个阶段安排，并都应有可考核指标，各计划类别起始时间、完成时间以计划文件为准。
</td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
4. 合同书“一、4.、6.”技术、经济指标要切实可行，与计划文件一致。各项目（课题）成果要有“专利”申请和授权数指标，同时描述实施期间项目单位“知识产权”创造和保护情况。
</td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
5. 合同书“二、2.”科研经费支出栏中不再设“人员费”，安排“劳务费”、“专家咨询费”。
</td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
6.合同签约方乙方（承担单位）户名、开户银行与行号、银行账号信息要准确，并在电子版合同中列出，以便核对。
</td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
7.电子版模版中涂色部分用具体内容替换。
</td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
8. 2009年度甲方为预算数的70%。2010年度及以后甲方拨款先作出预算，由项目单位垫支，待项目验收通过后一次拨付。
</td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
9.劳务咨询费限支付在本单位无经常性工资收入的临时聘用人员及外单位咨询专家的费用。
</td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
10.合同各方在同一页内签约。电子版与纸件合同要完全一致，否则不予拨款。
</td></tr>
</table>
<br/>
<div align="center" style="width: 100%">
	<input class="button save" id="nextBtn" name="button" type="button" href="javascript: void(0);" onclick="nextBtn();" value="下一步"/>
</div>
</div>
</div>
</div>
</div>
</div>