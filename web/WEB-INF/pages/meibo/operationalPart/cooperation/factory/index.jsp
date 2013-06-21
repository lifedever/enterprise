<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../../../../common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>${title }</title>
<jsp:include page="../../../../common/css.jsp"></jsp:include>
<jsp:include page="../../../../common/js.jsp"></jsp:include>
</head>
<body>
<div class="easyui-tabs" style="" data-options="fit:true">
		<div title="外发工厂管理" style="padding: 3px">
			<table id="tt_newFactory" class="easyui-datagrid"
			data-options="idField:'id',toolbar:'#tb_newFactory',rownumbers:true,fit:true,
			url:'/meibo/operationalPart/cooperation/factory/listContent.html',pagination:true,singleSelect : true,cache:false"
			fitColumns="true">
			<thead>
				<tr>
					<th data-options="field : 'ck',checkbox : true"></th>
					<th data-options="field:'factoryNo',width:60">编号</th>
					<th data-options="field:'factoryName',width:100">名称</th>
					<th data-options="field:'factoryProp',width:100">性质</th>
					<th data-options="field:'factoryStar',width:80,formatter:factoryStarFormatter">星级</th>
					<th data-options="field:'factorySite',width:100">网址</th>
					<th data-options="field:'contactMan',width:60">联系人</th>
					<th data-options="field:'mobile',width:100">手机</th>
					<th data-options="field:'address',width:100">地址</th>
					<th data-options="field:'remark',width:150">备注</th>
					<th data-options="field:'createDate',width:80,formatter:formatDate" sortable="true">创建时间</th>
				</tr>
			</thead>
		</table>
	</div>
	</div>
	<jsp:include page="index-toolbar-page.jsp"></jsp:include>
	<jsp:include page="index-win-page.jsp"></jsp:include>
	<jsp:include page="index-script-page.jsp"></jsp:include>
	<jsp:include page="../../../../main/footer.jsp"></jsp:include>
</body>
</html>