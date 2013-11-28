<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>待办事项</title>
<LINK rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/api_tppas/css/style.css">
<LINK rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/api_tppas/css/layout.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/install_upms.js?ver=1.0.0"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/jquery.msgbox.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/My97DatePicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/chosen.jquery.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/api_tppas/css/chosen.css" />
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/api_tppas/css/btn.css" />
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/api_tppas/report/css/waitThingItem.css" />
<style type="text/css">   

    </style>   
    <script language="javascript">   
    $(document).ready(function () {
        $("#tabs li").bind("click", function () {
            var index = $(this).index();
            var divs = $("#tabs-body > div");
            $(this).parent().children("li").attr("class", "tab-nav");//将所有选项置为未选中
            $(this).attr("class", "tab-nav-action"); //设置当前选中项为选中样式
            divs.hide();//隐藏所有选中项内容
            divs.eq(index).show(); //显示选中项对应内容
        });
 
    });
    </script>   
</head>
<body>
<div align="center" style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
	</br>
		<span>计划处工作人员：${sysUser.userName }！ 欢迎登陆综合管理系统 
		</span>
	</div>
</div>
<div>&nbsp;</div>
<div align="center" style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="tabs">
				    <ul id="tabs">
				        <li class="tab-nav-action">待调配项目</li>
				        <li class="tab-nav">待计划编制</li>
				        <li class="tab-nav">待归档项目</li>
				    </ul>
				</div>
				<div id="tabs-body" class="tabs-body">
				    <div style="display:block">
				    	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-list">
							<tr align="center">
								<th>序号</th>
								<th>项目名称</th>
								<th>申报单位</th>
								<th>计划类别</th>
								<th>技术领域</th>
								<th>项目负责人</th>
								<th>申报日期</th>
								<th>项目状态</th>
								<th align="center">操作</th>
							</tr>
							<s:iterator value="listProjectApplicationApplyState" id="projectApplication" status="itcount">
							<tr>
								<td><s:property value="#itcount.Count"/></td>
								<td><s:property value="#projectApplication.projectName"/></td>
								<td><s:property value="#projectApplication.applicationUnit" /></td>
								<td><s:property value="#projectApplication.tprojectType.typeRealName" /></td>
								<s:iterator value="#projectApplication.tprojectInfoAs" id="projectA"><td><s:property value="#projectA.technicalFisld" /></td><td><s:property value="#projectA.projectPerson" /></td></s:iterator>
								
								<td><s:property value="#projectApplication.startTime"/></td>
								<td><s:property value="#projectApplication.flowStatus"/></td>
								<td align="center">
									<a class="uline single" href="javascript: void(0);" onClick="showDetail11();">修改</a>
									<a class="uline single" href="javascript: void(0);" onClick="">分配</a>
									<a class="uline single" href="javascript: void(0);" onClick="">组合</a>
									<a class="uline single" href="javascript: void(0);" onClick="">拆分</a>
								</td>
							</tr>
							
							</s:iterator>
							
							
					     </table>
		    		</div>
				   
	    			<div style="display:none">
	    				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-list">
					        <TR>
					          <Th  width="87" height="30">序号</Th>
					          <Th  width="103" height="30">分计划名称</Th>
					          <Th  width="103" height="30">计划年度</Th>
					          <Th  width="103" height="30">计划批次</Th>
					          <Th  width="103" height="30">计划状态</Th>
					          <Th  width="152" height="30">操作</Th>
					        </TR >
					       
					        <s:iterator value="listtPlan" id="plan" status="itcount">
					         <tr align="middle">
					          <td><s:property value="#itcount.Count"/></td>
					          <td ><div align="left"><s:property value="#plan.planName"/></div></td>
					          <td ><div align="left"><s:property value="#plan.planYear"/></div></td>
					          <td ><div align="left"><s:property value="#plan.planBatch"/></div></td>
					          <td ><div align="left"><s:property value="#plan.planState"/></div></td>
					          <td ><div align="center">
							  	<a href="javascript: void(0);" onClick="">审核</a>
							</div></td>
					        </tr>
					        </s:iterator>
					        
					    </table>
				    </div>
				    <div style="display:none">
					    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-list">
					        <TR>
					          <Th  width="87" height="30">项目编号</Th>
					          <Th  width="103" height="30">项目名称</Th>
					          <Th  width="103" height="30">申报单位</Th>
					          <Th  width="103" height="30">计划类别</Th>
					          <Th  width="103" height="30">技术领域</Th>
					          <Th  width="103" height="30">申报日期</Th>
					          <Th  width="152" height="30">项目状态</Th>
							   <Th  width="152" height="30">操作</Th>
					        </TR >
					        <s:iterator value="listProjectApplicationFlowState" id="projectApplication" status="itcount">
							<tr>
								 <td><s:property value="#itcount.Count"/></td>
								<td><s:property value="#projectApplication.projectName"/></td>
								<td><s:property value="#projectApplication.applicationUnit" /></td>
								<td><s:property value="#projectApplication.tprojectType.typeRealName" /></td>
								<s:iterator value="#projectApplication.tprojectInfoAs" id="projectA"><td><s:property value="#projectA.technicalFisld" /></td></s:iterator>
				
								<td><s:property value="#projectApplication.startTime"/></td>
								<td><s:property value="#projectApplication.flowStatus"/></td>
								<td align="center">
									<a class="uline single" href="javascript: void(0);" onClick="showDetail11();">修改</a>
									<a class="uline single" href="javascript: void(0);" onClick="">分配</a>
									<a class="uline single" href="javascript: void(0);" onClick="">组合</a>
									<a class="uline single" href="javascript: void(0);" onClick="">拆分</a>
								</td>
							</tr>
							
							</s:iterator>
					       
				        </table>
				    </div>
				  
				   
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>