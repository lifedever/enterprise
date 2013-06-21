<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../common/tag.jsp"%>
<div class="ftitle">
	添加账户总额<span class="form_desc">填写总金额</span>
</div>
<div style="padding: 10px 0 10px 60px;">
	<form:form commandName="totalAccount" id="fm_totalAccount" method="post">
		<input type="hidden" id="accountId" name="accountId" value="${accountId }" />
		<form:hidden path="id"/>
		<table>
			<tr>
				<td>备注：</td>
				<td><form:textarea path="remark" cssStyle="width:200px;" /></td>
			</tr>
			<tr>
				<td>上次余额：</td>
				<td><input style="width:200px;" id="last" value="${tAccount.thisMoney }" class="easyui-numberbox" precision="2"/></td>
			</tr>
			<tr>
				<td>本次金额：</td>
				<td><input style="width:200px;" id="this" class="easyui-numberbox" precision="2" /></td>
			</tr>
			<tr>
				<td>总金额：</td>
				<td><form:input path="allMoney" id="allMoney" cssStyle="width:200px;"  readonly="true"/></td>
			</tr>
		</table>
	</form:form>
	<div id="dlg-buttons" style="text-align: center;margin-top: 20px;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveFormData('totalAccount',false,'/finace/dayAccount/saveTotalAccount.html',false)">保存</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#win_totalAccount').window('close')">取消</a>
	</div>
</div>
<script type="text/javascript">
	$('#this').blur(function(){
		var $last = Number($('#last').val());
		var $this = Number($('#this').val());
		$('#allMoney').val($last+$this);
	});
	$('#allMoney').click(function(){
		var $last = Number($('#last').val());
		var $this = Number($('#this').val());
		$('#allMoney').val($last+$this);
	});
</script>