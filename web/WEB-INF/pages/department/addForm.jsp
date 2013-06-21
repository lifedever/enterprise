<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--author: gefangshuai 2012-11-13 下午10:01:33-->
	<div id="dlg" class="easyui-dialog" data-options="modal:true,closed:true"
		style="width: 500px; height: 270px; padding: 10px 20px"
		buttons="#dlg-buttons">
		<div class="ftitle">
			部门信息<span class="form_desc">填写部门信息</span>
		</div>
		<div style="padding: 10px 0 10px 60px">
			
			<form id="fm" method="post" class="fm">
			<input type="hidden" id="deptId" name="parentId"/>
				<table>
					<tr>
						<td>
							上级部门：
						</td>
						<td>
							<label id="parentDept"></label>
						</td>
					</tr>
					<tr>
						<td>部门名称：</td>
						<td><input class="easyui-validatebox" type="text"
							name="departmentName" id="departmentName"
							data-options="required:true,missingMessage:'必填字段'"></input>
							&nbsp;<font color="red">*</font>&nbsp;</td>
					</tr>
					<tr>
						<td>部门编号：</td>
						<td><input class="easyui-validatebox" type="text"
							name="departmentCode"
							data-options="required:true,missingMessage:'必填字段'"></input>
							&nbsp;<font color="red">*</font>&nbsp;</td>
					</tr>
				</table>
			</form>
		</div>
		<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-ok" onclick="saveDept()">保存</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
		</div>
