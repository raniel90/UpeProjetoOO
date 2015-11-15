<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<spring:url value="/resources/css/hello.css" var="coreCss" />
	<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
	<link href="${coreCss}" rel="stylesheet" />
	<title>Cadastro de Hemocentro</title>

	<style>
		.error {
			color: #ff0000;
		}
	</style>
</head>

<body>

	<div class="container">
	<h2>Cadastro de Hemocentro</h2>

	<form:form class="form-horizontal" role="form" method="POST" modelAttribute="hemocentro">
		<form:input type="hidden" path="id" id="id"/>
		
		<div class="form-group">
			<label class="control-label col-sm-2" for="nome">Nome:</label>
			<div class="col-sm-10">
				<form:input path="nome" class="form-control" id="nome" placeholder="Digite o nome"/>
				<form:errors path="nome" cssClass="error"/>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<c:choose>
					<c:when test="${edit}">
						<button type="submit" class="btn btn-default">Alterar</button>
					</c:when>
					<c:otherwise>
						<button type="submit" class="btn btn-default">Cadastrar</button>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</form:form>

	<br/>
	<br/>
	Voltar Para <a href="<c:url value='/list' />">Listagem de Hemocentros</a>
	
	
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