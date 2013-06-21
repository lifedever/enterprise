<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../../common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>${title }</title>
<jsp:include page="../../common/css.jsp"></jsp:include>
<jsp:include page="../../common/js.jsp"></jsp:include>
</head>
<body>
<div class="easyui-tabs" style="" data-options="fit:true">
		<div title="加工单管理" style="padding: 3px">
			<table id="tt_worksheet" class="easyui-datagrid"
			data-options="idField:'id',toolbar:'#tb_worksheet',rownumbers:true,fit:true,
			url:'/meibo/worksheet/listContent.html',pagination:true,singleSelect : true,cache:false">
			<thead>
				<tr>
					<th data-options="field : 'ck',checkbox : true"></th>
					<th data-options="field:'isProof',width:40,formatter:isProofFormatter">类型</th>
					<th data-options="field:'productName',width:100">名称</th>
					<th data-options="field:'productNo',width:130,formatter:productNoformatter">加工单号</th>
					<th data-options="field:'contourSize',width:80">外形尺寸</th>
					<th data-options="field:'productCount',width:50">数量</th>
					<th data-options="field:'instoreCount',width:70">未入库数量</th>
					<th data-options="field:'craftwork',width:120">工艺</th>
					<th data-options="field:'projectImage',width:60,formatter:formatImage">工程图</th>
					<th data-options="field:'effectImage',width:60,formatter:formatImage">效果图</th>
					<th data-options="field:'idVehicle',width:60,formatter:formatVehicle">查看车辆</th>
					<th data-options="field:'idLogistics',width:60,formatter:formatLogistics">查看物流</th>
					<th data-options="field:'createDate',width:80,formatter:formatDate" sortable="true">创建时间</th>
					<th data-options="field:'id',width:80,formatter:instore" sortable="true">点击入库</th>
				</tr>
			</thead>
		</table>
	</div>
	</div>
	<jsp:include page="index-toolbar-page.jsp"></jsp:include>
	<jsp:include page="index-win-page.jsp"></jsp:include>
	<jsp:include page="index-script-page.jsp"></jsp:include>
	<jsp:include page="../../main/footer.jsp"></jsp:include>
</body>
</html>