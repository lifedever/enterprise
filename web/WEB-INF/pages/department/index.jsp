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
	var deptId = "";
	var url = "/role/listContent.html";
	$(function() {
		$("#p")
				.panel(
						{
							title : '欢迎您：${sessionScope.user.username}，所属部门：${sessionScope.user.department.departmentName}'
						});
		$('#ttree')
				.tree(
						{
							url : '/department/listContent.html',
							animate : true,
							<c:if test="${sessionScope.user.role.roleName eq '系统管理员' }">dnd:true,</c:if>
							id : 'departmentId',
							text : 'departmentName',
							onClick : function(node) {
								if (node.id != 1) {
									$('#tt_employee').datagrid({url:'/human/employee/listContent.html?f_empDeptId='+node.id});
								} else {
									$('#tt_employee').datagrid({url:'/human/employee/listContent.html'});
								}
								$('#tt_employee').datagrid('reload');
							},
							onDrop:function(target, source, point){
								var targetId = target.getAttribute('node-id');
								var sourceId = source.id;
								console.log(point)
								console.log(target)
								$.post('/department/onDrop.html',{
									targetId:targetId,
									sourceId:sourceId,
									point:point
								},function(data){
									if(!data){
										$.messager.alert('提示信息', '操作失败！');
									}
								});
							},
							onLoadSuccess : function() {
								var node = $('#ttree').tree('find', 1);
								$('#ttree').tree('expandTo', node.target).tree(
										'select', node.target);
							}
						});
	});
</script>
<body>
	<div id="p">
		<div class="easyui-layout" style="height: 520px;">
			<div data-options="region:'west',split:true,title:'部门列表'" style="width: 250px; padding: 3px;">
				<div>
					<c:if test="${sessionScope.user.role.roleName eq '系统管理员' }">
						<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newfun_Dept()">添加</a> <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="updateDept()">编辑</a> <a href="#" class="easyui-linkbutton" iconCls="icon-remove"
							plain="true" onclick="delDept()">删除</a>
					</c:if>
				</div>
				<hr />
				<ul class="easyui-tree" id="ttree"></ul>
				<hr />
				<div style="padding: 5px">
					<div>
						<span style="color: blue"><strong>提示：</strong></span><br />单击部门管理部门下的所有员工。
					</div>
				</div>
			</div>
			<div data-options="region:'center',title:'员工列表'" style="padding: 3px;">
				<table id="tt_employee" class="easyui-datagrid" data-options="toolbar:'#tb'">
				</table>
			</div>
			<div id="tb" style="padding: 5px; height: auto">
				<div>
					<a href="#" class="easyui-linkbutton" iconCls="icon-user-add" plain="true" onclick="addEmp();">添加员工</a> <a href="#" class="easyui-linkbutton" iconCls="icon-user-edit" plain="true" onclick="editEmp();">编辑员工</a> <a href="#" class="easyui-linkbutton"
						iconCls="icon-user-view" plain="true" onclick="viewEmp();">查看员工</a> <a href="#" class="easyui-linkbutton" iconCls="icon-user-del" plain="true" onclick="leaveEmp();">员工离职</a> <a href="#" class="easyui-linkbutton" iconCls="icon-user-del" plain="true"
						onclick="removeEmp();">移除员工</a> <input id="searchVal" class="easyui-searchbox" data-options="prompt:'输入查询关键字',searcher:searchEmps" />
					<div style="float: right;">
						<a href="#" class="easyui-linkbutton" iconCls="icon-user-view" plain="true" onclick="viewLeave();">已离职员工查看</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../human/employee/index.jsp"></jsp:include>
	<jsp:include page="addForm.jsp"></jsp:include>
	<script type="text/javascript">
		//打开窗口
		function newfun_Dept() {
			var row = $('#ttree').tree('getSelected');
			if (row) {
				$('#dlg').dialog('open').dialog('setTitle', '新增部门');
				$('#fm').form('clear');
				$('#parentDept').html(row.text)
				$("#deptId").val(row.id);
				url = 'addDept.html';
			} else {
				$.messager.alert('提示信息', '请先选择上级部门！');
			}
		}
		function saveDept() {
			$('#fm').form('submit', {
				url : url,
				onSubmit : function() {
					//return $(this).form('validate');
				},
				success : function(result) {
					if (!result) {
						$.messager.alert('错误', result.message);
					} else {
						$.messager.alert('提示信息', '操作成功！');
						$('#dlg').dialog('close'); // close the dialog  
						$('#ttree').tree('reload'); // reload the user data  
					}
				}
			});
		}
		function updateDept() {
			var row = $('#ttree').tree('getSelected');
			if (row) {
				$('#dlg').dialog('open').dialog('setTitle', '修改部门');
				$('#fm').form('load', "/department/getDept.html?id=" + row.id);
				url = 'addDept.html?id=' + row.id;
			}
		}
		function delDept() {
			var row = $('#ttree').tree('getSelected');
			if (row) {
				$.messager.confirm('警告', '你确定要移除选择吗?', function(r) {
					if (r) {
						$.post('delDept.html', {
							id : row.id
						}, function(result) {
							if (result.success) {
								$.messager.alert('成功', '删除成功！');
								$('#ttree').tree('reload'); // reload the user data  
							} else {
								$.messager.alert('失败', result.message);
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