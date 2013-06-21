<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="tb_productcost" style="padding: 5px; height: auto">
	<div style="margin-bottom: 5px">
<a href="#" class="easyui-linkbutton" iconCls="icon-money" plain="true" onclick="extraCost();">额外支出添加</a>
		类型：<select id="search_isProof">
			<option value="">全部</option>
			<option value="0">产品</option>
			<option value="1">样品</option>
		</select>&nbsp;
		加工单号：<input id="search_productNo" style="width: 120px;"/> &nbsp;
		名称：<input id="search_productName" style="width:100px"/>&nbsp;
		<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchProductCost();">查询</a>
	</div>
</div>