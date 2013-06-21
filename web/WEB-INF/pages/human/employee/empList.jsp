<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="w_empList" class="easyui-window" title="员工列表" data-options="modal:true,closed:true,maximizable:false,iconCls:'icon-save'" style="width: 800px; height: 400px;">
	<table id="tt_empList">
	</table>
</div>
<script type="text/javascript">
	function empList(url) {
		$('#w_empList').window('open');
		$('#tt_empList').datagrid({
			width : $('#w_empList').width() - 2,
			height : $('#w_empList').height() - 2,
			idField : 'id',//id字段 
			rownumbers : true,//行号 
			singleSelect : true,//是否单选
			url : '/human/employee/listContent.html',
			toolbar : [ {
				id : 'btnrm',
				text : '确认选择',
				iconCls : 'icon-ok',
				handler : confirmSelect
			}, '-' ],
			columns : [ [  {
				field : 'ck',
				checkbox : true
			}, {
				field : 'empNo',
				title : '员工编号',
				width : 80
			}, {
				field : 'empName',
				title : '员工姓名',
				width : 80
			}, {
				field : 'empContact',
				title : '联系方式',
				width : 120
			}, {
				field : 'empDeptName',
				title : '所属部门',
				width : 200
			}, {
				field : 'empPositionName',
				title : '职位',
				width : 100
			}, {
				field : 'createDate',
				title : '入职时间',
				width : 150,
				//日期格式转换 
				formatter : function(value, row, index) {
					if (value) {
						return getDateFromJson(value);
					}
				}
			} ] ],
			pagination : true
		//启用分页 
		});
		//设置分页 
		$('#tt_empList').datagrid('getPager').pagination({
			pageSize : 10,//每页显示的记录条数，默认为10 
			pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
			beforePageText : '第',//页数文本框前显示的汉字 
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
		});
	}
</script>