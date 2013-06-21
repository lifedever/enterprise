<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="/js/jquery-easyui-1.3.1/jquery-1.8.0.js"></script>
<script type="text/javascript" src="/js/jquery-easyui-1.3.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/js/utils.js"></script>
<script type="text/javascript" src="/js/DateFormat-0.1.js"></script>
<script type="text/javascript" src="/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="/js/datagrid-detailview.js"></script>
<script type="text/javascript" src="/js/jquery.PrintArea.js"></script>
<script type="text/javascript" src="/js/viewBeforUpload.js"></script>
<script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="/js/html5.js"></script>
<script type="text/javascript">
	$.fn.datebox.defaults.formatter = function(date) {
		var y = date.getFullYear();
		var m = date.getMonth() + 1;
		var d = date.getDate();
		 return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
	};
	//格式化时间
	function formatDate(value, row, index) {
		if (value) {
			return getDateFromJson(value);
		}
	}
	//强调单元格样式 
	function cellImpStyler(value, row, index) {
		if (value) {
			return 'color:red;';
		}
	}
	//格式化空值 
	function formatNull(value, row, index) {
		if (!value)
			return '暂无信息';
	}
	//格式化查看图片
	function formatImage(value, row, index) {
		return '<a href="'+value+'" target="_blank">' + '查看' + '</a>';
	}
	//格式化审批状态：-1：未通过，0：未审批，1：已通过
	function formatAuditState(value, row, index) {
		if (value == '-1') {
			return '<span style="color:red">未通过</span>';
		}
		if (value == '0') {
			return '<span style="color:blue">未审批</span>';
		}
		if (value == '1') {
			return '<span style="color:green">已通过</span>';
		}
	}

	//格式钱
	function formatMoney(value, row, index) {
		if (value == null)
			value = 0;
		return "￥ <strong>" + value + "</strong>";
	}
	//格式化第一行
	function firstRowStyler(index,row) {
		if (index == 0) {
			return 'background-color:#6293BB;color:#fff;font-weight:bold;';
		}
	}

	function overImg(e, a) {
		xOffset = 10;
		yOffset = 30;
		this.t = a.title;
		this.title = "";
		var c = (this.t != "") ? "<br/>" + this.t : "";
		$("body").append(
				"<p id='preview'><img src='"+ a.href +"' alt='图片预览' width='400' height='300'/>"
						+ c + "</p>");
		$("#preview").css("position", "absolute")
		//.animate({top:(e.pageY - xOffset) + "px"})
		.css("top", (e.pageY - xOffset) + "px").css("left",
				(e.pageX + yOffset) + "px").fadeIn("slow");
	}
	function outImg() {
		$("#preview").remove();
	}
	//操作
	function operation(value, row, index){
		if(value == 0){
			return '<span style="color:blue">入库</span>';
		}else {
			return '<span style="color:red">出库</span>';
		}
	}
	function print(id){
		$('#'+id).printArea();
	}
</script>

