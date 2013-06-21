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
		<div title="加工成本管理" style="padding: 3px">
			<table id="tt_newProductioncost" class="easyui-datagrid"
			data-options="idField:'id',toolbar:'#tb_productcost',fit:true,
			collapsible:true,rownumbers:true,
			url:'/finace/productioncost/listContent.html',pagination:true,singleSelect : true,cache:false">
			<thead>
				<tr>
					<th data-options="field : 'ck',checkbox : true"></th>
					<th data-options="field:'isProof',width:60,formatter:isProofFormatter">类型</th>
					<th data-options="field:'productNo',width:140,formatter:productNoFormatter">加工单号</th>
					<th data-options="field:'productName',width:150">名称</th>
					<th data-options="field:'totalCost',width:100,formatter:formatMoney">成本费</th>
					<th data-options="field:'contourSize',width:120">外形尺寸</th>
					<th data-options="field:'productCount',width:80">数量</th>
					<th data-options="field:'craftwork',width:100">工艺</th>
					<th data-options="field:'projectImage',width:100,formatter:formatImage">工程图</th>
					<th data-options="field:'effectImage',width:100,formatter:formatImage">效果图</th>
				</tr>
			</thead>
		</table>
	</div>
	</div>
	<jsp:include page="index-toolbar-page.jsp"></jsp:include>
	<jsp:include page="index-script-page.jsp"></jsp:include>
	<jsp:include page="index-win-page.jsp"></jsp:include>
	<jsp:include page="../../main/footer.jsp"></jsp:include>
</body>
</html>