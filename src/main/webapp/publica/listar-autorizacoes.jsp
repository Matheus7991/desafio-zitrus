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
<!-- <script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/jquery-3.6.0-dist/jquery-3.6.0.min.js"></script>-->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>

</head>
<body>

	<jsp:include page="/publica/publica.jsp"></jsp:include>

	
	<!-- Tabela sem Ajax -->
	
	<!-- <div class="container">
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
	</div>-->
	
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
          <tbody id="solicitacao">
           
          </tbody>
        </table>
        <button id="loadData" class="btn btn-primary">Carregar Autorizações</button>
      </div>
    </div>
  </div>

  <script>
    $(document).ready(function() {
      $('#loadData').click(function() {
        $.ajax({
          url: 'publica?acao=listAut', 
          type: 'GET',
          dataType: 'json',
          success: function(data) {
            var listaSolicitacoes = $('#solicitacao');
            listaSolicitacoes.empty(); 

            $.each(data, function(index, solicitacao) {
              var row = $('<tr>');
              row.append($('<td>').text(solicitacao.id));
              row.append($('<td>').text(solicitacao.nome));
              row.append($('<td>').text(solicitacao.procedimento));
              row.append($('<td>').text(solicitacao.idade));
              row.append($('<td>').text(solicitacao.sexo));
              listaSolicitacoes.append(row);
            });
          },
          error: function(xhr, status, error) {
            console.error('Erro ao carregar solicitações:', error);
          }
        });
      });
    });
  </script>
</body>
</html>