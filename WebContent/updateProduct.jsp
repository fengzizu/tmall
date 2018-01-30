<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>update product</title>
</head>
<body>

<center>
	<br>
		Welcome to the update product page!
	<br><br>
		<table border="1" width="800" height="70">
		<form name="updateProduct" method="POST" action="UpdateProductServlet">
		<tr>
				<th></th>
				<th>商品名</th>
				<th>售价</th>
				<th>进价</th>
				<th>描述</th>
				<th>类别号</th>
				<th>品牌</th>
				<th>颜色</th>
				<th>尺寸</th>
				<th>质量</th>
			</tr>
			<c:forEach items="${requestScope.productList }" var="product">
			<tr>
				<td><input type="hidden" name="pid" value="${product.pid }" size=5></td>
				<td><input type="text" name="pname" value="${product.pname }" size=15></td>
				<td><input type="text" name="price" value="${product.price }" size=5></td>
				<td><input type="text" name="purchasePrice" value="${product.purchasePrice }" size=5></td>
				<td><input type="text" name="pdescribe" value="${product.pdescribe }" size=25></td>
				<td><input type="text" name="categoryId" value="${product.categoryid }" size=5></td>
				<td><input type="text" name="brand" value="${product.brand }" size=8></td>
				<td><input type="text" name="color" value="${product.color }"></td>
				<td><input type="text" name="size" value="${product.size }"></td>
				<td><input type="text" name="quality" value="${product.quality }"></td>
			</tr>
			</c:forEach>
			</from>
</table>
	<br>
	<br>
		<input type="button" value="return" onclick="window.location.href='productsmanage.action'" style="height:45px;width:100px;font-size:16px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		<input type="submit" value="update"  style="height:45px;width:100px;font-size:16px">
</center>
</body>
</html>