<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="../common/tag.jsp"%>
<!-- 用户添加表单 -->
<div id="dlg_top3" class="easyui-dialog"
	style="width: 600px; height: 320px; padding: 10px 20px" closed="true"
	buttons="#dlg-buttons">
	<div class="ftitle">
		用户信息<span class="form_desc">修改用户信息</span>
	</div>
	<div style="padding: 10px 0 10px 60px">
		<form id="fm_top3" method="post" class="fm">
			<table>
				<tr>
					<td>用户帐号：</td>
					<td><input class="easyui-validatebox" type="text"
						name="username" id="username"
						data-options="required:true,missingMessage:'必填字段'"></input> &nbsp;<font
						color="red">*</font>&nbsp;</td>
					<td>性别：</td>
					<td><select class="easyui-combobox" name="sex" id="sex"><option
								value="男">男</option>
							<option value="女">女</option>
					</select>&nbsp;<font color="red">*</font>&nbsp;</td>
				</tr>
				<tr>
					<td>真实姓名：</td>
					<td><input class="easyui-validatebox" type="text"
						name="realName" data-options="required:true,missingMessage:'必填字段'"></input>
						&nbsp;<font color="red">*</font>&nbsp;</td>
					<td>电话：</td>
					<td><input class="easyui-validatebox" type="text" name="tel"></input>
					</td>
				</tr>
				<tr>
					<td>手机号码：</td>
					<td><input class="easyui-validatebox" type="text"
						name="mobileTel"
						data-options="required:true,missingMessage:'必填字段'"></input> &nbsp;<font
						color="red">*</font>&nbsp;</td>
					<td>邮箱：</td>
					<td><input class="easyui-validatebox" type="text" name="email"
						data-options="validType:'email',invalidMessage:'请输入正确的邮箱格式'"></input>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div id="dlg-buttonsff">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="">保存</a> <a href="javascript:void(0)"
			class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="javascript:$('#dlg_top3').dialog('close')">取消</a>
	</div>