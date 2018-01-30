<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
    <form method="POST" name="frmLogin" action="LoginServlet">
        <h1 align="center">用户登录</h1>
        <br /> 账号：<input type="text" name="username" size="20" maxlength="20" /><br>
        密码：<input type="password" name="password" size="20" maxlength="20" /><br>

        <input type="submit" name="Submit" value="提交"
            onClick="return validateLogin()" /> <input type="reset" name="Reset"
            value="重置" />

    </form>
    <script language="javascript">
   function validateLogin(){
    var sUserName = document.frmLogin.username.value ;
    var sPassword = document.frmLogin.password.value ;
    if (sUserName ==""){
     alert("请输入用户名!");
     return false ;
    }
    
    if (sPassword ==""){
     alert("请输入密码!");
     return false ;
    }
   }
  </script>
</body>
</html>