<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!-- 用户添加表单 -->
<div id="dlg_sub" class="easyui-dialog" style="width: 570px; height: 310px; padding: 10px 20px" data-options="modal:true,closed:true" buttons="#dlg-buttons">
 <div class="ftitle">
  链接信息<span class="form_desc">填写链接信息</span>
 </div>
 <div>
  <form id="fm_sub" method="post" class="fm">
   <table>
    <tr>
     <td>链接名称：</td>
     <td><input class="easyui-validatebox" type="text" name="functionName"></input> &nbsp;<font color="red">*</font>&nbsp;</td>
    </tr>
    <tr>
     <td>链接地址：</td>
     <td><input class="easyui-validatebox" type="text" name="functionUrl"></input> &nbsp;<font color="red">*</font>&nbsp;</td>
    </tr>
    <tr>
     <td>链接描述：</td>
     <td><textarea name="description" style="height: 60px;"></textarea></td>
    </tr>
    <tr>
     <td>是否有效：</td>
     <td><select class="easyui-combobox" name="activeFlag" id="activeFlag_sub"><option value="1">有效</option>
       <option value="0">无效</option>
     </select></td>
    </tr>
   </table>
  </form>
 </div>
 <div id="dlg-buttons">
  <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveFun_sub()">保存</a> <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg_sub').dialog('close')">取消</a>
 </div>
</div>