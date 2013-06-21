<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!-- 用户添加表单 -->
<div id="dlg_employee" class="easyui-window" data-options="modal:true,closed:true" style="width: 760px; height: 400px; padding: 10px 20px" buttons="#dlg-buttons">
	<div class="ftitle">
		员工信息<span class="form_desc">编辑员工信息</span>
	</div>
	<div>
		<form id="fm_employee"  enctype="multipart/form-data" method="post" class="fm">
			<input type="hidden" name="empDeptId" id="empDeptId" />
			<table>
				<tr>
					<td>编号：</td>
					<td><input class="easyui-validatebox" type="text" name="empNo"></input> &nbsp;<font color="red">*</font>&nbsp;</td>
					<td>姓名：</td>
					<td><input class="easyui-validatebox" type="text" name="empName"></input> &nbsp;<font color="red">*</font>&nbsp;</td>
				</tr>
				<tr>
					<td>性别：</td>
					<td><select id="empSex" name="empSex" class="easyui-combobox"><option>男</option>
							<option>女</option></select> &nbsp;<font color="red">*</font>&nbsp;</td>
					<td>职位：</td>
					<td><select id="empPosition" name="positionId" class="easyui-combobox" data-options="valueField:'id',textField:'positionName',cache:false">
					</select> &nbsp;<font color="red">*</font>&nbsp;</td>
				</tr>
				<tr>
					<td>学历：</td>
					<td><select name="empEdu">
							<option>小学</option>
							<option>初中</option>
							<option>高中</option>
							<option>大专</option>
							<option>大学</option>
							<option>硕士研究生</option>
							<option>博士研究生</option>
					</select>
					<td>籍贯：</td>
					<td><input class="easyui-validatebox" type="text" name="empOrigin"></input></td>
				</tr>
				<tr>
					<td>身份证：</td>
					<td><input class="easyui-validatebox" type="text" name="empID"></input></td>
					<td>联系方式：</td>
					<td><input class="easyui-validatebox" type="text" name="empContact"></input></td>
				</tr>
				<tr>
					<td>员工照片：</td>
					<td colspan="3"><input type="file" name="file"></input></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="dlg-buttons" style="text-align: center; margin-top: 50px;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveEmp()">保存</a> <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg_employee').dialog('close')">取消</a>
	</div>
</div>