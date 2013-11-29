/**************************
@FileType	:	JavaScript
@Filename	:	filename.js
@Update		:	2013年10月18日
**************************/
//项目申报信息查看
function viewProjectReportInfo(projectId, action) {
	var path = $("#path").text();
	// 访问路径替换
	var apiaction = action.replace(/\/server\//,"/api/");
	var actionUrl= path + apiaction + "?projectId=" + projectId + "&now="+ new Date().getTime();
	var xpwidth=window.screen.width-10;
	var xpheight=window.screen.height-35;
	window.open(actionUrl,'','resizable=yes,directories=no,top=0,scrollbars=yes,left=0,width='+xpwidth+',height='+xpheight);
}

//企业信息查看
function viewCompanyInfo(projectId) {
	var path = $("#path").text();
	// 访问路径替换
	var apiaction = "/api/report/companyInfoAction!getCompanyInfo.action";
	var actionUrl= path + apiaction + "?projectId=" + projectId + "&now="+ new Date().getTime();
    var xpwidth=window.screen.width-10;
    var xpheight=window.screen.height-35;
	window.open(actionUrl,'','resizable=yes,directories=no,top=0,scrollbars=yes,left=0,width='+xpwidth+',height='+xpheight);
}