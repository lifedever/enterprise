<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	//查询
	function searchOffer(value) {
		var query = {};
		query['s_customer.customerName'] = value;
		$("#tt_offer").datagrid('options').queryParams = query;
		$('#tt_offer').datagrid('reload');
	}
	function detailFormatter(index, row) {
		return '<div style="padding:2px"><table id="ddv-' + index + '"></table></div>';
	}
	
	function isProofFormatter(value){
		if (value == '0') {
			return '<span style="color:red">产品</span>';
		}
		if (value == '1') {
			return '<span style="color:green">样品</span>';
		}
	}
	function offerMoneyStateFormatter(value) {
		if (value == '0') {
			return '<span style="color:red">未报价</span>';
		}
		if (value == '1') {
			return '<span style="color:green">已报价</span>';
		}
	}
	function orderFormatter(value,row){
		if (value == '0') {
			return '<span style="color:red">未下订单</span>';
		}
		if (value == '1') {
			return '<a href="#" onclick="viewOrder(\''+row.orderNo+'\')">'+row.orderNo+'</a>';
		}
	}
	function viewOrder(orderNo){
		$('#win_viewOrder').window({
			href : '/meibo/order/viewOrderByOrderNo.html?orderNo=' + orderNo
		}).window('open');
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
	function offerStateFormatter(value) {
		if (value == '0') {
			return '<span style="color:red">未同意报价</span>';
		}
		if (value == '1') {
			return '<span style="color:green">已同意报价</span>';
		}
	}
	//报价详情
	function showMoneyAudit() {
		var row = $('#tt_offer').datagrid('getSelected');
		if (row) {
			$('#win_offerMoneyDetail').window({
				href : '/meibo/offer/showAuditOffer.html?offerId=' + row.id
			}).window('open');
		} else {
			$.messager.alert('提示信息', '请选择操作对象！');
		}
	}
	//查看报价列表
	function showOfferMoney() {
		var row = $('#tt_showAuditOffer').datagrid('getSelected');
		if (row) {
			$('#win_listOfferMoney')
					.window(
							{
								href : '/meibo/offer/offerMoney/showAuditOffer.html?offerItemId='
										+ row.id
							}).window('open');
		} else {
			$.messager.alert('提示信息', '请选择操作对象！');
		}
	}
	//是否同意报价
	function askAuditForm() {
		var rows = $('#tt_itemShow').datagrid('getRows');
		if (rows[0]) {
			$('#win_itemShow')
					.window(
							{
								href : '/meibo/offer/offerMoney/askForm.html?offerMoneyId='
										+ rows[0].id
							}).window('open');
		} else {
			$.messager.alert('提示信息', '请先提醒业务经理进行报价！');
		}
	}
	//生成订单
	function generateOrder() {
		var row = $('#tt_offer').datagrid('getSelected');
		if (row) {
			if (row.offerState != '1') {
				$.messager.alert('提示信息', '未同意报价，不能生成订单！');
			} else {
				$('#win_generateOrder').window({
					href : '/meibo/offer/generateOrder.html?offerId=' + row.id+'&customerId='+row.customerId
				}).window('open');
			}
		} else {
			$.messager.alert('提示信息', '请选择操作对象！');
		}
	}
	//保存生成订单的回调函数
	function generateOrderSuccess(data){
		if(data){
			$.messager.alert('提示信息', '操作成功！');
			$('#win_generateOrder').window('close');
			$('#tt_offer').datagrid('reload');
		}else{
			$.messager.alert('提示信息', '操作失败！');
		}
	}
	//格式化是否同意报价
	function askStateFormatter(index, row) {
		if (row.askState == '1') {
			return '<font color="green">同意</font>';
		} else {
			return '<font color="red">未同意</font>';
		}
	}
	//添加订单条目，来自报价单
	function newOrderItem(offerId) {
		$('#win_listOfferItem').window({
			href : '/meibo/offer/offerItem/list.html?offerId=' + offerId
		}).window('open');
	}
	//选定询价条目
	function selectOfferItem() {
		var rows = $('#tt_listOfferItem').datagrid('getSelections');
		if (rows.length == 0) {
			$.messager.alert('提示信息', '请选择操作对象！');
		} else {
			var ids = new Array();
			for ( var i = 0; i < rows.length; i++) {
				ids.push(rows[i].id);
			}
			$.post('/meibo/order/orderItem/saveTempOrderItem.html?ids=' + ids,
					function(data) {
						if (data) {
							$('#win_listOfferItem').window('close')
							$('#tt_editOfferItem').datagrid('reload');
						} else {
							$.messager.alert('提示信息', '操作失败！');
						}
					});
		}
	}
	//修改订单条目
	function editOrderItem(){
		var row = $('#tt_editOfferItem').datagrid('getSelected');
		if (row) {
			$('#win_editOfferItem').window({
				href : '/meibo/order/orderItem/formTempOrderItem.html?orderItemid=' + row.id
			}).window('open');
		} else {
			$.messager.alert('提示信息', '请选择操作对象！');
		}
	}
	//移除询价条目
	function removeOrderItem() {
		var row = $('#tt_editOfferItem').datagrid('getSelected');
		if (row) {
			$.post('/meibo/order/orderItem/removeTempOrderItem.html?orderItemid=' + row.id,
					function(data) {
						if (data) {
							$('#tt_editOfferItem').datagrid('reload');
						} else {
							$.messager.alert('提示信息', '操作失败！');
						}
					});
		} else {
			$.messager.alert('提示信息', '请选择操作对象！');
		}
	}
	function signFormatter(value,row) {
		if (value == '1'&&row.contractNo!='') {
			return '<span style="color:green">合同编号：'+row.contractNo+'</span>';
		}else{
			return '<span style="">无</span>';
		}
	}
	function signForm(){
		var row = $('#tt_offer').datagrid('getSelected');
		if (row) {
			if(row.isOrder==0){
				$.messager.alert('提示信息', '请先下订单！');
			}else{
				if(row.signState=='1'){
					$.messager.alert('提示信息', '无需签单或已签单！');
				}else{
					$('#win_signForm').window({
						href : '/meibo/contract/signForm.html?orderNo=' + row.orderNo
					}).window('open');
				}
			}
		} else {
			$.messager.alert('提示信息', '请选择操作对象！');
		}
	}
	function viewSign(){
		var row = $('#tt_offer').datagrid('getSelected');
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
	function cancelSign(){
		var row = $('#tt_offer').datagrid('getSelected');
		if (row) {
			$.messager.confirm('警告', '确定要取消签单吗？注意：本操作不可恢复！', function(r) {
				if (r) {
					$.post('/meibo/contract/cancelSign.html?orderNo='+row.orderNo,function(data){
						if (data) {
							$.messager.alert('提示信息', '操作成功！');
							$('#tt_offer').datagrid('reload'); // reload the user data
						} else {
							$.messager.alert('提示信息', '操作失败！');
						}
					});
				}
			});
		} else {
			$.messager.alert('提示信息', '请选择操作对象！');
		}
	}
	/**
	 * 删除报价
	 */
	function delOffer(){
		var row = $('#tt_offer').datagrid('getSelected');
		if (row) {
			$.messager.confirm('警告', '确定要删除报价信息吗？注意：本操作不可恢复！', function(r) {
				if (r) {
					$.post('/meibo/offer/delOffer.html?offerId='+row.id,function(data){
						if (data) {
							$.messager.alert('提示信息', '操作成功！');
							$('#tt_offer').datagrid('reload'); // reload the user data
						} else {
							$.messager.alert('提示信息', '操作失败！');
						}
					});
				}
			});
		} else {
			$.messager.alert('提示信息', '请选择操作对象！');
		}
	}
	
	/**
	 * 删除报价
	 */
	function delOffer2(){
		var row = $('#tt_offer').datagrid('getSelected');
		if (row) {
			if(row.moneyState!='1'){
				$.messager.confirm('警告', '确定要删除报价信息吗？注意：本操作不可恢复！', function(r) {
					if (r) {
						$.post('/meibo/offer/delOffer.html?offerId='+row.id,function(data){
							if (data) {
								$.messager.alert('提示信息', '操作成功！');
								$('#tt_offer').datagrid('reload'); // reload the user data
							} else {
								$.messager.alert('提示信息', '操作失败！');
							}
						});
					}
				});
			}else{
				$.messager.alert('提示信息', '已报价,无法删除！');
			}
		} else {
			$.messager.alert('提示信息', '请选择操作对象！');
		}
	}
	
	function viewDetail(id){
		$('#win_viewDetail').window({
			href : '/meibo/orrer/viewOrderByOrderNo.html?orderNo=' + orderNo
		}).window('open');
	}
	
	function formatDetail(value){
		return '<span style="color:green">'+'<a href="#" onclick="viewMaterialDetail(\''+value+'\')">查看明细</a>'+'</span>';
	}
	function viewMaterialDetail(value){
		$('#win_viewMaterialDetail').window({
			href : '/meibo/offer/materialdetail/index.html?itemId=' + value
		}).window('open');
	}
	function formatMType(value){
		if (value == '0') {
			return '<span style="color:red">材料</span>';
		}
		if (value == '1') {
			return '<span style="color:green">辅料</span>';
		}
	}
	function onExpandRow(index, row) {
		$('#ddv-' + index).datagrid(
				{
					url : '/meibo/offer/offerItem/listContent.html?f_offer.id='
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
						field : 'productPrice',
						title : '已报价格',
						width : 70,
						formatter : formatMoney
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
					} , {
						field : 'id',
						title : '用料明细',
						width : 80,
						formatter : formatDetail
					}] ],
					onResize : function() {
						$('#tt_offer').datagrid('fixDetailRowHeight', index);
					},
					onLoadSuccess : function() {
						setTimeout(function() {
							$('#tt_offer')
									.datagrid('fixDetailRowHeight', index);
						}, 0);
					}
				});
	}
</script>
