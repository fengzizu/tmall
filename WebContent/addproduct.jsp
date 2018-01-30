<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<title>添加商品</title>
<style type="text/css">
.div1{
	background-color:#fb5e33;
	height=400px;
}
.div2{
	background-color:#FFFACD;
	
}
</style>

<script type="text/javascript" src="./js/jquery-3.2.1.js"></script>

<script type="text/javascript">


	
	function buttonOnClick(){

		var addProductForm = document.addProductForm;
		
		var pname = addProductForm.pname.value;
		var price = addProductForm.price.value;
		var purchasePrice = addProductForm.purchasePrice.value;
		var pimage = addProductForm.pimage.value;
		var pdescribe=addProductForm.pdescribe.value;
		var categoryid=addProductForm.categoryid.value;
		var brand=addProductForm.brand.value;
		var shelftime=addProductForm.shelftime.value;
		var color=addProductForm.color.value;
		var size=addProductForm.size.value;
		var quality=addProductForm.quality.value;
		
		var style = "border: 2px solid red;";
		
		
		if(pname == "" || pname == null){
			alert("pname is null");
			addProductForm.pname.style = style;
			return (false);
		}
		if(price == "" || price == null){
			alert("price is null");
			addProductForm.price.style = style;
			return (false);
		}
		if(purchasePrice == "" || purchasePrice == null){
			alert("purchasePrice is null");
			addProductForm.purchasePrice.style = style;
			return (false);
		}
		if(pimage == "" || pimage == null){
			alert("pimage is null");
			addProductForm.pimage.style = style;
			return (false);
		}
		if(pdescribe == "" || pdescribe == null){
			alert("pdescribe is null");
			addProductForm.pdescribe.style = style;
			return (false);
		}
		if(categoryid == "" || categoryid == null){
			alert("categoryid is null");
			addProductForm.categoryid.style = style;
			return (false);
		}
		if(brand == "" || brand == null){
			alert("brand is null");
			addProductForm.brand.style = style;
			return (false);
		}
		if(shelftime == "" || shelftime == null){
			alert("shelftime is null");
			addProductForm.shelftime.style = style;
			return (false);
		}
		if(color == "" || color == null){
			alert("color is null");
			addProductForm.color.style = style;
			return (false);
		}
		if(size == "" || size == null){
			alert("size is null");
			addProductForm.size.style = style;
			return (false);
		}
		if(quality == "" || quality == null){
			alert("quality is null");
			addProductForm.quality.style = style;
			return (false);
		}
		

		// 创建AJAX的对象XMLHttpRequest 
		var httpRequest = false;
		
		try{
			httpRequest = new XMLHttpRequest();
			
		}catch(failed){
			httpRequest = false;
		}
		
		httpRequest.open("POST", "addproductservlet.action", false);
		httpRequest.send();
		
	}
</script>
</head>

<body >
<div class="div1">
<br>
<center>请填写商品信息，并添加商品！</center>
<br>
</div>
<br>
<div class="div2">
<center>
<form id="addProductForm" name="addProductForm" method="POST" action="addproductservlet.action" onsubmit="return buttonOnClick()" >
<table >	
	<tr>
		<td>名称:</td>
		<td><input type="text" name="pname"/></td>
	</tr>
	<tr>
		<td>售价:</td>
		<td><input type="text" name="price"/></td>
	</tr>
	<tr>
		<td>进价:</td>
		<td><input type="text" name="purchasePrice"/></td>
	</tr>
	<tr>
		<td>图片:</td>
		<td><input type="text" name="pimage"/></td>
	</tr>
	<tr>
		<td>描述:</td>
		<td><input type="text" name="pdescribe"/></td>
	</tr>
	<tr>
		<td>类别号:</td>
		<td><input type="text" name="categoryid"/></td>
	</tr>
	<tr>
		<td>品牌:</td>
		<td><input type="text" name="brand"/></td>
	</tr>
	<tr>
		<td>上架时间:</td>
		<td><input type="date" name="shelftime"/></td>
	</tr>
	<tr>
		<td>颜色:</td>
		<td>
			<select name="color">
				<option value="red">红色</option>
				<option value="black">黑色</option>
				<option value="white">白色</option>
				<option value="gray">灰色</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>型号:</td>
		<td>
			<select name="size">
				<option value="5.0">5.0寸</option>
				<option value="5.5">5.5寸</option>
				<option value="6.0">6.0寸</option>
				<option value="S">S</option>
				<option value="M">M</option>
				<option value="L">L</option>
				<option value="XL">XL</option>
				<option value="XXL">XXL</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>质量:</td>
		<td>
			<select name="quality">
				<option value="top">高</option>
				<option value="mid">中</option>
				<option value="low">低</option>
			</select>
		</td>
	</tr>
	
	<tr>
		<td></td>
		<td><input type="submit" value="submit" /></td>
	</tr>
</table>
</form>
</center>
</div>
</body>

</html>