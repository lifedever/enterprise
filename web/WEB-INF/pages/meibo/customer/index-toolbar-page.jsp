<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="tb_customer">
	<a href="#" class="easyui-linkbutton" iconCls="icon-user-add" plain="true" onclick="newCustomer();">添加新客户</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-user-edit" plain="true" onclick="editCustomer();">编辑</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-user-del" plain="true" onclick="delCustomer()">删除</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-phone" plain="true" onclick="askOffer()">开始询价</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-item" plain="true" onclick="showOffers()">询价信息</a>
	&nbsp;&nbsp;&nbsp;&nbsp;客户姓名：<input id="searchVal" class="easyui-searchbox"
		data-options="prompt:'输入客户姓名',searcher:searchCustomer" />
</div>