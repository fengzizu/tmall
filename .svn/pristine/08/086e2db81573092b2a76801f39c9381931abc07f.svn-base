<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Products Manage</title>

<script>
		var globalObject;
		var httpRequest = false;
		function deleteRow(nodeObject,pid){

			globalObject = nodeObject;
			/*尝试创建XMLHttpRequest对象*/
			try {
				httpRequest = new XMLHttpRequest();	
			} catch (failed) {
				httpRequest = false;
			}
			 
			/*判断XMLHttpRequest对象是否创建成功，如果创建成功,则执行异步请求*/
			if(httpRequest instanceof Object){
				
				/*1.构建向服务器端发送请求的url*/
				var url="DeleteProductServlet?pid=" + pid;
				
				/*2.调用XMLHttpRequest对象的方法，与数据库建立连接*/
				httpRequest.open("GET",url,true);
				
				/*3.设置监听函数*/
				httpRequest.onreadystatechange = serverListener;
				
				/*4.向服务器发送请求*/
				httpRequest.send(null);
				 
			}
		}	
		
		/**
		 *监听服务器处理完客户端的请求的响应状态信息
		 */ 
		function serverListener(){
			/*如果服务器已经处理完请求，并且向浏览器做出响应时*/
			if(httpRequest.readyState == 4){
				 
				/*如果响应的状态码时200，则代表时正确的响应*/
				if(httpRequest.status == 200){
					
					/*开始处理页面元素，通过JavaScript将表格的指定一行进行删除操作*/
					var table=document.getElementById("productsTable");
					var rowPid=globalObject.parentNode.parentNode.rowIndex;
					
					alert("rowPid is : "+rowPid);
					
					table.deleteRow(rowPid);
				}
			}
		}
		
	</script>

</head>
<body>
	<br>
	<input type="button" value="首页" onclick="window.location.href='index.jsp'" style="float:left;height:35px;width:80px;font-size:14px"> 
	<input type="button" value="添加商品" onclick="window.location.href='addproduct.jsp'" style="float:right;height:35px;width:80px;font-size:14px">  
	<input type="button" value="用户管理" onclick="window.location.href='SelectServlet'" style="float:right;height:35px;width:80px;font-size:14px">  
	<center>
		Welcome to the products management page!
		<br><br>
		<table id="productsTable" border="1" width="1350" height="50">
		<tr>
				<th>商品编号</th>
				<th>商品名</th>
				<th>售价</th>
				<th>进价</th>
				<th>图片</th>
				<th>描述</th>
				<th>类别名</th>
				<th>品牌</th>
				<th>上架时间</th>
				<th>颜色</th>
				<th>尺寸</th>
				<th>质量</th>
				<th>操作</th>
			</tr>
			
			<c:forEach items="${productList }" var="product">
			<tr>
				<td><c:out value="${product.pid }"></c:out></td>
				<td><c:out value="${product.pname }"></c:out></td>
				<td><c:out value="${product.price }"></c:out></td>
				<td><c:out value="${product.purchasePrice }"></c:out></td>
				<td><c:out value="${product.pimage }"></c:out></td>
				<td><c:out value="${product.pdescribe }"></c:out></td>
				<td><c:out value="${product.categoryname }"></c:out></td>
				<td><c:out value="${product.brand }"></c:out></td>
				<td><c:out value="${product.shelftime }"></c:out></td>
				<td><c:out value="${product.color }"></c:out></td>
				<td><c:out value="${product.size }"></c:out></td>
				<td><c:out value="${product.quality }"></c:out></td>
				
				<td><a href="OneProductServlet?pid=${product.pid }">修改</a> 
					<a href="#" onclick="deleteRow(this,${product.pid})">下架</a>
				</td>
			</tr>
			</c:forEach>
</table>
</center>
</body>
</html>