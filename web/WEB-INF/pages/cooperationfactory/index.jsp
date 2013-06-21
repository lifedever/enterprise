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
	var url = "/cooperationfactory/listContent.html";
	$(function() {
		$('#tt_factory')
				.datagrid(
						{
							title : '',
							iconCls : 'icon-save',
							fit:true,
							idField : 'id',//id字段
							rownumbers : true,//行号
							nowrap : false,
							multipleSelect : true,//是否多选
							url : url,
							toolbar : '#tb_factory',
							columns : [ [ {
								field : 'ck',
								checkbox : true
							}, {
								field : 'factoryNo',
								title : '编号',
								width : 70
							}, {
								field : 'factoryName',
								title : '名称',
								width : 100
							}, {
								field : 'factoryProp',
								title : '性质',
								width : 100
							}, {
								field : 'factoryStar',
								title : '星级',
								formatter : function(value) {
									if (value != 0) {
										var star = "";
										for (i = 0; i < value; i++) {
											star = star + '★';
										}
										return star;
									}
								},
								width : 100
							}, {
								field : 'factorySite',
								title : '网址',
								width : 140,
								formatter : function(value) {
									return '<a href="'+value+'" target=_blank>'+value+'</a>';
								}
							}, {
								field : 'employee',
								title : '外发人员',
								width : 100
							}, {
								field : 'contactMan',
								title : '联系人',
								width : 100
							}, {
								field : 'phone',
								title : '电话',
								width : 140
							}, {
								field : 'fax',
								title : '传真',
								width : 140
							}, {
								field : 'mobile',
								title : '手机',
								width : 140
							}, {
								field : 'post',
								title : '职务',
								width : 100
							}, {
								field : 'qq',
								title : 'QQ',
								width : 100
							}, {
								field : 'address',
								title : '地址',
								width : 200
							} ] ],
							detailFormatter : function(index, row) {
								return '<div style="padding:2px"><table id="ddv-' + index + '"></table></div>';
							},
							pagination : true
						//启用分页
						});
		//设置分页
		$('#tt_factory').datagrid('getPager').pagination({
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
	<div class="easyui-tabs" style="" data-options="fit:true">
		<div title="外发工厂管理" style="padding: 3px">
			<table id="tt_factory">
			</table>
		</div>
	</div>
	<jsp:include page="addForm.jsp"></jsp:include>
	<jsp:include page="toolBar.jsp"></jsp:include>
	<script type="text/javascript">
		function addFactory() {
			$('#dlg_factory').window('open').window('setTitle', '新增工厂');
			$('#fm_factory').form('clear');
			url = "/cooperationfactory/saveFactory.html";
		}
		function saveFactory() {
			$('#fm_factory').form('submit', {
				url : url,
				success : function(data) {
					var result = eval('(' + data + ')');
					if (result) {
						$.messager.alert('提示信息', '操作成功！');
						$('#dlg_factory').dialog('close'); // close the dialog
						$('#tt_factory').datagrid('reload');
					} else {
						$.messager.alert('提示信息', '操作失败！');
					}
				}
			});
		}

		function editFactory() {
			var row = $('#tt_factory').datagrid('getSelected');
			if (row) {
				$('#dlg_factory').dialog('open').dialog('setTitle', '编辑货源');
				$('#fm_factory').form('load', row);
				url = '/cooperationfactory/saveFactory.html?id=' + row.id;
			}
		}

		function delFactory() {
			var rows = $('#tt_factory').datagrid('getSelections');
			if (rows != null && rows.length > 0) {
				$.messager.confirm('警告', '你确定要删除选择吗?', function(r) {
					if (r) {
						var ids = '';
						for ( var i = 0; i < rows.length; i++) {
							ids = ids + rows[i].id + ",";
						}
						$.post('deleteFactory.html', {
							ids : ids
						}, function(data) {
							var result = eval('(' + data + ')');
							if (result) {
								$.messager.alert('成功', '删除成功！');
								$('#tt_factory').datagrid('reload'); // reload the user data  
							} else {
								$.messager.alert('失败', '删除失败！');
							}
						}, 'json');
					}
				});
			}
		}
	</script>
</body>
<jsp:include page="../main/footer.jsp"></jsp:include>
</html>