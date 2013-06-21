<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div id="dlg_extend" class="easyui-dialog" style="width: 500px; height: 350px; padding: 10px 20px" data-options="modal:true,closed:true" buttons="#dlg-buttons">
	<div class="ftitle">
		添加收支信息<span class="form_desc">填写详细收支信息，便于统计</span>
	</div>
	<div>
		<form id="fm_extend" method="post" class="fm">
			<table>
				<tr>
					<td>类型：</td>
					<td><select name="inOrOut">
							<option id="in" value="1">收入</option>
							<option id="out" value="0">支出</option>
					</select> &nbsp;<font color="red">*</font>&nbsp;</td>
				</tr>
				<tr>
					<td>金额：</td>
					<td><input type="text" name="money" id="money" class="easyui-numberbox"  precision="2" ></input> &nbsp;<font color="red">*</font>&nbsp;</td>
				</tr>
				<tr>
					<td>用途：</td>
					<td><input type="text" name="remark" ></input> &nbsp;<font color="red" >*</font>&nbsp;</td>
				</tr>
				<!-- <tr>
					<td>科目：</td>
					<td><input type="text" id="accountantName" name="accountantName" readonly="readonly" placeholder="单击选择会计科目"></input> <input type="hidden" id="accountantId" name="accountantId"></input> &nbsp;<font color="red">*</font>&nbsp;</td>
				</tr> -->
				<tr>
					<td>账户：</td>
					<td><input type="text" id="accountName" name="accountName" readonly="readonly" ></input> <input type="hidden" id="accountId" name="accountId"></input> &nbsp;<font color="red">*</font>&nbsp;</td>
				</tr>
				<tr>
					<td>操作时间：</td>
					<td><input class="easyui-datebox" name="changeDate" id="changeDate" required="required"></input></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="dlg-buttons" style="text-align: center;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveExpend()">保存</a> <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg_extend').dialog('close')">取消</a>
	</div>
</div>