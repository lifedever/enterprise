<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../../common/tag.jsp"%>
<!-- 填写打样表单 -->
<div id="dlgFinaceAuditProof" class="easyui-dialog" style="width: 490px; height: 220px; padding: 10px 20px" data-options="modal:true,closed:true" buttons="#dlg-buttons">
	<div class="ftitle">
		审批样品<span class="form_desc"></span>
	</div>
	<form id="fmFinaceAuditProof" method="post" class="fm">
		<input type="hidden" id="proofId" name="id" />
		<table border="0" width="90%">
			<tr>
				<td align="right">收款帐号</td>
				<td><input type="text" id="accountName" readonly="readonly" placeholder="单击选择账户" />
				<input type="hidden" name="accountId" id="accountId" /></td>
			</tr>
		</table>
	</form>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="savePay()">保存</a> <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlgFinaceAuditProof').dialog('close')">取消</a>
	</div>
</div>
