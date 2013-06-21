<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	//添加
	function addRP(){
		$('#win_rp').window({
			href : '/finace/rp/addForm.html'
		}).window('open');
	}
	//修改
	function editRP(){
		var row = $('#tt_rp').datagrid('getSelected');
		$('#win_rp').window({
			href : '/finace/rp/addForm.html?rpId=' + row.id
		}).window('open');
	}
	//删除
	function delRP(){
		var row = $('#tt_rp').datagrid('getSelected');	
		if (row) {
			$.messager.confirm('警告', '你确定要删除选择吗?', function(r) {
				if (r) {
					$.post('delete.html', {
						ids : row.id
					}, function(data) {
						var result = eval('(' + data + ')');
						if (result) {
							$.messager.alert('成功', '删除成功！');
							$('#tt_rp').datagrid('reload'); // reload the user data  
						} else {
							$.messager.alert('失败', '删除失败！');
						}
					}, 'json');
			}
			});
		}else{
			$.messager.alert('提示信息', '请选择操作对象！');
		}
	}
	
	function typeFormatter(value){
		if (value == '0') {
			return '<span style="color:green">奖励</span>';
		}
		if (value == '1') {
			return '<span style="color:red">惩罚</span>';
		}
	}
	//删除
	function searchRP(){
		var storeEndDate = $('#storeEndDate').datebox('getValue');//时间
		var storeStartDate = $('#storeStartDate').datebox('getValue');//时间
		var userName = $('#search_userName').val();//订单号
		var type = $('#search_type').val();//送货地址
		var query = {};
		query['s_userName'] = userName;
		query['f_type'] = type;
		query['d_createDate'] = "s_" + storeStartDate+ ",e_" + storeEndDate;
		$("#tt_rp").datagrid('options').queryParams = query;
		$('#tt_rp').datagrid('reload');
	}
</script>
