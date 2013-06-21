<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../common/tag.jsp"%>
<table id="tt_userList" class="easyui-datagrid" style="width: document.body.clientWidth*0.9; height: 340px" 
	data-options="idField:'id',toolbar:'#tb_cusxxx',
		collapsible:true,rownumbers:true,
		url:'/user/listContent.html?<c:if test="${sessionScope.user.role.roleName ne '系统管理员' }">f_departmentId=${user.department.id }&</c:if>n_id=${user.id }',
		pagination:true,singleSelect : true,cache:false">
	<thead>
		<tr>
			<th data-options="field:'username',width:80">用户名</th>
			<th data-options="field:'realName',width:80">真实姓名</th>
			<th data-options="field:'departmentName',width:120">部门</th>
			<th data-options="field:'mobile',width:120">手机</th>
			<th data-options="field:'sex',width:60">性别</th>
			<th data-options="field:'mobileTel',width:100">手机号</th>
			<th data-options="field:'createDate',width:100,formatter:formatDate">添加日期</th>
		</tr>
	</thead>
</table>
<div id="tb_cusxxx">
	<a href="#" class="easyui-linkbutton" iconCls="icon-user-add" plain="true" onclick="confirmAssign();">确认</a>
</div>