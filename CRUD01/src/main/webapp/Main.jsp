<%@page import="dao.ProductDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.ProductDto"%>
<%@page import="java.util.List"%>
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
	<title>Main</title>
	<script src="resources/js/jquery-4.0.0.min.js"></script>
	<style>
		#searchForm {
			display: none;
		}
	</style>
	<script>
		$(function() {
			$(".deleteP").click(function() {
				confirm("削除しますか？");
				let p_code = $(this).parent().parent().find(".p_code").html();
				location.href = "DeleteAction.jsp?p_code="+p_code;
			});
			$("#upload").click(function() {
				location.href = "Upload.jsp";
			});
			$("#edit").click(function() {
				location.href = "Edit.jsp"
			});
			$("#search").click(function() {
				$("#searchForm").show();
				$("#btns").hide();
				$("#tb").hide();
			});
			$("#search_cancel").click(function() {
				$("#searchForm").hide();
				$("#btns").show();
				$("#tb").show();
			});
		});
	</script>
</head>
<body>
	<h1>商品在庫管理</h1>
	<hr/>
	<div id="searchForm">
		<form action="SearchAction.jsp" method="post">
			<input type="text" name="keyword"/>
			<input type="submit" value="検索"/>
		</form>
		<br/>
		<button id="search_cancel">戻る</button>
	</div>
	<div id="btns">
		<button id="upload">
			商品登録
		</button>
		<button id="edit">
			商品情報修正
		</button>
		<button id="search">
			商品検索
		</button>
	</div>
	<table id="tb">
		<tr>
			<th>商品コード</th>
			<th>商品名</th>
			<th>価格</th>
			<th>在庫</th>
			<th>削除</th>
		</tr>
		<% for(int i=0; i<list.size(); i++) { %>
		<tr>
			<td class="p_code"><%=list.get(i).getP_code()%></td>
			<td><%=list.get(i).getP_name()%></td>
			<td><%=list.get(i).getPrice()%></td>
			<td><%=list.get(i).getStock()%></td>
			<td>
				<button class="deleteP">
					この商品を削除
				</button>
			</td>
		</tr>
		<% } %>
	</table>
</body>
</html>