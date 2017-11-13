<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="loadPageHeader.jsp"%>
<div class="container-fluid conteudo">
	<ol class="breadcrumb">
		<li><a href="dashboard">Dashboard</a></li>
		<li><a href="peso?opcao=listar">Meu peso</a></li>
		<li class="active">Cadastrar peso</li>
	</ol>
	<div class="row">
		<div class="col-md-12">
			<img class="icons" src="resources/img/Balance.png" alt="">
			<span class="fonte-titulo">Vamos encarar a balança!</span>
		</div>
	</div>
	<br>
	<form action="peso" method="post">
		<input type="hidden" name="opcao" value="cadastrar" />
		<div class="form-group">
			<label for="pesoInclusao">Informe seu peso</label> 
			<input type="text" class="form-control tipoNumerico" id="peso" name="peso" required>
		</div>
		<div class="form-group">
			<label for="dataPesoInclusao">Quando foi isso?</label> 
			<input type="text" class="form-control tipoCalendario" id="data" name="data" required>
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
			<input type="submit" class="btn btn-primary btnFinaliza" value="Salvar">
		</div>
	</form>
</div>
<%@ include file="loadPageFooter.jsp"%>