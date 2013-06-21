<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<!-- 用户添加表单 -->
	<div id="dlg" class="easyui-dialog"
		data-options="modal:true,closed:true"
		style="width: 570px; height: 290px; padding: 10px 20px"
		buttons="#dlg-buttons">
		<div class="ftitle">
			角色信息<span class="form_desc">填写角色信息</span>
		</div>
		<div>
			<form id="fm" method="post" class="fm">
				<table>
					<tr>
						<td>角色名：</td>
						<td><input class="easyui-validatebox" type="text"
							name="roleName"></input> &nbsp;<font color="red">*</font>&nbsp;</td>

					</tr>
					<tr>
						<td>角色描述：</td>
						<td><textarea name="roleDescription" style="height: 60px;"></textarea>
						</td>
					</tr>
					<tr>
						<td>是否有效：</td>
						<td><select class="easyui-combobox" name="activeFlag"
							id="activeFlag"><option value="1">有效</option>
								<option value="0">无效</option>
						</select></td>
					</tr>
				</table>
			</form>
		</div>
		<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-ok" onclick="saveRole()">保存</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
		</div>
