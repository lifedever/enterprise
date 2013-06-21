<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../common/tag.jsp"%>
<div id="tb_customer">
<a href="#" class="easyui-linkbutton" iconCls="icon-info" plain="true" onclick="showMoneyAudit();">报价详情</a>
<a href="#" class="easyui-linkbutton" iconCls="icon-order" plain="true" onclick="generateOrder();">下订单</a>
<c:choose>
<c:when test="${sessionScope.user.role.roleName eq '系统管理员2' }">
	<a href="#" class="easyui-linkbutton" iconCls="icon-del" plain="true" onclick="delOffer();">删除报价</a>
</c:when>
<c:otherwise>
	<a href="#" class="easyui-linkbutton" iconCls="icon-del" plain="true" onclick="delOffer2();">删除报价</a>
</c:otherwise>
</c:choose>
	&nbsp;&nbsp;&nbsp;&nbsp;客户姓名：<input id="searchVal" class="easyui-searchbox"
		data-options="prompt:'输入客户姓名',searcher:searchOffer" />
</div>