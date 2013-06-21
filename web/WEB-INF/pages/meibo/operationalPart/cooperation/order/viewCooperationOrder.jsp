<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/tag.jsp"%>
<div style="font-size: 13px;" id="print">
	<h2 align="center">外协产品加工单</h2>
	<form id="fm_generateCooperationOrder">
		<table style="border-collapse: collapse; margin-left: 20px; border-width: 0px;" border="1" width="95%">
			<tr>
				<td width="10%"><strong>加工单位</strong></td>
				<td width="20%">${cooperationOrder.cooperationFactory }</td>
				<td width="10%"><strong>联&nbsp;&nbsp;系&nbsp;&nbsp;人</strong></td>
				<td width="25%">${cooperationOrder.callMan }</td>
				<td width="10%"><strong>联系电话</strong></td>
				<td width="25%">${cooperationOrder.phone }</td>
			</tr>
			<tr>
				<td width="10%"><strong>产品名称</strong></td>
				<td width="20%">${cooperationOrder.productName }</td>
				<td width="10%"><strong>数&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;量</strong></td>
				<td width="25%">${cooperationOrder.productCount }</td>
				<td width="10%"><strong>加工单号</strong></td>
				<td width="25%">${cooperationOrder.productNo }</td>
			</tr>
			<tr>
				<td width="10%"><strong>派单人员</strong></td>
				<td width="20%">${cooperationOrder.sendMan }</td>
				<td width="10%"><strong>下单时间</strong></td>
				<td width="25%">
					<fmt:formatDate value="${cooperationOrder.setOrderDate}" pattern="yyyy年MM月dd日" />
				</td>
				<td width="10%"><strong>交货时间</strong></td>
				<td width="25%"><fmt:formatDate value="${cooperationOrder.returnProductDate}" pattern="yyyy年MM月dd日" /></td>
			</tr>
			<tr>
				<td width="10%"><strong>联系时间</strong></td>
				<td width="20%"><fmt:formatDate value="${cooperationOrder.linkDate}" pattern="yyyy年MM月dd日" /></td>
				<td width="10%"><strong>单&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价</strong></td>
				<td width="25%">${cooperationOrder.price}元/个</td>
				<td width="10%"><strong>合计金额</strong></td>
				<td width="25%"><input type="text" style="border: 0px;width: 60px;" readonly="readonly" id="allCount2"/>元</td>
			</tr>
			<tr>
				<td colspan="3"><strong>主要材质、技术要求、规格尺寸图示</strong></td>
				<td colspan="3" rowspan="2" align="center">
					<a href="${cooperationOrder.image }" target="_blank"><img alt="图示" id="img_image" src="${cooperationOrder.image }" width="220px" height="220px" style="cursor: pointer;"></a>
				</td>
			</tr>
			<tr>
				<td colspan="3" style="vertical-align: top;">${cooperationOrder.required}</td>
			</tr>
			<tr>
				<td colspan="6">
					<table width="100%">
						<tr>
							<td width="50%"><strong>名称：</strong>${cooperationOrder.factoryName}</td>
							<td width="50%"><strong>电话：</strong>${cooperationOrder.factoryTel}</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<table width="100%">
						<tr>
							<td width="40%"><strong>地址：</strong>${cooperationOrder.factoryAddress}</td>
							<td width="30%"><strong>网址：</strong>${cooperationOrder.factorySite}</td>
							<td width="30%"><strong>邮箱：</strong>${cooperationOrder.factoryEmail}</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
</div>
<div id="dlg-buttons" style="text-align: center; margin-top: 20px;">
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-print"
		onclick="print('print')">打印</a>
</div>
<script type="text/javascript">
(function(){
	$('#allCount2').val('${cooperationOrder.productCount }'*'${cooperationOrder.price}');
})();
</script>