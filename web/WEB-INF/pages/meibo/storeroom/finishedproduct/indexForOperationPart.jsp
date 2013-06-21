<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="../../../common/tag.jsp"%>
	<div class="easyui-panel">
		<table id="tt_newFinishedProduct" class="easyui-datagrid"
			style="width: document.body.clientWidth*0.9; height: 380px"
			data-options="idField:'id',toolbar:'#tb_finishedproductforpart',collapsible:true,rownumbers:true,url:'/meibo/storeroom/finishedproduct/listContent.html',pagination:true,singleSelect : true,cache:false" fitColumns="true">
			<thead>
				<tr>
					<th data-options="field:'productName',width:120">成品名称</th>
					<th data-options="field:'producer',width:70">生产厂家</th>
					<th data-options="field:'productCount',width:60">数量</th>
					<th data-options="field:'contourSize',width:100">外形尺寸</th>
					<th data-options="field:'printColor',width:100">印刷几色</th>
					<th data-options="field:'qualityRequire',width:160">质量要求</th>
					<th data-options="field:'printRequire',width:160">印刷要求</th>
					<th data-options="field:'createDate',width:90,formatter:formatDate">入库时间</th>
				</tr>
			</thead>
		</table>
	</div>
