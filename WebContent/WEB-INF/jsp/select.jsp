<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>SelectUpdateDelete</title>
 
<script>
		var globalObject;
		var httpRequest = false;
		function deleteRow(nodeObject,userId){

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
				var url="DeleteUserServlet?id=" + userId;
				
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
					var table=document.getElementById("registerTable");
					var rowId=globalObject.parentNode.parentNode.rowIndex;
					
					alert("rowId is : "+rowId);
					
					table.deleteRow(rowId);
				}
			}
		}
		
	</script>
</head>
<body>  
	<input type="button" value="首页" onclick="window.location.href='index.jsp'" style="float:left;height:35px;width:80px;font-size:14px"> 
	<input type="button" value="商品管理" onclick="window.location.href='productsmanage.action'" style="float:right;height:35px;width:80px;font-size:14px"> 
	<center> 
	<br>
	<br>
	<br>
	<br>
	<br>
		<table id="registerTable" border=1 width=600 height=150 style="border:1px black solid">
		<tr align="center">
				<th>编号</th>
				<th>姓名</th> 
				<th>性别</th>
				<th>籍贯</th>
				<th>爱好</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${requestScope.userList }" var="user">
			<tr align="center">
				<td>${user.id }</td>
				<td>${user.username }</td> 
				<td>
					<c:if test="${ user.gander eq 'male'}">男</c:if>
					<c:if test="${ user.gander eq 'female'}">女</c:if>
				</td>
				<td>${user.birthPlace }</td>
				<td>${user.hobby }</td>
				<td> 
					<a href="SelectOneUserServlet?id=${user.id }"><input type="button" value="修改"></a> 
					<a href="delete.action?id=${user.id }" ><input type="button" value="删除"></a> 
					<!--  <a href="delete.action" onclick="deleteRow(this,${user.id})"><input type="button" value="删除"></a> -->
					
				</td>
			</tr>
			</c:forEach>
</table>
</center>
 
</body>
</html>