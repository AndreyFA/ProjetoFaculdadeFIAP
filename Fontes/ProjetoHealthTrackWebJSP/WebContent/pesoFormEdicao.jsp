<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="loadPageHeader.jsp"%>
<div class="container-fluid conteudo">
	<ol class="breadcrumb">
		<li><a href="dashboard">Dashboard</a></li>
		<li><a href="peso?opcao=listar">Meu peso</a></li>
		<li class="active">Editar peso</li>
	</ol>
	<div class="row">
		<div class="col-md-12">
			<img class="icons" src="resources/img/Balance.png" alt="">
			<span class="fonte-titulo">Vamos encarar a balança!</span>
		</div>
	</div>
	<br>
	<form action="peso" method="post">
		<input type="hidden" value="editar" name="opcao" />
		<input type="hidden" value="${peso.getCodigo() }" name="codigo" />
		<div class="form-group">
			<label for="pesoEdicao">Peso</label> 
			<input type="text" class="form-control tipoNumerico" id="peso" name="peso" value="${peso.getPeso() }" required>
		</div>
		<div class="form-group">
			<label for="dataPesoEdicao">Data</label> 
			<input type="text" class="form-control tipoCalendario" id="data" name="data" value="${peso.getData() }" required>
		</div>
		<div class="modal-footer">
			<c:url value="peso" var="link">
				<c:param name="opcao" value="listar" />
			</c:url>
			<a class="btn btn-default" href="${link }">Cancelar</a>
			<input type="submit" class="btn btn-primary btnFinaliza" value="Confirmar" />
		</div>
	</form>
</div>
<%@ include file="loadPageFooter.jsp"%>