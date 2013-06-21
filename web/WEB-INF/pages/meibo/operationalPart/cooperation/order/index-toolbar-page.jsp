<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="tb_cooperationOrder" style="height: 55px;">
<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addVehicle();">添加车辆</a>
<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addLogistics();">添加物流</a>
<a href="#" class="easyui-linkbutton" iconCls="icon-money" plain="true" onclick="payOrderStatus();">付款</a>
<a href="#" class="easyui-linkbutton" iconCls="icon-del" plain="true" onclick="delCooperationOrder();">删除</a>
<br/>
	加工单号：<input id="search_productNo" style="width:100px;"/> &nbsp;
	交货时间：
			<input  id="returnProductStartDate" name="storeStartDate" 
						style="width: 105px;" readonly="readonly" class="easyui-datebox" /> --
			<input id="returnProductEndDate" name="storeEndDate" style="width: 105px;" 
						readonly="readonly" class="easyui-datebox" />&nbsp;
	外发厂家名称：<input id="search_factoryName" style="width:105px;"/>&nbsp;
	付款状态：
	<select id="search_payStatus">
		<option>未选择</option>
		<option value="1">已付款</option>
		<option value="0">未付款</option>
	</select>
	<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchCooperationOrder();">查询</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-table" onclick="exportForm();">结果导出</a>
</div>