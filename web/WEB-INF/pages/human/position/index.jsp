<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../../common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>${title }</title>
<jsp:include page="../../common/css.jsp"></jsp:include>
<jsp:include page="../../common/js.jsp"></jsp:include>

<script type="text/javascript">
	var url = "/human/position/listContent.html";
	$(function() {
		$('#tt_position').datagrid({
			title : '',
			iconCls : 'icon-edit',
			fit:true,
			idField : 'id',//id字段
			rownumbers : true,//行号
			//multipleSelect : true,//是否多选
			url : url,
			singleSelect : true,//是否单选
			toolbar : '#tb_position',
			columns : [ [ {
				field : 'positionNo',
				title : '职位编号',
				width : 200
			}, {
				field : 'positionName',
				title : '职位名称',
				width : 200
			}, {
				field : 'createDate',
				title : '创建时间',
				width : 150,
				//日期格式转换
				formatter : function(value, row, index) {
					if (value) {
						return getDateFromJson(value);
					}
				}
			} ] ]
		});
	});
</script>
</head>
<body>
	<div class="easyui-tabs" style="" data-options="fit:true">
		<div title="职位管理" style="padding: 3px">
			<table id="tt_position">
			</table>
		</div>
	</div>
		<div id="tb_position">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newPosition()">添加</a> <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editPosition()">编辑</a> <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="removePosition()">删除</a>
		</div>
	<jsp:include page="addForm.jsp"></jsp:include>
	<script type="text/javascript">
		function newPosition() {
			$('#dlg_position').dialog('open').dialog('setTitle', '编辑职位');
			$('#fm_position').form('clear');
			url = 'savePosition.html';
		}
		function editPosition() {
			var row = $('#tt_position').datagrid('getSelected');
			if (row) {
				$('#dlg_position').dialog('open').dialog('setTitle', '编辑职位');
				$('#fm_position').form('load', row);
				url = 'savePosition.html?id=' + row.id;
			}
		}
		function removePosition() {
			var row = $('#tt_position').datagrid('getSelected');
			if (row) {
				$.messager.confirm('警告', '你确定要删除选择吗?', function(r) {
					if (r) {
						$.post('deletePosition.html', {
							id : row.id
						},
								function(data) {
									if (data) {
										$.messager.alert('成功', '删除成功！');
										$('#tt_position').datagrid('reload'); // reload the user data  
									} else {
										$.messager.alert('失败',
												'删除失败！请先移除职位下的员工然后重试');
									}
								}, 'json');
					}
				});
			}
		}
		function savePosition() {
			$('#fm_position').form('submit', {
				url : url,
				success : function(data) {
					if (!data) {
						$.messager.alert('提示信息', '操作失败！');
					} else {
						$('#dlg_position').dialog('close'); // close the dialog  
						$('#tt_position').datagrid('reload'); // reload the user data  
						$.messager.alert('提示信息', '操作成功！');
					}
				}
			});
		}
	</script>
</body>
<jsp:include page="../../main/footer.jsp"></jsp:include>
</html>