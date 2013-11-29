// 工程根目录
var path="";

$(function() {
	    $(document).ready(function() {
			path = $("#path").text();
	    	$("select").each(function () {
	    		$(this).prepend("<option value=''>----请选择----</option>");
	    		$(this).attr("value",'');
	    		$(this).chosen();
	    	});
	    });
	});

//保存单位信息
$("#btnSave").bind("click", function() {
	var actionUrl=path +"/api/reportingunit/TreportingUnitAction!unitInfoSave.action";
	var val = confirm($("#comfirmSave").text());
	 if (!val) {
	    return; 
	 }
	upms.showOverLay();// 打开遮罩
	var $newPgDiv = $("#mainContent");

	var arrParams = 
		[{name : "",targetid : "",type : "text"}, 
		 {name : "",targetid : "",type : "select"}];
	var data = upms.transParsToObj(arrParams, $newPgDiv);
	$newPgDiv.load(actionUrl, data, function() {
		upms.hideOverLay();
	});
});

//返回申报单位管理画面
function goBack(){
		var actionUrl= path + "/api/reportingunit/TreportingUnitAction!list.action?now="+new Date().getTime();
		upms.showOverLay();// 打开遮罩
		upms.clearWebObj();
		var $newPgDiv = upms.createPageDiv();//$("#mainContent");
		$newPgDiv.load(actionUrl, null, function() {
			upms.hideOverLay();});
	}

//下拉列表联动
var secondId = "";
function getSecondData(value, value1){
    var pItemId=$('#'+ value1).val();
   
   	if(value1.substr(value1.length -1) == "3"){
    	$("#error" + value1).remove();
    }
   	else{
   		$("#error" + value1).remove();
   	}
    
    secondId = value;
    $.ajax({
       url:path + "/api/reportingunit/TreportingUnitAction!getSecondData.action",
       type:'post',
       dataType:'json',
       data:{pitemId:pItemId},
       success:setSecondData
    });
}

//下拉列表联动
function setSecondData(json){
    var data=json.backStr;
    var datas="";
    if(data!=""){
       datas=data.split(",");
    }
    var tempStr = secondId.substr(0,secondId.length-1);
    var tempIndex = parseInt(secondId.substr(secondId.length-1)) +1;
    for(;tempIndex < 5; tempIndex ++){
    	var s_root1=$("#" +tempStr + tempIndex);
    	if(s_root1.length > 0){
    		s_root1.find("option").remove();
    	    s_root1.append("<option value=''>----请选择----</option>");
    	    s_root1.trigger("liszt:updated");
    	}
    }
    var s_root=$("#" +secondId);
    s_root.find("option").remove();
    s_root.append("<option value=''>----请选择----</option>");
    for(var i=0;i<datas.length;i++){
    	 s_root.append("<option value='"+datas[i]+"'>"+datas[i+1]+"</option>");
       	 i++;
    }
    s_root.trigger("liszt:updated");
}

//股权结构新增行
var row_count = 0;
function addEquity()
{
	var table1;
	// 行ID数
	var num = 0;
	if(row_count == 0){
		row_count = $("#equityList tr").length -2;
	}
	if(row_count <= 0){
		if(row_count < 0)
		{
			table1 = $("#equityTr0");
			num = 1;
		}
		else
		{
			table1 = $("#equityTr0");
			num = row_count + 1;
		}
	}
	else{
		// 取得最后一行
		for(var i=row_count;i> -1 ;i--){
			if($("#equityTr" + i).length > 0){
				table1 = $("#equityTr" + i);
				break;
			}
		}
		num = row_count + 1;
	}
	// 设置行ID
	var row = $("<tr id='equityTr"+num+"'></tr>");
		
	// 股东名称
	var td1 = $("<td height='25' align='center'></td>");
	var div1=$("<div align='left'></div>");
	div1.append($("<INPUT class='inputA' style='width:13.5em' type='text'"
				+ "id='GDMC" + num + "' name='equityList[" + num + "].GDMC' onblur=blurText(this,'股东名称',1,0); onfocus=focusText(this); maxlength='20' />"));
	td1.append(div1);
	
	//投资者经济形态
	var td2 = $("<td height='25' align='center'></td>");
	var div2=$("<div align='left'></div>");
	div2.append($("<s:select list=#{'1':'自然人','2':'国有','3':'集体','4':'外贸','5':'合营','6':'股份制'}"
				+ " id='TZZJJXT" + num +"' name='equityList[" + num + "].TZZJJXT' style='width:14.5em;'></s:select>"));
	td2.append(div2);
	
	//法人代码或身份证
	var td3 = $("<td height='25' align='center'></td>");
	var div3=$("<div align='left'></div>");
	div3.append($("<INPUT class='inputA' style='width:13.5em;' type='text'"
				+ "id='FRDB" + num + "' name='equityList[" + num + "].FRDB' onblur=blurText(this,'法人代表',1,0); onfocus=focusText(this); maxlength='20'/>"));
	td3.append(div3);
	
	//上市公司
	var td4 = $("<td height='25' align='center'></td>");
	td4.append($("<s:radio list=#{'1':'是','0':'否'} id='SSGS" + num + "' name='equityList[" + num + "].SSGS' listKey='key' listValue='value' label='IsSpecial'></s:radio>"));
	
	//海外公司
	var td5 = $("<td height='25' align='center'></td>");
	td5.append($("<s:radio list=#{'1':'是','0':'否'} id='HWGS" + num + "' name='equityList[" + num + "].HWGS' listKey='key' listValue='value' label='IsSpecial'></s:radio>"));
	
	//所占股份
	var td6 = $("<td height='25' align='center'></td>");
	var div6=$("<div align='left'></div>");
	div6.append($("<INPUT class='inputA' style='width:13.5em;' type='text'"
				+ "id='SZGF" + num + "' name='equityList[" + num + "].SZGF' onblur=blurText(this,'所占股份',1,0); onfocus=focusText(this); maxlength='3'/>"));
	td6.append(div6);
	//投资方式
	var td7 = $("<td height='25' align='center'></td>");
	var div7=$("<div align='left'></div>");
	div7.append($("<INPUT class='inputA' style='width: 13.5em;' type='text'"
				+ "id='TZFS" + num + "' name='equityList[" + num + "].TZFS' onblur=blurText(this,'投资方式',1,0); onfocus=focusText(this); maxlength='20'/>"));
	td7.append(div7);
	
	//删除
	var td8 = $("<td align='center' height='25' class='t-list'></td>");
	td8.append($("<div><a href='javascript: void(0);'  class='line single' onclick='deleteEquity(this,0)'>删除</a></div>"));
	
	row.append(td1);
	row.append(td2);
	row.append(td3);
	row.append(td4);
	row.append(td5);
	row.append(td6);
	row.append(td7);
	row.append(td8);
	table1.after(row);
	row_count++;
}

//股权结构删除行
var delEquityIdCount = 0;
function deleteEquity(thisRow,flag,equityingUseID)
{
	if (confirm($("#comfirmDelete").text())){
		   if(flag == 1){
			delEquityIdCount++;
		}  
		$(thisRow).parent().parent().parent().remove();
	}else{
		return false;
	}
}

