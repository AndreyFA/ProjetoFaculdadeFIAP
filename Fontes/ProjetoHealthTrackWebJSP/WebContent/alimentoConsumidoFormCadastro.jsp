<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="loadPageHeader.jsp"%>
<div class="container-fluid conteudo">
	<ol class="breadcrumb">
		<li><a href="dashboard.jsp">Dashboard</a></li>
		<li><a href="alimentoConsumido.jsp">Meus alimentos consumidos</a></li>
		<li class="active">Cadastrar alimento consumido</li>
	</ol>
	<div class="row">
		<div class="col-md-12">
			<img class="icons" src="resources/img/Pressure.png" alt="">
			<span class="fonte-titulo"> Como está o coração?</span>
		</div>
	</div>
	<br>
	<form action="">
		<div class="form-group">
			<label for="tipoRefeicaoInclusao">Tipo de refeição</label> 
			<select class="form-control" id="tipoRefeicaoInclusao" required>
				<option>Lanche leve</option>
				<option>Lanche leve</option>
				<option>Lanche leve</option>
				<option>Lanche leve</option>
				<option>Lanche leve</option>
			</select>
		</div>
		<div class="form-group">
			<label for="totalCaloriasInclusao">Quantas calorias?</label> 
			<input type="text" class="form-control tipoNumerico" id="totalCaloriasInclusao" required>
		</div>
		<div class="form-group">
			<label for="dataInclusao">Data</label>
			<input type="text" class="form-control tipoCalendario" id="dataInclusao" required>
		</div>
		<div class="form-group">
			<label for="horarioInclusao">Horário</label> 
			<input type="text" class="form-control tipoHorario" id="horarioInclusao" required>
		</div>
		<div class="form-group">
			<label for="descricaoInclusao">Descrição</label>
			<input type="text" class="form-control" id="descricaoInclusao">
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
			<input type="submit" class="btn btn-primary btnFinaliza" value="Salvar" />
		</div>
	</form>
</div>
<%@ include file="loadPageFooter.jsp"%>