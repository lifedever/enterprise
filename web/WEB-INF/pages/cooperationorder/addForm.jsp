<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div id="dlg_cproduct" class="easyui-dialog" style="width: 690px; height: 400px; padding: 10px 20px" data-options="modal:true,closed:true">
	<div class="ftitle">
		外发单信息<span class="form_desc">填写外发单信息，需要关联产品</span>
	</div>
	<div>
		<form id="fm_cproduct" method="post" class="fm" enctype="multipart/form-data">
			<input type="hidden" name="productId" id="productId" /> <input type="hidden" name="factoryId" id="factoryId" />
			<table>
				<tr>
					<td colspan="4"><a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="selectProduct();">选择外发产品</a> <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="selectFactory();">选择协作工厂</a></td>
				</tr>
				<tr>
					<td>产品编号：</td>
					<td id="pro_no"></td>
					<td>产品名称：</td>
					<td id="pro_name"></td>
				</tr>
				<tr>
					<td>工厂编号：</td>
					<td id="fac_no"></td>
					<td>工厂名称：</td>
					<td id="fac_name"></td>
				</tr>
				<tr>
					<td>数量：</td>
					<td><input type="text" id="mount" readonly="readonly" /></td>
					<td>单位：</td>
					<td><input type="text" name="unit" /></td>
				</tr>
				<tr>
					<td>单价：</td>
					<td><input type="text" name="price" class="easyui-numberbox" precision="2" id="price" /></td>
					<td>总价：</td>
					<td><input type="text" id="sumPrice"  readonly="readonly" /></td>
				</tr>
				<tr>
					<td>外发单号：</td>
					<td><input type="text" name="cOrderNo" /></td>
					<td>制品单号：</td>
					<td><input type="text" name="goodsNo" /></td>
				</tr>
				<tr>
					<td>实付款项：</td>
					<td><input type="text" name="realPay" id="realPay"  id="price"/></td>
					<td>付款账户：</td>
					<td><input type="text" id="accountName" readonly="readonly" /> <input type="hidden" id="accountId" name="accountId"></input></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="dlg-buttons" style="text-align: center; margin-top: 30px;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveCproduct()">保存</a> <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg_cproduct').dialog('close')">取消</a>
	</div>
</div>