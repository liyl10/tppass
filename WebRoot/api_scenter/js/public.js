// JavaScript Document
//鼠标移上tr变色
$(document).ready(function () {
	$(".list_table tr").addClass("hover");
	$(".list_table tr").mouseover(function () {  
         //如果鼠标移到class为stripe的表格的tr上时，执行函数
		$(this).removeClass("out");
		$(this).removeClass("hover");
		$(this).addClass("over");
	});
	$(".list_table tr").mouseout(function () {
                //给这行添加class值为over，并且当鼠标一出该行时执行函数
		$(this).removeClass("over");
		$(this).removeClass("hover");
		$(this).addClass("out");
	});  //移除该行的class
});

//是否为空
function ifnull(val) {
	var renull = new RegExp(/^[ ]*$/);
	if (renull.test(val) || val == null || val == undefined) {
		return true;
	} else {
		return false;
	}
}

function forbidBackSpace(e) {         
            var ev = e || window.event; //获取event对象      
            var obj = ev.target || ev.srcElement; //获取事件源        
            var t = obj.type || obj.getAttribute('type'); //获取事件源类型     
            //获取作为判断条件的事件类型         
             var vReadOnly = obj.readOnly;            
             var vDisabled = obj.disabled;            
             //处理undefined值情况            
              vReadOnly = (vReadOnly == undefined) ? false : vReadOnly;            
              vDisabled = (vDisabled == undefined) ? true : vDisabled;            
              //当敲Backspace键时，事件源类型为密码或单行、多行文本的，             
              //并且readOnly属性为true或disabled属性为true的，则退格键失效             
              var flag1 = ev.keyCode == 8 && (t == "password" || t == "text" || t == "textarea") && (vReadOnly == true || vDisabled == true);            
              //当敲Backspace键时，事件源类型非密码或单行、多行文本的，则退格键失效             
              var flag2 = ev.keyCode == 8 && t != "password" && t != "text" && t != "textarea";            
              //判断            
               if (flag2 || flag1) return false;        
              }      
                //禁止后退键 作用于Firefox、Opera        
              document.onkeypress = forbidBackSpace;       
               //禁止后退键  作用于IE、Chrome        
              document.onkeydown = forbidBackSpace;
	