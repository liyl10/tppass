<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <title>企业信息</title>
<script type="text/javascript">
javascript:window.history.forward(1); 
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/api_tppas/report/css/waitThingItem.css" />
<LINK rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/api_tppas/css/style.css">
<LINK rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/api_tppas/css/layout.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/install_upms.js?ver=1.0.0"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/jquery.msgbox.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/My97DatePicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/chosen.jquery.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/api_tppas/css/chosen.css" />
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/api_tppas/css/btn.css" /></head>
<body>
<div id="mainContent"
			style="background: none repeat scroll 0 0 #FFFFFF;">
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">企业信息</div> 
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					class="t-entRegFrm">
					<TBODY>
						<TR>
							<TD width="15%" height=50 align=right  ><div
									align="right" >
									<FONT color=red>*</FONT>企业名称</div></TD>
							<TD height=120 colspan="2" align=middle class=g2>
								<div align="left">
									<input style="width: 91.4%; height:1.6em;ime-mode: disabled;"	type="text" class="inputA" id=companyName name="orgInfo.uoiName" 
									size=50 value="<s:property value='%{orgInfo.uoiName}' escape='true' />"
									readonly="readonly"  maxlength="58">
								</div>
							</TD>
							<TD width="17%" height=50 align=right><div
									align="right">
									<FONT color=red>*</FONT>注册时间（企业成立时间）
								</div></TD>
							<TD width="25%" height=50 align=middle><div 
									align="left" style="vertical-align: middle;">
									<INPUT  type="text" class="inputA" id="registerDate" 
									readonly="readonly"  name="orgInfo.regdate" size=15 type=text 
									value="<s:property value='orgInfo.regdate' />"
								</div></TD>
						</TR>
						<TR>
						 <TD height=25 align=right>
						  <div align="right"><FONT color=red>*</FONT>主营产品（服务）所属技术领域</div>
						 </TD>
						<TD width="25%" height=100 align=middle colspan="2"><div 
									align="left" style="vertical-align: middle;">
									<input style="width: 91.4%; height:1.6em;ime-mode: disabled;"	type="text" class="inputA" id=technosphereName name="technosphereName" 
									readonly="readonly" size=30 value="<s:property value='%{technosphereName}' escape='true' />"
									  maxlength="28">
								</div></TD>
							<TD height=25 align=right><div
									align="right" ><FONT color=red>*</FONT>注册类型</div></TD>
							<TD height=25 align=middle ><div align="left">
									<input	type="text" class="inputA" id=busiType name="orgInfo.busiType" 
									readonly="readonly" size=30 value="<s:property value='%{orgInfo.busiType}' escape='true' />"
									  maxlength="28">
								</div>
							</TD>
						</TR>
						
						<TR >
							<TD height=25 align=right><div
									align="right" ><FONT color=red>*</FONT>行业领域</div></TD>
							<TD height=120 colspan="4" align=middle ><div
									align="left" style="vertical-align: middle;">
							<input style="width: 91.4%; height:1.6em;ime-mode: disabled;" 	type="text" class="inputA" id=busiTypeName name="busiTypeName" 
									readonly="readonly"  value="<s:property value='%{busiTypeName}' escape='true' />"
									 >
							</TD>
						</TR>
						<TR >
							<TD height=25 align=right><div
									align="right" ><FONT color=red>*</FONT>组织机构代码证</div></TD>
							<TD height=30 colspan="2" align=middle ><div
									align="left">
									<INPUT class="inputA" size=30 type=text id="codeNum" maxlength="20"
										readonly="readonly" name="orgInfo.codeNum" value="<s:property value='%{orgInfo.codeNum}' escape='true'/>" >
								</div></TD>
							<TD height=30 align=right ><div
									align="right"><FONT color=red>*</FONT>国税号</div></TD>
							<TD height=30 align=middle><div align="left">
									<INPUT class="inputA"
									  size=30 type=text id="centralTaxNum" maxlength="20" 
										readonly="readonly" name="orgInfo.centralTaxNum" value="<s:property value='%{orgInfo.centralTaxNum}' escape='true'/>">
								</div></TD>
						</TR>
						<TR >
							<TD height=25 align=right><div
									align="right"><FONT color=red>*</FONT>注册地址</div></TD>
							<TD height=30 colspan="4" style="vertical-align: middle;">
							<input style="width: 91.4%; height:1.6em;ime-mode: disabled;" 	type="text" class="inputA" id=addrProvinceName name="addrProvinceName" 
									 readonly="readonly" value="<s:property value='%{addrProvinceName}' escape='true' />"
									 >
									</TD>
						</TR>
						<TR >
							<TD height=25 align=right ><div
									align="right"><FONT color=red>*</FONT>注册资金（<FONT
								color=red><STRONG>万元</STRONG></FONT>）</div></TD>
							<TD height=30 colspan="2" align=middle><div
									align="left">
									<INPUT class="inputA"  style="ime-mode: disabled;"  size=30 type=text  maxlength="20"
									id=registerCap name=orgInfo.regcap 
									readonly="readonly" value="<s:property value='%{orgInfo.regcap}' escape='true'/>"
								</div></TD>
								
							<TD height=30 align=right ><div
									align="right"><FONT color=red>*</FONT>邮政编码</div></TD>
							<TD height=30 align=middle ><div align="left">
									<INPUT class="inputA" size=30 type=text id=companyZipcode maxlength="6" style="ime-mode: disabled;"
										readonly="readonly" name="orgInfo.postcode" value="<s:property value='%{orgInfo.postcode}' escape='true'/>"
										>
								</div></TD>
						</TR>
						<TR >
							<TD height=25 align=right>
							  <div align="right"><FONT color=red>*</FONT>公司地址</div>
							</TD>
							<TD height=30 colspan="4" style="vertical-align: middle;">
							<input style="width: 91.4%; height:1.6em;ime-mode: disabled;" 	type="text" class="inputA" id=provinceName name="provinceName" 
									 readonly="readonly" value="<s:property value='%{provinceName}' escape='true' />"
									 
						   </TD>
						</TR>
						<TR>
							<TD height=25 align=right rowspan="2"><div
									align="right">企业法定代表人</div></TD>
							<TD height=30 width="10%" align=right><FONT color=red>*</FONT>姓名</TD>
							<TD height=30 width="15%" align=left ><INPUT
								id=legalPerson class="inputA" maxlength="20"
								size=30 type=text name=orgInfo.corporation
								readonly="readonly" value="<s:property value='%{orgInfo.corporation}' escape='true'/>">
								</TD>
							<TD  height=30 width="13%" align=right><FONT color=red>*</FONT>手机</TD>
							<TD height=30 width="20%" align=left >
							<INPUT id=legalPhone class="inputA" maxlength="11" 
								 size=30 type=text name=orgInfo.corporationMobile maxlength="11"
								readonly="readonly" value="<s:property value='%{orgInfo.corporationMobile}' escape='true'/>" >
							</TD>
						</TR>
						<TR>
							<TD height=30 width="12%" align=right><div
									align="right"><FONT color=red>*</FONT>电话</div></TD>
							<TD height=30 width="30%" align=middle ><div
									align="left">
							<INPUT class="inputA" size=30 type=text id=legalTel
										name=orgInfo.corporationPhone maxlength="18"
										readonly="readonly" value="<s:property value='%{orgInfo.corporationPhone}' escape='true'/>">
								</div></TD>
							<TD height=25 align=right><FONT color=red>*</FONT>EAMIL</TD>
							<TD height=30 align=left >
									<INPUT class="inputA" size=30 type=text id=legalEmail
										name=orgInfo.corporationEmail maxlength="18"
										readonly="readonly" value="<s:property value='%{orgInfo.corporationEmail}' escape='true'/>">
							</TD>
						</TR>
						<TR>
							<TD height=25 align=right rowspan="3"><div
									align="right">联系人</div></TD>
							<TD height=30 width="10%" align=right><FONT color=red>*</FONT>姓名</TD>
							<TD height=30 width="15%" align=left ><INPUT
								id=contactPerson class="inputA" maxlength="20"
								size=30 type=text name="orgInfo.linkman"
								readonly="readonly" value="<s:property value='%{orgInfo.linkMan}' escape='true'/>">
								</TD>
							<TD  height=30 width="13%" align=right><FONT color=red>*</FONT>手机</TD>
							<TD height=30 width="20%" align=left >
							<INPUT class="inputA" maxlength="11" id="contactPhone"
								 size=30 type=text name=orgInfo.linkManMobile 
								readonly="readonly" value="<s:property value='%{orgInfo.linkManMobile}' escape='true'/>">
							</TD>
						</TR>
						<TR>
							<TD height=30 width="12%" align=right><div
									align="right"><FONT color=red>*</FONT>电话</div></TD>
							<TD height=30 width="30%" align=middle ><div
									align="left">
									<INPUT class="inputA" size=30 type=text id=contactTel
										name=orgInfo.linkManPhone maxlength="18"
										readonly="readonly" value="<s:property value='%{orgInfo.linkManPhone}' escape='true'/>">
								</div></TD>
							<TD height=25 align=right><FONT color=red>*</FONT>传真</TD>
							<TD height=30 align=left >
							<INPUT class="inputA" size=30 type=text id=nbiFax
										name=orgInfo.nbiFax maxlength="18"
										readonly="readonly" value="<s:property value='%{orgInfo.nbiFax}' escape='true'/>">
							</TD>
						</TR>
						<TR>
							<TD width="17%" height=50 align=right><div
									align="right">
									<FONT color=red>*</FONT>EAMIL
								</div></TD>
							<TD width="25%" height=50 align=middle >
							<div align="left" style="vertical-align: middle;">
									<INPUT class="inputA" size=30 type=text id=orgEmail
										name=orgInfo.orgEmail maxlength="18"
										readonly="readonly" value="<s:property value='%{orgInfo.orgEmail}' escape='true'/>">
								 </div>
							</TD>
						</TR>
						<TR>
							<TD height=25 align=middle colSpan=5><div
									align="center">股权结构</div></TD>
						</TR>
						<TR>
							<TD colSpan=5>
								<TABLE class="t-noboder" border=0 cellSpacing=0 cellPadding=0 width="100%">
									<TBODY id=personId>
										<TR>
											
											<TD height=25 width="20%" align=middle class="noboder"><div
													align="center"><FONT color=red>*</FONT>股东名称
													</div></TD>
											<TD height=25 width="10%" align=middle><div
													align="center"><FONT color=red>*</FONT>投资者经济形态</div></TD>
											<TD height=25 width="18%" align=middle><div
													align="center"><FONT color=red>*</FONT>法人代码或身份证
													</div></TD>
											<TD height=25 width="11%" align=middle><div
													align="center"><FONT color=red>*</FONT>上市公司</div></TD>
											<TD height=25 width="11%" align=middle><div
													align="center"><FONT color=red>*</FONT>海外公司</div></TD>
											<TD height=25 width="8%" align=middle><div
													align="center"><FONT color=red>*</FONT>所占股份（%）
													</div></TD>
											<TD height=25 width="15%" align=middle><div
													align="center">投资方式
													</div></TD>

										</TR>
										<s:if test="%{viewList.size > 0}">
											<s:iterator value="viewList" status="rowData">
												<TR>
												<s:hidden id="person%{#rowData.count}" name="viewList[%{#rowData.count}].ownershipId" value="%{ownershipId}"></s:hidden>
												
												<TD height=25 align=middle><div
														align="middle"><input class="inputA" style="width:12em" type="text" maxlength="20"
														id="stockName<s:property value='%{#rowData.count}' escape='true'/>" 
														name="viewList[<s:property value='%{#rowData.count}' escape='true'/>].stockName" 
														readonly="readonly" value="<s:property value='%{stockName}' escape='true'/>">
														</div></TD>
												<TD height=25 align=middle><div
														align="middle">
														<input class="inputA" style="width:11.5em" type="text" maxlength="20"
														id="stockInvestor<s:property value='%{#rowData.count}' escape='true'/>" 
														name="viewList[<s:property value='%{#rowData.count}' escape='true'/>].stockInvestor" 
														readonly="readonly" value="<s:property value='%{stockInvestor}' escape='true'/>">
														</div></TD>
														
												<TD height=25  align=middle><div
														align="middle">
														<input class="inputA" style="width:11.5em" type="text" maxlength="20"
														id="idcard<s:property value='%{#rowData.count}' escape='true'/>" 
														name="viewList[<s:property value='%{#rowData.count}' escape='true'/>].idCard" 
														readonly="readonly" value="<s:property value='%{idCard}' escape='true'/>">
														</div></TD>
													<TD height=25  align=center >
														<s:radio list="#{'1':'是','0':'否'}" id="isSeason%{#rowData.count}" 
															disabled="true" name="viewList[%{#rowData.count}].isSeason" listKey="key" 
																		   listValue="value"  
															value="%{isSeason}" >
														</s:radio>
													</TD>
													<TD height=25  align=center >
														<s:radio list="#{'1':'是','0':'否'}" id="outsideFlag%{#rowData.count}" 
															disabled="true" name="viewList[%{#rowData.count}].isOverseas" listKey="key" 
																		   listValue="value" 
															value="%{isOverseas}">
														</s:radio>
													</TD>
												
												<TD height=25  align=middle><div
														align="middle"><input class="inputA" style="width:4em;ime-mode: disabled;" type="text" maxlength="5"
														id="stockScale<s:property value='%{#rowData.count}' escape='true'/>" 
														name="viewList[<s:property value='%{#rowData.count}' escape='true'/>].stockScale" 
														readonly="readonly" value="<s:property value='%{stockScale}' escape='true'/>">
														</div></TD>
												
												<TD height=25  align=middle><div
													align="middle">
													<input class="inputA" style="width:8.5em" type="text" maxlength="20"
														id="stockMode<s:property value='%{#rowData.count}' escape='true'/>" 
														name="viewList[<s:property value='%{#rowData.count}' escape='true'/>].stockMode" 
														readonly="readonly" value="<s:property value='%{stockMode}' escape='true'/>">
												</div></TD>
												</TR>
											</s:iterator>
										</s:if>
										
									</TBODY>
								</TABLE>
							</TD>
						</TR>
						<TR>
							<TD colSpan=5>&nbsp;</TD>
						</TR>
					</TBODY>
				</TABLE>
			</div>
		</div>
		<div align="center" style="width:95%">
		    <input class="button save" type="button" onclick="window.close();" name="savePwd"  value="关闭">           
		</div>
	</div>
</div>
</div>
</body>
</html>