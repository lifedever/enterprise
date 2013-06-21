<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../common/tag.jsp"%>
<div class="ftitle">
	收款信息<span class="form_desc">填写详细的收款信息</span>
</div>
<div style="padding: 10px 0 10px 60px;">
		<input type="hidden" id="countMoney" name="countMoney" value="${countMoney }" />
		<input type="hidden" id="hasMoney" name="hasMoney" value="${hasMoney }" />
		<form:form id="fm_newFinishedFee" method="post" class="fm" commandName="finishedFee">
			<input type="hidden" name="id" value="${finishedFee.id }" />
			<table>
				<tr>
					<td>订单号：</td>
					<td><input type="text" value="${orderNo }" class="easyui-validatebox" name="orderNo" id="orderNo" readonly="readonly" /></td>
				</tr>
				<tr>
					<td>收款金额：</td>
					<td><form:input type="text" class="easyui-numberbox" precision="2" id="hasCount" path="hasCount" onblur="checkMoney();"/></td>
				</tr>
				<tr>
					<td>转入账户：</td>
					<td><input type="text" class="easyui-numberbox" id="accountName11" data-options="required:true,missingMessage:'必填字段'"/>
						<input type="hidden" id="accountNo" name="accountNo"><input type="hidden" id="accountName" name="accountName">
					&nbsp;<font color="red">*</font>&nbsp;</td>
				</tr>
				<tr>
					<td>付款方：</td>
					<td><form:input type="text" class="easyui-validatebox" path="payer" data-options="required:true,missingMessage:'必填字段'" /> &nbsp;<font color="red">*</font>&nbsp;</td>
				</tr>
			</table>
		</form:form>
	<div id="dlg-buttons" style="text-align: center;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveFormData('newFinishedFee',false,'/finace/finishedfee/saveForm.html',saveFormSuccess)">保存</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#win_newFinishedFee').window('close')">取消</a>
	</div>
</div>
<script type="text/javascript">
(function() {
	//弹出银行账户 
	$('#accountName11').on('focus', function() {
		$('#win_accountName').window({
			href : '/finace/expenditure/listAccount.html'
		}).window('open');
	});
})();
	function saveFormSuccess(data){
		if (data) {
			$.messager.alert('提示信息', '操作成功！');
			$('#win_newFinishedFee').window('close'); // close the dialog
			$('#tt_newFinishedfee').datagrid('reload'); // reload the user data
		} else {
			$.messager.alert('提示信息', '操作失败！');
		}
	}
</script>