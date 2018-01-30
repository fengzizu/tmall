<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="refresh" content="2;url=SelectServlet">
<script type='text/javascript'>  
	var i=2;  
	function getTime(){  
	document.getElementById('num').innerHTML="<font color='red'>"+i+"</font>";  
	i-=1;  
	var x=setTimeout('getTime()',1000)//1000毫秒=1秒  
	if(i<=0){  
	clearTimeout(x);  
	}  
}  
window.onload=getTime;//开始执行倒计时  
</script>  

</head>
<body>
<center>
<br>
<h2 style="color:green">
用户修改成功！
<br><br><br>
此页面将在<span id='num' style='display=inline;'>2</span>秒后跳转至用户管理页面
</h2>
</center>
</body>
</html>