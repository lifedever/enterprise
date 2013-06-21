<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../common/tag.jsp"%>
<div class="ftitle">
	报价<span class="form_desc">是否同意报价</span>
</div>
<div style="padding: 10px 0 10px 60px;">
	<form id="fm_itemShow">
		<input type="hidden" value="${offerMoney.id }" name="id" />
		<table border="0" width="90%">
			<tr>
				<td width="20%">是否同意报价：</td>
				<td width="60%">
					<input type="radio" name="askState" value="1" checked="checked"/>
					<span style="color:green;">同意</span>
					<input type="radio" name="askState" value="-1"/>
					<span style="color:red;">不同意</span>
				</td>
			</tr>
			<tr>
				<td width="20%">单价：</td>
				<td width="60%">￥ <strong>${offerMoney.price }</strong></td>
			</tr>
			<tr>
				<td width="20%">总价：</td>
				<td width="60%">￥ <strong>${offerMoney.money }</strong></td>
			</tr>
			<tr>
				<td>备注：</td>
				<td><textarea name="askRemark" cols="28"></textarea></td>
			</tr>
		</table>
	</form>
	<div id="dlg-buttons" style="text-align: center; margin-top: 10px;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="saveFormData('itemShow',false,'/meibo/offer/offerMoney/saveAskAudit.html',saveAskAuditSuccess)">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="javascript:$('#win_itemShow').window('close')">取消</a>
	</div>
</div>
<script type="text/javascript">
	function saveAskAuditSuccess(data){
		if (data == "true") {
			$.messager.alert('提示信息', '操作成功！');
			$('#win_itemShow').window('close'); // close the dialog
			$('#tt_offer').datagrid('reload'); // reload the user data
			$('#tt_itemShow').datagrid('reload'); // reload the user data
		} else {
			$.messager.alert('提示信息', '操作失败,请查看加工单号是否正确!');
		}
	}
</script>