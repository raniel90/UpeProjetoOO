<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<spring:url value="/resources/css/hello.css" var="coreCss" />
	<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
	<link href="${coreCss}" rel="stylesheet" />
	<title>UPE CEES/2015</title>

</head>

<body>
	<div class="container">
	<h2>Listagem de Hemocentros</h2>	
	<table class="table">
		<thead>
	      <tr>
	        <th>Nome</th>
	        <th>Ações</th>
	      </tr>
	    </thead>
		<c:forEach items="${hemocentros}" var="hemocentro">
			<tr class="info">
			<td>${hemocentro.nome}</td>
			<td>
				<a href="<c:url value='/edit-${hemocentro.id}-hemocentro' />">Alterar</a>
				<a href="<c:url value='/delete-${hemocentro.id}-hemocentro' />">Remover</a>
			</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/new' />">Adicionar Novo Hemocentro</a>
	
	<hr>
	<footer>
		<p>© UPE/CEES 2015.1</p>
	</footer>
	</div>

	<spring:url value="/resources/core/css/hello.js" var="coreJs" />
	<spring:url value="/resources/core/css/bootstrap.min.js" var="bootstrapJs" />

	<script src="${coreJs}"></script>
	<script src="${bootstrapJs}"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	
</body>
</html>