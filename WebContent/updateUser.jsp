<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	 
</script>
</head>
<body>
<form name="updateUser" method="POST" action ="UpdateUserServlet" >
		
      <table border = "1" align = "center" style="border-collapse:collapse;">
      	 
          <tr>　　　　　　　　　　　　 
              <td colspan="2">用户ID<input name="userId" readonly="readonly" value="${user.id }"/></td>           
          </tr>
          <tr>
              <td>用户名</td>
              <td class="tdstyle2"><input type="text" name="username" value="${user.username }"/></td>    
          </tr> 
         <tr>
             <td>性 别</td>
             <td>
                 <input type="text" name="gander" value="${user.gander }"  />
             </td>        
         </tr>
        <tr>
             <td>地 址</td>
            <td> 
            	<input type="text" name="birthPlace" value="${user.birthPlace }">
             </td>
         </tr>
         <tr>
             <td>爱 好</td>
           <td>
             	<input type="text" name="hobby" value="${user.hobby }"/>
             </td>         
         </tr> 
         <tr>
             <td colspan="2" align="center"><input type = "submit" value = "确认修改" /></td>          
        </tr>
     </table>
     </form>
</body>
</html>



 