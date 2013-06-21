<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	function searchOffer(value) {
		var query = {};
		query['s_customer.customerName'] = value;
		$("#tt_offer").datagrid('options').queryParams = query;
		$('#tt_offer').datagrid('reload');
	}
	//报价审批页面
	function offerMoneyAudit() {
		var row = $('#tt_offer').datagrid('getSelected');
		if (row) {
			$('#win_offerMoneyAudit').window({
				href : '/meibo/offer/audit/managerAuditOffer.html?offerId=' + row.id
			}).window('open');
		} else {
			$.messager.alert('提示信息', '请选择操作对象！');
		}
	}
	function isProofFormatter(value){
		if (value == '0') {
			return '<span style="color:red">产品</span>';
		}
		if (value == '1') {
			return '<span style="color:green">样品</span>';
		}
	}
	//进行审批
	function itemAudit() {
		var row = $('#tt_managerAuditOffer').datagrid('getSelected');
		if (row) {
			$('#win_managerAuditOffer').window({
				href : '/meibo/offer/offerMoney/offerItemAudit.html?itemId='+ row.id
			}).window('open');
		} else {
			$.messager.alert('提示信息', '请选择操作对象！');
		}
	}
	//报价页面
	function auditForm() {
		var row = $('#tt_managerAuditOffer').datagrid('getSelected');
		var row2 = $('#tt_offer').datagrid('getSelected');
		var row3 = $('#tt_itemAudit').datagrid('getRows')[0];
		if (row) {
			if(row2.offerState=='1'||(row3&&row3.askState == '1')){
				$.messager.alert('提示信息', '已同意报价！');
			}else{
				$('#win_itemAudit').window({
					href : '/meibo/offer/offerMoney/auditForm.html?itemId=' + row.id
				}).window('open');
			}
		} else {
			$.messager.alert('提示信息', '请选择操作对象！');
		}
	}
	function offerStateFormatter(value){
		if(value=='0'){
			return '<span style="color:red">需要报价</span>';
		}
		if(value=='1'){
			return '<span style="color:green">已同意报价</span>';
		}
	}
	function detailFormatter(index, row) {
		return '<div style="padding:2px"><table id="ddv-' + index + '"></table></div>';
	}
	//格式化是否同意报价
	function askStateFormatter(index,row){
		if(row.askState=='1'){
			return '<font color="green">同意</font>';
		}else{
			return '<font color="red">未同意</font>';
		}
	}
	
	function formatDetail(value){
		return '<span style="color:green">'+'<a href="#" onclick="viewMaterialDetail(\''+value+'\')">查看明细</a>'+'</span>';
	}
	function viewMaterialDetail(value){
		$('#win_viewMaterialDetail').window({
			href : '/meibo/offer/materialdetail/index.html?itemId=' + value
		}).window('open');
	}
	function formatMType(value){
		if (value == '0') {
			return '<span style="color:red">材料</span>';
		}
		if (value == '1') {
			return '<span style="color:green">辅料</span>';
		}
	}
	
	function onExpandRow(index, row) {
		$('#ddv-' + index).datagrid(
				{
					url : '/meibo/offer/offerItem/listContent.html?f_offer.id='
							+ row.id,
					fitColumns : true,
					singleSelect : true,
					rownumbers : true,
					height : 'auto',
					columns : [ [ {
						field : 'productName',
						title : '名称',
						width : 100
					}, {
						field : 'productCount',
						title : '数量',
						width : 100
					}, {
						field : 'contourSize',
						title : '外形尺寸',
						width : 100
					}, {
						field : 'qualityRequire',
						title : '质量要求',
						width : 150
					}, {
						field : 'printColor',
						title : '印刷几色',
						width : 100
					}, {
						field : 'printRequire',
						title : '印刷要求',
						width : 150
					}, {
						field : 'projectImage',
						title : '工程图',
						width : 80,
						formatter : formatImage
					}, {
						field : 'effectImage',
						title : '效果图',
						width : 80,
						formatter : formatImage
					} , {
						field : 'id',
						title : '用料明细',
						width : 80,
						formatter : formatDetail
					}] ],
					onResize : function() {
						$('#tt_offer').datagrid('fixDetailRowHeight', index);
					},
					onLoadSuccess : function() {
						setTimeout(function() {
							$('#tt_offer')
									.datagrid('fixDetailRowHeight', index);
						}, 0);
					}
				});
	}
</script>
