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
	function isProofFormatter(value){
		if (value == '0') {
			return '<span style="color:red">产品</span>';
		}
		if (value == '1') {
			return '<span style="color:green">样品</span>';
		}
	}
	function signFormatter(value,row) {
		if (value == '0') {
			return '<span style="color:red">未签单</span>';
		}
		if (value == '1') {
			return '<span style="color:green">合同编号：'+row.contractNo+'</span>';
		}
	}
	function formatPrepared(value,row){
		if (value == '1') {
			return '<span style="color:green">'+'<a href="#" onclick="viewPrepare(\''+row.prepareNo+'\')">'+row.prepareNo+'</a>'+'</span>';
		}else{
			return '<span style="">无</span>';
		}
	}
	function productNoformatter(value,row){
		if(row.isWorksheet == '1'){
			return '<span style="color:green">'+'<a href="#" onclick="viewWorksheet(\''+row.productNo+'\')">'+row.productNo+'</a>'+'</span>';
		}else{
			return '<span style="">无加工单</span>';
		}
	}
	function cooperatorOrderformatter(value,row){
		if(row.isCooperate == '1'){
			return '<span style="color:green">'+'<a href="#" onclick="viewCooperationOrder(\''+row.productNo+'\')">'+row.productNo+'</a>'+'</span>';
		}else{
			return '<span style="">无外发单</span>';
		}
	}
	function viewWorksheet(productNo){
		$('#win_viewWorksheet').window({
			href : '/meibo/worksheet/viewWorksheet.html?productNo='+productNo
		}).window('open');
	}
	function viewCooperationOrder(productNo){
		$('#win_viewCooperationOrder').window({
			href : '/meibo/operationalPart/cooperation/order/viewCooperationOrder.html?productNo='+productNo
		}).window('open');
	}
	function viewPrepare(prepareNo){
		$('#win_prepared').window({
			href : '/meibo/order/prepare/viewPrepare.html?prepareNo='+prepareNo
		}).window('open');
	}
	//查询
	function searchOrder(value) {
		var query = {};
		query['s_customer.customerName'] = value;
		$("#tt_operaOrder").datagrid('options').queryParams = query;
		$('#tt_operaOrder').datagrid('reload');
	}
	function searchByType(value){
		var query = {};
		query['f_isProof'] = value;
		$("#tt_operaOrder").datagrid('options').queryParams = query;
		$('#tt_operaOrder').datagrid('reload');
	}
	function detailFormatter(index, row) {
		return '<div style="padding:2px"><table id="ddv-' + index + '"></table></div>';
	}
	function viewSign(){
		var row = $('#tt_operaOrder').datagrid('getSelected');
		if (row) {
			if(row.signState=='1'){
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
	
	//生成加工单窗口
	function generateWorksheetWin(){
		var row = $('#tt_operaOrder').datagrid('getSelected');
		if (row) {
			$('#win_generateWorksheetWin').window({
				href : '/meibo/worksheet/generateWorksheet.html?orderId=' + row.id
			}).window('open');
		} else {
			$.messager.alert('提示信息', '请选择操作对象！');
		}
	}
	function generateWorksheet(){
		var row = $('#tt_listOrderItem').datagrid('getSelected');
		if (row) {
			if(row.isWorksheet != '1'){
				$('#win_generateWorksheet').window({
					href : '/meibo/worksheet/createWorksheet.html?orderItemId=' + row.id
				}).window('open');
			}else{
				$('#win_viewWorksheet').window({
					href : '/meibo/worksheet/editWorksheet.html?productNo='+row.productNo
				}).window('open');
			}
		} else {
			$.messager.alert('提示信息', '请选择操作对象！');
		}
	}
	
	function newBox(){
		var row = $('#ddv-' + index).datagrid('getSelected');
		
	}
	//查看库房 win_seeStore
	function seeStore(){
		$('#win_seeStore').window({
			href : '/meibo/storeroom/finishedproduct/indexForOperationPart.html'
		}).window('open');
	}
	
	//外发
	function outSource(){
		var row = $('#tt_operaOrder').datagrid('getSelected');
		if (row) {
			$('#win_generateWorksheetWin').window({
				href : '/meibo/operationalPart/cooperation/order/generateCooperationOrder.html?orderId=' + row.id
			}).window('open');
		} else {
			$.messager.alert('提示信息', '请选择操作对象！');
		}
	}
	
	//更新订单状态
	function updateStatus(){
		var row = $('#tt_operaOrder').datagrid('getSelected');
		if(row){
			$('#win_updateStatus').window({
				href : '/meibo/order/updateStatus.html?orderId=' + row.id
			}).window('open');	
		}
	}
	function generateCooperationOrder(){
		var row = $('#tt_listOrderItem').datagrid('getSelected');
		if (row) {
			if(row.isCooperate!=1){
				$('#win_generateCooperationOrder').window({
					href : '/meibo/operationalPart/cooperation/order/createCooperationOrder.html?orderItemId=' + row.id
				}).window('open');
			}else{
				$.messager.alert('提示信息', '已产生外发单，请点击外发单号直接查看！');
			}
		} else {
			$.messager.alert('提示信息', '请选择操作对象！');
		}
	}
	function listFactorys(){
		$('#win_listFactory').window({
			href : '/meibo/operationalPart/cooperation/factory/listFactorys.html'
		}).window('open');
	}	
	function onClick(rowIndex, rowData){
		$('#win_box').window({
			href : '/meibo/order/orderItem/packingForm.html?itemId=' + rowData.id
		}).window('open');
	}
	function onExpandRow(index, row) {
		$('#ddv-' + index).datagrid(
				{
					url : '/meibo/order/orderItem/listContent.html?f_order.id='
							+ row.id,
					fitColumns : true,
					singleSelect : true,
					rownumbers : true,
					onClickRow:onClick,
					height : 'auto',
					idField : 'id',//id字段
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
						field : 'singlebox',
						title : '个/箱',
						width : 70
					}, {
						field : 'totalbox',
						title : '箱数',
						width : 70
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
						$('#tt_operaOrder').datagrid('fixDetailRowHeight', index);
					},
					onLoadSuccess : function() {
						setTimeout(function() {
							$('#tt_operaOrder')
									.datagrid('fixDetailRowHeight', index);
						}, 0);
					}
				});
	}
	
</script>
