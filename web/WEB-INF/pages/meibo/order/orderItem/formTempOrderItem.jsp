<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../common/tag.jsp"%>
<div class="ftitle">
	询价信息<span class="form_desc">填写询价基本信息</span>
</div>
<div style="padding: 10px 0 10px 60px;">
	<form:form id="fm_editOfferItem" commandName="orderItem" enctype="multipart/form-data">
		<form:input type="hidden" path="id" />
		<table border="0" width="90%">
			<tr>
				<td width="10%">产品姓名：</td>
				<td width="35%"><form:input type="text" path="productName" /></td>
				<td width="10%">产品数量：</td>
				<td width="35%"><form:input type="text" path="productCount" class="easyui-numberbox" precision="0" /></td>
			</tr>
			<tr>
				<td>外形尺寸：</td>
				<td><form:input type="text" path="contourSize" /></td>
				<td>质量要求：</td>
				<td><form:input type="text" path="qualityRequire" /></td>
			</tr>
			<tr>
				<td>印刷几色：</td>
				<td><form:input type="text" path="printColor" /></td>
				<td>印刷要求：</td>
				<td><form:input type="text" path="printRequire" /></td>
			</tr>
			<tr>
				<td>工程图：</td>
				<td><img src="${orderItem.projectImage }"
					style="max-width: 100px; max-height: 100px; cursor: pointer;" title="点击图片进行替换" id="img_projectImage"/>
					<input type="file" id="file_projectImage" name="file1" style="display: ;"/>	
				</td>
				<td>效果图：</td>
				<td><img src="${orderItem.effectImage }" 
					style="max-width: 100px; max-height: 100px; cursor: pointer;" title="点击图片进行替换" id="img_effectImage"/>
					<input type="file" id="file_effectImage" name="file2" style="display: ;"/>	
				</td>
			</tr>
		</table>
	</form:form>
	<div id="dlg-buttons" style="text-align: center; margin-top: 10px;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="saveFormData('editOfferItem',false,'/meibo/order/orderItem/editTempOrderItem.html',false)">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="javascript:$('#win_editOfferItem').window('close')">取消</a>
	</div>
</div>
<script type="text/javascript">
(function(){
	$('#img_projectImage').on('click',function(){
		return $('#file_projectImage').click();
	});
	$('#file_projectImage').on('change',function(){
		setImagePreview('img_projectImage','file_projectImage');
	});
	$('#img_effectImage').on('click',function(){
		return $('#file_effectImage').click();
	});
	$('#file_effectImage').on('change',function(){
		setImagePreview('img_effectImage','file_effectImage');
	});
})();
</script>