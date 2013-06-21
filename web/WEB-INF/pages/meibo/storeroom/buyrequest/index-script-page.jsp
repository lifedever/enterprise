<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
		
		function addBuyrequest() {
			$('#win_buyRequest').window({
				href : '/meibo/storeroom/buyrequest/addForm.html'
			}).window('open');
		}
		
		function editBuyrequest() {
			var row = $('#tt_buyRequest').datagrid('getSelected');
			if (row) {
				$('#win_editbuyRequest').window({
					href : '/meibo/storeroom/buyrequest/editForm.html?buyRequestId='+row.id
				}).window('open');
			}
		}

		function delBuyrequest() {
			var rows = $('#tt_buyRequest').datagrid('getSelections');
			if (rows != null && rows.length > 0) {
				$.messager.confirm('警告', '你确定要删除选择吗?', function(r) {
					if (r) {
						var ids = '';
						for ( var i = 0; i < rows.length; i++) {
							ids = ids + rows[i].id + ",";
						}
						$.post('deleteBuyRequest.html', {
							ids : ids
						}, function(data) {
							var result = eval('(' + data + ')');
							if (result) {
								$.messager.alert('成功', '删除成功！');
								$('#tt_buyRequest').datagrid('reload'); // reload the user data  
							} else {
								$.messager.alert('失败', '删除失败！');
							}
						}, 'json');
					}
				});
			}
		}
		
		function newBuyRequestItem(){
			$('#win_addBuyRequestItem').window({
				href : '/meibo/storeroom/buyrequestitem/addItemForm.html'
			}).window('open');
		}
		
		function delBuyRequestItem(){
			var row = $('#tt_addBuyRequestItem').datagrid('getSelected');
			var idd =  $('#tt_addBuyRequestItem').datagrid('getRowIndex',row);
			$.post('/meibo/storeroom/buyrequestitem/deleteBuyRequestItem.html', {
				id : idd
			}, function(data) {
				var result = eval('(' + data + ')');
				if (result) {
					$.messager.alert('成功', '删除成功！');
					$('#tt_addBuyRequestItem').datagrid('reload'); // reload the user data  
				} else {
					$.messager.alert('失败', '删除失败！');
				}
			}, 'json');
			// alert(row.getRowIndex());
		}
		
		function formatBuyrequestNo(value, row){
			return '<a href="#" onclick="viewBuyRequestNo(\''+row.buyRRequestNo+'\')">'+row.buyRequestNo+'</a>';
		}
		
		function viewBuyRequestNo(buyRequestNo){
			$('#win_viewBuyrequest').window({
				href : '/meibo/storeroom/buyrequest/detailIndex.html?buyRequestNo='+buyRequestNo
			}).window('open');
		}
		
		//查询
		function searchCommodity(){
			var buyrequestno = $('#search_buyrequestno').val();//请购单号
			var requester = $('#search_requester').val();//请购人
			var buyer = $('#search_buyer').val();//采购人
			var buyStartDate = $('#buyStartDate').datebox('getValue');//采购开始时间
			var buyEndDate = $('#buyEndDate').datebox('getValue');//采购结束时间
			var query = {};
			query['s_buyrequestno'] = buyrequestno;
			query['s_requester'] = requester;
			query['s_buyer'] = buyer;
			query['d_buyDate'] = "s_" + buyStartDate+ ",e_" + buyEndDate;
			$("#tt_buyRequest").datagrid('options').queryParams = query;
			$('#tt_buyRequest').datagrid('reload');
		}
	</script>