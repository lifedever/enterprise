<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="tb_customer">
<a href="#" class="easyui-linkbutton" iconCls="icon-orderView" plain="true" onclick="viewSign();">查看签单</a>
<a href="#" class="easyui-linkbutton" iconCls="icon-quxiao" plain="true" onclick="cancelSign();">取消签单</a>
	&nbsp;&nbsp;&nbsp;&nbsp;需方签约人：<input id="searchVal" class="easyui-searchbox"
		data-options="prompt:'输入客户姓名',searcher:searchContract" />
</div>