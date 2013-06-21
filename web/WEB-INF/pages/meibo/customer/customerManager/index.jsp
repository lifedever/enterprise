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
		<div title="客户信息维护" style="padding: 3px">
			<table id="tt_newCustomer" class="easyui-datagrid" style="" data-options="fit:true,idField:'id',toolbar:'#tb_customer',collapsible:true,rownumbers:true,url:'/meibo/customer/listContent.html',pagination:true,singleSelect : true,cache:false">
				<thead>
					<tr>
						<th data-options="field : 'ck',checkbox : true"></th>
						<th data-options="field:'customerName',width:80,formatter:formatterCustomerName">姓名</th>
						<th data-options="field:'company',width:150">单位名称</th>
						<th data-options="field:'userName',width:80">业务员</th>
						<th data-options="field:'mobile',width:120">手机</th>
						<th data-options="field:'offerDate',width:120,formatter:lastOfferFormatter,styler:cellImpStyler">最近一次询价时间</th>
						<th data-options="field:'telphone',width:100">电话</th>
						<th data-options="field:'address',width:150">地址</th>
						<th data-options="field:'fax',width:100">传真</th>
						<th data-options="field:'email',width:150">邮箱</th>
						<th data-options="field:'QQ',width:80">QQ</th>
						<th data-options="field:'MSN',width:80">MSN</th>
						<th data-options="field:'wangWang',width:80">旺旺</th>
						<th data-options="field:'feiXin',width:80">飞信</th>
						<th data-options="field:'webSite',width:150">网站</th>
						<th data-options="field:'remark',width:150">备注</th>
						<th data-options="field:'createDate',width:120,formatter:formatDate">添加日期</th>
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