<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="tb_logistics">
<a href="#" class="easyui-linkbutton" iconCls="icon-orderView" plain="true" onclick="addLogistics();">添加</a>
<a href="#" class="easyui-linkbutton" iconCls="icon-system" plain="true" onclick="editLogistics();">修改</a>
<a href="#" class="easyui-linkbutton" iconCls="icon-seestore" plain="true" onclick="delLogistics();">删除</a>
发货日期：<input  id="storeStartDate" name="storeStartDate" 
						style="width: 85px;" class="easyui-datebox" /> --
				 <input id="storeEndDate" name="storeEndDate" style="width: 85px;" 
						class="easyui-datebox" />&nbsp;
		加工单号：<input id="search_orderNo" style="width: 100px" class="easyui-validatebox" />&nbsp;
		目的地：<input id="search_destination" style="width: 85px;"></input> &nbsp;
		物品：<input id="search_goods" style="width: 85px;"></input>
		<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchLogistics();">查询</a>
</div>
