<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title }</title>
<jsp:include page="../../common/css.jsp"></jsp:include>
<jsp:include page="../../common/js.jsp"></jsp:include>
</head>
<body>
	<div class="ftitle">
		员工信息<span class="form_desc">详细员工信息</span>
	</div>
	<div>
		<table border="0" width="90%">
			<tr>
				<td width="20%">员工编号：</td>
				<td width="30%">${employee.empNo }</td>
				<td width="20%">员工姓名：</td>
				<td width="30%">${employee.empName }</td>
			</tr>
			<tr>
				<td>性别：</td>
				<td>${employee.empSex }</td>
				<td>职位：</td>
				<td>${employee.empPosition.positionName}</td>
			</tr>
			<tr>
				<td>学历：</td>
				<td>${employee.empEdu}</td>
				<td>籍贯：</td>
				<td>${employee.empOrigin}</td>
			</tr>
			<tr>
				<td>身份证：</td>
				<td>${employee.empID}</td>
				<td>联系方式：</td>
				<td>${employee.empContact}</td>
			</tr>
			<tr>
				<td>照片：</td>
				<td colspan="3"><img src="${employee.image}" style="width: 130px;height: 200px;"/></td>
			</tr>
		</table>
	</div>
</body>
</html>