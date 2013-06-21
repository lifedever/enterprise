<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<meta charset=UTF-8">
<title>${title }</title>
<jsp:include page="../common/js.jsp"></jsp:include>
<jsp:include page="../common/css.jsp"></jsp:include>
<style type="text/css">
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow: hidden;
}

.logo {
	padding: 20;
}

.form {
	right: 400px;
	left: 380px;
	top: 10px;
	position: absolute;
	background-color: red;
	width: 610px;
	height: 700px;
	background: url('/images/form.png') repeat-x;
	margin-top: 110;
	margin-right: auto;
	margin-left: auto;
	margin-bottom: 110px;
}

.form .co {
	position: relative;
	left: 30px;
	top: 35px;
	font-family: '宋体', '黑体';
	color: #ddd;
	font-size: 14px;
}

.form .title {
	text-align: center;
	position: relative;
	top: 55px;
	font-family: '微软雅黑', '黑体';
	color: #fff;
	font-size: 34px;
}

.form .input {
	color: #fff;
	text-align: center;
	position: relative;
	top: 95px;
}

label {
	font-size: 15px;
	font-weight: bold;
}

button {
	font-family: '黑体';
	cursor: pointer;
	color: #fff;
	border: none;
	width: 80px;
	height: 30px;
	background-color: blue;
	background: url("/images/btn.png") no-repeat;
	background-position: -2px top;
	font-size: 18px;
	height: 30px;
}
</style>
</head>
<body background="/images/bg.png">
	<div class="logo">
		<img src="/images/logo.png" width="130px" />
	</div>
	<form method="post" action="/login/checkLogin.html" id="loginForm">
		<div class="form">
			<div class="co">${title }</div>
			<strong><div class="title">企业管理系统</div></strong>
			<div class="input">
				<p>
					<label class="control-label">账号： </label> <input type="text" name="username" id="username"
						placeholder="请输入账号" style="width: 200px;" />
				</p>
				<p>
					<label class="control-label">密码：</label> <input type="password" name="password" id="password"
						placeholder="请输入密码" style="width: 200px;" />
				</p>
				<p>
					<button type="submit">
						<span style="font-size: 14px;">提交</span>
					</button>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<button type="reset">
						<span style="font-size: 14px;">重置</span>
					</button>
				</p>
			</div>
	</form>
	</div>
	<script type="text/javascript">
		(function() {
			$('#username').focus();
			if (window.parent.frames["mainFrame"])
				window.parent.location.reload();
		})();
	</script>
</body>
</html>