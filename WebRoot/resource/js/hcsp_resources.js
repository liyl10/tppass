/**
 * @comment 主要作于页面表单验证提示使用，可做扩展用于页面的友情提示。提供的demo若无特别声明，均可直接运行。
 * @filename hcsp_resources.js
 * @date Dec 25, 2012
 * @vsersion 1.0
 * Copyright (C) 2012 辉盛科技发展责任有限公司
 * @demo
 * alert(h_res.name_requied);//使用所有项目公共的资源
 * alert(h_res.scenter.example);//使用子平台公共的资源
 * alert(h_res.scenter.config.nullmsg.configName);//使用子平台中某一模块的资源
 */

/**
 * @comment 资源类
 */
var h_res = function(){}
/**
 * @comment 事件资源类
 */
h_res.event = function(){}
/**
 * @comment 事件资源
 */
h_res.event.blur = "blur";//
h_res.event.change = "change";//
h_res.event.click = "click";
h_res.event.dbclick = "dbclick";//双击事件
h_res.event.error = "error";//error事件
h_res.event.focus = "focus";
h_res.event.focusin = "focusin";
h_res.event.focusout = "focusout";
h_res.event.keydown = "keydown";
h_res.event.keyup = "keyup";
h_res.event.keypress = "keypress";
h_res.event.mousedown = "mousedown";
h_res.event.mouseenter = "mouseenter";
h_res.event.mouseleave = "mouseleave";
h_res.event.mousemove = "mousemove";
h_res.event.mouseout = "mouseout";
h_res.event.mouseover = "mouseover";
h_res.event.mouseup = "mouseup";
h_res.event.resize = "resize";
h_res.event.scroll = "scroll";
h_res.event.select = "select";
h_res.event.submit = "submit";
h_res.event.upload = "upload";
/**
 * @comment 所有项目公用资源
 */
h_res.name_requied = "名称不为空";
h_res.address_requied = "地址不为空";
h_res.phone_requied = "电话不为空";
h_res.mobile_requied = "手机不为空";
h_res.postal_requied = "邮编不为空";
h_res.country_requied = "国家不为空";
h_res.province_requied = "省份不为空";
h_res.city_requied = "市不为空";
h_res.county_requied = "县不为空";
h_res.village_requied = "乡镇不为空";
h_res.name_requied = "名称不为空";
/**
 * @comment 管理中心-公共资源
 */
h_res.scenter = function(){}
/*
h_res.scenter.nullmsg = function(){}
h_res.scenter.nullmsg.authname="";*/
/**
/**
 * @comment 管理中心-系统参数模块资源
 */
h_res.scenter.config = function(){}
/**
 * @comment 管理中心-系统参数模块非空提示
 */
h_res.scenter.config.nullmsg = function(){}
h_res.scenter.config.nullmsg.configName = "参数名称不为空";
h_res.scenter.config.nullmsg.configCode = "参数代码不为空";
h_res.scenter.config.nullmsg.configChoose = "可供选择的值不为空";
h_res.scenter.config.nullmsg.configDesc ="配置介绍不为空";
/**
 * @comment 管理中心-系统参数模块错误提示
 */
h_res.scenter.config.errormsg = function(){}
h_res.scenter.config.errormsg.configChoose="\"值-code-说明\"为单元，单元的属性以\“-\”分隔，<br/>多个单元以\“,\”分隔。如：0-male-男,1-female-女";

/**
/**
 * @comment 管理中心-权限模块资源
 */
h_res.scenter.auth = function(){}
/**
 * @comment 管理中心-权限模块非空提示
 */
h_res.scenter.auth.nullmsg = function(){}
h_res.scenter.auth.nullmsg.new_auth_name="请输入1-10个字符，可使用汉字、字母";
h_res.scenter.auth.nullmsg.new_auth_code="code必须唯一，建议格式为项目缩写.类缩写.方法缩写，如：sc.auth.auth_list";
h_res.scenter.auth.nullmsg.new_auth_desc="权限描述不超过200个字";
h_res.scenter.auth.nullmsg.new_auth_order="请输入十位以内的整数，越大越靠前";
/**
 * @comment 管理中心-权限模块错误提示
 */
h_res.scenter.auth.errormsg = function(){}
 /**
 * @comment 管理中心-角色模块资源
 */
h_res.scenter.role = function(){}
/**
 * @comment 管理中心-角色模块非空提示
 */
h_res.scenter.role.nullmsg = function(){}
h_res.scenter.role.nullmsg.role_name="角色名称不能为空！";
h_res.scenter.role.nullmsg.verify_note="审核备注不超过200个字";

/**
 * @comment 管理中心-角色模块错误提示
 */
h_res.scenter.role.errormsg = function(){}
h_res.scenter.role.errormsg.role_name="1-40个汉字、字母、数字！";
h_res.scenter.role.errormsg.role_desc="角色描述不超过200个字！";
h_res.scenter.role.errormsg.role_order="请输入十位以内的整数，越大越靠前！";
h_res.scenter.role.errormsg.verify_note="审核备注不超过200个字！";
/**
 * @comment 管理中心-角色模块提示
 */
h_res.scenter.role.tips = function(){}
h_res.scenter.role.tips.role_name="1-40个汉字、字母、数字";
h_res.scenter.role.tips.role_desc="角色描述不超过200个字";
h_res.scenter.role.tips.role_order="请输入十位以内的整数，越大越靠前";
h_res.scenter.role.tips.verify_note="审核备注不超过200个字";
 


