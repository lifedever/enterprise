<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../common/tag.jsp"%>
<div class="ftitle">
	签订合同<span class="form_desc">请认真填写合同信息，填写后不可更改</span>
</div>
<div style="padding: 10px 0 10px 60px;">
	<form:form id="fm_signForm" method="post" class="fm" enctype="multipart/form-data">
		<input type="hidden" name="orderNo" value="${orderNo}" />
		<table border="0" width="90%">
			<tr>
				<td width="45%">供&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;方：${sessionScope.title }</td>
				<td>签订日期：<input name="signDate" readonly="readonly" class="easyui-datebox"></td>
			</tr>
			<tr>
				<td width="45%">合同编号：${contractNo }<input type="hidden" name="contractNo" value="${contractNo }" /></td>
				<td>有效期至：<input name="validateDate" readonly="readonly" class="easyui-datebox"></td>
			</tr>
			<tr>
				<td colspan="2">合同条款：</td>
			</tr>
			<tr>
				<td colspan="2"><textarea style="width: 470px; height: 170px;" name="content"></textarea></td>
			</tr>
			<tr>
				<td>供方签约人：<input type="text" name="provider" /></td>
				<td>需方签约人：<input type="text" name="buyer" /></td>
			</tr>
			<tr>
				<td colspan="2">上传合同附件：<input type="file" name="atta"/></td>
			</tr>
		</table>
	</form:form>
	<div id="dlg-buttons" style="text-align: center;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="saveFormData('signForm',false,'/meibo/contract/saveContract.html',sveContractSuccess)">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="javascript:$('#win_signForm').window('close')">取消</a>
	</div>
</div>
<script type="text/javascript">
	function sveContractSuccess(data){
		if (data) {
			$.messager.alert('提示信息', '操作成功！');
			$('#win_signForm').window('close'); // close the dialog
			$('#tt_order').datagrid('reload'); // reload the user data
		} else {
			$.messager.alert('提示信息', '操作失败！');
		}
	}
</script>