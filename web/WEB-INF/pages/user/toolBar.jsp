<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div id="tb" style="padding: 5px; height: auto">
	<div style="margin-bottom: 5px">
		<a href="#" class="easyui-linkbutton" iconCls="icon-user-add" plain="true" onclick="newUser();">添加新账户</a> 
		<a href="#" class="easyui-linkbutton" iconCls="icon-user-add" plain="true" onclick="empList();">来自员工</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-user-edit" plain="true" onclick="editUser();">编辑</a> 
		<a href="#" class="easyui-linkbutton" iconCls="icon-user-del" plain="true" onclick="destroyUser()">删除</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="changePass()">修改密码</a> 
		&nbsp;&nbsp;&nbsp;&nbsp; 性别 ：
		<select id="sexVal" style="width: 100px;">
			<option value="">不限</option>
			<option value="男">男</option>
			<option value="女">女</option>
		</select> &nbsp;&nbsp; <select id="selectVal" style="width: 100px;">
			<option value="s_username">用户名</option>
			<option value="s_realName">真实姓名</option>
		</select> &nbsp;&nbsp; <input id="searchVal" class="easyui-searchbox" data-options="prompt:'输入查询关键字',searcher:searchUser" />
	</div>
</div>
