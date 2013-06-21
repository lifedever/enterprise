<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../common/tag.jsp"%>
<div class="ftitle">
	成品出库<span class="form_desc">填写详细的成品出库信息</span>
</div>
<div style="padding: 10px 0 10px 60px;">
		<form:form id="fm_newProductOutStore" method="post" class="fm" commandName="productInOutstore">
			<input type="hidden" name="finishedProductId" value="${finishedproductId }" />
			<input type="hidden" id="finishedProductCount" name="finishedProductCount" value="${finishedproductCount }" />
			<table>
				<tr>
					<td>成品名称：</td>
					<td><input type="text" readonly="readonly" name="finishedProductName" value="${finishedproductName }"/></td>
				</tr>
				<tr>
					<td>订单号：</td>
					<td><form:input type="text"path="orderNo" /></td>
				</tr>
				<tr>
					<td>出库数量：</td>
					<td><form:input id="count" path="count" class="easyui-numberspinner" data-options="min:1,required:true,missingMessage:'必填字段'"/> &nbsp;<font color="red">*</font>&nbsp;</td>
				</tr>
				<tr>
					<td>领取人：</td>
					<td><form:input path="pickinger"  /></td>
				</tr>
			</table>
		</form:form>
	<div id="dlg-buttons" style="text-align: center;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveFormData('newProductOutStore',beforeSubmit,'/meibo/storeroom/finishedproduct/saveStore.html',savaoutSuccess)">保存</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#win_newProductOutStore').window('close')">取消</a>
	</div>
</div>
<script type="text/javascript">
	function beforeSubmit(){
		var finishedProductCount = $('#finishedProductCount').val();
		var count = $('#count').val();
		if(Number(finishedProductCount) < Number(count)){
			$.messager.alert('提示信息', '出库数量不能大于库存数!');
			return false;
		}
		return $(this).form('validate');
	}

	function savaoutSuccess(data){
		if(data == 'true'){
			$.messager.alert('提示信息', '操作成功!');
			$('#win_newProductOutStore').window('close'); // close the dialog
			$('#tt_newFinishedProduct').datagrid('reload'); // reload the user data
		}else {
			$.messager.alert('提示信息', '操作失败,请查看订单号是否正确!');
		}
	}
</script>