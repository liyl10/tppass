//document.domain = 'xatrm.com';
// 项目根目录
var path="";
var isAllFlag = false;

$(document).ready(function(){
	path = $("#path").text();
	
	$("li[ref1='listHidden']").hide();
	$("#param").attr("value","&skilljobType=" + $("#skillJob").text());
	// 初始查询
 	var actionUrl=path + "/audit2/projectApplication!getAddAuditList.action?key=" + $("#key").val() + "&groupId="+$("#groupId").val() + $("#param").val() +"&date=" + new Date().getTime();
	//var params = [{name:"credibyLevel",targetid:"credibyLevel",type:"text"}];
	// upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#resultDiv");
	//var data = upms.transParsToObj(params, $("#searchForm"));
	$newPgDiv.load(actionUrl, null, function() {
		//upms.hideOverLay();
	});
}); 
 
/**
 * 收起筛选项
 */
function doHideDimList() {
	$("li[ref1='listHidden']").hide();
	isAllFlag = false;
	$("#ShowDimList").show();
	$("#HideDimList").hide();
	
}

/**
 * 更多筛选项
 */
function doShowDimList() {
	$("li[ref1='listHidden']").each(function(){
		if($(this).attr("temp") != "none"){
			$(this).show();
		}
	});
	isAllFlag = true;
	$("#ShowDimList").hide();
	$("#HideDimList").show();
}

/**
 * 封装专家名称
 */
function submitByName(){
	var data ="&expertName=" +  encodeURI($("#expertName").val());
	var $newPgDiv = $("#resultDiv");
 	var actionUrl=path + "/audit2/projectApplication!getAddAuditList.action?key=" + $("#key").val() + "&groupId="+$("#groupId").val() + $("#param").val() + data +"&date=" + new Date().getTime();
 	// alert(actionUrl);
    $newPgDiv.load(actionUrl, null, function() {
		//upms.hideOverLay();
	});
}

/**
 * 选择查询条件
 * @param now
 * @param data
 */
function selected(now, data){
	// 汉字转换
	data = encodeURI(data);
	var textValue = now.innerText;
	$(now).parent().parent().parent().hide();
	$(now).parent().parent().parent().attr("temp","none");
	var id = $(now).parent().parent().parent().attr("id");
	
	$("#param").attr("value", $("#param").val() + data );
	
	$("#newSelect").append($("<DIV sizcache='1' sizset='29' id='123'><A  id='456' class='current mr10' href='#' cmImpressionSent='1' onclick=deleteItem(this,'"
			+ id +"','"+ data +"');>"+textValue+"</A></DIV>"));
	
    $("#selected").show();
    
    var $newPgDiv = $("#resultDiv");
 	var actionUrl=path + "/audit2/projectApplication!getAddAuditList.action?key=" + $("#key").val() + "&groupId="+$("#groupId").val() + $("#param").val() + getExpertName() +"&date=" + new Date().getTime();
 	// alert(actionUrl);
    $newPgDiv.load(actionUrl, null, function() {
		//upms.hideOverLay();
	});
	//alert(now.innerText);
}

/**
 * 取得专家名称条件
 */
function getExpertName(){
	if($.trim($("#expertName").val())){
		return "&expertName=" +  encodeURI($("#expertName").val());
	}
	else{
		return "";
	}
}

/**
 * 删除已选择的条件
 * @param now
 * @param pId
 * @param data
 */
function deleteItem(now, pId, data){
	var num = $(now).parent().parent().children().size();
	$(now).parent().remove();
	
	$("#param").attr("value", $("#param").val().replace(data,""));

	if(num == 1){
		$("#selected").hide();
	}
	//$("#" +  pId).show();
	
	if($("#" +  pId).attr("ref1") != "listHidden" || $("#ShowDimList").css("display") == "none"){
		$("#" +  pId).show();
	}
	$("#" +  pId).attr("temp","");
	var $newPgDiv = $("#resultDiv");
 	var actionUrl=path + "/audit2/projectApplication!getAddAuditList.action?key=" + $("#key").val() + "&groupId="+$("#groupId").val() + $("#param").val()+ getExpertName() +"&date=" + new Date().getTime();
    $newPgDiv.load(actionUrl, null, function() {
		//upms.hideOverLay();
	});
}

/**
 * 重置筛选条件
 */
function reselect(){

	$("#selected").hide();
	var newDom = $("#newSelect");
	$(newDom).children().remove();
	for(var i = 1; i< 11; i++){
		
		$("#dimfilter" + i).attr("temp","");
		if(isAllFlag){
			$("#dimfilter" + i).show();
		}
		else{
			if($("#dimfilter" + i).attr("ref1") != "listHidden"){
				$("#dimfilter" + i).show();
			}
		}
	}
	$("#expertName").attr("value","");
	$("#param").attr("value","");
	var $newPgDiv = $("#resultDiv");
 	var actionUrl=path + "/audit2/projectApplication!getAddAuditList.action?key=" + $("#key").val() + "&groupId="+$("#groupId").val()+ getExpertName() +"&date=" + new Date().getTime();
    $newPgDiv.load(actionUrl, null, function() {
		//upms.hideOverLay();
	});
}

