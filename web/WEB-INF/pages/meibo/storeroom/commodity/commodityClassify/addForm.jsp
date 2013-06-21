<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../../../common/tag.jsp"%>
<div class="ftitle">
	货源分类信息<span class="form_desc">请填写完整的货源分类信息</span>
</div>
<div style="padding: 10px 0 10px 60px;">
	<form:form id="fm_newCommodityClassify" method="post" class="fm" commandName="commodityClassify">
		<input type="hidden" name="id" value="${commodityClassify.id }"/>
		<table>
			<tr>
				<td>编码：</td>
				<td><form:input type="text" class="easyui-validatebox"
					path="classifyCode"
					data-options="required:true,missingMessage:'必填字段'" /> &nbsp;<font
					color="red">*</font>&nbsp;</td>
			</tr>
			<tr>
				<td>名称：</td>
				<td><form:input type="text" class="easyui-validatebox"
					path="classifyName"
					data-options="required:true,missingMessage:'必填字段'" /> &nbsp;<font
					color="red">*</font>&nbsp;</td>
			</tr>
		</table>
	</form:form>
	<div id="dlg-buttons" style="text-align: center;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveFormData('newCommodityClassify',false,'/meibo/storeroom/commodity/commodityClassify/saveClassify.html',false)">保存</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#win_newCommodityClassify').window('close')">取消</a>
	</div>
</div>