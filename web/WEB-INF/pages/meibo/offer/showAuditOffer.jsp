<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../common/tag.jsp"%>
<table id="tt_showAuditOffer" class="easyui-datagrid" style="width: 720px; height: 340px;"
	data-options="idField:'id',toolbar:'#tb_managerAuditOffer',title:'',collapsible:true,rownumbers:true,url:'/meibo/offer/offerItem/listContent.html?f_offer.id=${offer.id }',pagination:true,singleSelect : true,cache:false">
	<thead>
		<tr>
			<th data-options="field : 'ck',checkbox : true"></th>
			<th data-options="field:'productName',width:100">名称</th>
			<th data-options="field:'offerCount',width:60">报价次数</th>
			<th data-options="field:'qualityRequire',width:165">质量要求</th>
			<th data-options="field:'printRequire',width:165">印刷要求</th>
			<th data-options="field:'createDate',width:150,formatter:formatDate">添加时间</th>
		</tr>
	</thead>
</table>
<div id="tb_managerAuditOffer">
	<a href="#" class="easyui-linkbutton" iconCls="icon-info" plain="true" onclick="showOfferMoney();">查看报价详情</a>
</div>
