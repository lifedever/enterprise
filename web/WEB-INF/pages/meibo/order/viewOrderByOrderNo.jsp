<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../../common/tag.jsp"%>
<div class="ftitle">
	订单详情<span class="form_desc">订单详情列表<font color="blue">【订单编号：${order.orderNo }】</font></span>
</div>
<div style="padding: 10px 0 10px 60px;">
	<form id="fm_generateOrder">
		<table width="80%">
			<tr>
				<td><strong>开始时间：</strong><fmt:formatDate value="${order.startDate}" pattern="yyyy年MM月dd日" />
				</td>
				<td><strong>结束时间：</strong><fmt:formatDate value="${order.endDate}" pattern="yyyy年MM月dd日" /></td>
			</tr>
		</table>
	</form>
</div>
<strong>订单信息列表：</strong>
<table id="tt_editOfferItem" class="easyui-datagrid" style="width: 800px; height: 270px;"
	data-options="idField:'id',
		collapsible:true,rownumbers:true,url:'/meibo/order/orderItem/listContent.html?f_order.orderNo=${order.orderNo }',
		pagination:true,singleSelect : true,cache:false">
	<thead>
		<tr>
			<th data-options="field:'productName',width:100,editing:true,editor:'text'">名称</th>
			<th data-options="field:'productCount',width:60">数量</th>
			<th data-options="field:'contourSize',width:80">外形尺寸</th>
			<th data-options="field:'qualityRequire',width:100">质量要求</th>
			<th data-options="field:'printColor',width:100">印刷几色</th>
			<th data-options="field:'printRequire',width:100">印刷要求</th>
			<th data-options="field:'projectImage',width:60,formatter:formatImage">工程图</th>
			<th data-options="field:'effectImage',width:60,formatter:formatImage">效果图</th>
			<th data-options="field:'isPrepared',width:120,formatter:formatPrepared">备料情况</th>
		</tr>
	</thead>
</table>