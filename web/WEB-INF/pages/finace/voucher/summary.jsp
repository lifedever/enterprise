<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../common/tag.jsp"%>
<div>
	<table width="50%" border="1" style="border-collapse: collapse; float: left; padding: 10px;">
		<tr>
			<td>科目</td>
			<td>借方</td>
			<td>贷方</td>
		</tr>
		<c:forEach items="${accountTypes }" var="type" varStatus="i">
			<c:choose>
				<c:when test="${fn:length(accountTypes)/2>i.index}">
					<tr>
						<td width="33%" style="font-weight: bold;">${i.index+1}、${type.typeName }</td>
						<td width="33%">
							<c:if test="${type.debtor ne 0.0 }">
								${type.debtor }
							</c:if>
						</td>
						<td width="33%">
							<c:if test="${type.credit ne 0.0 }">
								${type.credit }
							</c:if>
						</td>
					</tr>
					<c:forEach items="${type.accountants }" var="accountant">
						<tr>
							<td width="33%">${accountant.accountName }</td>
							<td width="33%">
								<c:if test="${accountant.debtor ne 0.0 }">
									${accountant.debtor }
								</c:if>	
							</td>
								
							<td width="33%">
								<c:if test="${accountant.credit ne 0.0 }">
									${accountant.credit }
								</c:if>	
							</td>
						</tr>
					</c:forEach>
				</c:when>
			</c:choose>
		</c:forEach>
	</table>
	<table width="50%" border="1" style="border-collapse: collapse; float: right; padding: 5px;">
		<tr>
			<td>科目</td>
			<td>借方</td>
			<td>贷方</td>
		</tr>
		<c:forEach items="${accountTypes }" var="type" varStatus="i">
			<c:choose>
				<c:when test="${fn:length(accountTypes)/2<=i.index}">
					<tr>
						<td width="33%" style="font-weight: bold;">${i.index+1}、${type.typeName }</td>
						<td width="33%"><c:if test="${type.debtor ne 0.0 }">${type.debtor }</c:if></td>
						<td width="33%"><c:if test="${type.credit ne 0.0 }">${type.credit }</c:if></td>
					</tr>
					<c:forEach items="${type.accountants }" var="accountant">
						<tr>
							<td width="33%">${accountant.accountName }</td>
							<td width="33%"><c:if test="${accountant.debtor ne 0.0 }">${accountant.debtor }</c:if></td>
							<td width="33%"><c:if test="${accountant.credit ne 0.0 }">${accountant.credit }</c:if></td>
						</tr>
					</c:forEach>
				</c:when>
			</c:choose>
		</c:forEach>
	</table>
</div>