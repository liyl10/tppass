<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title></title>
		<link href="${pageContext.request.contextPath}/resource/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resource/css/theme.css" rel="stylesheet" type="text/css" />
		<script src="${pageContext.request.contextPath}/api_scenter/js/jquery-1.4.4.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/api_scenter/js/jquery.form.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/api_scenter/js/RegExp.js" type="text/javascript" ></script>
	</head>
	<body>
		<div class="box-positon">
			<div class="rpos">
				当前位置: 查看权限
			</div>
			 
			<div class="clear"></div>
		</div>
		<div class="body-box">
	
	  <table width="100%" border="0" cellspacing="1" cellpadding="0" class="pn-ftable" >
       <tr>
	    <td class="pn-flabel pn-flabel-h">上级权限</td>
	    <td class="pn-fcontent">
        <input name="edit_auth_parent_id" id="edit_auth_parent_id" type="hidden" value="${pro_result.objinfo.scAuth.authId}" />
        ${pro_result.objinfo.scAuth.authName}
        </td>
      </tr>
	  <tr>
	    <td width="30%" class="pn-flabel pn-flabel-h"><font class="pn-frequired">*</font>权限名称</td>
	    <td width="70%" class="pn-fcontent">
	    <input name="edit_auth_id" id="edit_auth_id" type="hidden" value="${pro_result.objinfo.authId}" />
	    ${pro_result.objinfo.authName}
	    </td>
      </tr>
	 
      <tr>
	    <td class="pn-flabel"><font class="pn-frequired">*</font>权限code</td>
	    <td class="pn-fcontent">${pro_result.objinfo.authCode}
	    </td>
      </tr>
     <tr>
	    <td class="pn-flabel"><font class="pn-frequired">*</font>权限类型</td>
	    <td class="pn-fcontent">
	    <c:forEach items="${auth_type_config.childList}" var="enable">
             ${(enable.value ==pro_result.objinfo.authType)?enable.desc:""}
		</c:forEach>
       </td>
      </tr>
       <tr id="edit_view_url">
	    <td class="pn-flabel">权限url</td>
	    <td class="pn-fcontent">${pro_result.objinfo.authUrl} </td>
      </tr>
	   <tr id="edit_view_url">
	    <td class="pn-flabel">权限打开方式</td>	
	    <td class="pn-fcontent">
        <c:forEach items="${auth_opentype_config.childList}" var="enable">
			 ${(enable.value ==pro_result.objinfo.opentypeState)?enable.desc:""}
			 &nbsp;&nbsp; 
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
             </td>
 		 </tr>
 	  <tr>
	    <td class="pn-flabel">权限说明</td>
	    <td class="pn-fcontent">${pro_result.objinfo.authDesc} </td>
      </tr>
	  <tr>
	    <td class="pn-flabel">排列顺序</td>
	    <td class="pn-fcontent">${pro_result.objinfo.authOrder}</td>
		</tr>
	  <tr>
	    <td class="pn-flabel">启用状态</td>
	    <td class="pn-fcontent">
	    <c:forEach items="${enable_state_config.childList}" var="enable">
              ${(enable.value ==pro_result.objinfo.enableState)?enable.desc:""}
		</c:forEach>
		</td>
      </tr>
	  <tr>
	    <td colspan="2" class="pn-fbutton">
	      <input type="button" name="btn_cancel_edit" value="返回" class="reject" onclick="javascript:history.go(-1)" />	      
	      &nbsp; </td>
      </tr>
    </table>
		</div>
		<div id="dialog">
			<div id="dialog_content"></div>
		</div>
	</body>
</html>