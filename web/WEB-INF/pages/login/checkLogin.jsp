<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--author: gefangshuai 2012-11-16 下午9:56:06-->
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title}</title>
</head>
<body>
<%	
	String redirectUrl = (String)request.getAttribute("redirectUrl");
	if(redirectUrl!=null){
		response.sendRedirect(redirectUrl);
	}else{
		response.sendRedirect("/login/login.html");
	}
%>
</body>
</head>