/**
 * 添加专家信息
 */
function insertExpert(){
	var key = $("#key").val();
	var temp = art;
	var actionUrl= path + "/audit2/projectApplication!showAuditInsertExpert.action?now="+new Date().getTime();
	if(key == '1'){
		actionUrl= path + "/audit2/projectApplication!showAuditInsertExpert.action?key=" + key + "&now="+new Date().getTime();
		var win = art.dialog.top.parent;
		art = win.art;
	}

	art.dialog.open(
		actionUrl,
		{
			title: '专家添加',
			width: '1000px',
			height: '664px',
			left: '45%',
			top: '40%',
			lock:true,
			padding: 0,
			okVal: '保存',
			ok: function(){
				var iframe = this.iframe.contentWindow;
				var insertExpert = iframe.document.getElementById("insertExpert");
				var expertName = iframe.document.getElementById("expertName");
				var sex = iframe.document.getElementById("sex");
				var birthday = iframe.document.getElementById("birthday");
				var schooling = iframe.document.getElementById("schooling");
				var graduateSchool = iframe.document.getElementById("graduateSchool");
				var expertJob = iframe.document.getElementById("expertJob");
				var skillJob = iframe.document.getElementById("skillJob");
				var expertDegree = iframe.document.getElementById("expertDegree");
				var academicTitle = iframe.document.getElementById("academicTitle");
				var expertMajor = iframe.document.getElementById("expertMajor");
				var expertMajor1 = iframe.document.getElementById("expertMajor1");
				var expertMajor2 = iframe.document.getElementById("expertMajor2");
				var expertMajor3 = iframe.document.getElementById("expertMajor3");
				var expertPrestige = iframe.document.getElementById("expertPrestige");
				var expertWork = iframe.document.getElementById("expertWork");
				var deptType = iframe.document.getElementById("deptType");
				var expertType = iframe.document.getElementById("expertType");
				var recommendWork = iframe.document.getElementById("recommendWork");
				var expertIncumbency = iframe.document.getElementById("expertIncumbency");
				var workPhone = iframe.document.getElementById("workPhone");
				var housePhone = iframe.document.getElementById("housePhone");
				var phone = iframe.document.getElementById("phone");
				var email = iframe.document.getElementById("email");
				var portraiture = iframe.document.getElementById("portraiture");
				var researchFindings = iframe.document.getElementById("researchFindings");
				
				var errorexpertName = iframe.document.getElementById("errorexpertName");
				var errorsex = iframe.document.getElementById("errorsex");
				var errorbirthday = iframe.document.getElementById("errorbirthday");
				var errorschooling = iframe.document.getElementById("errorschooling");
				var errorgraduateSchool = iframe.document.getElementById("errorgraduateSchool");
				var errorexpertJob = iframe.document.getElementById("errorexpertJob");
				var errorskillJob = iframe.document.getElementById("errorskillJob");
				var errorexpertDegree = iframe.document.getElementById("errorexpertDegree");
				var erroracademicTitle = iframe.document.getElementById("erroracademicTitle");
				var errorexpertMajor = iframe.document.getElementById("errorexpertMajor");
				var errorexpertMajor1 = iframe.document.getElementById("errorexpertMajor1");
				var errorexpertMajor2 = iframe.document.getElementById("errorexpertMajor2");
				var errorexpertMajor3 = iframe.document.getElementById("errorexpertMajor3");
				var errorexpertPrestige = iframe.document.getElementById("errorexpertPrestige");
				var errorexpertWork = iframe.document.getElementById("errorexpertWork");
				var errordeptType = iframe.document.getElementById("errordeptType");
				var errorexpertType = iframe.document.getElementById("errorexpertType");
				var errorrecommendWork = iframe.document.getElementById("errorrecommendWork");
				var errorexpertIncumbency = iframe.document.getElementById("errorexpertIncumbency");
				var errorworkPhone = iframe.document.getElementById("errorworkPhone");
				var errorhousePhone = iframe.document.getElementById("errorhousePhone");
				var errorphone = iframe.document.getElementById("errorphone");
				var erroremail = iframe.document.getElementById("erroremail");
				var errorportraiture = iframe.document.getElementById("errorportraiture");
				var errorresearchFindings = iframe.document.getElementById("errorresearchFindings");
				
				//var domInputList = new Array(expertJob,expertName, birthday, graduateSchool, academicTitle, expertMajor, expertWork, recommendWork, workPhone, housePhone, phone, email, portraiture);
				var domInputList = new Array(expertName, phone, email);
				//var domSelectList = new Array(sex, schooling,expertDegree, expertMajor1, expertIncumbency, expertType);
				var domSelectList = new Array(skillJob, expertType,expertIncumbency);
				var domTextareaList = new Array(researchFindings);
				//var errInputList = new Array(errorexpertJob, errorexpertName, errorbirthday, errorgraduateSchool, erroracademicTitle, errorexpertMajor, errorexpertWork, errorrecommendWork, errorworkPhone, errorhousePhone, errorphone, erroremail, errorportraiture);
				var errInputList = new Array(errorexpertName,errorphone, erroremail);
				//var errSelectList = new Array(errorsex, errorschooling, errorskillJob, errorexpertDegree, errorexpertMajor1, errorexpertMajor2, errorexpertMajor3, errorexpertPrestige, errordeptType, errorexpertIncumbency, errorexpertType);
				var errSelectList = new Array(errorskillJob,errorexpertType,errorexpertIncumbency);
				var errTextAreaList = new Array(errorresearchFindings);
				var result1 = false;
				var result2 = false;
				if(checkDialog(domInputList, errInputList, domSelectList, errSelectList, domTextareaList, errTextAreaList)){
					result1 = true;
				}
				
				if(checkExpertMajors(expertMajor1, expertMajor2, expertMajor3, errorexpertMajor1)){
					result2 = true;
				}
				if(result1 || result2){
					return false;
				}
				
				
				
				$.ajax({
					url: path + "/audit2/projectApplication!insertAuditExpert.action?key=" + key + "&date=" + new Date().getTime(),   // 提交的页面
                    data: $(insertExpert).serialize(), // 从表单中获取数据
                    type: "POST", 
                    success:refreshExpertList
				});
				
			},
			cancelVal: '关闭',
			cancel: true
		}
	 );
	 
	art = temp;
}

