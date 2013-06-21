<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>${title }</title>
<jsp:include page="../common/css.jsp"></jsp:include>
<jsp:include page="../common/js.jsp"></jsp:include>

<script type="text/javascript">
	var url = "/prorder/listContent.html?orderBy=orderNo";
	$(function() {
		$("#p")
				.panel(
						{
							title : '欢迎您：${sessionScope.user.username}，所属部门：${sessionScope.user.department.departmentName}'
						});
		$('#tt').datagrid({
			title : '',
			iconCls : 'icon-edit',
			width : function() {
				return document.body.clientWidth * 0.9
			},
			height : 520,
			idField : 'id',//id字段
			rownumbers : true,//行号
			toolbar : '#tb_audit',
			url : url,
			singleSelect : true,//是否单选
			columns : [ [ {
				field : 'ck',
				checkbox : true
			}, {
				field : 'orderNo',
				title : '订单编号',
				width : 120,
				formatter:viewOrderFormatter
			}, {
				field : 'customerName',
				title : '客户姓名',
				width : 100
			}, {
				field : 'managerAudit',
				title : '审批状态',
				width : 80,
				formatter:function(value){
					if (value == 1) {
						return "<font color='green'>已审批</font>";
					} else {
						return "<font color='red'>未审批</font>";
					}
				}
			
			} ,{
				field : 'startDate',
				title : '开始时间',
				width : 160
			}, {
				field : 'endDate',
				title : '结束时间',
				width : 160
			}, {
				field : 'prepay',
				title : '预付款',
				formatter : function(value) {
					if (value == '') {
						return '<font color="red">未结算</font>';
					} else {
						return value;
					}
				},
				width : 100
			}, {
				field : 'totalMoney',
				title : '订单总价',
				formatter : function(value) {
					return '￥ <strong>'+value+'</strong>';
				},
				width : 100
			} ] ],
			pagination : true
		//启用分页
		});
		//设置分页
		$('#tt').datagrid('getPager').pagination({
			pageSize : 10,//每页显示的记录条数，默认为10 
			pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
			beforePageText : '第',//页数文本框前显示的汉字 
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
		});
	});
</script>
</head>
<body>
	<div id="p">
		<div title="报价管理">
			<table id="tt">
			</table>
		</div>
	</div>
	<div id="tb_audit" style="padding: 5px; height: auto">
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="auditAndOffer();">审批报价</a>
	</div>
	<div class="easyui-window" id="win_product" data-options="title:'产品列表',closed:true,modal:true,iconCls:'icon-save',cache:false" style="width: 850px; height: 450px; padding: 10px;"></div>
	<div id="viewOrder" class="easyui-window" title="订单详情" data-options="closed:true,modal:true,iconCls:'icon-save',cache:false" style="width: 850px; height: 450px; padding: 10px;"></div>
	<script type="text/javascript">
		function auditAndOffer() {
			var row = $('#tt').datagrid('getSelected');
			if (row) {
				$('#win_product').window({
					href : '/manage/productIndex.html?orderId='+row.id
				}).window('open');
			}else{
				$.messager.alert('提示：','请选择订单');
			}
		}
		function saveAudit() {
		}
		//查看订单详情
		function viewOrderFormatter(value){
			return '<a href="#" onclick="viewOrder(\''+value+'\')">'+value+'</a>';
		}
		function viewOrder(orderNo){
			$('#viewOrder').window({
				href : '/prorder/viewProrder.html?orderNo=' + orderNo
			}).window('open');
		}
	</script>
</body>
<jsp:include page="../main/footer.jsp"></jsp:include>
</html>