<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../common/tag.jsp"%>
<div class="ftitle">
	成品入库<span class="form_desc">填写详细的成品入库信息</span>
</div>
<div style="padding: 10px 0 10px 60px;">
		<form:form id="fm_newProductInStore" method="post" class="fm" commandName="productInOutstore">
			<input type="hidden" name="finishedProductId" value="${finishedproductId }" />
			<table>
				<tr>
					<td>名称：</td>
					<td><input type="text" readonly="readonly" name="finishedProductName" value="${finishedproductName }"/></td>
				</tr>
				<tr>
					<td>入库数量：</td>
					<td><form:input path="count" class="easyui-numberspinner" data-options="min:1,required:true,missingMessage:'必填字段'" /> &nbsp;<font color="red">*</font>&nbsp;</td>
				</tr>
				<tr>
					<td>送货人：</td>
					<td><form:input path="pickinger" />
				</tr>
			</table>
		</form:form>
	<div id="dlg-buttons" style="text-align: center;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveFormData('newProductInStore',false,'/meibo/storeroom/finishedproduct/saveStore.html',saveinSuccess)">保存</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#win_newProductInStore').window('close')">取消</a>
	</div>
</div>
<script type="text/javascript">
	function saveinSuccess(data){
		if (data) {
			$.messager.alert('提示信息', '操作成功！');
			$('#win_newProductInStore').window('close'); // close the dialog
			$('#tt_newFinishedProduct').datagrid('reload'); // reload the user data
		} else {
			$.messager.alert('提示信息', '操作失败！');
		}
	}
</script>