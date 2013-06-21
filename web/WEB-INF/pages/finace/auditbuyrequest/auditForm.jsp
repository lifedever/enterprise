<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../../common/tag.jsp"%>
	<div class="ftitle">
		请购单审批<span class="form_desc"></span>
	</div>
		<div style="margin: 10px 10px 10px 40px;">
		<form id="fm_auditbuyRequest" method="post" class="fm">
			<input type="hidden" id="buyRequestId" name="buyRequestId" value="${buyRequestId }"/>
			<table border="0">
				<tr>
					<td width="40%" align="right">支出金额：</td>
					<td width="60%"><input type="text" class="easyui-numberbox" precision="2" id="totalPrice" name="totalPrice"data-options="required:true,missingMessage:'必填字段'" /> &nbsp;<font color="red">*</font>&nbsp;</td>
				</tr>
				<tr>
					<td align="right">
						操作账户：
					</td>
					<td>
						<input type="text" id="accountName22" name="accountName22" readonly="readonly" placeholder="单击选择账户" />
						<input type="hidden" name="accountIdNo" id="accountIdNo" />
						<input type="hidden" name="accountNameNo" id="accountNameNo" />
					</td>
				</tr>
			</table>
		</form>
		</div>
	<div style="text-align: center;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveFormData('auditbuyRequest',false,'/finace/auditbuyrequest/saveAuditForm.html',saveFormSuccess)">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#win_auditbuyRequest').dialog('close')">取消</a>
	</div>
	<script type="text/javascript">
(function() {
	//弹出银行账户 
	$('#accountName22').on('focus', function() {
		$('#win_accountName').window({
			href : '/finace/expenditure/listAccount.html'
		}).window('open');
	});
})();
	function saveFormSuccess(data){
		if (data) {
			$.messager.alert('提示信息', '操作成功！');
			$('#win_auditbuyRequest').window('close'); // close the dialog
			$('#tt_buyRequest').datagrid('reload'); // reload the user data
		} else {
			$.messager.alert('提示信息', '操作失败！');
		}
	}
</script>