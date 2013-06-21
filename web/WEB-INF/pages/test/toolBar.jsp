<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>title</title>
<body>
	<div id="tb" style="padding: 5px; height: auto">
		<div style="margin-bottom: 5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
				onclick="newUser();">添加</a> <a href="#" class="easyui-linkbutton"
				iconCls="icon-edit" plain="true" onclick="editUser();">编辑</a> <a
				href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true">保存</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove"
				plain="true" onclick="destroyUser()">删除</a>
		</div>
		<div>
			从: <input class="easyui-datebox" style="width: 80px" /> 到: <input
				class="easyui-datebox" style="width: 80px" /> &nbsp;&nbsp;查询条件 <select
				id="selectVal" style="width: 100px;">
				<option value="username">姓名</option>
				<option value="realName">真实姓名</option>
			</select> <input id="searchVal" style="width: 100px"
				class="easyui-validatebox" /> <a href="#" class="easyui-linkbutton"
				iconCls="icon-search" onclick="searchUser();">查询</a>
		</div>
	</div>
</body>
</html>