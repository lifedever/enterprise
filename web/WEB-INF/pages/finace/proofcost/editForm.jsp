<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div id="dlg_editCost" class="easyui-dialog"
	style="width: 570px; height: 190px; padding: 10px 20px"
	data-options="modal:true,closed:true" buttons="#dlg-buttons">
	<div class="ftitle">
		实收金额<span class="form_desc">请输入实收金额，系统会根据实收金额统计收支状况</span>
	</div>
	<div>
		<form id="fm_editCost" method="post" class="fm">
		<input type="hidden" name="id" id="pro_id" />
			<table>
				<tr>
					<td width="50%" align="right">输入实收金额：</td>
					<td><input class="easyui-validatebox" type="text" name="proofRealCost" id="proofRealCost"></input>
						&nbsp;<font color="red">*</font>&nbsp;</td>
				</tr>
			</table>
		</form>
	</div>
	<div id="dlg-buttons" style="text-align: center;">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="saveRealPrice()">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel"
			onclick="javascript:$('#dlg_editCost').dialog('close')">取消</a>
	</div>
	</div>