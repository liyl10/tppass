<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>待办事项</title>
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/api_tppas/report/css/waitThingItem.css" />
<LINK rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/api_tppas/css/style.css">
<LINK rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/api_tppas/css/layout.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/install_upms.js?ver=1.0.0"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/jquery.msgbox.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/My97DatePicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/chosen.jquery.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/api_tppas/css/chosen.css" />
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/api_tppas/css/btn.css" />

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
		<span>计划处工作人员：${sysUser.userName }！ 欢迎登陆综合管理系统 </span>
	</div>
</div>
<div>&nbsp;</div>
<div align="center" style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="tabs">
				    <ul id="tabs">
				        <li class="tab-nav-action">待初审项目</li>
				        <li class="tab-nav">待审核项目</li>
				        <li class="tab-nav">待处长审核项目</li>
				        <li class="tab-nav">待合同审核项目</li>
				        <li class="tab-nav">待监理项目</li>
				        <li class="tab-nav">待验收项目</li>
				    </ul>
				</div>
				<div id="tabs-body" class="tabs-body">
				    <div style="display:block">
				    	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-list">
							<tr align="center">
								<th>序号</th>
								<th>项目名称</th>
								<th>申报单位</th>
								<th>单位性质</th>
								<th>计划类别</th>
								<th>技术领域</th>
								<th>状态</th>
								<th align="center">操作</th>
							</tr>
							<s:iterator  value="listProjectApplicationWaitCheck" id="projectApplication" status="st">
							  <tr>
							<td><s:property value="#st.Count"/></td>
							<td>${projectApplication.projectName }</td>
								<td>${projectApplication.applicationUnit }</td>
									<s:iterator value="#projectApplication.tprojectInfoAs" id="projectA">
									<td><s:property value="apiMitemService.getMitemNameById(#projectA.unitProperties)" /></td>
									<td><s:property value="#projectApplication.tprojectType.typeRealName" /></td></s:iterator>
											<td><s:property value="apiMitemService.getMitemNameById(#projectA.technicalFisld)" /></td>
										<td><s:property value="#projectApplication.flowStatus"/></td>
							 <td align="center">
									<a class="uline single" href="javascript: void(0);" onclick="showDetail1()">项目初审</a>
								</td>
							  </tr>
							</s:iterator>
						
							
					     </table>
		    		</div>
				    <div style="display:none">
				    	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-list">
							<tr align="center">
								<th>序号</th>
								<th>项目名称</th>
								<th>申报单位</th>
								<th>单位性质</th>
								<th>计划类别</th>
								<th>技术领域</th>
								<th>状态</th>
								<th align="center">操作</th>
							</tr>
								<s:iterator  value="listWaitingApplicationCheckState" id="projectApplication" status="st">
							  <tr>
							<td><s:property value="#st.Count"/></td>
							<td>${projectApplication.projectName }</td>
								<td>${projectApplication.applicationUnit }</td>
									<s:iterator value="#projectApplication.tprojectApplication.tprojectInfoAs" id="projectA">
									<td><s:property value="apiMitemService.getMitemNameById(#projectA.unitProperties)" /></td>
									<td>		<s:property value="#projectApplication.tprojectType.typeRealName" /></td>
									<td><s:property value="apiMitemService.getMitemNameById(#projectA.technicalFisld)" /></td></s:iterator>
										<td>${projectApplication.projectName }</td>
										<td><s:property value="#projectApplication.flowStatus"/></td>
							 <td align="center">
									<a class="uline single" href="javascript: void(0);" onclick="showDetail1()">审核</a>
								</td>
							  </tr>
							</s:iterator>
					     </table>
		    		</div>
	    			<div style="display:none">
	    				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-list">
					        <TR>
					          <Th  width="87" height="30">项目编号</Th>
					          <Th  width="103" height="30">项目名称</Th>
					          <Th  width="103" height="30">项目状态</Th>
					          <Th  width="152" height="30">操作</Th>
					        </TR >
					        <s:iterator value="listWaitChuzhangCheckProject" id="projectApplication" status="st">
					        <tr>
					     	<td><s:property value="#st.Count"/></td>
					         <td>${projectApplication.projectName }</td>
					        	<td><s:property value="#projectApplication.flowStatus"/></td>
					        	 <td ><div align="center"><a href="javascript: void(0);" onclick="showAudit()">审核</a></div></td>
					        </tr>
					        </s:iterator>
					    </table>
				    </div>
				    <div style="display:none">
					    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-list">
					        <TR>
					          <Th  width="87" height="30">项目编号</Th>
					          <Th  width="103" height="30">项目名称</Th>
					          <Th  width="103" height="30">提交合同日期</Th>
					          <Th  width="103" height="30">合同状态</Th>
					          <Th  width="152" height="30">操作</Th>
					        </TR >
					        <s:iterator value="listWaitContractCheckProject" id="contract" status="st">
					        <tr>
					        <td><div align="left"><s:property value="#contract.tprojectApplication.projectNumber"></s:property></div></td>
					         <td><div align="left"><s:property value="#contract.tprojectApplication.projectName"></s:property></div></td>
					          <td><div align="left"><s:property value="#contract.contractDate"></s:property></div></td>
					           <td><div align="left"><s:property value="#contract.contractStatus"></s:property></div></td>
					            <td><div align="center"><a href="javascript: void(0);" onclick="showDetail()">详细</a><a href="javascript: void(0);" onclick="showAudit()">审核</a></div></td>
					        </tr>
					        </s:iterator>
					        
				        </table>
				    </div>
				    <div style="display:none">
					    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-list">
							<tr align="center">
											<th>项目编号</th>
											<th>项目名称</th>
											<th>申报单位</th>
											<th>申报时间</th>
											<th>监理状态</th>
											<th align="center">操作</th>
							</tr>
							<s:iterator value="listWaitSupervisorProject" id="supervisorProject" status="st">
							<tr>
							   <td><div align="left"><s:property value="#supervisorProject.tprojectApplication.projectNumber"></s:property></div></td>
					         <td><div align="left"><s:property value="#supervisorProject.tprojectApplication.projectName"></s:property></div></td>
							 <td><div><s:property value="#supervisorProject.tprojectApplication.applicationUnit"></s:property></div></td>
							 <td><div><s:property value="#supervisorProject.supervisorStarttime"></s:property></div></td>
							  <td><div><s:property value="#supervisorProject.supervisorState"></s:property></div></td>
							  <td align="center">
									<a href="javascript: void(0);" class="uline single" onclick="showDetail()">监理申请</a>
									<a href="javascript: void(0);" class="uline single" onclick="showDetail1()">监理报告</a>
								</td>
							  
							</tr>
							</s:iterator>
							
						</table>
				    </div>
				    <div style="display:none">
					    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-list">
					        <TR >
					          <Th  width="87" >项目编号</Th>
					          <Th  width="103" >项目名称</Th>
					          <Th  width="117" >填表日期</Th>
					          <Th  width="102" >计划类型</Th>
					          <Th  width="102" >验收状态</Th>
					          <Th  width="152" >操作</Th>
					        </TR >
					        <s:iterator value="listWaitAcceptanceProject" id="acceptanceProject" status="st">
					           <tr>
					            <td>	<s:property value="#acceptanceProject.tprojectApplication.projectNumber" /></td>
					         <td><div align="left"><s:property value="#supervisorProject.tprojectApplication.projectName"></s:property></div></td>
					           <td><div  align="left"><s:property value="#acceptanceProject.createTime"></s:property></div></div></td>
					           <td><div  align="left"><s:property value="#acceptanceProject.tprojectApplication.tprojectType.typeRealName" /></div></div></td>
					              <td ><div align="left">
					               <s:if test="#acceptanceProject.acceptanceStatus==@com.hopsun.tppas.common.Constants@WAITINGPROJECT_CHECK_STATE">
					               已申请
					               </s:if>
					              
					              </div></td>
					              <td ><div align="center"><a href="javascript: void(0);" onclick="showDetail()">验收</a></div></td>
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