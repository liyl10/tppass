<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title></title>
		<style type="text/css">
		<!--
		td{ background-color:#FFF
		}
		-->
		</style>
		
		<link href="${pageContext.request.contextPath}/resource/css/yz.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resource/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resource/css/theme.css" rel="stylesheet" type="text/css" />
		<!-- script src="${pageContext.request.contextPath}/api_scenter/js/jquery-1.4.4.min.js" type="text/javascript" -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-1.4.4.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/validate.js"></script>
		<script type="text/javascript">
		$(document).ready(function(){
			   //jquery start
   /**
	 * 表单验证
	 */
	var validform=$("#role_insert_form").Validform({
		tiptype:3,
		showAllError:true,
		datatype:{
			"choose":/^([^-,]+-[^-,]+-[^-,]+(,)??)+$/,
			"zh2-5":/^[\u4E00-\u9FA5\uf900-\ufa2d]{2,5}$/,
			"zh":/^[\u4E00-\u9FA5\uf900-\ufa2d]+$/,
			"space":/^\s*$/,
			"mobleOrPhone":/^((\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)$/,
			"limit":/^[^<script]+$/,
			"limit_2":/^[^<>]$/,
			"limit_3":/^[^&]$/,
			"re_illeg":function(gets,obj,curform,regxp){
						var state=true;
				        //参数gets是获取到的表单元素值，
				        //obj为当前表单元素，
				        //curform为当前验证的表单，
				        //regxp为内置的一些正则表达式的引用。
				        regxp=/^[\w\W]{6,16}$/;
				        var regP=new RegExp(/[<|>]/g);
				       	//gets=gets.replace("<","&lt;");
				        //gets=gets.replace(">","&gt;");
				        var getsT=gets.replace(regP,"&lt;");//替换尖括号
				        $(obj).attr("value",getsT);
				        state=regxp.test(getsT);
				        return state;  //表示验证出错，没有return或者return true表示验证通过。
				    }
			
		}
	});
	
	validform.addRule([
		{
		ele:"#txt_v1",
		datatype:"*",
		nullmsg:"(输入值不能为空)"
		},
		{
		ele:"#txt_v1_e1",
		datatype:"space",
		nullmsg:"(必须为空)"
		},
		{
		ele:"#txt_v2",
		datatype:"*6-16",
		nullmsg:"(输入6-16位任意字符)"
		},
		{
		ele:"#txt_v3",
		datatype:"n",
		nullmsg:"(输入数字类型)"
		},
		{
		ele:"#txt_v4",
		datatype:"n6-16",
		nullmsg:"(输入6-16位数字)"
		},
		{
		ele:"#txt_v5",
		datatype:"s",
		nullmsg:"(输入字符串)"
		},
		{
		ele:"#txt_v6",
		datatype:"s6-16",
		nullmsg:"(输入6-16位字符串)"
		},
		{
		ele:"#txt_v7",
		datatype:"p",
		nullmsg:"(输入邮政编码)"
		},
		{
		ele:"#txt_v8",
		datatype:"m",
		nullmsg:"(输入手机号码)"
		},
		{
		ele:"#txt_v9",
		datatype:"e",
		nullmsg:"(输入Email)"
		},
		{
		ele:"#txt_v10",
		datatype:"url",
		nullmsg:"(输入url)"
		},
		{
		ele:"#txt_v11",
		datatype:"n",
		ignore:"ignore",
		nullmsg:"为空或输入数字"
		},
		{
		ele:"#txt_v12",
		datatype:"zh2-5",
		nullmsg:"(输入2-5个中文)"
		}, 
		{
		ele:"#txt_v13",
		datatype:"zh",
		nullmsg:"(输入中文)"
		}, 
		{
		ele:"#txt_v14",
		datatype:"*6-20",
		nullmsg:"(输入6-20位字符)"
		}, 
		{
		ele:"#txt_v15",
		datatype:"*6-20",
		recheck:"txt_v14",	
		nullmsg:"(请再次输入密码)"
		}, 
		{
		ele:"#txt_v16",
		datatype:"limit",
		nullmsg:"(请输入内容)"
		}, 
		{
		ele:"#txt_v17",
		datatype:"mobleOrPhone",
		nullmsg:"(请输入电话或手机)"
		}, 
		{
		ele:"#textarea_v18",
		datatype:"re_illeg",
		nullmsg:"(请输入内容)"
		}        
	]);
	
	$("[datatype]").focusin(function(){
		$(this).siblings(".Validform_checktip").text($(this).attr("nullmsg"));
	});
	$("[datatype]").focusout(function(){
		$(this).siblings(".Validform_checktip").text($(this).attr("nullmsg"));
	});
			   
			   
			   
			   // 我的正则表达式验证
			   
			    $("#text_a").keyup( function() {
			   	var str=$("#text_b").val();
			   	//   /^[a-zA-Z0-9_,]{1,}$/   //1到10个字符，数字、字母、或下滑线组成
			   	//   /^\s*$/   //匹配若干个空格
			   	//if(str==null||str.length==0){return};
				var regStr = new RegExp(/^\s*$/);
				   if(!regStr.test($("#text_a").val())){
						$("#out_text_a").html("验证不通过");
					}
					else{
						$("#out_text_a").html("输入正确");
					}							 
   				}); 
   				
			   //jquery end						   
		 });
		</script>
	</head>
	<body>
		<div class="box-positon">
			<div class="rpos">
				当前位置: 角色管理 - 添加
			</div>
			 
			<div class="clear"></div>
		</div>
		<div class="body-box">
		<div id="temp_valiade">
		<label for="text_a">输入值验证:</label>
  		<input name="text_a" type="text" id="text_a" /><input name="text_b" type="text" id="text_b" value=""/>
  		<div id="out_text_a"></div>
  		</div>
			<form method="post" action="http://www.baidu.com" id="role_insert_form" name="role_insert_form">
<table width="100%" class="pn-ftable" cellpadding="2" cellspacing="1" border="0">
  <tr>
    <td width="120">名称</td>
    <td width="450">&nbsp;</td>
    <td >说明</td>
    <td width="200"></td>
  </tr>
  <tr>
    <td>非空验证</td>
    <td><input type="text" name="txt_v1" id="txt_v1" /></td>
    <td>非空验证</td>
    <td rowspan="11"><strong>内置基本的datatype类型有：</strong> * | *6-16 | n | n6-16 | s | s6-18 | p | m | e   |   url<br />
      *：检测是否有输入，可以输入任何字符，不留空即可通过验证；<br />
      *6-16：检测是否为6到16位任意字符；<br />
      n：数字类型；<br />
      n6-16：6到16位数字；<br />
      s：字符串类型；<br />
      s6-18：6到18位字符串；<br />
      p：验证是否为邮政编码；<br />
      m：手机号码格式；<br />
      e：email格式；<br />
      url：验证字符串是否为网址。 </td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    </tr>
  <tr>
    <td>长度验证</td>
    <td><input type="text" name="txt_v2" id="txt_v2" /></td>
    <td>长度验证</td>
    </tr>
  <tr>
    <td>数字验证</td>
    <td><input type="text" name="txt_v3" id="txt_v3" /></td>
    <td>数字验证</td>
    </tr>
  <tr>
    <td>数字验证限定长度</td>
    <td><input type="text" name="txt_v4" id="txt_v4" /></td>
    <td>限定长度</td>
    </tr>
  <tr>
    <td>字符串验证</td>
    <td><input type="text" name="txt_v5" id="txt_v5" /></td>
    <td>不能输入特殊字符</td>
    </tr>
  <tr>
    <td>字符串验证限定长度</td>
    <td><input type="text" name="txt_v6" id="txt_v6" /></td>
    <td>限定长度</td>
    </tr>
  <tr>
    <td>邮编</td>
    <td><input type="text" name="txt_v7" id="txt_v7" /></td>
    <td>邮编</td>
    </tr>
  <tr>
    <td>手机号码验证</td>
    <td><input type="text" name="txt_v8" id="txt_v8" /></td>
    <td>默认的手机号码验证！ 存在问题</td>
    </tr>
  <tr>
    <td>Email</td>
    <td><input type="text" name="txt_v9" id="txt_v9" /></td>
    <td>Email验证</td>
    </tr>
  <tr>
    <td>url验证</td>
    <td><input type="text" name="txt_v10" id="txt_v10" /></td>
    <td>url验证</td>
    </tr>
   <tr>
    <td colspan="4">以下是我们扩展的库</td>
    </tr>
   <tr>
     <td>必须为空</td>
     <td><input type="text" name="txt_v1_e1" id="txt_v1_e1" /></td>
     <td>必须为空</td>
     <td>&nbsp;</td>
   </tr>
   <tr>
    <td>选择性验证</td>
    <td><input type="text" name="txt_v11" id="txt_v11" /></td>
    <td>若为空则不进行验证，非空则验证</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>中文验证限定字数</td>
    <td><input type="text" name="txt_v12" id="txt_v12" /></td>
    <td>中文验证限定字数</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>中文验证</td>
    <td><input type="text" name="txt_v13" id="txt_v13" /></td>
    <td>中文验证</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>密码</td>
    <td><input type="text" name="txt_v14" id="txt_v14" /></td>
    <td>密码</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>重复密码</td>
    <td><input type="text" name="txt_v15" id="txt_v15" /></td>
    <td>重复密码</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>特殊字符验证</td>
    <td><input type="text" name="txt_v16" id="txt_v16" /></td>
    <td>特殊字符验证</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>电话或手机</td>
    <td><input type="text" name="txt_v17" id="txt_v17" /></td>
    <td>电话或手机验证，支持手机号码，3-4位区号，7-8位直播号码1－4位分机号。如：12345678901、1234-12345678-1234 </td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>过滤特殊的字符串</td>
    <td><textarea name="textarea_v18" id="textarea_v18" cols="45" rows="5"></textarea></td>
    <td>过滤特殊的字符串</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
		<input type="submit" name="btn_submit" value="提交" class="submit" />		
			</form>
		</div>
		<div id="dialog" title="Download complete">
			<div id="dialog_content"></div>
		</div>
		
		
	</body>
</html>