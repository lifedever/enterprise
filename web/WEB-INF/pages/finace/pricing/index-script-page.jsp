<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
	$('#name').on(
			'blur',
			function() {
				$.post('checkCommodity.html?name=' + $('#name').val(),
						function(data) {
							var result = eval('(' + data + ')');
							if (!result) {
								$.messager.confirm('警告', '已存在货源"'
										+ $('#name').val() + '"，是否确定添加新的？',
										function(r) {
											if (!r) {
												$('#dlg_commodity').dialog(
														'close');
											}
										});
							}
						});
			});

	function newPricing() {
		var row = $('#tt_newPricing').datagrid('getSelected');
		if(row){
			$('#win_newPricing').window({
				href : '/finace/pricing/addForm.html?commodityId='+row.id
			}).window('open');
		}
	}
	
		var editIndex = undefined;
		function endEditing() {
			if (editIndex == undefined) {
				return true;
			}
			if ($('#tt_newPricing').datagrid('validateRow', editIndex)) {
				var ed = $('#tt_newPricing').datagrid('getEditor', {
					index : editIndex,
					field : 'price'
				});
				var price = $(ed.target).val();
				var id = $('#tt_newPricing').datagrid('getRows')[editIndex]['id'];
				$('#tt_newPricing').datagrid('getRows')[editIndex]['price'] = price;
				$('#tt_newPricing').datagrid('endEdit', editIndex);
				$.ajax({
					type : "POST",
					url : "/finace/pricing/savePricing.html",
					data : "commodityId=" + id + "&price=" + price,
					success : function(result) {
						
					}
				});
				editIndex = undefined;
				return true;
			} else {
				return false;
			}
		}
	
	function onClickRow(index) {
		if (editIndex != index) {
			if (endEditing()) {
				$('#tt_newPricing').datagrid('selectRow', index).datagrid('beginEdit',
						index);
				editIndex = index;
			} else {
				$('#tt_newPricing').datagrid('selectRow', editIndex);
			}
		}
	}


	//查询
	function searchCommodity() {
		var name = $('#search_name').val();//商品名称
		var providerName = $('#search_providerName').val();//供应商名称
		var storeStartDate = $('#storeStartDate').datebox('getValue');//入库开始时间
		var storeEndDate = $('#storeEndDate').datebox('getValue');//入库结束时间
		var query = {};
		query['s_name'] = name;
		query['s_provider.companyName'] = providerName;
		query['d_createDate'] = "s_" + storeStartDate + ",e_" + storeEndDate;
		$("#tt_newPricing").datagrid('options').queryParams = query;
		$('#tt_newPricing').datagrid('reload');
	}
	
	function formatTotalPrice(index,row){
		if(row.count!=''&&row.price!=''){
			return '<laber style="color:red;font-weight:bold;">￥&nbsp;'+Number(row.count)*Number(row.price)+'</font>';
		}
	}
</script>