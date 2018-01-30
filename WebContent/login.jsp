<!DOCTYPE html>
<html>
	<head>
		<title>Account</title>
		<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
			media="all" />
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="js/jquery.min.js"></script>
		<!-- Custom Theme files -->
		<!--theme-style-->
		<link href="css/style.css" rel="stylesheet" type="text/css"
			media="all" />
		<!--//theme-style-->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="" />
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		<!--fonts-->
		<link
			href='https://fonts.googleapis.com/css?family=Exo:100,200,300,400,500,600,700,800,900'
			rel='stylesheet' type='text/css'>
		<!--//fonts-->
		<script type="text/javascript" src="js/move-top.js"></script>
		<script type="text/javascript" src="js/easing.js"></script>
		<script type="text/javascript">
					jQuery(document).ready(function($) {
						$(".scroll").click(function(event){		
							event.preventDefault();
							$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
						});
					});
				</script>
		<script>$(document).ready(function(c) {
	$('.alert-close').on('click', function(c){
		$('.message').fadeOut('slow', function(c){
	  		$('.message').remove();
		});
	});	  
});
</script>
		<script>$(document).ready(function(c) {
	$('.alert-close1').on('click', function(c){
		$('.message1').fadeOut('slow', function(c){
	  		$('.message1').remove();
		});
	});	  
});
</script>
	</head>
	<body>

		<jsp:include page="header.jsp" />
		<div class="container">
			<div class="account">
				<h2 class="account-in">Login</h2>
				<form id = "loginform" action = "login.action" method = "GET" onsubmit="return check()">
					<div style="text-align:center">
						<span>UserName *</span>
						<input type="text" id="username" name="username" style="font-size:15px">
					</div>
					<div align="center">
						<span class="word">Password *</span>
						<input type="password" id="password" name="password">
					</div>
					<br><br>
					<div align="center">
					<a href="register.jsp"style="text-decoration:none;">
						<input type="button" value="Register" name="register" style="height:50px;width:150px;font-size:20px">
					</a>
						<input type="submit" value="Login" name="login" style="height:50px;width:150px;font-size:20px">
					</div>
				</form>
				<script type="text/javascript" src="./js/jquery-3.2.1.js"></script>
			 	<script type="text/javascript">
				
			 	function check(){
					if ($("#username").val() == "" && $("#password").val() == "") {
						alert("Please input username and password!");
						return false;
					}if ($("#username").val() == "") {
						alert("Please input username!");
						return false;
					}if($("#password").val() == "") {
						alert("Please input password!");
						return false;
					}
					return true;
				}
				</script>
			</div>
		</div>
		<jsp:include page="footer.jsp" />
	</body>
</html>