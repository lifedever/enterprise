<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../../common/tag.jsp"%>
<!-- 填写打样表单 -->
<div id="dlgAuditProof" class="easyui-dialog" style="width: 490px; height: 220px; padding: 10px 20px" data-options="modal:true,closed:true" buttons="#dlg-buttons">
	<div class="ftitle">
		审批样品<span class="form_desc"></span>
	</div>
	<form id="fmAuditProof" method="post" class="fm">
		<input type="hidden" id="proofId" name="id" />
		<table border="0" width="90%">
			<tr>
				<td align="right">审批状态：</td>
				<td><select style="height: 23px; width: 127px;" onchange="showor();" id="isAudit" name="isAudit">
						<option value="2">通过</option>
						<option value="1">不通过</option>
				</select></td>
			</tr>
			<tr>
				<td align="right">样品费(单价)：</td>
				<td><input type="proofMoney" name="proofMoney" value="0" class="easyui-numberbox" precision="2" />元</td>
			</tr>
		</table>
	</form>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveAudit()">保存</a> <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlgAuditProof').dialog('close')">取消</a>
	</div>
</div>
