<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title></title>
		<link href="${pageContext.request.contextPath}/resource/css/yz.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resource/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resource/css/theme.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/api_scenter/css/qtip.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-1.4.4.min.js"></script>
		<script src="${pageContext.request.contextPath}/api_scenter/js/jquery.form.js" type="text/javascript"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/api_scenter/js/RegExp.js"></script>
        
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/validate.js"></script>
		<script type="text/javascript" >
			var url_cur="${pageContext.request.contextPath}";
		</script>
        <script src="${pageContext.request.contextPath}/api_scenter/auth/js/auth_modify.js" type="text/javascript"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/hcsp_resources.js"></script>
	</head>
	<body>
		<div class="box-positon">
			<div class="rpos">
				当前位置: 修改权限
			</div>
			 
			<div class="clear"></div>
		</div>
		<div class="body-box">
	 <form action="${pageContext.request.contextPath}/api/auth/auth_modifysave.action" method="post" name="form_modify" target="_self" id="form_modify">	
	  <table width="100%" border="0" cellspacing="1" cellpadding="0" class="pn-ftable" >
       <tr>
	    <td class="pn-flabel pn-flabel-h">上级权限</td>
	    <td class="pn-fcontent"><input name="edit_auth_parent_id" id="edit_auth_parent_id" type="hidden" value="${pro_result.objinfo.scAuth.authId}" />
        <input name="edit_auth_parent_name" id="edit_auth_parent_name" type="text" class="text_box" size="30" value="${pro_result.objinfo.scAuth.authName}" readonly="readonly" disabled="disabled" /></td>
      </tr>
	  <tr>
	    <td width="30%" class="pn-flabel pn-flabel-h"><font class="pn-frequired">*</font>权限名称</td>
	    <td width="70%" class="pn-fcontent">
	    <input name="edit_auth_id" id="edit_auth_id" type="hidden" value="${pro_result.objinfo.authId}" />
	    <input name="edit_auth_name" id="edit_auth_name" type="text" class="text_box" size="30" maxlength="10" value="${pro_result.objinfo.authName}" /></td>
      </tr>
	 
      <tr>
	    <td class="pn-flabel"><font class="pn-frequired">*</font>权限code</td>
	    <td class="pn-fcontent"><input name="edit_auth_code" id="edit_auth_code" type="text" class="text_box" size="50" maxlength="50" value="${pro_result.objinfo.authCode}" />
	    </td>
      </tr>
     <tr>
	    <td class="pn-flabel"><font class="pn-frequired">*</font>权限类型</td>
	    <td class="pn-fcontent">
	    <c:forEach items="${auth_type_config.childList}" var="enable">
	  	  
		  <c:choose> 		
			<c:when test="${pro_result.objinfo.scAuth!=null}">
				<c:if test="${(enable.value>=pro_result.objinfo.scAuth.authType)}">
				 <label><input type="radio" name="edit_auth_type" value="${enable.value }" ${(enable.value ==pro_result.objinfo.authType)?"checked='checked'":""} />${enable.desc}</label>&nbsp;&nbsp; 
		 		</c:if>	 
			</c:when>	
			<c:otherwise>
			 	<label><input type="radio" name="edit_auth_type" value="${enable.value }" ${(enable.value ==pro_result.objinfo.authType)?"checked='checked'":""} />${enable.desc}</label>&nbsp;&nbsp; 
			</c:otherwise> 
			</c:choose>
		  	
		</c:forEach>
       </td>
      </tr>
       <tr id="edit_view_url">
	    <td class="pn-flabel">权限url</td>
	    <td class="pn-fcontent"><input name="edit_auth_url" id="edit_auth_url" type="text" class="text_box" size="100" maxlength="300" value="${pro_result.objinfo.authUrl}" /></td>
	   </tr>
      <tr id="edit_view_url">
	    <td class="pn-flabel">权限打开方式</td>	
	    <td class="pn-fcontent">
        <c:forEach items="${auth_opentype_config.childList}" var="enable">
			 <label><input type="radio" name="opentype_state" value="${enable.value }" ${(enable.value ==pro_result.objinfo.opentypeState)?"checked='checked'":""} />${enable.desc}</label>&nbsp;&nbsp; 
		   </c:forEach>
	    </td>
      </tr>
	 
      <tr>
	    <td  class="pn-flabel">权限图片</td>
       
	    <td class="pn-fcontent">
	    	<div id="showImage">
	    	 <c:if test="${pro_result.objinfo.authIcon != null}">
	    	    <img name="edit_auth_icon_img" src="${pro_result.objinfo.authIcon}" width="60" height="60" />
	    	 </c:if>
	    	 </div>  
	   		 <input id="fileupload" name="fileMaterial" type="file" />      
        	 <input type="button" onclick="uploadImage('<%=request.getContextPath() %>','form_modify')" value="上传" />    
             <input id="up_imgurl" name="up_imgurl" type="hidden" value="${pro_result.objinfo.authIcon}" />     
             </td>
 	  </tr>
      <tr>
	    <td class="pn-flabel">权限说明</td>
	    <td class="pn-fcontent">
        <textarea name="edit_auth_desc" id="edit_auth_desc" cols="50" rows="3" class="textarea_box" maxlength="200" >${pro_result.objinfo.authDesc}</textarea>
	    </td>
      </tr>
	  <tr>
	    <td class="pn-flabel">排列顺序</td>
	    <td class="pn-fcontent"><input name="edit_auth_order" id="edit_auth_order" type="text" class="text_box" size="10" maxlength="10" value="${pro_result.objinfo.authOrder}" />
	   </td>
      </tr>
	  <tr>
	    <td class="pn-flabel">启用状态</td>
	    <td class="pn-fcontent">
	    <c:forEach items="${enable_state_config.childList}" var="enable">
			 <label><input type="radio" name="edit_enable_state" value="${enable.value}" ${(enable.value ==pro_result.objinfo.enableState)?"checked='checked'":""} />${enable.desc}</label>&nbsp;&nbsp; 
		</c:forEach>
        </tr>
	  <tr>
	    <td colspan="2" class="pn-fbutton">
          <input type="submit" name="btn_save_edit" value="保存" class="submit" />
	      &nbsp;
	      <input type="reset" name="btn_reset" value="重置" class="reset" />&nbsp;
	      <input type="button" name="btn_cancel_edit" value="返回" class="reject" onclick="javascript:history.go(-1)" />
	      &nbsp; </td>
      </tr>
    </table>
    </form>
		</div>
		<div id="dialog" title="Download complete">
			<div id="dialog_content"></div>
		</div>
	</body>
</html>