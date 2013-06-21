<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../common/tag.jsp"%>
<div class="ftitle">
	用料明细信息<span class="form_desc">填写用料明细信息</span>
</div>
<div style="padding: 10px 0 10px 60px;">
	<form id="fm_addDetail" method="post" >
		<input type="hidden" name="itemId" value="${itemId }">
		<table border="0" width="90%">
			<tr>
				<td>
					类型：					
				</td>
				<td>
					<input type="radio" name="type" value="0" checked="checked"/><span style="color: red;">材料</span>
					<input type="radio" name="type" value="1" /><span style="color: green;">辅料</span>
				</td>
			</tr>
			<tr>
				<td width="12%">名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：</td>
				<td width="38%"><input type="text" name="name" /></td>
				<td width="12%">标准：</td>
				<td width="38%"><input type="text" name="standard" /></td>
			</tr>
			<tr>
				<td>数&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;量：</td>
				<td><input type="text" name="count"  class="easyui-numberbox" precision="0" value="1"/></td>
				<td>颜色厚度：</td>
				<td><input type="text" name="thickness" /></td>
			</tr>
			<tr>
				<td>整版：</td>
				<td><input type="text" name="fullPage" /></td>
				<td>备注：</td>
				<td><input type="text" name="remark" /></td>
			</tr>
		</table>
	</form>
	<div id="dlg-buttons" style="text-align: center;margin-top: 50px;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveFormData('addDetail',false,'/meibo/offer/materialdetail/saveTempDetail.html',false)">保存</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#win_addDetail').window('close')">取消</a>
	</div>
</div>