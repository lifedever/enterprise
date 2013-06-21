<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../../common/tag.jsp"%>
<div class="ftitle">
	添加额外支出<span class="form_desc"><font color="blue">【加工单号：${productNo }】</font></span>
</div>
<div style="padding: 10px 0 10px 60px;">
	<form id="fm_newProductioncost">
		<input type="hidden" name="productNo" value="${productNo }" />
		<table width="90%" border="0">
			<tr>
				<td>
					<strong>具体花费：</strong> 
					<input type="text" name="cost" value="0" class="easyui-numberbox" precision="2" />
				</td>
			</tr>
			<tr>
				<td>
					<strong>详情说明：</strong> 
					<input type="text" name="remark"/>
				</td>
			</tr>
		</table>
	</form>
</div>
<div id="dlg-buttons" style="text-align: center; margin-top: 20px;">
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok"
		onclick="saveFormData('newProductioncost',false,'/finace/productioncost/saveItemCost.html',false)">保存</a> 
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
		onclick="javascript:$('#win_newProductioncost').window('close')">取消</a>
</div>
