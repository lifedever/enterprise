<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="../../common/tag.jsp"%>
	<div id="showAccessoryStoreRoom" class="easyui-window" title="辅料列表"
		style="width: 800px; height: 400px;" data-options="modal:true,closed:true,cache:false"
		buttons="#dlg-buttons">
		<div style="margin: 5px;display: none;" id="copyAccessoryoBuyRequestItem">
			<a href="#" class="easyui-linkbutton" iconCls="icon-ok" plain="true"
			onclick="copyAccessoryToBuyRequestItem();">确认</a>
		</div>
		<div>
			<table id="viewAccessoryStoreRoomtt" >
			</table>
		</div>
	</div>
<script type="text/javascript">
		
		function showAccessoryStoreRoom(stockId, flag){
			var url = "/stock/listAccessoryContent.html?stockId="+stockId + "&flag=" + flag;
   			$('#showAccessoryStoreRoom').window('open');
   			$('#viewAccessoryStoreRoomtt').datagrid({
   				width : function() {
   					return document.body.clientWidth * 0.9
   				},
   				height : 360,
   				idField : 'id',//id字段
   				rownumbers : true,//行号
   				url : url,
   				columns : [ [ {
   					field : 'ck',
   					checkbox : true
   				}, {
   					field : 'accessoryName',
   					title : '名称',
   					width : 100
   				}, {
   					field : 'accessoryStandard',
   					title : '规格',
   					width : 150
   				}, {
   					field : 'color',
   					title : '颜色',
   					width : 80
   				}, {
   					field : 'price',
   					title : '单价',
   					width : 70
   				}, {
   					field : 'accessoryCount',
   					title : '数量',
   					width : 70
   				}, {
   					field : 'totalPrice',
   					title : '总价',
   					width : 70
   				}, {
   					field : 'commodityCount',
   					title : '库房剩余',
   					width : 120,
   					formatter:function(value,row){
   						var result = "<font color='red'>"+value+"</font>&nbsp;&nbsp;";
   						if(row.commodityCount<row.accessoryCount){
   							result = result + "<font color='red'>（材料不足）</font>";
   						}
   						return result;
   					}
   				}, {
   					field : 'vender',
   					title : '厂家',
   					width : 200
   				}] ],
   				pagination : true
   			//启用分页
   			});
   			//设置分页
   			$('#viewAccessoryStoreRoomtt').datagrid('getPager').pagination({
   				pageSize : 10,//每页显示的记录条数，默认为10 
   				pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
   				beforePageText : '第',//页数文本框前显示的汉字 
   				afterPageText : '页    共 {pages} 页',
   				displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
   			});showAccessoryStoreRoom
		}
	</script>
	
	<script type="text/javascript">
	function copyAccessoryToBuyRequestItem(){
		var row = $('#viewAccessoryStoreRoomtt').datagrid('getSelected');
		if(row){
			$('#buyName').val(row.accessoryName).attr('readonly',true);
			$('#buyStandard').val(row.accessoryStandard).attr('readonly',true);
			$('#buyCount').val(row.accessoryCount).attr('readonly',true);
			$('#commodityId2').val(row.commodityId);
			$('#showAccessoryStoreRoom').window('close');
		}else {
			$.messager.alert('提示信息', '请选择条目！');
		}
	}
	</script>