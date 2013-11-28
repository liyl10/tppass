<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>待办事项</title>

<LINK rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/api_tppas/css/style.css">
<LINK rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/api_tppas/css/layout.css">
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/api_tppas/js/artDialog/skins/blue.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/jquery/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/install_upms.js?ver=1.0.0"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/jquery.msgbox.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/artDialog/artDialog.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/artDialog/plugins/iframeTools.source.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/chosen.jquery.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/super/js/messageNotice.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/api_tppas/css/chosen.css" />
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/api_tppas/css/btn.css" />
<style type="text/css">   

    </style>   
    <script language="javascript">   
    
           function  notice(){
    	
		    var actionUrl="${pageContext.request.contextPath}/api/superadmin/ajaxMessageNotice.action?RandStr="+ Math.random();
			$.ajax({
				type : 'POST',
				url : actionUrl,
				success:function(data){
					var strs= new Array(); //定义一数组
					strs=data.split('}');
					var content="";
					for(var i=0;i<strs.length;i++){
						content+="<"+strs[i]+">"+"已经审批通过，请尽快填写合同为盼！"+"<br>";
					}
					if(content!=""){
						art.dialog.notice({
							title: '新消息',
							width: 220,// 必须指定一个像素宽度值或者百分比，否则浏览器窗口改变可能导致artDialog收缩
							content: content,
							icon: 'succeed',
							time: 20
						});
					}
					

				}
			});
			}
			window.setTimeout(notice, 1000);
		
    
    </script>   
</head>
<body>

</body>
</html>