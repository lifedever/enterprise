<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="../common/tag.jsp"%>
	<!-- 修改密码表单 -->
	<div id="pass_dlg" class="easyui-dialog"
		data-options="modal:true,closed:true"
		style="width: 700px; height: 320px; padding: 10px 20px"
		buttons="#dlg-buttons">
		<div class="ftitle">
			修改密码信息<span class="form_desc">建议密码为英文、数字的组合</span>
		</div>
		<div style="padding: 10px 0 10px 60px">
			<form id="pass_fm" method="post" class="fm">
				<table>
					<tr>
						<td style="text-align: right">旧密码：</td>
						<td><input class="easyui-validatebox" type="password"
							name="oldPassword" id="oldPassword"></input> &nbsp;<font
							color="red">*</font>&nbsp;<span id="pass_msg2">初始密码：123456</span></td>
					</tr>
					<tr>
						<td style="text-align: right">新密码：</td>
						<td><input class="easyui-validatebox" type="password"
							name="newPassword" id="newPassword"></input> &nbsp;<font
							color="red">*</font>&nbsp;</td>
					</tr>
					<tr>
						<td style="text-align: right">再次输入新密码：</td>
						<td><input class="easyui-validatebox" type="password"
							name="newPassword2" id="newPassword2"></input> &nbsp;<font
							color="red">*</font>&nbsp;</td>
					</tr>
				</table>
			</form>
		</div>
		<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-ok" onclick="savePass()">保存</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-cancel"
				onclick="javascript:$('#pass_dlg').dialog('close')">取消</a>
		</div>