/**
 * @comment 管理中心-用户模块资源
 */
h_res.scenter.user = function(){}
/**
 * @comment 管理中心-用户模块验证提示
 */
h_res.scenter.user.errormsg = function(){}
h_res.scenter.user.errormsg.username="6-18个数字、字母、下划线，字母开头！";
h_res.scenter.user.errormsg.userRealname="1-20个汉字、字母、数字！";
h_res.scenter.user.errormsg.userNickname="1-20个汉字、字母、数字！";
h_res.scenter.user.errormsg.userPwd="6-20个非空格字符！";
h_res.scenter.user.errormsg.userPwd2="两次输入的密码不一致！";
h_res.scenter.user.errormsg.userPhone="电话号码格式不正确！";
h_res.scenter.user.errormsg.userEmail="电子邮箱格式不正确！";
h_res.scenter.user.errormsg.verify="审核备注不超过200个字！";
h_res.scenter.user.errormsg.oldPwd="6-20个非空格字符！";
h_res.scenter.user.errormsg.mpwd="6-20个字符，不修改请留空！";
/**
 * @comment 管理中心-用户模块为空提示
 */
h_res.scenter.user.nullmsg = function(){}
h_res.scenter.user.nullmsg.username="用户名不能为空！";
h_res.scenter.user.nullmsg.userRealname="真实姓名不能为空！";
h_res.scenter.user.nullmsg.userParentName="请选择上级管理员!";
h_res.scenter.user.nullmsg.userPwd="请输入密码！";
h_res.scenter.user.nullmsg.userPwd2="请再次输入密码！";
h_res.scenter.user.nullmsg.oldPwd="请输入原密码！";
h_res.scenter.user.nullmsg.modify="请输入新密码！";

/**
 * @comment 管理中心-用户模块提示
 */
h_res.scenter.user.tips = function(){}
h_res.scenter.user.tips.username="6-18个数字、字母、下划线，字母开头";
h_res.scenter.user.tips.userRealname="1-20个汉字、字母、数字";
h_res.scenter.user.tips.userNickname="1-20个汉字、字母、数字";
h_res.scenter.user.tips.userParentName="请选择上级管理员";
h_res.scenter.user.tips.userPwd="6-20个非空格字符";
h_res.scenter.user.tips.userPwd2="请再次输入密码";
h_res.scenter.user.tips.userPhone="填写常用电话，例如：029-88452097/13512334454";
h_res.scenter.user.tips.userEmail="填写常用电子邮箱";
h_res.scenter.user.tips.oldPwd="请输入原密码";
h_res.scenter.user.tips.modify="请输入新密码";
h_res.scenter.user.tips.modify2="请输入确认密码";
h_res.scenter.user.tips.mpwd="6-20个字符，不修改请留空";
h_res.scenter.user.tips.verify="审核备注不超过200个字";

/**
 * @comment 管理中心-部门模块资源
 */
h_res.scenter.dept = function(){}
/**
 * @comment 管理中心-部门模块验证提示
 */
h_res.scenter.dept.errormsg = function(){}
h_res.scenter.dept.errormsg.deptName="1-40个汉字、字母、数字！";
h_res.scenter.dept.errormsg.deptCode="1-20个字母、数字！";
h_res.scenter.dept.errormsg.deptLeader="1-20个汉字、字母！";
h_res.scenter.dept.errormsg.deptLinkman="1-20个汉字、字母！";
h_res.scenter.dept.errormsg.deptAddress="5-100个汉字、字母、数字！";
h_res.scenter.dept.errormsg.deptPostcode="邮政编码不正确！";
h_res.scenter.dept.errormsg.deptPhone="电话号码格式不正确！";
h_res.scenter.dept.errormsg.deptFax="传真号码格式不正确！";
h_res.scenter.dept.errormsg.deptEmail="电子邮箱格式不正确！";
h_res.scenter.dept.errormsg.deptDesc="部门介绍不超过2000个字！";

/**
 * @comment 管理中心-部门模块为空提示
 */
h_res.scenter.dept.nullmsg = function(){}
h_res.scenter.dept.nullmsg.deptName="部门名称不能为空！";
h_res.scenter.dept.nullmsg.deptCode="部门代码不能为空！";

/**
 * @comment 管理中心-部门模块提示
 */
h_res.scenter.dept.tips = function(){}
h_res.scenter.dept.tips.deptName="1-40个汉字、字母、数字";
h_res.scenter.dept.tips.deptCode="1-20个字母、数字";
h_res.scenter.dept.tips.deptLeader="1-20个汉字、字母";
h_res.scenter.dept.tips.deptLinkman="1-20个汉字、字母";
h_res.scenter.dept.tips.deptAddress="5-100个汉字、字母、数字";
h_res.scenter.dept.tips.deptPostcode="填写正确的邮编";
h_res.scenter.dept.tips.deptPhone="填写常用电话，例如：029-88452097/13512334454";
h_res.scenter.dept.tips.deptFax="填写常用传真号，例如：029-88452097";
h_res.scenter.dept.tips.deptEmail="填写常用电子邮箱";
h_res.scenter.dept.tips.deptDesc="部门介绍不超过2000个字";










