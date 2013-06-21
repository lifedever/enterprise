<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../../../common/tag.jsp"%>
<div class="ftitle">
	下备料单<span class="form_desc">对产品或样品下备料单</span>
</div>
<div style="padding: 10px 0 10px 60px;">
	<form id="fm_materialOfferItem">
		<input type="hidden" name="auditUser" value="${sessionScope.user.realName }"/>
		<input type="hidden" name="orderItemId" value="${orderItem.id }"/>
		<table width="80%" border="0" style="border-collapse: collapse;">
			<tr>
				<td width="40%" colspan="2"><strong>加工单号：</strong>${orderItem.productNo }</td>
				<td width="20%"><strong>
					<c:choose>
						<c:when test="${orderItem.order.isProof eq 1 }">样品</c:when>
						<c:otherwise>产品</c:otherwise>
					</c:choose>名称：</strong>${orderItem.productName }</td>
				<td width="20%"><strong>客户名称：</strong>${orderItem.order.customer.customerName }</td>
			</tr>
			<tr>
				<td><strong>
					<c:choose>
						<c:when test="${orderItem.order.isProof eq 1 }">样品</c:when>
						<c:otherwise>产品</c:otherwise>
					</c:choose>数量：</strong>${orderItem.productCount }</td>
				<td colspan="3"><strong>所需日期：</strong><fmt:formatDate value="${orderItem.order.startDate}" pattern="yyyy年MM月dd日" /> ~
					<fmt:formatDate value="${orderItem.order.endDate}" pattern="yyyy年MM月dd日" />
				</td>
			</tr>
			<tr>
				<td colspan="4"><strong>单个产品用料情况：</strong></td>
			</tr>
			<td colspan="4"><textarea name="useCondition" style="width: 560px;"></textarea></td>
			<tr>
				<td colspan="4"><strong>备注：</strong></td>
			</tr>
			<td colspan="4"><textarea name="remark" style="width: 560px;"></textarea></td>
		</table>
	</form>
	<table id="tt_material" class="easyui-datagrid" style="width: 566px; height: 200px;" title="用料明细"
	data-options="idField:'id',toolbar:'#tb_material',
		collapsible:true,rownumbers:true,url:'/meibo/order/prepare/listTempMaterials.html',
		singleSelect : true,cache:false">
		<thead>
			<tr>
				<th data-options="field : 'ck',checkbox : true"></th>
				<th data-options="field:'classify',width:60">类别</th>
				<th data-options="field:'name',width:100,editing:true,editor:'text'">名称</th>
				<th data-options="field:'standard',width:60">规格</th>
				<th data-options="field:'count',width:60">数量</th>
				<th data-options="field:'color',width:60">颜色</th>
				<th data-options="field:'thickness',width:60">厚度</th>
				<th data-options="field:'remark',width:130">备注</th>
			</tr>
		</thead>
	</table>
</div>
<div id="tb_material">
	<a href="#" class="easyui-linkbutton" iconCls="icon-order" plain="true" onclick="addMaterial();">添加明细</a>
</div>
<div id="dlg-buttons" style="text-align: center;margin-top:3px;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveFormData('materialOfferItem',false,'/meibo/order/prepare/savePrepareOrder.html',false)">保存</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#win_materialOfferItem').window('close')">取消</a>
</div>
