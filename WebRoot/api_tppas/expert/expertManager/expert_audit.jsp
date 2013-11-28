<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/expert/expertManager/js/expert_audit.js"></script>
<!-- 保存按钮提示信息 -->
<label id="comfirmSave" style="display: none"><s:text name="confirm_save_info"/></label>
<!-- 删除按钮提示信息 -->
<label id="comfirmDelete" style="display: none"><s:text name="confirm_del_info"/></label>
<!-- 已上传评审表提示信息 -->
<label id="comfirmNextUpload" style="display: none"><s:text name="expert_audit_uploadfile_info"/></label>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">评审表</div>
				<iframe id="download" name="download" width=0 height=0 src="" style="display: none;"></iframe> 
				<form  method="post" enctype="multipart/form-data" id="uploadForm" target="download">	
					<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-entRegFrm">
						<tr height="35px">
							<td width="20%" align="right">
								评审表模板
							</td>
							<td align="left">
					    			<s:text name="expert_audit_template_shwo_name"/>
					    			<a class="uline single" href="javascript: void(0);" onclick="downTemplate();">
					    				&nbsp;&nbsp;&nbsp;下载
					    			</a>
							</td>
						</tr>
						<s:if test="%{tattachment!=null}">
							<tr height="35px" id="auditFileTr">
								<td width="20%" align="right">
									已上传评审表
								</td>
								<td align="left">
									<s:text name="expert_audit_shwo_name"/>&nbsp;&nbsp;&nbsp;
									<a class="uline single" href="javascript: void(0);" onclick="downfile('${tattachment.attachmentId}');">
										下载
									</a>
									&nbsp;&nbsp;&nbsp;
									<a class="uline single" href="javascript: void(0);" onclick="deleteFile('${tattachment.attachmentId}','${scoreId}');">
										删除
									</a>
								</td>
							</tr>
						</s:if>
						<tr height="35px">
							<td width="20%" align="right">
								<font color=red>*</font>评审表上传
							</td>
							<td align="left">
					    		<input type="file" class="inputA" id="uploadfile" name="uploadfile" style="width:45%;height:23px;" onblur="blurFileText(this,'附件上传路径',1,1);" onfocus="focusFileText(this);"/>
								<s:hidden id="hiddenuploadfile" name="hidden" value="附件上传路径,1,1"></s:hidden>
							</td>
						</tr>  
						<tr align="center">
							<td colspan="2">
								<s:hidden id="tableName" name="tableName" value="T_EXPERT_SCORE"></s:hidden>
								<s:hidden id="dataId" name="dataId" value="%{scoreId}"></s:hidden>
								<s:hidden id="retUrlTemp" name="retUrlTemp"></s:hidden>
								<s:hidden id="retUrlTo" name="retUrlTo"></s:hidden>
								<s:hidden id="upLoadfileName" name="upLoadfileName"></s:hidden>
								<s:hidden id="fileType" name="fileType" value="xls,xlsx,doc"></s:hidden>
								<s:hidden id="attachmentName" name="attachmentName" value="专家评审表"></s:hidden>
								<s:hidden id="attachmentId" name="attachmentId" value="%{tattachment.attachmentId}"></s:hidden>
								<input class="button" id="saveFile" name="button" type="button" value="保存"/>
								<!--<input class="button" id="retBack" name="button" type="button" href="javascript: void(0);" value="返回"/>
							--></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</div>
