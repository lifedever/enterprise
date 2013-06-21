<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/tag.jsp"%>
<!-- 用户添加表单 -->
<div id="dlg" class="easyui-window" data-options="modal:true,closed:true" style="width: 800px; height: 320px; padding: 10px 20px" buttons="#dlg-buttons">
	<div class="ftitle">
		用户信息<span class="form_desc">填写详细的用户信息，以便备案</span>
	</div>
	<div style="padding: 10px 0 10px 60px;">
		<form id="fm" method="post" class="fm">
			<table>
				<tr>
					<td>用户帐号：</td>
					<td><input class="easyui-validatebox" type="text" name="username" id="username" data-options="required:true,missingMessage:'必填字段'"></input> &nbsp;<font color="red">*</font>&nbsp;</td>
					<td>性别：</td>
					<td><select class="easyui-combobox" name="sex" id="sex"><option value="男">男</option>
							<option value="女">女</option>
					</select>&nbsp;<font color="red">*</font>&nbsp;</td>
				</tr>
				<tr>
					<td>真实姓名：</td>
					<td><input type="text" id="realName" name="realName"></input></td>
					<td>电话：</td>
					<td><input class="easyui-validatebox" type="text" id="tel" name="tel"></input></td>
				</tr>
				<tr>
					<td>手机号码：</td>
					<td><input class="easyui-validatebox" type="text" id="mobileTel" name="mobileTel" data-options="required:true,missingMessage:'必填字段'"></input> &nbsp;<font color="red">*</font>&nbsp;</td>
					<td>邮箱：</td>
					<td><input class="easyui-validatebox" type="text" name="email" data-options="validType:'email',invalidMessage:'请输入正确的邮箱格式'"></input></td>
				</tr>
				<tr>
					<td>所属部门：</td>
						<td><select class="easyui-combobox" id="deptCombox"
							name="department.id"
							data-options="valueField:'id',textField:'departmentName',required:true,missingMessage:'必填字段'">
						</select>&nbsp; <font color="red">*</font>&nbsp;</td>
						</td>
					<!-- 
						<td>角色：</td>
						<td><select class="easyui-combobox" id="roleCombox"
							name="role.id"
							data-options="valueField:'id',textField:'roleName',required:true,missingMessage:'必填字段'">
						</select></td>
					-->
					<td>是否有效：</td>
					<td><select class="easyui-combobox" name="activeFlag" id="activeFlag">
							<option value="1">有效</option>
							<option value="0">无效</option>
					</select>&nbsp;<font color="red">*</font>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="4"><font color="red"><strong>注意：</strong></font>用户的初始密码为：123456，请及时更改！</td>
				</tr>
			</table>
		</form>
		<div id="dlg-buttons" style="text-align: center;">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">保存</a> <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
		</div>
	</div>
</div>