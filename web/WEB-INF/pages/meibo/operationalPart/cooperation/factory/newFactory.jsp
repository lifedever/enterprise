<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/tag.jsp"%>
<div class="ftitle">
	客户信息<span class="form_desc">填写详细的客户信息</span>
</div>
<div style="padding: 10px 0 10px 60px;">
	<form:form id="fm_newFactory" method="post" class="fm" commandName="factory">
		<input type="hidden" name="id" value="${factory.id }" />
		<table border="0" width="90%">
			<tr>
				<td align="right">工厂名称：</td>
				<td><form:input type="text" path="factoryName" /></td>
				<td align="right">工厂编号：</td>
				<td><form:input type="text" path="factoryNo" /></td>
			</tr>
			<tr>
				<td align="right">工厂性质：</td>
				<td><form:input type="text" path="factoryProp" /></td>
				<td align="right">工厂星级：</td>
				<td>
					<form:select path="factoryStar">
						<form:option value="5" label="★★★★★"></form:option>
						<form:option value="4" label="★★★★"></form:option>
						<form:option value="3" label="★★★"></form:option>
						<form:option value="2" label="★★"></form:option>
						<form:option value="1" label="★"></form:option>
					</form:select>
				</td>
			</tr>
			<tr>
				<td align="right">工厂网址：</td>
				<td><form:input type="text" path="factorySite" /></td>
				<td align="right">联系人：</td>
				<td><form:input type="text" path="contactMan" /></td>
			</tr>
			<tr>
				<td align="right">联系电话：</td>
				<td><form:input type="text" path="phone" /></td>
				<td align="right">传真：</td>
				<td><form:input type="text" path="fax" /></td>
			</tr>
			<tr>
				<td align="right">手机：</td>
				<td><form:input type="text" path="mobile" /></td>
				<td align="right">QQ：</td>
				<td><form:input type="text" path="qq" /></td>
			</tr>
			<tr>
				<td align="right">地址：</td>
				<td><form:input type="text" path="address" /></td>
				<td align="right">备注：</td>
				<td><form:textarea type="text" path="remark"></form:textarea></td>
			</tr>
		</table>
	</form:form>
	<div id="dlg-buttons" style="text-align: center;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="saveFormData('newFactory',false,'/meibo/operationalPart/cooperation/factory/saveFactory.html',false)">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="javascript:$('#win_newFactory').window('close')">取消</a>
	</div>
</div>