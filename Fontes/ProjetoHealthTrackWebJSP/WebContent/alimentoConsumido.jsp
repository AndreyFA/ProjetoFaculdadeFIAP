<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="loadPageHeader.jsp"%>
<div class="container-fluid conteudo">
	<ol class="breadcrumb">
		<li><a href="dashboard.jsp">Dashboard</a></li>
		<li class="active">Meus alimentos consumidos</li>
	</ol>
	<div class="row">
		<div class="col-md-12">
			<img class="icons hidden-xs" src="resources/img/Food.png" alt="">
			<span class="fonte-titulo">Comeu algo saud�vel?</span>
		</div>
	</div>
	<br>
	<div class="row">
		<div class="col-xs-12 col-md-12">
			<div class="table-responsive">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th class="text-center">Tipo</th>
							<th class="text-center">N� de calorias</th>
							<th class="text-center">Data</th>
							<th class="text-center">Hor�rio</th>
							<th class="text-center">Descri��o</th>
							<th class="text-center">Editar</th>
							<th class="text-center">Remover</th>
						</tr>
					</thead>
					<tbody>						
						<c:forEach items="${alimentosConsumidos }" var="a">
							<tr>
								<td class="text-center">${a.getTipo().getNome() }</td>
								<td class="text-center">${a.getCalorias() }</td>
								<td class="text-center">${a.getHorario() }</td>
								<td class="text-center">${a.getHorario() }</td>
								<td class="text-center">${a.getDescricao() }</td>
								<td align="center">
									<c:url value="alimentoConsumido" var="link">
										<c:param name="opcao" value="editar" />
										<c:param name="codigo" value="${a.getCodigo() }" />
									</c:url>
									<a class="btn btn-default" href="${link }">Editar</a>
								</td>
								<td align="center">
									<a class="btn btn-danger" data-toggle="modal" data-target="#modalRemocao" onclick="codigoExcluir.value = ${a.getCodigo()}">Excluir</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-1">
			<c:url value="alimentoConsumido" var="link">
				<c:param name="opcao" value="cadastrar" />
			</c:url>
			<a class="btn btn-primary" href="${link }">Novo alimento</a>
		</div>
		<div class="col-md-3 col-md-offset-8">
			<nav aria-label="...">
				<ul class="pagination">
					<li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
					<li><a href="#">1 <span class="sr-only">(current)</span></a></li>
					<li><a href="#">2 <span class="sr-only">(current)</span></a></li>
					<li><a href="#">3 <span class="sr-only">(current)</span></a></li>
					<li><a href="#">4 <span class="sr-only">(current)</span></a></li>
					<li><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
				</ul>
			</nav>
		</div>
	</div>
</div>
<!-- Modal de Exclus�o -->
<div class="container-fluid modal fade" id="modalRemocao" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">
					Aten��o!
				</h4>
			</div>
			<div class="modal-body">
				Deseja realmente remover esse item?
			</div>
			<div class="modal-footer">
				<form action="alimentoConsumido" method="post">
					<input type="hidden" name="opcao" value="excluir">
					<input type="hidden" name="codigo" id="codigoExcluir">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<input type="submit" class="btn btn-primary" value="Confirmar">
				</form>				
			</div>
		</div>
	</div>
</div>
<%@ include file="loadPageFooter.jsp"%>