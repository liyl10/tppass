<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title></title>
		<link href="${pageContext.request.contextPath}/resource/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resource/css/theme.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/api_scenter/css/jquerythemes/ui-lightness/ui.all.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/api_scenter/js/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/api_scenter/js/jquery-1.4.4.min.js" type="text/javascript"></script>
		
		<script src="${pageContext.request.contextPath}/api_scenter/js/ui.core.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/api_scenter/js/ui.draggable.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/api_scenter/js/ui.resizable.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/api_scenter/js/ui.dialog.js" type="text/javascript"></script>
		
        <script src="${pageContext.request.contextPath}/api_scenter/js/RegExp.js" type="text/javascript" ></script>
     	<script type="text/javascript" src="${pageContext.request.contextPath}/api_scenter/js/zTree/js/jquery.ztree.core-3.1.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/api_scenter/js/zTree/js/jquery.ztree.excheck-3.1.js"></script>
		<script src="${pageContext.request.contextPath}/api_scenter/role/js/role_validator.js" type="text/javascript"></script>
		<SCRIPT type="text/javascript">
				<!--
				var setting = {
					check: {
						enable: true
					},
					data: {
						simpleData: {
							enable: true
						}
					},
					callback: {
					beforeExpand: beforeExpand,
					onExpand: onExpand,
					beforeCheck: beforeCheck,
					onCheck: onCheck
				}
				};
				function beforeExpand(treeId, treeNode) {
					return (treeNode.expand !== false);
				}
				 function onExpand(event, treeId, treeNode) {
				}
			 
				function beforeCheck(treeId, treeNode) {
					return (treeNode.doCheck !== false);
				}
				function onCheck(e, treeId, treeNode) {
				}
				var zNodes =${nodesvee};
				$(document).ready(function(){
					$.fn.zTree.init($("#treeDemo"), setting, zNodes);
					var zTree = $.fn.zTree.getZTreeObj("treeDemo");
					zTree.setting.check.chkboxType = { "Y" : "ps", "N" : "ps" };
					//保存时
				    $("#btn_save").click(function(){	
					$("form[name='form1']").attr("action","${pageContext.request.contextPath}/api/role/role_authsave.action");
					var nodes_checked=zTree.getCheckedNodes(true);
					//var auth_select=new Array();
					for (var i=0, l=nodes_checked.length; i<l; i++) {
					// auth_select[i]= nodes_checked[i].id;
					 $("#role_seleted_div").append("<input type='checkbox' name='ids' value='"+nodes_checked[i].id+"' checked='checked' />");
					}
					$("form[name='form1']").submit(); 
						});
				
						
				//	ready end
				});
				//
				-->
			</SCRIPT>
	</head>
	<body class="lbody" style="overflow-x:hidden;overflow-y:auto">
		<div class="box-positon">
			<div class="rpos">
				当前位置: 角色管理 - 角色授权
			</div>
			<div class="clear"></div>
		</div>
		<div class="body-box">
			<form method="post" action="" id="form1" name="form1">
				<table width="100%" class="pn-ftable" cellpadding="2" cellspacing="1" border="0">
					<tr>
						<td class="pn-flabel pn-flabel-h">${pro_result.objinfo.roleName}</td>
						<td class="pn-fcontent" style="height:430px;" valign="top">
							<ul id="treeDemo" class="ztree"></ul>
						</td>
					</tr>
					 
					<tr>
						<td colspan="2" class="pn-fbutton">	
					    	<input type="hidden" name="redirectUrl" value="${redirectUrl}"/>
						    <input type="hidden" name="role_id" id="role_id" value="${pro_result.objinfo.roleId}" />	 
						    <div style="display:none;" id="role_seleted_div"></div>
						    <tag:auth code="sc.role.role_authsave">
								<input type="button" name="btn_save" value="保存" class="submit" id="btn_save" />
							</tag:auth>
							&nbsp;
							<input type="button" name="btn_cancel" value="返回" class="reject" id="btn_cancel" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div id="dialog" title="Download complete">
			<div id="dialog_content"></div>
		</div>
	</body>
</html>