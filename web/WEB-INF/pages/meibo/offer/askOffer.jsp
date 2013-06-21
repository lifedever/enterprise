<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../common/tag.jsp"%>
<div class="ftitle">
	询价信息<span class="form_desc">填写询价基本信息</span>
</div>
<div style="padding: 10px 0 10px 60px;">
	<form id="fm_askOffer">
		<input type="hidden" value="${customer.id }" name="customerId" />
		<table border="0" width="90%">
			<tr>
				<td width="10%">客户姓名：</td>
				<td width="80%">${customer.customerName }</td>
			</tr>
			<tr>
				<td>
					询价对象：					
				</td>
				<td>
					<input type="radio" name="isProof" value="0" checked="checked"/><span style="color: red;">产品</span>
					<input type="radio" name="isProof" value="1" /><span style="color: green;">样品</span>
				</td>
			</tr>
			<tr>
				<td>备注信息：</td>
				<td><textarea name="remark" cols="58"></textarea></td>
			</tr>
		</table>
		<table id="tt_addOfferItem" class="easyui-datagrid" style="width: 620px; height: 250px;"
			data-options="idField:'id',toolbar:'#tb_addOfferItem',title:'询价条目',collapsible:true,rownumbers:true,url:'/meibo/offer/offerItem/listTempContent.html',pagination:true,singleSelect : true,cache:false">
			<thead>
				<tr>
					<th data-options="field:'id',width:100,formatter:formatMDetail">查看用料</th>
					<th data-options="field:'productName',width:100">名称</th>
					<th data-options="field:'productCount',width:50">数量</th>
					<th data-options="field:'qualityRequire',width:125">质量要求</th>
					<th data-options="field:'printRequire',width:125">印刷要求</th>
					<th data-options="field:'createDate',width:100,formatter:formatDate">添加时间</th>
				</tr>
			</thead>
		</table>
	</form>
	<div id="tb_addOfferItem">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newOfferItem();">点击添加询价条目</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="detailFormatter();">添加用料明细</a>
	</div>
	<div id="dlg-buttons" style="text-align: center; margin-top: 10px;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="saveFormData('askOffer',beforeAskOffer,'/meibo/offer/saveOffer.html',false)">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="javascript:$('#win_askOffer').window('close')">取消</a>
	</div>
</div>