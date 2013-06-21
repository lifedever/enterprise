<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="tb_customer">
<a href="#" class="easyui-linkbutton" iconCls="icon-orderView" plain="true" onclick="viewSign();">查看合同</a>
<a href="#" class="easyui-linkbutton" iconCls="icon-system" plain="true" onclick="generateWorksheetWin();">查看或创建加工单</a>
<a href="#" class="easyui-linkbutton" iconCls="icon-seestore" plain="true" onclick="seeStore();">查看库房</a>
<a href="#" class="easyui-linkbutton" iconCls="icon-out2" plain="true" onclick="outSource();">外发</a>
<a href="#" class="easyui-linkbutton" iconCls="icon-update" plain="true" onclick="updateStatus();">更新订单状态</a>
	&nbsp;&nbsp;&nbsp;&nbsp;客户姓名：<input id="searchVal" class="easyui-searchbox"
		data-options="prompt:'输入客户姓名',searcher:searchOrder" />
&nbsp;&nbsp;&nbsp;&nbsp;
订单类型：<select name="isProof" onchange="searchByType(this.value);">
			<option value="">未选择</option>
			<option value="0">成品</option>
			<option value="1">样品</option>
		</select>
</div>