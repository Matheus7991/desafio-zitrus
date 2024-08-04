<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container py-5">
	<div class="d-flex justify-content-center">		
			<div class="card m-2 text-center" style="width: 25rem;">
				<img src="https://cdn-icons-png.flaticon.com/512/3534/3534139.png" class="card-imt-top">
				<div class="card-body">
					<h5 class="card-title">Cadastrar autorização</h5>
					<p class="card-text">Clique no botão abaixo para cadastrar uma nova solicitação.</p>
					<a href="${pageContext.request.contextPath}/publica?acao=nova"
						class="btn btn-primary">Cadastrar</a>
				</div>
			</div>
			<div class="card m-2 text-center" style="width:25rem;">
				<img src="https://cdn-icons-png.flaticon.com/512/2721/2721299.png" class="card-imt-top">
				<div class="card-body">
					<h5 class="card-title">Listar autorizações</h5>
					<p class="card-text">Clique no botão abaixo para ver as solicitações cadastradas.</p>
					<a href="${pageContext.request.contextPath}/publica?acao=listar"
						class="btn btn-primary">Listar</a>
				</div>
			</div>
	</div>
</div>

