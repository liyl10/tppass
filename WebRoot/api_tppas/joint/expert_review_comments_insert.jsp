<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/api_tppas/joint/js/expert_review_comments_insert.js"></script>
<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
<div style="text-align: left;">
	<div class="Servicel04">
		<div class="abuot02">
			<div class="abuot07">专家评估模板</div>
			<div class="abuot03">
<!-- 保存按钮提示信息 -->
<label id="comfirmSave" style="display: none"><s:text name="confirm_save_info"/></label>
<s:hidden id="typeId" name="typeId" value="%{typeId}"></s:hidden>
<s:hidden id="planFlagId" name="planFlagId" value="%{planFlagId}"></s:hidden>
<!-- 下一步按钮提示信息 -->
<label id="comfirmSaveNext" style="display: none"><s:text name="confirm_save_and_next_info"/></label>
<table width="100%" border="0" class="t-entRegFrm"  cellspacing="0" cellpadding="0">
	<tr>
	<td width="10%" style="white-space:nowrap;width:10%;text-align:right;padding:2 2 10 10;font-size:105%">
		专家评估模板
	&nbsp;</td>
	<td colspan="5"width="10%" style="white-space:nowrap;width:20%;padding:2px;">		
		<s:select style="width:14.5em;" list="expertReviewList" label="abc" listKey="itemId"
			listValue="itemName" id="expertType" name="texpertReviewComments.expertType" 
			value="%{texpertReviewComments.expertType}" onblur="upms.upmsUtils.blurTextCheck(this,'专家评估模板');" onfocus="upms.upmsUtils.textFocus(this);"></s:select>
			<s:hidden id="expertTypeValue" value="%{texpertReviewComments.expertType}"></s:hidden>
		<s:hidden id="hiddenexpertType" name="hidden" value="专家评估模板"></s:hidden>	
	&nbsp;</td>
