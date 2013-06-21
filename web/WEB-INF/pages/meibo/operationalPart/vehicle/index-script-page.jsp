<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	//添加
	function addVehicle(){
		$('#win_vehicle').window({
			href : '/meibo/operationalPart/vehicle/addForm.html'
		}).window('open');
	}
	//修改
	function editVehicle(){
		var row = $('#tt_vehicle').datagrid('getSelected');
		$('#win_vehicle').window({
			href : '/meibo/operationalPart/vehicle/addForm.html?vehicleId=' + row.id
		}).window('open');
	}
	//删除
	function delVehicle(){
		var row = $('#tt_vehicle').datagrid('getSelected');	
		if (row) {
			$.messager.confirm('警告', '你确定要删除选择吗?', function(r) {
					$.post('delete.html', {
						ids : row.id
					}, function(data) {
						var result = eval('(' + data + ')');
						if (result) {
							$.messager.alert('成功', '删除成功！');
							$('#tt_vehicle').datagrid('reload'); // reload the user data  
						} else {
							$.messager.alert('失败', '删除失败！');
						}
					}, 'json');
			});
		}
	}
	//删除
	function searchVehicle(){
		var storeEndDate = $('#storeEndDate').datebox('getValue');//时间
		var storeStartDate = $('#storeStartDate').datebox('getValue');//时间
		var orderNo = $('#search_orderNo').val();//订单号
		var deliveryAddress = $('#search_deliveryAddress').val();//送货地址
		var clerk = $('#search_clerk').val();//业务员
		var query = {};
		query['s_orderNo'] = orderNo;
		query['s_deliveryAddress'] = deliveryAddress;
		query['s_clerk'] = clerk;
		query['d_date'] = "s_" + storeStartDate+ ",e_" + storeEndDate;
		$("#tt_vehicle").datagrid('options').queryParams = query;
		$('#tt_vehicle').datagrid('reload');
	}
</script>
