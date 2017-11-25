<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="loadPageHeader.jsp"%>
<div class="container-fluid conteudo">
	<ol class="breadcrumb">
		<li><a href="dashboard.jsp">Dashboard</a></li>
		<li><a href="atividadeFisica?opcao=listar">Minhas atividades físicas</a></li>
		<li class="active">Cadastrar atividade física</li>
	</ol>
	<div class="row">
		<div class="col-md-12">
			<img class="icons" src="resources/img/Exercise.png" alt="">
			<span class="fonte-titulo">Caramba! Você está se tornando um atleta</span>
		</div>
	</div>
	<br>
	<form action="atividadeFisica" method="post">
		<input type="hidden" name="opcao" value="editar">
		<input type="hidden" name="codigo" value="${atividadeFisica.getCodigo() }">
		<div class="form-group">
			<label for="tipoAtividadeInclusao">Tipo de atividade</label>
			<select class="form-control" id="tipoAtividadeInclusao" name="tipoAtividadeFisica" required>
				<c:forEach items="${tipoAtividadesFisicas }" var="t">
					<c:if test="${t.getCodigo() == atividadeFisica.getTipo().getCodigo() }">
						<option value="${t.getCodigo() }" selected>${t.getNome() }</option>
					</c:if>
					<c:if test="${t.getCodigo() != atividadeFisica.getTipo().getCodigo() }">
						<option value="${t.getCodigo() }" >${t.getNome() }</option>
					</c:if>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<label for="totalCaloriasInclusao">Quantas calorias?</label>
			<input class="form-control tipoNumerico" id="totalCaloriasInclusao" name="calorias" value="${atividadeFisica.getCalorias() }" required>
		</div>
		<div class="form-group">
			<label for="dataInclusao">Data</label>
			<input type="text" class="form-control tipoCalendario" id="dataInclusao" name="data" value="${atividadeFisica.getData() }" required>
		</div>
		<div class="form-group">
			<label for="horarioInclusao">Horário</label>
			<input type="text" class="form-control tipoHorario" id="horarioInclusao" name="horario" value="${atividadeFisica.getHorario() }"required>
		</div>
		<div class="form-group">
			<label for="descricaoInclusao">Descrição</label>
			<input type="text" class="form-control" id="descricaoInclusao" name="descricao" value="${atividadeFisica.getDescricao() }">
		</div>
		<div class="modal-footer">
			<c:url value="atividadeFisica" var="link">
				<c:param name="opcao" value="listar" />
			</c:url>
			<a class="btn btn-default" href="${link }">Cancelar</a>
			<input type="submit" class="btn btn-primary btnFinaliza" value="Salvar" />
		</div>
	</form>
</div>
<%@ include file="loadPageFooter.jsp"%>