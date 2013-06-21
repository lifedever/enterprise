<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div id="dlg_export" class="easyui-window" style="width: 460px; height: 270px; padding: 10px 20px" data-options="modal:true,closed:true" buttons="#dlg-buttons2">
	<div class="ftitle">
		导出报表<span class="form_desc">输入开始日期和结束日期</span>
	</div>
	<div>
		<form id="fm_export" method="post" class="fm">
			<table>
				<tr>
					<td>开始日期：</td>
					<td><input name="startDate" readonly="readonly" style="width: 85px;" class="easyui-datebox"> <font color="red">*</font></td>
				</tr>
				<tr>

					<td>结束日期：</td>
					<td><input name="endDate" readonly="readonly" style="width: 85px;" class="easyui-datebox"> <font color="red">*</font></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="dlg-buttons2" style="text-align: center; margin-top: 50px;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="exportOk()">导出</a> <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg_export').window('close')">取消</a>
	</div>
</div>