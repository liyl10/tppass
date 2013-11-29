<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/acceptance/highTech/js/acceptance_a_submit.js"></script>

<label id="projectErr" style="display: none"><s:text name="contract_err"/></label>
<label id="comfirmSubmit" style="display: none"><s:text name="confirm_submit_info"/></label>
<input type="hidden" id="acceptanceId" name="acceptanceId" value="<s:property value='acceptanceId' escape='true'/> " />
<input type="hidden" id="msgErr" name="msgErr" value="<s:property value='%{msgErr}' escape='true'/> " />
<input type="hidden" id="isPass" name="isPass" value="<s:property value='%{isPass}' escape='true'/> " />
	<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">提交项目验收表</div>
				<div class="abuot03">
<table width="100%" border="0" class="t-list"  cellspacing="0" cellpadding="0">
  <tr>
    <th width="12%"><div align="center">序号</div></th>
    <th width="59%"><div align="center">数据类型</div></th>
    <th width="29%"><div align="center">数据是否存在</div></th>
  </tr>
  <s:iterator status="rowStatus" value="submitHighTechAcceptanceList">
	<tr>
		<td align="left">${rowStatus.index+1}</td>
		<td align="left"><s:property value='%{name}' escape='true' /></td>
		<td align="left"><s:property value='%{isExist}' escape='true' /></td>
	</tr>
  </s:iterator>
</table>
<br/>
<table width="100%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
  <tr>
    <td><div align="right">处室意见
      <div align="right">（1000字以内）</div>
    </div></td>
      <td><textarea name="textarea2"  class="inputA"  style="width:700px; height:200px" onblur="upms.upmsUtils.blurTextCheck(this,'处室意见',1,8,1000);" onfocus="upms.upmsUtils.textFocus(this);" onKeyUp="this.value = upms.upmsUtils.checkTextareaLength(this.value, 1000);"><s:property value='%{tacceptance.acceptanceId}' escape='true'/></textarea>
      <s:hidden id="hiddenpresideOpinion" name="hidden" value="处室意见,1,8,1000"/></td>
  </tr>
  <tr>
    <td><div align="right">验收专家意见
      <div align="right">（1000字以内）</div>
    </div></td>
    <td><textarea name="textarea2"  class="inputA"  style="width:700px; height:200px" onblur="upms.upmsUtils.blurTextCheck(this,'验收专家意见',1,8,1000);" onfocus="upms.upmsUtils.textFocus(this);" onKeyUp="this.value = upms.upmsUtils.checkTextareaLength(this.value, 1000);"><s:property value='%{tacceptance.acceptanceId}' escape='true'/></textarea>
      <s:hidden id="hiddenpresideOpinion" name="hidden" value="验收专家意见,1,8,1000"/></td>
  </tr>
  <tr>
    <td><div align="right">处置结果
      <div align="right">（1000字以内）</div>
    </div></td>
    <td><textarea name="textarea2"  class="inputA"  style="width:700px; height:200px" onblur="upms.upmsUtils.blurTextCheck(this,'处置结果',1,8,1000);" onfocus="upms.upmsUtils.textFocus(this);" onKeyUp="this.value = upms.upmsUtils.checkTextareaLength(this.value, 1000);"><s:property value='%{tacceptance.acceptanceId}' escape='true'/></textarea>
      <s:hidden id="hiddenpresideOpinion" name="hidden" value="处置结果,1,8,1000"/></td>
  </tr>
</table>
<br/>
<div id="errInfo" class="requirecolor"></div>
<div align="center">
	<input type="button" class="button add" id="submitBtn1" name="submitBtn1" href="javascript: void(0);" onclick="submitInfo('1')" value="验收合格">
	<input type="button" class="button add" id="submitBtn2" name="submitBtn2" href="javascript: void(0);" onclick="submitInfo('2')" value="验收基本合格">
	<input type="button" class="button add" id="submitBtn3" name="submitBtn3" href="javascript: void(0);" onclick="submitInfo('3')" value="验收不合格">
	<input type="button" class="button add" id="submitBtn4" name="submitBtn4" href="javascript: void(0);" onclick="submitInfo('4')" value="结题">
</div>
	 </div>
 	 </div>
   </div>
  </div>
</div>


