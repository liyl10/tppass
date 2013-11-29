<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/expert/expertManager/js/technology_gain_show.js"></script>
<!-- 修改按钮提示信息 -->
<label id="comfirmUpdate" style="display: none"><s:text name="confirm_update_info"/></label>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">专业技术研究成果</div>
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-entRegFrm">
					<tr>
						<td width="30%" align="right">项目或课题名称</td>
						<td width="70%">
							<input type="text" id="gainName" name="ttechnologyGain.gainName" class="inputA" value="<s:property value='%{ttechnologyGain.gainName}' escape='true'/>" maxlength="50"/>
						</td>	
					</tr>
					<tr>
						<td width="30%" align="right">项目或课题来源</td>
						<td width="70%">
							<input type="text" id="gainSource" name="ttechnologyGain.gainSource" class="inputA" value="<s:property value='%{ttechnologyGain.gainSource}' escape='true'/>" maxlength="50"/>
						</td>
					</tr>
					<tr>
						<td width="30%" align="right" >完成情况和时间</td>
						<td width="70%">
							<textarea id="gainFinish" name="ttechnologyGain.gainFinish" class="inputA" style="width:99%; height:100px;resize:none;"><s:property value="%{ttechnologyGain.gainFinish}" escape="true"/></textarea>
						</td>
					</tr>
					<tr>
						<td width="30%" align="right" >获得情况和时间</td>
						<td width="70%">
							<textarea id="gainCondition" name="ttechnologyGain.gainCondition" class="inputA" style="width:99%; height:100px;resize:none;"><s:property value="%{ttechnologyGain.gainCondition}" escape="true"/></textarea>
						</td>
					</tr>
				</table>
				<br/>
				<div align="center">
					<s:hidden id="isUpdate" name="isUpdate" value="%{isEdit}"></s:hidden>
					<input class="button" type="button" id="goBut" name="goBut" value="返回" onclick="returnList('${ttechnologyGain.expertId}');"/>
				</div>
			</div>
		</div>
	</div>
</div>