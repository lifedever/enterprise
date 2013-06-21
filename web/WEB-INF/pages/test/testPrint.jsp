<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<jsp:include page="../common/css.jsp"></jsp:include>
<jsp:include page="../common/js.jsp"></jsp:include>
<script type="text/javascript" src="/js/jquery.printPage.js">
	
</script>
</head>
<body>
	<h1>打印测试页面</h1>
	<input type="button" value="打印" id="print" />
	<br />
	<div id="table1">
		<table width="90%" border="1" id="printArea" name="table1" id="">
			<tr>
				<td width="30%">姓名</td>
				<td width="30%">邮箱</td>
				<td width="30%">电话</td>
			</tr>
			<tr>
				<td>姓名</td>
				<td>邮箱</td>
				<td>电话</td>
			</tr>
			<tr>
				<td>姓名</td>
				<td>邮箱</td>
				<td>电话</td>
			</tr>
			<tr>
				<td>姓名</td>
				<td>邮箱</td>
				<td>电话</td>
			</tr>
			<tr>
				<td>姓名</td>
				<td>邮箱</td>
				<td>电话</td>
			</tr>
		</table>
	</div>
	<script type="text/javascript">
		new printPartOfDocument('print', 'table1');
	</script>
</body>
</html>