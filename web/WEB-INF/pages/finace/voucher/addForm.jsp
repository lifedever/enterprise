<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../common/tag.jsp"%>
<div>
	<form:form id="fm_newVoucher" method="post" class="fm" commandName="voucher">
		<form:input path="id" cssStyle="display:none" />
		<center>
			<h1>记账凭证</h1>
		</center>
		<table width="100%">
			<tr>
				<td>
					记字：<form:input path="jizi" />
				</td>
				<td>
					<form:input path="createDate" readonly="true" onclick="WdatePicker({startDate:'%y年%M月01日00时',dateFmt:'yyyy年MM月dd日',alwaysUseStartDate:true});"/>
				</td>
				<td>
					附单数据：<form:input path="fdshj" />
				</td>
			</tr>
		</table>
		<table id="tt_voucherItem" class="easyui-datagrid" title="" style="width: 620px; height: 240px;" 
			data-options="toolbar:'#tb_voucherItem',showFooter: true,idField:'id',
			singleSelect:true,url:'/finace/voucher/listVoucherItem.html'">
			<thead>
				<tr>
					<th data-options="field:'remark',width:120" rowspan="2">摘要</th>
					<th data-options="width:120" colspan="2">科目</th>
					<th data-options="field:'debtor',width:120,formatter:formatMoney" rowspan="2">借方</th>
					<th data-options="field:'credit',width:120,formatter:formatMoney" rowspan="2">贷方</th>
				</tr>
				<tr>
					<th data-options="field:'accountantType',width:120">总账科目</th>
					<th data-options="field:'accountantName',width:120">明细科目</th>
				</tr>
			</thead>
		</table>
		<table width="100%">
			<tr>
				<td>主管：<form:input path="master" cssStyle="width:60px;"/></td>
				<td>记账：<form:input path="voucher" cssStyle="width:60px;"/></td>
				<td>审核：<form:input path="auditer" cssStyle="width:60px;"/></td>
				<td>出纳：<form:input path="chahier" cssStyle="width:60px;"/></td>
				<td>制单：<form:input path="systems" cssStyle="width:60px;"/></td>
			</tr>
		</table>
	</form:form>
</div>
<div id="dlg-buttons" style="text-align: center;">
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveFormData('newVoucher',false,'/finace/voucher/saveVoucher.html',false)">保存</a> 
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#win_newVoucher').window('close')">取消</a>
</div>
<div id="tb_voucherItem">
	<a href="#" class="easyui-linkbutton" iconCls="icon-table-add" plain="true" onclick="newVoucherItem();">添加条目</a> 
	<a href="#" class="easyui-linkbutton" iconCls="icon-table-edit" plain="true" onclick="editVoucherItem();">编辑条目</a> 
	<a href="#" class="easyui-linkbutton" iconCls="icon-table-del" plain="true" onclick="delVoucherItem()">删除条目</a>
</div>