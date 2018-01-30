<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'plist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <div class="container">
			<div class="content">
				<div class="content-top">
					<h3 class="future">
						FEATURED
					</h3>
					<div class="content-top-in">
						
						<c:forEach items="${list }" var="product">
						
						<div class="col-md-3 md-col">
							<div class="col-md">
								<a href="${pageContext.request.contextPath}/LookProductDetail?pid=${product.pid}"><img src="${product.pimage }" alt="" /> </a>
								<div class="top-content">
									<h5>
										<a href="single.jsp">${product.pname}</a>
									</h5>
									<div class="white">
										<a href="single.jsp" 
											class="hvr-shutter-in-vertical hvr-shutter-in-vertical2 ">ADD
											TO CART</a>
										<p class="dollar">
											<span class="in-dollar">￥</span><span>${product.price}</span>
										</p>
										<div class="clearfix"></div> 
									</div>
								</div>
							</div>
						</div>
						
						</c:forEach>
						
						
						<!--<div class="col-md-3 md-col">
							<div class="col-md">
								<a href="single.html"><img src="images/pi1.jpg" alt="" /> </a>

								<div class="top-content">
									<h5>
										<a href="single.html">Bite Me</a>
									</h5>
									<div class="white">
										<a href="single.html"
											class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">ADD
											TO CART</a>
										<p class="dollar">
											<span class="in-dollar">$</span><span>3</span><span>0</span>
										</p>
										<div class="clearfix"></div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-3 md-col">
							<div class="col-md">
								<a href="single.html"><img src="images/pi2.jpg" alt="" /> </a>
								<div class="top-content">
									<h5>
										<a href="single.html">Little Fella</a>
									</h5>
									<div class="white">
										<a href="single.html"
											class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">ADD
											TO CART</a>
										<p class="dollar">
											<span class="in-dollar">$</span><span>5</span><span>0</span>
										</p>
										<div class="clearfix"></div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-3 md-col">
							<div class="col-md">
								<a href="single.html"><img src="images/pi3.jpg" alt="" /> </a>
								<div class="top-content">
									<h5>
										<a href="single.html">Astral Cruise</a>
									</h5>
									<div class="white">
										<a href="single.html"
											class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">ADD
											TO CART</a>
										<p class="dollar">
											<span class="in-dollar">$</span><span>4</span><span>5</span>
										</p>
										<div class="clearfix"></div>
									</div>
								</div>
							</div>
						</div>-->
						
						<div class="clearfix"></div>
					</div>
				</div>
				<!---->
			</div>
			
			<!-- page number -->
			<dir>
			<ul class="start">
				<li>
					<a href="#"><i></i> </a>
				</li>
				<li>
					<span>1</span>
				</li>
				<li class="arrow">
					<a href="#">2</a>
				</li>
				<li class="arrow">
					<a href="#">3</a>
				</li>
				<li class="arrow">
					<a href="#">4</a>
				</li>
				<li class="arrow">
					<a href="#">5</a>
				</li>
				<li>
					<a href="#"><i class="next"> </i> </a>
				</li>
			</ul>
			</div>
			
  </body>
</html>
