<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../../common/tag.jsp"%>
<div>
	<div id="container" style="min-width: 300px; height: 400px; margin: 0 auto"></div>
	<div>
		<strong>总收入：<span id="inSum" style="color: #4572A7"></span></strong>&nbsp;元
		<div><strong>总交易：<span id="outSum" style="color: #AA4643"></span></strong>&nbsp;笔</div>
	</div>
</div>
<script type="text/javascript">
	var chart;
	var series = [ {
		name : '收入',
		data : []
	}, {
		name : '交易额',
		data : []
	}  ];
	$.getJSON('/statistics/prorder/getMonthData.html?year=${year}',
			function(data) {
				series[0].data = data.out;
				series[1].data = data.count;
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
						text : '${year}年订单收入统计',
						style:{
							fontWeight: 'bold',
							fontSize:'20'
						},
						x : -20
					},
					subtitle : {
						text : '按月份统计收入明细',
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
							text : '月交易量（万元/笔）'
						},
						plotLines : [ {
							value : 0,
							width : 1,
							color : '#808080'
						} ]
					},
					tooltip : {
						formatter : function() {
							if(this.series.columnIndex==0){
								return '<b>' + this.series.name + '</b><br/>'
								+ this.x + ': ' + this.y + '万元';
							}
							if(this.series.columnIndex==1){
								return '<b>' + this.series.name + '</b><br/>'
								+ this.x + ': ' + this.y + '笔';
							}
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
				$('#inSum').html(getSum(data.out));
				$('#outSum').html(getSum(data.count));
			});
</script>
