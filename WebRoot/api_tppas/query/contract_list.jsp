<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>

<script  type="text/javascript">
//详细信息
function showDetail(){
	var last=$("#last").val();
	var actionUrl= "contract_caidan.html";
	upms.showOverLay();// 打开遮罩
	upms.clearWebObj();
	var $newPgDiv = upms.createPageDiv();//$("#mainContent");
	$newPgDiv.load(actionUrl, null, function() {
		upms.hideOverLay();});
}

function showDetailPT(){
	var last=$("#last").val();
	var actionUrl= "PT_contract_caidan.html";
	upms.showOverLay();// 打开遮罩
	upms.clearWebObj();
	var $newPgDiv = upms.createPageDiv();//$("#mainContent");
	$newPgDiv.load(actionUrl, null, function() {
		upms.hideOverLay();});
}

	upms.grid.gridHover($(".t-list"));
	upms.pagequery.initpaging({// 分页
		pgbtnid:"pgbtn",
		queryformid:"searchForm",
		resultdivid:"resultDiv",
		url:""
	});
</script>
 <!--以上Flash和导航栏 -->
	<div align="center"
		style="padding: 10px; background: none repeat scroll 0 0 #FFFFFF;">
		<div style="text-align: left;">
			<div class="Servicel04">
				<div class="abuot02">
					<div class="abuot07">合同列表</div>
					<div>
          <div class=requirecolor id="errInfo"></div>
          <form id="searchForm">
            <table style="width:100%">
              <tr>
                <td style="white-space:nowrap;width:10%;text-align:right;padding:2 2 10 10;font-size:105%"> 项目名称
                  &nbsp;</td>
                <td style="white-space:nowrap;width:20%;padding:2px">&nbsp;<input type=text class="inputA">
                </td>
                <td style="white-space:nowrap;width:10%;text-align:right;padding:2 2 10 10;font-size:105%"> 支持类别
                  &nbsp;</td>
                <td style="white-space:nowrap;width:20%;padding:2px">&nbsp;<select id="accountStatus" name="accountStatus" style="width:80%">
					<option value="0">快速成长类</option>
                    <option value="1">规模发展类</option>
                    <option value="2">公共服务平台类</option>
                  </select>
                </td>
                <td style="white-space:nowrap;width:10%;text-align:right;padding:2 2 10 10;font-size:105%"> 合同状态
                  &nbsp;</td>
                <td style="white-space:nowrap;width:20%;padding:2px;"><select id="accountStatus" name="accountStatus" style="width:80%">
					<option value="0">已下发</option>
                    <option value="1">填报中</option>
                    <option value="2">合同不通过</option>
                    <option value="3">合同签订</option>
                  </select>
                  &nbsp;</td>
              </tr>
              <tr>
              <td align="right" colspan="6" style="text-align:right;padding:2px;width:10%">
              <input class="button" type="button" id="queryBtn" value="查询" />
                  &nbsp;<!--<input class="button" type="button" id="queryBtn" value="打印" />--></td>
              </tr>
            </table>
          </form>
        </div>
        <div>&nbsp; </div>
					<div style="border-bottom: 1px dashed #C9DEEE;"></div>
					<div id="resultDiv">
	<TABLE id='testtab' border=0 cellSpacing=0 cellPadding=0 width="100%" class="t-list">
        <TR>
          <Th  width="87" height="30">序号</Th>
          <Th  width="103" height="30">项目名称</Th>
          <Th  width="117" height="30">合同提交日期</Th>
          <Th  width="102">支持类别</Th>
          <Th  width="102" height="30">合同状态</Th>
          <Th  width="152" height="30">操作</Th>
        </TR >
        <tr align="middle">
          <td ><div align="left">1</div></td>
          <td ><div align="left">项目名称1</div></td>
          <td ><div align="left">2012-03-15</div></td>
          <td ><div align="left">产业集群发展类</div></td>
          <td ><div align="left">已下发</div></td>
          <td ><div align="center"><a href="javascript: void(0);" onclick="showDetail()">详细</a></div></td>
        </tr>
        
        <TR align=middle>
          <TD ><div align="left">2</div></TD>
          <TD ><div align="left">项目名称2</div></TD>
          <TD ><div align="left">2012-03-15</div></TD>
          <TD ><div align="left">公共服务平台类</div></TD>
          <TD ><div align="left">填报中</div></TD>
          <TD ><div align="center"><a href="javascript: void(0);" onclick="showDetailPT()">详细</a></div></TD>
        </TR>
		<TR align=middle>
          <TD ><div align="left">3</div></TD>
          <TD ><div align="left">项目名称3</div></TD>
          <TD ><div align="left">2012-03-15</div></TD>
          <TD ><div align="left">产业集群发展类</div></TD>
          <TD ><div align="left">合同不通过</div></TD>
          <TD ><div align="center"><a href="javascript: void(0);" onclick="showDetail()">详细</a></div></TD>
        </TR>
		<TR align=middle>
          <TD ><div align="left">4</div></TD>
          <TD ><div align="left">项目名称4</div></TD>
          <TD ><div align="left">2011-03-15</div></TD>
          <TD ><div align="left">产业集群发展类</div></TD>
          <TD ><div align="left">合同签订</div></TD>
          <TD ><div align="center"><a href="javascript: void(0);" onclick="showDetail()">详细</a></div></TD>
        </TR>
 </TABLE>
 		<div class="page">
			<div class="pgtotal">
				共<em>2</em>条记录;
			</div>
			<div class="pgtotal">
				总共<em>1</em>页
			</div>
	
			<span> 
				跳转至第 
				<input type="text" id="goPageNo" name="goPageNo" style="width: 30px; height: 16px;"
				onkeyup='this.value=this.value.replace(/[^0-9]\D*$/,"")' autocomplete="off" />
				 页 
				 <input type="button" class="button" style="margin:-0.2em" value="确定" id="goBtn" name="goBtn" />
			</span> 
			<span id="pgbtn"></span>
			<div class="clear"></div>
		</div>
					</div>
					<!-- 查询结果列表E -->
</div>
</div>
</div>
</div>
