<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="refresh" content="3;url=index.jsp">
<script type='text/javascript'>  
var i=3;  
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

<title>Submit Order Success</title>
</head>
<body>
<center>
<br>
<h2 style="color:green">
订单提交成功，请移步首页继续选购！
<br><br><br>
此页面将在<span id='num' style='display=inline;'>3</span>秒后跳转至首页
</h2>
</center>
</body>
</html>