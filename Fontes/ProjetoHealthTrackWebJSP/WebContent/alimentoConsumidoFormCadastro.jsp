<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="loadPageHeader.jsp"%>
<div class="container-fluid conteudo">
	<ol class="breadcrumb">
		<li><a href="dashboard.jsp">Dashboard</a></li>
		<li><a href="alimentoConsumido?opcao=listar">Meus alimentos consumidos</a></li>
		<li class="active">Cadastrar alimento consumido</li>
	</ol>
	<div class="row">
		<div class="col-md-12">
			<img class="icons" src="resources/img/Pressure.png" alt="">
			<span class="fonte-titulo"> Como está o coração?</span>
		</div>
	</div>
	<br>
	<form action="alimentoConsumido" method="post">
		<input type="hidden" name="opcao" value="cadastrar" />
		<div class="form-group">
			<label for="tipoRefeicaoInclusao">Tipo de refeição</label> 
			<select class="form-control" name="tipoRefeicao" required>
				<option value="0">Selecione</option>
				<c:forEach items="${tipoRefeicoes }" var="t">
					<option value="${t.getCodigo() }" >${t.getNome() }</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<label for="totalCaloriasInclusao">Quantas calorias?</label> 
			<input type="text" class="form-control tipoNumerico" name="calorias" id="totalCaloriasInclusao" required>
		</div>
		<div class="form-group">
			<label for="dataInclusao">Data</label>
			<input type="text" class="form-control tipoCalendario" name="horario" id="dataInclusao" required>
		</div>
		<div class="form-group">
			<label for="horarioInclusao">Horário</label> 
			<input type="text" class="form-control tipoHorario" name="horario" id="horarioInclusao" required>
		</div>
		<div class="form-group">
			<label for="descricaoInclusao">Descrição</label>
			<input type="text" class="form-control" name="descricao" id="descricaoInclusao">
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
			<input type="submit" class="btn btn-primary btnFinaliza" value="Salvar" />
		</div>
	</form>
</div>
<%@ include file="loadPageFooter.jsp"%>