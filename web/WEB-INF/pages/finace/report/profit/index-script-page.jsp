<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	//新建
	function newProfit() {
		$('#win_newProfit').window({
			href : '/finace/report/profit/addForm.html'
		}).window('open');
	}
	//编辑
	function editProfit(){
		var row = $('#tt_newProfit').datagrid('getSelected');
		if (row) {
			$('#win_newProfit').window({
				href : '/finace/report/profit/addForm.html?id=' + row.id
			}).window('open');
		} else {
			$.messager.alert('提示信息', '请选择操作对象！');
		}
	}
	//删除
	function delProfit(){
		var row = $('#tt_newProfit').datagrid('getSelected');
		if (row) {
			$.messager.confirm('警告', '你确定要删除选择吗?', function(r) {
				if (r) {
					$.post('/finace/report/profit/delProfit.html',{
						id:row.id						
					},function(data){
						$.messager.alert('提示信息', '操作成功！');
						$('#tt_newProfit').datagrid('reload');
					});
				}
			});
		}else {
			$.messager.alert('提示信息', '请选择操作对象！');
		}
	}
</script>