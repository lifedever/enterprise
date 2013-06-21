<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../common/tag.jsp"%>
<div class="ftitle">
	定价信息<span class="form_desc">填写详细的定价信息</span>
</div>
<div style="padding: 10px 0 10px 60px;">
		<form:form id="fm_newPricing" method="post" class="fm" commandName="commodity">
			<input type="hidden" name="id" value="${commodity.id }" />
			<table>
				<tr>
					<td align="right">材料名称：</td>
					<td><input type="text"  id="name"  value="${commodity.name }"  readonly="readonly"/></td>
				</tr>
				<tr>
					<td align="right">单价：</td>
					<td><form:input id="price" path="price" class="easyui-numberbox" precision="2"  data-options="required:true,missingMessage:'必填字段'" />  
 					&nbsp;<font color="red">*</font>&nbsp;</td>
				</tr>
			</table>
		</form:form>
	<div id="dlg-buttons" style="text-align: center;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveFormData('newPricing',false,'/finace/pricing/savePricing.html',false)">保存</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#win_newPricing').window('close')">取消</a>
	</div>
</div>