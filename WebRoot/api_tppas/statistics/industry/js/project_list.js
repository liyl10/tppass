
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
		 if($("#count").val() == 0){
			 $("#exportBtn").attr("disabled",true);
		 }
		 else {
			 $("#exportBtn").removeAttr("disabled");
		 }
	});
});

upms.grid.gridHover($(".t-list"));
upms.pagequery.initpaging({// 分页
	pgbtnid:"pgbtn",
	queryformid:"searchForm",
	resultdivid:"resultDiv",
	url:path +"/api/industry/industryAction!getProjectList.action?now="+new Date().getTime()
});