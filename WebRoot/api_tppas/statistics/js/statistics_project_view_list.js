
// 工程根目录
var path="";

$(function() {
	$(document).ready(function() {
		 path = $("#path").text();
	});

	// 柱图
	var params = new Array();
	var reportYearList = $("input[id^='reportYear']");
	var projectTotalList = $("input[id^='projectTotal']");
	var noViewProjectTotalList = $("input[id^='noViewProjectTotal']");
	var noPassProjectList = $("input[id^='noPassProject']");
	var noAcceptanceProjectList = $("input[id^='noAcceptanceProject']");
	var passAcceptanceProjectList = $("input[id^='passAcceptanceProject']");
	for(var i=0; i<reportYearList.length;i++){
		var datas = new Array(parseInt(projectTotalList.eq(i).val()),parseInt(noViewProjectTotalList.eq(i).val()),parseInt(noPassProjectList.eq(i).val()),parseInt(noAcceptanceProjectList.eq(i).val()),parseInt(passAcceptanceProjectList.eq(i).val()));
		var param = {name:reportYearList.eq(i).val(), data:datas};
		params[params.length] = param;
	}
	if($('#containerColumn').length>0){
	    $('#containerColumn').highcharts({
	        chart: {
	            type: 'column'
	        },
	        title: {
	            text: '项目评审通过率统计柱形图'
	        },
	        credits: {
	            enabled: false
	       },
	        xAxis: {
	            categories: [
	                '项目总数',
	                '未初审',
	                '未通过',
	                '已通过初审未验收',
	                '已通过已验收'
	            ]
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: '项目数 (个)'
	            }
	        },
	        tooltip: {
	            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
	            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
	                '<td style="padding:0"><b>{point.y:.1f} 个</b></td></tr>',
	            footerFormat: '</table>',
	            shared: true,
	            useHTML: true
	        },
	        plotOptions: {
	            column: {
	                pointPadding: 0.2,
	                borderWidth: 0
	            }
	        },
	        
	        series: params
	    });
	}
	// 饼图
	if($('#containerPie').length > 0){
		var projectTotal = projectTotalList.eq(0).val();
		var noViewProjectTotal = noViewProjectTotalList.eq(0).val();
		var noPassProject = noPassProjectList.eq(0).val();
		var noAcceptanceProject = noAcceptanceProjectList.eq(0).val();
		var passAcceptanceProject = passAcceptanceProjectList.eq(0).val();
		
		if(noPassProjectList.eq(0).length = 0){
			var noPassProjectm = 0;
		}else{
			noPassProjectm = (noPassProject / projectTotal) * 100; 
		}
		if(noViewProjectTotalList.eq(0).length = 0){
			var noViewProjectTotalm = 0;
		}else{
			noViewProjectTotalm = (noViewProjectTotal / projectTotal) * 100; 
			
		}
		if(noAcceptanceProjectList.eq(0).length = 0){
			var noAcceptanceProjectm = 0;
		}else{
			noAcceptanceProjectm = (noAcceptanceProject / projectTotal) * 100; 
			
		}
		if(passAcceptanceProjectList.eq(0).length = 0){
			var passAcceptanceProjectm = 0;
		}else{
			passAcceptanceProjectm = (passAcceptanceProject / projectTotal) * 100; 
			//alert(passAcceptanceProjectm);
		}
		
	    $('#containerPie').highcharts({
	        chart: {
	            plotBackgroundColor: null,
	            plotBorderWidth: null,
	            plotShadow: false
	        },
	        title: {
	            text: '项目评审通过率统计饼图'
	        },
	        credits: {
                enabled: false
           },
	        tooltip: {
	    	    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	        },
	        plotOptions: {
	            pie: {
	                allowPointSelect: true,
	                cursor: 'pointer',
	                dataLabels: {
	                    enabled: true,
	                    color: '#000000',
	                    connectorColor: '#000000',
	                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
	                }
	            }
	        },
	        series: [{
	            type: 'pie',
	            name: '项目数份额',
	            data: [
	                ['未初审',  noViewProjectTotalm],
	                ['未通过',  noPassProjectm],
	                ['已通过初审未验收', noAcceptanceProjectm],
	                ['已通过已验收', passAcceptanceProjectm]
	            ]
	        }]
	    });
	}
});

/*//分页初始化
upms.grid.gridHover($(".t-list"));
upms.pagequery.initpaging({// 分页
	pgbtnid:"pgbtn",
	queryformid:"searchForm",
	resultdivid:"resultDiv",
	url:path + "/api/report/tprojectApplicationAction!getProjectViewList.action?date=" + new Date().getTime()
});*/
function showDetail(tcontractId){
	var actionUrl=path + "/api/contract/tcontract!importTcontract.action?tcontractId="+ tcontractId +"&now="+ new Date().getTime();
	upms.showOverLay();// 打开遮罩
	upms.clearWebObj();
	var $newPgDiv = upms.createPageDiv();//$("#mainContent");
	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();});
}	


function showBkd(tcontractId){
	var actionUrl=path + "/api/contract/tappropriationSingle!init.action?tcontractId="+ tcontractId 
					   + "&mainFlag=" + "1" 
						+"&now="+ new Date().getTime();
	upms.showOverLay();// 打开遮罩
	upms.clearWebObj();
	var $newPgDiv = upms.createPageDiv();//$("#mainContent");
	var data = {};
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();});
}	
