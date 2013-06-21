<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<div id="ordertb" style="padding: 5px; height: auto">
		<div style="margin-bottom: 5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
				onclick="addprepayment();">收取预付款</a> 
				<!--  -->
				<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
				onclick="addtotalmoney();">收取全款</a> 
				<br/>
			订单编号： <input id="search_Id" style="width: 100px"
				class="easyui-validatebox" />客户：<input id="search_Customer" style="width: 85px;"></input>
					业务员：<input id="search_User" style="width: 85px;"></input>
			完成状态：<select id="isComplete_state">
				<option value="">不限</option>
				<option value="1">已完成</option>
				<option value="0">未完成</option>
			</select>
			出库状态：<select id="isOutStore_state">
				<option value="">不限</option>
				<option value="1">已出库</option>
				<option value="0">未出库</option>
			</select>
			预付款：<select id="prepay_state">
				<option value="">不限</option>
				<option value="1">已收款</option>
				<option value="0">未收款</option>
			</select>
			全款：<select id="totalMoney_state">
				<option value="">不限</option>
				<option value="1">已报价</option>
				<option value="0">未报价</option>
			</select>
				 <a href="#" class="easyui-linkbutton"
				iconCls="icon-search" onclick="searchProrder();">查询</a>
		</div>
	</div>
