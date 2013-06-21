<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../common/tag.jsp"%>
<div class="ftitle">
	客户信息<span class="form_desc">填写详细的客户信息</span>
</div>
<div style="padding: 10px 10px 10px 10px;">
	<form:form id="fm_newCustomer" method="post" class="fm" commandName="customer">
		<input type="hidden" name="id" value="${customer.id }" />
		<table border="0" width="100%">
			<tr>
				<td>姓名：</td>
				<td><form:input class="easyui-validatebox" type="text" path="customerName"
						data-options="required:true,missingMessage:'必填字段'" /> &nbsp;<font color="red">*</font>&nbsp;</td>
				<td>公司：</td>
				<td><form:input type="text" path="company" /></td>
			</tr>
			<tr>
				<td>手机：</td>
				<td><form:input class="easyui-validatebox" type="text" path="mobile"
						data-options="required:true,missingMessage:'必填字段'" />&nbsp;<font color="red">*</font>&nbsp;</td>
				<td>电话：</td>
				<td><form:input type="text" path="telphone" /></td>
			</tr>
			<tr>
				<td>地址：</td>
				<td><form:input type="text" path="address" /></td>
				<td>传真：</td>
				<td><form:input type="text" path="fax" /></td>
			</tr>
			<tr>
				<td>网站：</td>
				<td><form:input type="text" path="webSite" /></td>
				<td>邮箱：</td>
				<td><form:input type="text" path="email" /></td>
			</tr>
			<tr>
				<td>QQ：</td>
				<td><form:input type="text" path="QQ" /></td>
				<td>MSN：</td>
				<td><form:input type="text" path="MSN" /></td>
			</tr>
			<tr>
				<td>旺旺：</td>
				<td><form:input type="text" path="wangWang" /></td>
				<td>飞信：</td>
				<td><form:input type="text" path="feiXin" /></td>
			</tr>
			<tr>
				<td>备注：</td>
				<td colspan="3"><form:textarea type="text" path="remark" cols="44"></form:textarea></td>
			</tr>
		</table>
	</form:form>
	<div id="dlg-buttons" style="text-align: center;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveFormData('newCustomer',false,'/meibo/customer/saveCustomer.html',false)">保存</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#win_newCustomer').window('close')">取消</a>
	</div>
</div>