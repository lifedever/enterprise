<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!-- 用户添加表单 -->
<div id="dlg" class="easyui-dialog" style="width: 570px; height: 290px; padding: 10px 20px" data-options="modal:true,closed:true" buttons="#dlg-buttons">
 <div class="ftitle">
  模块信息<span class="form_desc">填写功能模块信息</span>
 </div>
 <div>
  <form id="fm" method="post" class="fm">
   <table>
    <tr>
     <td>模块名称：</td>
     <td><input class="easyui-validatebox" type="text" name="functionName"></input> &nbsp;<font color="red">*</font>&nbsp;</td>

    </tr>
    <tr>
     <td>模块描述：</td>
     <td><textarea name="description" style="height: 60px;"></textarea></td>
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
  <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveFun()">保存</a> <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
 </div>
</div>