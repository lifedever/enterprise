<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../common/tag.jsp"%>
<style type="text/css">
	input{
		border: 0px;
	}
</style>
<div>
	<form:form action="" method="post" commandName="asserts" id="fm_newAsserts">
		<form:input path="id" cssStyle="display:none" />
		<table width="90%" border="1" style="border-collapse: collapse;">
			<tr>
				<td>资产</td>
				<td>年末余额</td>
				<td>年初余额</td>
				<td>负债和股东权益</td>
				<td>年末余额</td>
				<td>年初余额</td>
			</tr>
			<tr>
				<td>流动资产</td>
				<td><form:input path="asserts_a.c2r1" style="width:100px;"/></td>
				<td><form:input path="asserts_a.c3r1" style="width:100px;"/></td>
				<td>流动负债</td>
				<td><form:input path="asserts_b.c2r1" style="width:100px;"/></td>
				<td><form:input path="asserts_b.c3r1" style="width:100px;"/></td>
			</tr>
			<tr>
				<td>货币资金</td>
				<td><form:input path="asserts_a.c2r2" style="width:100px;"/></td>
				<td><form:input path="asserts_a.c3r2" style="width:100px;"/></td>
				<td>短期借款</td>
				<td><form:input path="asserts_b.c2r2" style="width:100px;"/></td>
				<td><form:input path="asserts_b.c3r2" style="width:100px;"/></td>
			</tr>
			<tr>
				<td>交易性金融资产</td>
				<td><form:input path="asserts_a.c2r3" style="width:100px;"/></td>
				<td><form:input path="asserts_a.c3r3" style="width:100px;"/></td>
				<td>交易性金融负债</td>
				<td><form:input path="asserts_b.c2r3" style="width:100px;"/></td>
				<td><form:input path="asserts_b.c3r3" style="width:100px;"/></td>
			</tr>
			<tr>
				<td>应收票据</td>
				<td><form:input path="asserts_a.c2r4" style="width:100px;"/></td>
				<td><form:input path="asserts_a.c3r4" style="width:100px;"/></td>
				<td>应付票据</td>
				<td><form:input path="asserts_b.c2r4" style="width:100px;"/></td>
				<td><form:input path="asserts_b.c3r4" style="width:100px;"/></td>
			</tr>
			<tr>
				<td>应收账款</td>
				<td><form:input path="asserts_a.c2r5" style="width:100px;"/></td>
				<td><form:input path="asserts_a.c3r5" style="width:100px;"/></td>
				<td>应付账款</td>
				<td><form:input path="asserts_b.c3r5" style="width:100px;"/></td>
				<td><form:input path="asserts_b.c3r5" style="width:100px;"/></td>
			</tr>
			<tr>
				<td>预付款项</td>
				<td><form:input path="asserts_a.c2r6" style="width:100px;"/></td>
				<td><form:input path="asserts_a.c3r6" style="width:100px;"/></td>
				<td>预收款项</td>
				<td><form:input path="asserts_b.c2r6" style="width:100px;"/></td>
				<td><form:input path="asserts_b.c3r6" style="width:100px;"/></td>
			</tr>
			<tr>
				<td>应收利息</td>
				<td><form:input path="asserts_a.c2r7" style="width:100px;"/></td>
				<td><form:input path="asserts_a.c3r7" style="width:100px;"/></td>
				<td>应付职工薪酬</td>
				<td><form:input path="asserts_b.c2r7" style="width:100px;"/></td>
				<td><form:input path="asserts_b.c3r7" style="width:100px;"/></td>
			</tr>
			<tr>
				<td>应收股利</td>
				<td><form:input path="asserts_a.c2r8" style="width:100px;"/></td>
				<td><form:input path="asserts_a.c3r8" style="width:100px;"/></td>
				<td>应交税费</td>
				<td><form:input path="asserts_b.c2r8" style="width:100px;"/></td>
				<td><form:input path="asserts_b.c3r8" style="width:100px;"/></td>
			</tr>
			<tr>
				<td>其他应收款</td>
				<td><form:input path="asserts_a.c2r9" style="width:100px;"/></td>
				<td><form:input path="asserts_a.c3r9" style="width:100px;"/></td>
				<td>应付利息</td>
				<td><form:input path="asserts_b.c2r9" style="width:100px;"/></td>
				<td><form:input path="asserts_b.c3r9" style="width:100px;"/></td>
			</tr>
			<tr>
				<td>存款</td>
				<td><form:input path="asserts_a.c2r10" style="width:100px;"/></td>
				<td><form:input path="asserts_a.c3r10" style="width:100px;"/></td>
				<td>应付股利</td>
				<td><form:input path="asserts_b.c2r10" style="width:100px;"/></td>
				<td><form:input path="asserts_b.c3r10" style="width:100px;"/></td>
			</tr>
			<tr>
				<td>一年内到期的非流动资产</td>
				<td><form:input path="asserts_a.c2r11" style="width:100px;"/></td>
				<td><form:input path="asserts_a.c3r11" style="width:100px;"/></td>
				<td>其他应付款</td>
				<td><form:input path="asserts_b.c2r11" style="width:100px;"/></td>
				<td><form:input path="asserts_b.c3r11" style="width:100px;"/></td>
			</tr>
			<tr>
				<td>其他流动资产</td>
				<td><form:input path="asserts_a.c2r12" style="width:100px;"/></td>
				<td><form:input path="asserts_a.c3r12" style="width:100px;"/></td>
				<td>一年内到期的非流动负债</td>
				<td><form:input path="asserts_b.c2r12" style="width:100px;"/></td>
				<td><form:input path="asserts_b.c3r12" style="width:100px;"/></td>
			</tr>
			<tr>
				<td>流动资产合计</td>
				<td><form:input path="asserts_a.c2r13" style="width:100px;"/></td>
				<td><form:input path="asserts_a.c3r13" style="width:100px;"/></td>
				<td>其他流动负债</td>
				<td><form:input path="asserts_b.c2r13" style="width:100px;"/></td>
				<td><form:input path="asserts_b.c3r13" style="width:100px;"/></td>
			</tr>
			<tr>
				<td>其中：非流动资产处理损失</td>
				<td><form:input path="asserts_a.c2r14" style="width:100px;"/></td>
				<td><form:input path="asserts_a.c3r14" style="width:100px;"/></td>
				<td>流动负债合计</td>
				<td><form:input path="asserts_b.c2r14" style="width:100px;"/></td>
				<td><form:input path="asserts_b.c3r14" style="width:100px;"/></td>
			</tr>
			<tr>
				<td>可供出售金融资产</td>
				<td><form:input path="asserts_a.c2r15" style="width:100px;"/></td>
				<td><form:input path="asserts_a.c3r15" style="width:100px;"/></td>
				<td>非流动负债</td>
				<td><form:input path="asserts_b.c2r15" style="width:100px;"/></td>
				<td><form:input path="asserts_b.c3r15" style="width:100px;"/></td>
			</tr>
			<tr>
				<td>持有至到期投资</td>
				<td><form:input path="asserts_a.c2r16" style="width:100px;"/></td>
				<td><form:input path="asserts_a.c3r16" style="width:100px;"/></td>
				<td>长期借款</td>
				<td><form:input path="asserts_b.c2r16" style="width:100px;"/></td>
				<td><form:input path="asserts_b.c3r16" style="width:100px;"/></td>
			</tr>
			<tr>
				<td>长期应收款</td>
				<td><form:input path="asserts_a.c2r17" style="width:100px;"/></td>
				<td><form:input path="asserts_a.c3r17" style="width:100px;"/></td>
				<td>应付债券</td>
				<td><form:input path="asserts_b.c2r17" style="width:100px;"/></td>
				<td><form:input path="asserts_b.c3r17" style="width:100px;"/></td>
			</tr>
			<tr>
				<td>长期股权投资</td>
				<td><form:input path="asserts_a.c2r18" style="width:100px;"/></td>
				<td><form:input path="asserts_a.c3r18" style="width:100px;"/></td>
				<td>长期应付款</td>
				<td><form:input path="asserts_b.c2r18" style="width:100px;"/></td>
				<td><form:input path="asserts_b.c3r18" style="width:100px;"/></td>
			</tr>
			<tr>
				<td>投资性房地产</td>
				<td><form:input path="asserts_a.c2r19" style="width:100px;"/></td>
				<td><form:input path="asserts_a.c3r19" style="width:100px;"/></td>
				<td>专项应付款</td>
				<td><form:input path="asserts_b.c2r19" style="width:100px;"/></td>
				<td><form:input path="asserts_b.c3r19" style="width:100px;"/></td>
			</tr>
			<tr>
				<td>固定资产</td>
				<td><form:input path="asserts_a.c2r20" style="width:100px;"/></td>
				<td><form:input path="asserts_a.c3r20" style="width:100px;"/></td>
				<td>预计负债</td>
				<td><form:input path="asserts_b.c2r20" style="width:100px;"/></td>
				<td><form:input path="asserts_b.c3r20" style="width:100px;"/></td>
			</tr>
			<tr>
				<td>在建工程</td>
				<td><form:input path="asserts_a.c2r21" style="width:100px;"/></td>
				<td><form:input path="asserts_a.c3r21" style="width:100px;"/></td>
				<td>递延所得税负债</td>
				<td><form:input path="asserts_b.c2r21" style="width:100px;"/></td>
				<td><form:input path="asserts_b.c3r21" style="width:100px;"/></td>
			</tr>
			<tr>
				<td>固定资产清理</td>
				<td><form:input path="asserts_a.c2r22" style="width:100px;"/></td>
				<td><form:input path="asserts_a.c3r22" style="width:100px;"/></td>
				<td>非流动负债合计</td>
				<td><form:input path="asserts_b.c2r22" style="width:100px;"/></td>
				<td><form:input path="asserts_b.c3r22" style="width:100px;"/></td>
			</tr>
			<tr>
				<td>生产性生物资产</td>
				<td><form:input path="asserts_a.c2r23" style="width:100px;"/></td>
				<td><form:input path="asserts_a.c3r23" style="width:100px;"/></td>
				<td>负债合计</td>
				<td><form:input path="asserts_b.c2r23" style="width:100px;"/></td>
				<td><form:input path="asserts_b.c3r23" style="width:100px;"/></td>
			</tr>
			<tr>
				<td>油气资产</td>
				<td><form:input path="asserts_a.c2r24" style="width:100px;"/></td>
				<td><form:input path="asserts_a.c3r24" style="width:100px;"/></td>
				<td>所有者权益</td>
				<td><form:input path="asserts_b.c2r24" style="width:100px;"/></td>
				<td><form:input path="asserts_b.c3r24" style="width:100px;"/></td>
			</tr>
			<tr>
				<td>无形资产</td>
				<td><form:input path="asserts_a.c2r25" style="width:100px;"/></td>
				<td><form:input path="asserts_a.c3r25" style="width:100px;"/></td>
				<td>实收资本</td>
				<td><form:input path="asserts_b.c2r25" style="width:100px;"/></td>
				<td><form:input path="asserts_b.c3r25" style="width:100px;"/></td>
			</tr>
			<tr>
				<td>开发支出</td>
				<td><form:input path="asserts_a.c2r26" style="width:100px;"/></td>
				<td><form:input path="asserts_a.c3r26" style="width:100px;"/></td>
				<td>资本公积</td>
				<td><form:input path="asserts_b.c2r26" style="width:100px;"/></td>
				<td><form:input path="asserts_b.c3r26" style="width:100px;"/></td>
			</tr>
			<tr>
				<td>商誉</td>
				<td><form:input path="asserts_a.c2r27" style="width:100px;"/></td>
				<td><form:input path="asserts_a.c3r27" style="width:100px;"/></td>
				<td>减：库存股</td>
				<td><form:input path="asserts_b.c2r27" style="width:100px;"/></td>
				<td><form:input path="asserts_b.c3r27" style="width:100px;"/></td>
			</tr>
			<tr>
				<td>长期待摊费用</td>
				<td><form:input path="asserts_a.c2r28" style="width:100px;"/></td>
				<td><form:input path="asserts_a.c3r28" style="width:100px;"/></td>
				<td>盈余公积</td>
				<td><form:input path="asserts_b.c2r28" style="width:100px;"/></td>
				<td><form:input path="asserts_b.c3r28" style="width:100px;"/></td>
			</tr>
			<tr>
				<td>递延所得税资产</td>
				<td><form:input path="asserts_a.c2r29" style="width:100px;"/></td>
				<td><form:input path="asserts_a.c3r29" style="width:100px;"/></td>
				<td>未分配利润</td>
				<td><form:input path="asserts_b.c2r29" style="width:100px;"/></td>
				<td><form:input path="asserts_b.c3r29" style="width:100px;"/></td>
			</tr>
			<tr>
				<td>其他非流动资产</td>
				<td><form:input path="asserts_a.c2r30" style="width:100px;"/></td>
				<td><form:input path="asserts_a.c3r30" style="width:100px;"/></td>
				<td>所有者权益合计</td>
				<td><form:input path="asserts_b.c2r30" style="width:100px;"/></td>
				<td><form:input path="asserts_b.c3r30" style="width:100px;"/></td>
			</tr>
			<tr>
				<td>非流动资产合计</td>
				<td><form:input path="asserts_a.c2r31" style="width:100px;"/></td>
				<td><form:input path="asserts_a.c3r31" style="width:100px;"/></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>资产总计</td>
				<td><form:input path="asserts_a.c2r32" style="width:100px;"/></td>
				<td><form:input path="asserts_a.c3r32" style="width:100px;"/></td>
				<td>负债和所有者权益合计</td>
				<td><form:input path="asserts_b.c2r31" style="width:100px;"/></td>
				<td><form:input path="asserts_b.c3r31" style="width:100px;"/></td>
			</tr>
		</table>
	</form:form>
</div>
<div id="dlg-buttons" style="text-align: center;margin-top: 20px;">
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveFormData('newAsserts',false,'/finace/report/asserts/saveAsserts.html',false)">保存</a> 
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
		onclick="javascript:$('#win_newAsserts').window('close')">取消</a>
</div>