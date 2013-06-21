<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../common/tag.jsp"%>
<div class="ftitle">
	询价单列表<span class="form_desc">直接从询价单列表中选择产品生成订单</span>
</div>
<table id="tt_listOfferItem" class="easyui-datagrid" style="height: 265px;"
	data-options="idField:'id',
		collapsible:true,rownumbers:true,url:'/meibo/offer/offerItem/listContent.html?f_offer.id=${offerId }',
		pagination:true,cache:false" fitColumns="true">
	<thead>
		<tr>
			<th data-options="field : 'ck',checkbox : true"></th>
			<th data-options="field:'productName',width:80,editing:true,editor:'text'">名称</th>
			<th data-options="field:'productPrice',width:80,formatter : formatMoney">已报价格</th>
			<th data-options="field:'productCount',width:80">数量</th>
			<th data-options="field:'contourSize',width:80">外形尺寸</th>
			<th data-options="field:'projectImage',width:80,formatter:formatImage">工程图</th>
			<th data-options="field:'effectImage',width:80,formatter:formatImage">效果图</th>
		</tr>
	</thead>
</table>
