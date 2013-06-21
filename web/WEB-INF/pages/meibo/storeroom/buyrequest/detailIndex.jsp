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
<div class="ftitle">
	请购单信息<span class="form_desc">请购单基本信息</span>
</div>
<div style="padding: 10px 10px 10px 10px;">
	<form id="fm_buyRequest">
		<table border="0" width="90%">
			<tr>
				<td align="right" width="18%">采购人：</td>
				<td width="32%">${buyrequest.buyer }</td>
				<td align="right" width="18%">
					采购日期：					
				</td>
				<td width="32%">
					<fmt:formatDate value="${buyrequest.buyDate  }" pattern="yyyy年MM月dd日" />
				</td>
			</tr>
		</table>
		<table id="tt_addBuyRequestItem" class="easyui-datagrid" style="width: 720px; height: 350px;"
			data-options="idField:'id',title:'请购条目列表',collapsible:true,rownumbers:true,url:'/meibo/storeroom/buyrequestitem/listContent.html?buyRequestNo=${buyrequest.buyRequestNo }',pagination:true,singleSelect : true,cache:false">
			<thead>
				<tr>
					<th data-options="field:'name',width:120">名称</th>
					<th data-options="field:'standard',width:110">标准</th>
					<th data-options="field:'count',width:60">数量</th>
					<th data-options="field:'unit',width:65">单位</th>
					<th data-options="field:'valuation',width:80,formatter:formatMoney">估价</th>
					<th data-options="field:'purpose',width:160">用途</th>
					<th data-options="field:'createDate',width:90,formatter:formatDate">添加时间</th>
				</tr>
			</thead>
		</table>
	</form>
</div>
</body>
</html>