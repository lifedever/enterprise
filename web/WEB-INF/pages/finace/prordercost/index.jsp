<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="jquery,ui,easy,easyui,web">
<meta name="description" content="easyui help you build your web page easily!">
<title>${title}</title>
<jsp:include page="../../common/css.jsp"></jsp:include>
<jsp:include page="../../common/js.jsp"></jsp:include>
</head>
<body>
	<div id="prepaymentdg" style="padding: 3px;">
		<table id="prepaymenttt" data-options="toolbar:'#ordertb'">
		</table>
		<jsp:include page="toolBar.jsp"></jsp:include>
		<jsp:include page="prepayForm.jsp"></jsp:include>
		<jsp:include page="totalMoneyForm.jsp"></jsp:include>
		<div id="viewProduct" class="easyui-window" title="加工单信息" data-options="closed:true,modal:true,iconCls:'icon-save',cache:false" style="width: 650px; height: 500px; padding: 10px;"></div>
		<div id="viewCus" class="easyui-window" title="客户信息" data-options="closed:true,modal:true,iconCls:'icon-save',cache:false" style="width: 850px; height: 400px; padding: 10px;"></div>
		<div class="easyui-window" id="win_accountName" data-options="title:'选择银行账户',closed:true,modal:true,iconCls:'icon-save',cache:false" style="width: 800px; height: 350px; padding: 10px;"></div>
		<div id="viewOrder" class="easyui-window" title="订单详情" data-options="closed:true,modal:true,iconCls:'icon-save',cache:false" style="width: 850px; height: 450px; padding: 10px;"></div>
	</div>
	<script type="text/javascript">
		var url = "/finace/prordercost/listContent.html";
		$(function() {
			$("#prepaymentdg")
					.panel(
							{
								title : '欢迎您：${sessionScope.user.username}，所属部门：${sessionScope.user.department.departmentName}'
							});
			$('#prepaymenttt')
					.datagrid(
							{
								title : '',
								iconCls : 'icon-save',
								width : function() {
									return document.body.clientWidth * 0.9
								},
								height : 520,
								idField : 'id',//id字段
								rownumbers : true,//行号
								//multipleSelect : true,//是否多选
								url : url,
								singleSelect : true,//是否单选
								columns : [ [
										{
											field : 'ck',
											checkbox : true
										},
										{
											field : 'orderNo',
											title : '订单编号',
											width : 120,
											formatter:viewOrderFormatter
										},
										{
											field : 'isCooperation',
											title : '是否外发',
											width : 70,
											formatter:function(value){
												if('1' == value){
													return "<font color='red'>是</font>";
												}else{
													return "<font color='green'>否</font>";
												}
											}
										},
										{
											field : 'customerName',
											title : '客户姓名',
											formatter : function(value, row,
													index) {
												return "<a href='#' class='easyui-linkbutton' iconCls='icon-view' plain='true' onclick='viewCustomer(\""
														+ row.customerId
														+ "\")'>"
														+ value
														+ "</a>";
											},
											width : 80
										},
										{
											field : 'userName',
											title : '业务员姓名',
											width : 80
										},
										{
											field : 'prepay',
											title : '预付款',
											formatter : function(value) {
												if (value == 0) {
													return "<font color='red'>未收取</font>";
												} else {
													return "<font color='green'>已收取</font> ￥"+value;
												}
											},
											width : 120
										},
										{
											field : 'totalMoney',
											title : '全款',
											formatter : function(value,row) {
												if (value == 0) {
													return "<font color='red'>未报价</font>";
												} else if(row.isOfferOk==0){
													return "<font color='green'>已报价</font> ￥"+value;
												}else if(row.isOfferOk==1){
													return "<font color='blue'>已收款</font>";
												}
											},
											width : 120
										},
										{
											field : 'isComplete',
											title : '完成状态',
											formatter : function(value, row,
													index) {
												if (value == '1') {
													return '<span style="color: green">已完成</span>';
												} else {
													return '<span style="color: red">未完成</span>';
												}
											},
											width : 100
										},
										{
											field : 'isOutStore',
											title : '出库状态',
											formatter : function(value, row,
													index) {
												if (value == '1') {
													return '<span style="color: green">已出库</span>';
												} else {
													return '<span style="color: red">未出库</span>';
												}
											},
											width : 100
										}, {
											field : 'startDate',
											title : '开始时间',
											width : 160
										}, {
											field : 'endDate',
											title : '结束时间',
											width : 160
										} ] ],

								view : detailview,
								detailFormatter : function(index, row) {
									return '<div style="padding:2px"><table id="ddv-' + index + '"></table></div>';
								},
								onExpandRow : function(index, row) {
									$('#ddv-' + index)
											.datagrid(
													{
														url : '/product/getListByOrderId.html?orderId='
																+ row.id,
														fitColumns : true,
														singleSelect : true,
														rownumbers : true,
														loadMsg : '正在加载....',
														height : 'auto',
														columns : [ [
																{
																	field : 'productName',
																	title : '产品名称',
																	width : 100
																},
																{
																	field : 'productCount',
																	title : '产品数量',
																	width : 60
																},
																{
																	field : 'materialRequired',
																	title : '质量要求',
																	width : 100
																},
																{
																	field : 'id',
																	title : '查看',
																	formatter : function(
																			value) {
																		return "<a href='#' class='easyui-linkbutton' iconCls='icon-view' plain='true' onclick='viewProduct(\""
																				+ value
																				+ "\")'>查看</a>";
																	},
																	width : 53
																} ] ],
														onResize : function() {
															$('#prepaymenttt')
																	.datagrid(
																			'fixDetailRowHeight',
																			index);
														},
														onLoadSuccess : function() {
															setTimeout(
																	function() {
																		$(
																				'#prepaymenttt')
																				.datagrid(
																						'fixDetailRowHeight',
																						index);
																	}, 0);
														}
													});
									$('#prepaymenttt').datagrid(
											'fixDetailRowHeight', index);
								},
								pagination : true
							});
			//设置分页
			$('#prepaymenttt').datagrid('getPager').pagination({
				pageSize : 10,//每页显示的记录条数，默认为10 
				pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
				beforePageText : '第',//页数文本框前显示的汉字 
				afterPageText : '页    共 {pages} 页',
				displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
			});
		});
	</script>
	<script type="text/javascript">
		//点击收取预付款	
		function addprepayment() {
			var row = $('#prepaymenttt').datagrid('getSelected');
			if (row) {
				$('#dlg_addprepayment').window('open');
				$('#fm_addprepayment').form('clear');
				$('#p_id').val(row.id);
			} else {
				$.messager.alert('提示信息', '请选择订单！');
			}
		}
		//保存预付款
		function savePrepay() {
			$('#fm_addprepayment').form('submit', {
				url : "/finace/prordercost/savePrice.html",
				success : function(data) {
					if (data) {
						$.messager.alert('提示信息', '操作成功！');
						$('#dlg_addprepayment').window('close'); // close the dialog
						$('#prepaymenttt').datagrid('reload');
					} else {
						$.messager.alert('提示信息', '操作失败！');
					}
				}
			});
		}

		//点击收取全款
		function addtotalmoney() {
			var row = $('#prepaymenttt').datagrid('getSelected');
			if (row) {
				if(row.totalMoney!=0){
					$('#dlg_addtotalmoney').window('open');
					$('#fm_addtotalmoney').form('clear');
					$('#totalMoney').val(row.totalMoney);
					$('#ptotal_id').val(row.id);
				}else{
					$.messager.alert('提示信息', '请先联系厂长进行报价！');
				}
			} else {
				$.messager.alert('提示信息', '请选择订单！');
			}
		}
		//保存全款
		function saveTotalmoney() {
			$('#fm_addtotalmoney').form('submit', {
				url : "/finace/prordercost/saveTotalmoney.html",
				success : function(data) {
					if (data) {
						$.messager.alert('提示信息', '操作成功！');
						$('#dlg_addtotalmoney').window('close'); // close the dialog
						$('#prepaymenttt').datagrid('reload');
					} else {
						$.messager.alert('提示信息', '操作失败！');
					}
				}
			});
		}

		//查看客户信息
		function viewCustomer(id) {
			$('#viewCus').window({
				href : '/customer/viewCustomer.html?customerId=' + id
			}).window('open');
		}
		//查看产品
		function viewProduct(id) {
			$('#viewProduct').window({
				href : '/product/viewForm.html?productId=' + id
			}).window('open');
		}

		//查询
		function searchProrder() {
			var id = $('#search_Id').val();//订单编号
			var customerName = $('#search_Customer').val();//客户姓名
			var userName = $('#search_User').val();//业务员
			var isComplete = $('#isComplete_state').val();//完成状态
			var isOutStore = $('#isOutStore_state').val();//出库状态
			var prepay = $('#prepay_state').val();//预付款
			var totalMoney = $('#totalMoney_state').val();//全款
			var query = {};
			if (prepay == '0') {
				query['f_prepay'] = 0;
			} else if (prepay == '1') {

				query['n_prepay'] = 0;
			}
			if (totalMoney == '0') {
				query['f_totalMoney'] = 0;
			} else if (totalMoney == '1') {
				query['n_totalMoney'] = 0;
			}
			query['s_isComplete'] = isComplete;
			query['s_isOutStore'] = isOutStore;
			query['s_orderNo'] = id;
			query['s_customer.customerName'] = customerName;
			query['s_user.realName'] = userName;
			$('#prepaymenttt').datagrid('options').queryParams = query;
			$('#prepaymenttt').datagrid('reload');
		}
	</script>
	
	<script type="text/javascript">
	(function() {
		//弹出银行账户
		$('#accountName').on('focus', function() {
			$('#win_accountName').window({
				href : '/finace/expenditure/listAccount.html'
			}).window('open');
		});
		
		$('#accountNameTotal').on('focus', function() {
			$('#win_accountName').window({
				href : '/finace/expenditure/listAccount.html'
			}).window('open');
		});
	})();
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
<jsp:include page="../../main/footer.jsp"></jsp:include>
</html>
