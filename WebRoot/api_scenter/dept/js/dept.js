/**
 * @comment 部门信息添加、修改页面对应验证的js
 * @author dulei(dulei@hopsun.cn)
 * @date 2013-01-10
 * @version 1.0
 */
$(document).ready(function () {
	
	/**
	 * 表单验证
	 */
	var demo=$("#myform").Validform({
		tiptype:3,
		showAllError:true,
		datatype:{
			"deptName":/^[A-Z|a-z|\d|\u4e00-\u9fa5]{1,40}$/,
			"deptCode":/^[A-Z|a-z|\d]{1,20}$/,
			"deptLeader":/^[A-Z|a-z|\s|\u4e00-\u9fa5]{1,20}$/,
			"deptAddress":/^[A-Z|a-z|\d|\s|\u4e00-\u9fa5]{5,100}$/,
			"deptPostcode":/[1-9]\d{5}(?!\d)/,
			"deptPhone":/^(0[0-9]{2,3}-)?([2-9][0-9]{6,7})+(-[0-9]{1,4})?$/,
			"deptEmail":/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/
		}
	});	
	
	$("#deptName").focusout(function(){
		demo.addRule([{
			ele:"#deptName",
			datatype:"deptName",
			ajaxurl:"${pageContext.request.contextPath}/api/dept_getDeptByName.action?deptname="+$('#deptName').val()+"&parentid="+$("#userDeptId").val()+"&deptId="+$("#deptId").val(),
			tips:h_res.scenter.dept.tips.deptName,
			nullmsg:h_res.scenter.dept.nullmsg.deptName,
			errormsg:h_res.scenter.dept.errormsg.deptName
		}]);
	});
	
	$("#userDeptName").focusout(function(){
		if($("#userDeptId").val().length>0 && $("#deptName").val().length>0){
			demo.addRule([{
				ele:"#deptName",
				datatype:"deptName",
				ajaxurl:"${pageContext.request.contextPath}/api/dept_getDeptByName.action?deptname="+$('#deptName').val()+"&parentid="+$("#userDeptId").val()+"&deptId="+$("#deptId").val(),
				tips:h_res.scenter.dept.tips.deptName,
				nullmsg:h_res.scenter.dept.nullmsg.deptName,
				errormsg:h_res.scenter.dept.errormsg.deptName
			}]);
		}
	});
	
	$("#deptCode").focusout(function(){
		demo.addRule([{
			ele:"#deptCode",
			datatype:"deptCode",
			ajaxurl:"${pageContext.request.contextPath}/api/dept_getDeptByCode.action?deptcode="+$('#deptCode').val()+"&parentid="+$("#userDeptId").val()+"&deptId="+$("#deptId").val(),
			tips:h_res.scenter.dept.tips.deptCode,
			nullmsg:h_res.scenter.dept.nullmsg.deptCode,
			errormsg:h_res.scenter.dept.errormsg.deptCode
		}]);
	});
	
	demo.addRule([{
		ele:"#deptName",
		datatype:"*",
		tips:h_res.scenter.dept.tips.deptName,
		nullmsg:h_res.scenter.dept.nullmsg.deptName
	},
	{
		ele:"#deptCode",
		datatype:"*",
		tips:h_res.scenter.dept.tips.deptCode,
		nullmsg:h_res.scenter.dept.nullmsg.deptCode
	},
	{
		ele:"#deptLeader",
		datatype:"deptLeader",
		ignore:"ignore",
		tips:h_res.scenter.dept.tips.deptLeader,
		errormsg:h_res.scenter.dept.errormsg.deptLeader
	},
	{
		ele:"#deptLinkman",
		datatype:"deptLeader",
		ignore:"ignore",
		tips:h_res.scenter.dept.tips.deptLinkman,
		errormsg:h_res.scenter.dept.errormsg.deptLinkman
	},
	{
		ele:"#deptAddress",
		datatype:"deptAddress",
		ignore:"ignore",
		tips:h_res.scenter.dept.tips.deptAddress,
		errormsg:h_res.scenter.dept.errormsg.deptAddress
	},
	{
		ele:"#deptPostcode",
		datatype:"p",
		ignore:"ignore",
		tips:h_res.scenter.dept.tips.deptPostcode,
		errormsg:h_res.scenter.dept.errormsg.deptPostcode
	},
	{
		ele:"#deptPhone",
		datatype:"deptPhone|m",
		ignore:"ignore",
		tips:h_res.scenter.dept.tips.deptPhone,
		errormsg:h_res.scenter.dept.errormsg.deptPhone
	},
	{
		ele:"#deptFax",
		datatype:"deptPhone",
		ignore:"ignore",
		tips:h_res.scenter.dept.tips.deptFax,
		errormsg:h_res.scenter.dept.errormsg.deptFax
	},
	{
		ele:"#deptEmail",
		datatype:"e",
		ignore:"ignore",
		tips:h_res.scenter.dept.tips.deptEmail,
		errormsg:h_res.scenter.dept.errormsg.deptEmail
	},
	{
		ele:"#deptDesc",
		datatype:"*0-2000",
		ignore:"ignore",
		tips:h_res.scenter.dept.tips.deptDesc,
		errormsg:h_res.scenter.dept.errormsg.deptDesc
	}]);
	
	$("[datatype]").focusin(function(){
		var tips = "<span class='custom_checktip'>"+$(this).attr("tips")+"</span>";
		$(this).parent().append(tips);
		$(this).siblings(".Validform_checktip").hide();
	}).focusout(function(){
		$(this).siblings(".custom_checktip").remove();
		$(this).siblings(".Validform_checktip").css("display","");
	});
	
})