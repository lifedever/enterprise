<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="tb_finishedfee" style="padding: 5px; height: auto">
	<div style="margin-bottom: 5px">
		<a href="#" class="easyui-linkbutton" iconCls="icon-money" plain="true" onclick="gathering();">收款</a>
		类型：<select id="search_isProof">
			<option value="">全部</option>
			<option value="1">产品</option>
			<option value="0">样品</option>
		</select>&nbsp;
		订单编号：<input id="search_orderNo" style="width: 120px;"/> &nbsp;
		客户姓名：<input id="search_customerName" style="width:100px"/>&nbsp;
		<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchFinishedFee();">查询</a>
	</div>
</div>