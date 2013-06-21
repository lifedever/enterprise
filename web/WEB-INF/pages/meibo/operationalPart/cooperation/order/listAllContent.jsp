<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#t td{
		padding: 10px;
	}
</style>
</head>
<body>
	<div id="print">
		<div style="text-align: center;margin: 40px;font-size: 18px;font-weight: bold;">外协产品汇总</div>
		
		<table id="t" width="100%" style="border-collapse: collapse;" border="1">
			<tr>
				<td>加工厂</td>
				<td>加工单号</td>
				<td>下单时间</td>
				<td>交货时间</td>
				<td>产品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>合计金额</td>
				<td>派单人</td>
			</tr>
			<c:forEach items="${rows }" var="row">
				<tr>
					<td>${row.cooperationFactory }</td>
					<td>${row.productNo }</td>
					<td><fmt:formatDate value="${row.setOrderDate }" pattern="yyyy-MM-dd"/></td>
					<td><fmt:formatDate value="${row.returnProductDate }" pattern="yyyy-MM-dd"/></td>
					<td>${row.productName }</td>
					<td>${row.productCount }</td>
					<td>${row.price }</td>
					<td>${row.productCount*row.price }</td>
					<td>${row.sendMan }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<script type="text/javascript">
		(function(){
			$('#print').printArea();
		})();
	</script>
</body>
</html>