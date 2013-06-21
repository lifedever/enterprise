<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	//打印合同
	function printSign(){
		$('#print_sign').printArea();
	}
	function orderFormatter(value,row){
		return '<a href="#" onclick="viewOrder(\''+row.orderNo+'\')">'+row.orderNo+'</a>';
	}
	function viewOrder(orderNo){
		$('#win_viewOrder').window({
			href : '/meibo/order/viewOrderByOrderNo.html?orderNo=' + orderNo
		}).window('open');
	}
	
	function finishFormatter(value,row){
		if(Number(row.allCount)==Number(row.hasCount)){
			return '<font color="green">已完成</font>';
		}else{
			return '<font color="red">未完成</font>';
		}
	}
	function isProofFormatter(value){
		if (value == '0') {
			return '<span style="color:red">产品</span>';
		}
		if (value == '1') {
			return '<span style="color:green">样品</span>';
		}
	}
	//查询
	function searchOrder(value) {
		var query = {};
		query['s_customer.customerName'] = value;
		$("#tt_auditOrder").datagrid('options').queryParams = query;
		$('#tt_auditOrder').datagrid('reload');
	}
	function detailFormatter(index, row) {
		return '<div style="padding:2px"><table id="ddv-' + index + '"></table></div>';
	}
	function signFormatter(value,row) {
		if (value == '1'&&row.contractNo!='') {
			return '<span style="color:green">合同编号：'+row.contractNo+'</span>';
		}else{
			return '<span style="">无</span>';
		}
	}
	function formatPrepared(value,row){
		if (value == '1') {
			return '<span style="color:green">'+'<a href="#" onclick="viewPrepare(\''+row.prepareNo+'\')">'+row.prepareNo+'</a>'+'</span>';
		}else{
			return '<span style="">无</span>';
		}
	}
	
	function viewPrepare(prepareNo){
		$('#win_prepared').window({
			href : '/meibo/order/prepare/viewPrepare.html?prepareNo='+prepareNo
		}).window('open');
	}
	//订单审批 
	function orderAudit(){
		var row = $('#tt_auditOrder').datagrid('getSelected');
		if (row) {
			$('#win_auditOrder').window({
				href : '/meibo/order/audit/auditForm.html?orderId=' + row.id
			}).window('open');
		} else {
			$.messager.alert('提示信息', '请选择操作对象！');
		}
	}
	function viewSign(){
		var row = $('#tt_auditOrder').datagrid('getSelected');
		if (row) {
			if(row.signState == '1'&&row.contractNo!=''){
				$('#win_viewSign').window({
					href : '/meibo/contract/viewSign.html?orderNo=' + row.orderNo
				}).window('open');
			}else{
				$.messager.alert('提示信息', '没有签单，请先进行签单！');
			}
		} else {
			$.messager.alert('提示信息', '请选择操作对象！');
		}
	} 
	function onExpandRow(index, row) {
		$('#ddv-' + index).datagrid(
				{
					url : '/meibo/order/orderItem/listContent.html?f_order.id='
							+ row.id,
					fitColumns : true,
					singleSelect : true,
					rownumbers : true,
					height : 'auto',
					columns : [ [ {
						field : 'productName',
						title : '名称',
						width : 100
					}, {
						field : 'productCount',
						title : '数量',
						width : 50
					}, {
						field : 'contourSize',
						title : '外形尺寸',
						width : 100
					}, {
						field : 'qualityRequire',
						title : '质量要求',
						width : 150
					}, {
						field : 'printColor',
						title : '印刷几色',
						width : 100
					}, {
						field : 'printRequire',
						title : '印刷要求',
						width : 150
					}, {
						field : 'projectImage',
						title : '工程图',
						width : 80,
						formatter : formatImage
					}, {
						field : 'effectImage',
						title : '效果图',
						width : 80,
						formatter : formatImage
					} ] ],
					onResize : function() {
						$('#tt_auditOrder').datagrid('fixDetailRowHeight', index);
					},
					onLoadSuccess : function() {
						setTimeout(function() {
							$('#tt_auditOrder')
									.datagrid('fixDetailRowHeight', index);
						}, 0);
					}
				});
	}
</script>
