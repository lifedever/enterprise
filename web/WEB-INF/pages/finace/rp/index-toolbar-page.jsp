<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="tb_rp">
<a href="#" class="easyui-linkbutton" iconCls="icon-orderView" plain="true" onclick="addRP();">添加</a>
<a href="#" class="easyui-linkbutton" iconCls="icon-system" plain="true" onclick="editRP();">修改</a>
<a href="#" class="easyui-linkbutton" iconCls="icon-seestore" plain="true" onclick="delRP();">删除</a>
&nbsp;类型：<select id="search_type">
		<option value="">全部</option>
		<option value="0">奖励</option>
		<option value="1">惩罚</option>
	</select>&nbsp;
日期时间：<input id="storeStartDate" name="storeStartDate" 
						style="width: 85px;" class="easyui-datebox" /> --
				 <input id="storeEndDate" name="storeEndDate" style="width: 85px;" 
						class="easyui-datebox" />&nbsp;
		姓名：<input id="search_userName" style="width: 100px" class="easyui-validatebox" />&nbsp;
		<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchRP();">查询</a>
</div>
