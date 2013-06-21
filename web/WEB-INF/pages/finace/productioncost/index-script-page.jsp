<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
		
		
		//收款
		function gathering(){
			var row = $('#tt_newProductioncost').datagrid('getSelected');
			if (row) {
				$('#win_newFinishedFee').window({
					href : '/finace/finishedfee/addForm.html?orderId='+row.id
				}).window('open');
			}
		}
		
		
		function viewProductNo(productNo){
			$('#win_viewProductCost').window({
				href : '/finace/productioncost/detailIndex.html?productNo='+productNo
			}).window('open');
		}

		//查看收款详细
		function productNoFormatter(value, row){
			return '<a href="#" onclick="viewProductNo(\''+row.productNo+'\')">'+row.productNo+'</a>';
			
		}
		// 类型
		function isProofFormatter(value){
			if (value == '0') {
				return '<span style="color:red">产品</span>';
			}
			if (value == '1') {
				return '<span style="color:green">样品</span>';
			}
		}
		//查询
		function searchProductCost(){
			var productNo = $('#search_productNo').val();//订单编号
			var productName = $('#search_productName').val();//客户姓名
			var isProof = $('#search_isProof').val();
			var query = {};
			query['s_productNo'] = productNo;
			query['s_productName'] = productName;
			query['f_isProof'] = isProof;
			$("#tt_newProductioncost").datagrid('options').queryParams = query;
			$('#tt_newProductioncost').datagrid('reload');
		}
		//额外支出
		function extraCost(){
			var row = $('#tt_newProductioncost').datagrid('getSelected');
			if(row){
				$('#win_newProductioncost').window({
					href : '/finace/productioncost/extraCostForm.html?productNo='+row.productNo
				}).window('open');
			}else{
				$.messager.alert('提示信息','请选择操作对象!');
			}
		}
	</script>