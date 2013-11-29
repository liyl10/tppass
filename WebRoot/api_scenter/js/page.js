
/**
 * 上一页、下一页、首页、尾页 跳转js
 * @param pageNumber 当前页码
 */
function _gotoPage(pageNumber)
{
	var myform=document.getElementById("myform");
	document.getElementById("pageNum").value=pageNumber;
	var page_size=document.getElementById("page_size").value;
	var r =/^[0-9]*[1-9][0-9]*$/; //正整数 
	if(!r.test(page_size))
	{
		alert("请输入正整数！");
		return;
	}
	myform.submit();
}
/**
 * 跳转分页js
 */
function skip()
{
	var myform=document.getElementById("myform");
	document.getElementById("pageNum").value=pageNumber;
	var page_size=document.getElementById("page_size").value;
	var r =/^[0-9]*[1-9][0-9]*$/; //正整数 
	if(!r.test(page_size))
	{
		alert("每页条数仅能为正整数！");
		return;
	}
	var pageNumber=document.getElementById("pageNumber").value;
	if(!r.test(pageNumber))
	{
		alert("跳转页数仅能为正整数！");
		return;
	}
	document.getElementById("pageNum").value=pageNumber;
	myform.submit();
}

function editstate()
{
	var myform=document.getElementById("myform");
	document.getElementById("pageNum").value=1;
	myform.submit();
}

$(function(){
	$(document).keypress(function (event){//keydown
		var keycode = event.which;  
		if (keycode == 13){   
		   document.getElementById("_goPage").click();
		}  
	});
});