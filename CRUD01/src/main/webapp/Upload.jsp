<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>商品登録</title>
	<script src="resources/js/jquery-4.0.0.min.js"></script>
</head>
<body>
	<h1>商品在庫管理</h1>
	<hr/>
	<br/>
	<form action="UploadAction.jsp" method="post">
		商品コード：
		<input type="text" name="p_code" required/> <br/>
		商品名：
		<input type="text" name="p_name" required/> <br/>
		価格：
		<input type="text" name="price" required/> <br/>
		在庫数：
		<input type="text" name="stock" required/> <br/>
		<input type="submit" value="商品登録"/>
	</form>
</body>
</html>