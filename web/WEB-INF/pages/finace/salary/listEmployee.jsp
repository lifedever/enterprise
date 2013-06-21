<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="tt_employee" class="easyui-datagrid" title="" style="height: 330px"
		data-options="singleSelect : true,toolbar:'#tb_ab',
			collapsible:true,rownumbers:true,idField : 'id',
			url:'/finace/salary/listEmployeeContent.html',pagination:true">
	<thead>
		<tr>
			<th data-options="field : 'ck',checkbox : true"></th>
			<th data-options="field:'empNo',width:100">员工编号</th>
			<th data-options="field:'empName',width:100">员工姓名</th>
			<th data-options="field:'empContact',width:150">联系方式</th>
			<th data-options="field:'empDeptName',width:150">所属部门</th>
			<th data-options="field:'empPositionName',width:100">职位</th>
			<th data-options="field:'createDate',width:120,formatter:dataformatter">入职时间</th>
		</tr>
	</thead>
</table>
<div id="tb_ab">
	<a href="#" class="easyui-linkbutton" iconCls="icon-ok" plain="true" onclick="addEmployee()">确认选择</a>
</div>
<script type="text/javascript">
	function dataformatter(value){
		if (value) {
			return getDateFromJson(value);
		}
	}
	function addEmployee() {
		var row = $('#tt_employee').datagrid('getSelected');
		if (row) {
			$('#win_employee').window('close');
			$('#employeeId').val(row.id);
			$('#employeeName').val(row.empName);
			$('#employeeNo').val(row.empNo);
			$('#fm_salary').form('load', '/finace/salary/loadSalary.html?employeeId='+row.id);  
		} else {
			$.messager.alert('提示', '请选择员工！');
		}
	}
</script>
