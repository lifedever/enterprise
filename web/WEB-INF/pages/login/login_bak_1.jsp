<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>${title }</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
<meta name="author" content="Muhammad Usman">
<!-- The styles -->
<link id="" href="/charisma-master/css/bootstrap-cerulean.css" rel="stylesheet">
<style type="text/css">
body {
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}
</style>
<link href="/charisma-master/css/bootstrap-responsive.css" rel="stylesheet">
<link href="/charisma-master/css/charisma-app.css" rel="stylesheet">
<link href='/charisma-master/css/chosen.css' rel='stylesheet'>
<link href='/charisma-master/css/uniform.default.css' rel='stylesheet'>
<link href='/charisma-master/css/colorbox.css' rel='stylesheet'>

<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
	  <script src="/js/html5.js"></script>
	<![endif]-->
<!-- The fav icon -->
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">

			<div class="row-fluid">
				<div class="span12 center login-header">
					<h2>北京美博雅克丽工贸有限公司</h2>
					<h1>企业管理系统</h1>
				</div>
				<!--/span-->
			</div>
			<!--/row-->
			<div class="row-fluid">
				<div class="well span5 center login-box">
					<div class="alert alert-info">请输入您的用户名和密码.</div>
					<form class="form-horizontal"  action="/login/checkLogin.html" id="loginForm" method="post">
						<fieldset>
							<div class="input-prepend" title="Username" data-rel="tooltip">
								<span class="add-on"><i class="icon-user"></i></span><input autofocus class="input-large span10"
									name="username" id="username" type="text" value="admin" />
							</div>
							<div class="clearfix"></div>
							<div class="input-prepend" title="Password" data-rel="tooltip">
								<span class="add-on"><i class="icon-lock"></i></span><input class="input-large span10" name="password"
									id="password" type="password"  />
							</div>
							<div class="clearfix"></div>
							<p class="center span5">
								<button type="submit" class="btn btn-primary">登录</button>
							</p>
						</fieldset>
					</form>
				</div>
				<!--/span-->
			</div>
			<!--/row-->
		</div>
		<!--/fluid-row-->
	</div>
	<!--/.fluid-container-->
	<script type="text/javascript">
		(function() {
			$('#username').focus();
			if (window.parent.frames["mainFrame"])
				window.parent.location.reload();
		})();
	</script>
</body>
</html>