</tr>
<tr>
		<td width="29%" colspan="2"><div align="center">评审指标</div></td>
		<td width="37%">
			<div align="center">评审指标说明</div>
		</td>
		<td width="5%">
			<div align="center">分值</div>
		</td>
		<td width="29%">
			<div align="center">评分标准</div>
		</td>
		
	</tr>
	<tr>
		<td rowspan="3" width="10%" align="center">1</td>
		<td rowspan="3" style="padding: 4px 8px; text-align: left">
			<input id="evaluationIndex1" name="texpertReviewComments.evaluationIndex1" value="企业状况" type="text" 
			style="width: 20em; 
			height:1.6em;" class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'评审指标',1,-1)"
			onfocus="upms.upmsUtils.textFocus(this);"
			maxlength="8" 
			readFlag="1"/>
			<s:hidden id="hiddenevaluationIndex1" name="hidden" value="评审指标,1,-1"></s:hidden>
		</td>
		<td rowspan="3" align="left">
			<textarea id="evaluationShows1" name="texpertReviewComments.evaluationShows1" class="inputA" style="width:98%;height:80px;resize:none;" onblur="upms.upmsUtils.blurTextCheck(this,'评审指标说明',1,8,30);" onfocus="upms.upmsUtils.textFocus(this);" onkeyup="upms.upmsUtils.checkTextareaLength(this, 30);">对该企业行业地位的评价</textarea>
		 	<s:hidden id="hiddenevaluationShows1" name="hidden" value="评审指标说明,1,8,30"></s:hidden>
		</td>
		
		<td rowspan="3" style="padding: 4px 8px; text-align: left">
			<input id="score1" name="texpertReviewComments.score1" value="20" type="text" style="width: 5em; 
			height:1.6em;ime-mode: disabled;" class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'分值',1,13)"
			onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isNum(event,this)"
			maxlength="3" 
			readFlag="1"/>
			<s:hidden id="hiddenscore1" name="hidden" value="分值,1,13"></s:hidden>
		</td>
		<td style="padding: 4px 8px; text-align: left">
			<input id="codePoints1" name="texpertReviewComments.codePoints1" value="国内前三名(16-20分)" type="text" style="width: 20em; 
			height:1.6em;" class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'评分标准',1,-1)"
			onfocus="upms.upmsUtils.textFocus(this);" 
			maxlength="18" 
			readFlag="1"/>
			<s:hidden id="hiddenecodePoints1" name="hidden" value="评分标准,1,-1"></s:hidden>
		</td>
	</tr>
	<tr>
		<td style="padding: 4px 8px; text-align: left">
			<input id="codePoints2" name="texpertReviewComments.codePoints2" value="国内前十名(12-15分)" type="text" style="width: 20em; 
			height:1.6em;" class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'评分标准',1,-1)"
			onfocus="upms.upmsUtils.textFocus(this);" 
			maxlength="18" 
			readFlag="1"/>
			<s:hidden id="hiddenecodePoints2" name="hidden" value="评分标准,1,-1"></s:hidden>
		</td>
	</tr>
	<tr>
		<td style="padding: 4px 8px; text-align: left">
			<input id="codePoints3" name="texpertReviewComments.codePoints3" value="其他(0-8分)" type="text" style="width: 20em; 
			height:1.6em;" class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'评分标准',1,-1)"
			onfocus="upms.upmsUtils.textFocus(this);" 
			maxlength="18" 
			readFlag="1"/>
			<s:hidden id="hiddenecodePoints3" name="hidden" value="评分标准,1,-1"></s:hidden>
		</td>
	</tr>
	
	<tr>
		<td rowspan="3" width="10%" align="center">2</td>
		<td rowspan="3" style="padding: 4px 8px; text-align: left">
			<input id="evaluationIndex2" name="texpertReviewComments.evaluationIndex2" value="项目技术评价" type="text" style="width: 20em; 
			height:1.6em;" class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'评审指标',1,-1)"
			onfocus="upms.upmsUtils.textFocus(this);"
			maxlength="8" 
			readFlag="1"/>
			<s:hidden id="hiddenevaluationIndex2" name="hidden" value="评审指标,1,-1"></s:hidden>
		</td>
		<td rowspan="3" align="left">
			<textarea id="evaluationShows2" name="texpertReviewComments.evaluationShows2" class="inputA" style="width:98%;height:80px;resize:none;" onblur="upms.upmsUtils.blurTextCheck(this,'评审指标说明',1,8,30);" onfocus="upms.upmsUtils.textFocus(this);" onkeyup="upms.upmsUtils.checkTextareaLength(this, 30);">技术先进性、产品创新性和成熟度</textarea>
		 	<s:hidden id="hiddenevaluationShows2" name="hidden" value="评审指标说明,1,8,30"></s:hidden>
		</td>
		
		<td rowspan="3" style="padding: 4px 8px; text-align: left">
			<input id="score2" name="texpertReviewComments.score2" value="30" type="text" style="width: 5em; 
			height:1.6em;ime-mode: disabled;" class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'分值',1,13)"
			onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isNum(event,this)"
			maxlength="3" 
			readFlag="1"/>
			<s:hidden id="hiddenscore2" name="hidden" value="分值,1,13"></s:hidden>
		</td>
		<td style="padding: 4px 8px; text-align: left">
			<input id="codePoints4" name="texpertReviewComments.codePoints4" value="国内领先，创新性强(24-30分)" type="text" style="width: 20em; 
			height:1.6em;" class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'评分标准',1,-1)"
			onfocus="upms.upmsUtils.textFocus(this);" 
			maxlength="18" 
			readFlag="1"/>
			<s:hidden id="hiddenecodePoints4" name="hidden" value="评分标准,1,-1"></s:hidden>
		</td>
	</tr>
	<tr>
		<td style="padding: 4px 8px; text-align: left">
			<input id="codePoints5" name="texpertReviewComments.codePoints5" value="国内先进，创新性较强(18-23分)" type="text" style="width: 20em; 
			height:1.6em;" class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'评分标准',1,-1)"
			onfocus="upms.upmsUtils.textFocus(this);" 
			maxlength="18" 
			readFlag="1"/>
			<s:hidden id="hiddenecodePoints5" name="hidden" value="评分标准,1,-1"></s:hidden>
		</td>
	</tr>
	<tr>
		<td style="padding: 4px 8px; text-align: left">
			<input id="codePoints6" name="texpertReviewComments.codePoints6" value="技术水平、创新性一般(0-17分)" type="text" style="width: 20em; 
			height:1.6em;" class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'评分标准',1,-1)"
			onfocus="upms.upmsUtils.textFocus(this);" 
			maxlength="18" 
			readFlag="1"/>
			<s:hidden id="hiddenecodePoints6" name="hidden" value="评分标准,1,-1"></s:hidden>
		</td>
	</tr>
	
	<tr>
		<td rowspan="3" width="10%" align="center">3</td>
		<td rowspan="3" style="padding: 4px 8px; text-align: left">
			<input id="evaluationIndex3" name="texpertReviewComments.evaluationIndex3" value="项目前期基础" type="text" style="width: 20em; 
			height:1.6em;" class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'评审指标',1,-1)"
			onfocus="upms.upmsUtils.textFocus(this);"
			maxlength="8" 
			readFlag="1"/>
			<s:hidden id="hiddenevaluationIndex3" name="hidden" value="评审指标,1,-1"></s:hidden>
		</td>
		<td rowspan="3" align="left">
			<textarea id="evaluationShows3" name="texpertReviewComments.evaluationShows3" class="inputA" style="width:98%;height:80px;resize:none;" onblur="upms.upmsUtils.blurTextCheck(this,'评审指标说明',1,8,30);" onfocus="upms.upmsUtils.textFocus(this);" onkeyup="upms.upmsUtils.checkTextareaLength(this, 30);">项目前期的投入、已有的阶段性成果情况</textarea>
		 	<s:hidden id="hiddenevaluationShows3" name="hidden" value="评审指标说明,1,8,30"></s:hidden>
		</td>
		<td rowspan="3" style="padding: 4px 8px; text-align: left">
			<input id="score3" name="texpertReviewComments.score3" value="20" type="text" style="width: 5em; 
			height:1.6em;ime-mode: disabled;" class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'分值',1,13)"
			onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isNum(event,this)"
			maxlength="3" 
			readFlag="1"/>
			<s:hidden id="hiddenscore3" name="hidden" value="分值,1,13"></s:hidden>
		</td>
		<td style="padding: 4px 8px; text-align: left">
			<input id="codePoints7" name="texpertReviewComments.codePoints7" value="投入大，成果多(16-20分)" type="text" style="width: 20em; 
			height:1.6em;" class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'评分标准',1,-1)"
			onfocus="upms.upmsUtils.textFocus(this);" 
			maxlength="18" 
			readFlag="1"/>
			<s:hidden id="hiddenecodePoints7" name="hidden" value="评分标准,1,-1"></s:hidden>
		</td>
	</tr>
	<tr>
		<td style="padding: 4px 8px; text-align: left">
			<input id="codePoints8" name="texpertReviewComments.codePoints8" value="投入较大，成果较多(12-15分)" type="text" style="width: 20em; 
			height:1.6em;" class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'评分标准',1,-1)"
			onfocus="upms.upmsUtils.textFocus(this);" 
			maxlength="18" 
			readFlag="1"/>
			<s:hidden id="hiddenecodePoints8" name="hidden" value="评分标准,1,-1"></s:hidden>
		</td>
	</tr>
	<tr>
		<td style="padding: 4px 8px; text-align: left">
			<input id="codePoints9" name="texpertReviewComments.codePoints9" value="投入少，成果一般(0-11分)" type="text" style="width: 20em; 
			height:1.6em;" class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'评分标准',1,-1)"
			onfocus="upms.upmsUtils.textFocus(this);" 
			maxlength="18" 
			readFlag="1"/>
			<s:hidden id="hiddenecodePoints9" name="hidden" value="评分标准,1,-1"></s:hidden>
		</td>
	</tr>
	
	<tr>
		<td rowspan="3" width="10%" align="center">4</td>
		<td rowspan="3" style="padding: 4px 8px; text-align: left">
			<input id="evaluationIndex4" name="texpertReviewComments.evaluationIndex4" value="项目市场评价" type="text" style="width: 20em; 
			height:1.6em;" class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'评审指标',1,-1)"
			onfocus="upms.upmsUtils.textFocus(this);"
			maxlength="8" 
			readFlag="1"/>
			<s:hidden id="hiddenevaluationIndex4" name="hidden" value="评审指标,1,-1"></s:hidden>
		</td>
		<td rowspan="3" align="left">
			<textarea id="evaluationShows4" name="texpertReviewComments.evaluationShows4" class="inputA" style="width:98%;height:80px;resize:none;" onblur="upms.upmsUtils.blurTextCheck(this,'评审指标说明',1,8,30);" onfocus="upms.upmsUtils.textFocus(this);" onkeyup="upms.upmsUtils.checkTextareaLength(this, 30);">产品市场容量。本产品的竞争优势、产业化前景</textarea>
		 	<s:hidden id="hiddenevaluationShows4" name="hidden" value="评审指标说明,1,8,30"></s:hidden>
		</td>
		
		<td rowspan="3" style="padding: 4px 8px; text-align: left">
			<input id="score4" name="texpertReviewComments.score4" value="15" type="text" style="width: 5em; 
			height:1.6em;ime-mode: disabled;" class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'分值',1,13)"
			onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isNum(event,this)"
			maxlength="3" 
			readFlag="1"/>
			<s:hidden id="hiddenscore4" name="hidden" value="分值,1,13"></s:hidden>
		</td>
		<td style="padding: 4px 8px; text-align: left">
			<input id="codePoints10" name="texpertReviewComments.codePoints10" value="市场前景很大(16-20分)" type="text" style="width: 20em; 
			height:1.6em;" class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'评分标准',1,-1)"
			onfocus="upms.upmsUtils.textFocus(this);" 
			maxlength="18" 
			readFlag="1"/>
			<s:hidden id="hiddenecodePoints10" name="hidden" value="评分标准,1,-1"></s:hidden>
		</td>
	</tr>
	<tr>
		<td style="padding: 4px 8px; text-align: left">
			<input id="codePoints11" name="texpertReviewComments.codePoints11" value="市场前景较大(12-15分)" type="text" style="width: 20em; 
			height:1.6em;" class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'评分标准',1,-1)"
			onfocus="upms.upmsUtils.textFocus(this);" 
			maxlength="18" 
			readFlag="1"/>
			<s:hidden id="hiddenecodePoints11" name="hidden" value="评分标准,1,-1"></s:hidden>
		</td>
	</tr>
	<tr>
		<td style="padding: 4px 8px; text-align: left">
			<input id="codePoints12" name="texpertReviewComments.codePoints12" value="市场前景一般(0-8分)" type="text" style="width: 20em; 
			height:1.6em;" class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'评分标准',1,-1)"
			onfocus="upms.upmsUtils.textFocus(this);" 
			maxlength="18" 
			readFlag="1"/>
			<s:hidden id="hiddenecodePoints12" name="hidden" value="评分标准,1,-1"></s:hidden>
		</td>
	</tr>
	<tr>
		<td rowspan="3" width="10%" align="center">5</td>
		<td rowspan="3" style="padding: 4px 8px; text-align: left">
			<input id="evaluationIndex5" name="texpertReviewComments.evaluationIndex5" value="项目预期效益" type="text" style="width: 20em; 
			height:1.6em;" class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'评审指标',1,-1)"
			onfocus="upms.upmsUtils.textFocus(this);"
			maxlength="8" 
			readFlag="1"/>
			<s:hidden id="hiddenevaluationIndex5" name="hidden" value="评审指标,1,-1"></s:hidden>
		</td>
		<td rowspan="3" align="left">
			<textarea id="evaluationShows5" name="texpertReviewComments.evaluationShows5" class="inputA" style="width:98%;height:80px;resize:none;" onblur="upms.upmsUtils.blurTextCheck(this,'评审指标说明',1,8,30);" onfocus="upms.upmsUtils.textFocus(this);" onkeyup="upms.upmsUtils.checkTextareaLength(this, 30);">项目成长速度预算</textarea>
		 	<s:hidden id="hiddenevaluationShows5" name="hidden" value="评审指标说明,1,8,30"></s:hidden>
		</td>
		
		<td rowspan="3" style="padding: 4px 8px; text-align: left">
			<input id="score5" name="texpertReviewComments.score5" value="15" type="text" style="width: 5em; 
			height:1.6em;ime-mode: disabled;" class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'分值',1,13)"
			onfocus="upms.upmsUtils.textFocus(this);" onkeypress="return upms.upmsUtils.isNum(event,this)"
			maxlength="3" 
			readFlag="1"/>
			<s:hidden id="hiddenscore5" name="hidden" value="分值,1,13"></s:hidden>
		</td>
		<td style="padding: 4px 8px; text-align: left">
			<input id="codePoints13" name="texpertReviewComments.codePoints13" value="≥40(12-15分)" type="text" style="width: 20em; 
			height:1.6em;" class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'评分标准',1,-1)"
			onfocus="upms.upmsUtils.textFocus(this);" 
			maxlength="18" 
			readFlag="1"/>
			<s:hidden id="hiddenecodePoints13" name="hidden" value="评分标准,1,-1"></s:hidden>
		</td>
	</tr>
	<tr>
		<td style="padding: 4px 8px; text-align: left">
			<input id="codePoints14" name="texpertReviewComments.codePoints14" value="≥30(9-11分)" type="text" style="width: 20em; 
			height:1.6em;" class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'评分标准',1,-1)"
			onfocus="upms.upmsUtils.textFocus(this);" 
			maxlength="18" 
			readFlag="1"/>
			<s:hidden id="hiddenecodePoints14" name="hidden" value="评分标准,1,-1"></s:hidden>
		</td>
	</tr>
	<tr>
		<td style="padding: 4px 8px; text-align: left">
			<input id="codePoints15" name="texpertReviewComments.codePoints15" value="＜30(0-8分)" type="text" style="width: 20em; 
			height:1.6em;" class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'评分标准',1,-1)"
			onfocus="upms.upmsUtils.textFocus(this);" 
			maxlength="18" 
			readFlag="1"/>
			<s:hidden id="hiddenecodePoints15" name="hidden" value="评分标准,1,-1"></s:hidden>
		</td>
	</tr>
	<tr>
		<td align="left" colspan="6">
			综合得分
		</td>
	</tr>
	<tr>
		<td colspan="6">综合评审意见：<input class="inputA" name="" type="text" value="重点推荐" style=" width: 5em;"  readonly="readonly"/>
		<input class="inputA" name="" type="text" value="推荐" style=" width: 5em;" readonly="readonly"/>
		<input class="inputA" name="" type="text" value="备选" style=" width: 5em;" readonly="readonly"/>
		<input class="inputA" name="" type="text" value="落选" style=" width: 5em;" readonly="readonly"/></td>
	</tr>
	<tr>
		<td colspan="6">注:&nbsp;
			<input id="remarksScore1" name="texpertReviewComments.remarksScore1" 
			value="90" type="text" style="width: 3em;ime-mode: disabled;" class="inputA"
			maxlength="3"  onkeypress="return upms.upmsUtils.isNum(event,this)"
		    onkeypress="return upms.upmsUtils.isNum(event,this)"
		    onblur="upms.upmsUtils.blurTextCheck(this,'重点推荐',1,13)"
		    onfocus="upms.upmsUtils.textFocus(this)"/>
			<s:hidden id="hiddenremarksScore1" name="hidden" value="重点推荐,1,13"></s:hidden>
		分以上为重点推荐； &nbsp;
			<input id="remarksScore2" name="texpertReviewComments.remarksScore2" 
			value="80" type="text" style="width: 3em;ime-mode: disabled;" class="inputA"
			maxlength="3"  onkeypress="return upms.upmsUtils.isNum(event,this)"
		    onkeypress="return upms.upmsUtils.isNum(event,this)"
		    onblur="upms.upmsUtils.blurTextCheck(this,'开始推荐',1,13)"
		    onfocus="upms.upmsUtils.textFocus(this)"/>
			<s:hidden id="hiddenremarksScore2" name="hidden" value="开始推荐,1,13"></s:hidden>
			-
			<input id="remarksScore3" name="texpertReviewComments.remarksScore3" 
			value="90" type="text" style="width: 3em;ime-mode: disabled;" class="inputA"
			maxlength="3"  onkeypress="return upms.upmsUtils.isNum(event,this)"
		    onkeypress="return upms.upmsUtils.isNum(event,this)"
		    onblur="upms.upmsUtils.blurTextCheck(this,'结束推荐',1,13)"
		    onfocus="upms.upmsUtils.textFocus(this)"/>
			<s:hidden id="hiddenremarksScore3" name="hidden" value="结束推荐,1,13"></s:hidden>
		分为推荐；&nbsp;
			<input id="remarksScore4" name="texpertReviewComments.remarksScore4" 
			value="60" type="text" style="width: 3em;ime-mode: disabled;" class="inputA"
			maxlength="3"  onkeypress="return upms.upmsUtils.isNum(event,this)"
		    onkeypress="return upms.upmsUtils.isNum(event,this)"
		    onblur="upms.upmsUtils.blurTextCheck(this,'开始备选',1,13)"
		    onfocus="upms.upmsUtils.textFocus(this)"/>
			<s:hidden id="hiddenremarksScore4" name="hidden" value="开始备选,1,13"></s:hidden>
			-
			<input id="remarksScore5" name="texpertReviewComments.remarksScore5" 
			value="79" type="text" style="width: 3em;ime-mode: disabled;" class="inputA"
			maxlength="3"  onkeypress="return upms.upmsUtils.isNum(event,this)"
		    onkeypress="return upms.upmsUtils.isNum(event,this)"
		    onblur="upms.upmsUtils.blurTextCheck(this,'结束备选',1,13)"
		    onfocus="upms.upmsUtils.textFocus(this)"/>
			<s:hidden id="hiddenremarksScore5" name="hidden" value="结束备选,1,13"></s:hidden>
		分为备选；&nbsp;
			<input id="remarksScore6" name="texpertReviewComments.remarksScore6" 
			value="60" type="text" style="width: 3em;ime-mode: disabled;" class="inputA"
			maxlength="3"  onkeypress="return upms.upmsUtils.isNum(event,this)"
		    onkeypress="return upms.upmsUtils.isNum(event,this)"
		    onblur="upms.upmsUtils.blurTextCheck(this,'落选',1,13)"
		    onfocus="upms.upmsUtils.textFocus(this)"/>
			<s:hidden id="hiddenremarksScore6" name="hidden" value="落选,1,13"></s:hidden>
		分以下为落选；
	</td>
	</tr>
	
 </table>

<div align="left">
<em class=requirecolor id="errremarksScore2" name="errremarksScore2"></em><br/>
<em class=requirecolor id="errremarksScore5" name="errremarksScore5"></em><br/>
<em class=requirecolor id="errrevealOrder" name="errrevealOrder"></em><br/>
</div>
<div align="center">
	<tag:auth code="ss.expertreviewcomments.insertBtn">
		<input type="button" id="okBtn" class="button add" href="javascript: void(0);" value="保存">
	</tag:auth>
	<input type="button" id="backBtn" class="button add" href="javascript: void(0);"  value="返回">
</div>

</div>
</div>
</div>
</div>
</div>
