<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="w_userList" class="easyui-window" title="用户列表"
	data-options="modal:true,closed:true,maximizable:false,iconCls:'icon-save'"
	style="width: 680px; height: 400px;">
	<table id="tt_userList">
	</table>
</div>
<script type="text/javascript">
	function showUserList(url) {
		$('#w_userList').window('open');
		$('#tt_userList').datagrid({
			width : $('#w_userList').width() - 2,
			height : $('#w_userList').height() - 2,
			idField : 'id',//id字段
			rownumbers : true,//行号
			simpleSelect : true,//是否多选
			url : url,
			toolbar : [ {
				id : 'btnrm',
				text : '确认选择',
				iconCls : '',
				handler : addUserOk
			}, '-' ],
			//singleSelect : true,//是否单选
			columns : [ [ {
				field:'ck',
				checkbox:true
			},{
				field : 'username',
				title : '用户名',
				width : 80
			}, {
				field : 'realName',
				title : '真实姓名',
				width : 80
			}, {
				field : 'mobileTel',
				title : '手机号',
				width : 120
			}, {
				field : 'departmentName',
				title : '部门',
				width : 100
			}, {
				field : 'roleName',
				title : '角色',
				width : 100
			} ] ],
			pagination : true
		//启用分页
		});
		//设置分页
		$('#tt_userList').datagrid('getPager').pagination({
			pageSize : 10,//每页显示的记录条数，默认为10 
			pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
			beforePageText : '第',//页数文本框前显示的汉字 
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
		});
	}
</script>
