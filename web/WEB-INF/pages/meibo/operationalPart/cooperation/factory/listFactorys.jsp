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
	<div class="easyui-panel">
		<table id="tt_newFactory" class="easyui-datagrid" style="width: 888px; height: 420px"
			data-options="idField:'id',toolbar:'#tb_newFactory',rownumbers:true,
			url:'/meibo/operationalPart/cooperation/factory/listContent.html',pagination:true,singleSelect : true,cache:false">
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
	<jsp:include page="index-script-page.jsp"></jsp:include>
	<div id="tb_newFactory">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" plain="true" onclick="selectOk();">确认选择</a>
	</div>
</body>
</html>