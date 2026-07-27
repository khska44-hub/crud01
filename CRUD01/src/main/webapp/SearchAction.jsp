<%@page import="dto.ProductDto"%>
<%@page import="java.util.List"%>
<%@page import="dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	ProductDao dao = new ProductDao();
	String keyword = request.getParameter("keyword");
	int cnt = dao.countResult(keyword);
	List<ProductDto> list = dao.showResult(keyword);
%>
<!DOCTYPE html>
<html>
<head>
	<script src="resources/js/jquery-4.0.0.min.js"></script>
	<script>
		alert("検索結果：<%=cnt%>件");
		$(function() {
			$("#goToMain").click(function() {
				confirm("メイン画面へ戻ります。");
				location.href = "Main.jsp";
			});
		});
	</script>
	<meta charset="UTF-8">
	<title>検索結果</title>
</head>
<body>
	<h1>商品在庫管理</h1>
	<hr/>
	<br/>
	<button id="goToMain">戻る</button>
	<table>
		<tr>
			<th>商品コード</th>
			<th>商品名</th>
			<th>価格</th>
			<th>在庫</th>
		</tr>
		<% for(int i=0; i<list.size(); i++) { %>
		<tr>
			<td><%=list.get(i).getP_code()%></td>
			<td><%=list.get(i).getP_name()%></td>
			<td><%=list.get(i).getPrice()%></td>
			<td><%=list.get(i).getStock()%></td>
		</tr>
		<% } %>
	</table>
</body>
</html>