/**
 * 刷新选择专家页面
 */
function refreshExpertList(){
	var $newPgDiv = $("#resultDiv");
 	var actionUrl=path + "/audit2/projectApplication!getAddAuditList.action?key=" + $("#key").val() + "&groupId="+$("#groupId").val() + $("#param").val() + getExpertName() +"&date=" + new Date().getTime();
    $newPgDiv.load(actionUrl, null, function() {
		return true;
	});
}

/**
 * 擅长专业不能相同
 * @param major1
 * @param major12
 * @param major3
 * @returns {Boolean}
 */
function checkExpertMajors(major1, major2, major3, error){
	if(isNotNullAndDifferent(major1.value,major2.value) || 
			isNotNullAndDifferent(major1.value,major3.value)||
			isNotNullAndDifferent(major2.value,major3.value)){
		$(error).remove();
		var span = $("<div id='error"+ major1.id +"'><span style='color:red;'>擅长专业不能相同！</span></div>");
		$(major3).parent().append(span);
		return true;
	}
	else{
		$(error).remove();
		return false;
	}
}

function isNotNullAndDifferent(value1, value2){
	if(value1 != "" && value2 != "" && value1 == value2){
		return true;
	}
	else{
		return false;
	}
}


/**
 * 页面输入验证
 * @param domInputList
 * @param errInputList
 * @param domSelectList
 * @param errSelectList
 * @param domTextareaList
 * @param errTextAreaList
 * @returns {Boolean}
 */
function checkDialog(domInputList, errInputList, domSelectList, errSelectList, domTextareaList, errTextAreaList){
	var result = false;
	for(var i=0; i < domInputList.length; i++){
		var id = domInputList[i].id;
		if($("#hidden"+ id).length >0){
			// 取得页面隐藏中验证信息
			if(errInputList[i] != "undefined"){
				$(errInputList[i]).remove();
			}
			var str = $("#hidden"+ id).val();
			var datas=str.split(",");
			var flag = upms.upmsUtils.blurTextCheck(domInputList[i], datas[0], datas[1], datas[2]);
			if(!flag){
				result = true;
			}
		}
	}
	
	for(var i=0; i < domSelectList.length; i++){
		var id = domSelectList[i].id;
		if($("#hidden"+ id).length >0){
			if(domSelectList[i].value == ""){
				if(errSelectList[i] != "undefined"){
					$(errSelectList[i]).remove();
				}
				var text = $("#hidden" + id).val();
				var span = $("<div id='error"+ id +"'><span style='color:red;font-style: normal;'>"+ text + "不能为空！</span></div>");
				$(domSelectList[i]).parent().append(span);
				result = true;
			}
		}
	}
	
	for(var i=0; i < domTextareaList.length; i++){
		var id = domTextareaList[i].id;
		if($("#hidden"+ id).length >0){
			// 取得页面隐藏中验证信息
			if(errTextAreaList[i] != "undefined"){
				$(errTextAreaList[i]).remove();
			}
			var str = $("#hidden"+ id).val();
			var datas=str.split(",");
			var flag = upms.upmsUtils.blurTextCheck(domTextareaList[i], datas[0], datas[1], datas[2], datas[3]);
			if(!flag){
				result = true;
			}
		}
	}
	
	return result;
}