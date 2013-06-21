<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="../../common/tag.jsp"%>
	<div id="showMaterialStoreRoom" class="easyui-window" title="原材料列表" 
		style="width: 800px; height: 400px;" data-options="modal:true,closed:true,cache:false,onMaximize:maximize">
		<div style="margin: 5px;display: none;" id="copyMaterialToBuyRequestItem">
			<a href="#" class="easyui-linkbutton" iconCls="icon-ok" plain="true"
			onclick="copyMaterialToBuyRequestItem();">确认</a>
		</div>
		
		<div>
			<table id="viewMaterialStoreRoomtt">
			</table>
		</div>
	</div>
<script type="text/javascript">
		function maximize(){
		
			$(window).resize(function(){  
				$('#viewMaterialStoreRoomtt').datagrid('resize');  
			});   
			$('#viewMaterialStoreRoomtt').datagrid('resize');
			$('#viewMaterialStoreRoomtt').datagrid('load');
		}
		function showMaterialStoreRoom(stockId, flag){
			var url = "/stock/listMaterialContent.html?stockId="+stockId + "&flag="+ flag;
   			$('#showMaterialStoreRoom').window('open');
   			$('#viewMaterialStoreRoomtt').datagrid({
   				height : 320,
   				idField : 'id',//id字段
   				rownumbers : true,//行号
   				fitColumnss : true,
   				url : url,
   				columns : [ [ {
   					field : 'ck',
   					checkbox : true
   				}, {
   					field : 'name',
   					title : '名称',
   					width : 100
   				}, {
   					field : 'standard',
   					title : '规格',
   					width : 150
   				}, {
   					field : 'color',
   					title : '颜色',
   					width : 80
   				}, {
   					field : 'thickness',
   					title : '厚度',
   					width : 80
   				}, {
   					field : 'price',
   					title : '单价',
   					width : 70
   				}, {
   					field : 'count',
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
   						if(row.commodityCount<row.count){
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
   			$('#viewMaterialStoreRoomtt').datagrid('getPager').pagination({
   				pageSize : 5,//每页显示的记录条数，默认为10 
   				pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
   				beforePageText : '第',//页数文本框前显示的汉字 
   				afterPageText : '页    共 {pages} 页',
   				displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
   			});
		}
		function copyMaterialToBuyRequestItem(){
			var row = $('#viewMaterialStoreRoomtt').datagrid('getSelected');
			if(row){
				$('#buyName').val(row.name).attr('readonly',true);
				$('#buyStandard').val(row.standard).attr('readonly',true);
				$('#buyCount').val(row.count).attr('readonly',true);
				$('#commodityId2').val(row.commodityId);
				$('#showMaterialStoreRoom').window('close');
			}else {
				$.messager.alert('提示信息', '请选择条目！');
			}
		}
	</script>
	
	