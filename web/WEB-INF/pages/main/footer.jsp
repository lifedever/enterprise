<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/tag.jsp"%>
<jsp:include page="../message/messageCenter.jsp"></jsp:include>
<jsp:include page="modifyPass.jsp"></jsp:include>
<footer>
	<div id="player"></div>
	<script type="text/javascript">
		var msgLen = '${fn:length(sessionScope.messages)}';
		if (msgLen > 0) {
			window
					.setTimeout(
							function() {
								//Player.controls.play();
								
								$('#player').html('<audio class="player" src="/sound/Sent.wav" autoplay="autoplay">Your browser does not support the audio element.</audio>');
								$.messager
										.show({
											title : '温馨提示',
											msg : '<img src="/images/icon/msg.gif"/>&nbsp;&nbsp;您有'
													+ msgLen
													+ '条未处理的消息，请<a href="#" onclick="showNoReadWin()"><strong>查看详情</strong></a>！',
											timeout : 5000,
											showType : 'slide'
										});
							}, 2000);
		}
		function logout() {
			$.messager.confirm('警告', '你确定要离开系统吗?', function(r) {
				if (r) {
					top.location.href = "/login/logout.html";
				}
			});
		}
	</script>
</footer>