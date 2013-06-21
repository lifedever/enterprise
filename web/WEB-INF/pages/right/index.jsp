<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="../common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>${title }</title>
<jsp:include page="../common/css.jsp"></jsp:include>
<jsp:include page="../common/js.jsp"></jsp:include>
<script type="text/javascript">
	var url = "/role/listContent.html";
	$(function() {
		$("#p").panel({
			title : '欢迎您：${sessionScope.user.username}，所属部门：${sessionScope.user.department.departmentName}'
		});
		$('#tt')
				.datagrid(
						{
							idField : 'id',//id字段
							rownumbers : true,//行号
							url : url,
							singleSelect : true,//是否单选
							toolbar : '#tb',
							columns : [ [ {
								field : 'roleName',
								title : '角色名',
								width : 180
							}, {
								field : 'activeFlag',
								title : '是否有效',
								formatter : function(value) {
									if (value == 1) {
										return "<font color='green'>有效</font>";
									} else if (value == 0) {
										return "<font color='red'>无效</font>"
									}
								},
								width : 53
							} ] ],

							onClickRow : function(rowIndex, rowData) {
								var fun_url = "/function/listContentByRole.html?roleId="
										+ rowData.id;
								$('#tt_fun').treegrid({
									iconCls : 'icon-save',
									treeField : 'functionName',
									width : function() {
										return document.body.clientWidth * 0.9
									},
									height : 485,
									idField : 'id',//id字段
									rownumbers : false,//行号
									singleSelect : true,//是否多选
									url : fun_url,
									//singleSelect : true,//是否单选
									columns : [ [ {
										field : 'functionName',
										title : '链接名称',
										width : 240
									}, {
										field : 'functionUrl',
										title : '链接地址',
										width : 260
									}, {
										field : 'description',
										title : '链接描述',
										width : 210
									} ] ]
								});
							}
						});
	});
</script>
<body>
	<div id="p">
		<div class="easyui-layout" style="height: 520px;">
			<div data-options="region:'west',split:true,title:'角色列表'" style="width: 290px;padding:3px;">
				<table id="tt">
				</table>
				<div style="padding: 5px">
					<div>
						<span style="color: blue"><strong>提示：</strong></span>点击角色以查看角色下的功能列表。
					</div>
					<div>
						<span style="color: blue"><strong>配置：</strong></span>点击点击配置功能模块按钮可以对角色的功能权限进行添加和删除操作。
					</div>
				</div>
				<div id="tb">
					<a href="#" class="easyui-linkbutton" iconCls="icon-add"
						plain="true" onclick="newfun_Role()">配置功能模块</a>
				</div>
				<jsp:include page="funList.jsp"></jsp:include>
			</div>
			<div style="padding: 3px;"
				data-options="region:'center',title:'查看与角色对应的功能列表 '">
				<table id="tt_fun" class="easyui-treegrid">
				</table>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		//打开窗口
		function newfun_Role() {
			var row = $('#tt').datagrid('getSelected');
			if (row) {
				$('#tree').tree({
					url : '/function/getFunTree.html?roleId=' + row.id,
					animate : true,
					checkbox : true
				});
				$('#w').window('open');
			}
		}
		//得到树的选择项
		function getChecked() {
			var nodes = $('#tree').tree('getChecked');
			var s = '';
			for ( var i = 0; i < nodes.length; i++) {
				if (s != '')
					s += ',';
				s += nodes[i].id;
			}
			return s;
		}
		//提交树的选择项
		function save() {
			var row = $('#tt').datagrid('getSelected');
			var funIds = getChecked();
			$.ajax({
				type : "POST",
				url : "/right/saveRight.html",
				data : "funIds=" + funIds + "&rowId=" + row.id,
				success : function(result) {
					if (result) {
						$.messager.alert('提示信息', '操作成功！');
						$('#w').dialog('close'); // close the dialog  
						$('table.easyui-treegrid').treegrid('reload'); // reload the user data  
					} else {
						$.messager.alert('提示信息', '操作失败！');
					}
				}
			});
		}
	</script>
</body>
<jsp:include page="../main/footer.jsp"></jsp:include>
</html>