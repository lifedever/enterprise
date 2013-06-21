<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
		
		function sureAdd(){
			var row = $('#tt_newFinishedProductForInstore').datagrid('getSelected');
			$('#win_newSure').window({
				href : '/meibo/storeroom/finishedproduct/addInstoreForm.html?productId='+row.id+"&workId="+$('#workId').val()+"&coopId="+$('#coopId').val()
			}).window('open');
		}
	
		function add() {
			var workId = $('#workId').val();
			var coopId = $('#coopId').val();
			$.post('/meibo/storeroom/finishedproduct/add.html', {
				workIds : workId, coopIds : coopId
			}, function(data) {
				var result = eval('(' + data + ')');
				if (result) {
					$.messager.alert('成功', '新增成功！');
					//$('#tt_newCommodity').datagrid('reload'); // reload the user data  
				} else {
					$.messager.alert('失败', '新增数量不能大于入库剩余数量！');
				}
			}, 'json');
		}
		//查询
		function searchFinishedProductForInstore(){
			var productName = $('#search_productNameforinstore').val();//商品名称
			var contourSize = $('#search_contourSizeforinstore').val();//入库开始时间
			var query = {};
			query['s_productName'] = productName;
			query['s_contourSize'] = contourSize;
			$("#tt_newFinishedProductForInstore").datagrid('options').queryParams = query;
			$('#tt_newFinishedProductForInstore').datagrid('reload');
		}
	</script>