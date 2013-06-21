<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../common/tag.jsp"%>
<div class="ftitle">
	客户信息<span class="form_desc">详细客户信息</span>
</div>
<div style="padding: 10px 0 10px 60px;">
	<table border="0" width="100%">
		<tr>
			<td>姓名：${customer.customerName}</td>
			<td>公司：${customer.company}</td>
		</tr>
		<tr>
			<td>手机：${customer.mobile}</td>
			<td>电话：${customer.telphone}</td>
		</tr>
		<tr>
			<td>网站：${customer.webSite}</td>
			<td>邮箱：${customer.email}</td>
		</tr>
		<tr>
			<td>QQ：${customer.QQ}</td>
			<td>MSN：${customer.MSN}</td>
		</tr>
		<tr>
			<td>旺旺：${customer.wangWang}</td>
			<td>飞信：${customer.feiXin}</td>
		</tr>
		<tr>
			<td colspan="2">备注：${customer.remark}</td>
		</tr>
	</table>
</div>