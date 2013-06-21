<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!-- 用户添加表单 -->
<div id="dlg_type" class="easyui-dialog" style="width: 570px; height: 290px; padding: 10px 20px" data-options="modal:true,closed:true" buttons="#dlg-buttons">
 <div class="ftitle">
  类别信息<span class="form_desc">填写科目类别信息</span>
 </div>
 <div>
  <form id="fm_type" method="post" class="fm">
   <table>
    <tr>
     <td>类别名称：</td>
     <td><input class="easyui-validatebox" type="text" name="typeName" data-options="required:true,missingMessage:'必填字段'"></input> &nbsp;<font color="red">*</font>&nbsp;</td>

    </tr>
   </table>
  </form>
 </div>
 <div id="dlg-buttons">
  <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveAccount()">保存</a> <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg_type').dialog('close')">取消</a>
 </div>
</div>