<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--author: gefangshuai 2012-11-29 下午11:24:51-->
	<div id="dlg_msg" class="easyui-window" title="查看消息"
		style="width: 600px; height: 320px; padding: 10px 20px" closed="true"
		data-options="modal:true,maximizable:false,collapsible:false,onClose:winClose"
		buttons="#dlg-buttons">
		<div id="p_msg" class="easyui-panel"
			style="width: 550px; height: 268px; padding: 0px 10px 10px 10px;"></div>
	</div>
	<script type="text/javascript">
		function winClose(){
			$('#msgTable').datagrid('reload');
		}
	</script>
