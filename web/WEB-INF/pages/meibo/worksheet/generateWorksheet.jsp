<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../common/tag.jsp"%>
<div class="ftitle">
	订单详情列表<span class="form_desc">从订单详情列表中生成加工单</span>
</div>
<table id="tt_listOrderItem" class="easyui-datagrid" style="width: 770px; height: 305px;"
	data-options="idField:'id',toolbar:'#tb_listOfferItem',
		collapsible:true,rownumbers:true,url:'/meibo/order/orderItem/listContent.html?f_order.id=${orderId }',
		pagination:true,cache:false,singleSelect:true" fitColumns="true">
	<thead>
		<tr>
			<th data-options="field : 'ck',checkbox : true"></th>
			<th data-options="field:'productName',width:80,editing:true,editor:'text'">名称</th>
			<th data-options="field:'xx',width:100,formatter:productNoformatter">加工单号</th>
			<th data-options="field:'productCount',width:60">数量</th>
			<th data-options="field:'contourSize',width:80">外形尺寸</th>
			<th data-options="field:'qualityRequire',width:80">质量要求</th>
			<th data-options="field:'printColor',width:80">印刷几色</th>
			<th data-options="field:'printRequire',width:80">印刷要求</th>
			<th data-options="field:'projectImage',width:80,formatter:formatImage">工程图</th>
			<th data-options="field:'effectImage',width:80,formatter:formatImage">效果图</th>
		</tr>
	</thead>
</table>
<div id="tb_listOfferItem">
	<a href="#" class="easyui-linkbutton" iconCls="icon-system" plain="true" onclick="generateWorksheet();">新增或修改加工单</a>
</div>