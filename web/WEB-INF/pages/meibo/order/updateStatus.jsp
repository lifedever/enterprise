<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../common/tag.jsp"%>
<div class="ftitle">
	请购单信息<span class="form_desc">填写请购单基本信息</span>
</div>
<div style="padding: 10px 10px 10px 10px;">
	<form id="fm_operaOrder">
		<input type="hidden" value="${order.id }" name="id" />
		<table border="0" width="90%">
			<tr>
				<td align="right" width="15%">订单号：</td>
				<td width="30%"><input type="text" value="${order.orderNo }" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td align="right" width="15%">
					订单状态：					
				</td>
				<td width="30%">
					<input type="text" id="orderStatus" name="orderStatus" value="${order.orderStatus }"/>
				</td>
			</tr>
		</table>
	</form>
	<div id="dlg-buttons" style="text-align: center; margin-top: 10px;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="saveFormData('operaOrder',false,'/meibo/order/update.html',saveSuccess)">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="javascript:$('#win_askOffer').window('close')">取消</a>
	</div>
</div>
<script type="text/javascript">
	function saveSuccess(data){
		if (data) {
			$.messager.alert('提示信息', '操作成功！');
			$('#win_updateStatus').window('close'); // close the dialog
			$('#tt_operaOrder').datagrid('reload'); // reload the user data
		} else {
			$.messager.alert('提示信息', '操作失败！');
		}
	}
</script>