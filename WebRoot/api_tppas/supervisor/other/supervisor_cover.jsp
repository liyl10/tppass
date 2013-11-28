<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/supervisor/other/js/supervisor_cover.js"></script>
<!-- 保存按钮提示信息 -->
<label id="comfirmSave" style="display: none"><s:text name="confirm_save_info"/></label>
<label id="comfirmNext" style="display: none"><s:text name="confirm_save_and_next_info"/></label>
	<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">
				  <p>西安市科技计划项目中期监理信息表</p>
				  <p align="center">（<s:property value="%{tprojectApplication.reportYear}" escape="true"/>年度）</p>
				</div>
				<div class="abuot03">
					<table width="100%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
					  <tr>
					    <td width="33%" align="right">项目名称</td>
					   	<td colspan="5">
					   		<s:property value="%{tprojectApplication.projectName}" escape="true"/>
					    </td>
					  </tr>
					  <tr>
					    <td width="33%" align="right">项目编号</td>
					    <td colspan="5">
					    	<s:property value="%{tprojectApplication.projectNumber}" escape="true"/>
					    </td>
					  </tr>
					  <tr>
					    <td width="33%" align="right">项目执行期</td>
					    <td colspan="5">
					    	<s:date name="%{tprojectApplication.startTime}" format="yyyy年MM月dd日" />
					    	--
					    	<s:date name="%{tprojectApplication.endTime}" format="yyyy年MM月dd日" />
					    </td>
					  </tr>
					  <tr>
					    <td width="33%" align="right">项目计划类别</td>
					    <td colspan="5">
					    	<s:property value="%{tprojectApplication.planFlag}" escape="true"/>
					    </td>
					  </tr>
					  <tr>
					    <td width="33%" align="right">承担单位</td>
					    <td colspan="5">
					    	<s:property value="%{tprojectApplication.applicationUnit}" escape="true"/>
					    </td>
					  </tr>
					  <tr>
					    <td width="33%" align="right">合作单位</td>
					    <td colspan="5">
					    	<s:property value="%{tprojectInfoB.assistUnit}" escape="true"/>
					    </td>
					  </tr>
					  <tr>
					    <td width="33%" align="right">归口管理单位</td>
					    <td colspan="5">
							<s:property value="%{tprojectApplication.centralizedType}" escape="true"/>
						</td>
					  </tr>
					  <tr>
					    <td align="right">资助金额</td>
					    <td colspan="5">
					    	<s:property value="%{tcontractContentsB.researchFunding}" escape="true"/>（万元）    
					    </td>
					  </tr>
					  <tr>
					    <td align="right">详细地址</td>
					    <td colspan="5">
					    	<s:property value="%{tprojectInfoB.unitAddress}" escape="true"/>
						</td>
					  </tr>
					  <tr>
					    <td align="right">项目负责人</td>
					    <td>
					    	<s:property value="%{tprojectInfoB.projectPerson}" escape="true"/>
					    </td>
					    <td width="7%" align="right">电话</td>
					    <td width="14%">
					    	<s:property value="%{tcontractCoverA.chargePhone1}" escape="true"/>
					    </td>
					    <td width="5%" align="right">手机</td>
					    <td width="25%">
					    	<s:property value="%{tcontractCoverA.chargePhone2}" escape="true"/>
					    </td>
					  </tr>
					  <tr>
					    <td style="padding: 4px 3px; text-align: right">填  报  人</td>
					    <td>
					    	<input type="text" id="writePerson" name="tsupervisor.writePerson"  value="<s:property value='%{tsupervisor.writePerson}' escape='true'/>"  class="inputA" style="width: 100px; " maxlength="15"/>
					    </td>
					    <td style="padding: 4px 3px; text-align: right">电话</td>
					    <td>
					    	<input type="text" id="writeTel" name="tsupervisor.writeTel"  value="<s:property value='%{tsupervisor.writeTel}' escape='true'/>"  class="inputA" style="width: 100px; " maxlength="12" 
					    	onblur="upms.upmsUtils.blurTextCheck(this,'填报人电话',1,1)" onfocus="upms.upmsUtils.textFocus(this);"/>
					    	<s:hidden id="hiddenwriteTel" name="hidden" value="填报人电话,1,1"></s:hidden>
					    </td>
					    <td style="padding: 4px 3px; text-align: right">手机</td>
					    <td>
					    	<input type="text" id="writeMobile" name="tsupervisor.writeMobile"  value="<s:property value='%{tsupervisor.writeMobile}' escape='true'/>"  class="inputA" style="width: 100px; " maxlength="11" 
					    	onblur="upms.upmsUtils.blurTextCheck(this,'填报人手机',1,0)" onfocus="upms.upmsUtils.textFocus(this);"/>
					    	<s:hidden id="hiddenwriteMobile" name="hidden" value="填报人手机,1,0"></s:hidden>
					    </td>
					  </tr>
					  <tr>
					    <td align="right">填报时间</td>
					    <td colspan="5">
					    	<s:date name="%{tprojectApplication.writeReportTime}" format="yyyy-MM-dd" />
					    </td>
					  </tr>
					</table>
					</br>
					</br>
					</br>
					</br>
					<div align="center" >西安市科学技术局制表</div>
					<br/>
					<br/>
					<s:hidden id="projectId" name="projectId" value="%{projectId}"></s:hidden>
					<s:hidden id="supervisorId" name="supervisorId" value="%{supervisorId}"></s:hidden>
					<s:hidden id="isEdit" name="isEdit" value="%{isEdit}"></s:hidden>
					<div align="center">
						<s:if test="%{isEdit==1}">
							<input  type="button" class="button add" id="saveBut" name="saveBut" href="javascript: void(0);"  value="保存">
							&nbsp;
							<input type="button" class="button save" id="nextBut" name="nextBut" href="javascript: void(0);" value="下一步"/>
						</s:if>
						<s:else>
							<input type="button" class="button save" id="nextStep" name="nextStep" href="javascript: void(0);" value="下一步"/>
						</s:else>
					</div>
	 			</div>
 	 		</div>
   		</div>
  	</div>
</div>
