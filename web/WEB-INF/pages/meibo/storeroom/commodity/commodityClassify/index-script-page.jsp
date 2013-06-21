<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
		var urll ="";
		function addClassify() {
			$('#win_newCommodityClassify').window({
				href : '/meibo/storeroom/commodity/commodityClassify/addForm.html'
			}).window('open');
		}

		function editClassify() {
			var row = $('#tt_newCommodityClassify').datagrid('getSelected');
			if (row) {
				$('#win_newCommodityClassify').window({
					href : '/meibo/storeroom/commodity/commodityClassify/addForm.html?connodityClassifyId=' + row.id
				}).window('open');
			}
		}
		
		function saveClassify() {
			$('#fm_classify').form('submit', {
				url : urll,
				success : function(data) {
					var result = eval('(' + data + ')');
					if (result) {
						$.messager.alert('提示信息', '操作成功！');
						$('#dlg_classify').dialog('close'); // close the dialog
						$('#tt').datagrid('reload');
					} else {
						$.messager.alert('提示信息', '操作失败！');
					}
				}
			});
		}

		function delClassify() {
			var rows = $('#tt_newCommodityClassify').datagrid('getSelections');
			if (rows != null && rows.length > 0) {
				$.messager.confirm('警告', '你确定要删除选择吗?', function(r) {
					if (r) {
						var ids = '';
						for ( var i = 0; i < rows.length; i++) {
							ids = ids + rows[i].id + ",";
						}
						$.post('/meibo/storeroom/commodity/commodityClassify/deleteClassify.html', {
							ids : ids
						}, function(data) {
							var result = eval('(' + data + ')');
							if (result) {
								$.messager.alert('成功', '删除成功！');
								$('#tt_newCommodityClassify').datagrid('reload'); // reload the user data  
							} else {
								$.messager.alert('失败', '删除失败！');
							}
						}, 'json');
					}
				});
			}
		}
	</script>