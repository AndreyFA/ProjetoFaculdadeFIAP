<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="loadPageHeader.jsp"%>
<div class="container-fluid conteudo">
	<ol class="breadcrumb">
		<li><a href="dashboard.jsp">Dashboard</a></li>
		<li><a href="alimentoConsumido?opcao=listar">Meus alimentos consumidos</a></li>
		<li class="active">Editar alimento consumido</li>
	</ol>
	<div class="row">
		<div class="col-md-12">
			<img class="icons" src="resources/img/Pressure.png" alt="">
			<span class="fonte-titulo">Como está o coração?</span>
		</div>
	</div>
	<br>
	<form action="alimentoConsumido" method="post">
		<input type="hidden" value="editar" name="opcao" />
		<input type="hidden" value="${alimentoConsumido.getCodigo() }" name="codigo" />
		<div class="form-group">
			<label for="tipoRefeicaoInclusao">Tipo de refeição</label> 
			<select class="form-control" name="tipoRefeicao" required>
				<option value="0">Selecione</option>
				<c:forEach items="${tipoRefeicoes }" var="t">
					<c:if test="${t.getCodigo() == alimentoConsumido.getTipo().getCodigo() }">
						<option value="${t.getCodigo() }" selected>${t.getNome() }</option>
					</c:if>
					<c:if test="${t.getCodigo() != alimentoConsumido.getTipo().getCodigo() }">
						<option value="${t.getCodigo() }" >${t.getNome() }</option>
					</c:if>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<label for="totalCaloriasInclusao">Quantas calorias?</label> 
			<input type="text" class="form-control tipoNumerico" id="totalCaloriasInclusao" name="calorias" value="${alimentoConsumido.getCalorias() }" required>
		</div>
		<div class="form-group">
			<label for="dataInclusao">Data</label>
			<input type="text" class="form-control tipoCalendario" id="dataInclusao" name="data" value='<fmt:formatDate value="${alimentoConsumido.getData().time }" pattern="dd-MM-yyyy"/>' required>
		</div>
		<div class="form-group">
			<label for="descricaoInclusao">Descrição</label>
			<input type="text" class="form-control" id="descricaoInclusao" name="descricao" value="${alimentoConsumido.getDescricao() }">
		</div>
		<div class="modal-footer">
			<c:url value="alimentoConsumido" var="link">
				<c:param name="opcao" value="listar" />
			</c:url>
			<a class="btn btn-default" href="${link }">Cancelar</a>
			<input type="submit" class="btn btn-primary btnFinaliza" value="Salvar" />
		</div>
	</form>
</div>
<%@ include file="loadPageFooter.jsp"%>