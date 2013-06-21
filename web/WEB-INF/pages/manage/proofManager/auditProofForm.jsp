<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div id="dlg_addAudit" class="easyui-dialog"
	style="width: 370px; height: 190px; padding: 10px 20px"
	data-options="modal:true,closed:true" buttons="#dlg-buttons">
	<div class="ftitle">
		统计结算<span class="form_desc">审核样品的价格</span>
	</div>
	<div>
		<form id="fm_addAudit" method="post" class="fm">
			<table>
				<tr>
					<td>是否通过：</td>
					<td>
						<select name="managerAudit">
							<option value="1">未通过</option>
							<option value="2">已通过</option>
						</select>
						&nbsp;<font color="red">*</font>&nbsp;</td>
					<input type="hidden" name="id" id="p_id" />
				</tr>
			</table>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="saveAudit()">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel"
			onclick="javascript:$('#dlg_addAudit').dialog('close')">取消</a>
	</div>