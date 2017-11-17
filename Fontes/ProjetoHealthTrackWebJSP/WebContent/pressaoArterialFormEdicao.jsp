<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="loadPageHeader.jsp"%>
<div class="container-fluid conteudo">
	<ol class="breadcrumb">
		<li><a href="dashboard">Dashboard</a></li>
		<li><a href="pressaoArterial?opcao=listar">Minha pressão</a></li>
		<li class="active">Editar pressão</li>
	</ol>
	<div class="row">
		<div class="col-md-12">
			<img class="icons" src="resources/img/Pressure.png" alt="">
			<span class="fonte-titulo"> Como está o coração?</span>
		</div>
	</div>
	<br>
	<form action="pressaoArterial" method="post">
		<input type="hidden" value="editar" name="opcao" />
		<input type="hidden" value="${pressaoArterial.getCodigo() }" name="codigo" />
		<div class="form-group">
			<label for="pressaoSistolicaInclusao">Pressão sistólica</label> 
			<input type="text" class="form-control tipoNumerico" id="pressaoSistolicaEdicao" name="pressaoSistolica" value="${pressaoArterial.getPressaoSistolica() }" required>
		</div>
		<div class="form-group">
			<label for="pressaoDiastolicaInclusao">Pressão diastólica</label>
			<input type="text" class="form-control tipoNumerico" id="pressaoDiastolicaEdicao" name="pressaoDiastolica" value="${pressaoArterial.getPressaoDiastolica() }" required>
		</div>
		<div class="form-group">
			<label for="dataInclusao">Data</label> 
			<input type="text" class="form-control tipoCalendario" id="dataEdicao" name="data" value="${pressaoArterial.getData() }" required>
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
			<input type="submit" class="btn btn-primary btnFinaliza" value="Salvar" />
		</div>
	</form>
</div>
<%@ include file="loadPageFooter.jsp"%>