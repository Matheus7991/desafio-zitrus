<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Solicitações</title>

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
				<h2>Lista de autorizações</h2>
				<table class="table table-success table-striped">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Nome</th>
							<th scope="col">Procedimento</th>
							<th scope="col">Idade</th>
							<th scope="col">Sexo</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="solicitacao" items="${listaSolicitacoes}">
							<tr>
								<td><c:out value="${solicitacao.id}" /></td>
								<td><c:out value="${solicitacao.nome}" /></td>
								<td><c:out value="${solicitacao.procedimento}" /></td>
								<td><c:out value="${solicitacao.idade}" /></td>
								<td><c:out value="${solicitacao.sexo}" /></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>

<!--   
<body>
  <div class="container">
    <div class="row">
      <div class="col">
        <h2>Lista de autorizações</h2>
        <button id="loadData" class="btn btn-primary">Carregar Autorizações</button>
        <table class="table">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">Nome</th>
              <th scope="col">Procedimento</th>
              <th scope="col">Idade</th>
              <th scope="col">Sexo</th>
            </tr>
          </thead>
          <tbody id="solicitacao">
  
          </tbody>
        </table>
      </div>
    </div>
  </div> 

  <script>
    $(document).ready(function() {
      $('#loadData').click(function() {
        $.ajax({
          url: 'http://localhost:8080/desafio-zitrus/publica?acao=autorizar', // Endpoint do seu servidor
          type: 'GET',
          dataType: 'json',
          success: function(data) {
            var tabelaAutorizacoes = $('#tabelaAutorizacoes');
            tabelaAutorizacoes.empty(); // Limpa a tabela antes de adicionar novos dados

            $.each(data, function(index, solicitacao) {
              var row = $('<tr>');
              row.append($('<td>').text(solicitacao.id));
              row.append($('<td>').text(solicitacao.nome));
              row.append($('<td>').text(solicitacao.procedimento));
              row.append($('<td>').text(solicitacao.idade));
              row.append($('<td>').text(solicitacao.sexo));
              tabelaAutorizacoes.append(row);
            });
          },
          error: function(xhr, status, error) {
            console.error('Erro ao carregar autorizações:', error);
          }
        });
      });
    });
  </script> 
</body> -->
</html>