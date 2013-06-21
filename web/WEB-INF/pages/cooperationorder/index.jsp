<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>${title }</title>
<jsp:include page="../common/css.jsp"></jsp:include>
<jsp:include page="../common/js.jsp"></jsp:include>

<script type="text/javascript">
	var url = "/cooperationorder/listContent.html";
	$(function() {
		$("#p")
				.panel(
						{
							title : '欢迎您：${sessionScope.user.username}，所属部门：${sessionScope.user.department.departmentName}'
						});
		$('#tt_cproduct')
				.datagrid(
						{
							title : '',
							iconCls : 'icon-save',
							width : function() {
								return document.body.clientWidth * 0.9
							},
							//checkOnSelect : false,
							height : $(document).height() - 50,
							idField : 'id',//id字段
							rownumbers : true,//行号
							nowrap : false,
							multipleSelect : true,//是否多选
							url : url,
							toolbar : '#tb_factory',
							columns : [ [
									{
										field : 'ck',
										checkbox : true
									},
									{
										field : 'cOrderNo',
										title : '外发单号',
										width : 100
									},
									{
										field : 'goodsNo',
										title : '制品单编号',
										width : 100
									},
									{
										field : 'productNo',
										title : '产品编号',
										width : 150
									}, {
										field : 'productName',
										title : '产品名称',
										width : 100
									}, {
										field : 'productCount',
										title : '产品数量',
										width : 80
									}, {
										field : 'unit',
										title : '单位',
										width : 80
									}, {
										field : 'price',
										title : '单价',
										width : 80
									}, {
										field : 'a',
										title : '总价',
										width : 80,
										formatter:function(value,row,rowIndex){
											return row.productCount*row.price;
										}
									}, {
										field : 'realPay',
										title : '实付款',
										width : 80
									}, {
										field : 'factoryName',
										title : '协作工厂',
										width : 200
									}] ],
							detailFormatter : function(index, row) {
								return '<div style="padding:2px"><table id="ddv-' + index + '"></table></div>';
							},
							pagination : true
						//启用分页
						});
		//设置分页
		$('#tt_cproduct').datagrid('getPager').pagination({
			pageSize : 10,//每页显示的记录条数，默认为10 
			pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
			beforePageText : '第',//页数文本框前显示的汉字 
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
		});
	});
</script>
</head>
<body>
	<div id="p">
		<div title="报价管理">
			<table id="tt_cproduct">
			</table>
		</div>
	</div>
	<jsp:include page="addForm.jsp"></jsp:include>
	<jsp:include page="toolBar.jsp"></jsp:include>
	<div id="selProduct" class="easyui-window" title="产品列表" data-options="closed:true,modal:true,iconCls:'icon-save',cache:false" style="width: 900px; height: 400px; padding: 10px;"></div>
	<div id="selFactory" class="easyui-window" title="协作工厂列表" data-options="closed:true,modal:true,iconCls:'icon-save',cache:false" style="width: 960px; height: 400px; padding: 10px;"></div>
	<div class="easyui-window" id="win_accountName" data-options="title:'选择银行账户',closed:true,modal:true,iconCls:'icon-save',cache:false" style="width: 800px; height: 350px; padding: 10px;"></div>
	<script type="text/javascript">
		//添加外发单
		function addCproduct() {
			$('#dlg_cproduct').window('open').window('setTitle', '新增外发单');
			$('#fm_cproduct').form('clear');
			url = "/cooperationorder/saveCproduct.html";
		}
		function saveCproduct() {
			$('#fm_cproduct').form('submit', {
				url : url,
				onSubmit:function(){
					var productId = $('#productId').val();
					var factoryId = $('#factoryId').val();
					if(productId==''){
						$.messager.alert('提示信息','请选择产品！')
						return false;
					}
					if(factoryId==''){
						$.messager.alert('提示信息','请选择协作工厂！')
						return false;
					}
				},
				success : function(data) {
					if (data) {
						$.messager.alert('提示信息', '操作成功！');
						$('#dlg_cproduct').dialog('close'); // close the dialog
						$('#tt_cproduct').datagrid('reload');
					} else {
						$.messager.alert('提示信息', '操作失败！');
					}
				}
			});
		}

		function delCproduct() {
			var rows = $('#tt_cproduct').datagrid('getSelections');
			if (rows != null && rows.length > 0) {
				$.messager.confirm('警告', '你确定要删除选择吗?', function(r) {
					if (r) {
						var ids = '';
						for ( var i = 0; i < rows.length; i++) {
							ids = ids + rows[i].id + ",";
						}
						$.post('deleteCproduct.html', {
							ids : ids
						}, function(data) {
							var result = eval('(' + data + ')');
							if (result) {
								$.messager.alert('成功', '删除成功！');
								$('#tt_cproduct').datagrid('reload'); // reload the user data  
							} else {
								$.messager.alert('失败', '删除失败！');
							}
						}, 'json');
					}
				});
			}
		}

		//选择产品
		function selectProduct() {
			$('#selProduct').window({
				href : '/cooperationorder/selProduct.html?customerId='
			}).window('open');
		}
		//确认选择产品
		function addSelProductOk() {
			var row = $('#tt_selProduct').datagrid('getSelected');
			$('#selProduct').window('close');
			$('#productId').val(row.id);
			$('#pro_no').html(row.productNo);
			$('#pro_name').html(row.productName);
			$('#mount').val(row.productCount)
		}
		//选择协作工厂
		function selectFactory() {
			$('#selFactory').window({
				href : '/cooperationorder/selFactory.html?customerId='
			}).window('open');
		}
		//确认选择产品
		function addSelFactoryOk() {
			var row = $('#tt_selFactory').datagrid('getSelected');
			$('#selFactory').window('close');
			$('#factoryId').val(row.id);
			$('#fac_no').html(row.factoryNo);
			$('#fac_name').html(row.factoryName);
		}
		$('#price').on('blur',function(){
			$('#sumPrice').val($(this).val()*$('#mount').val());
			$('#realPay').val($(this).val()*$('#mount').val());
		});
		//弹出银行账户 
		$('#accountName').on('focus', function() {
			$('#win_accountName').window({
				href : '/finace/expenditure/listAccount.html'
			}).window('open');
		});
	</script>
</body>
<jsp:include page="../main/footer.jsp"></jsp:include>
</html>