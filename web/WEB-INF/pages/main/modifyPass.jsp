<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--author: gefangshuai 2012-11-27 下午9:17:27-->
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title}</title>
<style type="text/css">
.m_title {
	cursor: pointer;
	font-size: 14px;
	font-weight: bold;
}

.mouseover {
	background-color: #E6E6E6;
	cursor: pointer;
	font-size: 14px;
	font-weight: bold;
}
</style>
</head>
<body>
	<div id="w_pass" class="easyui-window" title="消息中心"
		data-options="modal:true,closed:true,iconCls:'icon-save'"
		style="width: 650px; height: 240px; padding: 10px;">
		<div style="padding: 10px 0 10px 60px">
			<form id="pass_fm" method="post" class="fm">
				<table>
					<tr>
						<td style="text-align: right">旧密码：</td>
						<td><input class="easyui-validatebox" type="password"
							name="oldPassword" id="oldPassword2"></input> &nbsp;<font
							color="red">*</font>&nbsp;<span id="pass_msg">初始密码：123456</span></td>
					</tr>
					<tr>
						<td style="text-align: right">新密码：</td>
						<td><input class="easyui-validatebox" type="password"
							name="newPassword" id="newPassword2"></input> &nbsp;<font
							color="red">*</font>&nbsp;</td>
					</tr>
					<tr>
						<td style="text-align: right">再次输入新密码：</td>
						<td><input class="easyui-validatebox" type="password"
							name="newPassword2" id="newPassword3"></input> &nbsp;<font
							color="red">*</font>&nbsp;</td>
					</tr>
				</table>
			</form>
		</div> 	
		<div id="" style="text-align: center;">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="" onclick="savePass()">保存</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls=""
				onclick="javascript:$('#w_pass').window('close')">取消</a>
		</div>
	</div>

	<script type="text/javascript">
		function modifyPassword() {
			$('#w_pass').window('open');
		}
		//保存密码
		function savePass() {
			$('#pass_fm').form('submit', {
				url : "/user/savePass.html?id="+"${sessionScope.user.id}",
				onSubmit : function() {
					if ($('#newPassword2').val() != $('#newPassword3').val()) {
						$.messager.alert("错误", "两次密码输入不一致，请重新输入");
						return false;
					}
					return true;
				},
				success : function(data) {
					 var result = eval('(' + data + ')');
					if (result) {
						$.messager.alert('成功', '操作成功！');
						$('#w_pass').window('close'); // close the dialog
					}
				}
			});
		}
		
		//验证旧密码是否正确
		$("#oldPassword2").blur(function() {
			var op = $(this).val();
			$.post('/user/checkPass.html', {
				oldPassword : op,
				id : "${sessionScope.user.id}"
			}, function(data) {
				if (data.success) {
					$('#pass_msg').css({
						'color' : 'green'
					}).html('密码正确');
				} else {
					$('#pass_msg').css({
						'color' : 'red'
					}).html('密码错误，请重新输入');
					$("#oldPassword2").focus();
				}
			}, 'json');
		});
	</script>
</body>
</head>