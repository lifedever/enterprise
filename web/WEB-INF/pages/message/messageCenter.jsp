<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--author: gefangshuai 2012-11-27 下午9:17:27-->
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title}</title>
<style type="text/css">
.m_title {
	cursor: pointer;
	font-size: 14px;
	font-weight: bold;
}

.mouseover {
	background-color: #E6E6E6;
	cursor: pointer;
	font-size: 14px;
	font-weight: bold;
}

a {
	text-decoration: none;
}
</style>
</head>
<body>
	<div id="w" class="easyui-window" title="消息中心" data-options="closed:true,modal:true,iconCls:'icon-save'" style="width: 850px; height: 500px; padding: 10px;">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'north'" style="height: 44px">
				<div class="demo-info">
					<div class="demo-tip icon-tip"></div>
					<div>方便管理您的消息</div>
				</div>
			</div>
			<div data-options="region:'west',split:true" style="width: 160px; padding: 10px">
				<ul class="easyui-tree" id="msgTree" data-options="animate:true">
					<li id=""><span>消息管理</span>
						<ul>
							<li id="_create">写消息</li>
							<li id=""><span>收件箱</span>
								<ul>
									<li id="_noRead">未读信息</li>
									<li id="_read">已读信息</li>
								</ul></li>
							<li id="_send">发件箱</li>
							<li id="_delete">回收站</li>
						</ul></li>
				</ul>
			</div>
			<div id="centerMsg" data-options="region:'center'" style="">
				<div style="padding: 10px;" id="welcome">
					<div style="font-size: 20px; margin-bottom: 10px;">欢迎访问消息中心！在下面创建一条新的消息吧！</div>
					<form action="" method="post" id="msgForm">
						<table>
							<input type="hidden" name="sendUserId" value="${sessionScope.user.id }" />
							<tr>
								<td>发送者：</td>
								<td>${sessionScope.user.username }</td>
							</tr>
							<tr>
								<td>接收者：</td>
								<td><input type="text" name="usernames" placeholder="账户名(非真实姓名)" id="usernames" readonly="readonly"/>
								<a href="#" class="easyui-linkbutton" iconCls="" plain="true" onclick="chooseUsers();">添加</a> <span style="color: red" id="noUser"></span></td>

							</tr>
							<tr>
								<td>主题：</td>
								<td><input type="text" name="title" id="title" placeholder="消息主题" /></td>
							</tr>
							<tr>
								<td>消息内容：</td>
								<td><textarea placeholder="内容长度不能超过200个字符" cols="40" rows="10" name="content" id="content2"></textarea></td>
							</tr>
						</table>
						<div style="margin-left: 100px; margin-top: 20px;">
							<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="" onclick="sendMsg()">发送</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
							<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="" onclick="msgForm.reset();">取消</a>
						</div>
					</form>
				</div>
				<div id="table">
					<table id="msgTable"></table>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="show.jsp"></jsp:include>
	<jsp:include page="userList.jsp"></jsp:include>
	<script type="text/javascript">
		(function() {
			$('#msgTree').tree({
				onClick : clickNode
			});
		})();
		function clickNode(node) {
			$('#welcome').hide();
			$('#table').show();
			if (node.id && node.id != '_create') {
				$('#msgTable').datagrid({
					width : $('#centerMsg').width() - 3,
					height : $('#w').height() - 48,
					idField : 'id',//id字段
					rownumbers : true,//行号
					multipleSelect : true,//是否多选
					url : "/message/getMessage.html?nowClick="+ node.id,
					singleSelect : true,//是否单选
					columns : [ [
					    {
							field : 'ck',checkbox : true
						},{
							field : 'title',title : '标题',
							formatter : function(value,row,index) {
								return "<a href='#' onclick='showMessage(\""+ row.id+ "\");'><strong>"+ row.title+ "</strong></a>";
							},
							width : 200
						},{
							field : 'sendUser',
							title : '来源',
							width : 70
						},
						{
							field : 'type',
							title : '消息类型',
							width : 70
						},
						{
							field : 'createDate',
							title : '创建时间',
							width : 130,
							//日期格式转换
							formatter : function(value,row,index) {
								if (value) {
									return getDateTimeFromJson(value);
								}
							}
						},
						{
							field : 'id',
							title : '操作',
							formatter : function(value,row,index) {
								if (row.isDelete == 0) {
									return "<span style='color:red;cursor:pointer' onclick='remove(\""+ row.id+ "\")';><strong>移至回收站</strong></span>";
								} else if (row.isDelete == 1) {
									return "<span style='color:green;cursor:pointer' onclick='unremove(\""+ row.id+ "\")';><strong>还原消息</strong></span>";
								}
							},
							width : 100
						} ] ],
						pagination : true//启用分页
						});
			}
			if (node.id == '_create') {
				createMsg();
			}
		}
		function showWin() {
			$('#w').window('open');
			var node = $('#msgTree').tree('find','_create'); 
			$('#msgTree').tree('select',node.target);
			clickNode(node);
			if ($('#msgTree').tree('getSelected') != null) {
				//$('#msgTable').datagrid('reload')
			}
		}
		function showNoReadWin(){
			$('#w').window('open');
			var node = $('#msgTree').tree('find','_noRead'); 
			$('#msgTree').tree('select',node.target);
			clickNode(node);
			if ($('#msgTree').tree('getSelected') != null) {
				$('#msgTable').datagrid('reload')
			}
		}
		function showMessage(id) {
			$('#dlg_msg').window('open');
			$('#p_msg').panel('refresh', '/message/showMessage.html?id=' + id);
		}
		function remove(id) {
			$.get('/message/remove.html?id=' + id, function(data) {
				var result = eval('(' + data + ')');
				if (result) {
					alert('消息已移入回收站！');
					$('#msgTable').datagrid('reload');
				} else {
					alert('操作失败！');
				}
			});
		}
		function unremove(id) {
			$.get('/message/unremove.html?id=' + id, function(data) {
				var result = eval('(' + data + ')');
				if (result) {
					alert('消息已还原！');
					$('#msgTable').datagrid('reload');
				} else {
					alert('操作失败！');
				}
			});
		}
		//写消息
		function createMsg() {
			$('#table').hide();
			$('#welcome').show();
		}
		//选择用户
		function chooseUsers() {
			showUserList("/user/listContent.html");
		}
		//
		function addUserOk() {
			var rows = $('#tt_userList').datagrid('getSelections');
			var names = '';
			for ( var i = 0; i < rows.length; i++) {
				names += rows[i].username + ',';
			}
			$('#usernames').val(names);
			$('#w_userList').window('close');
		}
		//发送消息
		(function() {
			$('#usernames').on('blur', function() {
				$.get('/message/checkUsernames.html', {
					usernames : $('#usernames').val()
				}, function(data) {
					var result = eval("(" + data + ")");
					noUser = result.noUser;
					if (noUser.length > 0) {
						$('#noUser').text(noUser + '不存在，请重新选择');
						$('#usernames').focus();
					} else {
						$('#noUser').text('');
					}
				});
			});
		})();
		function sendMsg() {
			$('#msgForm')
					.form(
							'submit',
							{
								url : "/message/sendMessage.html",
								onSubmit : function() {
									var usernames = $('#usernames'), title = $('#title'), 
										content = $('#content2');
									if (usernames.val() == '') {
										$.messager.alert('提示', '请选择接收者');
										return false;
									}
									if (title.val() == '') {
										$.messager.alert('提示', '请输入消息主题');
										return false;
									}
									if (content.val() == '') {
										$.messager.alert('提示', '请输入消息内容');
										return false;
									}
									if (content.val().length > 200) {
										$.messager
												.alert('提示', '消息内容不能超过200个字符');
										return false;
									}

								},
								success : function(data) {
									var result = eval('(' + data + ')');
									if (result) {
										$.messager.alert('成功', '发送成功！');
										$('#msgForm').get(0).reset();
									}
								}
							});
		}
		
	</script>
</body>
</head>