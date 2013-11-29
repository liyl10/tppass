// 验证汉字、字母、空格
function nameValidate(str,o) {
	var obj = new RegExp(/^[A-Z|a-z|\s|\u4e00-\u9fa5]*$/);
    str = str.replace(/(^\s*|\s*$)/g,'');
    str = str.replace(/\s+/g, ' ');
    $(o).val(str);
    if (!obj.test(str)) {
    	return false;
    }else{
    	return true;
    }
}

// 验证汉字、字母
function deptnameValidate(str,o) {
	var obj = new RegExp(/^[A-Z|a-z|\u4e00-\u9fa5]*$/);
    str = str.replace(/\s+/g, '');
    $(o).val(str);
    if (!obj.test(str)) {
    	return false;
    }else{
    	return true;
    }
}

// 验证字母
function codeValidate(str,o) {
	var obj = new RegExp(/^[A-Z|a-z]*$/);
    str = str.replace(/\s+/g, '');
    $(o).val(str);
    if (!obj.test(str)) {
    	return false;
    }else{
    	return true;
    }
}

//字符串长度包括（半角、中文、全角）
function getStringLength(str) {
  var totalLength = 0;
  var list = str.split("");
  for(var i = 0; i < list.length; i++) {
   var s = list[i];
   if (s.match(/[\u0000-\u00ff]/g)) { //半角
    totalLength += 1; 
   } else if (s.match(/[\r]/g)) { //换行
    totalLength += 1; 
   } else if (s.match(/[\u4e00-\u9fa5]/g)) { //中文  
    totalLength += 3; 
   } else if (s.match(/[\uff00-\uffff]/g)) { //全角 
    totalLength +=3;
   ///[\u1100-\u115F\u11A3-\u11A7\u11FA-\u11FF\u2329\u232A\u2E80-\u303E\u3040-\u4DBF\u4E00-\uA4CF\uA960-\uA97F\uAC00-\uD7FF\uF900-\uFAFF\uFE10-\uFE1F\uFE30-\uFE6F\uFF01-\uFF60\uFFE0-\uFFE7]/ 
   } else if (s.match(/[\u1100-\u115F\u11A3-\u11A7\u11FA-\u11FF\u2329\u232A\u2E80-\u303E\u3040-\u4DBF\u4E00-\uA4CF\uA960-\uA97F\uAC00-\uD7FF\uF900-\uFAFF\uFE10-\uFE1F\uFE30-\uFE6F\uFF01-\uFF60\uFFE0-\uFFE7]/g)) { //全角 
    totalLength +=3;
   }else{
   	totalLength +=1;
   }
  }   
  return totalLength;
}

//给个焦点
function setfocus(val) {
	document.getElementById(val).focus();
}
//得到字符串的绝对长度
function getlength(str) {
	return str.match(/[^ -~]/g) == null ? str.length : str.length + str.match(/[^ -~]/g).length;
} 

// 验证2位小数
function moneyvalid(val) {
	var result=val.match(/^(?:-?(?:(?:[1-9]\d{0,2}(?:,\d{3})*)|[1-9]\d*|0))(?:\.\d{1,2})?$/);
	if (result == null) {
		return false;
	} 
	return true;
}

//光标位置：
function endpoint(val) {
	var obj = document.getElementById(val);
	var rng = obj.createTextRange();
	rng.setEndPoint("StartToEnd", rng);
	rng.select();
}
//是否为空
function ifnull(val) {
	var renull = new RegExp(/^[ ]*$/);
	if (renull.test(val) || val == null || val == undefined) {
		return true;
	} else {
		return false;
	}
}
//是否数字
function isnumber(val) {
	var renumber = new RegExp(/^[0-9]+$/);
	if (renumber.test(val)) {
		return true;
	} else {
		return false;
	}
}

// 判断输入是否是一个整数
function isint(str) {
    var result=str.match(/^(-|\+)?\d+$/);
    if(result==null) {
    	return false;
    }
    return true;
}

