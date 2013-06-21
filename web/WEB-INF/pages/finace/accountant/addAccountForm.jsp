<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!-- 用户添加表单 -->
<div id="dlg_account" class="easyui-dialog" style="width: 570px; height: 290px; padding: 10px 20px" data-options="modal:true,closed:true" buttons="#dlg-buttons">
 <div class="ftitle">
  科目信息<span class="form_desc">填写科目基本信息</span>
 </div>
 <div>
  <form id="fm_account" method="post" class="fm">
   <input type="hidden" name="typeId" id="typeId" />
   <table>
    <tr>
     <td>科目编号：</td>
     <td><input class="easyui-validatebox" type="text" name="accountNo" data-options="required:true,missingMessage:'必填字段'"></input> &nbsp;<font color="red">*</font>&nbsp;</td>

    </tr>
    <tr>
     <td>科目名称：</td>
     <td><input class="easyui-validatebox" type="text" name="accountName" data-options="required:true,missingMessage:'必填字段'"></input> &nbsp;<font color="red">*</font>&nbsp;</td>

    </tr>
    <tr>
     <td>科目描述：</td>
     <td><input class="easyui-validatebox" type="text" name="accountDesc"></input> &nbsp;<font color="red">*</font>&nbsp;</td>
    </tr>
    <tr>
     <td>是否有效：</td>
     <td><select class="easyui-combobox" name="activeFlag" id="activeFlag"><option value="1">有效</option>
       <option value="0">无效</option>
     </select></td>
    </tr>
   </table>
  </form>
 </div>
 <div id="dlg-buttons">
  <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveAccount()">保存</a> <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg_account').dialog('close')">取消</a>
 </div>
</div>