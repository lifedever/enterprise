<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="tb_customer">
<a href="#" class="easyui-linkbutton" iconCls="icon-orderView" plain="true" onclick="viewSign();">查看合同</a>
<a href="#" class="easyui-linkbutton" iconCls="icon-info" plain="true" onclick="orderAudit();">审批</a>
	&nbsp;&nbsp;&nbsp;&nbsp;客户姓名：<input id="searchVal" class="easyui-searchbox"
		data-options="prompt:'输入客户姓名',searcher:searchOrder" />
</div>