//验证带汉字的用户名
function usernamevalidate(val) {
	var name = new RegExp(/^(\w|[\u4e00-\u9fa5])*$/);
	if (name.test(val)) {
		return true;
	}
	return false;
}

//验证用户名 6-18个数字、字母、下划线，以字母开头
function validateUsername(val) {
	var filter=/^\s*[A-Za-z][A-Za-z0-9_]{5,18}\s*$/;
	if (!filter.test(val)) {
		return false;
	}
	return true;
}

//验证用户名
function usernamevali(val, int1, int2) {
	var par = "/^\\w{" + int1 + "," + int2 + "}$/";
	if (!(eval(par).test(val))) {
		//alert("\u7528\u6237\u540d\u4e0d\u5408\u6cd5\uff01" + int1 + "-" + int2 + "\u4f4d\uff0c\u5b57\u6bcd\uff0c\u6570\u5b57\uff0c\u4e0b\u5212\u7ebf");
		return false;
	}
	return true;
}
//验证用户名
function usernamevali2(str) {
	if (getlength(str) > 15 || getlength(str) < 3) {
		alert("\u7528\u6237\u540d\u957f\u5ea6\u4e0d\u5408\u6cd5\uff01\u7edd\u5bf9\u957f\u5ea63-15\u4f4d(\u6c49\u5b57\u7b97\u4e24\u4f4d)");
		return false;
	}
	if (!/^[\u4e00-\u9fa5\w]+$/.test(str)) {
		alert("\u7528\u6237\u540d\u4e0d\u5408\u6cd5\uff013-15\u4f4d\uff0c\u5b57\u6bcd\uff0c\u6570\u5b57\uff0c\u4e0b\u5212\u7ebf\uff0c\u6c49\u5b57(\u6c49\u5b57\u7b97\u4e24\u4f4d)");
		return false;
	}
	return true;
}

//验证用户名
function usernamevaliLogin(val) {
	if (!/^\w{3,16}$/.test(val)) {
		alert("\u7528\u6237\u540d\u4e0d\u5408\u6cd5\uff013-16\u4f4d\uff0c\u5b57\u6bcd\uff0c\u6570\u5b57\uff0c\u4e0b\u5212\u7ebf");
		return false;
	}
	return true;
}
//验证用户名
function usernamevaliLogin2(str) {
	if (getlength(str) > 16 || getlength(str) < 3) {
		//alert("\u7528\u6237\u540d\u957f\u5ea6\u4e0d\u5408\u6cd5\uff01\u7edd\u5bf9\u957f\u5ea63-16\u4f4d(\u6c49\u5b57\u7b97\u4e24\u4f4d)");
		return false;
	}
	if (!/^[\u4e00-\u9fa5\w]+$/.test(str)) {
		//alert("\u7528\u6237\u540d\u4e0d\u5408\u6cd5\uff013-16\u4f4d\uff0c\u5b57\u6bcd\uff0c\u6570\u5b57\uff0c\u4e0b\u5212\u7ebf\uff0c\u6c49\u5b57(\u6c49\u5b57\u7b97\u4e24\u4f4d)");
		return false;
	}
	return true;
}
//验证联系人
function usernamevaliLogin3(str) {
	if (getlength(str) > 20 || getlength(str) < 3) {
		//alert("\u7528\u6237\u540d\u957f\u5ea6\u4e0d\u5408\u6cd5\uff01\u7edd\u5bf9\u957f\u5ea63-16\u4f4d(\u6c49\u5b57\u7b97\u4e24\u4f4d)");
		return false;
	}
	if (!/^[\u4e00-\u9fa5\w]+$/.test(str)) {
		//alert("\u7528\u6237\u540d\u4e0d\u5408\u6cd5\uff013-16\u4f4d\uff0c\u5b57\u6bcd\uff0c\u6570\u5b57\uff0c\u4e0b\u5212\u7ebf\uff0c\u6c49\u5b57(\u6c49\u5b57\u7b97\u4e24\u4f4d)");
		return false;
	}
	return true;
}

