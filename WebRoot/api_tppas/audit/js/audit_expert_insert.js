

//项目根目录
var path="";

$(function() {
	$(document).ready(function() {
		path = $("#path").text();
	    upms.upmsUtils.initSelect("sex","",1,1,0);
	    
	    upms.upmsUtils.initSelect("schooling","",1,1,0);
	    
	    upms.upmsUtils.initSelect("expertDegree","",1,1,0);
	    
	    //upms.upmsUtils.initSelect("expertJob","",1,1,1);
	    
	    upms.upmsUtils.initSelect("skillJob","",1,1,1);
	    
	    upms.upmsUtils.initSelect("expertMajor1","",1,1,0);
	    
	    upms.upmsUtils.initSelect("expertMajor2","",1,1,0);
	    
	    upms.upmsUtils.initSelect("expertMajor3","",1,1,0);
	    
	    upms.upmsUtils.initSelect("expertPrestige","",1,1,0);
	    
	    upms.upmsUtils.initSelect("deptType","",1,1,0);
	    
	    upms.upmsUtils.initSelect("expertIncumbency","",1,1,1);
	    
	    upms.upmsUtils.initSelect("expertType","",1,1,1);
	});
});