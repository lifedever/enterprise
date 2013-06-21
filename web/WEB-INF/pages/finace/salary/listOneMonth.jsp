<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="tt_employee" class="easyui-datagrid" title="" style="height: 350px"
		data-options="singleSelect : true,
			collapsible:true,rownumbers:true,idField : 'id',
			url:'/finace/salary/showOneMonth.html?date=${date }',pagination:true,onClickRow:viewSalary2">
	<thead>
		<tr>
			<th data-options="field:'employeeNo',width:100">员工编号</th>
			<th data-options="field:'employeeName',width:100">员工姓名</th>
			<th data-options="field:'deptName',width:120">所在部门</th>
			<th data-options="field:'baseSalary',width:100,formatter:moneyFormatter">基本工资</th>
			<th data-options="field:'mustSalary',width:100,formatter:moneyFormatter">应发工资</th>
			<th data-options="field:'realSalary',width:100,formatter:moneyFormatter">实发工资</th>
			<th data-options="field:'createDate',width:120,formatter:dataformatter">发放时间</th>
		</tr>
	</thead>
</table>
<div style="margin-top: 4px;color: red;">点击行可以查看某个员工的工资发放情况</div>
<script type="text/javascript">
	function dataformatter(value){
		if (value) {
			return getDateFromJson(value);
		}
	}
	function moneyFormatter(value) {
		if (value == null)
			value = 0;
		return "￥ <strong>" + value + "</strong>" ;
	}
	function viewSalary2(){
		var row = $('#tt_employee').datagrid('getSelected');
		if (row) {
			$('#viewSalary').window({
				href : '/finace/salary/viewSalary.html?salaryId=' + row.id
			}).window('open');
		}
	}
</script>
