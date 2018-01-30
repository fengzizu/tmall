<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
<%-- <jsp:include page="header.jsp" /> --%><!-- 这个jsp页面标签无法将头部的商品分类动态包含进来下面这个可以； -->
<jsp:include page="/WishListServlet" />
<center>
			<form id="formid" action="${pageContext.request.contextPath}/" method="post">
				<table border="1px" >
					
					<caption style="color: red; font-size: 1cm;">欢迎来到购物车</caption>
					<tr height="10px">
						<th>商品名称</th>
						<th>商品单价</th>
						<th>商品数量</th>
						<th>商品小计</th>
						<th>操作商品</th>
					</tr>
					<c:forEach items="${cart.cartItem}" var="cartItem">
					
				
					<tr >
						<td width="30px"><input type="text"  name="pname" value="${cartItem.product.pname}"  readonly="readonly"/> </td>
						<td> <input type="text"  name="price" value="${cartItem.product.price}" readonly="readonly"/></td>
						<td> <input type="text"  name="count"  value="${cartItem.count}" readonly="readonly"/></td>
						<td> <input type="text"  name="subtotal" value="${cartItem.subtotal}" readonly="readonly"/></td>
						<td width="40px">
							<a href="/cart/removeCart.action">删除商品</a>
						</td>
						<td><input type="hidden" name="pid" value="${cartItem.product.pid}"/></td>
						
					</tr>
						</c:forEach>

					<tr >
						<td colspan="2">总价为：<input type="text" name="total"  value="${cart.total }" size="4" readonly="readonly"/></td>
						<td colspan="2"><a href="/cart/clearCart.action">清空购物车</a></td>
						<td ><a href="${pageContext.request.contextPath }/buildorder.action">生成订单</a></td>
					</tr>

					<tr></tr>

				</table>

			</form>

		</center>
<!--  
<jsp:include page="/footer.jsp" />
-->
</body>
</html>