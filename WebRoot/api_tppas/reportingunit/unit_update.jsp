<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/reportingunit/js/unit_update.js"></script>
<s:hidden id="unitID" name="unitID" value="%{unitID}"></s:hidden>
<!-- 保存按钮提示信息 -->
<label id="comfirmSave" style="display: none"><s:text name="confirm_save_info"/></label>
<!-- 删除按钮提示信息 -->
<label id="comfirmDelete" style="display: none"><s:text name="confirm_del_info"/></label>
<div align="center" style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">企业信息</div>
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					class="t-entRegFrm">
					<TBODY>
						<TR>
							<TD width="15%" height=50 align=right><div align="right">
									<FONT color=red>*</FONT>企业名称
								</div></TD>
							<TD height=50 colspan="2" align=middle class=g2>
								<div align="left">
									<INPUT class="inputA" type="text" name="text"
										style="width: 14.5em;" value="西安申报技术企业">
								</div>
							</TD>
							<TD width="17%" height=50 align=right><div align="right">
									<FONT color=red>*</FONT>企业简称
								</div></TD>
							<TD height=50 colspan="2" align=middle class=g2>
								<div align="left">
									<INPUT class="inputA" type="text" name="text"
										style="width: 14.5em;" value="XASBJSQY">
								</div>
							</TD>
						</TR>
						<TR>
							<TD width="15%" height=50 align=right><div align="right">
									<FONT color=red>*</FONT>类型名称
								</div></TD>
							<TD height=50 colspan="2" align=middle class=g2>
								<div align="left">
									<select name="selete" id="select2" style="width: 200px">
										<option value="1">股份有限公司</option>
										<option value="2">有限责任公司</option>
										<option value="3">合伙公司</option>
									</select>
								</div>
							</TD>
							<TD width="17%" height=50 align=right><div align="right">
									<FONT color=red>*</FONT>注册时间<BR>（企业成立时间）
								</div></TD>
							<TD height=50 colspan="2" align=middle class=g2>
								<div align="left">
									<INPUT class="txt w184p Wdate" type="text" name="text"
										style="width: 14.7em;" onClick="WdatePicker()" />
								</div>
							</TD>
						</TR>
						<TR>
							<TD height=25 align=right><div align="right">
									<FONT color=red>*</FONT>企业所属技术领域
								</div></TD>
							<TD height=25 colspan="5" align="center">
								<div align="left">
									<s:select list="unitTechnology" listKey="itemId"
										style="width:15.0em;" listValue="itemName" id="unitNature"
										name="unitNature"></s:select>
								</div>
							</TD>
						</TR>
						<TR>
							<TD height=25 align=right><div align="right">
									<FONT color=red>*</FONT>经营性质
								</div></TD>
							<TD height=25 colspan="2" align=middle><div align="left">
									<form name="form1" method="post" action="">
										<label> <select name="selete" id="select20"
											style="width: 200px">
												<option value="1">XXX</option>
												<option value="2">XXX</option>
												<option value="3">XXX</option>
										</select>
								</label>
								</form></div></TD>
							<TD width="17%" height=50 align=right><div align="right">
									注册有效期至</div></TD>
							<TD height=50 colspan="2" align=middle class=g2>
								<div align="left">
									<INPUT class="txt w184p Wdate" type="text" name="text"
										style="width: 14.7em;" onClick="WdatePicker()" />
								</div>
							</TD>
						</TR>
						<TR>
							<TD width="15%" height=50 align=right><div align="right">
									<FONT color=red>*</FONT>营业面积
								</div></TD>
							<TD height=50 colspan="2" align=middle class=g2>
								<div align="left">
									<INPUT class="inputA" type="text" name="text"
										style="width: 14.5em;" value="100">
								</div>
							</TD>
							<TD width="17%" height=50 align=right><div align="right">
									<FONT color=red>*</FONT>营业额（<FONT color=red><STRONG>万元</STRONG></FONT>）
								</div></TD>
							<TD height=50 colspan="2" align=middle class=g2>
								<div align="left">
									<INPUT class="inputA" type="text" name="text"
										style="width: 14.5em;" value="50000">
								</div>
							</TD>
						</TR>
						<TR>
							<TD width="15%" height=50 align=right><div align="right">
									<FONT color=red>*</FONT>员工人数（从业人数）
								</div></TD>
							<TD height=50 colspan="2" align=middle class=g2>
								<div align="left">
									<INPUT class="inputA" type="text" name="text"
										style="width: 14.5em;" value="600">
								</div>
							</TD>
							<TD width="17%" height=50 align=right><div align="right">
									<FONT color=red>*</FONT>技术人员总数
								</div></TD>
							<TD height=50 colspan="2" align=middle class=g2>
								<div align="left">
									<INPUT class="inputA" type="text" name="text"
										style="width: 14.5em;" value="20000">
								</div>
							</TD>
						</TR>
						<TR>
							<TD width="15%" height=50 align=right><div align="right">
									<FONT color=red>*</FONT>注册登记类型
								</div></TD>
							<TD height=50 colspan="5" align=middle class=g2>
								<div align="left">
									<select name="selete" id="select18" style="width: 200px">
										<option value="1">XXXX</option>
										<option value="2">XXXX</option>
										<option value="3">XXXX</option>
									</select>
								</div>
							</TD>
						</TR>
						<TR>
							<TD height=25 align=right><div align="right">
									<FONT color=red>*</FONT>行业领域
								</div></TD>
							<TD height=30 colspan="4" align=middle>
							<div align="left" style="vertical-align: middle;">
									<s:select list="unitIndustries1" listKey="itemId" style="width:15.0em;"
								listValue="itemName" id="industries1" name="industries1" onchange="getSecondData('industries2','industries1')">
								</s:select>
								<s:select list="unitIndustries2" listKey="itemId" style="width:15.0em;"
									listValue="itemName" id="industries2" name="industries2" onchange="getSecondData('industries3','industries2')">
								</s:select>
								<s:select list="unitIndustries3" listKey="itemId" style="width:15.0em;"
									listValue="itemName" id="industries3" name="industries3" onchange="getSecondData('industries4','industries3')">
								</s:select>	
								<s:select list="unitIndustries4" listKey="itemId" style="width:15.0em;"
									listValue="itemName" id="industries4" name="industries4">
								</s:select>	
								</div> 
						    </TD>
						</TR>
						<TR>
							<TD height=25 align=right><div align="right">
									<FONT color=red>*</FONT>法人代码
								</div></TD>
							<TD height=30 colspan="2" align=middle><div align="left">
									<INPUT class="inputA" size=30 type=text id="" maxlength="20"
										name="" style="width: 14.5em;" value="51331534345313545" />
								</div></TD>
							<TD height=30 align=right><div align="right">
									<FONT color=red>*</FONT>税务登记号
								</div></TD>
							<TD height=30 align=middle><div align="left">
									<INPUT class="inputA" size=30 type=text id="" maxlength="20"
										name="" style="width: 14.5em;" value="53356265665" />
								</div></TD>
						</TR>
						<TR>
							<TD height=25 align=right><div align="right">
									<FONT color=red>*</FONT>注册地址
								</div></TD>
							<TD height=30 colspan="3" style="vertical-align: middle;">
								<div align="left" style="vertical-align: middle; float: left;width:100%;">
								<s:select list="address1List" listKey="itemId" style="width:15.0em;"
								listValue="itemName" id="address1" name="address1" onchange="getSecondData('address2','address1');">
								</s:select>
								<s:select list="address2List" listKey="itemId" style="width:15.0em;"
									listValue="itemName" id="address2" name="address2" onchange="getSecondData('address3','address2');">
								</s:select>
								<s:select list="address3List" listKey="itemId" style="width:15.0em;"
									listValue="itemName" id="address3" name="address3">
								</s:select>	
								</div>
							</TD>
							<td><INPUT class="inputA" type="text" name="text"
								style="width: 14.5em;" value=""></td>
						</TR>
						<TR>
							<TD height=25 align=right b><div align="right">
									<FONT color=red>*</FONT>注册资金（<FONT color=red><STRONG>万元</STRONG></FONT>）
								</div></TD>
							<TD height=30 colspan="2" align=middle><div align="left">
									<INPUT class="inputA" type="text" name="text"
										style="width: 14.5em;" value="200">
								</div></TD>

							<TD height=30 align=right><div align="right">
									<FONT color=red>*</FONT>邮政编码
								</div></TD>
							<TD height=30 align=middle><div align="left">
									<INPUT class="inputA" type="text" name="text"
										style="width: 14.5em;" value="710077">
								</div></TD>
						</TR>
						<TR>
							<TD width="15%" height=50 align=right><div align="right">
									<FONT color=red>*</FONT>主要服务
								</div></TD>
							<TD height=50 colspan="2" align=middle class=g2>
								<div align="left">
									<INPUT class="inputA" type="text" name="text"
										style="width: 14.5em;" value="">
								</div>
							</TD>
							<TD width="17%" height=50 align=right><div align="right">
									<FONT color=red>*</FONT>主要服务对象
								</div></TD>
							<TD height=50 colspan="2" align=middle class=g2>
								<div align="left">
									<INPUT class="inputA" type="text" name="text"
										style="width: 14.5em;" value="">
								</div>
							</TD>
						</TR>
						<TR>
							<TD height=25 align=right b><div align="right">
									<FONT color=red>*</FONT>行政区域
								</div></TD>
							<TD height=30 colspan="4" align=middle>
							<div align="left">
								<div align="left" style="vertical-align: middle; float: left;width:100%;">
								<s:select list="area1List" listKey="itemId" style="width:15.0em;"
								listValue="itemName" id="area1" name="area1" onchange="getSecondData('area2','area1');">
								</s:select>
								<s:select list="area2List" listKey="itemId" style="width:15.0em;"
									listValue="itemName" id="area2" name="area2" onchange="getSecondData('area3','area2');">
								</s:select>
								<s:select list="area3List" listKey="itemId" style="width:15.0em;"
									listValue="itemName" id="area3" name="area3">
								</s:select>	
								</div>
								</div> 
						   </TD>
						</TR>
						<TR>
							<TD height=25 align=right b><div align="right">
									<FONT color=red>*</FONT>通讯地址
								</div></TD>
							<TD height=30 colspan="4" align=left>
								<div align="left" style="vertical-align: middle; float: left;">
									<s:select list="mailingAddress1List" listKey="itemId" style="width:15.0em;"
									listValue="itemName" id="mailingAddress1" name="mailingAddress1" onchange="getSecondData('mailingAddress2','mailingAddress1');">
									</s:select>
									<s:select list="mailingAddress2List" listKey="itemId" style="width:15.0em;"
										listValue="itemName" id="mailingAddress2" name="mailingAddress2" onchange="getSecondData('mailingAddress3','mailingAddress2');">
									</s:select>
									<s:select list="mailingAddress3List" listKey="itemId" style="width:15.0em;"
										listValue="itemName" id="mailingAddress3" name="mailingAddress3">
									</s:select>	
								</div>
							</TD>
						</TR>
						<TR>
							<TD width="17%" height=50 align=right><div align="right">
									企业介绍</div></TD>
							<TD height=50 colspan="5" align=middle class=g2>
								<div align="left">
									<textarea name="" cols="" rows=""
										style="width: 100%; height: 800%"></textarea>
								</div>
							</TD>
						</TR>
						<TR>
							<TD width="17%" height=50 align=right><div align="right">
									配套信息</div></TD>
							<TD height=50 colspan="5" align=middle class=g2>
								<div align="left">
									<textarea name="" cols="" rows=""
										style="width: 100%; height: 800%"></textarea>
								</div>
							</TD>
						</TR>
						<TR>
							<TD width="17%" height=50 align=right><div align="right">
									经营范围</div></TD>
							<TD height=50 colspan="5" align=middle class=g2>
								<div align="left">
									<textarea name="" cols="" rows=""
										style="width: 100%; height: 800%"></textarea>
								</div>
							</TD>
						</TR>
						<TR>
							<TD height=25 align=right rowspan="3"><div align="right">企业法定代表人</div></TD>
							<TD height=30 width="10%" align=right><FONT color=red>*</FONT>姓名</TD>
							<TD height=30 width="15%" align=left><INPUT class="inputA"
								class="inputA" maxlength="5" size=30 type=text name="text"
								value="王先生"></TD>
							<TD height=30 width="13%" align=right><FONT color=red>*</FONT>手机</TD>
							<TD height=30 width="20%" align=left><INPUT class="inputA"
								class="inputA" maxlength="11" size=30 type=text name="text"
								value="15126598558"></TD>
						</TR>
						<TR>
							<TD height=30 width="12%" align=right><div align="right">
									<FONT color=red>*</FONT>身份证号
								</div></TD>
							<TD height=30 width="30%" align=middle><div align="left">
									<INPUT class="inputA" class="inputA" size=30 type=text
										name="text" maxlength="18" value="610581188605155485">
								</div></TD>
							<TD height=25 align=right><FONT color=red>*</FONT>电话</TD>
							<TD height=30 align=left><INPUT class="inputA"
								class="inputA" size=30 type=text name="text" maxlength="13"
								value="029-5575659"></TD>
						</TR>
						<TR>
							<TD height=30 align=right><FONT color=red>*</FONT>传真</TD>
							<TD height=30 align=left><INPUT class="inputA"
								class="inputA" size=30 type=text name="text" maxlength="13"
								value="029-5265625"></TD>
							<TD height=30 align=right><div align="right">
									<FONT color=red>*</FONT>E-mail
								</div></TD>
							<TD height=30 align=middle><div align="left">
									<INPUT class="inputA" class="inputA" size=30 type=text
										name="text" value="www@163.com">
								</div></TD>
						</TR>
						<TR>
							<TD height=30 align=right rowspan="3"><div align="right">企业负责人</div></TD>
							<TD height=25 align=right><FONT color=red>*</FONT>姓名</TD>
							<TD height=30 align=left><INPUT class="inputA"
								class="inputA" maxlength="5" size=30 type=text name="text"
								value="李女士"></TD>
							<TD height=30 align=right>手机</TD>
							<TD height=30 align=left><INPUT class="inputA"
								class="inputA" maxlength="11" size=30 type=text name="text"
								value="15126598558"></TD>
						</TR>
						<TR>
							<TD height=25 align=right><FONT color=red>*</FONT>电话</TD>
							<TD height=30 align=left><INPUT class="inputA"
								class="inputA" size=30 type=text name="text" maxlength="13"
								value="029-5575659"></TD>
							<TD height=30 align=right>企业传真</TD>
							<TD height=30 align=left><INPUT class="inputA"
								class="inputA" size=30 type=text name="text" maxlength="13"
								value="029-5265625"></TD>
						</TR>
						<TR>

							<TD height=30 align=right><div align="right">
									<FONT color=red>*</FONT>E-mail
								</div></TD>
							<TD height=30 align=middle colspan="3"><div align="left">
									<INPUT class="inputA" class="inputA" size=30 type=text
										name="text" value="werw@163.com">
								</div></TD>
						</TR>
						<TR>
							<TD height=30 align=right><div align="right">企业是否上市</div></TD>
							<TD width="13%" height=25 align=left colspan="2">&nbsp;&nbsp;
								<s:radio list="#{'1':'是','0':'否'}" id="listedFlag" 
									name="tcompanyInfo.listedFlag" listKey="key" 
												   listValue="value" label="IsSpecial" 
									value="%{tcompanyInfo.listedFlag}">
							</s:radio>
							</TD>
							<TD height=30 align=right>企业上市代码</TD>
							<TD width="25%" height=30 align=middle>
								<div align="left">
									<INPUT class="inputA" class="inputA" size=30 type=text id=""
										name="" value="4564345243434345" />
								</div>
							</TD>
						</TR>
						<TR>
							<TD height=25 align=right><div align="right">是否引入风险投资</div></TD>
							<TD height=30 align=left colspan="2">&nbsp;&nbsp; <s:radio list="#{'1':'是','0':'否'}" id="listedFlag" 
									name="tcompanyInfo.listedFlag" listKey="key" 
												   listValue="value" label="IsSpecial" 
									value="%{tcompanyInfo.listedFlag}">
							</s:radio>
							</TD>
							<TD height=30 align=right>投资额（<FONT color=red><STRONG>万元</STRONG></FONT>）
							</TD>
							<TD height=30 align=middle><div align="left">
									<INPUT class="inputA" class="inputA" size=30 type=text id=""
										name="" value="600" />
								</div></TD>
						</TR>
						<TR>
							<TD height=30 align=right><SPAN style="COLOR: red">*
							</SPAN>企业上年度销售收入</TD>
							<TD height=30 align=middle colspan="5"><div align="left">
									<form name="form1" method="post" action="">
										<label> <select name="selete" id="select16"
											style="width: 200px">
												<option value="1">0~500万</option>
												<option value="2">500万~5000万</option>
												<option value="3">5000万~20,000万</option>
												<option value="4">>20,000万</option>
										</select>
								 </label>
								</form></div></TD>
						</TR>
						<TR>
							<TD height=25 align=middle colSpan=5><div align="center">股权结构</div></TD>
						</TR>
						<TR>
							<TD colSpan=5>
								<TABLE id="equityList" class="t-noboder" border=0 cellSpacing=0 cellPadding=0
									width="100%">
									<TBODY id=personId>
										<TR id="equityTr0">
											<TD height=25 width="17%" align=middle class="noboder"><div
													align="center">
													<FONT color=red>*</FONT>股东名称
												</div></TD>
											<TD height=25 width="17%" align=middle><div
													align="center">
													<FONT color=red>*</FONT>投资者经济形态
												</div></TD>
											<TD height=25 width="17%" align=middle><div
													align="center">
													<FONT color=red>*</FONT>法人代码或身份证
												</div></TD>
											<TD height=25 width="8%" align=middle><div
													align="center">
													<FONT color=red>*</FONT>上市公司
												</div></TD>
											<TD height=25 width="8%" align=middle><div
													align="center">
													<FONT color=red>*</FONT>海外公司
												</div></TD>
											<TD height=25 width="8%" align=middle><div
													align="center">
													<FONT color=red>*</FONT>所占股份（%）
												</div></TD>
											<TD height=25 width="17%" align=middle><div
													align="center">投资方式</div></TD>
											<TD height=25 width="8%" align=middle><div
													align="center">
													<INPUT class="button" type="button" class="button"
														value="新增" onclick="addEquity();"/>
												</div></TD>
										</TR>
										<s:if test="equityList.size > 0">
										<s:iterator value="equityList" status="rowData">
										<s:hidden id="equityUseId%{#rowData.count}" name="equityList[%{#rowData.count}].equityUseId" value="%{equitingUseId}"></s:hidden>
										<TR id="equityTr<s:property value='%{#rowData.count}' escape='true'/>">
											<TD height=25 align=middle>
												<div align="left">
													<INPUT class="inputA" style="width: 13.5em" type="text"
														id="GDMC<s:property value='%{#rowData.count}' escape='true'/>" 
														name="equityList[<s:property value='%{#rowData.count}' escape='true'/>].GDMC" 
														value="<s:property value='%{GDMC}' escape='true'/>"  
														onblur="blurText(this,'股东名称',1,0);" onfocus="focusText(this);" maxlength="20"/>
													</div>
												</TD>
											<TD height=25 align=middle>
												<div align="center">
													<form name="form1" method="post" action="">
														<s:select list="#{'1':'自然人','2':'国有','3':'集体','4':'外贸','5':'合营','6':'股份制'}"
														id="TZZJJXT<s:property value='%{#rowData.count}' escape='true'/>" 
														name="equityList[<s:property value='%{#rowData.count}' escape='true'/>].TZZJJXT" 
															style="width: 14.5em;"></s:select>
													</form>
												</div>
											</TD>
											<TD height=25 align=middle>
												<div align="left">
													<INPUT class="inputA" style="width: 13.5em;" type="text"
														id="FRDB<s:property value='%{#rowData.count}' escape='true'/>" 
														name="equityList[<s:property value='%{#rowData.count}' escape='true'/>].FRDB" 
														value="<s:property value='%{FRDB}' escape='true'/>"  
														onblur="blurText(this,'法人代表',1,0);" onfocus="focusText(this);" maxlength="20"/>
												</div>
											</TD>
											<TD height=25 align=center>
											<s:radio list="#{'1':'是','0':'否'}" 
											id="SSGS<s:property value='%{#rowData.count}' escape='true'/>" 
											name="equityList[<s:property value='%{#rowData.count}' escape='true'/>].SSGS"
											listKey="key" listValue="value" label="IsSpecial" 
											value="<s:property value='%{SSGS}' escape='true'/>">
											</s:radio>
											</TD>
											<TD height=25 align=center>
											<s:radio list="#{'1':'是','0':'否'}" 
											id="HWGS<s:property value='%{#rowData.count}' escape='true'/>" 
											name="equityList[<s:property value='%{#rowData.count}' escape='true'/>].HWGS"
											listKey="key" listValue="value" label="IsSpecial" 
											value="<s:property value='%{HWGS}' escape='true'/>">
											</s:radio>
											</TD>
											<TD height=25 align=middle>
											<div align="left">
												<INPUT class="inputA" style="width: 13.5em" type="text"
												id="SZGF<s:property value='%{#rowData.count}' escape='true'/>" 
												name="equityList[<s:property value='%{#rowData.count}' escape='true'/>].SZGF" 
												value="<s:property value='%{SZGF}' escape='true'/>"  
												onblur="blurText(this,'所占股份',1,0);" onfocus="focusText(this);" maxlength="3"/>
											</div>
											</TD>
											<TD height=25 align=middle>
											<div align="left">
												<INPUT class="inputA" style="width: 13.5em" type="text"
												id="TZFS<s:property value='%{#rowData.count}' escape='true'/>" 
												name="equityList[<s:property value='%{#rowData.count}' escape='true'/>].TZFS" 
												value="<s:property value='%{TZFS}' escape='true'/>"  
												onblur="blurText(this,'投资方式',1,0);" onfocus="focusText(this);" maxlength="20"/>
											</div>
											</TD>
											<TD height=25 align=middle class="t-list">
												<div align="center">
													<s:if test="%{#rowData.count > 3}">
													<a href="javascript: void(0);"  class="line single" onclick="deleteEquity(this,'1','${equitingUseId}');">删除</a>
													</s:if>
													<s:else>
													    &nbsp;
													</s:else> 
												</div>
											</td>
										</tr>
									 	</s:iterator>
										</s:if> 
									</TBODY>
								</TABLE>
							</TD>
						</TR>
					</TBODY>
				</table>		
				<div align="center" style="width: 95%">
					<INPUT class="button" type="button" name="button"
						name="btnSave" id="btnSave"  value="保存"> <INPUT class="button"
						type="button" name="button" onclick="goBack()" value="返回">
				</div>
			</div>
		</div>
	</div>
</div>