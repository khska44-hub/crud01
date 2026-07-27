<%@page import="dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	ProductDao dao = new ProductDao();
	int price = Integer.parseInt(request.getParameter("price"));
	int stock = Integer.parseInt(request.getParameter("stock"));
	String p_code = request.getParameter("p_code");
	dao.editProduct(price, stock, p_code);
%>
<script src="resources/js/jquery-4.0.0.min.js"></script>
<script>
	alert("修正されました！");
	location.href = "Main.jsp";
</script>