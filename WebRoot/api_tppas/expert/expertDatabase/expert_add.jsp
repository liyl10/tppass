<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/expert/expertDatabase/js/expert_add.js"></script>
<!-- 保存按钮提示信息 -->
<label id="comfirmSave" style="display: none"><s:text name="confirm_save_info"/></label>
<!-- 修改按钮提示信息 -->
<label id="comfirmUpdate" style="display: none"><s:text name="confirm_update_info"/></label>
<s:hidden id="isSelect" name="isSelect" value="%{expertId}"></s:hidden>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">基本信息</div>
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-entRegFrm">
					<tr height="25px">
						<th colspan="4" align="left">基本信息</th>
					</tr>
					<tr>
						<td align="right" style="width:20%"><font color=red>*</font>姓名</td>
						<td style="width:30%">
							<input type="text" id="expertName" name="texpert.expertName" value="<s:property value='%{texpert.expertName}' escape='true'/>" class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'姓名',1,-1)" onfocus="upms.upmsUtils.textFocus(this);" style="width:85%" maxlength="50"/>
							<s:hidden id="hiddenexpertName" name="hidden" value="姓名,1,-1,50"></s:hidden>
						</td>
						<td align="right" style="width:20%">性别</td>
						<td style="width:30%">
							<s:select id="sex" name="texpert.sex" value="%{texpert.sex}" list="sexList" listKey="itemId" listValue="itemName" style="width:90%"></s:select>
							<s:hidden id="hiddensexTemp" name="hiddensexTemp" value="%{texpert.sex}"></s:hidden>
							<s:hidden id="hiddensex" name="hidden" value="性别"></s:hidden>
						</td>
					</tr>
					<tr>
						<td align="right" style="width:20%">出生年月</td>
						<td style="width:30%">
							<input type="text" id="birthday"  name="texpert.birthday" value="<s:property value='%{getText("{0,date,yyyy-MM-dd}",{texpert.birthday})}' escape='true'/>" class="txt w184p Wdate" readonly="readonly" onClick="WdatePicker()"onblur="upms.upmsUtils.blurTextCheck(this,'出生年月',0,-1)" onfocus="upms.upmsUtils.textFocus(this);" style="width:88%"/>
							<s:hidden id="hiddenbirthday" name="hidden" value="出生年月,0,-1"></s:hidden>
						</td>
						<td align="right" style="width:20%">学历</td>
						<td style="width:30%">
							<s:select id="schooling" name="texpert.schooling" value="%{texpert.schooling}" list="schoolingList" listKey="itemId" listValue="itemName" style="width:90%"></s:select>
							<s:hidden id="hiddenschoolingTemp" name="hiddenschoolingTemp" value="%{texpert.schooling}"></s:hidden>
							<s:hidden id="hiddenschooling" name="hidden" value="学历"></s:hidden>
						</td>
					</tr>
					<tr>
						<td align="right" style="width:20%">学位</td>
						<td style="width:30%">
							<s:select id="expertDegree" name="texpert.expertDegree" value="%{texpert.expertDegree}" list="expertdegreeList" listKey="itemId" listValue="itemName" style="width:90%"></s:select>
							<s:hidden id="hiddenexpertDegreeTemp" name="hiddenexpertDegreeTemp" value="%{texpert.expertDegree}"></s:hidden>
							<s:hidden id="hiddenexpertDegree" name="hidden" value="学位"></s:hidden>
						</td>
						<td align="right" style="width:20%">毕业院校</td>
						<td style="width:30%">
							<input type="text" id="graduateSchool" name="texpert.graduateSchool" value="<s:property value='%{texpert.graduateSchool}' escape='true'/>" class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'毕业院校',0,-1)" onfocus="upms.upmsUtils.textFocus(this);" style="width:85%" maxlength="20"/>				
							<s:hidden id="hiddengraduateSchool" name="hidden" value="毕业院校,0,-1,50"></s:hidden>
						</td>
					</tr>
					<tr>
						<td align="right" style="width:20%">专家职务</td>
						<td style="width:30%">
							<input type="text" id="expertJob" name="texpert.expertJob" value="<s:property value='%{texpert.expertJob}' escape='true'/>" class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'专家职务',0,-1)" onfocus="upms.upmsUtils.textFocus(this);" style="width:85%" maxlength="20"/>				
							<s:hidden id="hiddenexpertJob" name="hidden" value="专家职务,0,-1,50"></s:hidden>
						</td>
						<td align="right" style="width:20%"><font color=red>*</font>专家职称</td>
						<td style="width:30%">
							<s:select id="skillJob" name="texpert.skillJob" list="skilljobList" value="%{texpert.skillJob}" listKey="itemId" listValue="itemName" style="width:90%"></s:select>
							<s:hidden id="hiddenskillJob" name="hidden" value="专家职称"></s:hidden>
						</td>
					</tr>
					<tr>
						<td align="right" style="width:20%"><font color=red>*</font>专家类型</td>
						<td style="width:30%">
							<s:select id="expertType" name="texpert.expertType" value="%{texpert.expertType}" list="expertTypeList" listKey="itemId" listValue="itemName" style="width:90%"></s:select>	
							<s:hidden id="hiddenexpertType" name="hidden" value="专家类型"></s:hidden>
						</td>
						<td align="right" style="width:20%">所学专业</td>
						<td style="width:30%">
							<input type="text" id="expertMajor" name="texpert.expertMajor" value="<s:property value='%{texpert.expertMajor}' escape='true'/>" class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'所学专业',0,-1)" onfocus="upms.upmsUtils.textFocus(this);" style="width:85%" maxlength="50"/>
							<s:hidden id="hiddenexpertMajor" name="hidden" value="所学专业,0,-1,50"></s:hidden>
						</td>
					</tr>
					<tr>
						<td align="right" style="width:20%">擅长专业1</td>
						<td style="width:30%">
							<s:select id="expertMajor1" name="texpert.expertMajor1" value="%{texpert.expertMajor1}" list="expertMajor1List" listKey="itemId" listValue="itemName" style="width:90%"></s:select>
							<s:hidden id="hiddenexpertMajor1Temp" name="hiddenexpertMajor1Temp" value="%{texpert.expertMajor1}"></s:hidden>
							<s:hidden id="hiddenexpertMajor1" name="hidden" value="擅长专业1"></s:hidden>
						</td>
						<td align="right" style="width:20%">擅长专业2</td>
						<td style="width:30%">
							<s:select id="expertMajor2" name="texpert.expertMajor2" value="%{texpert.expertMajor2}" list="expertMajor2List" listKey="itemId" listValue="itemName" style="width:90%" onchange="delExpertMajorMsg();"></s:select>
							<s:hidden id="hiddenexpertMajor2Temp" name="hiddenexpertMajor2Temp" value="%{texpert.expertMajor2}"></s:hidden>
							<s:hidden id="hiddenexpertMajor2" name="hidden" value="擅长专业2"></s:hidden>
						</td>
					</tr>
					<tr>
						<td align="right" style="width:20%">擅长专业3</td>
						<td style="width:30%">
							<s:select id="expertMajor3" name="texpert.expertMajor3" value="%{texpert.expertMajor3}" list="expertMajor3List" listKey="itemId" listValue="itemName" style="width:90%" onchange="delExpertMajorMsg();"></s:select>	
							<s:hidden id="hiddenexpertMajor3Temp" name="hiddenexpertMajor3Temp" value="%{texpert.expertMajor3}"></s:hidden>
							<s:hidden id="hiddenexpertMajor3" name="hidden" value="擅长专业3"></s:hidden>
						</td>
						<td align="right" style="width:20%">信誉等级</td>
						<td style="width:30%">
							<s:select id="expertPrestige" name="texpert.expertPrestige" value="%{texpert.expertPrestige}" list="expertprestigeList" listKey="itemId" listValue="itemName" style="width:90%"></s:select>
							<s:hidden id="hiddenexpertPrestige" name="hidden" value="信誉等级"></s:hidden>
							<s:hidden id="hiddenexpertPrestigeTemp" name="hiddenexpertPrestigeTemp" value="%{texpert.expertPrestige}"></s:hidden>
						</td>
					</tr>
					<tr>
						<td align="right" style="width:20%">学术荣誉称号</td>
						<td style="width:30%">
							<input type="text" id="academicTitle" name="texpert.academicTitle" value="<s:property value='%{texpert.academicTitle}' escape='true'/>" class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'学术荣誉称号',0,-1)" onfocus="upms.upmsUtils.textFocus(this);" style="width:85%" maxlength="50"/>
							<s:hidden id="hiddenacademicTitle" name="hidden" value="学术荣誉称号,0,-1,50"></s:hidden>
						</td>
						<td align="right" style="width:20%"></td>
						<td style="width:30%">
						</td>
					</tr>
					<tr height="25px">
						<th colspan="4" align="left">单位信息</th>
					</tr>
					<tr>
						<td align="right" style="width:20%">工作单位</td>
						<td style="width:30%">
							<input type="text" id="expertWork" name="texpert.expertWork" value="<s:property value='%{texpert.expertWork}' escape='true'/>" class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'工作单位',0,-1)" onfocus="upms.upmsUtils.textFocus(this);" style="width:85%" maxlength="50"/>
							<s:hidden id="hiddenexpertWork" name="hidden" value="工作单位,0,-1,50"></s:hidden>
						</td>
						<td align="right" style="width:20%">单位性质</td>
						<td style="width:30%">
							<s:select id="deptType" name="texpert.deptType" value="%{texpert.deptType}" list="depttypeList" listKey="itemId" listValue="itemName" style="width:90%"></s:select>
							<s:hidden id="hiddendeptTypeTemp" name="hiddendeptTypeTemp" value="%{texpert.deptType}"></s:hidden>
							<s:hidden id="hiddendeptType" name="hidden" value="单位性质"></s:hidden>
						</td>
					</tr>
					<tr>
						<td align="right" style="width:20%">推荐单位</td>
						<td style="width:30%">
							<input  type="text" id="recommendWork" name="texpert.recommendWork" value="<s:property value='%{texpert.recommendWork}' escape='true'/>" class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'推荐单位',0,-1)" onfocus="upms.upmsUtils.textFocus(this);" style="width:85%" maxlength="50"/>
							<s:hidden id="hiddenrecommendWork" name="hidden" value="推荐单位,0,-1"></s:hidden>
						</td>
						<td align="right" style="width:20%"><font color=red>*</font>在职状态</td>
						<td style="width:30%">
							<select id="expertIncumbency" name="texpert.expertIncumbency" style="width:90%">
								<option value="1" ${texpert.expertIncumbency==1?'selected':''}>在职</option>
								<option value="0" ${texpert.expertIncumbency==0?'selected':''}>离职</option>
							</select>
							<s:hidden id="hiddenexpertIncumbency" name="hidden" value="在职状态"></s:hidden>
						</td>
					</tr>
					<tr height="25px">
						<th colspan="4" align="left">联系方式</th>
					</tr>
					<tr>
						<td align="right" style="width:20%">办公电话</td>
						<td style="width:30%">
							<input type="text" name="texpert.workPhone" id="workPhone" value="<s:property value='%{texpert.workPhone}' escape='true'/>" class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'办公电话',0,1)" onfocus="upms.upmsUtils.textFocus(this);" style="width:85%" maxlength="12"/>
							<s:hidden id="hiddenworkPhone" name="hidden" value="办公电话,0,1,12"></s:hidden>
						</td>
						<td align="right" style="width:20%">住宅电话</td>
						<td style="width:30%">
							<input type="text" id="housePhone" name="texpert.housePhone" value="<s:property value='%{texpert.housePhone}' escape='true'/>" onblur="upms.upmsUtils.blurTextCheck(this,'住宅电话',0,1)" onfocus="upms.upmsUtils.textFocus(this);" class="inputA" style="width:85%" maxlength="12"/>
							<s:hidden id="hiddenhousePhone" name="hidden" value="住宅电话,0,1,12"></s:hidden>
						</td>	
					</tr>
					<tr>
						<td align="right" style="width:20%"><font color=red>*</font>手机</td>
						<td style="width:30%">
							<input type="text" id="phone" name="texpert.phone" value="<s:property value='%{texpert.phone}' escape='true'/>" onblur="upms.upmsUtils.blurTextCheck(this,'手机',1,0)" onfocus="upms.upmsUtils.textFocus(this);" class="inputA" style="width:85%" maxlength="11"/>
							<s:hidden id="hiddenphone" name="hidden" value="手机,1,0,11"></s:hidden>
						</td>
						<td align="right" style="width:20%"><font color=red>*</font>电子邮箱</td>
						<td style="width:30%">
							<input type="text" id="email" name="texpert.email" value="<s:property value='%{texpert.email}' escape='true'/>" onblur="upms.upmsUtils.blurTextCheck(this,'电子邮箱',1,7);" onfocus="upms.upmsUtils.textFocus(this);" class="inputA" style="width:85%" maxlength="50"/>
							<s:hidden id="hiddenemail" name="hidden" value="电子邮箱,1,7,50"></s:hidden>
						</td>	
					</tr>
					<tr>
						<td align="right" style="width:20%" >传真</td>
						<td colspan="3">
							<input type="text" id="portraiture" name="texpert.portraiture" value="<s:property value='%{texpert.portraiture}' escape='true'/>" onblur="upms.upmsUtils.blurTextCheck(this,'传真',0,1)" onfocus="upms.upmsUtils.textFocus(this);" class="inputA" style="width:31.5%" maxlength="12"/>
							<s:hidden id="hiddenportraiture" name="hidden" value="传真,0,1,12"></s:hidden>
						</td>
					</tr>
					<tr height="25px">
						<th colspan="4" align="left">研究成果</th>
					</tr>
					<tr>
						<td align="right" style="width:20%" width="30%">主要研究成果</td>
						<td colspan="3" width="70%">
							<textarea id="researchFindings" name="texpert.researchFindings" class="inputA" style="width:99%; height:100px;resize:none;" onblur="upms.upmsUtils.blurTextCheck(this,'研究成果',0,-1,1000)" onfocus="upms.upmsUtils.textFocus(this);"><s:property value="%{texpert.researchFindings}" escape="true"/></textarea>
							<s:hidden id="hiddenresearchFindings" name="hidden" value="研究成果,0,8,1000"></s:hidden>
						</td>
					</tr>
				</table>
				<br/>
				<div align="center">
						<s:hidden id="expertId" name="texpert.expertId" value="%{texpert.expertId}"></s:hidden>
						<s:hidden id="deleteFlag" name="texpert.deleteFlag" value="%{texpert.deleteFlag}"></s:hidden>
						<s:hidden id="remark" name="texpert.remark" value="%{texpert.remark}"></s:hidden>
						<s:if test="%{texpert.expertId!=null&&texpert.expertId!=''}">
							<s:hidden id="createTime" name="texpert.createTime" value="%{texpert.createTime}"></s:hidden>
							<s:hidden id="registerTime" name="texpert.registerTime" value="%{texpert.registerTime}"></s:hidden>
						</s:if>
						<s:hidden id="createUser" name="texpert.createUser" value="%{texpert.createUser}"></s:hidden>
						<s:hidden id="updateUser" name="texpert.updateUser" value="%{texpert.updateUser}"></s:hidden>
						<s:hidden id="isEdit" name="isEdit" value="%{isEdit}"></s:hidden>
						<s:if test="%{isEdit==1}">
							<input class="button" type="button" id="saveBut" name="saveBut" value="保存"/>
							<input class="button" type="button" id="nextBut" name="nextBut" value="下一步"/>
						</s:if>
						<s:elseif test="%{isEdit==0}">
							<input class="button" type="button" id=nextStep name="nextStep" value="下一步" onclick="nextStep('${texpert.expertId}');"/>
						</s:elseif>
						
				</div>
			</div>
		</div>
	</div>
</div>