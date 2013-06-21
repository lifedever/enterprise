<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/tag.jsp"%>
<div class="ftitle">
	材料信息<span class="form_desc">填写详细的供货商信息</span>
</div>
<div style="padding: 10px 0 10px 60px;">
		<form:form id="fm_newProvider" method="post" class="fm" commandName="provider">
		<input type="hidden" name="id" value="${provider.id }"/>
			<table>
				<tr>
					<td>公司名称：</td>
					<td><form:input type="text" class="easyui-validatebox"
						path="companyName"
						data-options="required:true,missingMessage:'必填字段'" /> &nbsp;<font
						color="red">*</font>&nbsp;</td>
				</tr>
				<tr>
					<td>公司地址：</td>
					<td><form:input type="text" path="companyAddress"
						class="easyui-validatebox"
						data-options="required:true,missingMessage:'必填字段'" /> &nbsp;<font
						color="red">*</font>&nbsp;</td>
				</tr>
				<tr>
					<td>联系人：</td>
					<td><form:input type="text" path="linkman"
						class="easyui-validatebox"
						data-options="required:true,missingMessage:'必填字段'" /> &nbsp;<font
						color="red">*</font>&nbsp;</td>
				</tr>
				<tr>
					<td>联系方式：</td>
					<td><form:input type="text" path="contact"
						class="easyui-validatebox"
						data-options="required:true,missingMessage:'必填字段'" /> &nbsp;<font
						color="red">*</font>&nbsp;</td>
				</tr>
				<tr>
					<td>网站：</td>
					<td><form:input type="text" path="site" /></td>
				</tr>
				<tr>
					<td>邮箱：</td>
					<td><form:input type="text" path="email" /></td>
				</tr>
			</table>
		</form:form>
	<div id="dlg-buttons" style="text-align: center;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveFormData('newProvider',false,'/meibo/storeroom/commodity/provider/saveProvider.html',saveproviderSuccess)">保存</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#win_newProvider').window('close')">取消</a>
	</div>
</div>
<script type="text/javascript">
	function saveproviderSuccess(data){
		if(data){
			$.messager.alert('提示信息', '操作成功!');
			$('#win_newProvider').window('close'); // close the dialog
			if($('#providerId')){
				
			}else {
				
			}
			$('#tt_newProvider').datagrid('reload'); // reload the user data
		}else {
			$.messager,alert('提示信息', '操作失败!');
		}
	}
</script>