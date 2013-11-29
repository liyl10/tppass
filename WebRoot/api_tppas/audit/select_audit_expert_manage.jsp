<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<link rel=stylesheet type=text/css href="${pageContext.request.contextPath}/api_tppas/css/style.css">
<link rel=stylesheet type=text/css href="${pageContext.request.contextPath}/api_tppas/css/layout.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/jquery/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/jquery.form.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/install_upms.js?ver=1.0.0"></script>
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/api_tppas/js/artDialog/skins/blue.css" />
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/chosen.jquery.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/api_tppas/css/chosen.css" />
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/api_tppas/css/btn.css" />

<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/artDialog/artDialog.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/artDialog/plugins/iframeTools.source.js"></script>

<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/api_tppas/css/global-expert.css" />
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/api_tppas/css/sub-category.css" />

<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/audit/js/select_audit_expert_manage.js"></script>

<s:if test="key==1">
	<label id="path" style="display: none">http://xmkadmin1.xatrm.com</label>
</s:if>
<s:else>
	<label id="path" style="display: none">${pageContext.request.contextPath}</label>
</s:else>

<label id="skillJob" style="display: none"><s:property value='@com.hopsun.tppas.common.Constants@SKILLJOB_PROFESSOR'/></label>
<s:hidden id="groupId" name="groupId" value="%{groupId}"></s:hidden>
<s:hidden id="key" name="key" value="%{key}"></s:hidden>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF; width: 97%;">
	<div style="text-align: left;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">专家选择</div>
					<s:hidden id="param" name="param"></s:hidden>
					<div>
						<form id="searchForm">
							<div class="filter_box" sizcache="1" sizset="29">
								<div class=inner sizcache="1" sizset="29">
									<ul sizcache="1" sizset="29">
										<li class="cls selected" sizcache="1" sizset="29" id="selected">
											<label>
												<strong class="black">已选条件：</strong>
											</label> 
											<div class=innerB sizcache="1" sizset="29">
												<div id="newSelect">
													<div sizcache='1' sizset='29' id='123'>
														<a class="current mr10" id="456" onclick="deleteItem(this,'dimfilter6','&skilljobType=<s:property value='@com.hopsun.tppas.common.Constants@SKILLJOB_PROFESSOR'/>');" cmImpressionSent="1">
															正高
														</a>
													</div>
												</div>
												<a class="fl blue" href="#" cmImpressionSent="1" onclick="reselect();">重置筛选条件</a> 
											</div>
											<div class=clear></div>
										</li>
										<li id=input1 class=cls sizcache="1" sizset="29" style="text-align: middle;">
												<label>专家姓名：</label> 
												<div class=innerB sizcache="1" sizset="29" >
													<div sizcache="1" sizset="29">
														<input type="text" id="expertName" name="expertName" class="inputB"/>
													</div>
													<div sizcache="1" sizset="29" class="t-list-1">
														<a href="javascript: void(0);" class="uline single" onclick="submitByName();">确定</a>
													</div>
												</div>
										</li>
										<s:if test="sexList.size > 0">
											<li id=dimfilter1 class=cls sizcache="1" sizset="29">
												<label>专家性别：</label> 
												<div class=innerB sizcache="1" sizset="29">
												<s:iterator value="sexList"  status="rowData">
													<div sizcache="1" sizset="29">
														<a href="#" cmImpressionSent="1" onclick="selected(this,'&sex=${itemId}');">${itemName}</a>
													</div>
												</s:iterator>
												</div>
											</li>
										</s:if>
										<s:if test="sexList.size > 0">
											<li id=dimfilter2 class=cls sizcache="1" sizset="29">
												<label>专家类型：</label> 
												<div class=innerB sizcache="1" sizset="29">
												<s:iterator value="expertTypeList"  status="rowData">
													<div sizcache="1" sizset="29">
														<a href="#" cmImpressionSent="1" onclick="selected(this,'&expertType=${itemId}');">${itemName}</a>
													</div>
												</s:iterator>
												</div>
											</li>
										</s:if>
										<s:if test="birthdayYearList.size > 0">
											<li id=dimfilter3 class=cls sizcache="1" sizset="29">
												<label>出生年份：</label> 
												<div class=innerB sizcache="1" sizset="29">
												<s:iterator value="birthdayYearList"  status="rowData">
													<div sizcache="1" sizset="29">
														<a href="#" cmImpressionSent="1" onclick="selected(this,'&birthdayYear=${itemDesc}');">${itemName}</a>
													</div>
												</s:iterator>
												</div>
											</li>
										</s:if>
										<s:if test="schoolingTypeList.size > 0">
											<li id=dimfilter5 class=cls sizcache="1" sizset="29">
												<label>学历：</label> 
												<div class=innerB sizcache="1" sizset="29">
												<s:iterator value="schoolingTypeList"  status="rowData">
													<div sizcache="1" sizset="29">
														<a href="#" cmImpressionSent="1" onclick="selected(this,'&schoolingType=${itemId}');">${itemName}</a>
													</div>
												</s:iterator>
												</div>
											</li>
										</s:if>
										<s:if test="skilljobTypeList.size > 0">
											<li id=dimfilter6 class=cls sizcache="1" sizset="29" ref1="listHidden" temp="none" style="display: none;">
												<label>专家职称：</label> 
												<div class=innerB sizcache="1" sizset="29">
												<s:iterator value="skilljobTypeList"  status="rowData">
													<div sizcache="1" sizset="29">
														<a href="#" cmImpressionSent="1" onclick="selected(this,'&skilljobType=${itemId}');">${itemName}</a>
													</div>
												</s:iterator>
												</div>
											</li>
										</s:if>
										<s:if test="expertJobTypeList.size > 0">
											<li id=dimfilter7 class=cls sizcache="1" sizset="29" ref1="listHidden" >
												<label>专家职务：</label> 
												<div class=innerB sizcache="1" sizset="29">
												<s:iterator value="expertJobTypeList"  status="rowData">
													<div sizcache="1" sizset="29">
														<a href="#" cmImpressionSent="1" onclick="selected(this,'&expertJobType=${itemId}');">${itemName}</a>
													</div>
												</s:iterator>
												</div>
											</li>
										</s:if>
										<s:if test="expertmajorTypeList.size > 0">
											<li id=dimfilter8 class=cls ref1="listHidden" sizcache="1" >
												<label>专业：</label> 
												<div class="innerB" sizcache="1" sizset="77">
													<s:iterator value="expertmajorTypeList"  status="rowData">
														<div sizcache="1" sizset="29">
															<a href="#" cmImpressionSent="1" onclick="selected(this,'&expertmajorType=${expertmajorType}');">${expertmajorType}</a>
														</div>
													</s:iterator>
												</div>
											</li>
										</s:if>
										<s:if test="graduatedList.size > 0">
											<li id=dimfilter10 class=cls ref1="listHidden" sizcache="1" >
												<label>毕业院校：</label> 
												<div class="innerB" sizcache="1" sizset="77">
													<s:iterator value="graduatedList"  status="rowData">
														<div sizcache="1" sizset="29">
															<a href="#" cmImpressionSent="1" onclick="selected(this,'&graduatedName=${graduatedName}');">${graduatedName}</a>
														</div>
													</s:iterator>
												</div>
											</li>
										</s:if>
									</ul>
								</div>
								<div class=filter_oper>
									<div id="ShowDimList" class="view_more" onclick="javascript:doShowDimList()">更多筛选项 <s></s></div>
									<div style="DISPLAY: none" id="HideDimList" class="view_more openr" onclick="javascript:doHideDimList()">收起筛选项 <s></s></div>
								</div>
							</div>
						</form>
					</div>
					<div align="right">
						<input class="button" type="button" id="insertExpert" value="添加" onclick="insertExpert();"/>&nbsp;
					</div>
					<div>&nbsp;</div>
					<!-- 查询结果列表S -->
					<div id="resultDiv"></div>
					<!-- 查询结果列表E -->
					
					<!-- dialogS -->
					<s:hidden id="hiddenexpertName" name="hidden" value="姓名,1,-1"></s:hidden>
					<s:hidden id="hiddensex" name="hidden" value="性别"></s:hidden>
					<s:hidden id="hiddenbirthday" name="hidden" value="出生年月,0,-1"></s:hidden>
					<s:hidden id="hiddenschooling" name="hidden" value="学历"></s:hidden>
					<s:hidden id="hiddengraduateSchool" name="hidden" value="毕业院校,0,-1,50"></s:hidden>
					<s:hidden id="hiddenexpertJob" name="hidden" value="专家职务,1,-1,50"></s:hidden>
					<s:hidden id="hiddenskillJob" name="hidden" value="专家职称"></s:hidden>
					<s:hidden id="hiddenexpertDegree" name="hidden" value="学位"></s:hidden>
					<s:hidden id="hiddenacademicTitle" name="hidden" value="学术荣誉称号,0,-1,50"></s:hidden>
					<s:hidden id="hiddenexpertMajor" name="hidden" value="所学专业,0,-1,50"></s:hidden>
					<s:hidden id="hiddenexpertMajor1" name="hidden" value="擅长专业1"></s:hidden>
					<s:hidden id="hiddenexpertMajor2" name="hidden" value="擅长专业2"></s:hidden>
					<s:hidden id="hiddenexpertMajor3" name="hidden" value="擅长专业3"></s:hidden>
					<s:hidden id="hiddenexpertPrestige" name="hidden" value="信誉等级"></s:hidden>
					<s:hidden id="hiddenexpertWork" name="hidden" value="工作单位,0,-1,50"></s:hidden>
					<s:hidden id="hiddendeptType" name="hidden" value="单位性质"></s:hidden>
					<s:hidden id="hiddenexpertType" name="hidden" value="专家类型"></s:hidden>
					<s:hidden id="hiddenrecommendWork" name="hidden" value="推荐单位,0,-1"></s:hidden>
					<s:hidden id="hiddenexpertIncumbency" name="hidden" value="在职状态"></s:hidden>
					<s:hidden id="hiddenworkPhone" name="hidden" value="办公电话,0,1,12"></s:hidden>
					<s:hidden id="hiddenhousePhone" name="hidden" value="住宅电话,0,1,12"></s:hidden>
					<s:hidden id="hiddenphone" name="hidden" value="手机,1,0,11"></s:hidden>
					<s:hidden id="hiddenemail" name="hidden" value="电子邮箱,1,7,50"></s:hidden>
					<s:hidden id="hiddenportraiture" name="hidden" value="传真,0,1,12"></s:hidden>
					<s:hidden id="hiddenresearchFindings" name="hidden" value="研究成果,0,8,1000"></s:hidden>
					<s:hidden id="selectedExpertNum" name="selectedExpertNum" value="%{selectedExpertNum}"></s:hidden>
					
					<!-- dialogD -->
			</div>
		</div>
	</div>
</div>
