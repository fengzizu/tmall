<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- 引入JQuery -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jquery-easyui-1.5.3/jquery.min.js"></script>

<!-- 引入EasyUI -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jquery-easyui-1.5.3/jquery.easyui.min.js"></script>

<!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jquery-easyui-1.5.3/locale/easyui-lang-zh_CN.js"></script>
	
<!-- 引入EasyUI的样式文件-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/jquery-easyui-1.5.3/themes/default/easyui.css"
	type="text/css" />
	
<!-- 引入EasyUI的图标样式文件-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/jquery-easyui-1.5.3/themes/icon.css"
	type="text/css" />


</head>
<body>

	<table class="easyui-datagrid" title="用户信息" style="width:450px;height:250px"
			data-options="singleSelect:true,collapsible:true,url:'showUser.action',method:'post'">
		<thead>
			<tr>
				<th data-options="field:'uid',width:80">用户编号</th>
				<th data-options="field:'uname',width:100">用户姓名</th>
				<th data-options="field:'password',width:80,align:'right'">密码</th>
				<th data-options="field:'gender',width:80,align:'right'">性别</th>
				<th data-options="field:'balance',width:250">余额</th>
			</tr>
		</thead>
	</table>

</body>
</html>