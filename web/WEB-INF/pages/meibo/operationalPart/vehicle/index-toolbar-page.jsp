<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="tb_vehicle">
<a href="#" class="easyui-linkbutton" iconCls="icon-orderView" plain="true" onclick="addVehicle();">添加</a>
<a href="#" class="easyui-linkbutton" iconCls="icon-system" plain="true" onclick="editVehicle();">修改</a>
<a href="#" class="easyui-linkbutton" iconCls="icon-seestore" plain="true" onclick="delVehicle();">删除</a>
日期时间：<input  id="storeStartDate" name="storeStartDate" 
						style="width: 85px;" class="easyui-datebox" /> --
				 <input id="storeEndDate" name="storeEndDate" style="width: 85px;" 
						class="easyui-datebox" />&nbsp;
		加工单号：<input id="search_orderNo" style="width: 100px" class="easyui-validatebox" />&nbsp;
		送货地址：<input id="search_deliveryAddress" style="width: 85px;"></input> &nbsp;
		业务员：<input id="search_clerk" style="width: 85px;"></input>
		<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchVehicle();">查询</a>
</div>
