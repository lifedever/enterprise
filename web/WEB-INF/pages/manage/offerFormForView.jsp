<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="ftitle">
		产品报价信息<span class="form_desc">根据客户要求进行产品报价</span>
	</div>
	<table width="80%" style="font-size: 14px;">
		<tr>
			<td>产品名称：${product.productName }</td>
			<td>客户要求：${offer.request }</td>
		</tr>
		<tr>
			<td>报价时间：${offer.offerDate }</td>
			<td>制作工期：${offer.makeDuration }</td>
		</tr>
	</table>
	<div style="margin: 10px;">
		<strong>所有报价信息列表：</strong>
		<hr />
		<table id="tt_offer" class="easyui-datagrid" title="" style="width: 500px; height: 220px" data-options="collapsible:true,rownumbers:true,url:'/offerMonery/getOfferList.html?id=${offer.id }',pagination:true,singleSelect : true">
			<thead>
				<tr>
					<th data-options="field:'money',width:120,formatter:moneyFormatter">价格</th>
					<th data-options="field:'createDate',width:100,formatter:dateFormatter">报价时间</th>
				</tr>
			</thead>
		</table>
	</div>
	<script type="text/javascript">
		function moneyFormatter(value) {
			return '￥ <strong>' + value + '</strong>';
		}
		function dateFormatter(value){
			return getDateFromJson(value);
		}
	</script>
</body>
</html>