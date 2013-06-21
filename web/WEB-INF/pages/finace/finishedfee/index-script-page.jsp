<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
		
		function orderItemCostFormatter(value,row){
			value = row.price*row.productCount
			 return"￥ <strong>" + value + "</strong>";
		}
		//收款
		function gathering(){
			var row = $('#tt_newFinishedfee').datagrid('getSelected');
			if (row) {
				$('#win_newFinishedFee').window({
					href : '/finace/finishedfee/addForm.html?orderId='+row.id
				}).window('open');
			}
		}
		
		function finishFormatter(value,row){
			if(Number(row.allCount)==Number(row.hasCount)){
				return '<font color="green">已完成</font>';
			}else{
				return '<font color="red">未完成</font>';
			}
		}
		function orderFormatter(value,row){
			return '<a href="#" onclick="viewOrder(\''+row.orderNo+'\')">'+row.orderNo+'</a>';
		}
		
		function viewOrderNo(orderNo){
			$('#win_viewFinfishedFeeDetail').window({
				href : '/finace/finishedfee/detailIndex.html?orderNo='+orderNo
			}).window('open');
		}

		//查看收款详细
		function orderNoFormatter(value, row){
			return '<a href="#" onclick="viewOrderNo(\''+row.orderNo+'\')">'+row.orderNo+'</a>';
			
		}
		// 类型
		function isProofFormatter(value){
			if (value == '0') {
				return '<span style="color:red">产品</span>';
			}
			if (value == '1') {
				return '<span style="color:green">样品</span>';
			}
		}
		function checkMoney(){
			var countMoney = $('#countMoney').val();
			var hasMoney = $('#hasMoney').val();
			var hasCount = $('#hasCount').val();
			if(Number(countMoney) <  Number(hasMoney) + Number(hasCount)){
				$.messager.alert('提示信息', '收款金额不能超过全款!');
				$('#hasCount').val(0.00);
			}
		}
		//查询
		function searchFinishedFee(){
			var orderNo = $('#search_orderNo').val();//订单编号
			var customerName = $('#search_customerName').val();//客户姓名
			var isProof = $('#search_isProof').val();
			var query = {};
			query['s_orderNo'] = orderNo;
			query['s_customerName'] = customerName;
			query['f_isProof'] = isProof;
			$("#tt_newFinishedfee").datagrid('options').queryParams = query;
			$('#tt_newFinishedfee').datagrid('reload');
		}
		
		//查看订单下产品
		function detailFormatter(index, row) {
			return '<div style="padding:2px"><table id="ddv-' + index + '"></table></div>';
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
							field : 'price',
							title : '单价',
							formatter:formatMoney,
							width : 70
						},{
							field : 'productCount',
							title : '数量',
							width : 50
						},{
							field : 'xxx',
							title : '总价',
							width : 70,
							formatter:orderItemCostFormatter
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
							$('#tt_newFinishedfee').datagrid('fixDetailRowHeight', index);
						},
						onLoadSuccess : function() {
							setTimeout(function() {
								$('#tt_newFinishedfee')
										.datagrid('fixDetailRowHeight', index);
							}, 0);
						}
					});
		}
	</script>