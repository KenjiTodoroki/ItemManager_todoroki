<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//リクエストスコープからインスタンスを取得する
ItemBean item = (ItemBean) request.getAttribute("item");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品詳細画面</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="main">
		<main>
			<h2>商品詳細</h2>
			<table border=1>
				<thead>
					<tr>
						<th>商品ID</th>
						<th>商品名</th>
						<th>メーカー</th>
						<th>価格(万円)</th>
						<th>登録日</th>
						<th>更新日</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><%=item.getItemId%></td>
						<td><%=item.getItemName%></td>
						<td><%=item.getMakerCode%></td>
						<td><%=item.getPrice%></td>
						<td><%=item.getInsertDatetime%></td>
						<td><%=item.getUpdateDatetime%></td>
						<td>
							<%-- <c:url let="item-edit" value="/ItemEditServlet">
								<c:param name="id" value="<% String.valueOf(data.itemId()) %>"></c:param>
							</c:url> --%>
							<form action="item-edit.jsp" method="post">
								<input type="submit" name="button" value="商品編集">
								<%-- <input type="hidden" name="itemId" value="<%=item.getItemId() %>"> --%>
							</form>
						</td>
						<td>
							<form action="item-delete" method="post">
								<input type="submit" name="button" value="商品削除">
								<%-- <input type="hidden" name="itemId" value="<%=item.getItemId() %>"> --%>
							</form>
						</td>
					</tr>
				</tbody>
			</table>
		</main>
	</div>
</body>
</html>