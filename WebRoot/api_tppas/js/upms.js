
(function(window,undefined){
	// 定义局部变量
	var document = window.document,
		navigator = window.navigator,
		location = window.location,
		$ = window.jQuery,
		jQuery = window.jQuery,	
		tempId = "",
		indexTemp = 0;
	// 国际化
	var LANG = {};	
	if (window.UPLANG){
		LANG = window.UPLANG;
	}
	// 公共参数
	var PUBVAR = {};
	// cookie操作工具类
	var cookieUtils = {
		get:function(name){// 获取cookie值
			var cookieName = encodeURIComponent(name) + "=",
				cookieStart = document.cookie.indexOf(cookieName),
				cookieValue = null;
			if (cookieStart > -1){
				var cookieEnd = document.cookie.indexOf(";",cookieStart);
				if (cookieEnd == -1){
					cookieEnd = document.cookie.length;
				}
				cookieValue = decodeURIComponent(document.cookie.substring(cookieStart + cookieName.length,cookieEnd));
			}
			return cookieValue;
		},
		set:function(sName,sValue,oExpires,sPath,sDomain,bSecure){// 设置cookie值
            var currDate = new Date(),
            	sExpires = typeof oExpires == 'undefined'?'':';expires=' + new Date(currDate.getTime() + (oExpires * 24 * 60 * 60* 1000)).toUTCString();
            document.cookie = sName + '=' + sValue + sExpires + ((sPath == null)?'':(' ;path=' + sPath)) + ((sDomain == null)?'':(' ;domain=' + sDomain)) + ((bSecure == true)?' ; secure':'');
		},
		unset:function(name,path,domain,secure){// 删除cookie值
			this.set(name,"",new Date(0),path,domain,secure);
		}			
	};
	// upms框架通用工具类
	var upmsUtils = {
		getSysLanguage:function(){// 获取系统语言
			var sysLang = navigator.systemLanguage,
				userLang = navigator.userLanguage,
				bLang = navigator.language;
			
			if (sysLang != undefined){
				return sysLang.toLowerCase();
			}else if (userLang != undefined){
				return userLang.toLowerCase();
			}else if (bLang != undefined){
				return bLang.toLowerCase();
			}else{// 默认
				return "zh-cn";
			}
		},
		getDomainHead:function(){// 获取网站url头  例如：http://127.0.0.1/UPMS/
			var sHost = location.host,
				sProtocol = location.protocol,
				sPathNm = location.pathname;
			var arrPathNm = sPathNm.split("\/");
			var domainHead = sProtocol + "\/\/" + sHost + "\/";
			if (arrPathNm.length > 1){
				if(arrPathNm[1] !='service'){
					domainHead += arrPathNm[1] + "\/";
				}
			}
			if (domainHead.substr(domainHead.length - 1) != "\/"){
				domainHead = domainHead + "\/";
			}
			return domainHead;
		},
		/**
		 * 文本域最大输入长度限制
		 * @param value 文本域的值
		 * @param maxLength 最大输入长度
		 * @returns
		 */
		checkTextareaLength:function(now,maxLength){   
			if(now.value.length>parseInt(maxLength)){
				now.value = now.value.substring(0,parseInt(maxLength));
				} 
			
		},
		/**
		 * 数字输入限制
		 * @param e event
		 * @param url 当前对象
		 */
		isNum:function(e, url){
			var flag = false;
			var k = window.event ? e.keyCode : e.which;
			 //alert(k);
			if ((k < 48 || k > 57 ) && k != 8 && k != 0){
				 // 禁止ctrl+c ctrl+v
				 if(e.ctrlKey && (k==99 || k==118)){
					 
				 }
				 else{
					 flag = true;
				 }
			 }
			 if(url.value=="0" && k != 8 && k != 0){
				 flag = true;
			 }
			 
			 if(flag){
				if (window.event) { 
					 window.event.returnValue = false; 
				} 
				 else { e.preventDefault(); //for firefox
				 }
			}
		},
		/**
		 * 小数输入限制
		 * @param e event
		 * @param url 当前对象
		 */
		isFloatNum:function(e,url){
			var flag = false;
			 
			var k = window.event ? e.keyCode : e.which;
			//alert(k); 
			if (((k < 48) || (k > 57)) && k != 46 &&  k != 45 && k != 8 && k != 0){

				if(e.ctrlKey && (k==99 || k==118)){

				}
				else{
					flag = true;
				}
			}
			else{
				if(k == 46){
					// 第一位不能为小数点
					if($.trim(url.value)==""){
						flag = true;
					}
					else{
						// 不能存在一个以上的小数点
						var pattern = /^\d*\.\d*$/;
						if(pattern.test($.trim(url.value))){
							flag = true;
						}
					} 
				}
				if(k == 45){
					// 第一位不能为小数点
					if($.trim(url.value)==""){
						flag = false;
					}
					else{
						flag = true;
					}
				}
			}
			if(url.value=="0" && ((k!=46 && k != 8 && k != 0) || (k > 48 && k < 58))){

				if((k > 48 && k < 58) || k==45){
					var bro=$.browser;
					if(bro.msie && bro.version=="8.0"){
						switch(k){
							case 49 : url.value = "1";
							break;
							case 50 : url.value = "2";
							break;
							case 51 : url.value = "3";
							break;
							case 52 : url.value = "4";
							break;
							case 53 : url.value = "5";
							break;
							case 54 : url.value = "6";
							break;
							case 55 : url.value = "7";
							break;
							case 56 : url.value = "8";
							break;
							case 57 : url.value = "9";
							break;
							case 45 : url.value = "-";
							break;
						}
					}
					else{
						url.value = "";
						url.onChange();
						
					}
				}
				if (window.event) {
					 var Range = url.createTextRange(); 
					    Range.moveEnd('character', 2);
					    Range.moveStart('character', 1);
					    Range.collapse();
					    Range.select(); 
				}    
				flag = true;
			}

			if(flag){
				if (window.event) { 
					window.event.returnValue = false; 
				} 
				else {
					e.preventDefault(); //for firefox
				}
			}	
		},
		/**
		 * 下一步设置左侧菜单选中状态
		 */ 
		setMenu:function(){
			var path=$("#path").text();
			var flag = true;
			$(".subNav >a").each(function(ind, elem) {
				var aqObj = $(elem);
				var num = ind +2;
				if(flag){
					
					// 浏览器判断
					if(aqObj.css('background-color') == '#e2f3fb' || aqObj.css('background-color') == 'rgb(226, 243, 251)'){
						$(".subNav >a").css('background',"#87baf0 url("+path+"/api_tppas/images/bg_sub_list.gif) no-repeat 10px center");
						$("#subNav" + num).find("a").css('background',"#e2f3fb url("+path+"/api_tppas/images/bg_sub_list.gif) no-repeat 10px center");
						
						$(".subNav >a").css('color',"#fff");
						$("#subNav" + num).find("a").css('color',"#10465f");
						flag = false;
					}
				}
			});
		},
		/**
		 * 设置页面控件disabled状态
		 */
		setDisableControl:function(){
			// 文本框限制
			$("input[type='text']").each(function(){
				$(this).attr("disabled",true);
			});
				
			// 文本域限制
			$("textarea").each(function(){
				$(this).attr("readonly",true);
				$(this).css('background-color','#F0F0F0');
			});

			// radio限制
			$(':input:radio').each(function(){
				$(this).attr("disabled",true);
			});
			// 按钮限制
			$("input[type='button']").each(function(){
				$(this).attr("disabled",true);
			});
		},
		/**
		 * 初始化下拉列表
		 * @param selectId 下拉列表ID
		 * @param value 初始值
		 * @param flag 是否添加【请选择】(0：否； 1：是)
		 * @param step 当前下拉列表级联数
		 * @param isEmpty 是否进行非空验证（0：否； 1：是；2：后台；3：项目分类--部门选择；4：项目分类--项目分类1选择）
		 */
		initSelect:function(selectId, value, flag, step, isEmpty){
			// 添加【请选择】选项
			if(flag == 1){
				$("#" + selectId).prepend("<option value=''>----请选择----</option>");
			}
			// 初期选择值设定
			if(value == ""){
				 $("#"+ selectId).attr("value",'');
			}
			// 选择事件绑定
			if(step == 1){
				if(isEmpty == 0){
					$("#" + selectId).chosen();
				}
				else{
					$("#" + selectId).chosen().change(function(){
						upms.upmsUtils.selectChange(selectId);
					});
				}
			}
			else{
				if(isEmpty == 0){
					$("#" + selectId).chosen();
				}
				else if(isEmpty ==1){
					$("#" + selectId).chosen().change(function(){
						upms.upmsUtils.getSecondData(selectId, step);
					});
				}
				else if(isEmpty ==2){
					$("#" + selectId).chosen().change(function(){
						upms.upmsUtils.getSecondDataApi(selectId, step);
					});
				}
				else if(isEmpty ==3){
					$("#" + selectId).chosen().change(function(){
						upms.upmsUtils.getFatherTypeListData(selectId, step);
					});
				}
				else if(isEmpty ==4){
					$("#" + selectId).chosen().change(function(){
						upms.upmsUtils.getSonTypeListData(selectId, step);
					});
				}
			}
		},
		/**
		 * 单个下拉列表选择变化事件
		 * @param selectId
		 */
		selectChange:function(selectId){
			
			// 选择【请选择】时显示提示信息
			if($("#" + selectId).val() ==""){
				var text = $("#hidden" + selectId).val();
				$("#error" + selectId).remove();
				var span = $("<div id='error"+ selectId +"'><span style='color:red;font-style: normal;'>"+ text + "不能为空！</span></div>");
				$("#" + selectId).parent().append(span);
			}
			// 选择其他内容时，清除提示信息
			else{
				$("#error" + selectId).remove();
			}
		},
		/**
		 * 级联下拉列表选择变化事件
		 * @param selectId
		 * @param step
		 */
		getSecondData:function(selectId, step){
			// 选择【请选择】时显示提示信息
			var id = selectId.substr(0,selectId.length -1);
			if($("#" + selectId).val() ==""){
				var text = $("#hidden" + id + step).val();
				$("#error" + id + step).remove();
				var span = $("<div id='error"+ id + step +"'><span style='color:red;font-style: normal;'>"+ text + "不能为空！</span></div>");
				$("#" + selectId).parent().append(span);
			}
			// 清除选择不能为空的提示信息
			if(selectId.substr(selectId.length -1) == step){
				if($("#" + selectId).val() != ""){
					$("#error" + id + step).remove();
				}
				return;
			}
			var pItemId=$('#'+ selectId).val();
			tempId = id;
			indexTemp = parseInt(selectId.substr(selectId.length -1)) + 1;
			// 取得系统根目录
			var path =$("#path").text();
		    $.ajax({
		       url: path+'/api/superadmin/mitem!getSecondData.action', // 具体方法根据实际工程而定
		       type:'post',
		       dataType:'json',
		       data:{pitemId:pItemId},
		       success:upms.upmsUtils.setSecondData
		    });
		},
		/**
		 * 级联下拉列表选择变化事件（后台）
		 * @param selectId
		 * @param step
		 */
		getSecondDataApi:function(selectId, step){
			// 选择【请选择】时显示提示信息
			var id = selectId.substr(0,selectId.length -1);
			
			var pItemId=$('#'+ selectId).val();
			tempId = id;
			indexTemp = parseInt(selectId.substr(selectId.length -1)) + 1;
			// 取得系统根目录
			var path =$("#path").text();
		    $.ajax({
		       url: path+'/api/superadmin/mitem!getSecondData.action', // 具体方法根据实际工程而定
		       type:'post',
		       dataType:'json',
		       data:{pitemId:pItemId},
		       success:upms.upmsUtils.setSecondData
		    });
		},
		/**
		 * 项目分类级联下拉列表选择变化事件--部门选择
		 * @param selectId
		 * @param step
		 */
		getFatherTypeListData:function(selectId, step){
			// 选择【请选择】时显示提示信息
			var id = selectId.substr(0,selectId.length -1);
			var pItemId=$('#'+ selectId).val();
			tempId = id;
			indexTemp = parseInt(selectId.substr(selectId.length -1)) + 1;
			// 取得系统根目录
			var path =$("#path").text();
		    $.ajax({
		       url: path+'/api/superadmin/typeModel!getFatherTypeListData.action', // 具体方法根据实际工程而定
		       type:'post',
		       dataType:'json',
		       data:{pitemId:pItemId},
		       success:upms.upmsUtils.setSecondData
		    });
		},
		/**
		 * 项目分类级联下拉列表选择变化事件--项目分类1选择
		 * @param selectId
		 * @param step
		 */
		getSonTypeListData:function(selectId, step){
			// 选择【请选择】时显示提示信息
			var id = selectId.substr(0,selectId.length -1);
			var pItemId=$('#'+ selectId).val();
			tempId = id;
			indexTemp = parseInt(selectId.substr(selectId.length -1)) + 1;
			
			// 清除选择不能为空的提示信息
			if(selectId.substr(selectId.length -1) == step){
				if($("#" + selectId).val() != ""){
					$("#error" + id + step).remove();
				}
				return;
			}
			
			// 取得系统根目录
			var path =$("#path").text();
		    $.ajax({
		       url: path+'/api/superadmin/typeModel!getSonTypeListData.action', // 具体方法根据实际工程而定
		       type:'post',
		       dataType:'json',
		       data:{pitemId:pItemId},
		       success:upms.upmsUtils.setSecondData
		    });
		},
		/**
		 * 下拉列表联动
		 * @param json 回传的json对象
		 */
		setSecondData:function(json){
		    var data=json.backStr; 
		    var datas="";
		    if(data!=""){
		       datas=data.split(",");
		    }
		    var tempStr = tempId;
		    var tempIndex = indexTemp;
		    for(;tempIndex < 5; tempIndex ++){
		    	var s_root1=$("#" +tempStr + tempIndex);
		    	if(s_root1.length > 0){
		    		s_root1.find("option").remove();
		    	    s_root1.append("<option value=''>----请选择----</option>");
		    	    s_root1.trigger("liszt:updated");
		    	}
		    }
		    var s_root=$("#" +tempStr + indexTemp);
		    s_root.find("option").remove();
		    s_root.append("<option value=''>----请选择----</option>");
		    for(var i=0;i<datas.length;i++){
		    	 s_root.append("<option value='"+datas[i]+"'>"+datas[i+1]+"</option>");
		       	 i++;
		    }
		    s_root.trigger("liszt:updated");
		    
		},
		/**
		 * 输入验证
		 * @returns 
		 */
		inputCheck:function(){
			var result = false;
			// 页面text验证
			var idList = $("input[type='text']");
			for(var i=0;i<idList.length;i++){
				var id = idList.eq(i).attr("id");
				if(typeof(id)=="undefined"){
					continue;
				}
				// 将jquery对象转为dom对象
				var domObject = idList.eq(i).get(0);
				if($("#hidden"+ id).length >0){
					// 取得页面隐藏中验证信息
					var str = $("#hidden"+ id).val();
					var datas=str.split(",");
					var flag = upms.upmsUtils.blurTextCheck(domObject, datas[0], datas[1], datas[2]);
					if(!flag){
						result = true;
					}
				}
			}
			// 页面textarea验证
			$("select").each(function(){
				
				var id= this.id;
				if($("#hidden"+ id).length >0){
					// 取得页面隐藏中验证信息
					var str = $("#hidden"+ id).val();
					var datas=str.split(",");
					var flag = upms.upmsUtils.blurTextCheck(this, datas[0], datas[1], datas[2], datas[3]);
					if(!flag){
						result = true;
					}
				}
			});
			
			// 页面select验证
			$("textarea").each(function(){
				
				var id= this.id;
				if($("#hidden"+ id).length >0){
					// 取得页面隐藏中验证信息
					var str = $("#hidden"+ id).val();
					var datas=str.split(",");
					var flag = upms.upmsUtils.blurTextCheck(this, datas[0], datas[1], datas[2], datas[3]);
					if(!flag){
						result = true;
					}
				}
			});
			return result;
		},
		/**
		 * 下拉列表未选择时验证
		 * 参数：
		 * @param idList：需要验证的下拉列表id数组
		 */
		selectCheck:function(idList){
			var result = false;
			for(var i=0; i< idList.length; i++){
				if($("#" + idList[i]).length >0){
					if($("#"+ idList[i] +" option:selected").val() ==""){
						var text = $("#hidden" + idList[i]).val();
						$("#error" + idList[i]).remove();
						var span = $("<div id='error"+ idList[i] +"'><span style='color:red;font-style: normal;'>"+ text + "不能为空！</span></div>");
						$("#" + idList[i]).parent().append(span);
						result = true;
					}
				}
			}
			return result;
		},
		/**
		 * radio选择未选择时的验证
		 * @param nameList 需要验证的radio的name数组
		 */
		radioCheck:function(nameList,isSub){
			var flag = false;
			for(var i=0; i < nameList.length; i++){
				var checkedItem = $("input:radio[name='"+nameList[i]+"']:checked").val();
				var radioItem = $("input:radio[name='"+ nameList[i] +"']");
				
				if(checkedItem==null){
					var attrName = radioItem.attr("name");
					if(isSub==1){
						if(attrName.indexOf(".") != -1){
							var attr1 = attrName.substring(0,attrName.lastIndexOf("["));
							var attr2 = attrName.substring(attrName.lastIndexOf("[")+1,attrName.lastIndexOf("]"));
							attrName = attr1 + attr2;
						}
					}else{
						if(attrName.indexOf(".") != -1){
							attrName = attrName.substring(attrName.lastIndexOf(".") +1);
						}
					}
					
					$("#error" + attrName).remove();
					var text = $("#hidden"+ attrName).val();
					var span = $("<div id='error"+attrName+"'><span style='color:red;font-style: normal;'>"+ text + "不能为空！</span></div>");
					radioItem.parent().append(span);
					flag = true;
				}
			}
			return flag;
		},
		/**
		 *  radio选择变化事件
		 * @param now 当前对象
		 */
		radioChange:function(now,isSub){
			
			var radioName = now.name;
			if(radioName.indexOf(".") != -1){
				if(isSub==1){
					var attr1 = radioName.substring(0,radioName.lastIndexOf("["));
					var attr2 = radioName.substring(radioName.lastIndexOf("[")+1,radioName.lastIndexOf("]"));
					radioName = attr1 + attr2;
				}else{
					radioName = radioName.substring(radioName.lastIndexOf(".") +1);
				}
			}
			$("#error" + radioName).remove();
		},
		/**
		 * 焦点离开时的验证
		 * 参数：
		 * @param now: 当前输入框的dom对象
		 * @param text: 提示信息字段名称
		 * @param spaceFlag: 是否进行非空验证（1：需要验证； 0：不需要验证）
		 * @param type: 数据格式验证类型（-1：不需要验证格式； 0：手机； 1：电话； 2：金额； 3：四位整数；
		 * 				 4：七位整数； 5：百分数； 6：邮编； 7：邮箱； 8:textArea； 9:整数； 10：年份
		 * 				11: 输入日期不能大于当前日期；12: 分数;13 >=0 <100 的分数）
		 * @param length: 可输入的最大长度限制（适用于textArea）
		 * 
		 */
		blurTextCheck:function(now, text, spaceFlag, type, length){
			var flag = true;
			var textValue = $.trim(now.value);
			if(textValue == ""){
				// 非空验证
				if(spaceFlag == 1){
					$("#error" + now.id).remove();
					var span = $("<div id='error"+ now.id +"'><span style='color:red;'>"+ text +"不能为空！</span></div>");
					$(now).parent().append(span);
					flag =false;
				}
			}
			else{
				if(type=="-1"){
					return flag;
				}
				else if(type==0){
					var result = upms.checkUtils.isMobilePhone(textValue);
					if(!result){
						$("#error" + now.id).remove();
						var span = $("<div id='error"+ now.id +"'><span style='color:red;'>"+ text +"格式不正确！(11位数字的手机号码，如：手机号码前3位为138 或 180等)</span></div>");
						$(now).parent().append(span);
						flag =false;
					}
				}
				else if(type==1){
					var result = upms.checkUtils.isPhone(textValue);
					if(!result){
						$("#error" + now.id).remove();
						var span = $("<div id='error"+ now.id +"'><span style='color:red;'>"+ text +"格式不正确！(例如：029-88888888)</span></div>");
						$(now).parent().append(span);
						flag =false;
					}
				}
				else if(type==2){
					var result = upms.checkUtils.isFloatNum2(textValue);
					if(!result){
						$("#error" + now.id).remove();
						var span = $("<div id='error"+ now.id +"'><span style='color:red;'>"+ text +"格式不正确！(9999999.9999)</span></div>");
						$(now).parent().append(span);
						flag =false;
					}
				}
				else if(type==3){
					var result = upms.checkUtils.isNum4(textValue);
					if(!result){
						$("#error" + now.id).remove();
						var span = $("<div id='error"+ now.id +"'><span style='color:red;'>"+ text +"格式不正确！(9999)</span></div>");
						$(now).parent().append(span);
						flag =false;
					}
				}
				else if(type==4){
					var result = upms.checkUtils.isNum7(textValue);
					if(!result){
						$("#error" + now.id).remove();
						var span = $("<div id='error"+ now.id +"'><span style='color:red;'>"+ text +"格式不正确！(9999999)</span></div>");
						$(now).parent().append(span);
						flag =false;
					}
				}
				else if(type==5){
					var result = upms.checkUtils.isPercentage(textValue);
					if(!result){
						$("#error" + now.id).remove();
						var span = $("<div id='error"+ now.id +"'><span style='color:red;'>"+ text +"格式不正确！(例如：99.99)</span></div>");
						$(now).parent().append(span);
						flag =false;
					}
				}
				else if(type==6){
					var result = upms.checkUtils.isZip(textValue);
					if(!result){
						$("#error" + now.id).remove();
						var span = $("<div id='error"+ now.id +"'><span style='color:red;'>"+ text +"格式不正确！</span></div>");
						$(now).parent().append(span);
						flag =false;
					}
				}
				else if(type==7){
					var result = upms.checkUtils.isEmail(textValue);
					if(!result){
						$("#error" + now.id).remove();
						var span = $("<div id='error"+ now.id +"'><span style='color:red;'>"+ text +"格式不正确！(XXXXXX@XXXX.XX)</span></div>");
						$(now).parent().append(span);
						flag =false;
					}
				}
				else if(type==8){
					var maxlength = textValue.length;
					if(maxlength > length){
						$("#error" + now.id).remove();
						var span = $("<div id='error"+ now.id +"'><span style='color:red;'>"+ text +"输入长度不能超过"+ length +"个字符！</span></div>");
						$(now).parent().append(span);
						flag =false;
					}
				}
				else if(type==9){
					var result = upms.checkUtils.isAllNum(textValue);
					if(!result){
						$("#error" + now.id).remove();
						var span = $("<div id='error"+ now.id +"'><span style='color:red;'>"+ text +"必须为整数！</span></div>");
						$(now).parent().append(span);
						flag =false;
					}
				}
				else if(type ==10){
					var result = upms.checkUtils.isYear(textValue);
					if(!result){
						$("#error" + now.id).remove();
						var span = $("<div id='error"+ now.id +"'><span style='color:red;'>"+ text +"格式不正确（yyyy）！</span></div>");
						$(now).parent().append(span);
						flag =false;
					}
				}
				else if(type == 11){
					// 输入的日期
					var date = textValue;
					// 当前日期
					var nowDate = new Date();
					nowDate = nowDate.getFullYear() +"/" + (nowDate.getMonth() +1) +"/"+ nowDate.getDate();
					if(Date.parse(textValue.replace("-","/").replace("-","/")) < Date.parse(nowDate)){
						$("#error" + now.id).remove();
						var span = $("<div id='error"+ now.id +"'><span style='color:red;font-style: normal;'>"+ text +"不能小于当前日期！</span></div>");
						$(now).parent().append(span);
						flag =false;
					}
				}
				else if(type==12){
					var result = upms.checkUtils.isFloatNum3(textValue);
					if(!result){
						$("#error" + now.id).remove();
						var span = $("<div id='error"+ now.id +"'><span style='color:red;'>"+ text +"分数格式不正确！</span></div>");
						$(now).parent().append(span);
						flag =false;
					}
				}
				else if(type==13){
					var result = upms.checkUtils.isScore(textValue);
					if(!result){
						$("#error" + now.id).remove();
						var span = $("<div id='error"+ now.id +"'><span style='color:red;'>"+ text +"分数不能超过100分！</span></div>");
						$(now).parent().append(span);
						flag =false;
					}
				}
				else{
					// 其他数据格式验证，待补充  
				}
			}
			
			return flag;
		},
		
		/**
		 * 时间区间判断
		 * @param startDateId 开始时间ID
		 * @param endDateId 结束时间ID
		 * @param isEmpty 是否进行非空验证 （0：不需非空验证； 1：需要非空验证）
		 * @param now 当前对象
		 * @param text 提示文本
		 */
		checkStartAndEndDate:function(startDateId, endDateId, isEmpty, text, now, num){
			var startValue = "";
			var endValue ="";
			if(now != null){
				if(isEmpty == 1){
					var valueTemp = $.trim(now.value);
					if(valueTemp == ""){
						$("#error" + now.id).remove();
						if(now.id == startDateId){
							var span = $("<div id='error"+ now.id +"'><span style='color:red;'>"+ text +"开始时间不能为空！</span></div>");
							$(now).parent().append(span);
						}
						else{
							$("#error" + startDateId).remove();

							startValue = $.trim($("#" + startDateId).val());
							if(startValue == ""){
								var span = $("<div id='error"+ startDateId +"'><span style='color:red;'>"+ text +"开始时间不能为空！</span></div>");
								$(now).parent().append(span);
							}

							var span = $("<div id='error"+ now.id +"'><span style='color:red;'>"+ text +"结束时间不能为空！</span></div>");
							$(now).parent().append(span);
						}
						flag =false;
					}
					else{
						if(now.id == startDateId){
							var reportYear = now.value.substring(0,4);
							if($("#reportYear").length > 0 && $("#reportYear").val() !=""){
								if(reportYear != $("#reportYear").val()){
									var span = $("<div id='error"+ startDateId +"'><span style='color:red;'>"+ text +"的开始时间必须等于申报年度！</span></div>");
									$("#" + startDateId).parent().append(span);
									flag =true;
									return flag;
								}
							}
							if($.trim($("#" + endDateId).val()) !=""){
								upms.upmsUtils.checkDate(startDateId, endDateId, text, num);
							}
						}
						else{
							if($.trim($("#" + startDateId).val()) !=""){
								upms.upmsUtils.checkDate(startDateId, endDateId, text, num);
							}
						}
					}
				}
			}else{
				if($.trim($("#" + endDateId).val()) !="" && $.trim($("#" + startDateId).val()) !=""){
					upms.upmsUtils.checkDate(startDateId, endDateId, text, num);
				}
			}
		},
		
		/**
		 * 时间区间判断
		 * @param startDateId 开始时间ID
		 * @param endDateId 结束时间ID
		 * @param text 提示文本
		 */
		checkDate:function(startDateId, endDateId, text, num){
			var startValue = $.trim($("#" + startDateId).val());
			var endValue = $.trim($("#" + endDateId).val());
			var flag = false;
			if($.trim($("#" + endDateId).val()) !="" && $.trim($("#" + startDateId).val()) !=""){
				$("#error" + startDateId).remove();
				var reportYear = startValue.substring(0,4);
				if($("#reportYear").length > 0 && $("#reportYear").val() !=""){
					if(reportYear != $("#reportYear").val()){
						var span = $("<div id='error"+ startDateId +"'><span style='color:red;'>"+ text +"的开始时间必须等于申报年度！</span></div>");
						$("#" + startDateId).parent().append(span);
						flag =true;
						return flag;
					}
				}
				if(startValue.length = 7){
					startValue = startValue + "-01";
					endValue = endValue + "-01";
				}
				if(startValue > endValue){
					var span = $("<div id='error"+ startDateId +"'><span style='color:red;'>"+"开始时间不能大于结束时间！</span></div>");
					$("#" + startDateId).parent().append(span);
					flag =true;
				}
				else{
					if(num != "undefined") {
						
						if(endValue.substr(0,4) - startValue.substr(0,4) > num - 1){
							var span = $("<div id='error"+ startDateId +"'><span style='color:red;'>"+"起止年限区间不能超过" +num +"年！</span></div>");
							$("#" + startDateId).parent().append(span);
							flag =true;
						}
						if(endValue.substr(0,4) - startValue.substr(0,4) < 1){
							var span = $("<div id='error"+ startDateId +"'><span style='color:red;'>"+"起止年限区间不能小于2年！</span></div>");
							$("#" + startDateId).parent().append(span);
							flag =true;
						}
					}
				}
			}else{
				flag = true;
			}
			return flag;
		},
		/**
		 * 获得焦点时的处理
		 * @param now 当前对象
		 */
		textFocus:function(now){
			// 清除错误提示信息
			$("#error" + now.id).remove();
		},
		/**
		 * 提交前准备数据（包括text、textarea和hidden的值）
		 * @param arrParams 存储需要提交数据的数组
		 * @param hiddenFlag 是否提交hidden的值（0：不提交； 1：提交）
		 * @param num 若页面中某一行可为空，num为这一行中text的个数
		 */
		setSubmitDatas:function(arrParams, hiddenFlag, num){
			
			var idList = $("input[type='text']");
			// 添加输入项信息
			for(var i=0; i< idList.length; i++){
				var id = idList.eq(i).attr("id");
				if($("#" + id).val()==""){
					i=i+num;
					continue;
				}
				
				var params = {name:idList.eq(i).attr("name"),targetid:idList.eq(i).attr("id"),type:"text"};
				arrParams[arrParams.length] = params;
			}
			
			if(hiddenFlag == 1){
				
				var hiddenList = $("input[type='hidden']");	
				// 添加动态项信息
				for(var i=0; i< hiddenList.length; i++){
					if(hiddenList.eq(i).attr("name") !="hidden"){
						var params = {name:hiddenList.eq(i).attr("name"),targetid:hiddenList.eq(i).attr("id"),type:"text"};
						arrParams[arrParams.length] = params;
					}
				}
			}
			
			$("textarea").each(function(){
				var params = {name:this.name,targetid:this.id,type:"text"};
				arrParams[arrParams.length] = params;
			});
			
			return arrParams;
		},
		/**
		 * 自动计算（和计算）
		 * @param inValueList 需要相加的值的Id数组
		 * @param fixNum 需要保留的小数位
		 */
		autoCal:function(inValueList, fixNum){
			var value = 0;
			for(var i=0; i<inValueList.length; i++){
				value = value + parseFloat($("#" + inValueList[i]).val() == '' ? 0 : $("#" + inValueList[i]).val());
			}
			var outValue = value.toFixed(fixNum);
			return outValue;
		},
		/**
		 * 提交及设置中间跳转页面
		 * @param url 提交的url
		 * @param arrParams 提交的数据（数组形式）
		 * @param contentFlag 提交页面显示在主页面位置区分（0：mianContent; 1:content）
		 * @param buttonFlag 按钮区分（0：保存按钮； 1：下一步按钮； 2:返回按钮）注：页面不可编辑时，下一步按钮相当于返回按钮，区分为2
		 * @param mappingUrl 映射url（保存、下一步、返回操作时设置为""）
		 */
		submitAndBack:function(url, arrParams, contentFlag, buttonFlag, mappingUrl){
			
			// 取得系统根目录
			var path=$("#path").text();
			// action跳转路径
			//var mappingUrl = "";
			// 设置跳转路径
			if(mappingUrl == ""){
				if(buttonFlag == 0){
					if(contentFlag == 0){
						mappingUrl = "&mappingUrl=mainSystemInfo";
					}
					else{
						mappingUrl = "&mappingUrl=systemInfo";
					}
				}
				else if(buttonFlag == 1){
					mappingUrl = "&mappingUrl=systemInfoNext";
				}
			}
			// 提交url设置
			url = path + url + mappingUrl +"&now=" + new Date().getTime();
			// 打开遮罩
			upms.showOverLay();
			var $newPgDiv=null;
			// 设置提交后显示在页面的位置
			if(contentFlag == 0){
				$newPgDiv = $("#mainContent");
			}else{
				$newPgDiv = $("#content");
			}
			// 提交请求
			var data = upms.transParsToObj(arrParams, $newPgDiv);
			$newPgDiv.load(url, data, function() {
				upms.hideOverLay();
			});
			
		},

		/**
		 * 翻页功能（有翻页功能的页面，在页面js初始化方法中调用）
		 * @param url 提交actionUrl
		 */
		pagination:function(url){
	
			// 取得系统根目录
			var path=$("#path").text();
			//分页
			upms.grid.gridHover($(".t-list"));
			upms.pagequery.initpaging({// 分页
				pgbtnid : "pgbtn",
				queryformid : "formId",
				resultdivid : "resultDiv",
				url : path + url + "&now="+ new Date().getTime()
			});
		},
		/**
		 * 初始化左侧菜单（在显示左侧菜单页面的js初始化方法中调用）
		 * @param url 提交actionUrl
		 */
		initLeftMenu:function(url){
			// 取得系统根目录
			var path=$("#path").text();
			// 图片路径根据实际工程而定
			$(".subNav >a:first").css('background',"#e2f3fb url("+path+"/api_tppas/images/bg_sub_list.gif) no-repeat 10px center");
			$(".subNav >a:first").addClass("background");
			$(".subNav >a:first").css('color',"#10465f");
			
			var value = $(window).height() - 175;

			$(".leftNav").css("height", value);
			$(".rightWrap").css("height", value);
			$("#content").css("height", value);

				$(".subNav >a").each(function(ind, elem) {
				var aqObj = $(elem);
				aqObj.parent("dd").bind("click", function() {
					$(".subNav >a").css('background',"#87baf0 url("+path+"/api_tppas/images/bg_sub_list.gif) no-repeat 10px center");
					$(this).find("a").css('background',"#e2f3fb url("+path+"/api_tppas/images/bg_sub_list.gif) no-repeat 10px center");
					$(this).find("a").addClass("background");
					
					$(".subNav >a").css('color',"#fff");
					$(this).find("a").css('color',"#10465f");
					
				});
			}); 
			
			$("#content").load(path + url + "&now=" + new Date().getTime());
		}
	};
	// 校验工具类
	var checkUtils = {
		infoTip:function(){// 信息提示
			return "";
		},
		isEmptyStr:function(){// 判断字符串是否为空
			var str = arguments[0];
			if (str === undefined || str === null || $.trim(str) === ""){
				return true;
			}else{
				return false;
			}
		},
		isNotEmptyStr:function(){// 判断字符串是否不为空
		    var str = arguments[0];
			if (str === undefined || str === null || $.trim(str) === ""){
				return false;
			}else{
				return true;
			}
		},
		isNull:function(){// 判断变量是不是为空
			var obj = arguments[0];
			if (obj === undefined || obj === null){
				return true;
			}else{
				return false;
			}			
		},
		isNotNull:function(){// 判断变量是不是不为空
			var obj = arguments[0];
			if (obj === undefined || obj === null){
				return false;
			}else{
				return true;
			}				
		},
		isChinese:function(){// 是否是中文
			var str = arguments[0];
			var regex = /.*[\u4e00-\u9fa5]+.*$/;
			return regex.test(str);
		},
		isNotChinese:function(){// 是否不是是中文
			var str = arguments[0];
			var regex = /.*[\u4e00-\u9fa5]+.*$/;
			return !regex.test(str);
		},
		isEmail:function(){//校验email格式
			var str =  $.trim(arguments[0]);
			//var regex = /^([a-zA-Z0-9_-]{1,})((.[a-zA-Z0-9_-]{1,}){0,})@([a-zA-Z0-9_-]{1,})((.[a-zA-Z0-9_-]{1,}){1,})$/;
			var regex =/^[a-zA-Z0-9_+.-]+\@([a-zA-Z0-9-]+\.)+[a-zA-Z0-9]{2,4}$/;
			return regex.test(str);
		},
		isMobilePhone:function(){// 校验手机号码
			var str = arguments[0];
			var regex = /^1[3|4|5|8][0-9]\d{8}$/;
			return regex.test(str);
		},
		isPhone:function(){// 校验电话号码
			var str = arguments[0];
			var regex = /^(0\d{2,3})?(-)?\d{7,8}(-\d{3,4})?$/;
			return regex.test(str);
		}
		,isFloatNum2:function(){
			var str = arguments[0];
			var regex = /^(-)?(([1-9](\d{0,6}))|0)(\.\d{1,4})?$/;
			return regex.test(str);
		}
		,isFloatNum3:function(){
			var str = arguments[0];
			var regex = /^(([1-9](\d{0,2}))|0)(\.\d{1,2})?$/;
			return regex.test(str);
		}
		,isNum4:function(){
			var str = arguments[0];
			var regex = /^(([1-9](\d{0,3}))|0)$/;
			return regex.test(str);
		}
		,isNum7:function(){
			var str = arguments[0];
			var regex = /^(([1-9](\d{0,6}))|0)$/;
			return regex.test(str);
		}
		,isPercentage:function(){
			var str = arguments[0];
			var regex = /^(((([1-9]\d?)|0)(\.\d{1,2})?)|(100(\.0)?))$/;
			return regex.test(str);
		}
		,isZip:function(){
			var str = arguments[0];
			var regex = /^[0-9]{6}$/;
			return regex.test(str);
		}
		,isAllNum:function(){
			var str = arguments[0];
			var regex = /^(([1-9](\d*))|0)$/;
			return regex.test(str);
		}
		,isYear:function(){
			var str = arguments[0];
			var regex = /^[1-9](\d{3})$/;
			return regex.test(str);
		}
		,
		isScore:function(){
			var str = arguments[0];
			var regex = /^(([1-9](\d)?)|0)$/;
			return regex.test(str);
		}
		
	};

	// 个性化的内部对象
	var WEBLOGIN = {
		loginDynamicCss:function(){// 登录页面动态样式
			$(".ipt_txt").bind("blur",function(){
				$(this).removeClass("focusline");
			});
			$(".ipt_txt").bind("focus",function(){
				$(this).addClass("focusline");
			});			
		}		
	};
	// 个性化国际化内部对象
	var WEBLANG = {
		initLang:function($obj){// 国际化方法
			if ($obj.find("span").length == 0){// 如果国际化下拉框无法正常初始化，则从cookie取语言标记
				window.location.href = upmsUtils.getDomainHead();
			}
			$obj.hover(function(){// 头部 国际化语言切换
				$("div", this).show();
			}, function(){
				$("div", this).hide();
			});
		}			
	};
	//  个性化主页面
	var WEBMAIN = {
		initLayout:function(){// 主页面布局初始化
			var _winWidth = window.screen.width;
			$(".body-bg-left").css("width",_winWidth - 42);
			$(".nav_right").css("width",_winWidth - 365);
			upms.$webObj.css("width",_winWidth - 310);
		},
		initMenu:function(defUrl){// 菜单初始化
//			$(".left_menu .p_menu").click(function(){
//				var chk = $(".menu_open",this);
//				$(this).next("ul").slideToggle("normal",function(){
//				   if($(this).is(":visible")){
//				     chk.addClass("menu_close");
//				   }else{
//					 chk.removeClass("menu_close");
//				   }
//				});
//			});
//			$(".left_menu li a").click(function(){
//				$(this).parent().click();
//				return false;
//			});
//			$(".left_menu li").mouseover(function(){
//				$(this).addClass("li_hover");
//			}).mouseout(function(){
//			    $(this).removeClass("li_hover");
//			}).click(function(){	
//		        $(".left_menu li").removeClass("li_check li_hover");
//				$(".left_menu li em").removeClass("em_check");	
//				$(this).addClass("li_check");	
//				$("em",this).addClass("em_check");
//				var oAobj = $("a",this);
//				var _link = oAobj.attr("href");
//				upms.$webObj.load(_link);
//				$("#currAddr_main").text($(".title",$(this).parent("ul").prev("div")).text());
//				$("#currAddr_child").text(oAobj.text());
//			});	
			$(".nav li a").click(function(){
			$(this).parent().click();
			return false;
		});
		$(".nav li").click(function(){	
//	        $(".left_menu li").removeClass("li_check li_hover");
//			$(".left_menu li em").removeClass("em_check");	
//			$(this).addClass("li_check");	
//			$("em",this).addClass("em_check");
			var oAobj = $("a",this);
			var _link = oAobj.attr("href");
			upms.$webObj.load(_link);
//			$("#currAddr_main").text($(".title",$(this).parent("ul").prev("div")).text());
//			$("#currAddr_child").text(oAobj.text());
		});
			upms.$webObj.load(defUrl);

//			$(".left_menu .home").click(function(){
//				  upms.$webObj.load(defUrl);
//				  $("#currAddr_main").text("LANG.websit_home_lang");
//				  $("#currAddr_child").text("LANG.websit_main_welcome");
//			})			

			WEBMAIN.menuClickEvt();
		},
		menuClickEvt:function(){// 菜单点击事件
			//$(".left_menu > ul > li > a").each(function(ind,elem){
			//alert(upmsUtils.getDomainHead());
			$(".nav > ul > li > a").each(function(ind,elem){
				var aqObj = $(elem);
				var actionUrl = aqObj.attr("action");
				aqObj.parent("li").bind("click",function(){
					upms.showOverLay();// 打开遮罩
					upms.clearWebObj();// 清空webObj对象
					var $newPgDiv = upms.createPageDiv();
					var data = {};
					//actionUrl="http://192.168.2.146:8880/atis/web/subMainPage.jsp";
					$newPgDiv.load(actionUrl+"?now="+ new Date().getTime(),data,function(){upms.hideOverLay();});

					//upms.$webObj.load(actionUrl);
					//upms.hideOverLay();
					
//					$.get(actionUrl, function (data) { 
//					    data = '"' + data + '"';    
//					    $newPgDiv.html(data);
//					    var newHTML = $newPgDiv.html();
//					    $newPgDiv.html(newHTML.substr(1,newHTML.length-2));
//					    upms.hideOverLay();
//					});
					
				});
			});			
		}
	};
	// 页面跳转
	var forward = {
		dialogId:"_forward_dialog_modal_",
		execute:function(params){// 跳转页面执行方法
			var sUrl = $.trim(params.url),
				sDialog = params.dialog,
				sDialogTitle = params.dialogtitle,// 对话框的标题
				sDialogTip = params.dialogtip,
				sBtnName = $.trim(params.btnname);
			var $currPgDiv = upms.getCurrPageDiv();
			
			if (checkUtils.isEmptyStr(sDialogTip)){
				sDailogTip = "你确定要操作吗?";
			}
			
			if (checkUtils.isEmptyStr(sDialogTitle)){
				sDialogTitle = "信息提示";
			}
			
			$("a[name='" + sBtnName + "']",$currPgDiv).each(function(ind,elem){
				$(elem).bind("click",function(){
					if (sDialog != "open"){
						upms.showOverLay();// 打开遮罩
						var parentObj = $(elem).parent(),
							selKeys = $.trim($(elem).attr("sendparam")).split(",");
						var data = {};// 传到服务端的参数
						for (var i = 0;i < selKeys.length;i++){
							var tmpDataObj = {};
							tmpDataObj[selKeys[i]] = $("input[name='" + selKeys[i] + "']",parentObj).val();
							$.extend(data,tmpDataObj);
						}
						upms.saveHisPageDiv();// 保存历史记录
						var $newPgDiv = upms.createPageDiv();
						$newPgDiv.load(sUrl,data,function(){
							upms.hideOverLay();// 关闭遮罩
						});							
					}else{
						forward.createDialog(sDialogTitle, sDialogTip, $currPgDiv);
				 		$("#" + forward.dialogId,$currPgDiv).dialog({
				 			autoOpen: true,
							modal: true,
							dialogClass:"dialogfont",
							buttons: {
								"确定":function(){
									upms.showOverLay();// 打开遮罩
									var parentObj = $(elem).parent(),
										selKeys = $.trim($(elem).attr("sendparam")).split(",");
									var data = {};// 传到服务端的参数
									for (var i = 0;i < selKeys.length;i++){
										var tmpDataObj = {};
										tmpDataObj[selKeys[i]] = $("input[name='" + selKeys[i] + "']",parentObj).val();
										$.extend(data,tmpDataObj);
									}
									upms.saveHisPageDiv();// 保存历史记录
									var $newPgDiv = upms.createPageDiv();
									$newPgDiv.load(sUrl,data,function(){
										upms.hideOverLay();// 关闭遮罩
									});	
									$(this).dialog("close");
								},
								"取消":function(){
									$(this).dialog("close");
								}
							}
						}); 						
					}				
				});
			});
		},
		createDialog:function(sTitle,sInfoTip,$currPgDiv){
			var arrHtml = new Array();
			arrHtml.push(" <div id='" + forward.dialogId + "' title='" + sTitle + "' style='display:none'>");
			arrHtml.push("<center><p class='dialogTip'>" + sInfoTip + "</p></center>");
			arrHtml.push("</div>");
			$currPgDiv.append(arrHtml.join(""));
		}
	};
	/*返回按钮操作*/
	var history = {
		go:function(params){
			if ($.type(params) === "string"){
				upmsTipManage.clearUpmsTipObj();// 清空历史提示信息
				var $currPgDiv = upms.getCurrPageDiv();
				$("#" + params,$currPgDiv).bind("click",function(){
					upms.hisGoPageDiv();				
				});	
			}else{
				if ($.isPlainObject(params) && !$.isEmptyObject(params)){
					var sBtnId = params.btnid,
						sModel = params.model;// requery 重查
					upmsTipManage.clearUpmsTipObj();// 清空历史提示信息
					var $currPgDiv = upms.getCurrPageDiv();
					$("#" + sBtnId,$currPgDiv).bind("click",function(){
						upms.hisGoPageDiv();	
						$currPgDiv = upms.getCurrPageDiv();
						pagequery.callbackQuery($currPgDiv);
					});
				}
			}
		}	
	};
	// 分页查询
	var pagequery = {
		pageResultDivId:"",// 查询结果div的id值
		cacheValidateArr:[],// 缓存校验对象
		cacheErrInfoId:"",// 错误信息显示id
		execute:function(params){// 分页查询方法
			var $currPgDiv = upms.getCurrPageDiv();
			pagequery.pageResultDivId = "";
			var sQuFrmId = params.queryformid,// 查询form的id
				sReqType = params.reqtype,// 请求类型
				sQuBtnId = params.querybtnid,// 查询按钮的id值
				sQuUrl = params.queryurl,// 分页查询的url
				sResDivId = params.resultdivid;// 查询结果div的id值
			pagequery.pageResultDivId = sResDivId;
			
			pagequery.savePageQueryParams($currPgDiv, sReqType, sQuFrmId, sQuUrl);// 保存分页查询的重要参数
			
			$("#" + sQuBtnId,$currPgDiv).bind("click",function(){// 给查询按钮添加查询事件
				upmsTipManage.clearUpmsTipObj();// 清空历史提示信息
				upms.showOverLay();// 开启遮罩
				var sQuParams = pagequery.quParamForStr(sQuFrmId,$currPgDiv);// 转化查询条件
				$.ajax({
					type:sReqType,
					url:sQuUrl,
					data:sQuParams,
					success:function(retmsg){
						$("#" + sResDivId,$currPgDiv).html(retmsg);
						upms.hideOverLay();// 关闭遮罩
					},
					error:function(retmsg){
						alert("网络连接错误，请稍候再试！");
						upms.hideOverLay();// 关闭遮罩
					}					
				});
			});
		},
		verifyExecute:function(params){// 带校验的查询
			var $currPgDiv = upms.getCurrPageDiv();
				pagequery.pageResultDivId = "";	
			var sQuFrmId = params.queryformid,// 查询form的id
				sReqType = params.reqtype,// 请求类型
				sQuBtnId = params.querybtnid,// 查询按钮的id值
				sQuUrl = params.queryurl,// 分页查询的url,
				arrValidate = params.validate,// 校验规则
				sErrInfoId = params.errinfoid,// 提示错误信息的id
				sResDivId = params.resultdivid;// 查询结果div的id值
			if (checkUtils.isEmptyStr(sReqType)){
				sReqType = "post";
			}
			pagequery.pageResultDivId = sResDivId;
			pagequery.cacheValidateArr = arrValidate;
			pagequery.cacheErrInfoId = sErrInfoId;
			
			pagequery.savePageQueryParams($currPgDiv, sReqType, sQuFrmId, sQuUrl);// 保存分页查询的重要参数
			
			$("#" + sQuBtnId,$currPgDiv).bind("click",function(){// 给查询按钮添加查询事件
				upmsTipManage.clearUpmsTipObj();// 清空历史提示信息
				pagequery.clearErrInfo(sErrInfoId, $currPgDiv);
				var flag = true;
				pagequery.setFormChkFlag(sQuFrmId, $currPgDiv);// 设置校验标记
				if ($.isArray(arrValidate)){
					for (var i = 0;i < arrValidate.length;i++){
						var obj = arrValidate[i];
						var retVal = pagequery.validateForQuery(obj, sErrInfoId,$currPgDiv);
						if ("nopass" == retVal){
							flag = false;
							break;
						}
					}
				}
				if (flag){
					upms.showOverLay();// 开启遮罩
					var sQuParams = pagequery.quParamForStr(sQuFrmId,$currPgDiv);// 转化查询条件
					$.ajax({
						type:sReqType,
						url:sQuUrl,
						data:sQuParams,
						success:function(retmsg){
							$("#" + sResDivId,$currPgDiv).html(retmsg);
							upms.hideOverLay();// 关闭遮罩
						},
						error:function(retmsg){
							alert("网络连接错误，请稍候再试！");
							upms.hideOverLay();// 关闭遮罩
						}					
					});						
				}
			});
		},
		savePageQueryParams:function($currPgDiv,sReqType,sQuFrmId,sQuUrl){// 保存分页查询的参数
			var HISPGPREF = "hggp_";
			var sCurrPgDivId = $currPgDiv.attr("id");
			var $hisReqTp = $("#" + sCurrPgDivId + HISPGPREF + "type",$currPgDiv),
				$hisFrm = $("#" + sCurrPgDivId + HISPGPREF + "frm",$currPgDiv),
				$hisUrl = $("#" + sCurrPgDivId + HISPGPREF + "url",$currPgDiv);
			if (checkUtils.isNotEmptyStr(sReqType)){// 存储请求类型
				if ( $hisReqTp.length == 0){
					$hisReqTp = $("<input type='hidden' id='" + sCurrPgDivId + HISPGPREF + "type' value='" + sReqType + "' />");
					$currPgDiv.append($hisReqTp);
				}else{
					$hisReqTp.val(sReqType);
				}				
			}
			if (checkUtils.isNotEmptyStr(sQuFrmId)){// 存储参数的form
				if ($hisFrm.length == 0){
					$hisFrm = $("<input type='hidden' id='" + sCurrPgDivId + HISPGPREF + "frm' value='" + sQuFrmId + "' />");
					$currPgDiv.append($hisFrm);					
				}else{
					$hisFrm.val(sQuFrmId);
				}
			}
			if (checkUtils.isNotEmptyStr(sQuUrl)){// 存储url
				if ($hisUrl.length == 0){
					$hisUrl = $("<input type='hidden' id='" + sCurrPgDivId + HISPGPREF + "url' value='" + sQuUrl + "' />");
					$currPgDiv.append($hisUrl);	
				}else{
					$hisUrl.val(sQuUrl);
				}
			}
		},
		callbackQuery:function($currPgDiv){// 回调查询  用于想grid对话框确定按钮回调查询
			var HISPGPREF = "hggp_";
			var sCurrPgDivId = $currPgDiv.attr("id");
			
			var $hisReqTp = $("#" + sCurrPgDivId + HISPGPREF + "type",$currPgDiv),
				$hisFrm = $("#" + sCurrPgDivId + HISPGPREF + "frm",$currPgDiv),
				$hisUrl = $("#" + sCurrPgDivId + HISPGPREF + "url",$currPgDiv);
			
			var sHisReqTp = "",sHisFrm = "",sHisUrl = "";
			
			var flag = true;
			
			if ($hisReqTp.length > 0){
				sHisReqTp = $.trim($hisReqTp.val());
			}else{
				flag = false;
			}
			
			if ($hisFrm.length > 0){
				sHisFrm = $.trim($hisFrm.val());
			}else{
				flag = false;
			}
			
			if ($hisUrl.length > 0){
				sHisUrl = $.trim($hisUrl.val());
			}else{
				flag = false;
			}
			
			if (flag){
				var chkFlag = true;// 校验标记
				if (pagequery.getFormChkFlag(sHisFrm, $currPgDiv) && $.isArray(pagequery.cacheValidateArr)){
					pagequery.clearErrInfo(pagequery.cacheErrInfoId, $currPgDiv);
					var arrValidate = pagequery.cacheValidateArr;
					for (var i = 0;i < arrValidate.length;i++){
						var obj = arrValidate[i];
						var retVal = pagequery.validateForQuery(obj, pagequery.cacheErrInfoId,$currPgDiv);
						if ("nopass" == retVal){
							chkFlag = false;
							break;
						}
					}
				}
				if (chkFlag){
					upms.showOverLay();// 开启遮罩
					var sQuParams = pagequery.quParamForStr(sHisFrm,$currPgDiv);// 转化查询条件
					$.ajax({
						type:sHisReqTp,
						url:sHisUrl,
						data:sQuParams,
						success:function(retmsg){
							$("#" + pagequery.pageResultDivId,$currPgDiv).html(retmsg);
							upms.hideOverLay();// 关闭遮罩
						},
						error:function(retmsg){
							alert("网络连接错误，请稍候再试！");
							upms.hideOverLay();// 关闭遮罩
						}					
					});
				}
			}
		},
		setFormChkFlag:function(sQuFrmId,$currPgDiv){// 设置是否需要校验的标记
			$("#" + sQuFrmId,$currPgDiv).attr("oncheckflag","true");
		},
		getFormChkFlag:function(sQuFrmId,$currPgDiv){// 获取校验标记
			var sFrmChkFlag = $("#" + sQuFrmId,$currPgDiv).attr("oncheckflag");
			if (checkUtils.isEmptyStr(sFrmChkFlag)){
				return false;
			}else{
				if (sFrmChkFlag == "true"){
					return true;
				}else{
					return false;
				}
			}
		},
		clearErrInfo:function(sErrInfoId,$currPgDiv){// 清除错误信息
			$("#" + sErrInfoId,$currPgDiv).html("");
			$("#" + sErrInfoId,$currPgDiv).hide();
		},
		onFalse:function(sErrInfoId,sErrMsg,$currPgDiv){
			$("#" + sErrInfoId,$currPgDiv).html(sErrMsg);
			$("#" + sErrInfoId,$currPgDiv).show();
		},
		validateForQuery:function(obj,sErrInfoId,$currPgDiv){
			var sTargetId = obj.targetid,
				sTargetName = obj.targetname,
				sType = obj.type,
				fOncheck = obj.oncheck,
				sFalseDesc = obj.falsedesc;	
			switch (sType){
				case "text":
					var $obj = upms.transTo$obj(sTargetId,sTargetName,sType,$currPgDiv);
					if (!$.isEmptyObject($obj)){
						if (fOncheck($obj.val()) == true){// 校验通过
							return "pass";
						}else if (fOncheck($obj.val()) == false){// 校验不通过
							pagequery.onFalse(sErrInfoId, sFalseDesc,$currPgDiv);
							return "nopass";
						}
					}else{
						return "next";
					}
				break;
				default:
				break;
			}
		},
		quParamForStr:function(sQuFrmId,$currPgDiv){// 转化查询参数
			return $("#" + sQuFrmId,$currPgDiv).serialize();
		},
		initpaging:function(params){// 分页初始化
			var $currPgDiv = upms.getCurrPageDiv();
			if($currPgDiv.length==0){
				//$currPgDiv =  $("#resultDiv");
				$currPgDiv =  $("#mainContent");
			}			
			var iPageNo = parseInt($("#pageNo",$currPgDiv).val()),// 当前页
				iTotalPages = parseInt($("#totalPages",$currPgDiv).val()),// 总页数
				sQueryFormId = params.queryformid,// 
				sPgBtnId = params.pgbtnid,// 存放数字按钮元素的id值
				sUrl = params.url;// 分页查询的url

			var $pgBtn = $("#" + sPgBtnId,$currPgDiv);
			var htmlArr = new Array();
			
			// 当当前页数不在可使用页数范围
			if (iPageNo > iTotalPages){
				iPageNo = iTotalPages;
			}else if(iPageNo < 1){
				iPageNo = 1;
			}
			
			if (iTotalPages <= 6){// 总记录少于6页
				htmlArr = new Array();
				htmlArr.push('<a href="javascript: void(0);" id="firstPage">首页</a>');
				htmlArr.push('<a href="javascript: void(0);" id="prePage">上一页</a>');
				for (var i = 1;i <= iTotalPages;i++){
					if (iPageNo == i){
						htmlArr.push('<a href="javascript: void(0);" class="checked" id="pgnum' + i + '">' + i + '</a>');
					}else{
						htmlArr.push('<a href="javascript: void(0);" id="pgnum' + i + '">' + i + '</a>');
					}
				}
				htmlArr.push('<a href="javascript: void(0);" id="nextPage">下一页</a>');
				htmlArr.push('<a href="javascript: void(0);" id="endPage">末页</a>');
			}else {// 当总页数大于例如6页时候
				if (iPageNo==1 || iPageNo==2){
					htmlArr = new Array();
					htmlArr.push('<a href="javascript: void(0);" id="firstPage">首页</a>');
					htmlArr.push('<a href="javascript: void(0);" id="prePage">上一页</a>');
					for (var i = 1;i <= 3;i++){
						if (iPageNo == i){
							htmlArr.push('<a href="javascript: void(0);" class="checked" id="pgnum' + i + '">' + i + '</a>');
						}else{
							htmlArr.push('<a href="javascript: void(0);" id="pgnum' + i + '">' + i + '</a>');
						}
					}
					htmlArr.push('<a class="ellipsis">...</a>');
					for (var i = iTotalPages-2;i <= iTotalPages;i++){
						htmlArr.push('<a href="javascript: void(0);" id="pgnum' + i + '">' + i + '</a>');
					}
					
					htmlArr.push('<a href="javascript: void(0);" id="nextPage">下一页</a>');
					htmlArr.push('<a href="javascript: void(0);" id="endPage">末页</a>');
				}else if (iPageNo ==iTotalPages || iPageNo==(iTotalPages-1)){
					htmlArr.push('<a href="javascript: void(0);" id="firstPage">首页</a>');
					htmlArr.push('<a href="javascript: void(0);" id="prePage">上一页</a>');
					for (var i = 1;i <= 3;i++){
						htmlArr.push('<a href="javascript: void(0);" id="pgnum' + i + '">' + i + '</a>');
					}
					htmlArr.push('<a class="ellipsis">...</a>');
					for (var i = (iTotalPages - 2);i <= iTotalPages;i++){
						if (iPageNo == i){
							htmlArr.push('<a href="javascript: void(0);" class="checked" id="pgnum' + i + '">' + i + '</a>');
						}else{
							htmlArr.push('<a href="javascript: void(0);" id="pgnum' + i + '">' + i + '</a>');
						}
					}
					htmlArr.push('<a href="javascript: void(0);" id="nextPage">下一页</a>');
					htmlArr.push('<a href="javascript: void(0);" id="endPage">末页</a>');	
				}else{
					htmlArr.push('<a href="javascript: void(0);" id="firstPage">首页</a>');
					htmlArr.push('<a href="javascript: void(0);" id="prePage">上一页</a>');
					htmlArr.push('<a class="ellipsis">...</a>');
					if (iPageNo == 3 ) {
						for (var i = 2;i <= 6;i++){
							if (iPageNo == i){
								htmlArr.push('<a href="javascript: void(0);" class="checked" id="pgnum' + i + '">' + i + '</a>');
							}else{
								htmlArr.push('<a href="javascript: void(0);" id="pgnum' + i + '">' + i + '</a>');
							}
						}
					}
				    else if ((iPageNo+2) == iTotalPages) {
						for (var i = (iPageNo - 3);i <= (iPageNo + 1);i++){
							if (iPageNo == i){
								htmlArr.push('<a href="javascript: void(0);" class="checked" id="pgnum' + i + '">' + i + '</a>');
							}else{
								htmlArr.push('<a href="javascript: void(0);" id="pgnum' + i + '">' + i + '</a>');
							}
						}


					} else {
						for (var i = (iPageNo - 2);i <= (iPageNo + 2);i++){
							if (iPageNo == i){
								htmlArr.push('<a href="javascript: void(0);" class="checked" id="pgnum' + i + '">' + i + '</a>');
							}else{
								htmlArr.push('<a href="javascript: void(0);" id="pgnum' + i + '">' + i + '</a>');
							}
						}
					}

					htmlArr.push('<a class="ellipsis">...</a>');
					htmlArr.push('<a href="javascript: void(0);" id="nextPage">下一页</a>');
					htmlArr.push('<a href="javascript: void(0);" id="endPage">末页</a>');	
				}
			}
			if (htmlArr.length > 0){
				$pgBtn.append(htmlArr.join(""));
				pagequery.pagingEvt(params,$currPgDiv);
			}				
					
		},
		pagingEvt:function(params,$currPgDiv){// 分页的点击事件
			var sQueryFormId = params.queryformid,// 查询条件的formid
				sResDivId = params.resultdivid,// 查询结果div的id值
				sUrl = params.url;// 分页查询的url
			
			if (checkUtils.isEmptyStr(sResDivId)){
				sResDivId = pagequery.pageResultDivId;
			}
			
			$("a[id^='pgnum']",$currPgDiv).each(function(ind,elem){// 数字按钮点击事件
				$(elem).bind("click",function(){
					upmsTipManage.clearUpmsTipObj();// 清空历史提示信息
					var chkFlag = true;// 校验标记
					if (pagequery.getFormChkFlag(sQueryFormId, $currPgDiv) && $.isArray(pagequery.cacheValidateArr)){
						pagequery.clearErrInfo(pagequery.cacheErrInfoId, $currPgDiv);
						var arrValidate = pagequery.cacheValidateArr;
						for (var i = 0;i < arrValidate.length;i++){
							var obj = arrValidate[i];
							var retVal = pagequery.validateForQuery(obj, pagequery.cacheErrInfoId,$currPgDiv);
							if ("nopass" == retVal){
								chkFlag = false;
								break;
							}
						}
					}	
					if (chkFlag){
						upms.showOverLay();// 开启遮罩
						var pgNumID = $(elem).attr("id"),
							pgUrl = $.trim(sUrl);
						var pageNo = parseInt(pgNumID.substring("pgnum".length,pgNumID.length)),
							totalPages = parseInt($.trim($('#totalPages',$currPgDiv).val()));
						var pgAjaxStr = pagequery.quParamForStr(sQueryFormId,$currPgDiv);
						if (checkUtils.isEmptyStr(pgAjaxStr)){
							pgAjaxStr = "pageNo=" + pageNo;
						}else{
							pgAjaxStr += "&pageNo=" + pageNo;
						}
						$.ajax({
							type:"post",
							url:pgUrl,
							data:pgAjaxStr,
							success:function(retmsg){
								$("#" + sResDivId,$currPgDiv).html(retmsg);
								upms.hideOverLay();// 关闭遮罩
							},
							error:function(retmsg){
								alert("网络连接错误，请稍候再试！");
								upms.hideOverLay();// 关闭遮罩
							}						
						});						
					}
				});
			});
			
			$("#goBtn",$currPgDiv).bind("click",function(){// 分页的确定按钮
				upmsTipManage.clearUpmsTipObj();// 清空历史提示信息
				var chkFlag = true;// 校验标记
				if (pagequery.getFormChkFlag(sQueryFormId, $currPgDiv) && $.isArray(pagequery.cacheValidateArr)){
					pagequery.clearErrInfo(pagequery.cacheErrInfoId, $currPgDiv);
					var arrValidate = pagequery.cacheValidateArr;
					for (var i = 0;i < arrValidate.length;i++){
						var obj = arrValidate[i];
						var retVal = pagequery.validateForQuery(obj, pagequery.cacheErrInfoId,$currPgDiv);
						if ("nopass" == retVal){
							chkFlag = false;
							break;
						}
					}
				}	
				if (chkFlag){
					upms.showOverLay();// 开启遮罩
					var iptPageNo = isNaN(parseInt($("#goPageNo",$currPgDiv).val()))?1:parseInt($("#goPageNo",$currPgDiv).val()),
						pageNo = parseInt($.trim($("#pageNo",$currPgDiv).val())),
						totalPages = parseInt($.trim($('#totalPages',$currPgDiv).val())),
						pgUrl = $.trim(sUrl);
					if (iptPageNo < 1){
						pageNo = 1;
					}else if (iptPageNo > totalPages){
						pageNo = totalPages;
					}else{
						pageNo = iptPageNo;
					}
					var pgAjaxStr = pagequery.quParamForStr(sQueryFormId,$currPgDiv);
					if (checkUtils.isEmptyStr(pgAjaxStr)){
						pgAjaxStr = "pageNo=" + pageNo;
					}else{
						pgAjaxStr += "&pageNo=" + pageNo;
					}
					$.ajax({
						type:"post",
						url:pgUrl,
						data:pgAjaxStr,
						success:function(retmsg){
							$("#" + sResDivId,$currPgDiv).html(retmsg);
							upms.hideOverLay();// 关闭遮罩
						},
						error:function(retmsg){
							alert("网络连接错误，请稍候再试！");
							upms.hideOverLay();// 关闭遮罩
						}						
					});					
				}
			});
			
			$("#firstPage",$currPgDiv).bind("click",function(){// 首页
				upmsTipManage.clearUpmsTipObj();// 清空历史提示信息
				var chkFlag = true;// 校验标记
				if (pagequery.getFormChkFlag(sQueryFormId, $currPgDiv) && $.isArray(pagequery.cacheValidateArr)){
					pagequery.clearErrInfo(pagequery.cacheErrInfoId, $currPgDiv);
					var arrValidate = pagequery.cacheValidateArr;
					for (var i = 0;i < arrValidate.length;i++){
						var obj = arrValidate[i];
						var retVal = pagequery.validateForQuery(obj, pagequery.cacheErrInfoId,$currPgDiv);
						if ("nopass" == retVal){
							chkFlag = false;
							break;
						}
					}
				}	
				if (chkFlag){
					upms.showOverLay();// 开启遮罩
					var pgUrl = $.trim(sUrl),
						pageNo = parseInt(1),
						totalPages = parseInt($.trim($('#totalPages',$currPgDiv).val()));
					var pgAjaxStr = pagequery.quParamForStr(sQueryFormId,$currPgDiv);
					if (checkUtils.isEmptyStr(pgAjaxStr)){
						pgAjaxStr = "pageNo=" + pageNo;
					}else{
						pgAjaxStr += "&pageNo=" + pageNo;
					}
					$.ajax({
						type:"post",
						url:pgUrl,
						data:pgAjaxStr,
						success:function(retmsg){
							$("#" + sResDivId,$currPgDiv).html(retmsg);
							upms.hideOverLay();// 关闭遮罩
						},
						error:function(retmsg){
							alert("网络连接错误，请稍候再试！");
							upms.hideOverLay();// 关闭遮罩
						}						
					});					
				}
			});
			
			$("#prePage",$currPgDiv).bind("click",function(){// 上一页
				upmsTipManage.clearUpmsTipObj();// 清空历史提示信息
				var chkFlag = true;// 校验标记
				if (pagequery.getFormChkFlag(sQueryFormId, $currPgDiv) && $.isArray(pagequery.cacheValidateArr)){
					pagequery.clearErrInfo(pagequery.cacheErrInfoId, $currPgDiv);
					var arrValidate = pagequery.cacheValidateArr;
					for (var i = 0;i < arrValidate.length;i++){
						var obj = arrValidate[i];
						var retVal = pagequery.validateForQuery(obj, pagequery.cacheErrInfoId,$currPgDiv);
						if ("nopass" == retVal){
							chkFlag = false;
							break;
						}
					}
				}	
				if (chkFlag){
					upms.showOverLay();// 开启遮罩
					var pgUrl = $.trim(sUrl),
						pageNo = parseInt($.trim($("#pageNo",$currPgDiv).val())),
						totalPages = parseInt($.trim($('#totalPages',$currPgDiv).val()));
					if (pageNo > 1){
						pageNo = pageNo - 1;
					}else{
						pageNo = 1;
					}
					var pgAjaxStr = pagequery.quParamForStr(sQueryFormId,$currPgDiv);
					if (checkUtils.isEmptyStr(pgAjaxStr)){
						pgAjaxStr = "pageNo=" + pageNo;
					}else{
						pgAjaxStr += "&pageNo=" + pageNo;
					}
					$.ajax({
						type:"post",
						url:pgUrl,
						data:pgAjaxStr,
						success:function(retmsg){
							$("#" + sResDivId,$currPgDiv).html(retmsg);
							upms.hideOverLay();// 关闭遮罩
						},
						error:function(retmsg){
							alert("网络连接错误，请稍候再试！");
							upms.hideOverLay();// 关闭遮罩
						}						
					});					
				}
			});
			
			$("#nextPage",$currPgDiv).bind("click",function(){// 下一页
				upmsTipManage.clearUpmsTipObj();// 清空历史提示信息
				var chkFlag = true;// 校验标记
				if (pagequery.getFormChkFlag(sQueryFormId, $currPgDiv) && $.isArray(pagequery.cacheValidateArr)){
					pagequery.clearErrInfo(pagequery.cacheErrInfoId, $currPgDiv);
					var arrValidate = pagequery.cacheValidateArr;
					for (var i = 0;i < arrValidate.length;i++){
						var obj = arrValidate[i];
						var retVal = pagequery.validateForQuery(obj, pagequery.cacheErrInfoId,$currPgDiv);
						if ("nopass" == retVal){
							chkFlag = false;
							break;
						}
					}
				}	
				if (chkFlag){
					upms.showOverLay();// 开启遮罩
					var pgUrl = $.trim(sUrl),
						pageNo = parseInt($.trim($("#pageNo",$currPgDiv).val())),
						totalPages = parseInt($.trim($('#totalPages',$currPgDiv).val()));
					if (pageNo < totalPages){
						pageNo = pageNo + 1;
					}else{
						pageNo = totalPages;
					}
					var pgAjaxStr = pagequery.quParamForStr(sQueryFormId,$currPgDiv);
					if (checkUtils.isEmptyStr(pgAjaxStr)){
						pgAjaxStr = "pageNo=" + pageNo;
					}else{
						pgAjaxStr += "&pageNo=" + pageNo;
					}
					$.ajax({
						type:"post",
						url:pgUrl,
						data:pgAjaxStr,
						success:function(retmsg){
							$("#" + sResDivId,$currPgDiv).html(retmsg);
							upms.hideOverLay();// 关闭遮罩
						},
						error:function(retmsg){
							alert("网络连接错误，请稍候再试！");
							upms.hideOverLay();// 关闭遮罩
						}						
					});					
				}
			});
			$("#endPage",$currPgDiv).bind("click",function(){// 末页
				upmsTipManage.clearUpmsTipObj();// 清空历史提示信息
				var chkFlag = true;// 校验标记
				if (pagequery.getFormChkFlag(sQueryFormId, $currPgDiv) && $.isArray(pagequery.cacheValidateArr)){
					pagequery.clearErrInfo(pagequery.cacheErrInfoId, $currPgDiv);
					var arrValidate = pagequery.cacheValidateArr;
					for (var i = 0;i < arrValidate.length;i++){
						var obj = arrValidate[i];
						var retVal = pagequery.validateForQuery(obj, pagequery.cacheErrInfoId,$currPgDiv);
						if ("nopass" == retVal){
							chkFlag = false;
							break;
						}
					}
				}	
				if (chkFlag){
					upms.showOverLay();// 开启遮罩
					var pageNo = parseInt($.trim($('#pageNo',$currPgDiv).val())),
						pgUrl = $.trim(sUrl),
						totalPages = parseInt($.trim($('#totalPages',$currPgDiv).val()));
					if (pageNo != totalPages){
						pageNo = totalPages;
					}
					var pgAjaxStr = pagequery.quParamForStr(sQueryFormId,$currPgDiv);
					if (checkUtils.isEmptyStr(pgAjaxStr)){
						pgAjaxStr = "pageNo=" + pageNo;
					}else{
						pgAjaxStr += "&pageNo=" + pageNo;
					}
					$.ajax({
						type:"post",
						url:pgUrl,
						data:pgAjaxStr,
						success:function(retmsg){
							$("#" + sResDivId,$currPgDiv).html(retmsg);
							upms.hideOverLay();// 关闭遮罩
						},
						error:function(retmsg){
							alert("网络连接错误，请稍候再试！");
							upms.hideOverLay();// 关闭遮罩
						}						
					});					
				}
			});
		}
	};
	// 查询列表的dialog操作
	var griddialog = {
		dialogId:"_grid_dialog_modal_",
		selfexecute:function(params){
			// to do ....
		},
		execute:function(params){
			var sUrl = params.url,// 请求的url
				sBtnName = $.trim(params.btnname),
				sDialogTitle = params.dialogtitle,// 对话框的标题
				sErrInfoId = params.errinfoid,
				sErrInfoTip = params.errinfotip,
				sSuccInfoId = params.succinfoid,
				sCheckSms = params.checksms,// 是否需要短信验证 open为需要 默认是close
				sSmsTip = params.smstip,// 短信验证提示语言
				sSuccInfoTip = params.succinfotip,				
				sDialogTip = params.dialogtip;// 对话框的显示内容
			var $currPgDiv = upms.getCurrPageDiv();
			if (checkUtils.isEmptyStr(sDialogTip)){
				sDailogTip = "你确定要操作吗?";
			}
			if (checkUtils.isEmptyStr(sDialogTitle)){
				sDialogTitle = "信息提示";
			}
			if (checkUtils.isEmptyStr(sSmsTip)){
				sSmsTip = "短信验证不通过!";
			}
			if (sCheckSms != "open"){
				sCheckSms = "close";
			}			
			var tipArrs = new Array();
			if (checkUtils.isNotEmptyStr(sErrInfoId)){
				tipArrs.push(sErrInfoId);
			}
			if (checkUtils.isNotEmptyStr(sSuccInfoId)){
				tipArrs.push(sSuccInfoId);
			}
			upmsTipManage.saveUpmsTipObj(tipArrs);
			
			$("a[name='" + sBtnName + "']",$currPgDiv).each(function(ind,elem){
				$(elem).bind("click",function(){
					var innerFlag = true;
					if (sCheckSms == "open"){
						if (sms.getSmsCheckFlag() == false){
							innerFlag = false;
							griddialog.createDialogForId(griddialog.dialogId + "sms", sDialogTitle, sSmsTip, $currPgDiv);
							$("#" + griddialog.dialogId + "sms",$currPgDiv).dialog({
					 			autoOpen: true,
								modal: true,
								dialogClass:"dialogfont",
								buttons: {
									"确定":function(){
										$(this).dialog("close");
									}
								}						
							});
						}
					}
					if (innerFlag){

						if (checkUtils.isNotEmptyStr(sErrInfoId)){
							griddialog.clearErrInfo(sErrInfoId, $currPgDiv);
						}
						if (checkUtils.isNotEmptyStr(sSuccInfoId)){
							griddialog.clearErrInfo(sSuccInfoId, $currPgDiv);
						}
						griddialog.createDialog(sDialogTitle, sDialogTip, $currPgDiv);
						$("#" + griddialog.dialogId,$currPgDiv).dialog({
				 			autoOpen: true,
							modal: true,
							dialogClass:"dialogfont",
							buttons: {
								"确定":function(){
									upms.showOverLay();// 打开遮罩
									var parentObj = $(elem).parent(),
										selKeys = $.trim($(elem).attr("sendparam")).split(",");
									var data = {};// 传到服务端的参数
									for (var i = 0;i < selKeys.length;i++){
										var tmpDataObj = {};
										tmpDataObj[selKeys[i]] = $("input[name='" + selKeys[i] + "']",parentObj).val();
										$.extend(data,tmpDataObj);
									}
									$.ajax({
										type:"post",
										url:sUrl,
										data:data,
										success:function(retmsg){
											if (checkUtils.isNotNull(retmsg)){
												if (retmsg.jsonFlag){// 成功
													pagequery.callbackQuery($currPgDiv);
													if (checkUtils.isNotEmptyStr(sSuccInfoId)){
														if (checkUtils.isEmptyStr(sSuccInfoTip)){
															sSuccInfoTip = "操作成功";
														}
														if (checkUtils.isNotEmptyStr(retmsg.jsonMsg)){
															griddialog.onFalse(sSuccInfoId, retmsg.jsonMsg, $currPgDiv);
														}else{
															griddialog.onFalse(sSuccInfoId, sSuccInfoTip, $currPgDiv);
														}
													}
												}else{// 失败
													if (checkUtils.isEmptyStr(sErrInfoTip)){
														sErrInfoTip = "操作失败";
													}
													
													if (checkUtils.isEmptyStr(sErrInfoId)){
														if (checkUtils.isNotEmptyStr(retmsg.jsonMsg)){
															alert(retmsg.jsonMsg);
														}else{
															alert(sErrInfoTip);
														}
													}else{
														if (checkUtils.isNotEmptyStr(retmsg.jsonMsg)){
															griddialog.onFalse(sErrInfoId, retmsg.jsonMsg, $currPgDiv);
														}else{;
															griddialog.onFalse(sErrInfoId, sErrInfoTip, $currPgDiv);
														}
													}
												}
											}
											upms.hideOverLay();// 关闭遮罩
										},
										error:function(retmsg){
											alert(retmsg);
											upms.hideOverLay();// 关闭遮罩
										}
									});
									$(this).dialog("close");
								},
								"取消":function(){
									$(this).dialog("close");
								}
							}						
						});
					
					}
				});
			});
		},
		createDialogForId:function(createDialogId,sTitle,sInfoTip,$currPgDiv){
			var arrHtml = new Array();
			arrHtml.push("<div id='" + createDialogId + "' title='" + sTitle + "' style='display:none'>");
			arrHtml.push("<center><p class='dialogTip'>" + sInfoTip + "</p></center>");
			arrHtml.push("</div>");
			$currPgDiv.append(arrHtml.join(""));
		},
		createDialog:function(sTitle,sInfoTip,$currPgDiv){
			var arrHtml = new Array();
			arrHtml.push("<div id='" + griddialog.dialogId + "' title='" + sTitle + "' style='display:none'>");
			arrHtml.push("<center><p class='dialogTip'>" + sInfoTip + "</p></center>");
			arrHtml.push("</div>");
			$currPgDiv.append(arrHtml.join(""));
		},
		clearErrInfo:function(sErrInfoId,$currPgDiv){// 清除错误信息
			$("#" + sErrInfoId,$currPgDiv).html("");
			$("#" + sErrInfoId,$currPgDiv).hide();
		},
		onFalse:function(sErrInfoId,sErrMsg,$currPgDiv){
			$("#" + sErrInfoId,$currPgDiv).html(sErrMsg);
			$("#" + sErrInfoId,$currPgDiv).show();
		}
	};
	// 提示信息统一管理对象
	var upmsTipManage = {
		tipObjArr:[],
		currPgDivId:"",
		saveUpmsTipObj:function(arrParams){
			if ($.isArray(arrParams)){
				upmsTipManage.tipObjArr = arrParams;
				var $currPgDiv = upms.getCurrPageDiv();
				upmsTipManage.currPgDivId = $.trim($currPgDiv.attr("id"));
			}
		},
		clearUpmsTipObj:function(){
			if ($.isArray(upmsTipManage.tipObjArr) && upmsTipManage.tipObjArr.length > 0 && checkUtils.isNotEmptyStr(upmsTipManage.currPgDivId)){
				for (var i = 0,len = upmsTipManage.tipObjArr.length;i < len;i++){
					var $currPgObj = $("#" + upmsTipManage.currPgDivId),
						sArrElem = upmsTipManage.tipObjArr[i];
					$("#" + sArrElem,$currPgObj).html("");
					$("#" + sArrElem,$currPgObj).hide();
				}
			}
		}
	};
	// 按钮操作
	var handlebtn = {
		dialogId:"_hb_forward_dialog_modal_",
		upfileDialogId:"_hb_upfile_dialog_modal_",
		downfileDialogId:"_hb_downfile_dialog_modal_",
		btnForUpFileParams:{},
		downfile:function(params){// 文件下载
			var sBtnId = params.btnid,// 按钮的id值
				oValidate = params.validate,// 传入校验参数
				sFormId = params.formid,// 请求的form
				oAjaxCheck = params.ajaxcheck,// ajax校验
				sDownUrl = params.downurl;
			var $currPgDiv = upms.getCurrPageDiv();
			var chkFlag = false,sChkModel = "";
			if ($.isPlainObject(oValidate) && !$.isEmptyObject(oValidate)){
				sChkModel = oValidate.model;
				if (checkUtils.isNotEmptyStr(sChkModel)){
					chkFlag = true;
				}
			}
			if (chkFlag){// 需要校验操作
				switch (sChkModel){
					case "formsevent":
						handlebtn.saveCheckFlag(true, $currPgDiv);
						handlebtn.validateBtn(oValidate, $currPgDiv);
						$("#" + sBtnId,$currPgDiv).bind("click",function(){
							handlebtn.allValidate(oValidate, $currPgDiv);
							if (handlebtn.getCheckFlag($currPgDiv) == true){
								
								if (checkUtils.isNotNull(oAjaxCheck) && !$.isEmptyObject(oAjaxCheck)){
									var sUrl = oAjaxCheck.url,// 校验的url
										sReqType = oAjaxCheck.reqtype,// 请求方式 例如 get  post
										sDialogTitle = oAjaxCheck.dialogtitle,// 对话框的标题
										sDialogTip = oAjaxCheck.dialogtip;// 对话框提示信息
									if (checkUtils.isEmptyStr(sReqType)){
										sReqType = "post";
									}
									if (checkUtils.isEmptyStr(sDialogTitle)){
										sDialogTitle = "信息提示";
									}
									if (checkUtils.isEmptyStr(sDialogTip)){
										sDialogTip = "文件下载失败!";
									}
									$.ajax({
										type:sReqType,
										url:sUrl,
										data:$("#" + sFormId).serialize(),
										success: function(msg){
											if (checkUtils.isNotNull(msg)){
												if (msg.jsonFlag == true){
													var sReqData = "";
													if (checkUtils.isNotEmptyStr(sFormId)){
														sReqData = $("#" + sFormId).serialize();
													}
													if (checkUtils.isNotEmptyStr(sReqData)){
														window.location.href = sDownUrl + "?" + sReqData;
													}else{
														window.location.href = sDownUrl;
													}													
												}else{
													if (checkUtils.isNotEmptyStr(msg.jsonMsg)){
														sDialogTip = msg.jsonMsg;
													}
													handlebtn.createDialog(handlebtn.downfileDialogId + sBtnId + "err", sDialogTitle, sDialogTip, $currPgDiv,"error");
													$("#" + handlebtn.downfileDialogId + sBtnId + "err",$currPgDiv).dialog({
											 			autoOpen: true,
														modal: true,
														dialogClass:"dialogfont",
														buttons: {
															"确定":function(){
																$(this).dialog("close");
															}
														}
													});
												}
											}else{
												handlebtn.createDialog(handlebtn.downfileDialogId + sBtnId + "err", sDialogTitle, sDialogTip, $currPgDiv,"error");
												$("#" + handlebtn.downfileDialogId + sBtnId + "err",$currPgDiv).dialog({
										 			autoOpen: true,
													modal: true,
													dialogClass:"dialogfont",
													buttons: {
														"确定":function(){
															$(this).dialog("close");
														}
													}
												});
											}
										},
										error:function(msg){
											handlebtn.createDialog(handlebtn.downfileDialogId + sBtnId + "err", sDialogTitle, sDialogTip, $currPgDiv,"error");
											$("#" + handlebtn.downfileDialogId + sBtnId + "err",$currPgDiv).dialog({
									 			autoOpen: true,
												modal: true,
												dialogClass:"dialogfont",
												buttons: {
													"确定":function(){
														$(this).dialog("close");
													}
												}
											});
										}
									});
								}else{
									var sReqData = "";
									if (checkUtils.isNotEmptyStr(sFormId)){
										sReqData = $("#" + sFormId).serialize();
									}
									if (checkUtils.isNotEmptyStr(sReqData)){
										window.location.href = sDownUrl + "?" + sReqData;
									}else{
										window.location.href = sDownUrl;
									}
								}
							}
						});						
						break;
					case "batch":
						handlebtn.saveCheckFlag(true, $currPgDiv);
						$("#" + sBtnId,$currPgDiv).bind("click",function(){
							handlebtn.batchValidate(oValidate, $currPgDiv);
							if (handlebtn.getCheckFlag($currPgDiv) == true){
								
								if (checkUtils.isNotNull(oAjaxCheck) && !$.isEmptyObject(oAjaxCheck)){
									var sUrl = oAjaxCheck.url,// 校验的url
										sReqType = oAjaxCheck.reqtype,// 请求方式 例如 get  post
										sDialogTitle = oAjaxCheck.dialogtitle,// 对话框的标题
										sDialogTip = oAjaxCheck.dialogtip;// 对话框提示信息
									if (checkUtils.isEmptyStr(sReqType)){
										sReqType = "post";
									}
									if (checkUtils.isEmptyStr(sDialogTitle)){
										sDialogTitle = "信息提示";
									}
									if (checkUtils.isEmptyStr(sDialogTip)){
										sDialogTip = "文件下载失败!";
									}
									$.ajax({
										type:sReqType,
										url:sUrl,
										data:$("#" + sFormId).serialize(),
										success: function(msg){
											if (checkUtils.isNotNull(msg)){
												if (msg.jsonFlag == true){
													var sReqData = "";
													if (checkUtils.isNotEmptyStr(sFormId)){
														sReqData = $("#" + sFormId).serialize();
													}
													if (checkUtils.isNotEmptyStr(sReqData)){
														window.location.href = sDownUrl + "?" + sReqData;
													}else{
														window.location.href = sDownUrl;
													}													
												}else{
													if (checkUtils.isNotEmptyStr(msg.jsonMsg)){
														sDialogTip = msg.jsonMsg;
													}
													handlebtn.createDialog(handlebtn.downfileDialogId + sBtnId + "err", sDialogTitle, sDialogTip, $currPgDiv,"error");
													$("#" + handlebtn.downfileDialogId + sBtnId + "err",$currPgDiv).dialog({
											 			autoOpen: true,
														modal: true,
														dialogClass:"dialogfont",
														buttons: {
															"确定":function(){
																$(this).dialog("close");
															}
														}
													});
												}
											}else{
												handlebtn.createDialog(handlebtn.downfileDialogId + sBtnId + "err", sDialogTitle, sDialogTip, $currPgDiv,"error");
												$("#" + handlebtn.downfileDialogId + sBtnId + "err",$currPgDiv).dialog({
										 			autoOpen: true,
													modal: true,
													dialogClass:"dialogfont",
													buttons: {
														"确定":function(){
															$(this).dialog("close");
														}
													}
												});
											}
										},
										error:function(msg){
											handlebtn.createDialog(handlebtn.downfileDialogId + sBtnId + "err", sDialogTitle, sDialogTip, $currPgDiv,"error");
											$("#" + handlebtn.downfileDialogId + sBtnId + "err",$currPgDiv).dialog({
									 			autoOpen: true,
												modal: true,
												dialogClass:"dialogfont",
												buttons: {
													"确定":function(){
														$(this).dialog("close");
													}
												}
											});
										}
									});
								}else{
									var sReqData = "";
									if (checkUtils.isNotEmptyStr(sFormId)){
										sReqData = $("#" + sFormId).serialize();
									}
									if (checkUtils.isNotEmptyStr(sReqData)){
										window.location.href = sDownUrl + "?" + sReqData;
									}else{
										window.location.href = sDownUrl;
									}
								}
							}						
						});							
						break;
					case "single":
						handlebtn.saveCheckFlag(true, $currPgDiv);
						$("#" + sBtnId,$currPgDiv).bind("click",function(){
							handlebtn.singleValidate(oValidate, $currPgDiv);
							if (handlebtn.getCheckFlag($currPgDiv) == true){
								
								if (checkUtils.isNotNull(oAjaxCheck) && !$.isEmptyObject(oAjaxCheck)){
									var sUrl = oAjaxCheck.url,// 校验的url
										sReqType = oAjaxCheck.reqtype,// 请求方式 例如 get  post
										sDialogTitle = oAjaxCheck.dialogtitle,// 对话框的标题
										sDialogTip = oAjaxCheck.dialogtip;// 对话框提示信息
									if (checkUtils.isEmptyStr(sReqType)){
										sReqType = "post";
									}
									if (checkUtils.isEmptyStr(sDialogTitle)){
										sDialogTitle = "信息提示";
									}
									if (checkUtils.isEmptyStr(sDialogTip)){
										sDialogTip = "文件下载失败!";
									}
									$.ajax({
										type:sReqType,
										url:sUrl,
										data:$("#" + sFormId).serialize(),
										success: function(msg){
											if (checkUtils.isNotNull(msg)){
												if (msg.jsonFlag == true){
													var sReqData = "";
													if (checkUtils.isNotEmptyStr(sFormId)){
														sReqData = $("#" + sFormId).serialize();
													}
													if (checkUtils.isNotEmptyStr(sReqData)){
														window.location.href = sDownUrl + "?" + sReqData;
													}else{
														window.location.href = sDownUrl;
													}													
												}else{
													if (checkUtils.isNotEmptyStr(msg.jsonMsg)){
														sDialogTip = msg.jsonMsg;
													}
													handlebtn.createDialog(handlebtn.downfileDialogId + sBtnId + "err", sDialogTitle, sDialogTip, $currPgDiv,"error");
													$("#" + handlebtn.downfileDialogId + sBtnId + "err",$currPgDiv).dialog({
											 			autoOpen: true,
														modal: true,
														dialogClass:"dialogfont",
														buttons: {
															"确定":function(){
																$(this).dialog("close");
															}
														}
													});
												}
											}else{
												handlebtn.createDialog(handlebtn.downfileDialogId + sBtnId + "err", sDialogTitle, sDialogTip, $currPgDiv,"error");
												$("#" + handlebtn.downfileDialogId + sBtnId + "err",$currPgDiv).dialog({
										 			autoOpen: true,
													modal: true,
													dialogClass:"dialogfont",
													buttons: {
														"确定":function(){
															$(this).dialog("close");
														}
													}
												});
											}
										},
										error:function(msg){
											handlebtn.createDialog(handlebtn.downfileDialogId + sBtnId + "err", sDialogTitle, sDialogTip, $currPgDiv,"error");
											$("#" + handlebtn.downfileDialogId + sBtnId + "err",$currPgDiv).dialog({
									 			autoOpen: true,
												modal: true,
												dialogClass:"dialogfont",
												buttons: {
													"确定":function(){
														$(this).dialog("close");
													}
												}
											});
										}
									});
								}else{
									var sReqData = "";
									if (checkUtils.isNotEmptyStr(sFormId)){
										sReqData = $("#" + sFormId).serialize();
									}
									if (checkUtils.isNotEmptyStr(sReqData)){
										window.location.href = sDownUrl + "?" + sReqData;
									}else{
										window.location.href = sDownUrl;
									}
								}
							}						
						});							
						break;
					default:
					break;				
				}
			}else{// 不需要校验的操作
				$("#" + sBtnId,$currPgDiv).bind("click",function(){
					
					if (checkUtils.isNotNull(oAjaxCheck) && !$.isEmptyObject(oAjaxCheck)){
						var sUrl = oAjaxCheck.url,// 校验的url
							sReqType = oAjaxCheck.reqtype,// 请求方式 例如 get  post
							sDialogTitle = oAjaxCheck.dialogtitle,// 对话框的标题
							sDialogTip = oAjaxCheck.dialogtip;// 对话框提示信息
						if (checkUtils.isEmptyStr(sReqType)){
							sReqType = "post";
						}
						if (checkUtils.isEmptyStr(sDialogTitle)){
							sDialogTitle = "信息提示";
						}
						if (checkUtils.isEmptyStr(sDialogTip)){
							sDialogTip = "文件下载失败!";
						}
						$.ajax({
							type:sReqType,
							url:sUrl,
							data:$("#" + sFormId).serialize(),
							success: function(msg){
								if (checkUtils.isNotNull(msg)){
									if (msg.jsonFlag == true){
										var sReqData = "";
										if (checkUtils.isNotEmptyStr(sFormId)){
											sReqData = $("#" + sFormId).serialize();
										}
										if (checkUtils.isNotEmptyStr(sReqData)){
											window.location.href = sDownUrl + "?" + sReqData;
										}else{
											window.location.href = sDownUrl;
										}													
									}else{
										if (checkUtils.isNotEmptyStr(msg.jsonMsg)){
											sDialogTip = msg.jsonMsg;
										}
										handlebtn.createDialog(handlebtn.downfileDialogId + sBtnId + "err", sDialogTitle, sDialogTip, $currPgDiv,"error");
										$("#" + handlebtn.downfileDialogId + sBtnId + "err",$currPgDiv).dialog({
								 			autoOpen: true,
											modal: true,
											dialogClass:"dialogfont",
											buttons: {
												"确定":function(){
													$(this).dialog("close");
												}
											}
										});
									}
								}else{
									handlebtn.createDialog(handlebtn.downfileDialogId + sBtnId + "err", sDialogTitle, sDialogTip, $currPgDiv,"error");
									$("#" + handlebtn.downfileDialogId + sBtnId + "err",$currPgDiv).dialog({
							 			autoOpen: true,
										modal: true,
										dialogClass:"dialogfont",
										buttons: {
											"确定":function(){
												$(this).dialog("close");
											}
										}
									});
								}
							},
							error:function(msg){
								handlebtn.createDialog(handlebtn.downfileDialogId + sBtnId + "err", sDialogTitle, sDialogTip, $currPgDiv,"error");
								$("#" + handlebtn.downfileDialogId + sBtnId + "err",$currPgDiv).dialog({
						 			autoOpen: true,
									modal: true,
									dialogClass:"dialogfont",
									buttons: {
										"确定":function(){
											$(this).dialog("close");
										}
									}
								});
							}
						});
					}else{
						var sReqData = "";
						if (checkUtils.isNotEmptyStr(sFormId)){
							sReqData = $("#" + sFormId).serialize();
						}
						if (checkUtils.isNotEmptyStr(sReqData)){
							window.location.href = sDownUrl + "?" + sReqData;
						}else{
							window.location.href = sDownUrl;
						}
					}
				});
			}
		},
		uploadfile:function(params){// 文件上传操作
			var sBtnId = params.btnid,// 按钮的id值
				oValidate = params.validate,// 传入参数
				oUploadFile = params.uploadfile;// 文件上传操作对象
			handlebtn.btnForUpFileParams = oUploadFile;// 缓存参数
			$.extend(handlebtn.btnForUpFileParams,{"btnId":sBtnId});
			var $currPgDiv = upms.getCurrPageDiv();
			var chkFlag = false,sChkModel = "";
			if ($.isPlainObject(oValidate) && !$.isEmptyObject(oValidate)){
				sChkModel = oValidate.model;
				if (checkUtils.isNotEmptyStr(sChkModel)){
					chkFlag = true;
				}
			}
			if (chkFlag){// 需要校验操作
				switch (sChkModel){
					case "formsevent":
						handlebtn.saveCheckFlag(true, $currPgDiv);
						handlebtn.validateBtn(oValidate, $currPgDiv);
						$("#" + sBtnId,$currPgDiv).bind("click",function(){
							handlebtn.allValidate(oValidate, $currPgDiv);
							if (handlebtn.getCheckFlag($currPgDiv) == true){
								upms.showOverLay();// 开启遮罩
								var sReqUrl = oUploadFile.requrl,// 请求的url
									arrFormElems = oUploadFile.formElems,
									sDataType = oUploadFile.datatype;
								ajaxUploadFile.execute({
									url:sReqUrl,
									formElems:arrFormElems,
									datatype:sDataType,
									success:handlebtn.upfileSuccess,
									error:handlebtn.upfileError
								});
							}
						});
					break;
					case "batch":
						handlebtn.saveCheckFlag(true, $currPgDiv);
						$("#" + sBtnId,$currPgDiv).bind("click",function(){
							handlebtn.batchValidate(oValidate, $currPgDiv);
							if (handlebtn.getCheckFlag($currPgDiv) == true){
								upms.showOverLay();// 开启遮罩
								var sReqUrl = oUploadFile.requrl,// 请求的url
									arrFormElems = oUploadFile.formElems,
									sDataType = oUploadFile.datatype;
								ajaxUploadFile.execute({
									url:sReqUrl,
									formElems:arrFormElems,
									datatype:sDataType,
									success:handlebtn.upfileSuccess,
									error:handlebtn.upfileError
								});
							}						
						});						
					break;
					case "single":
						handlebtn.saveCheckFlag(true, $currPgDiv);
						$.extend(handlebtn.btnForUpFileParams,{"chkType":"single"});
						$.extend(handlebtn.btnForUpFileParams,{"chkErrInfoId":oValidate.errinfoid});
						$("#" + sBtnId,$currPgDiv).bind("click",function(){
							handlebtn.singleValidate(oValidate, $currPgDiv);
							if (handlebtn.getCheckFlag($currPgDiv) == true){
								upms.showOverLay();// 开启遮罩
								var sReqUrl = oUploadFile.requrl,// 请求的url
									arrFormElems = oUploadFile.formElems,
									sDataType = oUploadFile.datatype;
								ajaxUploadFile.execute({
									url:sReqUrl,
									formElems:arrFormElems,
									datatype:sDataType,
									success:handlebtn.upfileSuccess,
									error:handlebtn.upfileError
								});
							}						
						});						
					break;
					default:
						
					break;
				}
			}else{// 不需要校验操作
				$("#" + sBtnId,$currPgDiv).bind("click",function(){
					var sReqUrl = oUploadFile.requrl,// 请求的url
						arrFormElems = oUploadFile.formElems,
						sDataType = oUploadFile.datatype;
					ajaxUploadFile.execute({
						url:sReqUrl,
						formElems:arrFormElems,
						datatype:sDataType,
						success:handlebtn.upfileSuccess,
						error:handlebtn.upfileError
					});					
				});
			}
		},
		upfileSuccess:function(data,status,type){// 文件上传 成功的回调函数
			if (status == "success"){
				upms.hideOverLay();// 关闭遮罩
				var sBtnId = handlebtn.btnForUpFileParams.btnid,// 按钮的id值
					sSuccUrl = handlebtn.btnForUpFileParams.succurl,// 请求成功后处理的url  数据返回类型是json的情况下才会使用
					sErrUrl = handlebtn.btnForUpFileParams.errurl,// 请求失败后处理的url 数据返回类型是json的情况下才会使用
					arrFormElems = handlebtn.btnForUpFileParams.formElems,
					sDialogTitle = handlebtn.btnForUpFileParams.dialogtitle,// 对话框的标题
					sSuccDialogTip = handlebtn.btnForUpFileParams.succdialogtip,// 对话框提示信息 成功
					sErrDialogTip = handlebtn.btnForUpFileParams.errdialogtip,// 对话框提示信息 失败
					sChkType = handlebtn.btnForUpFileParams.chkType,
					sChkErrInfoId = handlebtn.btnForUpFileParams.chkErrInfoId,
					sDataType = handlebtn.btnForUpFileParams.datatype;
				if (checkUtils.isEmptyStr(sSuccDialogTip)){
					sSuccDialogTip = "文件上传成功!";
				}
				if (checkUtils.isEmptyStr(sErrDialogTip)){
					sErrDialogTip = "文件上传失败!";
				}
				if (checkUtils.isEmptyStr(sDialogTitle)){
					sDialogTitle = "信息提示";
				}
				var $currPgDiv = upms.getCurrPageDiv();
				
				if (sChkType == "single"){
					handlebtn.clearTipInfo(sChkErrInfoId,$currPgDiv);
				}
				
				switch (type){
					case "json":
						if (data.jsonFlag == true){
							if (checkUtils.isNotEmptyStr(data.jsonMsg)){
								sSuccDialogTip = data.jsonMsg;
							}
							handlebtn.createDialog(handlebtn.upfileDialogId + sBtnId + "succ", sDialogTitle, sSuccDialogTip, $currPgDiv);
							$("#" + handlebtn.upfileDialogId + sBtnId + "succ",$currPgDiv).dialog({
					 			autoOpen: true,
								modal: true,
								dialogClass:"dialogfont",
								close:function(){// 为按钮关闭添加事件
									if (checkUtils.isNotEmptyStr(sSuccUrl)){
										upms.saveHisPageDiv();// 保存历史记录
										var $newPgDiv = upms.createPageDiv();
										$newPgDiv.load(sSuccUrl,{jsonFlag:true});										
									}
								},
								buttons: {
									"确定":function(){
										$(this).dialog("close");
									}
								}
							});
						}else{
							if (checkUtils.isNotEmptyStr(data.jsonMsg)){
								sErrDialogTip = data.jsonMsg;
							}
							handlebtn.createDialog(handlebtn.upfileDialogId + sBtnId + "err", sDialogTitle, sErrDialogTip, $currPgDiv);
							$("#" + handlebtn.upfileDialogId + sBtnId + "err",$currPgDiv).dialog({
					 			autoOpen: true,
								modal: true,
								dialogClass:"dialogfont",
								close:function(){// 为按钮关闭添加事件
									if (checkUtils.isNotEmptyStr(sErrUrl)){
										upms.saveHisPageDiv();// 保存历史记录
										var $newPgDiv = upms.createPageDiv();
										$newPgDiv.load(sErrUrl,{jsonFlag:false});										
									}
								},
								buttons: {
									"确定":function(){
										$(this).dialog("close");
									}
								}
							});
						}
					break;
					case "html":
						if (checkUtils.isNotNull(data)){
							upms.saveHisPageDiv();// 保存历史记录
							var $newPgDiv = upms.createPageDiv();
							$newPgDiv.html(data);
						}
					break;
					default:
						
					break;
				}
			}
		},
		upfileError:function(data,status,type){// 文件上传  失败的回调函数
			if (status == "error"){
				upms.hideOverLay();// 关闭遮罩
				var sDialogTitle = handlebtn.btnForUpFileParams.dialogtitle,// 对话框的标题
					sChkType = handlebtn.btnForUpFileParams.chkType,
					sChkErrInfoId = handlebtn.btnForUpFileParams.chkErrInfoId,
					sBtnId = handlebtn.btnForUpFileParams.btnid;// 按钮的id值
				if (sChkType == "single"){
					handlebtn.clearTipInfo(sChkErrInfoId,$currPgDiv);
				}
				if (checkUtils.isEmail(data)){
					data = "文件上传失败!"
				}
				if (checkUtils.isEmptyStr(sDialogTitle)){
					sDialogTitle = "信息提示";
				}
				var $currPgDiv = upms.getCurrPageDiv();
				handlebtn.createDialog(handlebtn.upfileDialogId + sBtnId + "error", sDialogTitle, data, $currPgDiv);
				$("#" + handlebtn.upfileDialogId + sBtnId + "error",$currPgDiv).dialog({
		 			autoOpen: true,
					modal: true,
					dialogClass:"dialogfont",
					buttons: {
						"确定":function(){
							$(this).dialog("close");
						}
					}
				});
			}
		},
		ajaxchksubmit:function(params){
			// to do.. 带ajax校验的提交操作
		},
		submit:function(params){// 提交按钮
			var sBtnId = params.btnid,// 按钮的id值
				oValidate = params.validate,// 传入参数
				arrParams = params.params,
				sFormId = params.formid,// 请求的form
				sUrl = params.url;// 请求的url
			var sChkModel = oValidate.model;
			var $currPgDiv = upms.getCurrPageDiv();
			//var $currPgDiv = $("#" + params.contantdiv);//upms.getCurrPageDiv();
			
			switch (sChkModel){
				case "formsevent":
					handlebtn.saveCheckFlag(true, $currPgDiv);
					handlebtn.validateBtn(oValidate, $currPgDiv);
					$("#" + sBtnId,$currPgDiv).bind("click",function(){
						handlebtn.allValidate(oValidate, $currPgDiv);
						if (handlebtn.getCheckFlag($currPgDiv) == true){
							upms.showOverLay();// 开启遮罩
							var ajaxParams = upms.transParsToObj(arrParams,$currPgDiv);
							upms.saveHisPageDiv();// 保存历史记录
							var $newPgDiv = upms.createPageDiv();
							$newPgDiv.load(sUrl,ajaxParams,function(){
								upms.hideOverLay();// 关闭遮罩
							});
						}
					});			
				break;
				case "batch":
					handlebtn.saveCheckFlag(true, $currPgDiv);
					$("#" + sBtnId,$currPgDiv).bind("click",function(){
						handlebtn.batchValidate(oValidate, $currPgDiv);
						if (handlebtn.getCheckFlag($currPgDiv) == true){
							upms.showOverLay();// 开启遮罩
							var ajaxParams = upms.transParsToObj(arrParams,$currPgDiv);
							upms.saveHisPageDiv();// 保存历史记录
							var $newPgDiv = upms.createPageDiv();
							$newPgDiv.load(sUrl,ajaxParams,function(){
								upms.hideOverLay();// 关闭遮罩
							});
						}						
					});
				break;
				case "single":
					handlebtn.saveCheckFlag(true, $currPgDiv);
					$("#" + sBtnId,$currPgDiv).bind("click",function(){
						handlebtn.singleValidate(oValidate, $currPgDiv);
						if (handlebtn.getCheckFlag($currPgDiv) == true){
							upms.showOverLay();// 开启遮罩
							var ajaxParams = upms.transParsToObj(arrParams,$currPgDiv);
							upms.saveHisPageDiv();// 保存历史记录
							var $newPgDiv = upms.createPageDiv();
							$newPgDiv.load(sUrl,ajaxParams,function(){
								upms.hideOverLay();// 关闭遮罩
							});
						}						
					});
				break;
				default:
				
				break;
			}
		},
		showTipInfo:function(sErrInfoId,sFalseDesc,$currPgDiv){// 显示信息
			$("#" + sErrInfoId,$currPgDiv).html(sFalseDesc);
			$("#" + sErrInfoId,$currPgDiv).show();
		},
		clearTipInfo:function(sErrInfoId,$currPgDiv){// 清除
			$("#" + sErrInfoId,$currPgDiv).html("");
			$("#" + sErrInfoId,$currPgDiv).hide();
		},
		singleValidate:function(oValidate,$currPgDiv){// 按钮的单个校验
			var arrParams = oValidate.params,
				sErrInfoId = oValidate.errinfoid;
			var outerFlag = true,sErrMsg = "";	
			
			var tipArrs = [];
			
			if (checkUtils.isNotEmptyStr(sErrInfoId)){
				tipArrs.push(sErrInfoId);
				upmsTipManage.saveUpmsTipObj(tipArrs);
			}
			
			handlebtn.clearTipInfo(sErrInfoId,$currPgDiv);
			for (var i = 0,len = arrParams.length;i < len;i++){
				var oVObj = arrParams[i];
				var sTargetId = oVObj.targetid,
				    sTargetName = oVObj.targetname,
				    sType = oVObj.type,
				    funCheck = oVObj.oncheck,
			    	sFalseTip = oVObj.falsetip;
				var sFunParams = handlebtn.getFormsElemValue(oVObj, $currPgDiv);
				if ($.isFunction(funCheck)){
					if (funCheck(sFunParams) === false){
						sErrMsg += "[" + sFalseTip + "]&nbsp;&nbsp;";
						outerFlag = false;
					}
				}
			}
			handlebtn.showTipInfo(sErrInfoId, sErrMsg, $currPgDiv);
			if (outerFlag == true){
				handlebtn.saveCheckFlag(true, $currPgDiv);
			}else{
				handlebtn.saveCheckFlag(false, $currPgDiv);
			}
		},
		batchValidate:function(oValidate,$currPgDiv){// 按钮的批量校验
			var arrParams = oValidate.params;
			var outerFlag = true;
			for (var i = 0,len = arrParams.length;i < len;i++){
				var oVObj = arrParams[i];
				var sTargetId = oVObj.targetid,
				    sTargetName = oVObj.targetname,
				    sType = oVObj.type,
				    funCheck = oVObj.oncheck,
				    sInfoId = oVObj.infoid,
			    	sTrueTip = oVObj.truetip,
			    	sFalseTip = oVObj.falsetip,
			    	sInfoTip = oVObj.infotip;
				$("#" + sInfoId,$currPgDiv).html("");
				$("#" + sInfoId,$currPgDiv).removeClass("errTip");
				$("#" + sInfoId,$currPgDiv).removeClass("infoTip");
				var sFunParams = handlebtn.getFormsElemValue(oVObj, $currPgDiv);
				if ($.isFunction(funCheck)){
					if (funCheck(sFunParams) === false){
						$("#" + sInfoId,$currPgDiv).addClass("errTip");
						if (checkUtils.isNotEmptyStr(sFalseTip)){
							$("#" + sInfoId,$currPgDiv).html(sFalseTip);
						}	
						outerFlag = false;
					}
				}
				if (outerFlag == true){
					handlebtn.saveCheckFlag(true, $currPgDiv);
				}else{
					handlebtn.saveCheckFlag(false, $currPgDiv);
				}
			}
		},
		allValidate:function(oValidate,$currPgDiv){// 所有校验项全部校验下
			var arrParams = oValidate.params;
			var outerFlag = true;
			for (var i = 0,len = arrParams.length;i < len;i++){
				var oVObj = arrParams[i];
				var sTargetId = oVObj.targetid,
				    sTargetName = oVObj.targetname,
				    sType = oVObj.type,
				    funFocus = oVObj.onfocus,
				    funBlur = oVObj.onblur,
				    funClick = oVObj.onclick,
				    funCheck = oVObj.oncheck,
				    sInfoId = oVObj.infoid,
			    	sTrueTip = oVObj.truetip,
			    	sFalseTip = oVObj.falsetip,
			    	sInfoTip = oVObj.infotip,
				    funChange = oVObj.onchange;
				$("#" + sInfoId,$currPgDiv).html("");
				$("#" + sInfoId,$currPgDiv).removeClass("errTip");
				$("#" + sInfoId,$currPgDiv).removeClass("infoTip");
				var sFunParams = handlebtn.getFormsElemValue(oVObj, $currPgDiv);
				if ($.isFunction(funFocus)){
					if (funFocus(sFunParams) === false){
						$("#" + sInfoId,$currPgDiv).addClass("errTip");
						if (checkUtils.isNotEmptyStr(sFalseTip)){
							$("#" + sInfoId,$currPgDiv).html(sFalseTip);
						}
						outerFlag = false;
					}
				}
				if ($.isFunction(funBlur)){
					if (funBlur(sFunParams) === false){
						$("#" + sInfoId,$currPgDiv).addClass("errTip");
						if (checkUtils.isNotEmptyStr(sFalseTip)){
							$("#" + sInfoId,$currPgDiv).html(sFalseTip);
						}		
						outerFlag = false;
					}
				}
				if ($.isFunction(funClick)){
					if (funClick(sFunParams) === false){
						$("#" + sInfoId,$currPgDiv).addClass("errTip");
						if (checkUtils.isNotEmptyStr(sFalseTip)){
							$("#" + sInfoId,$currPgDiv).html(sFalseTip);
						}
						outerFlag = false;
					}
				}
				if ($.isFunction(funChange)){
					if (funChange(sFunParams) === false){
						$("#" + sInfoId,$currPgDiv).addClass("errTip");
						if (checkUtils.isNotEmptyStr(sFalseTip)){
							$("#" + sInfoId,$currPgDiv).html(sFalseTip);
						}	
						outerFlag = false;
					}
				}
				if ($.isFunction(funCheck)){
					if (funCheck(sFunParams) === false){
						$("#" + sInfoId,$currPgDiv).addClass("errTip");
						if (checkUtils.isNotEmptyStr(sFalseTip)){
							$("#" + sInfoId,$currPgDiv).html(sFalseTip);
						}	
						outerFlag = false;
					}
				}
			}
			if (outerFlag == true){
				handlebtn.saveCheckFlag(true, $currPgDiv);
			}else{
				handlebtn.saveCheckFlag(false, $currPgDiv);
			}
		},
		validateBtn:function(oValidate,$currPgDiv){// 按钮操作校验
			var sModel = oValidate.model;// 校验类型
			switch (sModel){
				case "formsevent":
					var arrParams = oValidate.params;
					for (var i = 0,len = arrParams.length;i < len;i++){
						var oVObj = arrParams[i];
						var sTargetId = oVObj.targetid,
						    sTargetName = oVObj.targetname,
						    sType = oVObj.type,
						    funFocus = oVObj.onfocus,
						    funBlur = oVObj.onblur,
						    funClick = oVObj.onclick,
						    funChange = oVObj.onchange;
						var $currChkObj = upms.select$obj(sTargetId,sTargetName,sType,$currPgDiv);
						if ($.isFunction(funFocus)){// 赋予focus事件
							$currChkObj.bind("focus",oVObj,function(evt){
							    var sInfoId = evt.data.infoid,
							    	sTrueTip = evt.data.truetip,
							    	sFalseTip = evt.data.falsetip,
							    	funFocus = evt.data.onfocus,
							    	sInfoTip = evt.data.infotip;
								$("#" + sInfoId,$currPgDiv).html("");
								$("#" + sInfoId,$currPgDiv).removeClass("errTip");
								$("#" + sInfoId,$currPgDiv).removeClass("infoTip");
								var sFunParams = handlebtn.getFormsElemValue(evt.data, $currPgDiv);
								if (funFocus(sFunParams) === true){
									$("#" + sInfoId,$currPgDiv).addClass("infoTip");
									if (checkUtils.isNotEmptyStr(sTrueTip)){
										$("#" + sInfoId,$currPgDiv).html(sTrueTip);
									}
								}else if (funFocus(sFunParams) === false){
									$("#" + sInfoId,$currPgDiv).addClass("errTip");
									if (checkUtils.isNotEmptyStr(sFalseTip)){
										$("#" + sInfoId,$currPgDiv).html(sFalseTip);
									}
									handlebtn.saveCheckFlag(false, $currPgDiv);
								}else{
									$("#" + sInfoId,$currPgDiv).addClass("infoTip");
									if (checkUtils.isNotEmptyStr(sInfoTip)){
										$("#" + sInfoId,$currPgDiv).html(sInfoTip);
									}
								}
							});
						}
						if ($.isFunction(funBlur)){// blur事件
							$currChkObj.bind("blur",oVObj,function(evt){
							    var sInfoId = evt.data.infoid,
							    	sTrueTip = evt.data.truetip,
							    	sFalseTip = evt.data.falsetip,
							    	funBlur = evt.data.onblur,
							    	sInfoTip = evt.data.infotip;
								$("#" + sInfoId,$currPgDiv).html("");
								$("#" + sInfoId,$currPgDiv).removeClass("errTip");
								$("#" + sInfoId,$currPgDiv).removeClass("infoTip");
								var sFunParams = handlebtn.getFormsElemValue(evt.data, $currPgDiv);
								if (funBlur(sFunParams) === true){
									$("#" + sInfoId,$currPgDiv).addClass("infoTip");
									if (checkUtils.isNotEmptyStr(sTrueTip)){
										$("#" + sInfoId,$currPgDiv).html(sTrueTip);
									}
								}else if (funBlur(sFunParams) === false){
									$("#" + sInfoId,$currPgDiv).addClass("errTip");
									if (checkUtils.isNotEmptyStr(sFalseTip)){
										$("#" + sInfoId,$currPgDiv).html(sFalseTip);
									}
									handlebtn.saveCheckFlag(false, $currPgDiv);
								}else{
									$("#" + sInfoId,$currPgDiv).addClass("infoTip");
									if (checkUtils.isNotEmptyStr(sInfoTip)){
										$("#" + sInfoId,$currPgDiv).html(sInfoTip);
									}
								}
							});
						}
						if ($.isFunction(funChange)){// change事件
							$currChkObj.bind("change",oVObj,function(evt){
							    var sInfoId = evt.data.infoid,
							    	sTrueTip = evt.data.truetip,
							    	sFalseTip = evt.data.falsetip,
							    	funChange = evt.data.onchange
							    	sInfoTip = evt.data.infotip;
								$("#" + sInfoId,$currPgDiv).html("");
								$("#" + sInfoId,$currPgDiv).removeClass("errTip");
								$("#" + sInfoId,$currPgDiv).removeClass("infoTip");
								var sFunParams = handlebtn.getFormsElemValue(evt.data, $currPgDiv);
								if (funChange(sFunParams) === true){
									$("#" + sInfoId,$currPgDiv).addClass("infoTip");
									if (checkUtils.isNotEmptyStr(sTrueTip)){
										$("#" + sInfoId,$currPgDiv).html(sTrueTip);
									}
								}else if (funChange(sFunParams) === false){
									$("#" + sInfoId,$currPgDiv).addClass("errTip");
									if (checkUtils.isNotEmptyStr(sFalseTip)){
										$("#" + sInfoId,$currPgDiv).html(sFalseTip);
									}
									handlebtn.saveCheckFlag(false, $currPgDiv);
								}else{
									$("#" + sInfoId,$currPgDiv).addClass("infoTip");
									if (checkUtils.isNotEmptyStr(sInfoTip)){
										$("#" + sInfoId,$currPgDiv).html(sInfoTip);
									}
								}
							});							
						}
						if ($.isFunction(funClick)){// click事件
							$currChkObj.bind("click",oVObj,function(evt){
							    var sInfoId = evt.data.infoid,
						    		sTrueTip = evt.data.truetip,
						    		sFalseTip = evt.data.falsetip,
						    		funClick = evt.data.onclick,
						    		sInfoTip = evt.data.infotip;
								$("#" + sInfoId,$currPgDiv).html("");
								$("#" + sInfoId,$currPgDiv).removeClass("errTip");
								$("#" + sInfoId,$currPgDiv).removeClass("infoTip");
								var sFunParams = handlebtn.getFormsElemValue(evt.data, $currPgDiv);
								if (funClick(sFunParams) === true){
									$("#" + sInfoId,$currPgDiv).addClass("infoTip");
									if (checkUtils.isNotEmptyStr(sTrueTip)){
										$("#" + sInfoId,$currPgDiv).html(sTrueTip);
									}
								}else if (funClick(sFunParams) === false){
									$("#" + sInfoId,$currPgDiv).addClass("errTip");
									if (checkUtils.isNotEmptyStr(sFalseTip)){
										$("#" + sInfoId,$currPgDiv).html(sFalseTip);
									}
									handlebtn.saveCheckFlag(false, $currPgDiv);
								}else{
									$("#" + sInfoId,$currPgDiv).addClass("infoTip");
									if (checkUtils.isNotEmptyStr(sInfoTip)){
										$("#" + sInfoId,$currPgDiv).html(sInfoTip);
									}
								}
							});							
						}
					}
				break;
				default:
					
				break;
			}
		},
		getFormsElemValue:function(obj,$currPgDiv){
			var sTargetId = obj.targetid,
		    	sTargetName = obj.targetname,
		    	sType = obj.type;
			var $currChkObj = upms.select$obj(sTargetId,sTargetName,sType,$currPgDiv);
			if (sType == "checkbox"){
				var retArr = [];
				$currChkObj.each(function(ind,elem){
					retArr.push($.trim($(elem).val()));
				});
				return retArr;
			}else if(sType == "radio"){
				$currChkObj = upms.transTo$obj(sTargetId,sTargetName,sType,$currPgDiv);
				return $.trim($currChkObj.val());
			}else if(sType == "select"){
				$currChkObj = upms.transTo$obj(sTargetId,sTargetName,sType,$currPgDiv);
				return $.trim($currChkObj.val());
			}else{
				return $.trim($currChkObj.val());
			}
		},
		getCheckFlag:function($currPgDiv){
			var CHECKFLAG = "_handle_btn_check_flag_";
			var $chkFlagObj = $("#" + CHECKFLAG,$currPgDiv);
			if ($chkFlagObj.length == 0){
				return true;
			}else{
				if ($chkFlagObj.val() == "false"){
					return false;
				}else{
					return true;
				}
			}
		},
		saveCheckFlag:function(flag,$currPgDiv){// 保存校验标记
			var CHECKFLAG = "_handle_btn_check_flag_";
			var $chkFlagObj = $("#" + CHECKFLAG,$currPgDiv);
			if ($chkFlagObj.length == 0){
				$chkFlagObj = $("<input type='hidden' id='" + CHECKFLAG + "' name='" + CHECKFLAG + "' value='" + flag + "' />");
				$currPgDiv.append($chkFlagObj);
			}else{
				$chkFlagObj.val(flag);
			}
		},
		selectDialogId:"_select_dialog_btn_model_",
		selectbtn:function(params){// 带勾选框的跳转
			var sBtnId = params.btnid,// 按钮的id值
				sUrl = params.url,// 请求的url
				sModel = params.model,// 模式 forward 跳转页面  dialog  提示框，对应的url取值不同
				sDialogTitle = params.dialogtitle,// 对话框的标题
				oSelectObj = params.selectobj,
				sCheckSms = params.checksms,// 是否需要短信验证 open为需要 默认是close
				sSmsTip = params.smstip,// 短信验证提示语言
				sErrDialogTip = params.errdialogtip,// 对话框提示信息 失败
				sSuccDialogTip = params.succdialogtip;// 对话框提示信息 成功
			var $currPgDiv = upms.getCurrPageDiv();
			if (checkUtils.isEmptyStr(sSuccDialogTip)){
				sSuccDialogTip = "操作成功!";
			}
			if (checkUtils.isEmptyStr(sErrDialogTip)){
				sErrDialogTip = "操作失败!";
			}
			if (checkUtils.isEmptyStr(sDialogTitle)){
				sDialogTitle = "信息提示";
			}
			if (checkUtils.isEmptyStr(sSmsTip)){
				sSmsTip = "短信验证不通过!";
			}
			if (sCheckSms != "open"){
				sCheckSms = "close";
			}
			$("#" + sBtnId,$currPgDiv).bind("click",function(){
				var innerFlag = true;
				if (sCheckSms == "open"){
					if (sms.getSmsCheckFlag() == false){
						innerFlag = false;
						handlebtn.createDialog(handlebtn.selectDialogId + sBtnId + "sms", sDialogTitle, sSmsTip, $currPgDiv);
						$("#" + handlebtn.selectDialogId + sBtnId + "sms",$currPgDiv).dialog({
				 			autoOpen: true,
							modal: true,
							dialogClass:"dialogfont",
							buttons: {
								"确定":function(){
									$(this).dialog("close");
								}
							}						
						});
					}
				}
				if (innerFlag){
					if ($.isPlainObject(oSelectObj) && !$.isEmptyObject(oSelectObj)){
						var $selObj = undefined,sSelType = undefined,$seledObj  = undefined;
						
						if (checkUtils.isNotEmptyStr(oSelectObj.type)){
							sSelType = oSelectObj.type;
							if (sSelType == "checkbox"){
								if (checkUtils.isNotEmptyStr(oSelectObj.targetid)){
									$selObj = $("input[type='checkbox'][id='" + oSelectObj.targetid + "']",$currPgDiv);
									$seledObj = $("input[type='checkbox'][id='" + oSelectObj.targetid + "']:checked",$currPgDiv);
								}else if (checkUtils.isNotEmptyStr(oSelectObj.targetname)){
									$selObj = $("input[type='checkbox'][name='" + oSelectObj.targetname + "']",$currPgDiv);
									$seledObj = $("input[type='checkbox'][name='" + oSelectObj.targetname + "']:checked",$currPgDiv);
								}
							}else if (sSelType == "radio"){
								if (checkUtils.isNotEmptyStr(oSelectObj.targetid)){
									$selObj = $("input[type='radio'][id='" + oSelectObj.targetid + "']",$currPgDiv);
									$seledObj = $("input[type='radio'][id='" + oSelectObj.targetid + "']:checked",$currPgDiv);
								}else if (checkUtils.isNotEmptyStr(oSelectObj.targetname)){
									$selObj = $("input[type='radio'][name='" + oSelectObj.targetname + "']",$currPgDiv);
									$seledObj = $("input[type='radio'][name='" + oSelectObj.targetname + "']:checked",$currPgDiv);
								}
							}
							if (checkUtils.isNotNull($selObj)){
								if ($seledObj.length > 0){
									if (sModel == "forward"){
										if (sSelType == "checkbox"){
											var spName = oSelectObj.name;
											if (checkUtils.isEmptyStr(spName)){
												spName = $seledObj.attr("name");
											}
											if (checkUtils.isNotEmptyStr(spName)){
												upms.showOverLay();// 打开遮罩
												var data = {};
												var tmpArr = [];
												$seledObj.each(function(ind,elem){
													tmpArr.push($.trim($(elem).val()));
												});
												data[spName] = tmpArr.join(",");
												upms.saveHisPageDiv();// 保存历史记录
												var $newPgDiv = upms.createPageDiv();
												$newPgDiv.load(sUrl,data,function(){
													upms.hideOverLay();// 关闭遮罩
												});	
											}
										}else if (sSelType == "radio"){
											var spName = oSelectObj.name;
											if (checkUtils.isEmptyStr(spName)){
												spName = $seledObj.attr("name");
											}
											if (checkUtils.isNotEmptyStr(spName)){
												upms.showOverLay();// 打开遮罩
												var data = {};
												data[spName] = $seledObj.val();
												upms.saveHisPageDiv();// 保存历史记录
												var $newPgDiv = upms.createPageDiv();
												$newPgDiv.load(sUrl,data,function(){
													upms.hideOverLay();// 关闭遮罩
												});	
											}
										}								
									}else if (sModel == "dialog"){
										if (sSelType == "checkbox"){
											var spName = oSelectObj.name;
											if (checkUtils.isEmptyStr(spName)){
												spName = $seledObj.attr("name");
											}
											if (checkUtils.isNotEmptyStr(spName)){
												upms.showOverLay();// 打开遮罩
												var data = {};
												var tmpArr = [];
												$seledObj.each(function(ind,elem){
													tmpArr.push($.trim($(elem).val()));
												});
												data[spName] = tmpArr.join(",");
												$.ajax({
													type:"post",
													url:sUrl,
													data:data,
													success:function(retmsg){
														if (checkUtils.isNotNull(retmsg)){
															if (retmsg.jsonFlag){// 成功
																if (checkUtils.isNotEmptyStr(retmsg.jsonMsg)){
																	handlebtn.createDialog(handlebtn.selectDialogId + sBtnId + "succ", sDialogTitle, retmsg.jsonMsg, $currPgDiv);
																}else{
																	handlebtn.createDialog(handlebtn.selectDialogId + sBtnId + "succ", sDialogTitle, sSuccDialogTip, $currPgDiv);
																}
																$("#" + handlebtn.selectDialogId + sBtnId + "succ",$currPgDiv).dialog({
														 			autoOpen: true,
																	modal: true,
																	dialogClass:"dialogfont",
																	close:function(){// 为按钮关闭添加事件
																		pagequery.callbackQuery($currPgDiv);
																	},
																	buttons: {
																		"确定":function(){
																			$(this).dialog("close");
																		}
																	}						
																});
															}else{// 失败
																if (checkUtils.isNotEmptyStr(retmsg.jsonMsg)){
																	handlebtn.createDialog(handlebtn.selectDialogId + sBtnId + "fail", sDialogTitle, retmsg.jsonMsg, $currPgDiv,"error");
																}else{
																	handlebtn.createDialog(handlebtn.selectDialogId + sBtnId + "fail", sDialogTitle, sErrDialogTip, $currPgDiv,"error");
																}
																$("#" + handlebtn.selectDialogId + sBtnId + "fail",$currPgDiv).dialog({
														 			autoOpen: true,
																	modal: true,
																	dialogClass:"dialogfont",
																	buttons: {
																		"确定":function(){
																			$(this).dialog("close");
																		}
																	}						
																});
															}
														}
														upms.hideOverLay();// 关闭遮罩
													},
													error:function(retmsg){
														alert("网络连接错误，请稍候再试！");
														upms.hideOverLay();// 关闭遮罩
													}
												});
											}
										}else if (sSelType == "radio"){
											var spName = oSelectObj.name;
											if (checkUtils.isEmptyStr(spName)){
												spName = $seledObj.attr("name");
											}
											if (checkUtils.isNotEmptyStr(spName)){
												upms.showOverLay();// 打开遮罩
												var data = {};
												data[spName] = $seledObj.val();
												$.ajax({
													type:"post",
													url:sUrl,
													data:data,
													success:function(retmsg){
														if (checkUtils.isNotNull(retmsg)){
															if (retmsg.jsonFlag){// 成功
																if (checkUtils.isNotEmptyStr(retmsg.jsonMsg)){
																	handlebtn.createDialog(handlebtn.selectDialogId + sBtnId + "succ", sDialogTitle, retmsg.jsonMsg, $currPgDiv);
																}else{
																	handlebtn.createDialog(handlebtn.selectDialogId + sBtnId + "succ", sDialogTitle, sSuccDialogTip, $currPgDiv);
																}
																$("#" + handlebtn.selectDialogId + sBtnId + "succ",$currPgDiv).dialog({
														 			autoOpen: true,
																	modal: true,
																	dialogClass:"dialogfont",
																	close:function(){// 为按钮关闭添加事件
																		pagequery.callbackQuery($currPgDiv);
																	},
																	buttons: {
																		"确定":function(){
																			$(this).dialog("close");
																		}
																	}						
																});
															}else{// 失败
																if (checkUtils.isNotEmptyStr(retmsg.jsonMsg)){
																	handlebtn.createDialog(handlebtn.selectDialogId + sBtnId + "fail", sDialogTitle, retmsg.jsonMsg, $currPgDiv,"error");
																}else{
																	handlebtn.createDialog(handlebtn.selectDialogId + sBtnId + "fail", sDialogTitle, sErrDialogTip, $currPgDiv,"error");
																}
																$("#" + handlebtn.selectDialogId + sBtnId + "fail",$currPgDiv).dialog({
														 			autoOpen: true,
																	modal: true,
																	dialogClass:"dialogfont",
																	buttons: {
																		"确定":function(){
																			$(this).dialog("close");
																		}
																	}						
																});
															}
														}
														upms.hideOverLay();// 关闭遮罩
													},
													error:function(retmsg){
														alert("网络连接错误，请稍候再试！");
														upms.hideOverLay();// 关闭遮罩
													}
												});
											}
										}
									}
								}else{
									handlebtn.createDialog(handlebtn.selectDialogId + sBtnId + "sel", sDialogTitle, "请选择相关记录!", $currPgDiv);
									$("#" + handlebtn.selectDialogId + sBtnId + "sel",$currPgDiv).dialog({
							 			autoOpen: true,
										modal: true,
										dialogClass:"dialogfont",
										buttons: {
											"确定":function(){
												$(this).dialog("close");
											}
										}						
									});
								}
							}
						}
					}else{
						handlebtn.createDialog(handlebtn.selectDialogId + sBtnId + "err", sDialogTitle, "方法使用不当！", $currPgDiv,"error");
						$("#" + handlebtn.selectDialogId + sBtnId + "err",$currPgDiv).dialog({
				 			autoOpen: true,
							modal: true,
							dialogClass:"dialogfont",
							buttons: {
								"确定":function(){
									$(this).dialog("close");
								}
							}						
						});
					}				
				}

			});
		},
		forward:function(params){// 跳转页面
			var sBtnId = params.btnid,// 按钮的id值
				arrParams = params.params,// 传入参数
				sUrl = params.url,// 请求的url
				sDialog = params.dialog,// 是否需要对话框 
				sDialogTitle = params.dialogtitle,// 对话框的标题
				sDialogTip = params.dialogtip;// 对话框提示信息
			var $currPgDiv = upms.getCurrPageDiv();
			if (checkUtils.isEmptyStr(sDialogTip)){
				sDailogTip = "你确定要操作吗?";
			}
			if (checkUtils.isEmptyStr(sDialogTitle)){
				sDialogTitle = "信息提示";
			}
			$("#" + sBtnId,$currPgDiv).bind("click",function(){
				if (sDialog != "open"){
					upms.showOverLay();// 打开遮罩
					var data = upms.transParsToObj(arrParams,$currPgDiv);
					upms.saveHisPageDiv();// 保存历史记录
					var $newPgDiv = upms.createPageDiv();
					$newPgDiv.load(sUrl,data,function(){
						upms.hideOverLay();// 关闭遮罩
					});
				}else{
					handlebtn.createDialog(handlebtn.dialogId + sBtnId, sDialogTitle, sDailogTip, $currPgDiv);
					$("#" + handlebtn.dialogId + sBtnId,$currPgDiv).dialog({
			 			autoOpen: true,
						modal: true,
						dialogClass:"dialogfont",
						buttons: {
							"确定":function(){
								upms.showOverLay();// 打开遮罩
								var data = upms.transParsToObj(arrParams,$currPgDiv);
								upms.saveHisPageDiv();// 保存历史记录
								var $newPgDiv = upms.createPageDiv();
								$newPgDiv.load(sUrl,data,function(){
									upms.hideOverLay();// 关闭遮罩
								});
								$(this).dialog("close");
							},
							"取消":function(){
								$(this).dialog("close");
							}
						}						
					});
				}
			});
		},
		createDialog:function(sDialogId,sTitle,sInfoTip,$currPgDiv,infoType){
			var arrHtml = new Array();
			if (infoType == "error"){
				arrHtml.push(" <div id='" + sDialogId + "' title='" + sTitle + "' style='display:none'>");
				arrHtml.push("<center><p class='dialogErrTip'>" + sInfoTip + "</p></center>");
				arrHtml.push("</div>");
				$currPgDiv.append(arrHtml.join(""));	
			}else{
				arrHtml.push(" <div id='" + sDialogId + "' title='" + sTitle + "' style='display:none'>");
				arrHtml.push("<center><p class='dialogTip'>" + sInfoTip + "</p></center>");
				arrHtml.push("</div>");
				$currPgDiv.append(arrHtml.join(""));				
			}
		}
	};
	// 文件上传
	var ajaxUploadFile = {
		IFRAME_PREF:"_upms_ajax_file_up_iframe_",
		FORM_PREF:"_upms_ajax_file_up_frm_",
		execute:function(params){// ajax文件上传对外执行方法
			var sUrl = params.url,
				arrFormElems = params.formElems,
				funSuccess = params.success,
				funError = params.error,
				sDataType = params.datatype;
			var currTimeId = new Date().getTime();
			var $form = ajaxUploadFile.createUpFileForm(currTimeId, arrFormElems);
			var $ifrm = ajaxUploadFile.createUpFileIframe(currTimeId, sUrl);
			var sCurrFrameId = ajaxUploadFile.IFRAME_PREF + currTimeId,
				sCurrFormId = ajaxUploadFile.FORM_PREF + currTimeId;
			
			// 定义事件的回调函数 S
			var upFileCallBack = function(){
				var xml = {};
				var oIframe = document.getElementById(sCurrFrameId);
				try{
					if (oIframe.contentWindow){
						xml.responseText = oIframe.contentWindow.document.body?oIframe.contentWindow.document.body.innerHTML:null;
						xml.responseXML = oIframe.contentWindow.document.XMLDocument?oIframe.contentWindow.document.XMLDocument:oIframe.contentWindow.document;
					}else if (oIframe.contentDocument){
						xml.responseText = oIframe.contentDocument.document.body?oIframe.contentDocument.document.body.innerHTML:null;
						xml.responseXML = oIframe.contentDocument.document.XMLDocument?oIframe.contentDocument.document.XMLDocument:oIframe.contentDocument.document;
					}
					if (!$.isEmptyObject(xml)){
						var retArr = ajaxUploadFile.uploadFileData(xml,sDataType);
						if ($.isArray(retArr) && retArr.length == 2){
							if ($.isFunction(funSuccess)){// 成功处理函数
								funSuccess(retArr[1],"success",retArr[0]);
							}							
						}else{
							if ($.isFunction(funError)){
								funError("返回参数失败","error","html");// 失败处理函数
							}
						}
					}					
				}catch (e) {
					if ($.isFunction(funError)){
						funError(e,"error","html");// 失败处理函数
					}
				}
				
				$(oIframe).unbind();
				
				setTimeout(function(){
					try{
						$(oIframe).remove();
						$form.remove();
					}catch(e){
						alert(e);
					}
				},100);
				xml = {};
			};
			// 定义事件的回调函数 E
			
			try{
				$form.attr('target',sCurrFrameId);
				$form.attr('action',sUrl);
				if ($form.attr("encoding")){
					$form.attr("encoding","multipart/form-data");
				}else{
					$form.attr("enctype","multipart/form-data");
				}
				$form.submit();
			}catch (e) {
				if ($.isFunction(funError)){
					funError(e,"error","html");// 失败处理函数
				}
			}
			
			if (window.attachEvent){
				document.getElementById(sCurrFrameId).attachEvent('onload', upFileCallBack);
			}else{
				document.getElementById(sCurrFrameId).addEventListener('load', upFileCallBack, false);
			}
			return;
		},
		createUpFileIframe:function(currTimeId,sUrl){// 构建用于文件上传的iframe
			var sFrameId = ajaxUploadFile.IFRAME_PREF + currTimeId;
			var $upIFrame = $("<iframe id='" + sFrameId + "' name='" + sFrameId + "' />");
			$upIFrame.css('position','absolute');
			$upIFrame.css('top','-1000px');
			$upIFrame.css('left','-1000px');
			$upIFrame.attr('src',sUrl);
			$('body').append($upIFrame);
			return $upIFrame;			
		},
		createUpFileForm:function(currTimeId,arrFormElems){// 创建用于文件上传的隐藏form
			var sFormId = ajaxUploadFile.FORM_PREF + currTimeId;
			var $upForm = $("<form action='' method='post' name='" + sFormId + "' id='" + sFormId + "' enctype='multipart/form-data'></form>");
			for (var i = 0,len = arrFormElems.length;i < len;i++){
				var sOldElemParams = arrFormElems[i];
				var sTargetId = sOldElemParams.targetid,
					sTargetName = sOldElemParams.targetname,
					sType = sOldElemParams.type;
				var $oldElem = upms.select$obj(sTargetId,sTargetName,sType);
				var sNewElemId = ajaxUploadFile.FORM_PREF + currTimeId + $oldElem.attr("id");
				var $newElem = $oldElem.clone();
				$newElem.attr("id",sNewElemId);
				if (sType == "select"){
					var sSelVal = $("option:selected",$oldElem).val();
					$("option[value='" + sSelVal + "']",$newElem).attr("selected","selected");
				}
				if (sType == "textarea"){
					$newElem.val($oldElem.val());
				}
				$upForm.append($newElem);
			}
			$upForm.css('position','absolute');
			$upForm.css('top','-1200px');
			$upForm.css('left','-1200px');
			$upForm.appendTo('body');
			return $upForm;
		},
		uploadFileData:function(xml,sDataType){
			var data = xml.responseText;
			var retArr = [];
			switch (sDataType){
				case "json":
					retArr = [];
					retArr.push("json");
					var retObj;
					try {
						retObj = eval("(" + data + ")");
					} catch (e) {
						retObj = eval("(" + $(data).html() + ")");
					}
					retArr.push(retObj);
					return  retArr;
				break;
				case "html":
					retArr = [];
					retArr.push("html");
					retArr.push($(data).html());
					return retArr;
				break;
				case "jsonhtml":
					var retObj;
					try {
						retArr = [];
						retObj = eval("(" + $(data).html() + ")");
						retArr.push("json");
						retArr.push(retObj);
						return retArr;
					} catch (e) {
						retArr = [];
						retArr.push("html");
						retArr.push(data);
						return retArr;
					}
				break;
				default:
					retArr.push("html");
					retArr.push(data);
					return retArr;
				break;
			}
		}
	};
	// 短信验证
	var sms ={
		isSmsWait:true,
		smsTimesId:undefined,
		smsDivId:undefined,
		getSmsCheckFlag:function(){//  判断是否进行过短信验证
			var $currPgDiv = upms.getCurrPageDiv();
			var flag = $.trim($("#smsCheckFlag",$currPgDiv).val());
			if (flag == "true"){
				return true;
			}else{
				return false;
			}
		},
		load:function(params){// 加载短信的代码
			var sDivId = params.divid,// 加载短信验证的div的id值
				sUrl = params.url,// 请求的url
				sModel = params.model;// 请求模式  request 或 session
			sms.smsDivId = sDivId;// 记录显示的div
			var $currPgDiv = upms.getCurrPageDiv();
			if (checkUtils.isNotEmptyStr(sms.smsTimesId)){
				window.clearTimeout(sms.smsTimesId);
				sms.smsTimesId = undefined;
			}
			if (checkUtils.isNotEmptyStr(sModel)){
				if (sModel == "request"){
					$("#" + sDivId,$currPgDiv).load(sUrl,{},function(){
						$("#smsModel",$currPgDiv).val("request_model");
					});
				}else if (sModel == "session"){
					$("#" + sDivId,$currPgDiv).load(sUrl,{},function(){
						$("#smsModel",$currPgDiv).val("session_model");
					});
				}
			}
		},
		install:function(){// 安装短信发送功能
			sms.isSmsWait = true;
			var $currPgDiv = upms.getCurrPageDiv();
			$("#sendSmsBtn",$currPgDiv).bind("click",function(){// 获取短信信息
				sms.send();
			});	
			$("#checkSmsBtn",$currPgDiv).bind("click",function(){// 验证短信信息
				var chkCode = $("#validateCode",$currPgDiv).val();
				if (checkUtils.isEmptyStr(chkCode)){
					$("#sendResM",$currPgDiv).html("请输入短信验证码!").removeClass("greenC").addClass("redC").show();
				}else{
					sms.validate();
				}
			});
		},
		send:function(){
			var $currPgDiv = upms.getCurrPageDiv();
			$.ajax({
				type:"post",
				url:$.trim($("#sendSmsUrl",$currPgDiv).val()),
				success:function(msg){
					if (msg.respCode == '0000'){
						$("#respCode",$currPgDiv).val(msg.respCode);
						$("#validateOrderNum",$currPgDiv).val(msg.validateOrderNum);
						$("#validateTm",$currPgDiv).val(msg.validateTm);
						$("#sendResM",$currPgDiv).html('验证码30分钟内有效,若未收到,1分钟后可重新获取').removeClass("redC").addClass("greenC").show();
						$("#checkSmsBtn",$currPgDiv).show();
						sms.waitSend(60);
						sms.isSmsWait = true;					
					}else{
						$("#sendResM",$currPgDiv).html(msg.retMsg).removeClass("greenC").addClass("redC").show();
					}
				},
				error:function(msg){
					alert(msg);
				}				
			});
		},
		waitSend:function(s){// 等待发送
			var $currPgDiv = upms.getCurrPageDiv();
			if (!sms.isSmsWait){
				return;
			}else{
				if (s == 0){
					$("#sendSmsBtn",$currPgDiv).val('重新发送');
					$("#sendSmsBtn",$currPgDiv).bind("click",function(){
						sms.send();
					});
					return;
				}else{
					$("#sendSmsBtn",$currPgDiv).val(s+'秒后可重发');
					$("#sendSmsBtn",$currPgDiv).unbind("click");
				}
				--s;
				sms.smsTimesId = window.setTimeout("upms.sms.waitSend(" + s + ")",1000);
			}
		},
		validate:function(){
			var $currPgDiv = upms.getCurrPageDiv();
			var params = {
					"phoneSmsCode":$.trim($("#validateCode",$currPgDiv).val()),
					"validateOrderNum":$.trim($("#validateOrderNum",$currPgDiv).val()),
					"validateTm":$.trim($("#validateTm",$currPgDiv).val()),
					"smsModel":$.trim($("#smsModel",$currPgDiv).val())
				 };
			$.ajax({
				type:"post",
				url:$.trim($("#checkUrl",$currPgDiv).val()),
				data:params,
				success:function(msg){
					if (msg.respCode == '0000' && checkUtils.isNotEmptyStr(msg.smsModel)){
						
						var flag = false;
						$("#smsCheckFlag",$currPgDiv).val("false");
						if (msg.smsModel == "session_model"){
							flag = true;
							$("#smsCheckFlag",$currPgDiv).val("true");
						}else if (msg.smsModel == "request_model"){
							if (msg.isChkSmsReq == '1'){
								flag = true;
								$("#smsCheckFlag",$currPgDiv).val("true");
							}
						}
						if (flag){
							var n = 3;
							for (var i = 0;i <= n;i++){
								window.setTimeout("upms.sms.smstimes("+i+","+n+",function(){$('#" + sms.smsDivId + "',upms.getCurrPageDiv()).hide();return false;})",1000);
							}
						}else{
							$("#smsCheckFlag",$currPgDiv).val("false");
							$("#sendResM",$currPgDiv).html("短信验证失败!").removeClass("greenC").addClass("redC").show();
							if (checkUtils.isNotEmptyStr(sms.smsTimesId)){
								window.clearTimeout(sms.smsTimesId);
								sms.smsTimesId = undefined;
							}
							$("#sendSmsBtn",$currPgDiv).val('重新发送短信').show();
							$("#sendSmsBtn",$currPgDiv).bind("click",function(){
								sms.send();
							});	
						}
					}else{
						$("#sendResM",$currPgDiv).html(msg.jsonMsg).removeClass("greenC").addClass("redC").show();
						if (checkUtils.isNotEmptyStr(sms.smsTimesId)){
							window.clearTimeout(sms.smsTimesId);
							sms.smsTimesId = undefined;
						}
						$("#sendSmsBtn",$currPgDiv).val('重新发送短信').show();
						$("#sendSmsBtn",$currPgDiv).bind("click",function(){
							sms.send();
						});
					}
				},
				error:function(msg){
					alert(msg);
				}
			});
		},
		smstimes:function(i,j,callback){
			if(i != j){
				return;
			}else{
				callback();
			}			
		}		
	};
	// 查询列表的相关操作
	var grid = {
		gridHover:function($obj){
			$("tr:not(:first)",$obj).hover(function(){
				 $(this).addClass("over");
			},function(){
				 $(this).removeClass("over");
			});
		},
		radio:function(params){// 给单选框添加个性化事件
			var $gridrad = undefined;
			if (checkUtils.isNotEmptyStr(params.targetid)){
				$gridrad = $("input[type='radio'][id='" + params.targetid + "']");
			}else if (checkUtils.isNotEmptyStr(params.targetname)){
				$gridrad = $("input[type='radio'][name='" + params.targetname + "']");
			}
			if (checkUtils.isNotNull($gridrad)){
				$gridrad.bind("click",function(){
					if ($(this).attr("checked")){
						$gridrad.parent().parent().removeClass("select");
						$(this).parent().parent().addClass("select");
					}
				});
			}
		},
		checkboxall:function(params){// 查询列表全选框操作
			var oAllCheckbox = params.allcheckbox,
				oOneCheckbox = params.onecheckbox;
			var $allchkbox = undefined,$onechkbox = undefined;
			if (checkUtils.isNotEmptyStr(oAllCheckbox.targetid)){
				$allchkbox = $("#" + oAllCheckbox.targetid);
			}else if (checkUtils.isNotEmptyStr(oAllCheckbox.targetname)){
				$allchkbox = $("input[type='checkbox'][name='" + oAllCheckbox.targetname + "']");
			}
			if (checkUtils.isNotEmptyStr(oOneCheckbox.targetid)){
				$onechkbox = $("input[type='checkbox'][id='" + oOneCheckbox.targetid + "']");
			}else if (checkUtils.isNotEmptyStr(oOneCheckbox.targetname)){
				$onechkbox = $("input[type='checkbox'][name='" + oOneCheckbox.targetname + "']");
			}
			if (checkUtils.isNotNull($allchkbox) && checkUtils.isNotNull($onechkbox)){
				$allchkbox.bind("click",function(){
					if ($allchkbox.attr("checked")){
						$onechkbox.attr("checked","checked");
						$onechkbox.parent().parent().addClass("select");
					}else{
						$onechkbox.removeAttr("checked");  
						$onechkbox.parent().parent().removeClass("select");
					}
				});
				$onechkbox.bind("click",function(){
					if ($(this).attr("checked")){
						$(this).parent().parent().addClass("select");
					}else{
						$(this).parent().parent().removeClass("select");
					}
				});
			}
		}	
	};
	// 定义upms对象
	var upms = {
		version:"1.1",// 版本号
		upmsPagePref:"_upms_page_layer_no_",// 页面前缀
		$webObj:{},
		webObjLen:0,
		installWebObj:function($webObj){
			upms.$webObj = $webObj;
			upms.webObjLen = $webObj.length;
		},
		clearWebObj:function(){
			if (!$.isEmptyObject(upms.$webObj)){
				upms.$webObj.html("");
			}
		},
		createPageDiv:function(){
			if (!$.isEmptyObject(upms.$webObj)){
				var webChildLen = upms.$webObj.children().length;
				var $newPageDiv = $("<div id='" + upms.upmsPagePref + webChildLen + "'></div>");
				upms.$webObj.append($newPageDiv);
				return $newPageDiv;
			}
			return null;
		},
		getCurrPageDiv:function(){
			if (!$.isEmptyObject(upms.$webObj)){
				var webChildLen = upms.$webObj.children().length;
				var iCurrPage = webChildLen - 1;
				return $("div#" + upms.upmsPagePref + iCurrPage,upms.$webObj);
			}
			return null;
		},
		getPageDiv:function(num){
			if (!$.isEmptyObject(upms.$webObj) && num >= 0){
				var webChildLen = upms.$webObj.children().length;
				if (num > (webChildLen - 1)){
					num = webChildLen - 1;
				}
				return $("div#" + upms.upmsPagePref + num,upms.$webObj);
			}
			return null;
		},
		removePageDiv:function(num){
			if (!$.isEmptyObject(upms.$webObj) && num >= 0){
				var webChildLen = upms.$webObj.children().length;
				if (num > (webChildLen - 1)){
					num = webChildLen - 1;
				}
				upms.$webObj.remove("div#" + upms.upmsPagePref + num);
			}			
		},
		saveHisPageDiv:function(){
			if (!$.isEmptyObject(upms.$webObj)){
				var webChildLen = upms.$webObj.children().length;
				var iHisNo = webChildLen - 1;
				$("div#" + upms.upmsPagePref + iHisNo,upms.$webObj).css("display","none");
			}
		},
		hisGoPageDiv:function(){
			if (!$.isEmptyObject(upms.$webObj)){
				var webChildLen = upms.$webObj.children().length;
				var iCurrPage = webChildLen - 1,
					iPrefPage = webChildLen - 2;
				$("div#" + upms.upmsPagePref + iCurrPage,upms.$webObj).remove();
				$("div#" + upms.upmsPagePref + iPrefPage,upms.$webObj).css("display","block");
			}
		},
		initRandCode:function(imgID){// 初始化验证码
			$("#" + imgID).bind("click",function(){
				upms.refreshRandCode(imgID);
			});
			//upms.refreshRandCode(imgID);
		},
		refreshRandCode:function(imgID){// 刷新验证码
			var srcVal = $.trim($("#" + imgID).attr("src"));
			if (checkUtils.isNotEmptyStr(srcVal)){
				var srcArr = srcVal.split("\?");
				if (checkUtils.isNotEmptyStr(srcArr[0])){
					srcVal = srcArr[0] + "?t=" + new Date().getTime();
				}
			}
			$("#" + imgID).attr('src', srcVal);		
		},
		validateForms:function(params){// 统一校验框架
			if ($.isPlainObject(params) && !$.isEmptyObject(params)){// 判断传入参数是不是对象同时对象不能为空
				// 将对象的属性值存入到局部变量里
				var sModel = params.model,
					sErrInfoId = params.errInfoId,
					fOnTrue = params.onTrue,
					fOnFalse = params.onFalse,
					fOnSuccess = params.onSuccess,
					fOnError = params.onError,
					arrParams = params.params,
					oOnAjax = params.onAjax;				
				switch (sModel){
					case "single":// {targetId:'',targetName:'',$target:'',type:'',onCheck:'',trueDesc:'',falseDesc:'',onTrue:'',onFalse:''}
						if ($.isArray(arrParams)){// 参数对象必须为数组
							for (var i = 0,len = arrParams.length;i < len;i++){
								var obj = arrParams[i];
								var retVal = upms.validateForSingle(obj, sErrInfoId, fOnTrue, fOnFalse);
								if ("nopass" == retVal){									
									if (fOnError != undefined && $.isFunction(fOnError)){
										fOnError();
									}
									return false;
								}
							}
							if (oOnAjax != undefined && $.isPlainObject(oOnAjax) && !$.isEmptyObject(oOnAjax)){// 判断是否要执行ajax校验操作
								var isCallbackflag = oOnAjax.callbackflag;
								$.ajax({
									type:oOnAjax.type,
									url:oOnAjax.url,
									data:oOnAjax.data,
									success:function(msg){
										if (oOnAjax.success != undefined && $.isFunction(oOnAjax.success)){
											var isFlag = oOnAjax.success(msg);
											if (isFlag == true && isCallbackflag != false && fOnSuccess != undefined && $.isFunction(fOnSuccess)){
												fOnSuccess();
											}else if (isFlag == false && isCallbackflag != false && fOnError != undefined && $.isFunction(fOnError)){
												fOnError();
											}
											return true;
										}
									},
									error:function(msg){
										if (oOnAjax.error != undefined && $.isFunction(oOnAjax.error)){
											if (oOnAjax.error != undefined && $.isFunction(oOnAjax.error)){
												var isFlag = oOnAjax.error(msg);
												if (isFlag == true && isCallbackflag != false && fOnSuccess != undefined && $.isFunction(fOnSuccess)){
													fOnSuccess();
												}else if (isFlag == false && isCallbackflag != false && fOnError != undefined && $.isFunction(fOnError)){
													fOnError();
												}
												return true;
											}
										}										
									}
								});
							}
							return true;
						}
						if (fOnError != undefined && $.isFunction(fOnError)){
							fOnError();
						}
						return false;
					break;
					case "bacth":
						
					break;
					default:
						
					break;
				}
			}	
		},
		validateForSingle:function(obj,sErrInfoId,fOnTrue,fOnFalse){
			// 用局部变量存储obj的属性值
			var sTargetId = obj.targetId,
				sTargetName = obj.targetName,
				o$TargetObj = obj.$targetObj,
				oTargetObj = obj.targetObj,
				sType = obj.type,
				fOncheck = obj.onCheck,
				sTrueDesc = obj.trueDesc,
				sFalseDesc = obj.falseDesc;
			switch (sType){
				case "text":
					var $obj = upms.trans$obj(sTargetId, sTargetName,o$TargetObj,oTargetObj, sType);
					if (!$.isEmptyObject($obj)){
						if (fOncheck($obj.val()) == true){// 校验通过
							if (fOnTrue != undefined && $.isFunction(fOnTrue)){
								fOnTrue(sTrueDesc);
							}else{
								upms.validateClearMsg(sErrInfoId);
							}
							return "pass";
						}else if (fOncheck($obj.val()) == false){// 校验不通过
							if (fOnFalse != undefined && $.isFunction(fOnFalse)){
								fOnFalse(sFalseDesc);
							}else{
								upms.validateShowMsg(sErrInfoId, sFalseDesc);
							}
							return "nopass";
						}
					}else{
						return "next";
					}
				break;
				default:
					
				break;
			}
		},
		validateShowMsg:function(sErrInfoId,sFalseDesc){
			$("#" + sErrInfoId).html(sFalseDesc);
			$("#" + sErrInfoId).show();
		},
		validateClearMsg:function(sErrInfoId){
			$("#" + sErrInfoId).html("");
			$("#" + sErrInfoId).hide();
		},
		select$obj:function(sTargetId,sTargetName,sType,$currPgDiv){// 选择jQuery对象
			switch (sType){
				case "text":// 文本框以及隐藏域和密码框
					if (checkUtils.isNotEmptyStr(sTargetId)){
						return $("#" + sTargetId,$currPgDiv);
					}else if (checkUtils.isNotEmptyStr(sTargetName)){
						return $("input[type='text'][name='" + sTargetName + "']",$currPgDiv);
					}						
					return null;
				break;
				case "select":// 下拉框
					if (checkUtils.isNotEmptyStr(sTargetId)){
						return $("#" + sTargetId,$currPgDiv);
					}else if (checkUtils.isNotEmptyStr(sTargetName)){
						return $("select[name='" + sTargetName + "']",$currPgDiv);
					}
					return null;
				break;
				case "radio":// 单选框
					if (checkUtils.isNotEmptyStr(sTargetId)){
						return $("input:radio[id='" + sTargetId +  "']",$currPgDiv);
					}else if (checkUtils.isNotEmptyStr(sTargetName)){
						return $("input:radio[name='" + sTargetName +  "']",$currPgDiv);
					}
					return null;
				break;
				case "checkbox":// 多选框
					if (checkUtils.isNotEmptyStr(sTargetId)){
						return $("input:checkbox[id='" + sTargetId +  "']",$currPgDiv);
					}else if (checkUtils.isNotEmptyStr(sTargetName)){
						return $("input:checkbox[name='" + sTargetName +  "']",$currPgDiv);
					}
					return null;
				break;
				case "textarea":// 文本域 
					if (checkUtils.isNotEmptyStr(sTargetId)){
						return $("#" + sTargetId,$currPgDiv);
					}else if (checkUtils.isNotEmptyStr(sTargetName)){
						return $("textarea[name='" + sTargetName + "']",$currPgDiv);
					}
					return null;
				break;
				case "file":// 文件上传
					if (checkUtils.isNotEmptyStr(sTargetId)){
						return $("#" + sTargetId,$currPgDiv);
					}else{
						return $("input[type='file'][name='" + sTargetName + "']",$currPgDiv);
					}
					return null;
				break;
				default:
					return null;
				break;
			}				
		},
		transTo$obj:function(sTargetId,sTargetName,sType,$currPgDiv){// 取值的jQuery对象
			switch (sType){
				case "text":// 文本框以及隐藏域和密码框
					if (checkUtils.isNotEmptyStr(sTargetId)){
						return $("#" + sTargetId,$currPgDiv);
					}else if (checkUtils.isNotEmptyStr(sTargetName)){
						return $("input[type='text'][name='" + sTargetName + "']",$currPgDiv);
					}						
					return null;
				break;
				case "select":// 下拉框
					if (checkUtils.isNotEmptyStr(sTargetId)){
						return $("#" + sTargetId + " option:selected",$currPgDiv);
					}else if (checkUtils.isNotEmptyStr(sTargetName)){
						return $("select[name='" + sTargetName + "']  option:selected",$currPgDiv);
					}
					return null;
				break;
				case "radio":// 单选框
					if (checkUtils.isNotEmptyStr(sTargetId)){
						return $("input:radio[id='" + sTargetId +  "'][checked]",$currPgDiv);
					}else if (checkUtils.isNotEmptyStr(sTargetName)){
						return $("input:radio[name='" + sTargetName +  "'][checked]",$currPgDiv);
					}
					return null;
				break;
				case "checkbox":// 多选框
					if (checkUtils.isNotEmptyStr(sTargetId)){
						return $("input:checkbox[id='" + sTargetId +  "'][checked]",$currPgDiv);
					}else if (checkUtils.isNotEmptyStr(sTargetName)){
						return $("input:checkbox[name='" + sTargetName +  "'][checked]",$currPgDiv);
					}
					return null;
				break;
				case "textarea":// 文本域 
					if (checkUtils.isNotEmptyStr(sTargetId)){
						return $("#" + sTargetId,$currPgDiv);
					}else if (checkUtils.isNotEmptyStr(sTargetName)){
						return $("textarea[name='" + sTargetName + "']");
					}
					return null;
				break;
				case "file":// 文件上传
					if (checkUtils.isNotEmptyStr(sTargetId)){
						return $("#" + sTargetId,$currPgDiv);
					}else{
						return $("input[type='file'][name='" + sTargetName + "']",$currPgDiv);
					}
					return null;
				break;
				default:
					return null;
				break;
			}			
		},
		trans$obj:function(sTargetId,sTargetName,o$TargetObj,oTargetObj,sType){
			switch (sType){
				case "text":// 文本框以及隐藏域和密码框
					if (checkUtils.isNotEmptyStr(sTargetId)){
						return $("#" + sTargetId);
					}else if (checkUtils.isNotEmptyStr(sTargetName)){
						return $("input[type='text'][name='" + sTargetName + "']");
					}
					
					if ($.isEmptyObject(o$TargetObj)){
						if ($.isEmptyObject(oTargetObj)){
							return null;
						}else{
							return $(oTargetObj);
						}
					}else{
						return o$TargetObj;
					}						
					
					return null;
				break;
				case "select":// 下拉框
					
				break;
				case "radio":// 单选框
					
				break;
				case "checkbox":// 多选框
					
				break;
				case "textarea":// 文本域 
					
				break;
				default:
					return null;
				break;
			}			
		},
		transParsToObj:function(params,$currPgDiv){// 将upms自定义参数对象转化为json对象
			var retJObj = {};
			if ($.isArray(params)){
				for (var i = 0,len = params.length;i < len;i++){
					var oElem = params[i];
					if ($.isPlainObject(oElem) && !$.isEmptyObject(oElem)){
						var sName = $.trim(oElem.name),
							sType = $.trim(oElem.type),
							sTargetId = $.trim(oElem.targetid),
							sTargetName = $.trim(oElem.targetname);
						switch (sType){
							case "text":// 文本框以及隐藏域和密码框
								var $obj = upms.transTo$obj(sTargetId, sTargetName, sType, $currPgDiv);
								if (checkUtils.isNotNull($obj)){
									var tmpObj = {};
									tmpObj[sName] = $.trim($obj.val());
									$.extend(retJObj,tmpObj);
								}
							break;
							case "select":// 下拉框
								var $obj = upms.transTo$obj(sTargetId, sTargetName, sType, $currPgDiv);
								if (checkUtils.isNotNull($obj)){
									var tmpObj = {};
									tmpObj[sName] = $.trim($obj.val());
									$.extend(retJObj,tmpObj);									
								}
							break;
							case "radio":// 单选框
								var $obj = upms.transTo$obj(sTargetId, sTargetName, sType, $currPgDiv);
								if (checkUtils.isNotNull($obj)){
									var tmpObj = {};
									tmpObj[sName] = $.trim($obj.val());
									$.extend(retJObj,tmpObj);									
								}
							break;
							case "checkbox":// 多选框
								var $obj = upms.transTo$obj(sTargetId, sTargetName, sType, $currPgDiv);
								var chkarr = [],tmpObj = {};
								$obj.each(function(ind,elem){
									chkarr.push($.trim($(elem).val()));
								});
								tmpObj[sName] = chkarr.join(",");
								$.extend(retJObj,tmpObj);
							break;
							case "textarea":// 文本域 
								var $obj = upms.transTo$obj(sTargetId, sTargetName, sType, $currPgDiv);
								if (checkUtils.isNotNull($obj)){
									var tmpObj = {};
									tmpObj[sName] = $.trim($obj.val());
									$.extend(retJObj,tmpObj);									
								}
							break;
							case "file":// 文件上传
								var $obj = upms.transTo$obj(sTargetId, sTargetName, sType, $currPgDiv);
								if (checkUtils.isNotNull($obj)){
									var tmpObj = {};
									tmpObj[sName] = $.trim($obj.val());
									$.extend(retJObj,tmpObj);
								}
							break;
							default:
								
							break;
						}
						
					}
				}
			}
			return retJObj;
		},
		changeParamsToObj:function(params){// 将upms自定义参数对象转化为json对象
			var retJObj = {};
			if ($.isArray(params)){
				for (var i = 0;i < params.length;i++){
					var oElem = params[i];
					if ($.isPlainObject(oElem) && !$.isEmptyObject(oElem)){
						var sName = $.trim(oElem.name),
							sType = $.trim(oElem.type),
							sTargetId = $.trim(oElem.targetId),
							sTargetName = $.trim(oElem.targetName),
							oTargetObj = oElem.targetObj,
							o$TargetObj = oElem.$targetObj;
					
						switch (sType){
							case "text":
								var $obj = upms.trans$obj(sTargetId, sTargetName, o$TargetObj, oTargetObj, sType);
								if (!$.isEmptyObject($obj)){
									var tmpObj = {};
									tmpObj[sName] = $.trim($obj.val());
									$.extend(retJObj,tmpObj);
								}
							break;
							default:
								
							break;
						}
					}
				}					
			}
			
			return retJObj;
		},
		installOverLay:function(params){// 安装ajax遮罩
			$("body").remove("#_overlaydiv_");
			$("body").remove("#_olcontent_");			
			
			var sType = "font";
			var sFontContent = LANG.overlay_font_tip;
			// 缺省对象
			var $overLayDiv = $("<div id='_overlaydiv_' style='z-index: 1000; border: medium none; margin: 0px; padding: 0px; background-color: rgb(204, 204, 242); opacity: 0.7; filter: Alpha(opacity=70);cursor: wait; position: fixed;display:none;'></div>"),
			    $overLayContent = $("<div id='_olcontent_' style='z-index: 1001; position: fixed; padding: 0px; margin: 0px; text-align: left; color: rgb(238, 238, 238); border: medium none; background-color: rgb(238, 238, 238); cursor: auto; display:none; font-size:8px;'></div>"),
			    $overlayH1 = $("<h1></h1>"),
			    $fontObj = $("<font id='_ovlayTip_' style='color:black; font-style:微软雅黑; font-size: 14px;'></font>");
			
			if ($.isPlainObject(params) && !$.isEmptyObject(params)){
				var sOverlayBgColor = params.overlaybgcolor,
					sContentBgColor = params.contentbgcolor,
					sOpacity = params.opacity,
					oFontCss = params.fontcss,
					oImgCss = params.imgcss,
					sImgUrl = params.imgurl;
				if (checkUtils.isNotEmptyStr(params.type)){
					sType = params.type;
				}
				if (checkUtils.isNotEmptyStr(params.fontcontent)){
					sFontContent = params.fontcontent;
				}
				if (checkUtils.isNotEmptyStr(sOverlayBgColor)){
					$overLayDiv.css("background-color",sOverlayBgColor);
				}
				if (checkUtils.isNotEmptyStr(sContentBgColor)){
					$overLayContent.css("background-color",sContentBgColor);
				}
				if (checkUtils.isNotNull(sOpacity) && !isNaN(parseFloat(sOpacity))){
					$overLayDiv.css("opacity",parseFloat(sOpacity));
					var ieOpacity = parseInt(parseFloat(sOpacity) * 100);
					$overLayDiv.css("filter","Alpha(opacity=" + ieOpacity + ")");
				}
				if (sType != "img"){// 非图片 就是显示文字
					if ($.isPlainObject(oFontCss) && !$.isEmptyObject(oFontCss)){
						for (var keyCss in oFontCss){
							if (checkUtils.isNotEmptyStr(keyCss)){
								$fontObj.css(keyCss,oFontCss[keyCss]);
							}
						}
					}
				}else{// 图片
					// to do.....
				}
			}
			
			if (sType != "img"){// 非图片 就是显示文字
				$fontObj.text(sFontContent);
				$overlayH1.append($fontObj);
				$overLayContent.append($overlayH1);
				$("body").append($overLayDiv);
				$("body").append($overLayContent);
			}else{
				// to do.....
			}
		},
		showOverLay:function(){// 显示ajax遮罩效果
			var $overlaydiv = $("#_overlaydiv_"),
				$olcontentdiv = $("#_olcontent_");
			var olDivLen = $overlaydiv.length,
				olConDivLen = $olcontentdiv.length;
			if (!upms.ishasoverLay(olDivLen,olConDivLen)){
				installOverLay();
			}
			upms.hideOverLay();
			if (upms.webObjLen != 0){
				var wScrollLeft = $(window).scrollLeft(),
					wScrollTop = $(window).scrollTop(),
					ovlayWidth = upms.$webObj.outerWidth(),
					ovlayHeight = upms.$webObj.outerHeight(),
					ovlayOffSet = upms.$webObj.offset();
				
				$("#_overlaydiv_").css("height",ovlayHeight);
				$("#_overlaydiv_").css("width",ovlayWidth);
				$("#_overlaydiv_").css("left",ovlayOffSet.left - wScrollLeft);
				$("#_overlaydiv_").css("top",ovlayOffSet.top - wScrollTop);
				$("#_overlaydiv_").css("display","block");
				upms.centerOverLay($("#_overlaydiv_"),$("#_olcontent_"),wScrollLeft,wScrollTop);
				$("#_olcontent_").css("display","inline");
			}
		},
		ishasoverLay:function(olDivLen,olConDivLen){// 缺省安装
			if (olDivLen == 0 || olConDivLen == 0){
				$("body").remove("#_overlaydiv_");
				$("body").remove("#_olcontent_");
				return false;
			}
			return true;
		},
		centerOverLay:function(parentNode,msgNode,wScrollLeft,wScrollTop){// 遮罩 居中方法
			var sLeft = parentNode.offset().left + ((parentNode.outerWidth() - msgNode.outerWidth()))/2;
			var sTop = parentNode.offset().top + ((parentNode.outerHeight() - msgNode.outerHeight()))/2;
			msgNode.css("top",sTop - wScrollTop);
			msgNode.css("left",sLeft - wScrollLeft);			
		},
		hideOverLay:function(){// 隐藏ajax遮罩效果
			$("#_overlaydiv_").css("display","none");
			$("#_olcontent_").css("display","none");	
		},
		WEBMAIN:WEBMAIN,
		WEBLOGIN:WEBLOGIN,
		WEBLANG:WEBLANG,
		pagequery:pagequery,// 分页查询
		forward:forward,// 页面跳转
		history:history,// 返回操作
		griddialog:griddialog,
		handlebtn:handlebtn,
		sms:sms,
		grid:grid,
		ajaxUploadFile:ajaxUploadFile,// ajax文件上传
		cookieUtils:cookieUtils,// cookie工具类
		checkUtils:checkUtils,// 校验工具类
		upmsUtils:upmsUtils// upms框架通用工具类
	};
	
	// 将upms对象安装到window对象
	window.upms = window.UPMS = window._$ = upms;
})(window);

$.fn.setDisableControl = function(){
    $('input[type=text]').attr('readonly', 'true').attr("tabindex","-1").attr('unselectable', 'on').css("color", "black");
    $('input[type=textarea]').attr('readonly', 'readonly').attr('disabled', 'disabled');
    $('select').attr("disabled", "true");
    $('textarea').attr("disabled", "true");
    $('input[type=checkbox]').attr("disabled", "true");
    $(".button").filter('.button[button-flg="hide"]').hide(); 
};

	








