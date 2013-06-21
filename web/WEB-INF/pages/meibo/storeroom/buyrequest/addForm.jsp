<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../common/tag.jsp"%>
<div class="ftitle">
	请购单信息<span class="form_desc">填写请购单基本信息</span>
</div>
<div style="padding: 10px 10px 10px 10px;">
	<form id="fm_buyRequest">
		<input type="hidden" value="${customer.id }" name="customerId" />
		<table border="0" width="90%">
			<tr>
				<td align="right" width="15%">采购人：</td>
				<td width="30%"><input type="text" id="buyer" name="buyer" class="easyui-validatebox"
					data-options="required:true,missingMessage:'必填字段'" />&nbsp;<font
					color="red">*</font>&nbsp;</td>
				<td align="right" width="15%">
					采购日期：					
				</td>
				<td width="30%">
					<input type="text" name="buyDate" id="buyDate" readonly="readonly" class="easyui-datebox"/>
				</td>
			</tr>
		</table>
		<table id="tt_addBuyRequestItem" class="easyui-datagrid" style="width: 745px; height: 290px;"
			data-options="idField:'id',toolbar:'#tb_addBuyRequestItem',title:'请购条目',collapsible:true,rownumbers:true,url:'/meibo/storeroom/buyrequestitem/listTempContent.html',pagination:true,singleSelect : true,cache:false">
			<thead>
				<tr>
					<th data-options="field:'name',width:120">名称</th>
					<th data-options="field:'standard',width:110">标准</th>
					<th data-options="field:'count',width:60">数量</th>
					<th data-options="field:'unit',width:60">单位</th>
					<th data-options="field:'valuation',width:75">估价</th>
					<th data-options="field:'purpose',width:185">用途</th>
					<th data-options="field:'createDate',width:100,formatter:formatDate">添加时间</th>
				</tr>
			</thead>
		</table>
	</form>
	<div id="tb_addBuyRequestItem">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newBuyRequestItem();">点击添加请购条目</a>
		<!-- <a href="#" class="easyui-linkbutton" iconCls="icon-del" plain="true" onclick="delBuyRequestItem();">移除请购条目</a> -->
	</div>
	<div id="dlg-buttons" style="text-align: center; margin-top: 10px;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="saveFormData('buyRequest',false,'/meibo/storeroom/buyrequest/saveForm.html',false)">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="javascript:$('#win_askOffer').window('close')">取消</a>
	</div>
</div>