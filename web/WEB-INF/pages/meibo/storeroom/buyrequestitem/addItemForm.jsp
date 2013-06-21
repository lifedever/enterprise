<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../common/tag.jsp"%>
<div class="ftitle">
	询价条目信息<span class="form_desc">填写询价具体条目的信息</span>
</div>
<div style="padding: 10px 0 10px 60px;">
	<form:form id="fm_addBuyRequestItem" method="post" class="fm" commandName="buyRequestItem">
		<table border="0" width="90%">
			<tr>
				<td width="10%">名称：</td>
				<td width="40%"><input type="text" class="easyui-validatebox" name="name" data-options="required:true,missingMessage:'必填字段'" /> &nbsp;<font color="red">*</font>&nbsp;</td>
				<td width="10%">标准：</td>
				<td width="40%"><input type="text" name="standard" /></td>
			</tr>
			<tr>
				<td>数量：</td>
				<td><input type="text" name="count" class="easyui-numberspinner" data-options="min:1,required:true,missingMessage:'必填字段'" style="width: 155px;" /> &nbsp;<font color="red">*</font>&nbsp;</td>
				<td>单位：</td>
				<td><input type="text" name="unit" /></td>
			</tr>
			<tr>
				<td>估价：</td>
				<td><form:input type="text" path="valuation" class="easyui-numberbox" precision="2" id="valuation"/></td>
				<td>用途：</td>
				<td><input type="text" name="purpose" /></td>
			</tr>
			<tr>
				<td>备注：</td>
				<td colspan="3"><input type="text" name="beizhu" /></td>
			</tr>
		</table>
	</form:form>
	<div id="dlg-buttons" style="text-align: center;margin-top: 50px;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveFormData('addBuyRequestItem',false,'/meibo/storeroom/buyrequestitem/saveTempForm.html',false)">保存</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#win_addBuyRequestItem').window('close')">取消</a>
	</div>
</div>