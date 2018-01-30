<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的订单</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<title>Home</title>
		<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
			media="all" />
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="js/jquery.min.js"></script>
		<!-- Custom Theme files -->
		<!--theme-style-->
		<link href="css/style.css" rel="stylesheet" type="text/css"
			media="all" />
		<!--//theme-style-->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="" />
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		<!--fonts-->
		<link
			href='https://fonts.googleapis.com/css?family=Exo:100,200,300,400,500,600,700,800,900'
			rel='stylesheet' type='text/css'>
		<!--//fonts-->
		<script type="text/javascript" src="js/move-top.js"></script>
		<script type="text/javascript" src="js/easing.js"></script>
		<script type="text/javascript">
					jQuery(document).ready(function($) {
						$(".scroll").click(function(event){		
							event.preventDefault();
							$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
						});
					});
				</script>
		<!--slider-script-->
		<script src="js/responsiveslides.min.js"></script>
		<script>
				$(function () {
				  $("#slider1").responsiveSlides({
					auto: true,
					speed: 500,
					namespace: "callbacks",
					pager: true,
				  });
				});
			</script>
		<!--//slider-script-->
		<script>$(document).ready(function(c) {
	$('.alert-close').on('click', function(c){
		$('.message').fadeOut('slow', function(c){
	  		$('.message').remove();
		});
	});	  
});
</script>
		<script>$(document).ready(function(c) {
	$('.alert-close1').on('click', function(c){
		$('.message1').fadeOut('slow', function(c){
	  		$('.message1').remove();
		});
	});	  
});
</script>
</head>

<body >
<jsp:include page="/WishListServlet" />
<div >
<br>
<center>我的订单</center>
<br>
</div>
<br>
<div >
<center>
<table border="1" width="1000" height="50">	
	<tr>
		<th>订单编号</th>
		<th>订单时间</th>
		<th>订单金额</th>
		<th>订单状态</th>
		<th>收货人姓名</th>
		<th>收货地址</th>
		<th>联系电话</th>
	</tr>
	
	<!-- foreach开始 -->
	<c:forEach items="${orderList}" var="order">
	
	<tr>
		<td><c:out value="${order.oid }"></c:out></td>
		<td><c:out value="${order.time}"></c:out></td>
		<td><c:out value="${order.total}"></c:out></td>
		<td><c:out value="${order.state}"></c:out></td>
		<td><c:out value="${order.cname}"></c:out></td>
		<td><c:out value="${order.address}"></c:out></td>
		<td><c:out value="${order.phone}"></c:out></td>
	</tr>
	
	</c:forEach>
	<!-- foreach结束 -->
	
</table>
</center>
</div>
<br>
<jsp:include page="footer.jsp" />
</body>

</html>