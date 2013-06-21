<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../../common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>${title }</title>
<jsp:include page="../../common/css.jsp"></jsp:include>
<jsp:include page="../../common/js.jsp"></jsp:include>
<script type="text/javascript" src="/js/highcharts.js"></script>
<script type="text/javascript" src="/js/exporting.js"></script>
<script type="text/javascript">
	function showYear() {
		var $url = "/statistics/salary/empYears.html?empId=${emp.id}";
		$.ajax($url, {
			dataType : 'html',
			success : function(data) {
				$('#result').html(data);
			}
		});
	}
	function showMonths() {
		var year = $('#year').val();
		var $url = "/statistics/salary/empMonths.html?empId=${emp.id}&year=" + year;
		$.ajax($url, {
			dataType : 'html',
			success : function(data) {
				$('#result').html(data);
			}
		});
	}
</script>
</head>
<body>
	<div id="p" class="easyui-panel" style="height: 520px" title="欢迎您：${sessionScope.user.username}，所属部门：${sessionScope.user.department.departmentName}">
		<div style="margin: 10px; font-size: 14px; height: 100px;">
			请选择要统计的年份： <select name="year" id="year">
				<script type="text/javascript">
					for ( var i = 1990; i <= new Date().getFullYear(); i++) {
						if (i == new Date().getFullYear()) {
							document
									.write("<option value='"+i+"' selected='selected'>"
											+ i + "</option>");
						} else {
							document.write("<option value='"+i+"'>" + i
									+ "</option>");
						}
					}
					showYear();
				</script>
			</select> <input type="button" onclick="showMonths();" value="查看月度报表" /> 
			<select id="chartType" onclick="changeType();">
				<option value="column">柱状图</option>
				<option value="line">线形图</option>
				<option value="area">楔形图</option>
			</select>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button"  onclick="showEmployee()" value="查看具体员工的薪水统计"/>
			<div id="result"></div>
		</div>
	</div>
	<jsp:include page="../../human/employee/empList.jsp"></jsp:include>
	<div class="easyui-window" id="win_employee" data-options="title:'选择员工',closed:true,modal:true,iconCls:'icon-save',cache:false" style="width: 850px; height: 400px; padding: 10px;"></div>
	<script type="text/javascript">
		function changeType() {
			var $type = $('#chartType');
			chart.options.chart.type = $type.val();
			chart = new Highcharts.Chart(chart.options);
		}
		//现实员工列表 
		function showEmployee(){
			empList();
		}
		function confirmSelect(){
			var row = $('#tt_empList').datagrid('getSelected');
			var empId = row.id;
			$('#w_empList').window('close');
			window.location.href="/statistics/salary/empIndex.html?empId="+empId;
		}
	</script>
</body>
</html>