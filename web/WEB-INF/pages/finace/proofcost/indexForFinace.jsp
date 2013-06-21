<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../../common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>${title }</title>
<jsp:include page="../../common/css.jsp"></jsp:include>
<jsp:include page="../../common/js.jsp"></jsp:include>
<script type="text/javascript">
	var url = "/proof/listContent.html?f_isAudit=2&f_managerAudit=2&orderBy=product.prorder.orderNo";
	$(function() {
		$("#designp")
				.panel(
						{
							title : '欢迎您：${sessionScope.user.username}，所属部门：${sessionScope.user.department.departmentName}'
						});
		$('#prooftt')
				.datagrid(
						{
							title : '',
							iconCls : 'icon-save',
							width : function() {
								return document.body.clientWidth * 0.9;
							},
							height : 520,
							idField : 'id',//id字段
							rownumbers : true,//行号
							url : url,
							nowrap : false,
							toolbar : '#tb_proof',
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
										field : 'proofName',
										title : '样品名称',
										width : 80
									},
									{
										field : 'customerName',
										title : '客户姓名',
										formatter : function(value, row, index) {
											return "<a href='#' class='easyui-linkbutton' iconCls='icon-view' plain='true' onclick='viewCustomer(\""
													+ row.customerId
													+ "\")'>"
													+ value + "</a>";
										},
										width : 80
									},
									{
										field : 'customerRequire',
										title : '客户要求',
										width : 240
									},
									{
										field : 'proofEffect',
										title : '样品效果',
										width : 130
									},
									{
										field : 'proofCount',
										title : '样品数量',
										width : 80
									},
									{
										field : 'proofMoney',
										title : '样品单价',
										width : 80,
										formatter:function(value){
											return '￥<strong>'+value+'</stron>';
										}
									},
									{
										field : 'allCount',
										title : '样品总价',
										width : 80,
										formatter:function(value,row){
											return '￥<strong>'+Number(row.proofCount)*Number(row.proofMoney)+'</stron>';
										}
									},
									{
										field : 'isPay',
										title : '收款状态',
										formatter : function(value) {
											if (value == 1) {
												return "<font color='green'>已收款</font>";
											} else {
												return "<font color='red'>未收款</font>";
											}
										},
										width : 100
									}, {
										field : 'beizhu',
										title : '备注',
										width : 140
									} ] ],
							view : detailview,
							detailFormatter : function(index, row) {
								return '<div style="padding:2px"><table id="ddv-' + index + '"></table></div>';
							},
							onExpandRow : onExpandRow,
							pagination : true
						//启用分页
						});
		//设置分页
		$('#prooftt').datagrid('getPager').pagination({
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
	<div id="designp">
		<div title="打样单管理" style="padding: 3px;">
			<table id="prooftt" data-options="toolbar:'#prooftb'">
			</table>
		</div>
	</div>
	<div id="tb_proof">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" plain="true" onclick="payOk();">确认收款</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 样品名称：<input id="proofName" style="width: 75px;"></input>&nbsp;&nbsp; 产品名称：<input id="proofProName" style="width: 75px;"></input>&nbsp;&nbsp;
		完成状态： <select id="completeState" name="suditState">
			<option value="">请选择</option>
			<option value="0">未完成</option>
			<option value="1">已完成</option>
		</select>&nbsp;&nbsp; <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchProof();">查询</a>
	</div>
	<jsp:include page="finaceAuditForm.jsp"></jsp:include>
	<div id="viewProduct" class="easyui-window" title="加工单信息" data-options="closed:true,modal:true,iconCls:'icon-save',cache:false" style="width: 650px; height: 500px; padding: 10px;"></div>
	<div id="viewCus" class="easyui-window" title="客户信息" data-options="closed:true,modal:true,iconCls:'icon-save',cache:false" style="width: 850px; height: 400px; padding: 10px;"></div>
	<div class="easyui-window" id="win_accountName" data-options="title:'选择银行账户',closed:true,modal:true,iconCls:'icon-save',cache:false" style="width: 800px; height: 350px; padding: 10px;"></div>
	<div id="dlgviewProofDetail" maximized="true" class="easyui-window" data-options="title:'查看样品制作明细',modal:true,closed:true,cache:false" style="width: 660px; height: 350px; padding: 10px 20px"></div>
	<div id="viewOrder" class="easyui-window" title="订单详情" data-options="closed:true,modal:true,iconCls:'icon-save',cache:false" style="width: 850px; height: 450px; padding: 10px;"></div>
	<script type="text/javascript">
		//弹出银行账户 
		$('#accountName').on('focus', function() {
			$('#win_accountName').window({
				href : '/finace/salary/listAccount.html'
			}).window('open');
		});
		function onExpandRow(index, row) {
			$('#index').val(index);
			$('#ddv-' + index)
					.datagrid(
							{
								url : '/proof/getProductByProof.html?proofId='
										+ row.id,
								fitColumns : true,
								singleSelect : true,
								rownumbers : true,
								id : 'id',
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
											formatter : function(value) {
												return "<a href='#' class='easyui-linkbutton' iconCls='icon-view' plain='true' onclick='viewProduct(\""
														+ value + "\")'>查看</a>";
											},
											width : 53
										} ] ],
								onResize : function() {
									$('#prooftt').datagrid(
											'fixDetailRowHeight', index);
								},
								onLoadSuccess : function() {
									setTimeout(function() {
										$('#prooftt').datagrid(
												'fixDetailRowHeight', index);
									}, 0);
								}
							});
			$('#prooftt').datagrid('fixDetailRowHeight', index);
		}
		//查看产品 
		function viewProduct(id) {
			$('#viewProduct').window({
				href : '/product/viewForm.html?productId=' + id
			}).window('open');
		}
		//查看客户信息 
		function viewCustomer(id) {
			$('#viewCus').window({
				href : '/customer/viewCustomer.html?customerId=' + id
			}).window('open');
		}
		//查询 
		function searchProof() {
			var proofName = $('#proofName').val();
			var proofProName = $('#proofProName').val();//产品名称
			var auditState = $('#auditState').val();//审批状态
			var completeState = $('#completeState').val();//完成状态
			var query = {};
			query['s_proofName'] = proofName;
			query['s_product.productName'] = proofProName;
			query['f_isAudit'] = auditState;
			query['f_isComplete'] = completeState;
			console.log(query)
			$("#prooftt").datagrid('options').queryParams = query;
			$('#prooftt').datagrid('reload');
		}
		//厂长审批 
		function payOk() {
			var row = $('#prooftt').datagrid('getSelected');
			if (!row) {
				$.messager.alert('提示', '请选择样品!');
			} else {
				$('#dlgFinaceAuditProof').dialog('open').dialog('setTitle', '收取样品费'); 
			}
		}
		function savePay() {
			var row = $('#prooftt').datagrid('getSelected');
			$.messager.confirm('警告', '确认已经收到客户：“' + row.customerName
					+ '”的 【'+(Number(row.proofCount*row.proofMoney))+'元】 钱了吗”?', function(r) {
				if (r) {
					$.post('payOk.html', {
						proofId : row.id,
						accountId:$('#accountId').val()
					}, function(data) {
						var result = eval('(' + data + ')');
						if (result) {
							$.messager.alert('成功', '操作成功！');
							$('#dlgFinaceAuditProof').dialog('close');
							$('#prooftt').datagrid('reload'); // reload the user data  
						} else {
							$.messager.alert('失败', '操作失败！');
						}
					}, 'json');
				}
			});
		}
	</script>
	<script type="text/javascript">
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