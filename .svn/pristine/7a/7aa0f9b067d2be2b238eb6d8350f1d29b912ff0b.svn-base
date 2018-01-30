<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=utf8">
<title>Register</title>

<script type="text/javascript" src="./js/jquery-3.2.1.js"></script>

<script type="text/javascript">

	/* 根据表单名称获取表单对象 */
	function buttonOnClick(){

		var registerForm = document.registerForm;
		
		var name = registerForm.username.value;
		var password = registerForm.password.value;
		var gander = registerForm.gander.value;
		var birthPlace = registerForm.birthPlace.value;
		
		/* 复选框中的取值 */
		var hobbyElements = registerForm.interest;
		var hobby = "";
		for(var i = 0;i < hobbyElements.length;i++){
			if(hobbyElements[i].checked){
				hobby += hobbyElements[i].value + ",";
			}
		}
		hobby = hobby.substr(0, hobby.length - 1);
		
		var style = "border: 2px solid red;";
		
		/* 在前端进行判空，减轻服务器压力，防止用户空提交 */
		/* if(name == "" || name == null || /[^\x00-\xff]/g.test(name)){
			alert("name is null or has Chinese characters");
			return false;
		} */
		if(name == "" || name == null){
			alert("name is null");
			//addProductForm.name.style = style;
			return false;
		}
		if(password == "" || password == null){
			alert("password is null");
			//addProductForm.password.style = style;
			return false;
		}
		if(hobby == "" || hobby == null){
			alert("hobby is null");
			//addProductForm.hobby.style = style;
			return false;
		}

		/* 创建AJAX的对象XMLHttpRequest */
		var httpRequest = false;
		
		try{
			httpRequest = new XMLHttpRequest();
			
		}catch(failed){
			httpRequest = false;
		}
		
		httpRequest.open("POST", "register.action", false);
		httpRequest.setRequest.Header("Content-Type","application/x-www-form-urllencoded");
		
		var context = "&name = " + name + "&password = " + password + "&gander = " + gander + "&birthPlace = " + birthPlace + "&hobby = " + hobby;
		httpRequest.send();
		
	}
</script>
</head>

<body style="background:lightgreen">
<br>
<center>Welcome to visit the register page!
<br>

<br>
<form id="registerForm" name="registerForm" method="POST" action="register.action">
<table style="border:1px red dashed">	
	<tr>
		<td>username:</td>
		<td><input type="text" name="username"/></td>
	</tr>
	<tr>
		<td>password:</td>
		<td><input type="password" name="password"/></td>
	</tr>
	<tr>
		<td>gander:</td>
		<td>
			man<input type="radio" name="gander" value="male" checked>
			woman<input type="radio" name="gander" value="female"/>
		</td>
	</tr>
	<tr>
		<td>birthPlace:</td>
		<td>
			<select name="birthPlace">
				<option value="AnHui">AnHui</option>
				<option value="BeiJing">BeiJing</option>
				<option value="ShangHai">ShangHai</option>
				<option value="ShanXi">ShanXi</option>
				<option value="XinJiang">XinJiang</option>
				<option value="GuangXi">GuangXi</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>hobby:</td>
		<td>
			music<input type="checkbox" name="interest" value="music" checked="checked"/>
			jog<input type="checkbox" name="interest" value="jog"/>
			swimming<input type="checkbox" name="interest" value="swimming"/>
			fishing<input type="checkbox" name="interest" value="fishing"/>
		</td>
	</tr>
	<tr>
		<td>selfIntroduce:</td>
		<td><textarea name="selfIntroduce" rows="4" cols="19"></textarea></td>
	</tr>
</table>
		<br>
		
		<input type="submit" value="submit" style="height:30px;width:70px;font-size:16px"/>
		
</form>
</center>
</body>

</html>