<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="../../common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>${title }</title>
<jsp:include page="../../common/css.jsp"></jsp:include>
<jsp:include page="../../common/js.jsp"></jsp:include>

<script type="text/javascript">
	var url = "/finace/proofcost/listProofOrder.html?isProof=1";
	$(function() {
		$("#p").panel({
			title : '欢迎您：${sessionScope.user.username}，所属部门：${sessionScope.user.department.departmentName}'
		});
		$('#tt')
				.datagrid(
						{
							title : '',
							iconCls : 'icon-edit',
							width : function() {
								return document.body.clientWidth * 0.9
							},
							height : 520,
							idField : 'id',//id字段
							rownumbers : true,//行号
							//multipleSelect : true,//是否多选
							url : url,
							singleSelect : true,//是否单选
							columns : [ [ {
								field : 'ck',
								checkbox : true
							}, {
								field : 'orderNo',
								title : '订单编号',
								width : 120
							}, {
								field : 'customerName',
								title : '客户姓名',
								width : 100
							}, {
								field : 'startDate',
								title : '开始时间',
								width : 160
							}, {
								field : 'endDate',
								title : '结束时间',
								width : 160
							}, {
								field : 'proofConut',
								title : '样品数量',
								width : 100
							}, {
								field : 'proofCost',
								title : '价格结算',
								formatter : function(value) {
									if (value == '') {
										return '<font color="red">未结算</font>';
									} else {
										return value;
									}
								},
								width : 100
							}, {
								field : 'isManagerAuditFinish',
								title : '审核状态',
								formatter : function(value) {
									if (value == 0) {
										return '<font color="red">未完成</font>';
									} else {
										return '<font color="green">已完成</font>';
									}
								},
								width : 100
							}] ],
							view : detailview,
							detailFormatter : function(index, row) {
								return '<div style="padding:2px"><table id="ddv-' + index + '"></table></div>';
							},
							onExpandRow : onExpandRow,
							pagination : true
						//启用分页
						});
		//设置分页
		$('#tt').datagrid('getPager').pagination({
			pageSize : 10,//每页显示的记录条数，默认为10 
			pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
			beforePageText : '第',//页数文本框前显示的汉字 
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
		});
	});
</script>
</head>
<body>
	<div id="p">
		<div title="报价管理">
			<table id="tt">
			</table>
		</div>
	</div>
	<input type="hidden" id="index" />
	<jsp:include page="auditProofForm.jsp"></jsp:include>
	<script type="text/javascript">
		function onExpandRow(index, row) {
			$('#index').val(index);
			$('#ddv-' + index).datagrid({
				url : '/proof/getProofsByOrderId.html?orderId=' + row.id,
				fitColumns : true,
				singleSelect : true,
				rownumbers : true,
				id : 'id',
				loadMsg : '正在加载....',
				height : 'auto',
				toolbar : [ {
					id : 'btnadd',
					text : '价格审批',
					iconCls : 'icon-edit',
					handler : function() {
						var row = $('#ddv-' + index).datagrid('getSelected');
						$('#dlg_addAudit').dialog('open').dialog('setTitle', '价格审批');
						$('#fm_addAudit').form('clear');
						$('#p_id').val(row.id);
					}
				} ],
				columns : [ [ {
					field : 'customerRequire',
					title : '客户要求',
					width : 60
				}, {
					field : 'proofEffect',
					title : '样品效果',
					width : 60
				}, {
					field : 'proofCount',
					title : '样品数量',
					width : 30
				}, {
					field : 'proofMoney',
					title : '样品单价',
					width : 30
				}, {
					field : 'proofCost',
					title : '样品总价',
					width : 30
				}, {
					field : 'managerAudit',
					title : '价格审核',
					formatter : function(value) {
						if (value == 0) {
							return '<font color="blue">未审核</font>';
						} if(value==1){
							return '<font color="red">未通过</font>';
						}else {
							return '<font color="green">已通过</font>';
						}
					},
					width : 30
				} ] ],
				onResize : function() {
					$('#tt').datagrid('fixDetailRowHeight', index);
				},
				onLoadSuccess : function() {
					setTimeout(function() {
						$('#tt').datagrid('fixDetailRowHeight', index);
					}, 0);
				}
			});
			$('#tt').datagrid('fixDetailRowHeight', index);
		}
		function saveAudit() {
			$('#fm_addAudit').form('submit', {
				url : "/finace/proofcost/saveAudit.html",
				success : function(data) {
					if (data) {
						var index = $('#index').val();
						$.messager.alert('提示信息', '操作成功！');
						$('#dlg_addAudit').dialog('close'); // close the dialog
						$('#ddv-' + index).datagrid('reload');
						$('#tt').datagrid('reload');
						var row = $('#tt').datagrid('getSelected');
						if(row){
							$('#tt').datagrid('getSelected').onExpandRow(index, row);
						}
					} else {
						$.messager.alert('提示信息', '操作失败！');
					}
				}
			});
		}
	</script>
</body>
<jsp:include page="../../main/footer.jsp"></jsp:include>
</html>