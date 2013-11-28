<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=7"/>
<title>后台登录 - 西安科技企业信息系统</title>
<meta name="keywords" content="关键词" />
<meta name="description" content="摘要" />
<link rel="icon" type="image/x-icon" href="favicon.ico" />
<link href="${pageContext.request.contextPath}/api_scenter/login/css/login/admin-login.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-1.7.1.min.js"></script>
<script src="${pageContext.request.contextPath}/api_scenter/login/js/login.js" type="text/javascript"></script>
<!--[if IE]>
<script src="${pageContext.request.contextPath}/api_scenter/login/js/html5.js"></script>
<![endif]-->
<script type="text/javascript">

</script>
</head>
<body>
	<input id="loginPath" type="hidden" value="${pageContext.request.contextPath}"/>
	<input id="index" type="hidden" name="index" value="0"/>
	<div class="admin-main">
    	<div class="login-box">
        	<!-- 选项卡1开始 -->
            <div class="admin-login">
                <!-- 标题开始 -->
                <div class="adminTitle">
                  <ul id="myTab1">
                    <li class="active" onclick="nTabs(this,0);"></li>
                    <li class="normal" onclick="nTabs(this,1);"></li>
                    <li class="normal" onclick="nTabs(this,2);"></li>
                  </ul>
                </div>
                <!-- 内容开始 -->
                <div class="adminContent">
                	<c:forEach begin="0" end="2" varStatus="status">
              			<div id="myTab1_Content${status.index}" <c:if test="${!status.first}">class="none"</c:if> >
		         		<form name="form${status.index}" method="post" >
							<ul>
		           	  			<li>
		           	  				<c:choose>
		           	  					<c:when test="${status.index == 1}">
		           	  						<span class="left">部门</span>
				                            <span class="right">
				                            <label for="select"></label>
				                            	 <select name="select" id="select_dept${status.index}" class="select-box" onchange="change(this,${status.index});">
					                            	<option>请选择</option>
			                            			<c:forEach items="${deptlist1}" var="dept1">
					                            		<option value="${dept1.deptId}">${dept1.deptName}</option>
					                            	</c:forEach>
					                            </select>
				                            </span>
		           	  					</c:when>
		           	  					<c:otherwise>
		           	  						<span class="left"></span>
				                            <span class="right">
				                            	<label for="select"></label>
				                            </span>
		           	  					</c:otherwise>
		           	  				</c:choose>
		            			</li>
		                        <li>
		                        	<span class="left">角色</span>
		                            <span class="right">
			                            <label for="select"></label>
			                            <c:choose>
			           	  					<c:when test="${status.index == 0}">
			           	  						<select name="admin.userName" id="select_post${status.index}" class="select-box" onchange="changepost(this,${status.index});">
					                            	<option value="">请选择</option>
					                            	<c:forEach items="${userlist0}" var="user0">
														<c:if test="${user0.userName != 'admin'}">
															<option value="${user0.userName}">${user0.userNickname}</option>
														</c:if>
													</c:forEach>
					                            </select>
			           	  					</c:when>
			           	  					<c:when test="${status.index == 1}">
			           	  						<select name="admin.userName" id="select_post${status.index}" class="select-box" onchange="changepost(this,${status.index});">
					                            	<option value="">请选择</option>
					                            </select>
			           	  					</c:when>
			           	  					<c:when test="${status.index == 2}">
			           	  						<select name="admin.userName" id="select_post${status.index}" class="select-box" onchange="changepost(this,${status.index});">
					                            	<option value="">请选择</option>
					                            	<c:forEach items="${userlist2}" var="user2">
														<c:if test="${user2.userName != 'admin'}">
															<option value="${user2.userName}">${user2.userNickname}</option>
														</c:if>
													</c:forEach>
					                            </select>
			           	  					</c:when>
			           	  				</c:choose>
		                            </span>
		            			</li>
		                        <li>
		                        	<span class="left">密码</span>
		                            <span class="right">
		                            <input type="password" name="admin.userPwd" id="password${status.index}" class="input-text">
		                            </span>
		            			</li>
		                        <li>
		                        	<span class="left">验证码</span>
		                            <span class="right">
		                            <input type="text" name="number" id="number${status.index}" class="input-text" maxlength="4">
		                            </span>
		                            <span class="right yzm-box">
		                           		<a href="javascript:void(0);" title="看不清？换一张" style="cursor: pointer" onclick="javascript:reloadImage(${status.index});"><img id="img${status.index}" src="${pageContext.request.contextPath}/api_scenter/login/image.jsp" width="94" height="35" alt="验证码"></a><a href="javascript:void(0);" title="看不清？换一张" style="cursor: pointer" onclick="javascript:reloadImage(${status.index});" >看不清？换一张</a>
		                            </span>
		            			</li>
		                        <li>
		                            <span class="right">
		                           	<input type="button" name="button" id="submit${status.index}" value="登 录" class="admin-btn" onMouseOver="this.style.backgroundImage='url(${pageContext.request.contextPath}/api_scenter/login/images/admin-btn-hover.gif)'" onMouseOut="this.style.backgroundImage='url(${pageContext.request.contextPath}/api_scenter/login/images/admin-btn.gif)'">
		                            </span>
		            			</li>
		                    </ul>
		               		</form>
	            		</div>
                	</c:forEach>
                </div>
            </div>
            <!-- 选项卡1结束 -->
            <div class="clear"></div>
        </div>
    </div>
    <footer>
    </footer>
</body>
</html>