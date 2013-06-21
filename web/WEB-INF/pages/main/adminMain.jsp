<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>${title }</title>
<link href="/charisma-master/css/bootstrap-cerulean.css" rel="stylesheet">
<style type="text/css">
</style>
<link href="/charisma-master/css/bootstrap-responsive.css" rel="stylesheet">
<link href="/charisma-master/css/charisma-app.css" rel="stylesheet">
<link href='/charisma-master/css/jquery.noty.css' rel='stylesheet'>
<link href='/charisma-master/css/opa-icons.css' rel='stylesheet'>

<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
		<script src="/js/html5.js"></script>
		<![endif]-->
<!-- The fav icon -->
<jsp:include page="../common/css.jsp"></jsp:include>
<jsp:include page="../common/js.jsp"></jsp:include>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div id="content" class="span12">
				<div class="sortable row-fluid">
					<div class="box span12">
						<div class="box-header well">
							<h2>
								<i class="icon-info-sign"></i>信息总览
							</h2>
						</div>
						<div class="box-content">
							<a data-rel="tooltip" title="最近三个月新来员工数：${empCount[1] }." class="well span3 top-block" href="#"> <span
								class="icon32 icon-red icon-user"></span>
								<div>员工总数</div>
								<div>${empCount[0] }</div> 
								<span class="notification">${empCount[1] }</span>
							</a> 
							<a data-rel="tooltip" title="最近三个月新增客户数：${customerCount[1] }." class="well span3 top-block" href="#"> <span
								class="icon32 icon-blue icon-user"></span>
								<div>客户总数</div>
								<div>${customerCount[0] }</div> 
								<span class="notification">${customerCount[1] }</span>
							</a> 
							<a data-rel="tooltip" title="$34 new sales." class="well span3 top-block" href="#"> 
								<span class="icon32 icon-color icon-cart"></span>
								<div>出售额</div>
								<div>$${sales[0] }</div> 
								<span class="notification yellow">$${sales[1] }</span>
							</a> 
							<a data-rel="tooltip" title="${msgArr[1] }条新消息." class="well span3 top-block" href="javascript:showWin()"> 
								<span class="icon32 icon-color icon-envelope-closed"></span>
								<div>消息</div>
								<div>${msgArr[0] }</div> <span class="notification red">${msgArr[1] }</span>
							</a>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<div class="row-fluid sortable">
					<div class="box span4">
						<div class="box-header well">
							<h2>
								<i class="icon-heart"></i> 温馨提示
							</h2>
						</div>
						<div class="box-content">
							<h3>面板说明</h3>
							<p>	本页面板给出了系统运营期间的大致信息，
								用户可以通过本页了解到客户状态和产品销售状态，
								如果想查看详细记录，
								请进入具体功能模块查看具体情况
							</p>
							<p>
								<span style="color: red;">注：</span>
								<span style="color: blue;">
									本页面只有系统管理员可见！如需更改，请联系开发人员。
								</span>
							</p>	
						</div>
					</div>
					<!--/span-->
					<div class="box span4">
						<div class="box-header well">
							<h2>
								<i class="icon-user"></i> 活跃顾客
							</h2>
						</div>
						<div class="box-content">
							<div class="box-content">
								<ul class="dashboard-list">
									<c:forEach items="${customers }" var="cus">
										<li>
											<a href="javascript:viewCustomer('${cus.id }')"> 
												<img  class="dashboard-avatar" alt="头像">
											</a> 
											<strong>姓名:</strong>
											<a href="javascript:viewCustomer('${cus.id }')"> 
												${cus.customerName } 
											</a> <br> 
											<strong>上次询价日期:</strong>
												<fmt:formatDate value="${cus.visitTime}" pattern="yyyy年MM月dd日" /> <br> 
											<strong>身份:</strong>
											<span class="label label-success">普通客户</span>
										</li>
									</c:forEach>
								</ul>
							</div>
						</div>
					</div>
					<!--/span-->

					<div class="box span4">
						<div class="box-header well" data-original-title>
							<h2>
								<i class="icon-list"></i> 热销商品
							</h2>
						</div>
						<div class="box-content">
							<ul class="dashboard-list">
								<c:forEach items="${hotList }" var="hot" varStatus="i">
									<li>
										<a href="#"> 
											<c:choose>
												<c:when test="${i.index eq 0 }">
													<i class="icon-arrow-up"></i> 
													<span class="red">${hot[0] }</span> 
													${hot[1] }
												</c:when>
												<c:when test="${i.index eq 1 }">
													<i class="icon-arrow-up"></i> 
													<span class="yellow">${hot[0] }</span> 
													${hot[1] }
												</c:when>
												<c:when test="${i.index eq 2 }">
													<i class="icon-arrow-up"></i> 
													<span class="blue">${hot[0] }</span> 
													${hot[1] }
												</c:when>
												<c:otherwise>
													<i class="icon-arrow-up"></i> 
													<span class="green">${hot[0] }</span> 
													${hot[1] }
												</c:otherwise>
											</c:choose>
										</a>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
					<!--/span-->
				</div>
				<!-- content ends -->
			</div>
			<!--/#content.span10-->
		</div>
		<!--/fluid-row-->
		<hr>
		<footer>
			<p class="pull-left">
				&copy; <a href="#">北京美博雅克丽工贸有限公司</a> 2012
			</p>
			<p class="pull-right">
				Powered by: <a href="http://www.wincn.net" target="_blank">wincn开发网</a>
			</p>
		</footer>
	</div>
	<div class="easyui-window" id="win_viewCustomer" data-options="title:'查看客戶信息',closed:true,modal:true,iconCls:'icon-save',cache:false" style="width: 700px; height: 370px; padding: 10px;"></div>
	
	<script type="text/javascript">
		(function(){
			var avatars = $('.dashboard-avatar');
			for(var i=0;i<avatars.length;i++){
				avatars[i].src='/charisma-master/img/gallery/thumbs/'+(Math.floor(Math.random()*10)+1)+'.jpg';
			}
		})();
		
		//查看客户
		function viewCustomer(customerId){
			$('#win_viewCustomer').window({
				href : '/meibo/customer/viewCustomer.html?customerId='+customerId
			}).window('open');
		}
	</script>
</body>
<jsp:include page="../main/footer.jsp"></jsp:include>
</html>