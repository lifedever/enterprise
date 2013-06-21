<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	//新建
	function newVoucher() {
		$('#win_newVoucher').window({
			href : '/finace/voucher/addForm.html'
		}).window('open');
	}
	//编辑
	function editVoucher() {
		var row = $('#tt_newVoucher').datagrid('getSelected');
		if (row) {
			$('#win_newVoucher').window({
				href : '/finace/voucher/addForm.html?id=' + row.id
			}).window('open');
		} else {
			$.messager.alert('提示信息', '请选择操作对象！');
		}
	}
	//删除
	function delVoucher(){
		var row = $('#tt_newVoucher').datagrid('getSelected');
		if (row) {
			$.messager.confirm('警告', '你确定要删除选择吗?里面的条目会一并删除！', function(r) {
				if (r) {
					$.post('/finace/voucher/deleteVoucher.html',{
						id:row.id						
					},function(data){
						$.messager.alert('提示信息', '操作成功！');
						$('#tt_newVoucher').datagrid('reload');
					});
				}
			});
		}else {
			$.messager.alert('提示信息', '请选择操作对象！');
		}
	}
	//添加条目
	function newVoucherItem(){
		$('#win_voucherItem').window({
			href : '/finace/voucher/addItemForm.html'
		}).window('open');
	}
	//编辑条目
	function editVoucherItem(){
		var row = $('#tt_voucherItem').datagrid('getSelected');
		if(row){
			$('#win_voucherItem').window({
				href : '/finace/voucher/addItemForm.html?id='+row.id
			}).window('open');
		} else {
			$.messager.alert('提示信息', '请选择操作对象！');
		}
	}
	//删除条目
	function delVoucherItem(){
		var row = $('#tt_voucherItem').datagrid('getSelected');
		if(row){
			$.messager.confirm('警告', '你确定要删除选择吗?', function(r) {
				if (r) {
					$.post('/finace/voucher/delVoucherItem.html',{
						voucherItemId:row.id
					},function(data){
						$('#tt_voucherItem').datagrid('reload');
					});
				}
			});
		} else {
			$.messager.alert('提示信息', '请选择操作对象！');
		}
	}
	//科目汇总
	function summaryVoucher(){
		$('#dlg').window('open').window('setTitle', '新增用户');
	}
</script>