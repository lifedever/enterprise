<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../common/tag.jsp"%>
<style>
input {
	border: 0px;
	width: 100px;
}

.table {
	border-collapse: collapse;
}

.table td {
	padding: 10px;
}
</style>
<div>
	<form:form id="fm_newProfit" method="post" class="fm" commandName="profit">
		<form:input path="id" cssStyle="display:none" />
		<div style="text-align: center; font-size: 16px; font-weight: bold; margin-bottom: 10px;">利&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;润&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;表</div>
		<div style="text-align: center; margin-bottom: 20px;">
			<form:input path="createDate" />
		</div>
		<div style="text-align: left; float: left;">
			编制单位：
			<form:input path="bzhdw" cssStyle="width:150px;" />
		</div>
		<div style="text-align: right; float: right;">金额单位：人民币元</div>
		<table border="1" width="100%" class="table">
			<tr>
				<td width="50%">项目</td>
				<td width="16%">行次</td>
				<td width="17%">本期金额</td>
				<td width="17%">本年累计</td>
			</tr>
			<tr>
				<td>一、营业收入</td>
				<td align="center">1</td>
				<td><form:input path="yyshr" class="easyui-numberbox" precision="2" data-options="required:true,missingMessage:'必填字段'" /></td>
				<td><form:input path="y_yyshr" class="easyui-numberbox" precision="2" data-options="required:true,missingMessage:'必填字段'" /></td>
			</tr>
			<tr>
				<td>减：营业成本</td>
				<td align="center">2</td>
				<td><form:input path="yychb" class="easyui-numberbox" precision="2" data-options="required:true,missingMessage:'必填字段'" /></td>
				<td><form:input path="y_yychb" class="easyui-numberbox" precision="2" data-options="required:true,missingMessage:'必填字段'" /></td>
			</tr>
			<tr>
				<td>营业税金及附加</td>
				<td align="center">3</td>
				<td><form:input path="yyshj" class="easyui-numberbox" precision="2" data-options="required:true,missingMessage:'必填字段'" /></td>
				<td><form:input path="y_yyshj" class="easyui-numberbox" precision="2" data-options="required:true,missingMessage:'必填字段'" /></td>
			</tr>
			<tr>
				<td>销售费用</td>
				<td align="center">4</td>
				<td><form:input path="xshfy" class="easyui-numberbox" precision="2" data-options="required:true,missingMessage:'必填字段'" /></td>
				<td><form:input path="y_xshfy" class="easyui-numberbox" precision="2" data-options="required:true,missingMessage:'必填字段'" /></td>
			</tr>
			<tr>
				<td>管理费用</td>
				<td align="center">5</td>
				<td><form:input path="glfy" class="easyui-numberbox" precision="2" data-options="required:true,missingMessage:'必填字段'" /></td>
				<td><form:input path="y_glfy" class="easyui-numberbox" precision="2" data-options="required:true,missingMessage:'必填字段'" /></td>
			</tr>
			<tr>
				<td>财务费用</td>
				<td align="center">6</td>
				<td><form:input path="cwfy" class="easyui-numberbox" precision="2" data-options="required:true,missingMessage:'必填字段'" /></td>
				<td><form:input path="y_cwfy" class="easyui-numberbox" precision="2" data-options="required:true,missingMessage:'必填字段'" /></td>
			</tr>
			<tr>
				<td>资产减值损失</td>
				<td align="center">7</td>
				<td><form:input path="zijzhssh" class="easyui-numberbox" precision="2" data-options="required:true,missingMessage:'必填字段'" /></td>
				<td><form:input path="y_zijzhssh" class="easyui-numberbox" precision="2" data-options="required:true,missingMessage:'必填字段'" /></td>
			</tr>
			<tr>
				<td>加：公允价值变动收益</td>
				<td align="center">8</td>
				<td><form:input path="gyjzh" class="easyui-numberbox" precision="2" data-options="required:true,missingMessage:'必填字段'" /></td>
				<td><form:input path="y_gyjzh" class="easyui-numberbox" precision="2" data-options="required:true,missingMessage:'必填字段'" /></td>
			</tr>
			<tr>
				<td>投资收益</td>
				<td align="center">9</td>
				<td><form:input path="tzshy" class="easyui-numberbox" precision="2" data-options="required:true,missingMessage:'必填字段'" /></td>
				<td><form:input path="y_tzshy" class="easyui-numberbox" precision="2" data-options="required:true,missingMessage:'必填字段'" /></td>
			</tr>
			<tr>
				<td>其中：对联营企业和合营企业的投资收益</td>
				<td align="center">10</td>
				<td><form:input path="lyqy" class="easyui-numberbox" precision="2" data-options="required:true,missingMessage:'必填字段'" /></td>
				<td><form:input path="y_lyqy" class="easyui-numberbox" precision="2" data-options="required:true,missingMessage:'必填字段'" /></td>
			</tr>
			<tr>
				<td>二、营业利润</td>
				<td align="center">11</td>
				<td><form:input path="yylr" class="easyui-numberbox" precision="2" data-options="required:true,missingMessage:'必填字段'" /></td>
				<td><form:input path="y_yylr" class="easyui-numberbox" precision="2" data-options="required:true,missingMessage:'必填字段'" /></td>
			</tr>
			<tr>
				<td>加：营业外收入</td>
				<td align="center">12</td>
				<td><form:input path="yywshr" class="easyui-numberbox" precision="2" data-options="required:true,missingMessage:'必填字段'" /></td>
				<td><form:input path="y_yywshr" class="easyui-numberbox" precision="2" data-options="required:true,missingMessage:'必填字段'" /></td>
			</tr>
			<tr>
				<td>补贴收入</td>
				<td align="center">13</td>
				<td><form:input path="btshr" class="easyui-numberbox" precision="2" data-options="required:true,missingMessage:'必填字段'" /></td>
				<td><form:input path="y_btshr" class="easyui-numberbox" precision="2" data-options="required:true,missingMessage:'必填字段'" /></td>
			</tr>
			<tr>
				<td>减：营业外支出</td>
				<td align="center">14</td>
				<td><form:input path="yywzhch" class="easyui-numberbox" precision="2" data-options="required:true,missingMessage:'必填字段'" /></td>
				<td><form:input path="y_yywzhch" class="easyui-numberbox" precision="2" data-options="required:true,missingMessage:'必填字段'" /></td>
			</tr>
			<tr>
				<td>其中：非流动资产处理损失</td>
				<td align="center">15</td>
				<td><form:input path="flqzch" class="easyui-numberbox" precision="2" data-options="required:true,missingMessage:'必填字段'" /></td>
				<td><form:input path="y_flqzch" class="easyui-numberbox" precision="2" data-options="required:true,missingMessage:'必填字段'" /></td>
			</tr>
			<tr>
				<td>三、利润总额</td>
				<td align="center">16</td>
				<td><form:input path="lrze" class="easyui-numberbox" precision="2" data-options="required:true,missingMessage:'必填字段'" /></td>
				<td><form:input path="y_lrze" class="easyui-numberbox" precision="2" data-options="required:true,missingMessage:'必填字段'" /></td>
			</tr>
			<tr>
				<td>减：所得税费用</td>
				<td align="center">17</td>
				<td><form:input path="sdshfy" class="easyui-numberbox" precision="2" data-options="required:true,missingMessage:'必填字段'" /></td>
				<td><form:input path="y_sdshfy" class="easyui-numberbox" precision="2" data-options="required:true,missingMessage:'必填字段'" /></td>
			</tr>
			<tr>
				<td>四、净利润</td>
				<td align="center">18</td>
				<td><form:input path="jlr" class="easyui-numberbox" precision="2" data-options="required:true,missingMessage:'必填字段'" /></td>
				<td><form:input path="y_jlr" class="easyui-numberbox" precision="2" data-options="required:true,missingMessage:'必填字段'" /></td>
			</tr>
		</table>
	</form:form>
</div>
<div id="dlg-buttons" style="text-align: center;">
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveFormData('newProfit',false,'/finace/report/profit/saveProfit.html',false)">保存</a> <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
		onclick="javascript:$('#win_newProfit').window('close')">取消</a>
</div>