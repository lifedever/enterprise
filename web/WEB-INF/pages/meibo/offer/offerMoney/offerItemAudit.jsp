<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../common/tag.jsp"%>
<div class="ftitle">
	报价信息<span class="form_desc">对产品或样品进行详细报价</span>
</div>
<div style="padding: 10px 0 10px 60px;">
		<table width="90%">
			<tr>
				<td width="12%">名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：</td>
				<td width="38%">${item.productName }</td>
				<td width="12%">外形尺寸：</td>
				<td width="38%">${item.contourSize }</td>
			</tr>
			<tr>
				<td>数&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;量：</td>
				<td>${item.productCount}</td>
				<td>质量要求：</td>
				<td>${item.qualityRequire}</td>
			</tr>
			<tr>
				<td>印刷几色：</td>
				<td>${item.printColor}</td>
				<td>印刷要求：</td>
				<td>${item.printRequire}</td>
			</tr>
			<tr>
				<td>工&nbsp;&nbsp;程&nbsp;图：</td>
				<td><a href='${item.projectImage }' target="_blank">查看</a></td>
				<td>效&nbsp;&nbsp;果&nbsp;图：</td>
				<td><a href='${item.effectImage }' target="_blank">查看</a></td>
			</tr>
			<tr>
				<td>用料明细：</td>
				<td><a href='#' onclick="viewMaterialDetail(${item.id})">查看用料明细</a></td>
			</tr>
		</table>
</div>
<table id="tt_itemAudit" class="easyui-datagrid" style="width: 750px; height: 250px;"
	data-options="idField:'id',toolbar:'#tb_itemAudit',title:'已报价格  [<font color=red>最近一次报价有效（已高亮显示）</font>]',fitColumns : true,collapsible:true,rownumbers:true,url:'/meibo/offer/offerMoney/listContent.html?f_offerItem.id=${item.id }',pagination:true,singleSelect : true,cache:false,rowStyler:firstRowStyler">
	<thead>
		<tr>
			<th data-options="field:'price',width:100,formatter:formatMoney">单价</th>
			<th data-options="field:'money',width:100,formatter:formatMoney">总价</th>
			<th data-options="field:'askRemark',width:145">询价备注</th>
			<th data-options="field:'auditRemark',width:145">审批备注</th>
			<th data-options="field:'askState',width:75,formatter:askStateFormatter">是否同意</th>
			<th data-options="field:'createDate',width:100,formatter:formatDate">操作日期</th>
		</tr>
	</thead>
</table>
<div id="tb_itemAudit">
	<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="auditForm();">报价</a>
</div>
