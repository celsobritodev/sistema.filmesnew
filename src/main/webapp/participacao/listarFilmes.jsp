<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sistema de Filmes</title>
<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/css/sticky-footer-navbar.css"
	rel="stylesheet">
</head>

<body>

	<jsp:include page="/resources/templates/navbar.jsp" />

	<!-- Begin page content -->
	<div class="container">
		<div class="page-header">
			<h1>Escolha um filme</h1>
		</div>

		<table class="table">
			<thead>
				<tr>
					<th>C?digo</th>
					<th>T?tulo</th>
					<th>Dura??o</th>
					<th>Ano</th>
					<th>A??o</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${filmes}" var="filme">
					<tr>
						<td>${filme.codFilme}</td>
						<td>${filme.titulo}</td>
						<td>${filme.duracao}</td>
						<td>${filme.ano}</td>
						<td><a href="<%=request.getContextPath()%>/participacao/novo?codFilme=${filme.codFilme}" 
						class="btn btn-primary btn-xs">Escolher</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<jsp:include page="/resources/templates/rodape.jsp"></jsp:include>

	<!-- Core JS -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>