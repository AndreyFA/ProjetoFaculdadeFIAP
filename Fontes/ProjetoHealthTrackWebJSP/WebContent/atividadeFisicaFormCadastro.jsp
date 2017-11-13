<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="loadPageHeader.jsp"%>
<div class="container-fluid conteudo">
	<ol class="breadcrumb">
		<li><a href="dashboard.jsp">Dashboard</a></li>
		<li><a href="dashboard.jsp">Minhas atividades f�sicas</a></li>
		<li class="active">Cadastrar atividade f�sica</li>
	</ol>
	<div class="row">
		<div class="col-md-12">
			<img class="icons" src="resources/img/Exercise.png" alt="">
			<span class="fonte-titulo">Caramba! Voc� est� se tornando um atleta</span>
		</div>
	</div>
	<br>
	<form action="">
		<div class="form-group">
			<label for="tipoAtividadeInclusao">Tipo de atividade</label>
			<select class="form-control" id="tipoAtividadeInclusao" required>
				<option>Corrida</option>
				<option>Corrida</option>
				<option>Corrida</option>
				<option>Corrida</option>
				<option>Corrida</option>
			</select>
		</div>
		<div class="form-group">
			<label for="totalCaloriasInclusao">Quantas calorias?</label>
			<input class="form-control tipoNumerico" id="totalCaloriasInclusao" required>
		</div>
		<div class="form-group">
			<label for="dataInclusao">Data</label>
			<input type="text" class="form-control tipoCalendario" id="dataInclusao" required>
		</div>
		<div class="form-group">
			<label for="horarioInclusao">Hor�rio</label>
			<input type="text" class="form-control tipoHorario" id="horarioInclusao" required>
		</div>
		<div class="form-group">
			<label for="descricaoInclusao">Descri��o</label>
			<input type="text" class="form-control" id="descricaoInclusao">
		</div>
	</form>
</div>
<%@ include file="loadPageFooter.jsp"%>