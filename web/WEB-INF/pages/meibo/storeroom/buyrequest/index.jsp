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
		<div title="请购管理" style="padding: 3px">
			<table id="tt_buyRequest" class="easyui-datagrid"
			data-options="fit:true,idField:'id',toolbar:'#tb_buyrequest',collapsible:true,rownumbers:true,url:'/meibo/storeroom/buyrequest/listContent.html',pagination:true,singleSelect : true,cache:false">
			<thead>
				<tr>
					<th data-options="field : 'ck',checkbox : true"></th>
					<th data-options="field:'buyRequestNo',width:200,formatter:formatBuyrequestNo">请购单号</th>
					<th data-options="field:'requester',width:150">请购人</th>
					<th data-options="field:'buyer',width:150">采购人</th>
					<th data-options="field:'buyDate',width:120,formatter:formatDate">采购日期</th>
					<th data-options="field:'createDate',width:120,formatter:formatDate">请购日期</th>
				</tr>
			</thead>
		</table>
	</div>
	</div>
	<jsp:include page="index-toolbar-page.jsp"></jsp:include>
	<jsp:include page="index-win-page.jsp"></jsp:include>
	<jsp:include page="index-script-page.jsp"></jsp:include>
	<jsp:include page="../../../main/footer.jsp"></jsp:include>
</body>
</html>