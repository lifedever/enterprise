<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	//打印合同
	function printSign(){
		$('#print_sign').printArea();
	}
	function productNoformatter(value,row){
		return '<span style="color:green">'+'<a href="#" onclick="viewWorksheet(\''+row.productNo+'\')">'+row.productNo+'</a>'+'</span>';
	}
	function viewWorksheet(productNo){
		$('#win_viewWorksheet').window({
			href : '/meibo/worksheet/viewWorksheet.html?productNo='+productNo
		}).window('open');
	}
	function detailFormatter(index, row) {
		return '<div style="padding:2px"><table id="ddv-' + index + '"></table></div>';
	}
	function isProofFormatter(value){
		if (value == '0') {
			return '<span style="color:red">产品</span>';
		}
		if (value == '1') {
			return '<span style="color:green">样品</span>';
		}
	}
	function editWorksheet(){
		var row = $('#tt_worksheet').datagrid('getSelected');
		if (row) {
			$('#win_viewWorksheet').window({
				href : '/meibo/worksheet/editWorksheet.html?worksheetId='+row.id
			}).window('open');
		} else {
			$.messager.alert('提示信息', '请选择操作对象！');
		}
	}
	function delWorksheet(){
		var row = $('#tt_worksheet').datagrid('getSelected');
		if (row) {
			$.messager.confirm('警告', '你确定要删除选择吗?', function(r) {
				if (r) {
					$.post('/meibo/worksheet/delWorksheet.html',{
						worksheetId:row.id
					},function(data){
						if(data){
							$.messager.alert('提示信息', '删除成功！');
							$('#tt_worksheet').datagrid('reload'); // reload the user data  
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
			href : '/meibo/storeroom/finishedproduct/indexForInstore.html?workId='+value
		}).window('open');
	}
	
	//查询
	function searchWorksheet(){
		var productName = $('#search_productName').val();//商品名称
		var productNo = $('#search_productNo').val(); //供应商名称
		var isProof = $('#search_isProof').val();//入库开始时间
		var query = {};
		query['s_productName'] = productName;
		query['s_productNo'] = productNo;
		query['s_isProof'] = isProof;
		$("#tt_worksheet").datagrid('options').queryParams = query;
		$('#tt_worksheet').datagrid('reload');
	}
	
	//添加车辆
	function addVehicle(){
		var row = $('#tt_worksheet').datagrid('getSelected');
		if(row){
			$('#win_addvehicle').window({
				href : '/meibo/operationalPart/vehicle/addForm.html?productId='+row.id
			}).window('open');
		}else {
			$.messager.alert('提示信息', '请选择操作对象!');
		}
	}
	//添加物流
	function addLogistics(){
		var row = $('#tt_worksheet').datagrid('getSelected');
		if(row){
			$('#win_addlogistics').window({
				href : '/meibo/operationalPart/logistics/addForm.html?productId='+row.id
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
		var row = $('#tt_worksheet').datagrid('getSelected');
		if(row){
			$('#win_viewvehicle').window({
				href : '/meibo/operationalPart/vehicle/indexForWorksheet.html?orderNo='+row.productNo
			}).window('open');
		}
	}
	
	function viewLogistics(value){
		var row = $('#tt_worksheet').datagrid('getSelected');
		if(row){
			$('#win_viewlogistics').window({
				href : '/meibo/operationalPart/logistics/indexForWorksheet.html?orderNo='+row.productNo
			}).window('open');
		}
	}
	
</script>
