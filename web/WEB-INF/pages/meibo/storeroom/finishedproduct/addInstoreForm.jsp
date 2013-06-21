<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../common/tag.jsp"%>
<div class="ftitle">
	成品入库<span class="form_desc">填写入库成品数量</span>
</div>
<div style="padding: 10px 0 10px 60px;">
	<form id="fm_newFinishedProductInstore">
		<input type="hidden" name="productId" value="${productId }" />
		<input type="hidden" name="workId" value="${workId }" />
		<input type="hidden" name="coopId" value="${coopId }" />
		<table border="0" width="90%">
			<tr>
				<td width="15%" align="right">数量：</td>
				<td width="35%"><input type="text" name="count" class="easyui-numberspinner" data-options="min:1,required:true,missingMessage:'必填字段'" style="width: 155px;" />&nbsp;<span style="color: red;">*</span></td>
			</tr>
		</table>
	</form>
	<div id="dlg-buttons" style="text-align: center; margin-top: 10px;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveFormData('newFinishedProductInstore',false,'/meibo/storeroom/finishedproduct/saveInstoreRoom.html',savesuccess)">保存</a> <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="javascript:$('#win_newSure').window('close')">取消</a>
	</div>
</div>
<script type="text/javascript">
	function savesuccess(data){
		var result = eval('(' + data + ')');
		if(result){
			$.messager.alert('提示信息', '保存成功!');
			$('#tt_worksheet').datagrid('reload');
			$('#tt_cooperationOrder').datagrid('reload');
			$('#win_newFinishedProduct11').window('close');
			$('#win_newFinishedProduct22').window('close');
			$('#win_newSure').window('close');
		}else {
			$.messager.alert('提示信息', '数量不能大于剩余入库数量!');
		}
	}
</script>
