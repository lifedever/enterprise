<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div id="dlg_salary" class="easyui-window" style="width: 770px; height: 450px; padding: 10px 20px" data-options="modal:true,closed:true" buttons="#dlg-buttons">
	<div class="ftitle">
		工资信息<span class="form_desc">填写详细工资单信息</span>
	</div>
	<div>
		<form id="fm_salary" method="post" class="fm">
			<table>
				<tr>
					<td>员工姓名：</td>
					<td><input type="text" id="employeeName" readonly="readonly" placeholder="单击选择员工" /> <input type="hidden" name="employeeId" id="employeeId" />&nbsp;<font color="red">*</font>&nbsp;</td>
					<td align="right">员工编号：</td>
					<td><input type="text" id="employeeNo" readonly="readonly" />&nbsp;<font color="red">*</font>&nbsp;</td>
				</tr>
				<tr>
					<td>基本工资：</td>
					<td><input type="text" name="baseSalary" id="baseSalary" class="easyui-numberbox" precision="2" />元</td>
					<td align="right">职务津贴：</td>
					<td><input type="text" name="allowance" id="allowance" class="easyui-numberbox" precision="2" />元</td>
				</tr>
				<tr>
					<td>工种补助：</td>
					<td><input type="text" name="jobSubsidy" id="jobSubsidy" class="easyui-numberbox" precision="2" />元</td>
					<td align="right">加班费：</td>
					<td><input type="text" name="overtimeSalary" id="overtimeSalary" class="easyui-numberbox" precision="2" />元</td>
				</tr>
				<tr>
					<td>加班补助：</td>
					<td><input type="text" name="overtimeSubsidy" id="overtimeSubsidy" class="easyui-numberbox" precision="2" />元</td>
					<td align="right" style="color: red">请假扣款：</td>
					<td><input type="text" name="leaveUnpay" id="leaveUnpay" class="easyui-numberbox" precision="2" />元</td>
				</tr>
				<tr>
					<td style="color: red">罚款：</td>
					<td><input type="text" name="forfeit" id="forfeit" class="easyui-numberbox" precision="2" />元</td>
					<td align="right" style="color: red">其它罚款：</td>
					<td><input type="text" name="otherUnpay" id="otherUnpay" class="easyui-numberbox" precision="2" />元</td>
				</tr>
				<tr>
					<td>应发工资：</td>
					<td><input type="text" name="mustSalary" id="mustSalary" readonly="readonly">元</td>
					<td align="right">实发工资：</td>
					<td><input type="text" name="realSalary" id="realSalary" />元</td>
				</tr>
				<tr>
					<td>发放帐号</td>
					<td><input type="text" id="accountName" readonly="readonly" placeholder="单击选择账户" /><input type="hidden" name="accountId" id="accountId" /></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="dlg-buttons" style="text-align: center; margin-top: 50px;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveSalary()">保存</a> <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveAndGoon()">保存并继续添加</a> <a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg_salary').dialog('close')">取消</a>
	</div>
</div>