//验证url
function urlValidate(url) {
	var obj = new RegExp(/^http:\/\/[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/);
	if (!obj.test(url)) {
		return false;
	}
	return true;
}
//验证url 不带http://
function validateUrl(url) {
	var obj = new RegExp(/^[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/);
	if (!obj.test(url)) {
		return false;
	}
	return true;
}

//验证固定电话
function phoneValidate(phone) {
	//var obj = new RegExp(/^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/);
	var obj = new RegExp(/^(0[0-9]{2,3}-)?([2-9][0-9]{6,7})+(-[0-9]{1,4})?$/);
	if (!obj.test(phone)) {
		return false;
	}
	return true;
}
//去掉空格
function trim(str) {
	return str.replace(/(^\s*)|(\s*$)/g, "");
}
//验证手机号码
function mobileValidate(mobile) {
	//var obj = new RegExp(/^1[3458]\d{9}$/);
	var obj = new RegExp(/^0{0,1}(13[0-9]|147|15[6-9]|153|180|182|18[6-9])[0-9]{8}$/);
	if (!obj.test(mobile)) {
		return false;
	}
	return true;
}
//验证邮政编码
function isZipCode(zipCode) {
	//var obj = new RegExp(/[1-9]\d{5}(?!\d)/);
	var obj = new RegExp(/^\d{6}$/);
    if(!obj.test(zipCode)) {
    	return false;
    }
    
    return true;
}

//验证密码
function pwdValidate(val) {
	if (!/^.{6,20}$/.test(val)) {
		alert("\u5bc6\u7801\u4e0d\u5408\u6cd5\uff01(6-20\u4f4d)");
		return false;
	}
	return true;
}

// 判断输入是否是有效的长日期格式 - "YYYY-MM-DD HHSS" || "YYYY/MM/DD HHSS"
function isDateTime(str) {
	var obj = new RegExp(/^(\d{4})(-|\/)(\d{1,2})\2(\d{1,2}) (\d{1,2})(\d{1,2})(\d{1,2})$/);
    if (!obj.test(str)) {
    	return false;
    }
    var d = new Date(result[1], result[3]-1, result[4], result[5], result[6], result[7]);
    return (d.getFullYear()==result[1]&&(d.getMonth()+1)==result[3]&&d.getDate()==result[4]&&d.getHours()==result[5]&&d.getMinutes()==result[6]&&d.getSeconds()==result[7]);
}

// 检查是否为 YYYY-MM-DD || YYYY/MM/DD 的日期格式
function isdate(str) {
	var obj = new RegExp(/^(\d{4})(-|\/)(\d{1,2})\2(\d{1,2})$/);
	if(!obj.test(str)) {
		return false;
	}
	
	return true;
}

//校验密码：只能输入6-20个字母、数字、下划线   
function isPasswd(pwd) {
	var patrn = /^(\w){6,20}$/;
	if (!patrn.exec(pwd)) {
		return false;
	}
	return true;
} 
function isName(val) {
	var patrn = /^(\w){6,16}$/;
	if (!patrn.exec(val)) {
		return false;
	}
	return true;
}     

//验证email
function email(val) {
	if (!ifnull(val)) {
		var eexp = new RegExp(/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/);
		if (!eexp.test(val)) {
			return false;
		} else {
			return true;
		}
	} else {
		return false;
	}
}
//验证密码 6-16位
function checkpassword(obj1, obj2, reobj2) {
	if (obj1.value == "" || obj1.value.length < 6 || obj1.value.length > 16) {
		alert("\u8bf7\u8f93\u5165\u539f\u5bc6\u7801 (6-16\u4f4d)");
		obj1.focus();
		return false;
	}
	if (obj2.value == "" || obj2.value.length < 6 || obj2.value.length > 16) {
		alert("\u8bf7\u8f93\u5165\u65b0\u5bc6\u7801 (6-16\u4f4d)");
		obj2.focus();
		return false;
	}
	if (reobj2.value == "") {
		alert("\u8bf7\u91cd\u590d\u5bc6\u7801!");
		reobj2.focus();
		return false;
	}
	if (obj2.value != reobj2.value) {
		alert("\u5bc6\u7801\u4e0d\u4e00\u81f4!");
		return false;
	}
	return true;
}
 
//验证密码 6-16位
function passwordvali(obj1, obj2) {
	if (obj1.val() == "" || obj1.value.length < 6 || obj1.value.length > 16) {
		alert("\u8bf7\u8f93\u5165\u5408\u6cd5\u7684\u5bc6\u7801! (6-16\u4f4d)");
		obj1.focus();
		return false;
	}
	if (obj2.value == "") {
		alert("\u8bf7\u91cd\u590d\u5bc6\u7801!");
		obj2.focus();
		return false;
	}
	if (obj1.value != obj2.value) {
		alert("\u5bc6\u7801\u4e0d\u4e00\u81f4!");
		return false;
	}
	return true;
}

 

// 判断单选框或复选框是否有被选中
function isChecked(obj) {
	var checked = false;
	for (var i = 0; i <obj.length; i++) {
		if (obj[i].checked) {
			checked = true;
		}
	}
	
	return checked;
}
    
//验证图片    
function checkImgSize(val) {
	var imgSize = 1024 * 1024 * 2; //最大2M
	if (!ifnull(val)) {
        //检测类型
		if (!/^.+\.(jpg|bmp|png|gif)$/.test(val.toLowerCase())) {
			alert("\u53ea\u652f\u6301\u4e0a\u4f20jpg, bmp, png, gif  \u683c\u5f0f\u7684\u56fe\u7247 ");
			return false;
		}
		/* 
      var img = new Image();
      img.dynsrc=val; 
                if(img.fileSize > imgSize){
                 alert("图片大小超出了 "+imgSize/1024/1024+"M 的最大上传限制!  ");
                    return false;
                }else if(img.fileSize<=0){
                    alert("无效的路径！");
                    return false;
                }
                
       return true;
        */
	}
	return true;
}

  //图片缩放：
function imgcon(width, height, val) {
	var w = val.width;
	var h = val.height;
	if (w > width) {
		h = width / w * h;
		w = width;
		if (h > height) {
			w = height / h * w;
			h = height;
		}
	}
	if (h > height) {
		w = height / h * w;
		h = height;
		if (w > width) {
			h = width / w * h;
			w = width;
		}
	}
	val.width = w;
	val.height = h;
}
//验证文件    
function checkFileType(val,types) {
	if (!ifnull(val)) {
        //检测类型
        var expstr="/^.+\.(";
        var array=types.split(",");
        
        for(var i=0;i<array.length;i++){
            expstr=expstr+array[i];
	        if(i<array.length-1){
	         expstr=expstr+"|";
	        }
        }
        expstr=expstr+")$/";
        var exp=new RegExp(eval(expstr));
		if (!exp.test(val.toLowerCase())) {
			alert("\u53ea\u652f\u6301\u4e0a\u4f20 "+types+"  \u683c\u5f0f\u7684\u6587\u4ef6 ");
			return false;
		}else{
		 return true;
		}
	}else{
	  alert("请选择上传的文件！");
	  return false;
	}
	return false;
}

//时钟：
var timerID = null;
var timerRunning = false;
function MakeArray(size) {
	this.length = size;
	for (var i = 1; i <= size; i++) {
		this[i] = "";
	}
	return this;
}
function stopclock() {
	if (timerRunning) {
		clearTimeout(timerID);
	}
	timerRunning = false;
}
function showtime() {
	var now = new Date();
	var year = now.getYear();
	if (year < 1900) {
		year = year + 1900;
	}
	var month = now.getMonth() + 1;
	var date = now.getDate();
	var hours = now.getHours();
	var minutes = now.getMinutes();
	var seconds = now.getSeconds();
	var day = now.getDay();
	Day = new MakeArray(7);
	Day[0] = "\u661f\u671f\u5929";
	Day[1] = "\u661f\u671f\u4e00";
	Day[2] = "\u661f\u671f\u4e8c";
	Day[3] = "\u661f\u671f\u4e09";
	Day[4] = "\u661f\u671f\u56db";
	Day[5] = "\u661f\u671f\u4e94";
	Day[6] = "\u661f\u671f\u516d";
	var timeValue = "";
	timeValue += year + "-";
	timeValue += ((month < 10) ? "0" : "") + month + "-";
	timeValue += date + " ";
	timeValue += hours;
	timeValue += ((minutes < 10) ? ":0" : ":") + minutes;
	timeValue += ((seconds < 10) ? ":0" : ":") + seconds + "  ";
	timeValue += (Day[day]) + "  ";
	document.getElementById("clock").innerHTML = timeValue;
	timerID = setTimeout("showtime()", 1000);
	timerRunning = true;
}
function startclock() {
	stopclock();
	showtime();
} 

//剩余字数
function charcount(id, number, name) {
	var count = document.getElementById(name).value.length;
	var lastcount = number - count;
	if (lastcount < 0) {
		document.getElementById(id).innerHTML = "<span style='color:red'>\u5df2\u8d85\u51fa\u6700\u5927\u5b57\u6570!&nbsp;" + number + "&nbsp;\u5b57</span>";
	} else {
		document.getElementById(id).innerHTML = "\u5269\u4f59\u5b57\u6570:&nbsp;<span style='color:green'>" + lastcount + "</span>&nbsp;\u5b57&nbsp;(\u5b9e\u9645\u5185\u5bb9\u4ee5\u6e90\u7801\u4e3a\u51c6)";
	}
}

//Ajax验证验证码是否正确
var http_request = false;
function send_request(url) {
			//初始化、指定处理函数、发送请求的函数
	http_request = false;
				//开始初始化XMLHttpRequest对象
	if (window.XMLHttpRequest) { 
				//Mozilla 浏览器
		http_request = new XMLHttpRequest();
		if (http_request.overrideMimeType) {
					//设置MiME类别
			http_request.overrideMimeType("text/xml");
		}
	} else {
		if (window.ActiveXObject) { 
				// IE浏览器
			try {
				http_request = new ActiveXObject("Msxml2.XMLHTTP");
			}
			catch (e) {
				try {
					http_request = new ActiveXObject("Microsoft.XMLHTTP");
				}
				catch (e) {
				}
			}
		}
	}
	if (!http_request) { 
				// 异常，创建对象实例失败
		window.alert("\u4e0d\u80fd\u521b\u5efaXMLHttpRequest\u5bf9\u8c61\u5b9e\u4f8b.");
		return false;
	}
	http_request.onreadystatechange = processRequest;
				// 确定发送请求的方式和URL以及是否同步执行下段代码
	http_request.open("post", url, true);
	http_request.send(null);
}
			// 处理返回信息的函数
function processRequest() {
	if (http_request.readyState == 4) { // 判断对象状态
		if (http_request.status == 200) { // 信息已经成功返回，开始处理信息
			var res = http_request.responseText;
			callback(res);
		}
	}
}
function addFavo(title) {
	if (document.all) {
		try {
			window.external.addFavorite("http://www.xdzinfo.com", title);
		}
		catch (e1) {
			try {
				window.external.addToFavoritesBar("http://www.xdzinfo.com", title);
			}
			catch (e2) {
				alert("\u52a0\u5165\u6536\u85cf\u5931\u8d25,\u8bf7\u60a8\u4f7f\u7528ctrl+d\u8fdb\u884c\u624b\u5de5\u52a0\u5165");
			}
		}
	} else {
		if (window.external) {
			window.sidebar.addPanel(title, "http://www.xdzinfo.com", "");
		} else {
			alert("\u52a0\u5165\u6536\u85cf\u5931\u8d25,\u8bf7\u60a8\u4f7f\u7528ctrl+d\u8fdb\u884c\u624b\u5de5\u52a0\u5165");
		}
	}
}

//设为主页兼容firefox
function setHomepage() {
	if (document.all) {
		document.body.style.behavior = "url(#default#homepage)";
		document.body.setHomePage("http://www.xdzinfo.com");
	} else {
		if (window.sidebar) {
			if (window.netscape) {
				if (confirm("\u662f\u5426\u5c06\u201chttp://www.xdzinfo.com\u201d\u8bbe\u4e3a\u4e3b\u9875?")) {
					try {
						netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
					}
					catch (e) {
						alert("\u8be5\u64cd\u4f5c\u88ab\u6d4f\u89c8\u5668\u62d2\u7edd\uff0c\u5982\u679c\u60f3\u542f\u7528\u8be5\u529f\u80fd\uff0c\u8bf7\u5728\u5730\u5740\u680f\u5185\u8f93\u5165 about:config,\u7136\u540e\u5c06\u9879 signed.applets.codebase_principal_support \u503c\u8be5\u4e3atrue");
					}
				}
			}
			var prefs = Components.classes["@mozilla.org/preferences-service;1"].getService(Components.interfaces.nsIPrefBranch);
			prefs.setCharPref("browser.startup.homepage", "http://www.xdzinfo.com");
		}
	}
}
//通用电话号码验证
String.prototype.Trim = function(){  
  var m = this.match(/^\s*(\S+(\s+\S+)*)\s*$/);  
  return (m == null) ? "" : m[1];  
}
String.prototype.isMobile = function(){  
  return (/^(?:13\d|15[89])-?\d{5}(\d{3}|\*{3})$/.test(this.Trim()));  
} 
String.prototype.isTel = function(){
    //"兼容格式: 国家代码(2到3位)-区号(2到3位)-电话号码(7到8位)-分机号(1-3位)"
    //return (/^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/.test(this.Trim()));
    return (/^(([0\+]\d{2,3}-)?(0\d{2,3})-)(\d{7,8})(-(\d{1,3}))?$/.test(this.Trim()));
}
//传对象进来
function checkphone(tel){  
        if (tel.value.isMobile()||tel.value.isTel()){  
            tel.value = tel.value.Trim();  
            alert("您的电话号码是:" + tel.value);
            return true;  
        }else{  
            alert("请输入正确的电话号码\n如:13571977141或029-88452097或029-88452097-123"); 
            tel.focus();
            return false;        
        }          
}
//传对象的值进来
function checkphonevalue(tel){  
        if (tel.isMobile()||tel.isTel()){          
            return true;  
        }else{   
            return false;        
        }          
} 
//验证身份证号码
function isIdCardNo(num) {
	if (isNaN(num)) {
		return false;
	}
	var len = num.length, re;
	if (len == 15) {
		re = new RegExp(/^(\d{6})()?(\d{2})(\d{2})(\d{2})(\d{3})$/);
	} else {
		if (len == 18) {
			re = new RegExp(/^(\d{6})()?(\d{4})(\d{2})(\d{2})(\d{3})(\d)$/);
		} else {
			return false;
		}
	}
	var a = num.match(re);
	if (a != null) {
		if (len == 15) {
			var D = new Date("19" + a[3] + "/" + a[4] + "/" + a[5]);
			var B = D.getYear() == a[3] && (D.getMonth() + 1) == a[4] && D.getDate() == a[5];
		} else {
			var D = new Date(a[3] + "/" + a[4] + "/" + a[5]);
			var B = D.getFullYear() == a[3] && (D.getMonth() + 1) == a[4] && D.getDate() == a[5];
		}
		if (!B) {
			return;
			false;
		}
	}
	return true;
}
//验证身份证号码结束	
//自定义去除首尾空格,增加了对象非空判断。
function trim_val(str) {
	if(str!=null&&str!='undefind'){
		return str.replace(/(^\s*)|(\s*$)/g, "");
		}
}
 