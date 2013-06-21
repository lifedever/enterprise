<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../common/tag.jsp"%>
<div class="ftitle">
	银行日记账信息<span class="form_desc">填写银行日记账</span>
</div>
<div style="padding: 10px 0 10px 60px;">
	<form:form commandName="dayAccount" id="fm_dayAccount" method="post">
		<input type="hidden" id="totalAccountId" name="totalAccount.id" value="${totalAccount.id }" />
		<form:hidden path="id"/>
		<table>
			
			<tr>
				<td>总额：<input style="width:200px;" id="zonge" value="${totalAccount.thisMoney }" readonly="true"/></td>
			</tr>
			<tr>
				<td>摘要：<form:textarea path="remark" cssStyle="width:200px;" /></td>
			</tr>
			<tr>
				<td>借方：<form:input path="debtor" id="debtor" cssStyle="width:200px;" class="easyui-numberbox" precision="2" data-options="required:true,missingMessage:'必填字段'"/></td>
			</tr>
			<tr>
				<td>贷方：<form:input path="lender" id="lender" cssStyle="width:200px;" class="easyui-numberbox" precision="2" data-options="required:true,missingMessage:'必填字段'"/></td>
			</tr>
		</table>
	</form:form>
	<div id="dlg-buttons" style="text-align: center;margin-top: 20px;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveFormData('dayAccount',beforeSub,'/finace/dayAccount/saveDayAccount.html',saveSuccess)">保存</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#win_dayAccount').window('close')">取消</a>
	</div>
</div>
<script type="text/javascript">
	function beforeSub(){
		var zonge = Number($('#zonge').val());
		var debtor = Number($('#debtor').val());
		var lender = Number($('#lender').val());
		if((zonge+debtor-lender)<0){
			$.messager.alert('错误','余额不足！');
			return false;
		}
	}
	function saveSuccess(data){
		var money = Number($('#zonge').val())+Number($('#debtor').val())-Number($('#lender').val());
		$('#money').html(money);
		$('#win_dayAccount').window('close'); //close the dialog
		$('#tt_dayAccount').datagrid('reload'); // reload the user data
		$('#tt_totalAccount').datagrid('reload'); // reload the user data
	}
</script>