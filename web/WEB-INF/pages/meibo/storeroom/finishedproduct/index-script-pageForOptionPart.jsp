<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
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