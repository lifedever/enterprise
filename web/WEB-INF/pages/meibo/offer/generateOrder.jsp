<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../../common/tag.jsp"%>
<div class="ftitle">
	生成订单<span class="form_desc">根据报价信息生成订单</span>
</div>
<div style="padding: 10px 0 10px 60px;">
	<form id="fm_generateOrder">
		<input type="hidden" value="${customerId }" name="customerId" />
		<input type="hidden" value="${offer.isProof }" name="isProof"/>
		<table width="80%">
			<tr>
				<td>开始时间：<input name="startDate" readonly="readonly" class="easyui-datebox"
					data-options="required:true,missingMessage:'必填字段'">&nbsp;<font color="red">*</font></td>
				<td>结束时间：<input name="endDate" readonly="readonly" class="easyui-datebox"
					data-options="required:true,missingMessage:'必填字段'">&nbsp;<font color="red">*</font></td>
			</tr>
		</table>
	</form>
</div>
<strong>订单信息列表：</strong>
<table id="tt_editOfferItem" class="easyui-datagrid" style="width: 800px; height: 220px;"
	data-options="idField:'id',toolbar:'#tb_generateOrder',
		collapsible:true,rownumbers:true,url:'/meibo/order/orderItem/listTempContent.html',
		pagination:true,singleSelect : true,cache:false">
	<thead>
		<tr>
			<th data-options="field : 'ck',checkbox : true"></th>
			<th data-options="field:'productName',width:100,editing:true,editor:'text'">名称</th>
			<th data-options="field:'price',width:60,formatter : formatMoney">已报价格</th>
			<th data-options="field:'productCount',width:60">数量</th>
			<th data-options="field:'contourSize',width:80">外形尺寸</th>
			<th data-options="field:'qualityRequire',width:100">质量要求</th>
			<th data-options="field:'printColor',width:100">印刷几色</th>
			<th data-options="field:'printRequire',width:100">印刷要求</th>
			<th data-options="field:'projectImage',width:60,formatter:formatImage">工程图</th>
			<th data-options="field:'effectImage',width:60,formatter:formatImage">效果图</th>
		</tr>
	</thead>
</table>
<div id="tb_generateOrder">
	<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newOrderItem('${offer.id}');">来自询价单</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editOrderItem();">修改</a> <a
		href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="removeOrderItem();">移除</a>
</div>
<div id="dlg-buttons" style="text-align: center; margin-top: 10px;">
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok"
		onclick="saveFormData('generateOrder',false,'/meibo/order/saveOrder.html',generateOrderSuccess)">保存</a> <a
		href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
		onclick="javascript:$('#win_generateOrder').window('close')">取消</a>
</div>