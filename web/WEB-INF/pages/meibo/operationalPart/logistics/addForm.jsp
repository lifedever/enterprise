<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../common/tag.jsp"%>
<div class="ftitle">
	物流信息<span class="form_desc">填写详细的物流信息</span>
</div>
<div style="padding: 10px 0 10px 60px;">
		<form:form id="fm_logistics" method="post" class="fm" commandName="logistics">
			<input type="hidden" name="id" value="${logistics.id }" />
			<table>
				<tr>
					<td align="right">加工单号：</td>
					<td><form:input type="text" path="orderNo" value="${productNo }"/></td>
					
					<td align="right">发货日期：</td>
					<td><form:input type="text" path="shipDate" class="easyui-datebox"/></td>
				</tr>
				<tr>
					<td align="right">收件人：</td>
					<td><form:input type="text" path="addressee" /> &nbsp;</td>
					<td align="right">发件人：</td>
					<td><form:input type="text" path="sender" /></td>
				
				</tr>
				<tr>
					<td align="right">金额：</td>
					<td><form:input path="sum" class="easyui-numberbox" precision="2" /></td>
					<td align="right">目的地：</td>
					<td><form:input type="text" class="easyui-validatebox" path="destination" data-options="required:true,missingMessage:'必填字段'" /> &nbsp;<font color="red">*</font>&nbsp;</td>
				
				</tr>
				<tr>
					<td align="right">重量：</td>
					<td><form:input type="text" path="weight" /></td>
					
					<td align="right">体积：</td>
					<td><form:input type="text" path="volume" /></td>
				</tr>
				<tr>
					<td align="right">物品：</td>
					<td><form:input type="text" path="goods" /> &nbsp;</td>
					
					<td align="right">备注：</td>
					<td><form:input type="text" path="remark" /></td>
				</tr>
			</table>
		</form:form>
	<div id="dlg-buttons" style="text-align: center;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveFormData('logistics',false,'/meibo/operationalPart/logistics/saveForm.html',closedia)">保存</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#win_logistics').window('close')">取消</a>
	</div>
</div>
<script type="text/javascript">
	function closedia(data){
		if(data){
			if($('#win_logistics')){
				$('#win_logistics').window('close');
			}
			if($('#win_addlogistics')){
				$('#win_addlogistics').window('close');
			}
		}
	}
</script>