<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../../common/tag.jsp"%>
<div>
	<div id="container" style="min-width: 300px; height: 400px; margin: 0 auto"></div>
	<div><strong>总收入：<span id="inSum" style="color: #4572A7"></span></strong>&nbsp;元</div>
	<div><strong>总支出：<span id="outSum" style="color: #AA4643"></span></strong>&nbsp;元</div>
</div>
<script type="text/javascript">
	function getSum(arr){
		var sum = 0;
		for(var i=0;i<arr.length;i++){
			sum+=arr[i];
		}
		return sum;
	}
	var chart;
	var series = [ {
		name : '收入',
		data : []
	}, {
		name : '支出',
		data : []
	} ];
	$.getJSON('/statistics/expenditure/getYearData.html', function(data) {
		var years = data.year;
		series[0].data = data.ins;
		series[1].data = data.out;
		chart = new Highcharts.Chart({
			chart : {
				renderTo : 'container',
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
				text : '年度收支统计',
				style:{
					fontWeight: 'bold',
					fontSize:'20'
				},
				x : -20
			},
			subtitle : {
				text : '按年份统计收支明细',
				x : -20
			},
			xAxis : {
				title : {
					text : '年份(年)'
				},
				categories : years
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
					return '<b>' + this.series.name + '</b><br/>' + this.x
							+ ': ' + this.y + '元';
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
		$('#inSum').html(getSum(data.ins));
		$('#outSum').html(getSum(data.out));
	});
</script>
