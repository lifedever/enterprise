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
		<div title="成品管理" style="padding: 3px">
			<table id="tt_newFinishedProduct" class="easyui-datagrid"
				data-options="fit:true,idField:'id',toolbar:'#tb_finishedproduct',collapsible:true,rownumbers:true,
			url:'/meibo/storeroom/finishedproduct/listContent.html',
			pagination:true,singleSelect : true,cache:false" fitColumns="true">
				<thead>
					<tr>
						<th data-options="field : 'ck',checkbox : true"></th>
						<th data-options="field:'isProof',width:50,formatter:isProofFormatter">类型</th>
						<th data-options="field:'productName',width:120">名称</th>
						<th data-options="field:'contourSize',width:120">外形尺寸</th>
						<th data-options="field:'printColor',width:100">印刷几色</th>
						<th data-options="field:'qualityRequire',width:160">质量要求</th>
						<th data-options="field:'printRequire',width:160">印刷要求</th>
						<th data-options="field:'projectImage',width:60,formatter:formatImage">工程图</th>
						<th data-options="field:'effectImage',width:60,formatter:formatImage">效果图</th>
						<th data-options="field:'createDate',width:100,formatter:formatDate">入库时间</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	<div id="tb_finishedproduct" style="padding: 5px; height: auto">
	<div style="margin-bottom: 5px">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addFinishedProduct();">新增</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editFinishedProduct();">编辑</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-del" plain="true" onclick="delFinishedProduct();">删除</a>
		
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		成品名称：<input id="search_productName" style="width: 85px;"/> &nbsp;
		生产者：<input id="search_producer" style="width: 85px;"/>&nbsp;
		外形尺寸：<input id="search_contourSize" style="width: 85px;"></input> 
		<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchFinishedProduct();">查询</a>
	</div>
</div>
	<jsp:include page="index-win-page.jsp"></jsp:include>
	<jsp:include page="index-script-page.jsp"></jsp:include>
	<jsp:include page="../../../main/footer.jsp"></jsp:include>
</body>
</html>