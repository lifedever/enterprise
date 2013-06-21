<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
//查询
function searchContract(value) {
	var query = {};
	query['s_buyer'] = value;
	$("#tt_contract").datagrid('options').queryParams = query;
	$('#tt_contract').datagrid('reload');
}
function orderFormatter(value,row){
	return '<a href="#" onclick="viewOrder(\''+row.orderNo+'\')">'+row.orderNo+'</a>';
}
function viewOrder(orderNo){
	$('#win_viewOrder').window({
		href : '/meibo/order/viewOrderByOrderNo.html?orderNo=' + orderNo
	}).window('open');
}
function viewSign(){
	var row = $('#tt_contract').datagrid('getSelected');
	if (row) {
		$('#win_viewSign').window({
			href : '/meibo/contract/viewSign.html?orderNo=' + row.orderNo
		}).window('open');
	} else {
		$.messager.alert('提示信息', '请选择操作对象！');
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
function cancelSign(){
	var row = $('#tt_contract').datagrid('getSelected');
	if (row) {
		$.messager.confirm('警告', '确定要取消签单吗？注意：本操作不可恢复！', function(r) {
			if (r) {
				$.post('/meibo/contract/cancelSign.html?orderNo=' + row.orderNo,function(data){
					if (data) {
						$.messager.alert('提示信息', '操作成功！');
						$('#tt_contract').datagrid('reload'); // reload the user data
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
</script>
