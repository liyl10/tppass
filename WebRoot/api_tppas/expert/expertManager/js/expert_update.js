	// 项目根目录
	var path="";
	
	$(function() {
		$(document).ready(function() {
			path = $("#path").text();
			
			upms.upmsUtils.initSelect("sex",$("#sex").val(), 1 , 1 , 1);
	      	upms.upmsUtils.initSelect("schooling",$("#schooling").val(), 1 , 1 , 1);
	      	upms.upmsUtils.initSelect("expertJob",$("#expertJob").val(), 1 , 1 , 1);
	      	upms.upmsUtils.initSelect("skillJob",$("#skillJob").val(), 1 , 1 , 1);
	      	upms.upmsUtils.initSelect("expertPrestige",$("#expertPrestige").val(), 1 , 1 , 1);
	      	upms.upmsUtils.initSelect("expertMajor1",$("#expertMajor1").val(), 1 , 1 , 1);
	      	upms.upmsUtils.initSelect("expertMajor2",$("#expertMajor2").val(), 1 , 1 , 1);
	      	upms.upmsUtils.initSelect("expertMajor3",$("#expertMajor3").val(), 1 , 1 , 1);
	      	upms.upmsUtils.initSelect("deptType",$("#deptType").val(), 1 , 1 , 1);
	      	upms.upmsUtils.initSelect("expertDegree",$("#expertDegree").val(), 1 , 1 , 1);
	      	upms.upmsUtils.initSelect("expertIncumbency",$("#expertIncumbency").val(), 1 , 1 , 1);
	      	upms.upmsUtils.initSelect("expertType",$("#expertType").val(), 1 , 1 , 1);
		});
	});
	
	//保存按钮事件
	$("#saveBut").click(function(){
  		// 验证下拉列表
  		var idList = new Array("sex","schooling","expertDegree","expertJob","skillJob",
  				"expertPrestige","expertMajor1","expertMajor2","expertMajor3","deptType","expertIncumbency","expertType");
  		var result2 = upms.upmsUtils.selectCheck(idList);	
  		// 输入项验证
		if(upms.upmsUtils.inputCheck() || result2){
			return;
		}
		
		var comfirmInfo = comfirmInfo = $("#comfirmUpdate").text();
		if (confirm(comfirmInfo)){
			//获取隐藏项
			var hiddenList = $("input[type='hidden']");
			//获取文本框项
			var inputList = $("input[type='text']");
			
			var actionUrl= path + "/api/expert/texpertInfoAction!saveOrUpdateExpert.action?optType=0&now="+new Date().getTime();
  			upms.showOverLay();// 打开遮罩
  			var $newPgDiv = $("#content");
  			var arrParams = [{name:"texpert.sex",targetid:"sex",type:"select"},
			              {name:"texpert.schooling",targetid:"schooling",type:"select"},
			              {name:"texpert.expertDegree",targetid:"expertDegree",type:"select"},
  			              {name:"texpert.expertJob",targetid:"expertJob",type:"select"},
  			              {name:"texpert.skillJob",targetid:"skillJob",type:"select"},
			              {name:"texpert.expertMajor1",targetid:"expertMajor1",type:"select"},
			              {name:"texpert.expertMajor2",targetid:"expertMajor2",type:"select"},
			              {name:"texpert.expertMajor3",targetid:"expertMajor3",type:"select"},
			              {name:"texpert.expertPrestige",targetid:"expertPrestige",type:"select"},
  			              {name:"texpert.deptType",targetid:"deptType",type:"select"},
  			              {name:"texpert.expertIncumbency",targetid:"expertIncumbency",type:"select"},
  			              {name:"texpert.expertType",targetid:"expertType",type:"select"},
  			              {name:"texpert.researchFindings",targetid:"researchFindings",type:"textarea"}];
  			// 添加隐藏项
			for(var i=0; i< hiddenList.length; i++){
				if(hiddenList.eq(i).attr("name") !="hidden"){
					var params = {name:hiddenList.eq(i).attr("name"),targetid:hiddenList.eq(i).attr("id"),type:"text"};
					arrParams[arrParams.length] = params;
				}
			}
			//添加文本框项
			for(var i=0; i< inputList.length; i++){
				var params = {name:inputList.eq(i).attr("name"),targetid:inputList.eq(i).attr("id"),type:"text"};
				arrParams[arrParams.length] = params;
			}
			
  			var data = upms.transParsToObj(arrParams, $newPgDiv);
  			$newPgDiv.load(actionUrl, data, function() {
  				upms.hideOverLay();
  			});
		}
  		
  	});
	
	//下一步按钮事件
	$("#nextBut").click(function(){
  		// 验证下拉列表
  		var idList = new Array("sex","schooling","expertDegree","expertJob","skillJob",
  				"expertPrestige","expertMajor1","expertMajor2","expertMajor3","deptType","expertIncumbency","expertType");
  		var result2 = upms.upmsUtils.selectCheck(idList);	
  		// 输入项验证
		if(upms.upmsUtils.inputCheck() || result2){
			return;
		}
		
		var comfirmInfo = $("#comfirmUpdate").text();
		if (confirm(comfirmInfo)){
			//设置左边菜单选中
			upms.upmsUtils.setMenu();
			//获取隐藏项
			var hiddenList = $("input[type='hidden']");
			//获取文本框项
			var inputList = $("input[type='text']");
			
			var actionUrl= path + "/api/expert/texpertInfoAction!saveOrUpdateExpert.action?optType=1&now="+new Date().getTime();
  			upms.showOverLay();// 打开遮罩
  			var $newPgDiv = $("#content");
  			var arrParams = [{name:"texpert.sex",targetid:"sex",type:"select"},
			              {name:"texpert.schooling",targetid:"schooling",type:"select"},
			              {name:"texpert.expertDegree",targetid:"expertDegree",type:"select"},
  			              {name:"texpert.expertJob",targetid:"expertJob",type:"select"},
  			              {name:"texpert.skillJob",targetid:"skillJob",type:"select"},
			              {name:"texpert.expertMajor1",targetid:"expertMajor1",type:"select"},
			              {name:"texpert.expertMajor2",targetid:"expertMajor2",type:"select"},
			              {name:"texpert.expertMajor3",targetid:"expertMajor3",type:"select"},
			              {name:"texpert.expertPrestige",targetid:"expertPrestige",type:"select"},
  			              {name:"texpert.deptType",targetid:"deptType",type:"select"},
  			              {name:"texpert.expertIncumbency",targetid:"expertIncumbency",type:"select"},
  			              {name:"texpert.expertType",targetid:"expertType",type:"select"},
  			              {name:"texpert.researchFindings",targetid:"researchFindings",type:"textarea"}];
  			// 添加隐藏项
			for(var i=0; i< hiddenList.length; i++){
				if(hiddenList.eq(i).attr("name") !="hidden"){
					var params = {name:hiddenList.eq(i).attr("name"),targetid:hiddenList.eq(i).attr("id"),type:"text"};
					arrParams[arrParams.length] = params;
				}
			}
			//添加文本框项
			for(var i=0; i< inputList.length; i++){
				var params = {name:inputList.eq(i).attr("name"),targetid:inputList.eq(i).attr("id"),type:"text"};
				arrParams[arrParams.length] = params;
			}
			
  			var data = upms.transParsToObj(arrParams, $newPgDiv);
  			$newPgDiv.load(actionUrl, data, function() {
  				upms.hideOverLay();
  			});
		}
  		
  	});