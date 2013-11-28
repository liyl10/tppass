<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
<script type="text/javascript">
function nextbt(){
		$("#content").load("planning_specialist_work_list.html");
	}
$(function() {
	    $(document).ready(function() {
	   	    
	      	//$("#sex").prepend("<option value=''>---请选择---</option>");
	      
	      	upms.upmsUtils.initSelect("sex","${texpert.sex}", 1 , 1 , 1);
	      	upms.upmsUtils.initSelect("schooling","${texpert.schooling}", 1 , 1 , 1);
	      	upms.upmsUtils.initSelect("expertJob","${texpert.expertJob}", 1 , 1 , 1);
	      	upms.upmsUtils.initSelect("skillJob","${texpert.skillJob}", 1 , 1 , 1);
	      	upms.upmsUtils.initSelect("expertPrestige","${texpert.expertPrestige}", 1 , 1 , 1);
	      	upms.upmsUtils.initSelect("expertMajor1","${texpert.expertMajor1}", 1 , 1 , 1);
	      	upms.upmsUtils.initSelect("expertMajor2","${texpert.expertMajor2}", 1 , 1 , 1);
	      	upms.upmsUtils.initSelect("expertMajor3","${texpert.expertMajor3}", 1 , 1 , 1);
	      	upms.upmsUtils.initSelect("deptType","${texpert.deptType}", 1 , 1 , 1);
	      	upms.upmsUtils.initSelect("expertDegree","${texpert.expertDegree}", 1 , 1 , 1);
	      	upms.upmsUtils.initSelect("expertStatus","${texpert.expertStatus}", 1 , 1 , 1);
	      	
	      	
	      	$("#queryBtn").click(function(){
	      		// 验证text
	      		var result = upms.upmsUtils.inputCheck();
	      		// 验证时间区间
	      		//var result1  = upms.upmsUtils.checkDate("startId", "endId", "起始年限");
	      		// 验证下拉列表
	      		var idList = new Array("sex","schooling","expertDegree","expertJob","skillJob",
	      				"expertPrestige","expertMajor1","expertMajor2","expertMajor3","deptType","expertStatus");
	      		var result2 = upms.upmsUtils.selectCheck(idList);
	      		if(result || result2){
	      			return;
	      		}
	      		var actionUrl= "${pageContext.request.contextPath}/api/expert/texpertAction!save.action?expertId={texpert.expertId}&"+"now="+new Date().getTime();
      			upms.showOverLay();// 打开遮罩
      			var $newPgDiv = $("#content");
      			var params = [{name:"expertName",targetid:"expertName",type:"text"},
      			              {name:"sex",targetid:"sex",type:"select"},
      			              {name:"birthday",targetid:"birthday",type:"text"},
    			              {name:"schooling",targetid:"schooling",type:"select"},
    			              {name:"expertDegree",targetid:"expertDegree",type:"select"},
    			              {name:"graduateSchool",targetid:"graduateSchool",type:"text"},
      			              {name:"expertJob",targetid:"expertJob",type:"select"},
      			              {name:"skillJob",targetid:"skillJob",type:"select"},
      			              {name:"academicTitle",targetid:"academicTitle",type:"text"},
      			              {name:"expertMajor",targetid:"expertMajor",type:"text"},
    			              {name:"expertMajor1",targetid:"expertMajor1",type:"select"},
    			              {name:"expertMajor2",targetid:"expertMajor2",type:"select"},
    			              {name:"expertMajor3",targetid:"expertMajor3",type:"select"},
    			              {name:"expertPrestige",targetid:"expertPrestige",type:"select"},
        			            {name:"expertWork",targetid:"expertWork",type:"text"},
      			              {name:"deptType",targetid:"deptType",type:"select"},
      			              {name:"recommendWork",targetid:"recommendWork",type:"text"},
      			              {name:"expertStatus",targetid:"expertStatus",type:"select"},
      			            {name:"housePhone",targetid:"housePhone",type:"text"},
    			              {name:"workPhone",targetid:"workPhone",type:"text"},
      			          {name:"phone",targetid:"phone",type:"text"},
  			              {name:"email",targetid:"email",type:"text"},
  			            {name:"portraiture",targetid:"portraiture",type:"text"},
			              {name:"researchFindings",targetid:"researchFindings",type:"textarea"}
      			           ];
      			var data = upms.transParsToObj(params, $("#expertFormAdd"));
      			$newPgDiv.load(actionUrl, data, function() {
      				upms.hideOverLay();
      			});
      	
	      	});
	    });
	});

