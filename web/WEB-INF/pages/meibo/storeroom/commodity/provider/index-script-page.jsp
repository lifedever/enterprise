<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
		function addProvider() {
			$('#win_newProvider').window({
				href : '/meibo/storeroom/commodity/provider/addForm.html'
			}).window('open');
		}

		function editProvider() {
			var row = $('#tt_newProvider').datagrid('getSelected');
			if (row) {
				$('#win_editProvider').window({
					href : '/meibo/storeroom/commodity/provider/addForm.html?providerId='+row.id
				}).window('open');
			}
		}

		function delProvider() {
			var rows = $('#tt_newProvider').datagrid('getSelections');
			if (rows != null && rows.length > 0) {
				$.messager.confirm('警告', '你确定要删除选择吗?', function(r) {
					if (r) {
						var ids = '';
						for ( var i = 0; i < rows.length; i++) {
							ids = ids + rows[i].id + ",";
						}
						$.post('/meibo/storeroom/commodity/provider/deleteProvider.html', {
							ids : ids
						}, function(data) {
							var result = eval('(' + data + ')');
							if (result) {
								$.messager.alert('成功', '删除成功！');
								$('#tt_newProvider').datagrid('reload'); // reload the user data  
							} else {
								$.messager.alert('失败', '删除失败！');
							}
						}, 'json');
					}
				});
			}
		}
	</script>