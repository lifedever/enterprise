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
	var url = "/proof/listContent.html?orderBy=product.prorder.orderNo";
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
									},{
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
										width : 180
									},
									{
										field : 'proofEffect',
										title : '样品效果',
										width : 100
									},
									{
										field : 'proofCount',
										title : '样品数量',
										width : 80
									},
									{
										field : 'managerAudit',
										title : '审批状态',
										formatter : function(value) {
											if (value == 2) {
												return "<font color='green'>审批通过</font>";
											} else if (value == 1) {
												return "<font color='red'>审批未通过</font>";
											} else {
												return "<font color='red'>未审批</font>";
											}
										},
										width : 80
									},
									{
										field : 'isComplete',
										title : '完成状态',
										formatter : function(value) {
											if (value == 1) {
												return "<font color='green'>已完成</font>";
											} else {
												return "<font color='red'>未完成</font>";
											}
										},
										width : 70
									},
									{
										field : 'isStoreOk',
										title : '备料状态',
										formatter : function(value) {
											if (value == 1) {
												return "<font color='green'>已完成</font>";
											} else {
												return "<font color='red'>未完成</font>";
											}
										},
										width : 70
									},{
										field : 'idForMaterial',
		                				title : '查看原材料',
		                				formatter : function(value) {
		                					return "<a href=\"#\" class=\"easyui-linkbutton\" iconCls=\"icon-remove\" plain=\"true\" onclick=\"showMaterialStoreRoom("+value+","+false+")\">原材料</a>";
		                				},
		                				width : 70
									}, {
										field : 'idForAccessory',
		                				title : '查看辅料',
		                				formatter : function(value) {
		                					return "<a href=\"#\" class=\"easyui-linkbutton\" iconCls=\"icon-remove\" plain=\"true\" onclick=\"showAccessoryStoreRoom("+value+","+false+")\">辅料</a>";
		                				},
		                				width : 70
									},
									{
										field : 'id',
										title : '查看用料表',
										formatter : function(value) {
											return "<a href='#' class='easyui-linkbutton' iconCls='icon-view' plain='true' onclick='viewProofDetail(\""
													+ value + "\")'>查看用料表</a>";
										},
										width : 80
									},
									{
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
	<jsp:include page="auditForm.jsp"></jsp:include>
	<jsp:include page="viewAccessoryStoreRoom.jsp"></jsp:include>
	<jsp:include page="viewMaterialStoreRoom.jsp"></jsp:include>
	<div id="tb_proof">
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="managerAuditProof();">审批</a> 样品名称：<input id="proofName" style="width: 75px;"></input>&nbsp;&nbsp; 产品名称：<input id="proofProName" style="width: 75px;"></input>&nbsp;&nbsp; 完成状态： <select
			id="completeState" name="suditState">
			<option value="">请选择</option>
			<option value="0">未完成</option>
			<option value="1">已完成</option>
		</select>&nbsp;&nbsp; <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchProof();">查询</a>
	</div>
	<div id="viewProduct" class="easyui-window" title="加工单信息" data-options="closed:true,modal:true,iconCls:'icon-save',cache:false" style="width: 650px; height: 500px; padding: 10px;"></div>
	<div id="viewCus" class="easyui-window" title="客户信息" data-options="closed:true,modal:true,iconCls:'icon-save',cache:false" style="width: 850px; height: 400px; padding: 10px;"></div>
	<div class="easyui-window" id="win_accountName" data-options="title:'选择银行账户',closed:true,modal:true,iconCls:'icon-save',cache:false" style="width: 800px; height: 350px; padding: 10px;"></div>
	<div id="dlgviewProofDetail" maximized="true" class="easyui-window" data-options="title:'查看样品制作明细',modal:true,closed:true,cache:false" style="width: 660px; height: 350px; padding: 10px 20px"></div>
	<div id="viewOrder" class="easyui-window" title="订单详情" data-options="closed:true,modal:true,iconCls:'icon-save',cache:false" style="width: 850px; height: 450px; padding: 10px;"></div>
	<script type="text/javascript">
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
		//查看用料明细
		function viewProofDetail(id) {
			$('#dlgviewProofDetail').window({
				href : '/proof/viewDetail.html?id=' + id
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
		function managerAuditProof() {
			var row = $('#prooftt').datagrid('getSelected');
			if (!row) {
				$.messager.alert('提示', '请选择样品!');
			} else {
				$('#dlgAuditProof').dialog('open').dialog('setTitle', '样品制作审批');
			}
		}
		//保存审批
		function saveAudit() {
			var row = $('#prooftt').datagrid('getSelected');
			$('#proofId').val(row.id);
			$('#fmAuditProof').form('submit', {
				url : '/proof/managerAudit.html',
				onSubmit : function() {
					return $(this).form('validate');
				},
				success : function(data) {
					if (!data) {
						$.messager.alert('错误', result.message);
					} else {
						$.messager.alert('提示信息', '操作成功！');
						$('#dlgAuditProof').dialog('close'); // close the dialog  
						$('#prooftt').datagrid('reload'); // reload the user data  
					}
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