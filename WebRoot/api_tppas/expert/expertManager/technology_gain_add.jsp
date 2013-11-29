<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/expert/expertManager/js/technology_gain_add.js"></script>
<!-- 保存按钮提示信息 -->
<label id="comfirmSave" style="display: none"><s:text name="confirm_save_info"/></label>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">专业技术研究成果</div>
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-entRegFrm">
					<tr>
						<td width="30%" align="right"><font color=red>*</font>项目或课题名称</td>
						<td width="70%">
							<input type="text" id="gainName" name="ttechnologyGain.gainName" class="inputA" maxlength="50" onblur="upms.upmsUtils.blurTextCheck(this,'项目或课题名称',1,-1,50);" onfocus="upms.upmsUtils.textFocus(this);"/>
							<s:hidden id="hiddengainName" name="hidden" value="项目或课题名称,1,-1,50"></s:hidden>
						</td>	
					</tr>
					<tr>
						<td width="30%" align="right"><font color=red>*</font>项目或课题来源</td>
						<td width="70%">
							<input type="text" id="gainSource" name="ttechnologyGain.gainSource" class="inputA" maxlength="50" onblur="upms.upmsUtils.blurTextCheck(this,'项目或课题来源',1,-1,50);" onfocus="upms.upmsUtils.textFocus(this);"/>
							<s:hidden id="hiddengainSource" name="hidden" value="项目或课题来源,1,-1,50"></s:hidden>
						</td>
					</tr>
					<tr>
						<td width="30%" align="right" >完成情况和时间</td>
						<td width="70%">
							<textarea id="gainFinish" name="ttechnologyGain.gainFinish" class="inputA" style="width:99%; height:100px;resize:none;" ></textarea>
							<s:hidden id="hiddengainFinish" name="hidden" value="完成情况和时间,0,8,1000"></s:hidden>
						</td>
					</tr>
					<tr>
						<td width="30%" align="right" >获得情况和时间</td>
						<td width="70%">
							<textarea id="gainCondition" name="ttechnologyGain.gainCondition" class="inputA" style="width:99%; height:100px;resize:none;" ></textarea>
							<s:hidden id="hiddengainCondition" name="hidden" value="获得情况和时间,0,8,1000"></s:hidden>
						</td>
					</tr>
				</table>
				<br/>
				<div align="center">
					<s:hidden id="expertId" name="ttechnologyGain.expertId" value="%{expertId}"></s:hidden>
					<input class="button" type="button" id="saveBut" name="saveBut" value="保存"/>
					<input class="button" type="button" id="goBut" name="nextBut" value="返回" onclick="returnList('${expertId}');"/>
				</div>
			</div>
		</div>
	</div>
</div>