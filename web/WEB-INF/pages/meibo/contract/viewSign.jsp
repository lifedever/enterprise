<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../common/tag.jsp"%>
<div class="ftitle">
	签单详情<span class="form_desc">查看签单详细内容</span>
</div>
<div style="padding: 10px 0 10px 60px;" id="print_sign">
	<table border="1" width="90%" style="border-collapse:collapse;">
		<tr>
			<td width="45%" style="padding: 5px;"><strong>供&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;方</strong>：${sessionScope.title }</td>
			<td style="padding: 5px;"><strong>签订日期</strong>：<fmt:formatDate value="${contract.signDate}" pattern="yyyy年MM月dd日" />
		</tr>
		<tr>
			<td width="45%"style="padding: 5px;"><strong>合同编号</strong>：${contract.contractNo }</td>
			<td style="padding: 5px;"><strong>有效期至</strong>：<fmt:formatDate value="${contract.validateDate}" pattern="yyyy年MM月dd日" />
		</tr>
		<tr>
			<td colspan="2" style="padding: 5px;border-bottom-width: 0px;"><strong>合同条款</strong>：</td>
		</tr>
		<tr>
			<td colspan="2" style="padding-bottom: 10px; padding-left: 20px;border-top-width: 0px;">${contract.content }</td>
		</tr>
		<tr style="margin-bottom: 10px;" style="padding: 5px;">
			<td><strong>供方签约人</strong>：${contract.provider }
			<td><strong>需方签约人</strong>：${contract.buyer }
		</tr>
	</table>
	<c:if test="${contract.contractAtta ne '' }">
		<div style="margin-top: 20px;font-weight: bold;">下载附件：<a href="${contract.contractAtta }" target="_blank">下载</a></div>
	</c:if>
</div>
<div id="dlg-buttons" style="text-align: center;margin-top: 20px;">
	<a href="javascript:printSign()" class="easyui-linkbutton" iconCls="icon-print" >打印</a> <a
		href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
		onclick="javascript:$('#win_viewSign').window('close')">取消</a>
</div>
<script type="text/javascript">
	function sveContractSuccess(data) {
		if (data) {
			$.messager.alert('提示信息', '操作成功！');
			$('#win_signForm').window('close'); // close the dialog
			$('#tt_order').datagrid('reload'); // reload the user data
		} else {
			$.messager.alert('提示信息', '操作失败！');
		}
	}
</script>