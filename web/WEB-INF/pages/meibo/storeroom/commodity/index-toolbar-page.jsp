<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="tb_commodity" style="padding: 5px; height: auto">
	<div style="margin-bottom: 5px">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addCommodity();">新增</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editCommodity();">编辑</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-del" plain="true" onclick="delCommodity();">删除</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-in" plain="true" onclick="inStore();">入库</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-out" plain="true" onclick="outStore();">出库</a>
		入库时间：<input  id="storeStartDate" name="storeStartDate" 
						style="width: 85px;" class="easyui-datebox" /> --
				 <input id="storeEndDate" name="storeEndDate" style="width: 85px;" 
						class="easyui-datebox" />&nbsp;
		商品名称：<input id="search_name" style="width: 100px" class="easyui-validatebox" />&nbsp;
		供应商名称：<input id="search_providerName" style="width: 85px;"></input> 
		<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchCommodity();">查询</a>
	</div>
</div>