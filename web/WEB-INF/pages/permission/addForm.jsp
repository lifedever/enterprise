<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!-- 用户添加表单 -->
<div id="dlg" class="easyui-dialog" data-options="modal:true,closed:true" style="width: 500px; height: 290px; padding: 10px 20px" buttons="#dlg-buttons">
  <div class="ftitle">
    权限配置<span class="form_desc">配置角色的权限信息</span>
  </div>
  <div>
    <form id="fm" method="post" class="fm">
      <table>
        <tr>
          <td>对象：</td>
          <td><input class="easyui-validatebox" type="text" name="title"></input> &nbsp;<font color="red">*</font>&nbsp;名称标识</td>
        </tr>
        <tr>
          <td>标识：</td>
          <td><input name="className" /> &nbsp;<font color="red">*</font>&nbsp;类名</td>
        </tr>
        <tr>
          <td>操作类型：</td>
          <td><select name="operation"><option value="list">列表</option>
          </select> &nbsp;<font color="red">*</font>&nbsp;</td>
        </tr>
        <tr>
          <td>控制范围：</td>
          <td><select name="cause"><option value="userId">用户</option>
              <option value="departmentId">部门</option>
          </select> &nbsp;<font color="red">*</font>&nbsp;</td>
        </tr>
      </table>
    </form>
  </div>
  <div id="dlg-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="savePermission()">保存</a> <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
  </div>