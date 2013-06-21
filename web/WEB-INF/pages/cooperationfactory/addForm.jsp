<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div id="dlg_factory" class="easyui-dialog" style="width: 690px; height: 389px; padding: 10px 20px" data-options="modal:true,closed:true">
	<div class="ftitle">
		协作工厂信息<span class="form_desc">填写协作工厂信息</span>
	</div>
	<div>
		<form id="fm_factory" method="post" class="fm" enctype="multipart/form-data">
			<table>
				<tr>
					<td>编号：</td>
					<td><input type="text" name="factoryNo" /></td>
					<td>名称：</td>
					<td><input type="text" name="factoryName" /></td>
				</tr>
				<tr>
					<td>性质：</td>
					<td><input type="text" name="factoryProp" /></td>
					<td>星级：</td>
					<td><select name="factoryStar" style="width: 150px;">
							<option value="1">★</option>
							<option value="2">★★</option>
							<option value="3">★★★</option>
							<option value="4">★★★★</option>
							<option value="5">★★★★★</option>
					</select></td>
				</tr>
				<tr>
					<td>网址：</td>
					<td><input type="text" name="factorySite" /></td>
					<td>外发人员：</td>
					<td><input type="text" name="employee" /></td>
				</tr>
				<tr>
					<td>电话：</td>
					<td><input type="text" name="phone" /></td>
					<td>联系人：</td>
					<td><input type="text" name="contactMan" /></td>
				</tr>
				<tr>
					<td>传真：</td>
					<td><input type="text" name="fax" /></td>
					<td>手机：</td>
					<td><input type="text" name="mobile" /></td>
				</tr>
				<tr>
					<td>职务：</td>
					<td><input type="text" name="post" /></td>
					<td>QQ：</td>
					<td><input type="text" name="qq" /></td>
				</tr>
				<tr>
					<td>地址</td>
					<td><input type="text" name="address" /></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="dlg-buttons" style="text-align: center; margin-top: 30px;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveFactory()">保存</a> <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg_factory').dialog('close')">取消</a>
	</div>
</div>