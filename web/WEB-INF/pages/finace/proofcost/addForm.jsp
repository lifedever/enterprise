<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div id="dlg_addCost" class="easyui-dialog"
	style="width: 570px; height: 290px; padding: 10px 20px"
	data-options="modal:true,closed:true" buttons="#dlg-buttons">
	<div class="ftitle">
		统计结算<span class="form_desc">请输入样品单价，系统会自动计算价格</span>
	</div>
	<div>
		<form id="fm_addCost" method="post" class="fm">
		<input type="hidden" name="id" id="p_id" />
			<table style="width: 100%">
				<tr>
					<td align="right">输入单价：</td>
					<td><input class="easyui-validatebox" type="text" name="proofMoney" id="proofMoney"></input>
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
			iconCls="icon-ok" onclick="savePrice()">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel"
			onclick="javascript:$('#dlg_addCost').dialog('close')">取消</a>
	</div>
	</div>