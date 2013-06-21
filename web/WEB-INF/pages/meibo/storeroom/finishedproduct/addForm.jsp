<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../common/tag.jsp"%>
<div class="ftitle">
	成品信息<span class="form_desc">填写成品基本信息</span>
</div>
<div style="padding: 10px 0 10px 60px;">
	<form:form id="fm_newFinishedProduct" commandName="finishedPorduct" enctype="multipart/form-data">
		<input type="hidden" name="id" value="${finishedPorduct.id }" />
		<table border="0" width="90%">
			<tr>
				<td width="15%" align="right">名称：</td>
				<td width="35%"><form:input type="text" id="productName" path="productName" class="easyui-validatebox" data-options="required:true,missingMessage:'必填字段'" />&nbsp;<font color="red">*</font>&nbsp;</td>
				<td align="right">类型：</td>
				<td><form:select path="isProof">
						<form:option value="0" label="成品" />
						<form:option value="1" label="样品" />
					</form:select></td>
				<%-- <td width="15%" align="right">数量：</td>
				<td width="35%"><form:input type="text" path="productCount" class="easyui-numberspinner" data-options="min:1,required:true,missingMessage:'必填字段'" style="width: 155px;" /></td> --%>
			</tr>
			<tr>
				<td align="right">外形尺寸：</td>
				<td><form:input type="text" id="contourSize" path="contourSize" class="easyui-validatebox" data-options="required:true,missingMessage:'必填字段'" />&nbsp;<font color="red">*</font>&nbsp;</td>
				<td align="right">质量要求：</td>
				<td><form:input type="text" path="qualityRequire" id="qualityRequire"/></td>
			</tr>
			<tr>
				<td align="right">印刷几色：</td>
				<td><form:input type="text" path="printColor" id="printColor" class="easyui-validatebox" data-options="required:true,missingMessage:'必填字段'" />&nbsp;<font color="red">*</font>&nbsp;</td>
				<td align="right">印刷要求：</td>
				<td><form:input type="text" id="printRequire" path="printRequire" /></td>
			</tr>
			<tr>
				<td align="right">生产厂家：</td>
				<td><form:input type="text" id="producer" path="producer" class="easyui-validatebox" data-options="required:true,missingMessage:'必填字段'" />&nbsp;<font color="red">*</font>&nbsp;</td>
				
			</tr>
			<tr>
				<td align="right">工程图：</td>
				<td><c:if test="${!empty finishedPorduct.id}">
						<img alt="工程图预览" src="${finishedPorduct.projectImage }" style="width: 150px; height: 150px;">
					</c:if> <input type="file" id="file_projectImage" name="file1" /></td>
				<td align="right">效果图：</td>
				<td><c:if test="${!empty finishedPorduct.id}">
						<img alt="效果图预览" src="${finishedPorduct.effectImage }" style="width: 150px; height: 150px;">
					</c:if> <input type="file" id="file_effectImage" name="file2" /></td>
			</tr>
		</table>
	</form:form>
	<div id="dlg-buttons" style="text-align: center; margin-top: 10px;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveFormData('newFinishedProduct',false,'/meibo/storeroom/finishedproduct/saveFinishedProduct.html',savesuccess)">保存</a> <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="javascript:$('#win_newFinishedProduct').window('close')">取消</a>
	</div>
</div>
<script type="text/javascript">
 	function savesuccess(data){
 		if(data){
 			$.messager.alert('提示信息', '操作成功！');
			$('#win_newFinishedProduct').window('close'); // close the dialog
 			$('#tt_newFinishedProductForInstore').datagrid('reload'); 
 		}
 	}
</script>
