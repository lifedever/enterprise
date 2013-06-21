<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../../../common/tag.jsp"%>
<div class="ftitle">
	装箱<span class="form_desc">装箱详情<font color="blue">【订单编号：${order.orderNo }】</font></span>
</div>
<div style="padding: 10px 0 10px 60px;">
	<form id="fm_auditOrder">
		<input type="hidden" name="id" value="${orderItem.id }" />
		<table width="80%" border="0">
			<tr>
				<td>名称：</td>
				<td><input type="text" readonly="readonly" value="${orderItem.productName }"></td>
			</tr>
			<tr>
				<td>数量：</td>
				<td><input type="text" id="productCount" name="productCount" readonly="readonly" value="${orderItem.productCount }"></td>
			</tr>
			<tr>
				<td>个/箱：</td>
				<td><input type="text" id="singlebox"  name="singlebox" value="${orderItem.singlebox }" class="easyui-numberbox" required="required"><span style="color: red;">*</span></td>
			</tr>
			<tr>
				<td>总箱数：</td>
				<td><input type="text" id="totalbox" name="totalbox" value="${orderItem.totalbox }" readonly="readonly" ></td>
			</tr>
		</table>
	</form>
</div>
<div id="dlg-buttons" style="text-align: center; margin-top: 20px;">
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok"
		onclick="saveFormData('auditOrder',false,'/meibo/order/orderItem/packing.html',saveSuccess)">保存</a> 
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
		onclick="javascript:$('#win_box').window('close')">取消</a>
</div>
<script type="text/javascript">

	$('#singlebox').blur(function(){
		var productCount = $('#productCount').val();
		var singlebox = $('#singlebox').val();
		if(productCount % singlebox == 0){
			$('#totalbox').val(productCount/singlebox);
		} else {
			$('#totalbox').val(parseInt(productCount/singlebox) + 1);
		}
	});
	
	function saveSuccess(data){
		if(data){
			$.messager.alert('提示信息','操作成功!');
			$("#win_box").window('close');
			$('#tt_operaOrder').datagrid('reload');
		}
	}
</script>
