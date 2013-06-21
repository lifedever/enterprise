<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../common/css.jsp"></jsp:include>
<title></title>
<body>

	<div class="container">
		<h2>增加用户</h2>
		<div class="row">
			<form class="form-horizontal" action="addUser.html" method="post">
				<div class="control-group">
					<label class="control-label" for="inputUsername">用户名</label>
					<div class="controls">
						<input type="text" id="inputUsername" placeholder="用户名"
							name="username">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="inputPassword">密码</label>
					<div class="controls">
						<input type="password" id="inputPassword" placeholder="密码"
							name="password">
					</div>
				</div>
				<div class="control-group">
					<label for="inputRealName" class="control-label">真实姓名</label>
					<div class="controls">
						<input type="text" id="inputRealName" placeholder="真实姓名"
							name="realName" />
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<button type="submit" class="btn" />
						提交
						</button>
						<a class="btn" href="/test/list.html">返回列表</a>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>