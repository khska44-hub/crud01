<%@page import="dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	ProductDao dao = new ProductDao();
	String p_code = request.getParameter("p_code");
	String p_name = request.getParameter("p_name");
	int price = Integer.parseInt(request.getParameter("price"));
	int stock = Integer.parseInt(request.getParameter("stock"));
	dao.uploadProduct(p_code, p_name, price, stock);
%>
<script src="resources/js/jquery-4.0.0.min.js"></script>
<script>
	alert("登録されました！");
	location.href = "Main.jsp";
</script>