<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../../../common/tag.jsp"%>
<div class="ftitle">
	用料明细<span class="form_desc">添加具体的用料明细</span>
</div>
<div style="padding: 10px 0 10px 60px;">
	<form id="fm_material">
		<table width="80%" border="0" style="border-collapse: collapse;">
			<tr>
				<td width="40%">
				类别：<select id="empPosition" name="classify" class="easyui-combobox" 
						data-options="valueField:'classifyName',textField:'classifyName',cache:false,
							url:'/meibo/storeroom/commodity/commodityClassify/loadCombobox.html'">
					</select>
				</td>
				<td width="40%">名称：<input type="text" name="name"/></td>
			</tr>
			<tr>
				<td>规格：<input type="text" name="standard"/></td>
				<td>颜色：<input type="text" name="color"/></td>
			</tr>
			<tr>
				<td>厚度：<input type="text" name="thickness"/></td>
				<td>数量：<input name="count" class="easyui-numberbox" precision="1" value="1"/></td>
			</tr>
			<tr>
				<td>备注：<input type="text" name="remark"/></td>
			</tr>
		</table>
	</form>
</div>
<div id="dlg-buttons" style="text-align: center;margin-top: 20px;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveFormData('material',false,'/meibo/order/prepare/saveTempMaterial.html',false)">保存</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#win_material').window('close')">取消</a>
</div>
