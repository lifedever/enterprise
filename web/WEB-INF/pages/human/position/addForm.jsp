<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!-- 用户添加表单 -->
<div id="dlg_position" class="easyui-window" data-options="modal:true,closed:true" style="width: 570px; height: 250px; padding: 10px 20px" buttons="#dlg-buttons">
	<div class="ftitle">
		职位信息<span class="form_desc">编辑职位信息</span>
	</div>
	<div>
		<form id="fm_position" method="post" class="fm">
			<table>
				<tr>
					<td>职位编号：</td>
					<td><input class="easyui-validatebox" type="text" name="positionNo"></input> &nbsp;<font color="red">*</font>&nbsp;</td>

				</tr>
				<tr>
					<td>职位名称：</td>
					<td><input class="easyui-validatebox" type="text" name="positionName"></input> &nbsp;<font color="red">*</font>&nbsp;</td>
				</tr>
			</table>
		</form>
	</div>
	<div id="dlg-buttons" style="text-align: center;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="savePosition()">保存</a> <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg_position').dialog('close')">取消</a>
	</div>
</div>