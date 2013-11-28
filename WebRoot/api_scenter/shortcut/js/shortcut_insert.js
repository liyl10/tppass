/**
 * @comment 用户快捷方式添加页面对应的js
 * @author dulei(dulei@hopsun.cn)
 * @date 2013-01-10
 * @version 1.0
 */
//ztree 设置信息
var setting = {
	check: {
		enable: true
	},
	data: {
		simpleData: {
			enable: true
		}
	},
	callback: {
		beforeCheck: beforeCheck,
		onCheck: onCheck
	}
};

var code;
//选择设置信息
function setCheck() {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
	type = { "Y":"", "N":""};
	zTree.setting.check.chkboxType = type;
}

function showCode(str) {
	if (!code) code = $("#code");
	code.empty();
	code.append("<li>"+str+"</li>");
}

//选中前判断是否可以选中
function beforeCheck(treeId, treeNode) {
	return (treeNode.doCheck !== false);
}

//快捷方式添加或删除
function onCheck(e, treeId, treeNode) {
	$.get("../api/shortcut_insertOrDeleteShortcut.action",{ ids: treeNode.id, isinsert: treeNode.checked,stamp: new Date().getTime()},
	function(data){});
}