<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../common/tag.jsp"%>
<div class="ftitle">
	车辆信息<span class="form_desc">填写详细的车辆信息</span>
</div>
<div style="padding: 10px 0 10px 60px;">
		<form:form id="fm_vehicle" method="post" class="fm" commandName="vehicle">
			<input type="hidden" name="id" value="${vehicle.id }" />
			<table>
				<tr>
					<td align="right">加工单号：</td>
					<td><form:input type="text" path="orderNo" value="${productNo }"/></td>
					
					<td align="right">件数：</td>
					<td><form:input type="text" class="easyui-numberbox" path="number" /></td>
				
				</tr>
				<tr>
					<td align="right">送货地址：</td>
					<td><form:input type="text" path="deliveryAddress" /> &nbsp;</td>
					<td align="right">车辆类型：</td>
					<td><form:input type="text" path="vehicleType" /></td>
				
				</tr>
				<tr>
					<td align="right">金额：</td>
					<td><form:input path="sum" class="easyui-numberbox" precision="2" /></td>
					<td align="right">司机：</td>
					<td><form:input type="text" class="easyui-validatebox" path="driver" data-options="required:true,missingMessage:'必填字段'" /> &nbsp;<font color="red">*</font>&nbsp;</td>
				
				</tr>
				<tr>
					<td align="right">业务员：</td>
					<td><form:input type="text" path="clerk" /> &nbsp;</td>
					
					<td align="right">日期时间：</td>
					<td><form:input type="text" path="date" class="easyui-datebox"/></td>
				</tr>
			</table>
		</form:form>
	<div id="dlg-buttons" style="text-align: center;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveFormData('vehicle',false,'/meibo/operationalPart/vehicle/saveForm.html',false)">保存</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#win_vehicle').window('close')">取消</a>
	</div>
</div>
<script type="text/javascript">
	function closedia(data){
		if(data){
			if($('#win_vehicle')){
				$('#win_vehicle').window('close');
			}
			if($('#win_addvehicle')){
				$('#win_addvehicle').window('close');
			}
		}
	}
</script>