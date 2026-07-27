<%@page import="dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	String p_code = request.getParameter("p_code");
	ProductDao dao = new ProductDao();
	dao.deleteProduct(p_code);
%>
<script src="resources/js/jquery-4.0.0.min.js"></script>
<script>
	$(function() {
		alert("削除されました！");
		location.href = "Main.jsp";
	});
</script>