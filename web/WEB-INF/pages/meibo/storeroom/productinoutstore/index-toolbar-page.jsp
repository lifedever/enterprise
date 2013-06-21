<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="tb_productinoutstore" style="padding: 5px; height: auto">
	<div style="margin-bottom: 5px">
		操作类型：
		<select id="search_operation" style="width: 55px;">
			<option value="">全部</option>
			<option value="0">入库</option>
			<option value="1">出库</option>
		</select>&nbsp;
		订单号：<input id="search_orderNo" style="width: 120px;"/> &nbsp;
		成品名称：<input id="search_name" style="width: 85px;"/>&nbsp;
		记录人：<input id="search_recorder" style="width: 85px;" />&nbsp;
		<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchInOutstore();">查询</a>
	</div>
</div>