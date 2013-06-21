<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../../../common/tag.jsp"%>
<div class="ftitle">
	备料单详情<span class="form_desc">备料单详细列表<font color="blue">【备料单号：${prepareOrder.prepareNo }】</font></span>
</div>
<div style="padding-left: 30px;" id="print_prepare">
	<h1 style="text-align: center;">备料单</h1>
	<table border="1" style="border-collapse: collapse;border-top-width: 0px;border-left-width: 0px;border-right-width: 0px;border-bottom-width: 0xp;" width="90%">
		<tr  style="border-width:0px;">
			<td colspan="4" width="75%"  style="border-width: 0px;">&nbsp;</td>
			<td colspan="2"  style="border-width: 0px;padding-bottom: 3px;">
				填单日期：<fmt:formatDate value="${prepareOrder.createDate}" pattern="yyyy年MM月dd日" />
			</td>
		</tr>
		<tr>
			<td width="15%">
				加工单号
			</td>
			<td width="15%">
				${prepareOrder.orderItem.productNo }
			</td>
			<td width="15%">
				<c:choose>
					<c:when test="${prepareOrder.orderItem.order.isProof eq 1 }">样品</c:when>
					<c:otherwise>产品</c:otherwise>
				</c:choose>名称
			</td>
			<td width="15%">
				${prepareOrder.orderItem.productName }
			</td>
			<td>
				客户名称
			</td>
			<td width="15%">
				${prepareOrder.orderItem.productName }
			</td>
		</tr>
		<tr>
			<td>
				<c:choose>
					<c:when test="${prepareOrder.orderItem.order.isProof eq 1 }">样品</c:when>
					<c:otherwise>产品</c:otherwise>
				</c:choose>数量
			</td>
			<td>
				${prepareOrder.orderItem.productCount }
			</td>
			<td>
				所需日期
			</td>
			<td colspan="3">
				<fmt:formatDate value="${prepareOrder.orderItem.order.startDate}" pattern="yyyy年MM月dd日" /> ~
				<fmt:formatDate value="${prepareOrder.orderItem.order.endDate}" pattern="yyyy年MM月dd日" />
			</td>
		</tr>
		<tr>
			<td>单个产品用料情况</td>
			<td colspan="5" valign="top">${prepareOrder.useCondition}</td>
		</tr>
		<c:forEach items="${classifies }" var="classify">
			<tr>
				<td>
					${classify }
				</td>
				<td colspan="5">
					<table border="1" style="border-collapse: collapse;" width="100%">
						<tr>
							<td>名称</td>
							<td>规格</td>
							<td>数量</td>
							<td>颜色</td>
							<td>厚度</td>
							<td>备注</td>
						</tr>
						<c:forEach items="${materMap[classify] }" var="material">
							<tr>
								<td>${material.name }</td>
								<td>${material.standard }</td>
								<td>${material.count }</td>
								<td>${material.color }</td>
								<td>${material.thickness }</td>
								<td>${material.remark }</td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td>
				其它
			</td>
			<td colspan="5">
				${prepareOrder.remark }
			</td>
		</tr>
	</table>
</div>
<div id="dlg-buttons" style="text-align: center;margin-top:3px;">
	<a href="javascript:printPrepare()" class="easyui-linkbutton" iconCls="icon-print" >打印</a>
</div>
<script type="text/javascript">
	function printPrepare(){
		$('#print_prepare').printArea();
	}
</script>
