<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<link rel=stylesheet type=text/css href="${pageContext.request.contextPath}/api_tppas/css/style.css">
<link rel=stylesheet type=text/css href="${pageContext.request.contextPath}/api_tppas/css/layout.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/jquery/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/js/install_upms.js?ver=1.0.0"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/audit/js/expert_score.js"></script>

<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
	<div style="text-align: center;">
		<div class="Servicel04">
			<div class="abuot02">
				<div class="abuot07">
					2013年企业技术创新项目技术专家评估表<br />
					（计划类别:<s:property value="%{tprojectApplication.planFlag}" escape="true"/>）
				</div>
				<div class="abuot03" align="center">
					<div style="width:90%;">
						<div style="float: left; margin-left:20px;">
							项目名称:<s:property value="%{tprojectApplication.projectName}" escape="true"/>
						</div>
					</div>
				</div>
				<div class="abuot03" align="center">
					<div style="width:90%;">
						<div style="float: left; margin-left:20px;">
							单位名称:<s:property value="%{tprojectApplication.applicationUnit}" escape="true"/>
						</div>
						<div style="float: right; margin-right:20px;">
							项目编号:<s:property value="%{tprojectApplication.planNumber}" escape="true"/>
						</div>
					</div>
					<form id="updateExpertScore">
					<table width="90%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
						<tr>
							<td>
								<div style="text-align:center; vertical-align:middle;">支持方向</div>
							</td>
							<td colspan="6">
								<div align="left" style="vertical-align:middle;">
									<input type="text" style="width:30em;"/>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div style="text-align:center; vertical-align:middle;">支持条件</div>
							</td>
							<td colspan="6">
								<div align="left" style="vertical-align:middle;">
									<input type="text"  class="inputA" style="width:30em;">
								</div>
							</td>
					  </tr>
					  <tr>
						<td colspan="2" height="35px;">
							<div style="text-align:center; vertical-align:middle;">评审指标</div>
						</td>
						<td>
							<div align="center">评审指标说明</div>
						</td>
						<td>
							<div align="center">分值</div>
						</td>
						<td colspan="2">
							<div align="center">评分标准</div>
						</td>
						<td>
							<div align="center">打分</div>
						</td>
					  </tr>
					  <tr>
						<td>
							<div align="center">1</div>
						</td>
						<td>
							<div align="left">企业状况</div>
						</td>
						<td>
							<div align="left" style="vertical-align:middle;">
								对该企业行业地位的评价
							</div>
						</td>
						<td>
							<div align="left" style="vertical-align:middle;">
								<input type="text"  class="inputA" style="width:6em;" value="">
							</div>
						</td>
						<td colspan="2">
							<div align="left" style="vertical-align:middle;">
								<input name="radiobutton" type="radio" value="radiobutton" />国内前三名（16-20分）<br />
								<input name="radiobutton" type="radio" value="radiobutton" />国内前十名（12-15分）<br />
								<input name="radiobutton" type="radio" value="radiobutton" />其它（0-8分）
							</div>
						</td>
						<td>
							<div align="left" style="vertical-align:middle;">
								<input type="text"  class="inputA" style="width:6em;" value="">
							</div>
						</td>
					  </tr>
					  <tr>
						<td>
							<div align="center">2</div>
						</td>
						<td>
							<div align="left">项目技术评价</div>
						</td>
						<td>
							<div align="left" style="vertical-align:middle;">
							技术先进性、产品创新性和成熟度
							</div>
						</td>
						<td>
							<div align="left" style="vertical-align:middle;">
								<input type="text"  class="inputA" style="width:6em;" value="">
							</div>
						</td>
						<td colspan="2">
							<div align="left" style="vertical-align:middle;">
								<input name="radiobutton" type="radio" value="radiobutton" />国内领先，创新性强（24-30分）<br />
								<input name="radiobutton" type="radio" value="radiobutton" />国内先进，创新性较强（18-23分）<br />
								<input name="radiobutton" type="radio" value="radiobutton" />技术水平、创新性一般（0-17分）
							</div>
						</td>
						<td>
							<div align="left" style="vertical-align:middle;">
								<input type="text"  class="inputA" style="width:6em;" value="">
							</div>
						</td>
					  </tr>
					   <tr>
						<td>
							<div align="center">3</div>
						</td>
						<td>
							<div align="left">项目前期基础</div>
						</td>
						<td>
							<div align="left" style="vertical-align:middle;">
								项目前期的投入、已有的阶段性成果情况
							</div>
						</td>
						<td>
							<div align="left" style="vertical-align:middle;">
								<input type="text"  class="inputA" style="width:6em;" value="">
							</div>
						</td>
						<td colspan="2">
							<div align="left" style="vertical-align:middle;">
								<input name="radiobutton" type="radio" value="radiobutton" />投入大，成果多（16-20分）<br />
								<input name="radiobutton" type="radio" value="radiobutton" />投入较大，成果较多（12-15分）<br />
								<input name="radiobutton" type="radio" value="radiobutton" />投入少，成果一般（0-11分）
							</div>
						</td>
						<td>
							<div align="left" style="vertical-align:middle;">
								<input type="text"  class="inputA" style="width:6em;" value="">
							</div>
						</td>
					  </tr>
					   <tr>
						<td>
							<div align="center">4</div>
						</td>
						<td>
							<div align="left">项目市场评价</div>
						</td>
						<td>
							<div align="left" style="vertical-align:middle;">
								产品市场容量、本产品的竞争优势、产业化前景
							</div>
						</td>
						<td>
							<div align="left" style="vertical-align:middle;">
								<input type="text"  class="inputA" style="width:6em;" value="">
							</div>
						</td>
						<td colspan="2">
							<div align="left" style="vertical-align:middle;">
								<input name="radiobutton" type="radio" value="radiobutton" />市场前景很大（12-15分）<br />
								<input name="radiobutton" type="radio" value="radiobutton" />市场前景较大（9-11分）<br />
								<input name="radiobutton" type="radio" value="radiobutton" />市场前景一般（0-8分）
							</div>
						</td>
						<td>
							<div align="left" style="vertical-align:middle;">
								<input type="text"  class="inputA" style="width:6em;" value="">
							</div>
						</td>
					  </tr>
					   <tr>
						<td width="14%" rowspan="2">
							<div align="center">5</div>
						</td>
						<td width="14%" rowspan="2">
							<div align="left">项目预期效益</div>
						</td>
						<td width="14%" rowspan="2">
							<div align="left" style="vertical-align:middle;">
								A项目成长速度预期<br />
								*B实现可能性（系数）
							</div>
						</td>
						<td width="14%" rowspan="2">
							<div align="left" style="vertical-align:middle;">
								<input type="text"  class="inputA" style="width:6em;" value="">
							</div>
						</td>
						<td width="15%">A项目成长速度预期</td>
						<td width="15%">B实现可能性（系数）</td>
						<td width="14%" rowspan="2" >
							<div align="left" style="vertical-align:middle;">
								<input type="text"  class="inputA" style="width:6em;" value="">
							</div>
						</td>
					  </tr>
					  <tr>
					  	<td>
						  	<div align="left" style="vertical-align:middle;">
								<input name="radiobutton" type="radio" value="radiobutton" />≥40（12-15分）<br />
								<input name="radiobutton" type="radio" value="radiobutton" />≥30（9-11分）<br />
								<input name="radiobutton" type="radio" value="radiobutton" />< 30（0-8分）
							</div>
					  	</td>
						<td>
							<div align="left" style="vertical-align:middle;">
								<input name="radiobutton" type="radio" value="radiobutton" />≥80%<br />
								<input name="radiobutton" type="radio" value="radiobutton" />≥60%<br />
								<input name="radiobutton" type="radio" value="radiobutton" />< 60%
				 			</div>
				 		</td>
					  </tr>
					  <tr>
						<td colspan="6">
							<div align="left">综合得分</div>
						</td>
						<td>
							<input type="text"  class="inputA" style="width:6em;" value="" readonly="readonly">
						</td>
					  </tr>
					  <tr>
						<td colspan="7">
							<div align="left" style="margin-left:10px;"> 综合评审意见：
								<label>
								  	<input type="radio" name="radiobutton" value="radiobutton">
								  	重点推荐
								</label>
								<label>
								  	<input type="radio" name="radiobutton" value="radiobutton">
								  	推荐
								</label>
							  	<label>
							  		<input type="radio" name="radiobutton" value="radiobutton">
								 	 备选
							  	</label>
							  	<label>
							  		<input type="radio" name="radiobutton" value="radiobutton">
									  落选<br />
										  <FONT color=red>
										  	注：90分以上为重点推荐； 80－89分为推荐； 60-79分为备选； 60分以下为落选 
										  </FONT>
							 	 </label>
						  	</div>
						  </td>
					  </tr>
					  <tr>
						 <td>
						 	<div align="right">
						 		说明理由<br/>
						 		（重点推荐<br />
						 		或落选的填写）<br />
						 		（1000字以内）
						 	</div>
						 </td>
						 <td colspan="6">
						 	<div align="left">
						 		<textarea name="textarea" cols="100" rows="8"></textarea>
						 	</div>
						 </td>
					  </tr>
					</table>
					<div style="width:90%;">
						<div style="float: left; margin-left:20px;">
							专家签名:<input type="text" NAME="" class="inputA" style="width:8em;"> 
						</div>
						<div style="float: right; margin-right:20px;">
							评审日期:<input type="text" NAME="" class="inputA" style="width:8em;">
						</div>
					</div>
					</form>
   				</div>
  			</div>
		</div>
	</div>
</div>
