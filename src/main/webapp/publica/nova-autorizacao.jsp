<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nova autorização</title>

<link
	href="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/css/bootstrap.min.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/jquery-3.6.0-dist/jquery-3.6.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>

</head>
<body>

	<jsp:include page="/publica/publica.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div class="col">
				<h2>Nova autorização</h2>

				<c:if test="${mensagem != null}">
					<div class="alert ${alert} alert-dismissible fade show">
						<button type="button" class="btn-close" data-bs-dismiss="alert"></button>
						<span><c:out value="${mensagem}" /></span>
					</div>
				</c:if>


				<form
					action="${pageContext.request.contextPath}/publica?acao=salvar"
					method="post">
					<div class="mb-3">
						<label for="exampleInputName" class="form-label">Nome</label> <input
							type="text" class="form-control" id="exampleInputName"
							aria-describedby="nameHelp" name="nome" required>
						<div id="nameHelp" class="form-text">Digite seu nome e
							sobrenome</div>
					</div>
					<div class="mb-3">
						<label for="exampleInputProcedi" class="form-label">Procedimento</label>
						<input type="text" class="form-control" id="exampleInputProcedi"
							name="procedi" required>
					</div>
					<div class="mb-3">
						<label for="exampleInputIdade" class="form-label">Idade</label> <input
							type="text" class="form-control" id="exampleInputIdade"
							name="idade" required>
					</div>
					<div class="mb-3">
						<label for="Select" class="form-label">Informe seu sexo</label> <select
							id="Select" class="form-select" name="sexo" required>
							<option></option>
							<option value="M">Masculino</option>
							<option value="F">Feminino</option>
						</select>
					</div>
					<button type="submit" class="btn btn-primary">Salvar</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>