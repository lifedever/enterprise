<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div id="dlg_addprepayment" class="easyui-window" title="收取预付款"
	style="width: 570px; height: 290px; padding: 10px 20px"
	data-options="modal:true,closed:true" buttons="#dlg-buttons">
	<div class="ftitle">
		统计结算<span class="form_desc">请输入预付款金额。</span>
	</div>
	<div>
		<form id="fm_addprepayment" method="post" class="fm">
		<input type="hidden" name="id" id="p_id" />
			<table style="width: 100%">
				<tr>
					<td align="right">预付款金额：</td>
					<td><input class="easyui-validatebox" type="text" name="prepay" id="aprepay" required="required"></input>
						&nbsp;<font color="red">*</font>&nbsp;</td>
				</tr>
				<tr>
					<td align="right">相关账户：</td>
					<td><input type="text" id="accountName" name="accountName" readonly="readonly" ></input> <input type="hidden" id="accountId" name="accountId"></input> &nbsp;<font color="red">*</font>
						<span style="font-size: 10px; color: gray;">点击输入框选择账户</span>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div id="dlg-buttons" style="text-align: center;">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="savePrepay()">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel"
			onclick="javascript:$('#dlg_addprepayment').dialog('close')">取消</a>
	</div>
	</div>