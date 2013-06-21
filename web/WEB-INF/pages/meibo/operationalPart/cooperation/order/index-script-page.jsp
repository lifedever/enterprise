<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	//打印合同
	function printSign(){
		$('#print_sign').printArea();
	}
	function cooperatorOrderformatter(value,row){
		return '<span style="color:green">'+'<a href="#" onclick="viewCooperationOrder(\''+row.productNo+'\')">'+row.productNo+'</a>'+'</span>';
	}
	function payStatusFormatter(value){
		if(value == '1'){
			return '<span style="color:green">已付款</span>';
		}else{
			return '<span style="color:red">未付款</span>';
		}
	}
	function viewCooperationOrder(productNo){
		$('#win_viewCooperationOrder').window({
			href : '/meibo/operationalPart/cooperation/order/viewCooperationOrder.html?productNo='+productNo
		}).window('open');
	}
	
	function delCooperationOrder(){
		var row = $('#tt_cooperationOrder').datagrid('getSelected');
		if (row) {
			$.messager.confirm('警告', '你确定要删除选择吗?', function(r) {
				if (r) {
					$.post('/meibo/operationalPart/cooperation/order/delCooperationOrder.html',{
						cooperationOrderId:row.id
					},function(data){
						if(data){
							$.messager.alert('提示信息', '删除成功！');
							$('#tt_cooperationOrder').datagrid('reload'); // reload the user data  
						}
					});
				}
			});
		} else {
			$.messager.alert('提示信息', '请选择操作对象！');
		}
		
	}
	
	function instore(value, row){
		if(row.instoreCount > 0){
			return '<span style="color:red">'+'<a href="#" onclick="productinstore(\''+value+'\')">点击入库</a>'+'</span>';
		}else {
			return '<span style="color:red">'+'<a href="#" >点击入库</a>'+'</span>';;
		}
	}
	function productinstore(value){
		$('#win_newFinishedProduct11').window({
			href : '/meibo/storeroom/finishedproduct/indexForInstore.html?coopId='+value
		}).window('open');
	}
	
	function isProofFormatter(value){
		if (value == '0') {
			return '<span style="color:red">产品</span>';
		}
		if (value == '1') {
			return '<span style="color:green">样品</span>';
		}
	}
	function payOrderStatus(){
		var row = $('#tt_cooperationOrder').datagrid('getSelected');
		if(row){
			$('#win_cooperationOrder').window({
				href : '/meibo/operationalPart/cooperation/order/payStatus.html?orderId='+row.id
			}).window('open');
		}else{
			$.messager.alert('提示信息', '请选择操作对象！');
		}
	}
	//导出
	function exportForm(){
		var productName = $('#search_productName').val();//商品名称
		var productNo = $('#search_productNo').val(); //供应商名称
		var factoryName = $('#search_factoryName').val();//外发厂名称
		var payStatus = $('#search_payStatus').val();//付款状态
		var returnProductStartDate = $('#returnProductStartDate').datebox('getValue');//入库开始时间
		var returnProductEndDate = $('#returnProductEndDate').datebox('getValue');//入库结束时间
		var query = {};
		query['s_productName'] = productName;
		query['s_productNo'] = productNo;
		query['s_factoryName'] = factoryName;
		query['d_returnProductDate'] = "s_" + returnProductStartDate + ",e_" + returnProductEndDate;
		if(payStatus == 1){
			query['s_payStatus'] = payStatus;
		}
		if(payStatus == 0){
			query['s_payStatus'] = payStatus;
		}
		$('#win_cooperationOrders').window('open');
		$.ajax("/meibo/operationalPart/cooperation/order/listAllContent.html", {
			dataType : 'html',
			type:'post',
			data:postValue = query,
			success : function(data) {
				$('#win_cooperationOrders').html(data);
			}
		});
		var row = $('#tt_cooperationOrder').datagrid('getSelected');
		
	}
	function exportPage(){
		var productName = $('#search_productName').val();//商品名称
		var productNo = $('#search_productNo').val(); //供应商名称
		var factoryName = $('#search_factoryName').val();//外发厂名称
		var payStatus = $('#search_payStatus').val();//付款状态
		var returnProductStartDate = $('#returnProductStartDate').datebox('getValue');//入库开始时间
		var returnProductEndDate = $('#returnProductEndDate').datebox('getValue');//入库结束时间
		var query = {};
		query['s_productName'] = productName;
		query['s_productNo'] = productNo;
		query['s_factoryName'] = factoryName;
		query['d_returnProductDate'] = "s_" + returnProductStartDate + ",e_" + returnProductEndDate;
		if(payStatus == 1){
			query['s_payStatus'] = payStatus;
		}
		if(payStatus == 0){
			query['s_payStatus'] = payStatus;
		}
		$.post('/meibo/operationalPart/cooperation/order/listAllContent.html',{
				postValue:query
			},function(){
			
		});
	}
	//查询
	function searchCooperationOrder(){
		var productName = $('#search_productName').val();//商品名称
		var productNo = $('#search_productNo').val(); //供应商名称
		var factoryName = $('#search_factoryName').val();//外发厂名称
		var payStatus = $('#search_payStatus').val();//付款状态
		var returnProductStartDate = $('#returnProductStartDate').datebox('getValue');//入库开始时间
		var returnProductEndDate = $('#returnProductEndDate').datebox('getValue');//入库结束时间
		var query = {};
		query['s_productName'] = productName;
		query['s_productNo'] = productNo;
		query['s_factoryName'] = factoryName;
		query['d_returnProductDate'] = "s_" + returnProductStartDate + ",e_" + returnProductEndDate;
		if(payStatus == 1){
			query['s_payStatus'] = payStatus;
		}
		if(payStatus == 0){
			query['s_payStatus'] = payStatus;
		}
		$("#tt_cooperationOrder").datagrid('options').queryParams = query;
		$('#tt_cooperationOrder').datagrid('reload');
	}
	
	//添加车辆
	function addVehicle(){
		var row = $('#tt_cooperationOrder').datagrid('getSelected');
		if(row){
			$('#win_addvehicle').window({
				href : '/meibo/operationalPart/vehicle/addForm.html?cooperationOrderId='+row.id
			}).window('open');
		} else {
			$.messager.alert('提示信息', '请选择操作对象!');
		}
	}
	//添加物流
	function addLogistics(){
		var row = $('#tt_cooperationOrder').datagrid('getSelected');
		if(row){
			$('#win_addlogistics').window({
				href : '/meibo/operationalPart/logistics/addForm.html?cooperationOrderId='+row.id
			}).window('open');
		}else {
			$.messager.alert('提示信息', '请选择操作对象!');
		}
	}
	
	//查看车辆
	function formatVehicle(value){
		return '<span style="color:green">'+'<a href="#" onclick="viewVehicle(\''+value+'\')">车辆</a>'+'</span>';
	}
	//查看物流
	function formatLogistics(value){
		return '<span style="color:green">'+'<a href="#" onclick="viewLogistics(\''+value+'\')">物流</a>'+'</span>';
	}
	
	function viewVehicle(value){
		var row = $('#tt_cooperationOrder').datagrid('getSelected');
		if(row){
			$('#win_viewvehicle').window({
				href : '/meibo/operationalPart/vehicle/indexForWorksheet.html?orderNo='+row.productNo
			}).window('open');
		}
	}
	
	function viewLogistics(value){
		var row = $('#tt_cooperationOrder').datagrid('getSelected');
		if(row){
			$('#win_viewlogistics').window({
				href : '/meibo/operationalPart/logistics/indexForWorksheet.html?orderNo='+row.productNo
			}).window('open');
		}
	}
</script>
