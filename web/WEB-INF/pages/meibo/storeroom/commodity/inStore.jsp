<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../common/tag.jsp"%>
<div class="ftitle">
	材料信息<span class="form_desc">填写详细的材料信息</span>
</div>
<div style="padding: 10px 0 10px 60px;">
		<form:form id="fm_newInStore" method="post" class="fm" commandName="inOutstore">
			<input type="hidden" name="commodityId" value="${commodityId }" />
			<form:input path="operation" value="0" cssStyle="display:none"/>
			<table>
				<tr>
					<td>材料名称：</td>
					<td><input type="text" readonly="readonly" name="name" value="${commodityName }"/></td>
				</tr>
				<tr>
					<td>加工单号：</td>
					<td><form:input type="text"  path="productNo"  /> &nbsp;<font color="red">*</font>&nbsp;</td>
				</tr>
				<tr>
					<td>入库数量：</td>
					<td><form:input path="count" class="easyui-numberspinner" data-options="min:1,required:true,missingMessage:'必填字段'" style="width: 180px;" /> &nbsp;<font color="red">*</font>&nbsp;</td>
				</tr>
				<tr>
					<td>采购人：</td>
					<td><form:input path="pickinger" class="easyui-validatebox" data-options="required:true,missingMessage:'必填字段'" style="width: 180px;" /> &nbsp;<font color="red">*</font>&nbsp;</td>
				</tr>
			</table>
		</form:form>
	<div id="dlg-buttons" style="text-align: center;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveFormData('newInStore',false,'/meibo/storeroom/commodity/saveOutStore.html',saveinSuccess)">保存</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#win_inStore').window('close')">取消</a>
	</div>
</div>
<script type="text/javascript">
	function saveinSuccess(data){
		if (data == "true") {
			$.messager.alert('提示信息', '操作成功！');
			$('#win_newInStore').window('close'); // close the dialog
			$('#tt_newCommodity').datagrid('reload'); // reload the user data
		} else {
			$.messager.alert('提示信息', '操作失败,请查看加工单号是否正确!');
		}
	}
</script>