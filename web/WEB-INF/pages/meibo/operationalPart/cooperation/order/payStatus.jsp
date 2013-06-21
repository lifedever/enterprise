<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/tag.jsp"%>
<div style="text-align: center; margin-top: 20px;">
	<form:form commandName="order" id="fm_cooperationOrder">
		<input name="id" type="hidden" value="${order.id }" />
		<form:radiobutton path="payStatus" value="1" />已付款
		<form:radiobutton path="payStatus" value="0" />未付款
	</form:form>
</div>
<div id="dlg-buttons" style="text-align: center; margin-top: 20px;">
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveFormData('cooperationOrder',false,
				'/meibo/operationalPart/cooperation/order/saveStatus.html',false)">保存</a> <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
		onclick="javascript:$('#win_cooperationOrder').window('close')">取消</a>
</div>