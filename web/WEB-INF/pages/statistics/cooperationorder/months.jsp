<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../../common/tag.jsp"%>
<div>
	<div id="container" style="min-width: 300px; height: 400px; margin: 0 auto"></div>
	<div>
		<strong>总支出：<span id="outSum" style="color: #AA4643"></span></strong>&nbsp;元
	</div>
</div>
<script type="text/javascript">
	var chart;
	var series = [ {
		name : '支出',
		data : []
	} ];
	$.getJSON('/statistics/cooperationorder/getMonthData.html?year=${year}',
			function(data) {
				series[0].data = data.out;
				chart = new Highcharts.Chart({
					chart : {
						renderTo : 'container',
						//line, spline, area, areaspline,column, bar, pie , scatter
						type : 'column',
						marginRight : 130,
						marginBottom : 50
					},
					exporting : {
						enable : true
					},
					credits : {
						enable : true,
						text : '北京美博雅克力工贸有限公司',
						href : '#'
					},
					title : {
						text : '${year}年外发支出统计',
						style:{
							fontWeight: 'bold',
							fontSize:'20'
						},
						x : -20
					},
					subtitle : {
						text : '按月份统计支出明细',
						x : -20
					},
					xAxis : {
						title : {
							text : '月份(月)'
						},
						categories : [ '一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月',
								'九月', '十月', '十一月', '十二月' ]
					},
					yAxis : {
						title : {
							text : '收支对比(元)'
						},
						plotLines : [ {
							value : 0,
							width : 1,
							color : '#808080'
						} ]
					},
					tooltip : {
						formatter : function() {
							return '<b>' + this.series.name + '</b><br/>'
									+ this.x + ': ' + this.y + '元';
						}
					},
					legend : {
						layout : 'vertical',
						align : 'right',
						verticalAlign : 'top',
						x : -10,
						y : 100,
						borderWidth : 0
					},
					series : series
				});
				$('#outSum').html(getSum(data.out));
			});
</script>
