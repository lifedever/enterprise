<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../../../common/tag.jsp"%>
<div class="ftitle">
	订单详情<span class="form_desc">订单详情列表<font color="blue">【订单编号：${order.orderNo }】</font></span>
</div>
<div style="padding: 10px 0 10px 60px;">
	<form id="fm_auditOrder">
		<input type="hidden" name="orderId" value="${order.id }" />
		<table width="80%" border="0">
			<tr>
				<td><strong>开始时间：</strong> <fmt:formatDate value="${order.startDate}" pattern="yyyy年MM月dd日" /></td>
				<td><strong>结束时间：</strong> <fmt:formatDate value="${order.endDate}" pattern="yyyy年MM月dd日" /></td>
			</tr>
			<tr>
				<td colspan="2">审批状态： <input type="radio" value="1" name="isAudit" checked="checked" /><span
					style="color: green;">通过</span> <input type="radio" value="-1" name="isAudit" /><span style="color: red;">未通过</span>
				</td>
			</tr>
		</table>
	</form>
</div>
<div id="dlg-buttons" style="text-align: center; margin-top: 20px;">
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok"
		onclick="saveFormData('auditOrder',false,'/meibo/order/audit/saveAudit.html',false)">保存</a> 
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
		onclick="javascript:$('#win_auditOrder').window('close')">取消</a>
</div>
