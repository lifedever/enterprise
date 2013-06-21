<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../common/tag.jsp"%>
<div class="ftitle">
	询价条目信息<span class="form_desc">填写询价具体条目的信息</span>
</div>
<div style="padding: 10px 0 10px 60px;">
	<form id="fm_addOfferItem"  enctype="multipart/form-data" method="post">
		<table border="0" width="90%">
			<tr>
				<td width="12%">名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：</td>
				<td width="38%"><input type="text" name="productName" /></td>
				<td width="12%">外形尺寸：</td>
				<td width="38%"><input type="text" name="contourSize" /></td>
			</tr>
			<tr>
				<td>数&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;量：</td>
				<td><input type="text" name="productCount"  class="easyui-numberbox" precision="0" value="1"/></td>
				<td>质量要求：</td>
				<td><input type="text" name="qualityRequire" /></td>
			</tr>
			<tr>
				<td>印刷几色：</td>
				<td><input type="text" name="printColor" /></td>
				<td>印刷要求：</td>
				<td><input type="text" name="printRequire" /></td>
			</tr>
			<tr>
				<td>工&nbsp;&nbsp;程&nbsp;图：</td>
				<td><input type="file" name="file1" /></td>
				<td>效&nbsp;&nbsp;果&nbsp;图：</td>
				<td><input type="file" name="file2" /></td>
			</tr>
		</table>
	</form>
	<div id="dlg-buttons" style="text-align: center;margin-top: 50px;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveFormData('addOfferItem',false,'/meibo/offer/offerItem/saveTempOfferItem.html',false)">保存</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#win_addOfferItem').window('close')">取消</a>
	</div>
</div>