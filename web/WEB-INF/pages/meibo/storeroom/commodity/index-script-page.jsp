<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
		$('#name').on('blur',function(){
			$.post('checkCommodity.html?name='+$('#name').val(),function(data){
				var result = eval('(' + data + ')');
				if(!result){
					$.messager.confirm('警告', '已存在货源"'+$('#name').val()+'"，是否确定添加新的？', function(r) {
						if (!r) {
							$('#dlg_commodity').dialog('close')
						}
					});
				}
			});
		});
	
		var urll = "";
		function changeSel() {
			var val = $('#searchPro').combobox('getValue');
			var query = {};
			query['providerId'] = val;
			$("#tt").datagrid('options').queryParams = query;
			$('#tt').datagrid('reload');
		}
		function addCommodity() {
			$('#win_newCommodity').window({
				href : '/meibo/storeroom/commodity/addForm.html'
			}).window('open');
		}
		function editCommodity() {
			var row = $('#tt_newCommodity').datagrid('getSelected');
			if (row) {
				$('#win_newCommodity').window({
					href : '/meibo/storeroom/commodity/addForm.html?commodityId='+row.id
				}).window('open');
				
				if (row.providerName != "") {
					$('#providerCombox').combobox('setValue', row.providerName);
				}
				$('#providerCombox').combobox('reload',
						'/provider/loadCombobox.html');
				$('#classifyCombox').combobox('reload',
						'/commodityClassify/loadCombobox.html');
			}
		}

		function delCommodity() {
			var rows = $('#tt_newCommodity').datagrid('getSelections');
			if (rows != null && rows.length > 0) {
				$.messager.confirm('警告', '你确定要删除选择吗?', function(r) {
					if (r) {
						var ids = '';
						for ( var i = 0; i < rows.length; i++) {
							ids = ids + rows[i].id + ",";
						}
						$.post('deleteCommodity.html', {
							ids : ids
						}, function(data) {
							var result = eval('(' + data + ')');
							if (result) {
								$.messager.alert('成功', '删除成功！');
								$('#tt_newCommodity').datagrid('reload'); // reload the user data  
							} else {
								$.messager.alert('失败', '删除失败！');
							}
						}, 'json');
					}
				});
			}
		}
		
		//材料出库
		function outStore(){
			var row = $('#tt_newCommodity').datagrid('getSelected');
			if (row) {
				$('#win_newOutStore').window({
					href : '/meibo/storeroom/commodity/outStore.html?commodityId='+row.id
				}).window('open');
			}
		}
		
		//材料入库
		function inStore(){
			var row = $('#tt_newCommodity').datagrid('getSelected');
			if (row) {
				$('#win_newInStore').window({
					href : '/meibo/storeroom/commodity/inStore.html?commodityId='+row.id
				}).window('open');
			}
		}

		//添加供货商
		function newProvider() {
			$('#win_newProvider').window({
				href : '/meibo/storeroom/commodity/provider/addForm.html'
			}).window('open');
		}

		//保存供货商
		function saveProvider() {
			$('#fm_provider').form(
					'submit',
					{
						url : url,
						success : function(data) {
							var result = eval('(' + data + ')');
							if (result) {
								$.messager.alert('提示信息', '操作成功！');
								$('#providerCombox').combobox('setValue',
										$('#companyName').val());
								$('#dlg_provider').dialog('close'); // close the dialog
							} else {
								$.messager.alert('提示信息', '公司已存在，请重新录入！');
							}
						}
					});
		}
		
		//查询
		function searchCommodity(){
			var name = $('#search_name').val();//商品名称
			var providerName = $('#search_providerName').val();//供应商名称
			var storeStartDate = $('#storeStartDate').datebox('getValue');//入库开始时间
			var storeEndDate = $('#storeEndDate').datebox('getValue');//入库结束时间
			var query = {};
			query['s_name'] = name;
			query['s_provider.companyName'] = providerName;
			query['d_createDate'] = "s_" + storeStartDate+ ",e_" + storeEndDate;
			$("#tt_newCommodity").datagrid('options').queryParams = query;
			$('#tt_newCommodity').datagrid('reload');
		}
	</script>