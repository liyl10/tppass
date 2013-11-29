<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/contract/other/js/contract_obligation.js"></script>
<div style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
<div style="text-align: left;" >
	<div class="Servicel04">
		<div class="abuot02">
			<div class="abuot07">合同说明</div>
<s:hidden id="tcontractId" name="tcontractId" value="%{tcontractId}"></s:hidden>
<s:hidden id="Flag" name="Flag" value="%{Flag}"></s:hidden>
<s:hidden id="contractStatus" name="contractStatus" value="%{contractStatus}"></s:hidden>
<s:hidden id="contractContentsBId" name="tcontractContentsB.contractContentsBId" value="%{tcontractContentsB.contractContentsBId}"></s:hidden>
<!-- 保存按钮提示信息 -->
<label id="comfirmSave" style="display: none"><s:text name="confirm_save_info"/></label>
<!-- 下一步按钮提示信息 -->
<label id="comfirmSaveNext" style="display: none"><s:text name="confirm_save_and_next_info"/></label>	
<table width="100%" border="0" cellspacing="0" cellpadding="0">		
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<strong>三、各方的权利义务</strong>
</td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
第一条   缔约各方均应共同遵守国家、省、市有关科技计划与经费管理的规定，严格遵守并认真履行本合同的各项条款。 
</td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
第二条   甲方应按合同约定的金额提供项目科研经费，监督、检查合同履行情况。合同履行期间，甲方有权直接组织或委托丙方检查、监督乙方对本合同的履行情况。乙方完成项目研究开发任务后，由甲方负责进行验收。
</td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
第三条  乙方应严格履行合同义务，使用项目经费应按照合同约定的支出范围执行，保证专款专用，并实行独立核算，严禁弄虚作假、截留和挪用项目经费等违反财经纪律的行为；按甲方要求报告工作进展情况和重大问题。
</td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
第四条  丙方应匹配项目约定的科研经费；督促项目责任人报告年度执行情况；协助科技局对项目执行情况进行检查或评估；督促项目责任人申请知识产权和进行科技成果登记； 协助科技行政部门协调有关问题。
</td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
第五条  甲、乙、丙各方对项目合同及其他技术资料负有保密责任。本项目研究取得的技术成果，其知识产权归属及成果转化，按国家和本省的有关规定执行。上述技术成果涉及国家利益的，乙方有偿转让之前，应经过甲方的审查批准；涉及国家机密的，按国家《保密法》有关规定执行。
</td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<strong>四、违约责任</strong></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
第六条  甲方不履行合同内容，导致乙方研究开发工作延误的，所拨科研经费不予追回。
</td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
第七条  因乙方原因，导致研究开发工作未能达到合同约定指标的，乙方应采取措施尽快使项目达到合同预定要求，并承担由此而增加的费用。
</td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
第八条  乙方无正当原因未履行合同时，甲方有权停拨、追缴部分或全部甲方所拨科研经费，由此造成的经济损失由违约方承担。
</td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
第九条  乙方违反经费使用规定或经甲方检查确认计划进度不符合合同约定的，甲方有权减拨或停拨后续经费；情节严重的，甲方有权终止合同，乙方应返还甲方已拨付的全部经费。
</td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
第十条  乙方因不可抗力不能履行合同义务时，可以免除违约责任，但应及时通知甲、丙方，并在合理的期限内出具因不可抗力导致合同不能履行的证明。
</td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
第十一条 乙方违规使用科研经费或将科研经费挪作他用的，甲方在三年内不受理该负责人和承担单位项目申报；情节严重的，将追究相关责任。
</td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<strong>五、合同变更、解除和争议解决</strong></td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
第十二条  合同的变更或解除，须经缔约各方协商一致，签署书面文件，并作为本合同的组成部分。
</td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
第十三条  当事人一方逾期半年不履行合同规定的义务，对方有权解除合同，并追究违约责任。
</td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
第十四条  变更或解除合同造成的损失由双方协商或按责任原则分别承担。
</td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
第十五条 合同一方发生合并、分立或更名时，由变更后的单位继受或分别继受变更一方在合同中的权利义务。
</td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
第十六条  合同在履行过程中发生争议的，缔约各方应通过友好协商的方式解决。如协商不成时，缔约各方有权向人民法院起诉或仲裁机构申请仲裁，但在有关司法、仲裁结果生效之前，乙方有义务按照甲方要求继续履行或终止履行本合同。
</td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<strong>六、附则</strong></td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
第十七条 有关合同的未尽事宜，按照国家、省有关科技计划与经费管理的规定执行。
</td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
第十八条 本合同经签约各方签字盖章后生效，合同文本一式五份，甲方存三份（并电子版一份），乙方存一份，丙方存一份。
</td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
第十九条 本合同由甲方负责解释。
</td></tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	  <tr height="30px">
		<td align="left">
		&nbsp;&nbsp;甲方（委托单位）：<s:property value='%{entrustmentCompany}' escape='true'/>
		</td>
	  </tr>
	  <tr height="30px">
		<td align="left">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;项 目 负 责 人（签名）：
		</td>
	  </tr>
	  <tr height="30px">
		<td align="left">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;项 目 负 责 人（签名）：
		</td>
	  </tr>
	  <tr height="30px">
		<td align="right">
			（公 章）&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
	  </tr>
	  <tr height="40px">
	  	<td align="right">
		  	<FONT color=red>*</FONT><INPUT class="txt w184p Wdate" type="text" name="tcontractContentsB.selectTime1" 
			  	id="selectTime1" 
			  	value="<s:property value='%{getText("{0,date,yyyy-MM-dd}",{tcontractContentsB.selectTime1})}' />" 
			  	readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" 
			  	onblur="upms.upmsUtils.blurTextCheck(this,'甲方（委托单位）的日期',1,-1);" 
        		onfocus="upms.upmsUtils.textFocus(this)" readonly="readonly"/>
			  	<s:hidden id="hiddenselectTime1" name="hidden" value="甲方（委托单位）的日期,1,-1"></s:hidden>
	  	</td>
	  </tr>
	  <tr height="30px">
		<td align="left">
			&nbsp;&nbsp;乙方（承担单位）：<s:property value='%{tcontract.TprojectApplication.applicationUnit}' escape='true'/> 
		</td>
	  </tr>
	  <tr height="30px">
		<td align="left">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;法人代表  （签名）：
		</td>
	  </tr>
	 <tr height="30px">
		<td align="left">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;项目负责人（签名）：
		</td>
		</tr>
	  <tr height="30px">
		<td align="left">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<FONT color=red>*</FONT>开户银行与行号：
			<input type="text" class="inputA" id="bank" maxlength="50" 
			    name="tcontractContentsB.bank" 
				value="<s:property value='%{tcontractContentsB.bank}' escape='true'/>" 
				onblur="upms.upmsUtils.blurTextCheck(this,'开户银行与行号',1,-1);" 
        		onfocus="upms.upmsUtils.textFocus(this)" />
				<s:hidden id="hiddenbank" name="hidden" value="开户银行与行号,1,-1"></s:hidden>
		</td>
	  </tr>
	  <tr height="30px">
		<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<FONT color=red>*</FONT>银行帐号：
			<input type="text" class="inputA" maxlength="20" id="bankAccount" 
			    name="tcontractContentsB.bankAccount" 
				value="<s:property value='%{tcontractContentsB.bankAccount}' escape='true'/>" 
				onblur="upms.upmsUtils.blurTextCheck(this,'银行账号',1,9);" 
        		onfocus="upms.upmsUtils.textFocus(this)" 
				style="ime-mode: disabled;" onkeypress="return upms.upmsUtils.isNum(event,this)"/>
				<s:hidden id="hiddenbankAccount" name="hidden" value="银行帐号,1,9"></s:hidden>
		</td>
	  </tr>
	  <tr height="30px">
		<td align="right">
			（公 章）&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
	  </tr>
	  <tr height="40px">
	  	<td align="right">
		  	<FONT color=red>*</FONT><INPUT type="text"  class="txt w184p Wdate" name="tcontractContentsB.selectTime2" 
			  	id="selectTime2" 
			  	value="<s:property value='%{getText("{0,date,yyyy-MM-dd}",{tcontractContentsB.selectTime2})}' />" 
			  	readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" 
			  	onblur="upms.upmsUtils.blurTextCheck(this,'乙方（承担单位）的日期',1,-1);" 
        		onfocus="upms.upmsUtils.textFocus(this)" readonly="readonly"/>
		  		<s:hidden id="hiddenselectTime2" name="hidden" value="乙方（承担单位）的日期,1,-1"></s:hidden>
	  	</td>
	  </tr>
	  <tr height="30px">
	    <td align="left">
	    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;协作单位（签字、加章）
	    </td>
	  </tr>
	  <tr height="30px">
	    <td align="left">&nbsp;</td>
	  </tr>
	  <tr height="30px">
	    <td align="left">&nbsp;</td>
	  </tr>
	  <tr height="30px">
		<td align="left">
			&nbsp;&nbsp;丙方（归口管理单位）：<s:property value='%{centralizedManagement}' escape='true'/>
		</td>
	  </tr>
	  <tr height="30px">
		<td align="left">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;单位负责人（签名）：
		</td>
	  </tr>
	  <tr height="30px">
		<td align="left">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;经  办  人（签名）：
		</td>
	  </tr>
	  <tr height="30px">
		<td align="right">
			（公 章）&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
	  </tr>
	  <tr height="30px">
	  	<td align="right">
		  	<FONT color=red>*</FONT><INPUT class="txt w184p Wdate" type="text" name="tcontractContentsB.selectTime3" 
		  		id="selectTime3" 
		  		value="<s:property value='%{getText("{0,date,yyyy-MM-dd}",{tcontractContentsB.selectTime3})}' />" 
		  		readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" 
		  		onblur="upms.upmsUtils.blurTextCheck(this,'丙方（归口管理单位）的日期',1,-1);" 
        		onfocus="upms.upmsUtils.textFocus(this)" readonly="readonly"/>
			  	<s:hidden id="hiddenselectTime3" name="hidden" value="丙方（归口管理单位）的日期,1,-1"></s:hidden>
	  	</td>
	  </tr>
	</table>
	<br/>
<div align="center">
	<s:if test="%{Flag==0}">
		<input  type="button" id="okBtn" class="button add" href="javascript: void(0);" value="保存">
		&nbsp;
		<input  type="button" id="nextBtn" class="button next" href="javascript: void(0);" value="下一步">
	</s:if>
	<s:else>
		<input  type="button" id="nextBtn1" class="button next" href="javascript: void(0);" value="下一步">
	</s:else>
</div>
</div>
</div>
</div>
</div>