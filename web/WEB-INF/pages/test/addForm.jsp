<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>title</title>
<body>
	<!-- 用户添加表单 -->
	<div id="dlg" class="easyui-dialog"
		style="width: 440px; height: 320px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<div class="ftitle">用户信息</div>
		<form id="fm" method="post" novalidate enctype="">
			<div class="fitem">
				<label>用户名：</label> <input name="username"
					class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>真实姓名：</label> <input name="realName"
					class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>手机号：</label> <input name="mobileTel">
			</div>
			<div class="fitem">
				<label>Email：</label> <input name="email" class="easyui-validatebox"
					validType="email">
					<input type="file" name ="imageFile"/>
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="saveUser()">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
	</div>
</body>
</html>