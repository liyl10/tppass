/**
 * @comment 管理中心左边页面对应的js
 * @author dulei(dulei@hopsun.cn)
 * @date 2013-01-10
 * @version 1.0
 */
 
var path = $("#path").val();
 
//时间输出方法
function nowdate(){
	var day="";
	var month="";
	var ampm="";
	var ampmhour="";
	var myweekday="";
	var year="";
	var nowdate = "";
	mydate=new Date();
	myweekday=mydate.getDay();
	mymonth=mydate.getMonth()+1;
	myday= mydate.getDate();
	year= mydate.getFullYear();
	if(myweekday == 0)
	weekday=" 星期日 ";
	else if(myweekday == 1)
	weekday=" 星期一 ";
	else if(myweekday == 2)
	weekday=" 星期二 ";
	else if(myweekday == 3)
	weekday=" 星期三 ";
	else if(myweekday == 4)
	weekday=" 星期四 ";
	else if(myweekday == 5)
	weekday=" 星期五 ";
	else if(myweekday == 6)
	weekday=" 星期六 ";
	nowdate = year+"年"+mymonth+"月"+myday+"日 "+weekday;
	document.write(nowdate);
}
	//时间
	nowdate();

	/**
	 *树展示
	**/
	var str="";
		var setting = {
		async: {
			enable: true,
			url: getUrl
		},
		check: {
			enable: false
		},
		data: {
			simpleData: {
				enable: true
			}
		},
		view: {
			expandSpeed: "fast"
		},
		callback: {
			beforeExpand: beforeExpand,
			onAsyncSuccess: onAsyncSuccess,
			onAsyncError: onAsyncError,
			onClick: onClick
			 
		}
	};
		
	var log, className = "dark",
	startTime = 0, endTime = 0, perCount = 100, perTime = 100;
	
	//获取 ztree 异步加载utl
	function getUrl(treeId, treeNode) {
		var param = "authId=" + treeNode.id;
		return "../api/login_getChildList.action?" + param;
	}
	
	//节点展开之前
	function beforeExpand(treeId, treeNode) {
		if (!treeNode.isAjaxing) {
			startTime = new Date();
			treeNode.times = 1;
			ajaxGetNodes(treeNode, "refresh");
			return true;
		} else {
			alert("节点正在加载，请稍后...");
			return false;
		}
	}
	
	//加载成功后
	function onAsyncSuccess(event, treeId, treeNode, msg) {
		if (!msg || msg.length == 0) {
			return;
		}
		var zTree = $.fn.zTree.getZTreeObj("tree"),
		totalCount = treeNode.count;
		if (treeNode.children.length < totalCount) {
			setTimeout(function() {ajaxGetNodes(treeNode);}, perTime);
		} else {
			treeNode.icon = "";
			zTree.updateNode(treeNode);
			zTree.selectNode(treeNode.children[0]);
			endTime = new Date();
			// var usedTime = (endTime.getTime() - startTime.getTime())/1000;
			className = (className === "dark" ? "":"dark");
			
		}
	}
	
	//加载失败
	function onAsyncError(event, treeId, treeNode, XMLHttpRequest, textStatus, errorThrown) {
		var zTree = $.fn.zTree.getZTreeObj("tree");
		alert("获取数据异常，登陆超时，请重新登录！");
		window.parent.location.reload(); //重新加载页面
		treeNode.icon = "";
		zTree.updateNode(treeNode);
	}
	
	//ajax 加载是的图片
	function ajaxGetNodes(treeNode, reloadType) {
		var zTree = $.fn.zTree.getZTreeObj("tree");
		if (reloadType == "refresh") {
			treeNode.icon = "../api_scenter/js/zTree/css/zTreeStyle/img/loading.gif";
			zTree.updateNode(treeNode);
		}
		zTree.reAsyncChildNodes(treeNode, reloadType, true);
	}
	
	//加载用时
	function getTime() {
		var now= new Date(),
		h=now.getHours(),
		m=now.getMinutes(),
		s=now.getSeconds(),
		ms=now.getMilliseconds();
		return (h+":"+m+":"+s+ " " +ms);
	}
		
	/**
	 *	执行zTree封装的异步加载后，对返回数据的过滤函数。
	**/
	function ajaxDataFilter(treeId, parentNode, childNodes) {
	if(childNodes.authlist)	 {
			childNodes=childNodes.authlist;   //获取返回值
			 return childNodes;
		}else if(childNodes == 1){
			alert("尚未登录或登陆超时，请重新登陆后使用！");
			window.location.href = "../api/login_index.action";
		}else{
			alert("子节点数据格式不正确。");	
			return false;	 
		}
	};
		
	/* 点击事件*/
	function onClick(event, treeId, treeNode, clickFlag) {
		var zTree = $.fn.zTree.getZTreeObj("tree");
		zTree.expandNode(treeNode);
		var openType = treeNode.openType;
		$.get("../api/login_getUrlByCodeAndUser.action",{ authid: treeNode.id },
		 function(data){
			if(data != "0"){
				var url = data;
				if(url !=null && url != 'undefined' && url != '' && url !='null'){
					if(openType){
						if(url.indexOf('http://') != -1){
							window.open(url);
						}else{
							window.open(".."+url);
						}
					}else{
						if(url.indexOf('http://') != -1){
							window.parent.frame_content.location.href=url;
						}else{
							window.parent.frame_content.location.href= ".."+url;
						}
					}
				}else{
					return false;
				}
			}
 		});
		
	}