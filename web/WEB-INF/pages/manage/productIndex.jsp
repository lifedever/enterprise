<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/tag.jsp"%>
<table id="tt_buy" class="easyui-datagrid" title="" style="width: document.body.clientWidth*0.9; height: 320px" data-options="toolbar:'#tb_expend',collapsible:true,rownumbers:true,url:'/product/listContent.html?f_orderId=${orderId }',pagination:true,singleSelect : true">
	<thead>
		<tr>
			<th data-options="field : 'ck',checkbox : true"></th>
			<th data-options="field:'productNo',width:120">产品编号</th>
			<th data-options="field:'productName',width:100">产品名称</th>
			<th data-options="field:'productCount',width:60">产品数量</th>
			<th data-options="field:'managerAudit',width:60,formatter:managerAuditFormatter">审批状态</th>
			<th data-options="field:'offerState',width:100,formatter:offerFormatter">是否报价</th>
			<th data-options="field:'offerCount',width:60">报价次数</th>
			<th data-options="field:'materialRequired',width:160">质量要求</th>
			<th data-options="field:'imgPath',width:100,formatter:gongcheng">工程图</th>
			<th data-options="field:'photoPath',width:100,formatter:chanpin">产品图</th>
		</tr>
	</thead>
</table>
<div id="tb_expend">
	<a href="#" class="easyui-linkbutton" iconCls="icon-system" plain="true" onclick="audit()">报价审批</a>
</div>
<div id="offerWin" class="easyui-window" title="报价列表" data-options="closed:true,modal:true,iconCls:'icon-save',cache:false" style="width: 650px; height: 400px; padding: 10px;"></div>
<script type="text/javascript">
	function managerAuditFormatter(value){
		if (value == 1) {
			return "<font color='green'>已审批</font>";
		} else {
			return "<font color='red'>未审批</font>";
		}
	}
	function gongcheng(value,row){
		return "<a class='preview' title='"+row.productName+"' href='"+value+"' target='_blank'>查看工程图</a>"
	}
	function chanpin(value,row){
		return "<a class='preview' title='"+row.productName+"' href='"+value+"' target='_blank'>查看产品图</a>"
	}
	function offerFormatter(value,row){
		if (value == 1) {
			return "<font color='red'>要求报价</font>";
		} else {
			return "<font color='green'>不要求报价</font>";
		}
	}
	function audit(){
		var row = $('#tt_buy').datagrid('getSelected');
		if(row){
			$('#offerWin').window({
				href : '/manage/offerForm.html?productId=' + row.id
			}).window('open');
		}else{
			$.mesager.alert('提示','请选择产品进行报价！');
		}
	}
</script>
