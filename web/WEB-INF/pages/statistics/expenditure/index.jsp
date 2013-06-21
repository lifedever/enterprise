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
		var $url = "/statistics/expenditure/years.html";
		$.ajax($url, {
			dataType : 'html',
			success : function(data) {
				$('#result').html(data);
			}
		});
	}
	function showMonths() {
		var year = $('#year').val();
		var $url = "/statistics/expenditure/months.html?year=" + year;
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
					for ( var i = new Date().getFullYear(); i >=1900 ; i--) {
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
			</select> <input type="button" onclick="showMonths();" value="查看月度报表" /> <select id="chartType" onclick="changeType();">
				<option value="column">柱状图</option>
				<option value="line">线形图</option>
				<option value="area">楔形图</option>
			</select>
			<div id="result"></div>
		</div>
	</div>
	<script type="text/javascript">
		function changeType() {
			var $type = $('#chartType');
			chart.options.chart.type = $type.val();
			chart = new Highcharts.Chart(chart.options);
		}
	</script>
</body>
</html>