<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品分类</title>
</head>
<body style="background: rgb(199, 237, 204);">
	<center>

		<form action="${pageContext.request.contextPath}/category/addCategory"
			method="post">

			<table border="1" height="100px">
				<caption>添加商品分类</caption>
				<tr>
					<td>一级商品分类添写：</td>
					<td><input type="text" name="oneGrade" /></td>
				</tr>
				<tr>
					<td>二级分类用"-"分割数量</td>
					<td><input type="text" name="twoGrade" /></td>

				</tr>
				<tr>
					<td>提交：</td>
					<td><input type="submit" /></td>
				</tr>
				<tr>
					<td>类别添加结果显示：</td>
					<td><c:if test="${msg==0}">
							<span><font color="red">添加失败</font></span>
						</c:if> <c:if test="${msg==1}">
							<span><font color="green">添加成功</font></span>
						</c:if></td>
					</td>
				</tr>

			</table>


		</form>

	</center>

</body>
</html>