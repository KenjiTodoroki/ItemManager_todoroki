<%@page import="model.entity.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- (UserBean)ダウンキャスト(親クラスをUserBean(セットした型)に戻す) --!>
<!-- ※control + spaceでimport -->

<%
UserBean user = (UserBean) session.getAttribute("user");
String text = (String) request.getAttribute("text");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー画面</title>
<link rel="stylesheet" href="assets/stylesheets/app.css">
</head>
<body>
	<!-- 「=」は式（ブラウザに表示させる） -->
	<%=user.getUserId()%>さん、こんにちは
	<%=text %>
	<div class="main">
		<main>
			<h2>従業員管理システム</h2>
			<form action="menu" method="post">
				<input type="submit" name="button" value="従業員一覧"><br> <input
					type="submit" name="button" value="従業員登録画面へ"><br> <input
					type="submit" name="button" value="経験言語登録画面へ">
			</form>
		</main>
	</div>
</body>
</html>
