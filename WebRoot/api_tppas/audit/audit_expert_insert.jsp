<!DOCTYPE HTML>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/api_tppas/js/artDialog/skins/blue.css" />
<link rel=stylesheet type=text/css href="${pageContext.request.contextPath}/api_tppas/css/style.css">
<link rel=stylesheet type=text/css href="${pageContext.request.contextPath}/api_tppas/css/layout.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/jquery/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/install_upms.js?ver=1.0.0"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/My97DatePicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/chosen.jquery.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/api_tppas/css/chosen.css" />

<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/audit/js/audit_expert_insert.js"></script>
<script type="text/javascript">
//document.domain = 'xatrm.com';
</script>

</head>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: center;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">专家添加</div>
				<div class="abuot03" align="center">
					<form id="insertExpert">
					<table width="90%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
					  <tr height="25px">
						<th colspan="4" align="left">基本信息</th>
					</tr>
					<tr>
						<td align="right" style="width:20%">
							<font color="red">*</font>姓名
						</td>
						<td style="width:30%" align="left">
							<input type="text" id="expertName" name="expert.expertName" 
								value="<s:property value='%{expert.expertName}' escape='true'/>" 
								class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'姓名',1,-1)" 
								onfocus="upms.upmsUtils.textFocus(this);" 
								style="width:85%" maxlength="5"/>
							<s:hidden id="hiddenexpertName" name="hidden" value="姓名,1,-1,50"></s:hidden>
						</td>
						<td align="right" style="width:20%">
							性别
						</td>
						<td style="width:30%" align="left">
							<s:select id="sex" name="expert.sex" 
								value="%{expert.sex}" list="sexList" listKey="itemId" 
								listValue="itemName" style="width:16.2em;"></s:select>
							<s:hidden id="hiddensex" name="hidden" value="性别"></s:hidden>
						</td>
					</tr>
					<tr>
						<td align="right" style="width:20%">
							出生年月
						</td>
						<td style="width:30%" align="left">
							<input type="text" id="birthday"  name="expert.birthday" 
								value="<s:property value='%{getText("{0,date,yyyy-MM-dd}",{expert.birthday})}' escape='true'/>" 
								class="txt w184p Wdate" readonly="readonly" onClick="WdatePicker()" 
								onblur="upms.upmsUtils.blurTextCheck(this,'出生年月',1,-1)" 
								onfocus="upms.upmsUtils.textFocus(this);" style="width:88%"/>
							<s:hidden id="hiddenbirthday" name="hidden" value="出生年月"></s:hidden>
						</td>
						<td align="right" style="width:20%">
							学历
						</td>
						<td style="width:30%" align="left">
							<s:select id="schooling" name="expert.schooling" 
								value="%{expert.schooling}" list="schoolingList" listKey="itemId" 
								listValue="itemName" style="width:16.2em;">
							</s:select>
							<s:hidden id="hiddenschooling" name="hidden" value="学历"></s:hidden>
						</td>
					</tr>
					<tr>
						<td align="right" style="width:20%">
							学位
						</td>
						<td style="width:30%" align="left">
							<s:select id="expertDegree" name="expert.expertDegree" 
								value="%{expert.expertDegree}" list="expertdegreeList" 
								listKey="itemId" listValue="itemName" style="width:16.2em;">
							</s:select>
							<s:hidden id="hiddenexpertDegree" name="hidden" value="学位"></s:hidden>
						</td>
						<td align="right" style="width:20%">
							毕业院校
						</td>
						<td style="width:30%" align="left">
							<input type="text" id="graduateSchool" name="expert.graduateSchool" 
								value="<s:property value='%{expert.graduateSchool}' escape='true'/>" 
								class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'毕业院校',1,-1)" 
								onfocus="upms.upmsUtils.textFocus(this);" style="width:85%" maxlength="15"/>				
							<s:hidden id="hiddengraduateSchool" name="hidden" value="毕业院校,1,-1,50"></s:hidden>
						</td>
					</tr>
					<tr>
						<td align="right" style="width:20%">
							专家职务
						</td>
						<td style="width:30%" align="left">
							<input type="text" id="expertJob" name="expert.expertJob" 
								value="<s:property value='%{expert.expertJob}' escape='true'/>" 
								class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'专家职务',0,-1)" 
								onfocus="upms.upmsUtils.textFocus(this);" style="width:85%" maxlength="15"/>			
							<s:hidden id="hiddenexpertJob" name="hidden" value="专家职务,0,-1,50"></s:hidden>	
						</td>
						<td align="right" style="width:20%">
							<font color="red">*</font>专家职称
						</td>
						<td style="width:30%" align="left">
							<s:select id="skillJob" name="expert.skillJob" 
								list="skilljobList" value="%{expert.skillJob}" 
								listKey="itemId" listValue="itemName" style="width:16.2em;">
							</s:select>
							<s:hidden id="hiddenskillJob" name="hidden" value="专家职称"></s:hidden>
						</td>
					</tr>
					<tr>
						<td align="right" style="width:20%">
							<font color="red">*</font>专家类型
						</td>
						<td style="width:30%" align="left">
							<s:select id="expertType" name="expert.expertType" 
								 list="expertTypeList" 
								listKey="itemId" listValue="itemName" style="width:16.2em;">
							</s:select>
							<s:hidden id="hiddenexpertType" name="hidden" value="专家类型"></s:hidden>
						</td>
						<td align="right" style="width:20%">
							所学专业
						</td>
						<td style="width:30%" align="left">
							<input type="text" id="expertMajor" name="expert.expertMajor" 
								value="<s:property value='%{expert.expertMajor}' escape='true'/>" 
								class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'所学专业',0,-1)" 
								onfocus="upms.upmsUtils.textFocus(this);" style="width:85%" maxlength="15"/>
							<s:hidden id="hiddenexpertMajor" name="hidden" value="所学专业,0,-1,50"></s:hidden>
						</td>
					</tr>
					<tr>
						<td align="right" style="width:20%">
							擅长专业1
						</td>
						<td style="width:30%" align="left">
							<s:select id="expertMajor1" name="expert.expertMajor1" 
								value="%{expert.expertMajor1}" list="expertMajor1List" 
								listKey="itemId" listValue="itemName" style="width:16.2em;">
							</s:select>
							<s:hidden id="hiddenexpertMajor1" name="hidden" value="擅长专业1"></s:hidden>
						</td>
						<td align="right" style="width:20%">
							擅长专业2
						</td>
						<td style="width:30%" align="left">
							<s:select id="expertMajor2" name="expert.expertMajor2" 
								value="%{expert.expertMajor2}" list="expertMajor2List" 
								listKey="itemId" listValue="itemName" style="width:16.2em;">
							</s:select>
							<s:hidden id="hiddenexpertMajor2" name="hidden" value="擅长专业2"></s:hidden>
						</td>
					</tr>
					<tr>
						<td align="right" style="width:20%">
							擅长专业3
						</td>
						<td style="width:30%" align="left">
							<s:select id="expertMajor3" name="expert.expertMajor3" 
								value="%{expert.expertMajor3}" list="expertMajor3List" 
								listKey="itemId" listValue="itemName" style="width:16.2em;">
							</s:select>	
							<s:hidden id="hiddenexpertMajor3" name="hidden" value="擅长专业3"></s:hidden>
						</td>
						<td align="right" style="width:20%">
							信誉等级
						</td>
						<td style="width:30%" align="left">
							<s:select id="expertPrestige" name="expert.expertPrestige" 
								value="%{expert.expertPrestige}" list="expertprestigeList" 
								listKey="itemId" listValue="itemName" style="width:16.2em;">
							</s:select>
							<s:hidden id="hiddenexpertPrestige" name="hidden" value="信誉等级"></s:hidden>
						</td>
					</tr>
					<tr>
						<td align="right" style="width:20%">
							学术荣誉称号
						</td>
						<td style="width:30%" align="left">
							<input type="text" id="academicTitle" name="expert.academicTitle" 
								value="<s:property value='%{expert.academicTitle}' escape='true'/>" 
								class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'学术荣誉称号',0,-1)" 
								onfocus="upms.upmsUtils.textFocus(this);" style="width:85%" maxlength="15"/>
							<s:hidden id="hiddenacademicTitle" name="hidden" value="学术荣誉称号,0,-1,50"></s:hidden>
						</td>
						<td align="right" style="width:20%">
							&nbsp;
						</td>
						<td style="width:30%" align="left">
							&nbsp;
						</td>
					</tr>
					<tr height="25px">
						<th colspan="4" align="left">单位信息</th>
					</tr>
					<tr>
						<td align="right" style="width:20%">
							工作单位
						</td>
						<td style="width:30%" align="left">
							<input type="text" id="expertWork" name="expert.expertWork" 
								value="<s:property value='%{expert.expertWork}' escape='true'/>" 
								class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'工作单位',0,-1)" 
								onfocus="upms.upmsUtils.textFocus(this);" style="width:85%" maxlength="15"/>
							<s:hidden id="hiddenexpertWork" name="hidden" value="工作单位,0,-1,50"></s:hidden>
						</td>
						<td align="right" style="width:20%">
							单位性质
						</td>
						<td style="width:30%" align="left">
							<s:select id="deptType" name="expert.deptType" 
								value="%{expert.deptType}" list="depttypeList" 
								listKey="itemId" listValue="itemName" style="width:16.2em;">
							</s:select>
							<s:hidden id="hiddendeptType" name="hidden" value="单位性质"></s:hidden>
						</td>
					</tr>
					<tr>
						<td align="right" style="width:20%">
							推荐单位
						</td>
						<td style="width:30%" align="left">
							<input  type="text" id="recommendWork" name="expert.recommendWork" 
								value="<s:property value='%{expert.recommendWork}' escape='true'/>" 
								class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'推荐单位',0,-1)" 
								onfocus="upms.upmsUtils.textFocus(this);" style="width:85%" maxlength="15"/>
							<s:hidden id="hiddenrecommendWork" name="hidden" value="推荐单位,0,-1"></s:hidden>
						</td>
						<td align="right" style="width:20%">
							<font color="red">*</font>在职状态
						</td>
						<td style="width:30%" align="left"> 
							<select id="expertIncumbency" name="expert.expertIncumbency" style="width:16.2em;">
								<option value="1" ${expert.expertIncumbency==1?'selected':''}>在职</option>
								<option value="0" ${expert.expertIncumbency==0?'selected':''}>离职</option>
							</select>
							<s:hidden id="hiddenexpertIncumbency" name="hidden" value="在职状态"></s:hidden>
						</td>
					</tr>
					<tr height="25px">
						<th colspan="4" align="left">联系方式</th>
					</tr>
					<tr>
						<td align="right" style="width:20%">
							办公电话
						</td>
						<td style="width:30%" align="left">
							<input type="text" name="expert.workPhone" id="workPhone" 
								value="<s:property value='%{expert.workPhone}' escape='true'/>" 
								class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'办公电话',0,1)" 
								onfocus="upms.upmsUtils.textFocus(this);" style="width:85%" maxlength="12"/>
							<s:hidden id="hiddenworkPhone" name="hidden" value="办公电话,0,1,12"></s:hidden>
						</td>
						<td align="right" style="width:20%">
							住宅电话
						</td>
						<td style="width:30%" align="left">
							<input type="text" id="housePhone" name="expert.housePhone" 
								value="<s:property value='%{expert.housePhone}' escape='true'/>" 
								onblur="upms.upmsUtils.blurTextCheck(this,'住宅电话',0,1)" 
								onfocus="upms.upmsUtils.textFocus(this);" class="inputA" 
								style="width:85%" maxlength="12"/>
							<s:hidden id="hiddenhousePhone" name="hidden" value="住宅电话,0,1,12"></s:hidden>
						</td>	
					</tr>
					<tr>
						<td align="right" style="width:20%">
							<font color="red">*</font>手机
						</td>
						<td style="width:30%" align="left">
							<input type="text" id="phone" name="expert.phone" 
								value="<s:property value='%{expert.phone}' escape='true'/>" 
								onblur="upms.upmsUtils.blurTextCheck(this,'手机',1,0)" 
								onfocus="upms.upmsUtils.textFocus(this);" class="inputA" 
								style="width:85%" maxlength="11"/>
							<s:hidden id="hiddenphone" name="hidden" value="手机,1,0,11"></s:hidden>
						</td>
						<td align="right" style="width:20%">
							<font color="red">*</font>电子邮箱
						</td>
						<td style="width:30%" align="left">
							<input type="text" id="email" name="expert.email" 
								value="<s:property value='%{expert.email}' escape='true'/>" 
								onblur="upms.upmsUtils.blurTextCheck(this,'电子邮箱',1,7);" 
								onfocus="upms.upmsUtils.textFocus(this);" class="inputA" 
								style="width:85%" maxlength="30"/>
							<s:hidden id="hiddenemail" name="hidden" value="电子邮箱,1,7,50"></s:hidden>
						</td>	
					</tr>
					<tr>
						<td align="right" style="width:20%">
							传真
						</td>
						<td colspan="3" align="left">
							<input type="text" id="portraiture" name="expert.portraiture" 
								value="<s:property value='%{expert.portraiture}' escape='true'/>" 
								onblur="upms.upmsUtils.blurTextCheck(this,'传真',0,1)" 
								onfocus="upms.upmsUtils.textFocus(this);" class="inputA" 
								style="width:31.5%" maxlength="12"/>
							<s:hidden id="hiddenportraiture" name="hidden" value="传真,0,1,12"></s:hidden>
						</td>
					</tr>
					<tr height="25px">
						<th colspan="4" align="left">研究成果</th>
					</tr>
					<tr>
						<td align="right" style="width:20%" width="30%">
							主要研究成果
						</td>
						<td colspan="3" width="70%" align="left">
							<textarea id="researchFindings" name="expert.researchFindings" 
								class="inputA" style="width:99%; height:100px;resize:none;" 
								onblur="upms.upmsUtils.blurTextCheck(this,'研究成果',0,8,1000)" 
								onkeyup="upms.upmsUtils.checkTextareaLength(this, 1000);"
								onfocus="upms.upmsUtils.textFocus(this);"><s:property value="%{expert.researchFindings}" escape="true"/></textarea>
							<s:hidden id="hiddenresearchFindings" name="hidden" value="研究成果,0,8,1000"></s:hidden>
						</td>
					</tr>
					</table>
					</form>
	 			</div>
 	 		</div>
  		</div>
  	</div>
</div>