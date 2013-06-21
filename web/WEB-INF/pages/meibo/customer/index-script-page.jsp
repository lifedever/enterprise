<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	//新建客户
	function newCustomer() {
		$('#win_newCustomer').window({
			href : '/meibo/customer/addForm.html'
		}).window('open');
	}
	//编辑客户
	function editCustomer() {
		var row = $('#tt_newCustomer').datagrid('getSelected');
		if (row) {
			$('#win_newCustomer').window({
				href : '/meibo/customer/addForm.html?customerId=' + row.id
			}).window('open');
		} else {
			$.messager.alert('提示信息', '请选择操作对象！');
		}
	}
	//删除客户
	function delCustomer() {
		var row = $('#tt_newCustomer').datagrid('getSelected');
		if (row) {
			$.messager.confirm('警告', '你确定要删除选择吗?', function(r) {
				if (r) {
					$.post('/meibo/customer/deleteCustomer.html', {
						customerId : row.id
					}, function(data) {
						if (data) {
							$('#tt_newCustomer').datagrid('reload');
						} else {
							$.messager.alert('提示信息', '操作失败！');
						}
					})
				}
			});
		} else {
			$.messager.alert('提示信息', '请选择操作对象！');
		}
	}

	//询价
	function askOffer() {
		var row = $('#tt_newCustomer').datagrid('getSelected');
		if (row) {
			$('#win_askOffer').window({
				href : '/meibo/offer/askOffer.html?customerId=' + row.id
			}).window('open');
		} else {
			$.messager.alert('提示信息', '请选择操作对象！');
		}
	}
	//询价详情列表
	function showOffers(){
		var row = $('#tt_newCustomer').datagrid('getSelected');
		if (row) {
			$('#win_listOffer').window({
				href : '/meibo/offer/list.html?customerId=' + row.id
			}).window('open');
		} else {
			$.messager.alert('提示信息', '请选择操作对象！');
		}
	}
	
	//查询
	function searchCustomer(value) {
		var query = {};
		query['s_customerName'] = value;
		$("#tt_newCustomer").datagrid('options').queryParams = query;
		$('#tt_newCustomer').datagrid('reload');
	}
	//添加询价条目
	function newOfferItem(){
		$('#win_addOfferItem').window({
			href : '/meibo/offer/offerItem/addItemForm.html'
		}).window('open');
	}
	
	//添加用料明细
	function detailFormatter() {
		var row = $('#tt_addOfferItem').datagrid('getSelected');
		if(row){
			$('#win_addDetail').window({
				href : '/meibo/offer/materialdetail/addDetailForm.html?itemId='+row.id
			}).window('open');
		}
		
	}
	
	function showItemsFormat(value, row, index){
		return '<a href="#" onclick="showItems(\''+row.id+'\')">查看详情</a>';
	}
	//询价条目详情
	function showItems(offerId){
		$('#win_showOfferItems').window({
			href : '/meibo/offer/offerItem/showList.html?offerId='+offerId
		}).window('open');
	}
	//
	function lastOfferFormatter(value, row, index){
		if(value){
			return formatDate(value, row, index);
		}else{
			return formatNull(value, row, index);
		}
	}
	//格式化客户名
	function formatterCustomerName(value,row){
		return '<a href="javascript:viewCustomer(\''+row.id+'\')">'+value+'</a>';
	}
	//查看客户
	function viewCustomer(customerId){
		$('#win_viewCustomer').window({
			href : '/meibo/customer/viewCustomer.html?customerId='+customerId
		}).window('open');
	}
	function beforeAskOffer(){
		var rows = $('#tt_addOfferItem').datagrid('getRows');
		if(rows.length==0){
			$.messager.alert('提示信息', '请添加询价条目！');
			return false;
		}
	}
	
	function formatMDetail(value){
		return '<a href="#" onclick="viewMDetail(\''+value+'\')">查看</a>';
	}
	
	function viewMDetail(value){
		$('#win_viewDetail').window({
			href : '/meibo/offer/materialdetail/list.html?itemId='+value
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
</script>