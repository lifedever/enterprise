<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	
		var urll = "";
		function changeSel() {
			var val = $('#searchPro').combobox('getValue');
			var query = {};
			query['providerId'] = val;
			$("#tt").datagrid('options').queryParams = query;
			$('#tt').datagrid('reload');
		}
		function isProofFormatter(value){
			if(value == '1'){
				return '<font color="green">样品</font>'
			}else{
				return '<font color="red">成品</font>'
			}
		}
		function addFinishedProduct() {
			$('#win_newFinishedProduct').window({
				href : '/meibo/storeroom/finishedproduct/addForm.html'
			}).window('open');
		}
		function editFinishedProduct() {
			var row = $('#tt_newFinishedProduct').datagrid('getSelected');
			if (row) {
				$('#win_newFinishedProduct').window({
					href : '/meibo/storeroom/finishedproduct/addForm.html?finishedproductId='+row.id
				}).window('open');
			}
		}

		function delFinishedProduct() {
			var rows = $('#tt_newFinishedProduct').datagrid('getSelections');
			if (rows != null && rows.length > 0) {
				$.messager.confirm('警告', '你确定要删除选择吗?', function(r) {
					if (r) {
						var ids = '';
						for ( var i = 0; i < rows.length; i++) {
							ids = ids + rows[i].id + ",";
						}
						$.post('delFinishedProduct.html', {
							ids : ids
						}, function(data) {
							var result = eval('(' + data + ')');
							if (result) {
								$.messager.alert('成功', '删除成功！');
								$('#tt_newFinishedProduct').datagrid('reload'); // reload the user data  
							} else {
								$.messager.alert('失败', '删除失败！');
							}
						}, 'json');
					}
				});
			}
		}
		
		//成品出库
		function productOutStore(){
			var row = $('#tt_newFinishedProduct').datagrid('getSelected');
			if (row) {
				$('#win_newProductOutStore').window({
					href : '/meibo/storeroom/finishedproduct/productOutStore.html?finishedproductId='+row.id
				}).window('open');
			}
		}
		
		//成品入库
		function productInStore(){
			var row = $('#tt_newFinishedProduct').datagrid('getSelected');
			if (row) {
				$('#win_newProductInStore').window({
					href : '/meibo/storeroom/finishedproduct/productInStore.html?finishedproductId='+row.id
				}).window('open');
			}
		}

		//查询
		function searchFinishedProduct(){
			var productName = $('#search_productName').val();//商品名称
			var producer = $('#search_producer').val();//供应商名称
			var contourSize = $('#search_contourSize').val();//入库开始时间
			var query = {};
			query['s_productName'] = productName;
			query['s_producer'] = producer;
			query['s_contourSize'] = contourSize;
			$("#tt_newFinishedProduct").datagrid('options').queryParams = query;
			$('#tt_newFinishedProduct').datagrid('reload');
		}
	</script>