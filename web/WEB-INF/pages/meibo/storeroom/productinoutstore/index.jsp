<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../../../common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>${title }</title>
<jsp:include page="../../../common/css.jsp"></jsp:include>
<jsp:include page="../../../common/js.jsp"></jsp:include>
</head>
<body>
<div class="easyui-tabs" style="" data-options="fit:true">
		<div title="成品出入库日志" style="padding: 3px">
			<table id="tt_newProductInOutstore" class="easyui-datagrid"
			data-options="fit:true,idField:'id',toolbar:'#tb_productinoutstore',collapsible:true,rownumbers:true,url:'/meibo/storeroom/productinoutstore/listContent.html',pagination:true,singleSelect : false,cache:false">
			<thead>
				<tr>
					<th data-options="field:'operation',width:80,formatter:operation">操作</th>
					<th data-options="field:'orderNo',width:140">订单号</th>
					<th data-options="field:'finishedProductName',width:180">成品名称</th>
					<th data-options="field:'count',width:80">数量</th>
					<th data-options="field:'pickinger',width:120">生产厂家</th>
					<th data-options="field:'recorder',width:100">记录人</th>
					<th data-options="field:'createDate',width:100,formatter:formatDate" sortable="true">日期</th>
				</tr>
			</thead>
		</table>
	</div>
	</div>
	<jsp:include page="index-toolbar-page.jsp"></jsp:include>
	<jsp:include page="index-script-page.jsp"></jsp:include>
	<jsp:include page="../../../main/footer.jsp"></jsp:include>
</body>
</html>