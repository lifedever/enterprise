<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
		//查询
		function searchInOutstore(){
			var operation = $('#search_operation').val();//操作类型
			var orderNo = $('#search_orderNo').val();//商品名称
			var name = $('#search_name').val();//供应商名称
			var pickinger = $('#search_pickinger').val();
			var recorder = $('#search_recorder').val();
			var query = {};
			query['f_operation'] = operation;
			query['s_orderNo'] = orderNo;
			query['s_finishedProductName'] = name;
			query['s_pickinger'] = pickinger;
			query['s_recorder'] = recorder;
			$("#tt_newProductInOutstore").datagrid('options').queryParams = query;
			$('#tt_newProductInOutstore').datagrid('reload');
		}
	</script>