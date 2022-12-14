<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html>

<head>
		<meta charset="UTF-8">
		<title>Sistema de filmes</title>
		<link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" 	rel="stylesheet">
		<link href="<%=request.getContextPath()%>/resources/css/sticky-footer-navbar.css" rel="stylesheet">

	</head>


<body>
<jsp:include page="/resources/templates/navbar.jsp" />

	<!-- Begin page content -->
	<div class="container">
		<div class="page-header">
			<h1>Artistas</h1>
		</div>

		<div class="row">
			<div class="col-sm-2">
				<form class="navbar-form" action="<%=request.getContextPath()%>/artista/novo">
					<button type="submit" class="btn btn-primary">Inserir novo</button>
				</form>
			</div>
			<div class="col-sm-6">
				<form class="navbar-form" action="<%=request.getContextPath()%>/artista/filtrar">
					<div class="form-group">
						<input type="text" name="busca" placeholder="Digite um nome" class="form-control"/>
					</div>
					<button type="submit" class="btn btn-success">Filtrar</button>
				</form>
			</div>
		</div>

	  
	  
<table class="table">
			<thead>
				<tr>
					<th>Código</th>
					<th>Nome</th>
					<th>Nacionalidade</th>
					<th>Cache</th>
					<th>Nascimento</th>
					<th>Ação</th>
				</tr>
			</thead>



			
			<tbody>
				<c:forEach var="artista" items="${artistas}">
					<tr>
						<td>${artista.codArtista}</td>
						<td>${artista.nome}</td>
						<td>${artista.nacionalidade}</td>
						<fmt:setLocale value="pt_BR"/>
						<td>
						  <fmt:formatNumber type="currency" value="${artista.cache}"/>
					   </td>
						<td>
						  <fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${artista.nascimento}"/>
					   </td>
						<td>
						 <a href="<%=request.getContextPath()%>/artista/editar?cod=${artista.codArtista}" class="btn btn-primary btn-xs">Editar </a> 
						 <a href="<%=request.getContextPath()%>/artista/remover?cod=${artista.codArtista}" class="btn btn-danger btn-xs">Excluir</a>
					    </td>
					</tr>
				</c:forEach>

			</tbody>
			
			
			
			
		</table>
   
        
     </div>
        

	<jsp:include page="/resources/templates/rodape.jsp"></jsp:include>

	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>
