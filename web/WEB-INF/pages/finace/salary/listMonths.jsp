<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="ftitle">
	<span class="form_desc">
		<font color="red">点击每行数据可以查看月度工资详情</font>
	</span>
</div>
<table id="tt_account" class="easyui-datagrid" title="" style="height: 450px;" data-options="singleSelect : true,
			collapsible:true,rownumbers:true,pagination:true,
			url:'/finace/salary/showMonthSalarys.html',onClickRow:clickRow">
	<thead>
		<tr>
			<th data-options="field:'2',width:250">工资月份</th>
			<th data-options="field:'0',width:250,formatter:moneyFormatter">应发工资总额</th>
			<th data-options="field:'1',width:250,formatter:moneyFormatter">实发工资总额</th>
			<th data-options="field:'xx',width:250,formatter:chaMoney">差额</th>
		</tr>
	</thead>
</table>
<div class="easyui-window" id="win_oneMonth" data-options="closed:true,modal:true,cache:false" style="width: 830px; height: 420px; padding: 10px;"></div>
<script type="text/javascript">
	function moneyFormatter(value) {
		if (value == null)
			value = 0;
		return "￥ <strong>" + value + "</strong>";
	}
	function clickRow(rowIndex, row) {
		var date = row[2];
		$('#win_oneMonth').window({
			href : '/finace/salary/listOneMonth.html?date=' + date
		}).window('open').window('setTitle',
				date.substr(0, 4) + '年' + date.substr(4, 2) + '月' + '工资发放情况');
	}
	function chaMoney(value,row){
		var m = row[0]-row[1];
		return "￥ <strong>" + m + "</strong>";
	}
</script>
