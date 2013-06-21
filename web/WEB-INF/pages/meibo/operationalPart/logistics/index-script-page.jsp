<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	//添加
	function addLogistics(){
		$('#win_logistics').window({
			href : '/meibo/operationalPart/logistics/addForm.html'
		}).window('open');
	}
	//修改
	function editLogistics(){
		var row = $('#tt_logistics').datagrid('getSelected');
		$('#win_logistics').window({
			href : '/meibo/operationalPart/logistics/addForm.html?logisticsId=' + row.id
		}).window('open');
	}
	//删除
	function delLogistics(){
		var row = $('#tt_logistics').datagrid('getSelected');	
		if (row) {
			$.messager.confirm('警告', '你确定要删除选择吗?', function(r) {
					$.post('delete.html', {
						ids : row.id
					}, function(data) {
						var result = eval('(' + data + ')');
						if (result) {
							$.messager.alert('成功', '删除成功！');
							$('#tt_logistics').datagrid('reload'); // reload the user data  
						} else {
							$.messager.alert('失败', '删除失败！');
						}
					}, 'json');
			});
		}
	}
	//删除
	function searchLogistics(){
		var storeEndDate = $('#storeEndDate').datebox('getValue');//时间
		var storeStartDate = $('#storeStartDate').datebox('getValue');//时间
		var orderNo = $('#search_orderNo').val();//订单号
		var destination = $('#search_destination').val();//送货地址
		var goods = $('#search_goods').val();//业务员
		var query = {};
		query['s_orderNo'] = orderNo;
		query['s_destination'] = destination;
		query['s_goods'] = goods;
		query['d_shipDate'] = "s_" + storeStartDate+ ",e_" + storeEndDate;
		$("#tt_logistics").datagrid('options').queryParams = query;
		$('#tt_logistics').datagrid('reload');
	}
</script>
