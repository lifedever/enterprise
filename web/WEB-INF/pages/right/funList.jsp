<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div id="w" class="easyui-window"
	data-options="title:'功能列表',closed:true,modal:true" 
	style="width: 350px; height: 350px; padding: 10px";>
	<div class="demo-info">
		<div class="demo-tip icon-tip"></div>
		<div>勾选相应的功能模块提交后配置即可生效</div>
	</div>
	<div style="height: 200px;overflow: auto;">
		<form id="fm" method="post" action="/right/saveRight.html" class="fm">
			<ul id="tree" class="easyui-tree"
				
			</ul>
		</form>
	</div>
	<div id="dlg-buttons" style="margin-bottom: 10px; margin-left: 60px;margin-top: 14px;">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="save()" style="">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#w').dialog('close')">取消</a>
	</div>
</div>