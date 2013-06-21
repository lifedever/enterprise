<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!-- 用户添加表单 -->
<div id="dlg_account" class="easyui-dialog" style="width: 570px; height: 290px; padding: 10px 20px" data-options="modal:true,closed:true" buttons="#dlg-buttons">
 <div class="ftitle">
  账户信息<span class="form_desc">填写账户详细信息</span>
 </div>
 <div>
  <form id="fm_account" method="post" class="fm">
  <input type="hidden" id="accountType" name="accountType"/>
   <table>
    <tr>
     <td>账户名称：</td>
     <td><input class="easyui-validatebox" type="text" name="accountName" data-options="required:true,missingMessage:'必填字段'"></input> &nbsp;<font color="red">*</font>&nbsp;</td>
    </tr>
    <tr>
     <td>账户卡号：</td>
     <td><input class="easyui-validatebox" type="text" name="accountNo"></input> &nbsp;<font color="red">*</font>&nbsp;</td>
    </tr>
   </table>
  </form>
 </div>
 <div id="dlg-buttons">
  <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveAccount()">保存</a> <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg_account').dialog('close')">取消</a>
 </div>
</div>