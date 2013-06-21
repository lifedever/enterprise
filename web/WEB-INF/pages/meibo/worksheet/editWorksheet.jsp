<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../common/tag.jsp"%>
<div style="font-size: 14px;" id="print">
	<h1 style="margin-left: 20px;">
		<c:choose>
			<c:when test="${worksheet.isProof eq 0}">产品制作明细</c:when>
			<c:otherwise>样品制作明细</c:otherwise>
		</c:choose>
	</h1>
	<form id="fm_viewWorksheet">
		<input type="hidden" value="${worksheet.id }" name="id"/>
		<div style="text-align: right; margin-right: 20px; font-size: 14px; font-weight: bold; margin-bottom: 10px;">北京美博雅克丽工贸有限公司</div>
		<table style="border-collapse: collapse; margin-left: 20px; border-width: 0px;" border="1" width="95%">
			<tr>
				<td style="border-width: 0px;padding-bottom: 8px;" width="50%"><strong>名称：</strong><input type="text" value="${worksheet.productName }" name="productName"  style="width: 200px;"/></td>
				<td style="border-width: 0px;padding-bottom: 8px;" width="50%"><strong>编号：</strong><input type="text"
				value="${worksheet.productNo }" style="width: 200px;" name="productNo"/></td>
			</tr>
			<tr>
				<td style="border-width: 0px;padding-bottom: 8px;"><strong>规格：</strong><input type="text"
				value="${worksheet.contourSize }" style="width: 200px;" name="contourSize"/></td>
				<td style="border-width: 0px;padding-bottom: 8px;"><strong>数量：</strong><input type="text"
				value="${worksheet.productCount }" style="width: 200px;" name="productCount"/></td>
			</tr>
			<tr>
				<td style="vertical-align: top;"><strong>工程图：</strong>
					<div style="text-align: center;">
						<img style="max-width: 240px; max-height: 240px;" src="${worksheet.projectImage }" />
						<input type="hidden"  name="projectImage" value="${worksheet.projectImage }"/>
					</div>
				</td>
				<td style="vertical-align: top;"><strong>效果图：</strong>
					<div style="text-align: center;">
						<img style="max-width: 240px; max-height: 240px;" src="${worksheet.effectImage }" />
						<input type="hidden"  name="effectImage" value="${worksheet.effectImage }"/>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<table width="100%" border="1" style="border-collapse: collapse;">
						<c:forEach items="${classifies }" var="classify">
							<tr>
								<td width="20%"><strong>${classify }</strong></td>
								<td>
									<table border="1" style="border-collapse: collapse;" width="100%">
										<tr style="background-color: #ADFEDC">
											<td>名称</td>
											<td>规格</td>
											<td>数量</td>
											<td>颜色</td>
											<td>厚度</td>
											<td>备注</td>
										</tr>
										<c:forEach items="${materMap[classify] }" var="material">
											<tr>
												<td>${material.name }</td>
												<td>${material.standard }</td>
												<td>${material.count }</td>
												<td>${material.color }</td>
												<td>${material.thickness }</td>
												<td>${material.remark }</td>
											</tr>
										</c:forEach>
									</table>
								</td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="border-width: 0px;padding-bottom: 8px;padding-top: 8px;"><strong>工艺：</strong></td>
			</tr>
			<tr>
				<td colspan="2" style="border-width: 0px;">
					<input type="checkbox"  name="craftwork" value="开料"/>开料
					<input type="checkbox"  name="craftwork" value="修边"/>修边
					<input type="checkbox"  name="craftwork" value="车床"/>车床
					<input type="checkbox"  name="craftwork" value="刨"/>刨
					<input type="checkbox"  name="craftwork" value="铣床"/>铣床
					<input type="checkbox"  name="craftwork" value="钻床"/>钻床
					<input type="checkbox"  name="craftwork" value="热弯"/>热弯
					<input type="checkbox"  name="craftwork" value="抛光"/>抛光
				</td>
			</tr>
			<tr>
				<td colspan="2" style="border-width: 0px;">
					<input type="checkbox" name="craftwork" value="雕刻"/>雕刻
					<input type="checkbox" name="craftwork" value="粘接"/>粘接
					<input type="checkbox" name="craftwork" value="丝印"/>丝印
					<input type="checkbox" name="craftwork" value="模具"/>模具
					<input type="checkbox" name="craftwork" value="喷油"/>喷油
					<input type="checkbox" name="craftwork" value="喷砂"/>喷砂
					<input type="checkbox" name="craftwork" value="热压"/>热压
				</td>
			</tr>
			<tr>
				<td colspan="2" style="border-width: 0px;padding-bottom: 8px;padding-top: 8px;"><strong>加工时间：</strong></td>
			</tr>
			<tr>
				<td colspan="2" style="border-width: 0px;">
				<input type="text" id="startDate" name="startDate" readonly="readonly" onclick="WdatePicker({startDate:'%y年%M月01日00时',dateFmt:'yyyy年MM月dd日HH时',alwaysUseStartDate:true});" value="<fmt:formatDate value="${worksheet.startDate}" pattern="yyyy年MM月dd日00时" />"/>
				至<input type="text" id="endDate"  name="endDate" readonly="readonly" onclick="WdatePicker({startDate:'%y年%M月01日00时',dateFmt:'yyyy年MM月dd日HH时',alwaysUseStartDate:true});" value="<fmt:formatDate value="${worksheet.endDate}" pattern="yyyy年MM月dd日00时" />"/>，共计<input type="text" readonly="readonly" id="realUse"/>
			</td>
			</tr>
			<tr>
				<td colspan="2" style="border-width: 0px;padding-bottom: 8px;" align="right">
					制作人签名：<u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u>
				</td>
			</tr>
		</table>
	</form>
