<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div id="dlg_addtotalmoney" class="easyui-window" title="收取全款"
	style="width: 570px; height: 290px; padding: 10px 20px"
	data-options="modal:true,closed:true" buttons="#dlg-buttons">
	<div class="ftitle">
		统计结算<span class="form_desc">为了减少不必要的麻烦，请细心填写全款金额。</span>
	</div>
	<div>
		<form id="fm_addtotalmoney" method="post" class="fm">
		<input type="hidden" name="id" id="ptotal_id" />
			<table style="width: 100%">
				<tr>
					<td align="right">全款金额：</td>
					<td><input type="text" readonly="readonly" id="totalMoney" name="totalMoney"/></td>
				</tr>
				<tr>
					<td align="right">相关账户：</td>
					<td><input type="text" id="accountNameTotal" name="accountNameTotal" readonly="readonly" ></input> <input type="hidden" id="accountIdTotal" name="accountIdTotal"></input> &nbsp;<font color="red">*</font>
						<span style="font-size: 10px; color: gray;">点击输入框选择账户</span>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div id="dlg-buttons" style="text-align: center;">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="saveTotalmoney()">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel"
			onclick="javascript:$('#dlg_addtotalmoney').dialog('close')">取消</a>
	</div>
	</div>