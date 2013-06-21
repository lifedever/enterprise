<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../common/tag.jsp"%>
<div class="ftitle">
	奖惩信息<span class="form_desc">填写详细的奖惩信息</span>
</div>
<div style="padding: 10px 0 10px 60px;">
	<form:form id="fm_rp" method="post" class="fm" commandName="rp">
		<input type="hidden" name="id" value="${rp.id }" />
		<table border="0" width="100%">
			<tr>
				<td align="right">奖惩类型：</td>
				<td><input type="radio" name="type" value="0" checked="checked" /><span style="color: green;">奖</span> <input type="radio" name="type" value="1" /><span style="color: red;">惩</span></td>
			</tr>
			<tr>
				<td align="right">姓名：</td>
				<td><form:input type="text" class="easyui-validatebox" path="userName" data-options="required:true,missingMessage:'必填字段'" /> &nbsp;<font color="red">*</font>&nbsp;</td>
			</tr>
			<tr>
				<td align="right">缘由：</td>
				<td><form:input type="text" path="reason" /></td>

			</tr>
			<tr>
				<td align="right">金额：</td>
				<td><form:input path="sum" class="easyui-numberbox" precision="2" /></td>
			</tr>
			<tr>
				<td align="right">日期时间：</td>
				<td><form:input type="text" path="createDate" class="easyui-datebox" /></td>
			</tr>
			<tr>
				<td align="right">备注：</td>
				<td><form:textarea path="remark" /></td>
			</tr>
		</table>
	</form:form>
	<div id="dlg-buttons" style="text-align: center;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveFormData('rp',false,'/finace/rp/saveForm.html',false)">保存</a> <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#win_rp').window('close')">取消</a>
	</div>
</div>