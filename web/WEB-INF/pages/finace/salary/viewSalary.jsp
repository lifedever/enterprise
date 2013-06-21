<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<input type="button" value="打印" id="print" />
<div id="viewprodlg">
	<div class="ftitle">
		<span class="form_desc">
			<div class="fitem">发放时间：${salary.createDate}</div>
		</span>
	</div>
	<table border="1" width="99%" cellpadding="0" cellspacing="0" frame="border" id="employeeSalary">
		<tr>
			<td>员工姓名： ${salary.employee.empName}</td>
			<td>员工编号：${salary.employee.empNo}</td>
		</tr>
		<tr>
			<td>基本工资：${salary.baseSalary }元</td>
			<td>职务津贴：${salary.allowance}元</td>
		</tr>
		<tr>
			<td>工种补助：${salary.jobSubsidy}元</td>
			<td>加班补助：${salary.overtimeSubsidy}元</td>
		</tr>
		<tr>
			<td>加班费：${salary.overtimeSalary}元</td>
			<td>请假扣款：${salary.leaveUnpay}元</td>
		</tr>
		<tr>
			<td>罚款：${salary.forfeit}元</td>
			<td>其它扣款：${salary.otherUnpay}元</td>
		</tr>
		<tr>
			<td>应发工资：${salary.mustSalary}元</td>
			<td>实发工资：${salary.realSalary}元</td>
		</tr>
	</table>
</div>
<script type="text/javascript">
	$('#print').on('click', function() {
		$('#viewprodlg').printArea();
	});
</script>
