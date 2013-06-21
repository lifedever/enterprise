<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="tb_finishedproduct" style="padding: 5px; height: auto">
	<div style="margin-bottom: 5px">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addFinishedProduct();">新增</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editFinishedProduct();">编辑</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-del" plain="true" onclick="delFinishedProduct();">删除</a>
		
		<a href="#" class="easyui-linkbutton" iconCls="icon-in" plain="true" onclick="productInStore();">成品入库</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-out" plain="true" onclick="productOutStore();">成品出库</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		成品名称：<input id="search_productName" style="width: 85px;"/> &nbsp;
		生产者：<input id="search_producer" style="width: 85px;"/>&nbsp;
		外形尺寸：<input id="search_contourSize" style="width: 85px;"></input> 
		<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchFinishedProduct();">查询</a>
	</div>
</div>