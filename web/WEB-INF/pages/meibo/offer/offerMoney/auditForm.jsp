<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../common/tag.jsp"%>
<div class="ftitle">
	报价<span class="form_desc">对产品进行报价</span>
</div>
<div style="padding: 10px 0 10px 60px;">
	<form id="fm_itemAudit">
		<input type="hidden" value="${item.id }" name="itemId" />
		<table border="0" width="90%">
			<tr>
				<td width="20%" align="right">单价：</td>
				<td width="70%"><input type="text" name="price" id="price" class="easyui-numberbox" precision="2" value="0" onblur="setMoney();"/></td>
			</tr>
			<tr>
				<td width="20%" align="right">总价：</td>
				<td width="70%"><input type="text" name="money" id="money" precision="2" value="0" onblur="checkMoney()"/></td>
			</tr>
			<tr>
				<td  align="right">备注：</td>
				<td><textarea name="auditRemark" cols="28"></textarea></td>
			</tr>
		</table>
	</form>
	<div id="dlg-buttons" style="text-align: center; margin-top: 10px;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="saveFormData('itemAudit',false,'/meibo/offer/offerMoney/saveAudit.html',saveAuditSuccess)">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="javascript:$('#win_itemAudit').window('close')">取消</a>
	</div>
</div>
<script type="text/javascript">
	function setMoney(){
		var count = '${item.productCount}';
		var money = count*$('#price').val();
		$('#money').get(0).value=(money);
	}
	function checkMoney(){
		var reg=  /^(-[1-9]|[1-9]|(0[.])|(-(0[.])))[0-9]{0,}(([.]*\d{1,2})|[0-9]{0,})$/;
		if(!reg.test($('#money').val())){
			$.messager.alert('注意','必须是数字，并且小数点最多保留后两位');
		}
	}
	function saveAuditSuccess(data){
		if (data) {
			$.messager.alert('提示信息', '操作成功！');
			$('#win_itemAudit').window('close'); // close the dialog
			$('#tt_itemAudit').datagrid('reload'); // reload the user data
		} else {
			$.messager.alert('提示信息', '操作失败!');
		}
	}
</script>