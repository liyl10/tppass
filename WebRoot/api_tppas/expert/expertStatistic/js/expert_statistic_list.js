// 项目根目录
var path="";

$(document).ready(function(){
	path = $("#path").text();
	if($("#pageCount").val() == 0){
		$("#printBtn").attr("disabled",true);
	}
	else{
		$("#printBtn").removeAttr("disabled");
	}
}); 



// 分页初始化
upms.grid.gridHover($(".t-list"));
upms.pagequery.initpaging({// 分页
	pgbtnid:"pgbtn",
	queryformid:"searchForm",
	resultdivid:"resultDiv",
	url:path + "/api/expert/texpertAction!getExpertStatisticList.action?date=" + new Date().getTime()
});