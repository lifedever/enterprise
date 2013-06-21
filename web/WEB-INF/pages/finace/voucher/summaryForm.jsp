<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../common/tag.jsp"%>
<div id="dlg" class="easyui-window" data-options="modal:true,closed:true,cache:false" 
	style="width: 500px; height: 220px; padding: 10px 20px" buttons="#dlg-buttons">
	<div class="ftitle">
		科目汇总<span class="form_desc">选择科目汇总的开始时间和结束时间，如不填写默认为汇总所有的内容</span>
	</div>
	<div style="padding: 10px 0 10px 10px;">
		<form:form id="fm_summary" method="post" class="fm" enctype="multipart/form-data">
			<table width="100%">
			<tr>
				<td>开始时间：<input type="text" readonly="readonly" id="startDate" name="startDate" onclick="WdatePicker({startDate:'%y年%M月01日',dateFmt:'yyyy年MM月dd日',alwaysUseStartDate:true});"/></td>
				<td>结束时间：<input type="text" readonly="readonly" id="endDate" name="endDate" onclick="WdatePicker({startDate:'%y年%M月01日',dateFmt:'yyyy年MM月dd日',alwaysUseStartDate:true});"/></td>
			</tr>
		</table>
		</form:form>
		<div id="dlg-buttons" style="text-align: center;">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="summary()">保存</a> 
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
				onclick="javascript:$('#dlg').window('close')">取消</a>
		</div>
	</div>
</div>
<script type="text/javascript">
	function summary(){
		$('#win_summary').window({
			href : '/finace/voucher/summary.html?startDate='+$('#startDate').val()+'&endDate='+$('#endDate').val()
		}).window('open');
		$('#dlg').window('close');
	}
</script>