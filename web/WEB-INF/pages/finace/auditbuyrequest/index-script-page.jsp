<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
		
		function auditBuyrequest() {
			var row = $('#tt_buyRequest').datagrid('getSelected');
			if(row){
				$('#win_auditbuyRequest').window({
					href : '/finace/auditbuyrequest/auditForm.html?buyRequestId='+row.id
				}).window('open');
			}
		}
		
		function newBuyRequestItem(){
			$('#win_addBuyRequestItem').window({
				href : '/meibo/storeroom/buyrequestitem/addItemForm.html'
			}).window('open');
		}
		
		function formatBuyrequestNo(value, row){
			return '<a href="#" onclick="viewBuyRequestNo(\''+row.buyRequestNo+'\')">'+row.buyRequestNo+'</a>';
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
		
		function saveAudit() {
			$('#fmAudit').form('submit', {
				url : '/finace/auditbuyrequest/auditBuyRequest.html',
				onSubmit : function() {
					return $(this).form('validate');
				},
				success : function(result) {
					if (result == 'false') {
						$.messager.alert('提示信息', '请填写备注信息！');
					} else {
						$.messager.alert('提示信息', '操作成功！');
						$('#dlgAuditBuy').dialog('close'); // close the dialog  
						$('#tt_buy').datagrid('reload'); // reload the user data  
					}
				}
			});
		}
	</script>