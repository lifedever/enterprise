<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../common/tag.jsp"%>
<div>
	<form:form id="fm_voucherItem" method="post" class="fm" commandName="voucherItem">
		<form:input path="id" cssStyle="display:none" />
		<div>
			<label style="color: red;">温馨提示:</label>填完左边内容,右边部分内容会自动生成
		</div>
		<table width="100%">
			<tr>
				<td align="right">摘要：</td>
				<td><form:input type="text" path="remark" /></td>
			</tr>
			<tr>
				<td align="right">总账科目：</td>
				<td><form:input type="text" path="accountantType" id="superAccountantName1" readonly="readonly" onclick="onClick1();" /></td>
			</tr>
			<tr>
				<td align="right">明细科目：</td>
				<td><form:input type="text" path="accountantName" id="accountantName1"/></td>
			</tr>
			<tr>
				<td align="right">借方金额：</td>
				<td><form:input type="text" path="debtor" id="debtor1" class="easyui-numberbox" precision="2" /></td>
			</tr>
			<tr>
				<td align="right">贷方金额：</td>
				<td><form:input type="text" path="credit" id="credit1" class="easyui-numberbox" precision="2" /></td>
			</tr>
		</table>
	</form:form>
</div>
<div id="dlg-buttons" style="text-align: center;">
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveFormData('voucherItem',false,'/finace/voucher/saveVoucherItem.html',false)">保存</a> <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
		onclick="javascript:$('#win_voucherItem').window('close')">取消</a>
</div>
<script type="text/javascript">
	(function() {
		/* $('#debtor1').on('blur', function() {
			$('#credit2').val($(this).val());
		});
		$('#credit1').on('blur', function() {
			$('#debtor2').val($(this).val());
		}); */
	})();
	function onClick1() {
		$('#win_accountantName1').window({
			href : '/finace/voucher/listAccountant1.html'
		}).window('open');
	}
	function onClick2() {
		$('#win_accountantName1').window({
			href : '/finace/voucher/listAccountant2.html'
		}).window('open');
	}
	function addAccountant1() {
		var row1 = $('#tt_accountantType').datagrid('getSelected');
		var row2 = $('#tt_accountant').datagrid('getSelected');
		if (row2) {
			$('#win_accountantName1').window('close');
			$.messager.alert('提示', '选择成功！');
			$('#superAccountantName1').val(row2.accountName);//总账科目

		} else {
			$.messager.alert('提示', '请选择会计科目！');
		}
	}
	function addAccountant2() {
		var row1 = $('#tt_accountantType').datagrid('getSelected');
		var row2 = $('#tt_accountant').datagrid('getSelected');
		if (row2) {
			$('#win_accountantName1').window('close');
			$.messager.alert('提示', '选择成功！');
			$('#superAccountantName2').val(row2.accountName);//总账科目

		} else {
			$.messager.alert('提示', '请选择会计科目！');
		}
	}
</script>