<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="tb_worksheet">
<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addVehicle();">添加相关车辆</a>
<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addLogistics();">添加物流</a>
<a href="#" class="easyui-linkbutton" iconCls="icon-del" plain="true" onclick="delWorksheet();">删除</a>
	&nbsp;&nbsp;&nbsp;&nbsp;
	加工单号：<input id="search_productNo" style="width: 85px;"/> &nbsp;
	名称：<input id="search_productName" style="width: 85px;"/>&nbsp;
	类型：<select id="search_isProof">
			<option value="">所有</option>
			<option value="0">产品</option>
			<option value="1">样品</option>
		</select>
	<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchWorksheet();">查询</a>
</div>