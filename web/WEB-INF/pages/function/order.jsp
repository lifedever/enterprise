<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<script type="text/javascript">
	function up(row) {
		url = "/function/sortUpParentContent.html?id=" + row;
		$('#tt').datagrid({
			url : url
		});
	}
	function down(row) {
		url = "/function/sortDownParentContent.html?id=" + row;
		$('#tt').datagrid({
			url : url
		});
	}
	function up_sub(row) {
		url = "/function/sortUpParentContent.html?id=" + row;
		$('#tt_sub').datagrid({
			url : url
		});
	}
	function down_sub(row) {
		url = "/function/sortDownParentContent.html?id=" + row;
		$('#tt_sub').datagrid({
			url : url
		});
	}
</script>