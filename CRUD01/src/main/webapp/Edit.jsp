<%@page import="dto.ProductDto"%>
<%@page import="java.util.List"%>
<%@page import="dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	ProductDao dao = new ProductDao(); 
	List<ProductDto> list = dao.showProductList();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>商品情報修正</title>
	<script src="resources/js/jquery-4.0.0.min.js"></script>
</head>
<body>
	<h1>商品在庫管理</h1>
	<hr/>
	<br/>
	<form action="EditAction.jsp" method="post">
		<select name="p_code" id="select_p_code">
			<% for(int i=0; i<list.size(); i++) { %>
			<option value="<%=list.get(i).getP_code()%>">
				<%=list.get(i).getP_code()%>
			</option>
			<% } %>
		</select>
		<br/>
		修正後の値段：
		<input type="text" name="price"/> <br/>
		修正後の在庫数：
		<input type="text" name="stock"/> <br/>
		<input type="submit" value="修正する"/>
	</form>
</body>
</html>