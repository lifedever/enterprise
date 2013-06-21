<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../common/tag.jsp"%>
<div class="ftitle">
	修改请购单<span class="form_desc">修改请购单基本信息</span>
</div>
<div style="padding: 10px 0 10px 60px;">
	<form:form id="fm_editbuyRequest" method="post" class="fm" commandName="buyRequest">
		<input type="hidden" value="${buyRequest.id }" id="id" name="id" />
		<table border="0" width="90%">
			<tr>
				<td align="right" width="18%">采购人：</td>
				<td width="32%"><form:input class="easyui-validatebox" type="text" id="buyer" path="buyer"data-options="required:true,missingMessage:'必填字段'" /> &nbsp;<font color="red">*</font>&nbsp;</td>
			</tr>
			<tr>
				<td align="right" width="18%">
					采购日期：					
				</td>
				<td width="32%">
					<form:input type="text" readonly="readonly" class="easyui-datebox" path="buyDate" id="buyDate" data-options="required:true,missingMessage:'必填字段'" /> &nbsp;<font color="red">*</font>&nbsp;
				</td>
			</tr>
		</table>
	</form:form>
	<div id="dlg-buttons" style="text-align: center; margin-top: 10px;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="saveFormData('editbuyRequest',false,'/meibo/storeroom/buyrequest/saveForm.html',savesuccess)">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="javascript:$('#win_editbuyRequest').window('close')">取消</a>
	</div>
</div>
<script type="text/javascript">
	function savesuccess(data){
		if (data) {
			$.messager.alert('提示信息', '操作成功！');
			$('#win_editbuyRequest').window('close'); // close the dialog
			$('#tt_buyRequest').datagrid('reload'); // reload the user data
		} else {
			$.messager.alert('提示信息', '操作失败！');
		}
	}
</script>