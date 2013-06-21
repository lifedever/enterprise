<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../common/tag.jsp"%>
<div class="ftitle">
	材料信息<span class="form_desc">填写详细的材料信息</span>
</div>
<div style="padding: 10px 0 10px 60px;">
		<form:form id="fm_newCommodity" method="post" class="fm" commandName="commodity">
			<input type="hidden" name="id" value="${commodity.id }" />
			<table>
				<tr>
					<td align="right">分类：</td>
					<td><form:input class="easyui-combobox" path="commodityClassify.id" 
					data-options="url:'/meibo/storeroom/commodity/commodityClassify/loadCombobox.html',
							valueField:'id',
							textField:'classifyName',
							panelHeight:'auto',
							required:true,missingMessage:'必填字段'" />  
 					&nbsp;<font color="red">*</font>&nbsp;</td>
					
					<td align="right">名称：</td>
					<td><form:input type="text" class="easyui-validatebox" path="name" data-options="required:true,missingMessage:'必填字段'" /> &nbsp;<font color="red">*</font>&nbsp;</td>
				
				</tr>
				<tr>
					<td align="right">厚度：</td>
					<td><form:input type="text" path="thickness" /> &nbsp;</td>
					<td align="right">规格：</td>
					<td><form:input type="text" class="easyui-validatebox" path="standard" data-options="required:true,missingMessage:'必填字段'" /> &nbsp;<font color="red">*</font>&nbsp;</td>
				
				</tr>
				<tr>
					<td align="right">数量：</td>
					<td><form:input path="count" class="easyui-numberspinner" data-options="min:1,required:true,missingMessage:'必填字段'" style="width: 155px;" /> &nbsp;<font color="red">*</font>&nbsp;</td>
					<td align="right">单位：</td>
					<td><form:input type="text" class="easyui-validatebox" path="unit" data-options="required:true,missingMessage:'必填字段'" /> &nbsp;<font color="red">*</font>&nbsp;</td>
				
				</tr>
				<tr>
					<td align="right">颜色：</td>
					<td><form:input type="text" path="color" /> &nbsp;</td>
					
					<td align="right">采购人：</td>
					<td><form:input type="pickinger" path="pickinger" data-options="required:true,missingMessage:'必填字段'" class="easyui-validatebox"/>&nbsp;<font color="red">*</font>&nbsp;</td>
				</tr>
				<tr>
					<td align="right">选择供应商：</td>
					<td>
					<form:input class="easyui-combobox" path="provider.id" id="providerId"
					data-options="url:'/meibo/storeroom/commodity/provider/loadCombobox.html',
							valueField:'id',
							textField:'companyName',
							panelHeight:'auto',
							required:true,missingMessage:'必填字段'" />  
 					&nbsp;<font color="red">*</font>&nbsp;
					<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newProvider();">新增</a></td>
					<td align="right">商品图片：</td>
					<td><input type="file" name="file" /></td>
				
				</tr>
			</table>
		</form:form>
	<div id="dlg-buttons" style="text-align: center;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveFormData('newCommodity',false,'/meibo/storeroom/commodity/saveCommodity.html',false)">保存</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#win_newCommodity').window('close')">取消</a>
	</div>
</div>