</div>
<div id="dlg-buttons" style="text-align: center; margin-top: 20px;">
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok"
		onclick="saveFormData('viewWorksheet',false,'/meibo/worksheet/saveWorksheet.html',saveSuccess)">保存</a> 
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
		onclick="javascript:$('#win_viewWorksheet').window('close')">取消</a>
</div>
<script type="text/javascript">
	(function(){
		var craftworks = $("input[name='craftwork']");
		for(var i=0;i<craftworks.length;i++){
			if('${worksheet.craftwork}'.indexOf(craftworks[i].value) >= 0 ){
				craftworks[i].checked=true;
			}
		}
		
		//
		//2013年02月13日21时
		var $startDate = $('#startDate').val();
		var s_y=$startDate.substr(0,4);
		var s_m=$startDate.substr(5,2);
		var s_d=$startDate.substr(8,2);
		var s_h=$startDate.substr(11,2);
		
		var $endDate = $('#endDate').val();
		var e_y=$endDate.substr(0,4);
		var e_m=$endDate.substr(5,2);
		var e_d=$endDate.substr(8,2);
		var e_h=$endDate.substr(11,2);
		
		var begintime_ms = new Date(s_y+'/'+s_m+'/'+s_d+' '+s_h+':00:00').getTime(); //begintime 为开始时间
		var endtime_ms = new Date(e_y+'/'+e_m+'/'+e_d+' '+e_h+':00:00').getTime();   // endtime 为结束时间
		var date_ms = endtime_ms-begintime_ms;
		//计算出相差天数
		var days=Math.floor(date_ms/(24*3600*1000))
		//计算出小时数
		var leave1=date_ms%(24*3600*1000)    //计算天数后剩余的毫秒数
		var hours=Math.floor(leave1/(3600*1000))
		
		$('#realUse').val(days+'天'+hours+'小时');
	})();
	function beforeSave(){
		return false;
	}
	function saveSuccess(data){
		if(data){
			$.messager.alert('提示信息', '操作成功！');
			$('#win_viewWorksheet').window('close')
			$('#tt_worksheet').datagrid('reload');
		}else{
			$.messager.alert('提示信息', '操作失败！');
		}
	}
</script>