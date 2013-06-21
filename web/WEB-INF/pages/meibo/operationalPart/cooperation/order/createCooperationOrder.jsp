<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/tag.jsp"%>
<div style="font-size: 13px;">
	<h2 align="center">外协产品加工单</h2>
	<form id="fm_generateCooperationOrder" enctype="multipart/form-data" method="post">
		<input type="hidden" style="border: 0px;" id="cooperationAddress" name="cooperationAddress"/>
		<table style="border-collapse: collapse; margin-left: 20px; border-width: 0px;" border="1" width="95%">
			<tr>
				<td width="10%"><strong>加工单位</strong></td>
				<td width="20%"><input type="text" style="border: 0px;" id="factoryName" name="cooperationFactory"/></td>
				<td width="10%"><strong>联&nbsp;&nbsp;系&nbsp;&nbsp;人</strong></td>
				<td width="25%"><input type="text" style="border: 0px;" id="contactMan" name="callMan"/></td>
				<td width="10%"><strong>联系电话</strong></td>
				<td width="25%"><input type="text" style="border: 0px;" id="mobile" name="phone"/></td>
			</tr>
			<tr>
				<td width="10%"><strong>产品名称</strong></td>
				<td width="20%"><input type="text" style="border: 0px;" value="${orderItem.productName }" name="productName"/></td>
				<td width="10%"><strong>数&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;量</strong></td>
				<td width="25%"><input type="text" id="productCount" style="border: 0px;" value="${orderItem.productCount }" name="productCount" class="easyui-numberbox" precision="0"></td>
				<td width="10%"><strong>加工单号</strong></td>
				<td width="25%"><input type="text" style="border: 0px;" value="${orderItem.productNo }" name="productNo"/></td>
			</tr>
			<tr>
				<td width="10%"><strong>派单人员</strong></td>
				<td width="20%"><input type="text" style="border: 0px;" name="sendMan"/></td>
				<td width="10%"><strong>下单时间</strong></td>
				<td width="25%"><input type="text" style="border: 0px;" readonly="readonly" name="setOrderDate" onclick="WdatePicker({startDate:'%y年%M月01日',dateFmt:'yyyy年MM月dd日',alwaysUseStartDate:true});"/></td>
				<td width="10%"><strong>交货时间</strong></td>
				<td width="25%"><input type="text" style="border: 0px;" readonly="readonly" name="returnProductDate" onclick="WdatePicker({startDate:'%y年%M月01日',dateFmt:'yyyy年MM月dd日',alwaysUseStartDate:true});"/></td>
			</tr>
			<tr>
				<td width="10%"><strong>联系时间</strong></td>
				<td width="20%"><input type="text" style="border: 0px;" readonly="readonly" name="linkDate" onclick="WdatePicker({startDate:'%y年%M月01日',dateFmt:'yyyy年MM月dd日',alwaysUseStartDate:true});"/></td>
				<td width="10%"><strong>单&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价</strong></td>
				<td width="25%"><input type="text" style="border: 0px;width: 50px;" id="price" name="price" class="easyui-numberbox" precision="2" value="${orderItem.price }" />元/个</td>
				<td width="10%"><strong>合计金额</strong></td>
				<td width="25%"><input type="text" style="border: 0px;width: 60px;" readonly="readonly" id="allCount"/>元</td>
			</tr>
			<tr>
				<td colspan="3"><strong>主要材质、技术要求、规格尺寸图示</strong></td>
				<td colspan="3" rowspan="2" align="center">
					<img alt="图示" id="img_image" src="${orderItem.projectImage }" width="220px" height="220px" style="cursor: pointer;">
					<input type="file" id="file_image" name="file" style="display: none;"/>
					<input type="hidden" name="image1" id="image1" value="${orderItem.projectImage }"/>
				</td>
			</tr>
			<tr>
				<td colspan="3"><textarea cols="44" rows="13" name="required"></textarea></td>
			</tr>
			<tr>
				<td colspan="6">
					<table width="100%">
						<tr>
							<td width="50%"><strong>名称：</strong><input type="text" name="factoryName" value="北京美博雅克丽工贸有限公司" style="border: 0px;width: 230px;"/></td>
							<td width="50%"><strong>电话：</strong><input type="text" name="factoryTel" value="010-61281003、81284720" style="border: 0px;width: 260px;"/></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<table width="100%">
						<tr>
							<td width="40%"><strong>地址：</strong><input type="text" name="factoryAddress" value="北京市大兴区西红门镇新建五连环开发区" style="border: 0px;width: 240px;"/></td>
							<td width="30%"><strong>网址：</strong><input type="text" name="factorySite" value="www.mbykl.com" style="border: 0px;width: 150px;"/></td>
							<td width="30%"><strong>邮箱：</strong><input type="text" name="factoryEmail" value="mbykl@126.com" style="border: 0px;width: 150px;"/></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
</div>
<div id="dlg-buttons" style="text-align: center; margin-top: 20px;">
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok"
		onclick="saveFormData('generateCooperationOrder',false,'/meibo/operationalPart/cooperation/order/saveCooperationOrder.html',saveSuccess)">保存</a>
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
		onclick="javascript:$('#win_generateCooperationOrder').window('close')">取消</a>
</div>
<script type="text/javascript">
	$('#allCount').on('click',function(){
		$(this).val($('#productCount').val()*$('#price').val());
	});
	$('#img_image').on('click',function(){
		return $('#file_image').click();
	});
	$('#file_image').on('change',function(){
		setImagePreview('img_image','file_image','220px');
		$('#file_image').show();
		$('#image1').val('1');
	});
	function saveSuccess(data) {
		if (data) {
			$.messager.alert('提示信息', '操作成功！');
			$('#win_generateCooperationOrder').window('close')
			$('#tt_listOrderItem').datagrid('reload');
		} else {
			$.messager.alert('提示信息', '操作失败！');
		}
	}
	$('#factoryName').on('click',function(){
		listFactorys();
	});
</script>