<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="tb_buyrequest" style="padding: 5px; height: auto">
	<div style="margin-bottom: 5px">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="auditBuyrequest();">审批</a>
		请购单号：<input id="search_buyrequestno" style="width: 100px" class="easyui-validatebox" />&nbsp;
		请购人：<input id="search_requester" style="width: 85px;"></input> 
		采购人：<input id="search_buyer" style="width: 85px;"></input>
		采购时间：<input id="buyStartDate" name="buyStartDate" 
						style="width: 85px;" class="easyui-datebox" /> --
				 <input id="buyEndDate" name="buyEndDate" style="width: 85px;" 
						class="easyui-datebox" />&nbsp;
		<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchCommodity();">查询</a>
	</div>
</div>