</script>

<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
<div style="text-align: left;">
<div class="Servicel04">
<div class="abuot02">
<div class="abuot07">基本信息</div>
<form action="" id="expertFormAdd" name="expertFormadd">
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-entRegFrm">
	<tr>
		<th colspan="5" align="left">基本信息</th>
	</tr>
	<tr>
		<td align="right"><s:label><FONT color=red>*</FONT>姓名</s:label></td>
		<td> <input type="text" name="expertName" id="expertName"  value="${texpert.expertName }" style="width: 20em; 
							height:1.6em;" class="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'姓名',1,-1)"
							onfocus="upms.upmsUtils.textFocus(this);"/>
							<s:hidden id="hiddenexpertName" name="hidden" value="姓名,1,-1"></s:hidden>
							 </td>
		<td align="right"><s:label><FONT color=red>*</FONT>性别</s:label></td>
		<td>
		<select name="sex" id="sex" style="width:200px">
		<option value=''>---请选择---</option>
		 <option value="1">男</option>
		 <option value="0">女</option>
		</select>
		<s:hidden id="hiddensex" name="hidden" value="性别"></s:hidden>
		</td>
	</tr>
	<tr>
		<td align="right"><s:label><FONT color=red>*</FONT>出生年月</s:label></td>
		<td><s:textfield name="texpert.birthday" id="birthday" cssClass="txt w184p Wdate" readonly="readonly" onClick="WdatePicker()"onblur="upms.upmsUtils.blurTextCheck(this,'出生年月',1,-1)"
							onfocus="upms.upmsUtils.textFocus(this);"></s:textfield>
							<s:hidden id="hiddenbirthday" name="hidden" value="出生年月"></s:hidden>
							</td>
		<td align="right"><s:label><FONT color=red>*</FONT>学历</s:label></td>
		<td>
		<s:select list="apiMitemService.getMiteByTypeId(@com.hopsun.tppas.common.Constants@SCHOOLING)" name="texpert.schooling" id="schooling" cssStyle="width:200px" headerKey="----请选择----" headerValue="" listKey="key" listValue="value"></s:select>
			<s:hidden id="hiddenschooling" name="hidden" value="学历"></s:hidden>
		</td>
	</tr>
	<tr>
		<td align="right"><s:label><FONT color=red>*</FONT>学位</s:label></td>
		<td>
		<s:select list="apiMitemService.getMiteByTypeId(@com.hopsun.tppas.common.Constants@EXPERTDEGREE)" name="texpert.expertDegree" id="expertDegree" cssStyle="width:200px" headerKey="----请选择----" headerValue="" listKey="key" listValue="value"></s:select>
			<s:hidden id="hiddenexpertDegree" name="hidden" value="学位"></s:hidden>
		</td>
		<td align="right"><s:label><FONT color=red>*</FONT>毕业院校</s:label></td>
		<td><s:textfield name="texpert.graduateSchool" id="graduateSchool" cssClass="inputA" cssStyle="width: 14.5em;"onblur="upms.upmsUtils.blurTextCheck(this,'毕业院校',1,-1)"
							onfocus="upms.upmsUtils.textFocus(this);"></s:textfield>				
							<s:hidden id="hiddengraduateSchool" name="hidden" value="毕业院校,1,-1"></s:hidden></td>
	</tr>
	<tr>
		<td align="right"><s:label><FONT color=red>*</FONT>行政职务</s:label></td>
		<td>
		<s:select list="apiMitemService.getMiteByTypeId(@com.hopsun.tppas.common.Constants@EXPERTJOB)" name="texpert.expertJob" id="expertJob" cssStyle="width:200px" headerKey="----请选择----" headerValue="" listKey="key" listValue="value"></s:select>
		<s:hidden id="hiddenexpertJob" name="hidden" value="行政职务"></s:hidden>
		</td>
		<td align="right"><s:label><FONT color=red>*</FONT>技术职务</s:label></td>
		<td>
			<s:hidden id="hiddenskillJob" name="hidden" value="技术职务"></s:hidden>
			<s:select list="apiMitemService.getMiteByTypeId(@com.hopsun.tppas.common.Constants@SKILLJOB)" 
			name="texpert.skillJob" id="skillJob" cssStyle="width:200px" 
			headerKey="----请选择----" headerValue="" listKey="key" listValue="value"></s:select>
		</td>
	</tr>
	<tr>
		<td align="right"><s:label><FONT color=red>*</FONT>学术荣誉称号</s:label></td>
		<td><s:textfield name="texpert.academicTitle" cssClass="inputA" cssStyle="width: 14.5em;" onblur="upms.upmsUtils.blurTextCheck(this,'学术荣誉称号',1,-1)"
							onfocus="upms.upmsUtils.textFocus(this);" id="academicTitle"/>
							<s:hidden id="hiddenacademicTitle" name="hidden" value="学术荣誉称号,1,-1"></s:hidden>
							</td>
		<td align="right"><s:label><FONT color=red>*</FONT>所学专业</s:label></td>
		<td><s:textfield name="texpert.expertMajor" cssClass="inputA" cssStyle="width: 14.5em;" id="expertMajor" onblur="upms.upmsUtils.blurTextCheck(this,'所学专业',1,-1)"
							onfocus="upms.upmsUtils.textFocus(this);" />
							<s:hidden id="hiddenexpertMajor" name="hidden" value="所学专业,1,-1"></s:hidden>
							</td>
	</tr>
		<tr>
		<td align="right"><s:label><FONT color=red>*</FONT>擅长专业1</s:label></td>
		<td>
			<s:hidden id="hiddenexpertMajor1" name="hidden" value="擅长专业1"></s:hidden>
		<s:select list="apiMitemService.getMiteByTypeId(@com.hopsun.tppas.common.Constants@EXPERTMAJOR1)" name="texpert.expertMajor1" id="expertMajor1" cssStyle="width:200px" headerKey="----请选择----" headerValue="" listKey="key" listValue="value"></s:select>
		</td>
		<td align="right"><s:label><FONT color=red>*</FONT>擅长专业2</s:label></td>
		<td>
					<s:hidden id="hiddenexpertMajor2" name="hidden" value="擅长专业2"></s:hidden>
		<s:select list="apiMitemService.getMiteByTypeId(@com.hopsun.tppas.common.Constants@EXPERTMAJOR2)" name="texpert.expertMajor2" id="expertMajor2" cssStyle="width:200px" headerKey="----请选择----" headerValue="" listKey="key" listValue="value"></s:select>
		</td>
	</tr>
		</tr>
		<tr>
		<td align="right"><s:label><FONT color=red>*</FONT>擅长专业3</s:label></td>
		<td>
		<s:hidden id="hiddenexpertMajor3" name="hidden" value="擅长专业3"></s:hidden>
		<s:select list="apiMitemService.getMiteByTypeId(@com.hopsun.tppas.common.Constants@EXPERTMAJOR3)" name="texpert.expertMajor3" id="expertMajor3" cssStyle="width:200px" headerKey="----请选择----" headerValue="" listKey="key" listValue="value"></s:select>
			
		</td>
		<td align="right"><s:label><FONT color=red>*</FONT>信誉等级</s:label></td>
		<td>
				<s:hidden id="hiddenexpertPrestige" name="hidden" value="信誉等级"></s:hidden>
		<s:select list="apiMitemService.getMiteByTypeId(@com.hopsun.tppas.common.Constants@EXPERTPRESTIGE)" name="texpert.expertPrestige" id="expertPrestige" cssStyle="width:200px" headerKey="----请选择----" headerValue="" listKey="key" listValue="value"></s:select>
		</td>
	</tr>
	<tr>
		<th colspan="5" align="left">单位信息</th>
	</tr>
	<tr>
		<td align="right"><s:label><FONT color=red>*</FONT>工作单位</s:label></td>
		<td><input class="inputA" name="texpert.expertWork" id="expertWork" type="text"  value="${texpert.expertWork }" style=" width: 14.5em;" onblur="upms.upmsUtils.blurTextCheck(this,'工作单位',1,-1)"
							onfocus="upms.upmsUtils.textFocus(this);" />
							<s:hidden id="hiddenexpertWork" name="hidden" value="工作单位,1,-1"></s:hidden>
							</td>
		<td align="right"><s:label><FONT color=red>*</FONT>单位性质</s:label></td>
		<td>
						<s:hidden id="hiddendeptType" name="hidden" value="单位性质"></s:hidden>
			<s:select list="apiMitemService.getMiteByTypeId(@com.hopsun.tppas.common.Constants@DEPTTYPE)" name="texpert.deptType" id="deptType" cssStyle="width:200px" headerKey="----请选择----" headerValue="" listKey="key" listValue="value"></s:select>
		</td>
	</tr>
	<tr>
		<td align="right"><s:label><FONT color=red>*</FONT>推荐单位</s:label></td>
		<td><input class="inputA" name="texpert.recommendWork" type="text" id="recommendWork" onblur="upms.upmsUtils.blurTextCheck(this,'推荐单位',1,-1)"
							onfocus="upms.upmsUtils.textFocus(this);" value="" style=" width: 14.5em;"/>
								<s:hidden id="hiddenrecommendWork" name="hidden" value="推荐单位,1,-1"></s:hidden>
							</td>
		<td align="right"><s:label><FONT color=red>*</FONT>在职状态</s:label></td>
		<td>
		<s:hidden id="hiddenexpertStatus" name="hidden" value="在职状态"></s:hidden>
			<s:select list="apiMitemService.getMiteByTypeId(@com.hopsun.tppas.common.Constants@EXPERTSTATUS)" name="texpert.expertStatus" id="expertStatus" cssStyle="width:200px" headerKey="----请选择----" headerValue="" listKey="key" listValue="value"></s:select>
			
		</td>
	</tr>
	<tr>
		<th colspan="5" align="left">联系方式</th>
	</tr>
	<tr>
		<td align="right"><s:label><FONT color=red>*</FONT>办公电话</s:label></td>
		<td><s:textfield name="texpert.workPhone" id="workPhone" cssClass="inputA" onblur="upms.upmsUtils.blurTextCheck(this,'办公电话',1,12)"
							onfocus="upms.upmsUtils.textFocus(this);" cssStyle="width: 14.5em;"/>
							<s:hidden id="hiddenworkPhone" name="hidden" value="办公电话,1,12"></s:hidden>
							</td>
		<td align="right"><s:label><FONT color=red>*</FONT>住宅电话</s:label></td>
		<td><s:textfield name="texpert.housePhone" id="housePhone" onblur="upms.upmsUtils.blurTextCheck(this,'住宅电话',1,12)"
							onfocus="upms.upmsUtils.textFocus(this);" cssClass="inputA" cssStyle="width: 14.5em;"/>
							<s:hidden id="hiddenhousePhone" name="hidden" value="住宅电话,1,-1"></s:hidden>
							</td>	
	</tr>
	<tr>
		<td align="right"><s:label><FONT color=red>*</FONT>手机</s:label></td>
		<td><s:textfield name="texpert.phone" id="phone" onblur="upms.upmsUtils.blurTextCheck(this,'手机',1,11)"
							onfocus="upms.upmsUtils.textFocus(this);" cssClass="inputA" cssStyle="width: 14.5em;"/>
									<s:hidden id="hiddenphone" name="hidden" value="手机,1,-1"></s:hidden>
							</td>
		<td align="right"><s:label><FONT color=red>*</FONT>电子邮箱</s:label></td>
		<td><s:textfield name="texpert.email" id="email" onblur="upms.upmsUtils.blurTextCheck(this,'电子邮箱',1,-1)"
							onfocus="upms.upmsUtils.textFocus(this);" cssClass="inputA" cssStyle="width: 14.5em;"/>
								<s:hidden id="hiddenemail" name="hidden" value="电子邮箱,1,-1"></s:hidden>
							</td>	
	</tr>
	</tr>
	<tr>
		<td align="right" ><s:label><FONT color=red>*</FONT>传真</s:label></td>
		<td colspan="3"><s:textfield name="texpert.portraiture" onblur="upms.upmsUtils.blurTextCheck(this,'传真',1,-1)"
							onfocus="upms.upmsUtils.textFocus(this);" id="portraiture" cssClass="inputA" cssStyle="width: 14.5em;"/>
							<s:hidden id="hiddenportraiture" name="hidden" value="传真,1,-1"></s:hidden>
							</td>
	</tr>
	<tr>
		<th colspan="5" align="left"><s:label><FONT color=red>*</FONT>研究成果</s:label>	</th>
	</tr>
	<tr>
		<td align="right" width="30%"><s:label><FONT color=red>*</FONT>主要研究成果</s:label></td>
		<td colspan="3" width="70%"><textarea id="researchFindings" name="texpert.researchFindings" id="researchFindings" class="inputA" style="width:99%; height:100px;resize:none;" ></textarea></td>
	</tr>
	<tr>
		<td align="center" colspan="5">
			<input class="button" type="button" id="queryBtn" value="保存"/>
			<input class="button" id="button" type="button" href="javascript: void(0);" onClick="nextbt();" value="下一步"/>
		</td>
	</tr>
</table>
</form>
</div>
</div>
</div>
</div>