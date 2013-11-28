<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/config/tld/tag.tld"%>
﻿<div align="center" style="padding: 10px;background: none repeat scroll 0 0 #FFFFFF;">
  <div style="text-align: left;">
    <div class="Servicel04">
      <div class="abuot02">
        <div class="abuot07">专家评审查询</div>
        <div>
          <div class=requirecolor id="errInfo"></div>
          <form id="searchForm">
            <table style="width:100%">
              <tr>
                <td style="white-space:nowrap;width:10%;text-align:right;padding:2 2 10 10;font-size:105%"> 专家名称
                  &nbsp;</td>
                <td style="white-space:nowrap;width:20%;padding:2px">&nbsp;<input type=text class="inputA">
                </td>
                <td style="white-space:nowrap;width:10%;text-align:right;padding:2 2 10 10;font-size:105%"> 专家类别
                  &nbsp;</td>
                <td style="white-space:nowrap;width:20%;padding:2px">&nbsp;<select id="accountStatus" name="accountStatus" style="width:80%">
					<option value="0">全部</option>
                    <option value="1">高等院校</option>
                    <option value="2">研究机构</option>
                  </select>
                </td>
              </tr>

              <tr>
              <td align="right" colspan="4" style="text-align:right;padding:2px;width:10%">
              <input class="button" type="button" id="queryBtn" value="查询" />
                  &nbsp;<!--<input class="button" type="button" id="queryBtn" value="打印" />--></td>
              </tr>
            </table>
          </form>
        </div>
        <div>&nbsp; </div>
        <!-- 查询结果列表S -->
        <div id="resultDiv">
          <table width="100%" border="0" cellspacing="0" cellpadding="0" class="t-list">
            <tr align="center">
              <th>序号</th>
              <th>项目名称</th>
              <th>申请单位</th>
              <th>项目负责人</th>
              <th>项目年度</th>
              <th>申报时间</th>
              <th>项目分类</th>
              <th>项目所属领域</th>
              <th>申请单位性质</th>
              <th>申请单位所属区域</th>
              <th>是否立项</th>
              <th>验收状态</th>
            </tr>
            <tr>
              <td>1</td>
              <td>项目名称1</td>
              <td>申请单位1</td>
              <td>项目负责人1</td>
              <td>2013年</td>
              <td>2013-03-15</td>
              <td>快速成长类</td>
              <td>软件开发类</td>
              <td>科研院所</td>
              <td>雁塔区</td>
              <td>是</td>
              <td>已经验收</td>
            </tr>
            <tr>
              <td>2</td>
              <td>项目名称2</td>
              <td>申请单位2</td>
              <td>项目负责人2</td>
              <td>2013年</td>
              <td>2013-03-15</td>
              <td>快速成长类</td>
              <td>软件开发类</td>
              <td>科研院所</td>
              <td>雁塔区</td>
              <td>是</td>
              <td>已经验收</td>
            </tr>
            <tr>
              <td>3</td>
              <td>项目名称3</td>
              <td>申请单位3</td>
              <td>项目负责人3</td>
              <td>2013年</td>
              <td>2013-03-15</td>
              <td>快速成长类</td>
              <td>软件开发类</td>
              <td>科研院所</td>
              <td>雁塔区</td>
              <td>是</td>
              <td>已经验收</td>
            </tr>
          </table>
          <div class="page">
            <div class="pgtotal"> 共<em>2</em>条记录; </div>
            <div class="pgtotal"> 总共<em>1</em>页 </div>
            <span> 跳转至第
            <input type="text" id="goPageNo" name="goPageNo" style="width: 30px; height: 16px;"
							onkeyup='this.value=this.value.replace(/[^0-9]\D*$/,"")' autocomplete="off" />
            页
            <input type="button" class="button" style="margin:-0.2em" value="确定" id="goBtn" name="goBtn" />
            </span> <span id="pgbtn"></span>
		 </div>
        </div>
        <!-- 查询结果列表E -->
      </div>
    </div>
  </div>
</div>
<script type="text/javascript">
	upms.grid.gridHover($(".t-list"));
	upms.pagequery.initpaging({// 分页
		pgbtnid:"pgbtn",
		queryformid:"searchForm",
		resultdivid:"resultDiv",
		url:""
	});
</script>
