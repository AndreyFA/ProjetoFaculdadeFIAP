<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="loadPageHeader.jsp"%>
<div class="container-fluid conteudo">
	<c:if test="${not empty mensagemSucesso}">
		<div class="alert alert-success">${mensagemSucesso }</div>
	</c:if>
	<c:if test="${not empty mensagemErro}">
		<div class="alert alert-danger">${mensagemErro }</div>
	</c:if>
	<ol class="breadcrumb">
		<li><a href="dashboard.jsp">Dashboard</a></li>
		<li class="active">Meus dados cadastrais</li>
	</ol>
	<div class="row">
		<div class="col-md-12">
			<h2>Meu dados</h2>
		</div>
	</div>
	<br>
	<form action="usuario" method="post">
		<input type="hidden" name="codigo" value="${usuario.getCodigo() }">
		<input type="hidden" name="opcao" value="editarUsuario">
		<div class="row">
			<div class="col-md-4">
				<div class="form-group">
					<label for="nomeCompleto">Nome completo</label> 
					<input type="text" class="form-control" id="nomeCompleto" name="nome" value="${usuario.getNomeCompleto() }" required>
				</div>
				<div class="form-group">
					<label for="altura">Qual sua altura?</label> 
					<input type="text" class="form-control tipoNumerico" id="altura" name="altura" value='<fmt:formatNumber type="number" maxFractionDigits="0" value="${usuario.getAltura() }" />' required>
				</div>
				<div class="form-group">
					<label for="email">E-mail</label> 
					<input type="email" class="form-control tipoEmail" id="email" name="email" value="${usuario.getEmail() }" required>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label for="dataNascimento">Qual sua data de nascimento?</label> 
					<input type="text" class="form-control tipoCalendario" id="dataNascimento" name="dataNascimento" value='<fmt:formatDate value="${usuario.getDataNascimento().time }" pattern="dd-MM-yyyy"/>' required>
				</div>
				<div class="form-group">
					<label for="genero">Qual seu gênero?</label> 
					<select class="form-control" id="genero" name="genero">
						<c:if test='${usuario.getGenero().equals("M") }'>
							<option value="${usuario.getGenero() }" selected>Masculino</option>
							<option value="F">Feminino</option>
						</c:if>
						<c:if test='${usuario.getGenero().equals("F") }'>
							<option value="${usuario.getGenero() }" selected>Feminino</option>
							<option value="M">Masculino</option>
						</c:if>
					</select>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<input type="submit" class="btn btn-primary btnFinaliza" value="Alterar" />
				<button type="button" class="btn btn-default" data-toggle="modal" data-target="#modalSenha">
					Alterar senha
				</button>
			</div>
		</div>
	</form>
	<br>
</div>
<!-- Modal de Alterar senha -->
<div class="container-fluid modal fade" id="modalSenha" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Trocar senhar? Parece uma boa idéia!</h4>
			</div>
			<div class="modal-body">
				<form action="usuario" method="post">
					<input type="hidden" name="opcao" value="alterarSenha">
					<div class="form-group">
						<label for="senhaAtual">Sua senha atual</label> 
						<input type="password" class="form-control" id="senhaAtual" name="senha" required>
					</div>
					<div class="form-group">
						<label for="senhaNova">Sua nova senha</label> 
						<input type="password" class="form-control" id="senhaNova" name="novaSenha" required>
					</div>
					<div class="form-group">
						<label for="confirmarSenhaNova">Confirme sua nova senha</label> 
						<input type="password" class="form-control" id="confirmarSenhaNova" name="confirmacaoNovaSenha" required>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
						<input type="submit" class="btn btn-primary btnFinaliza" value="Confirmar">
					</div>
				</form>
			</div>			
		</div>
	</div>
</div>
<%@ include file="loadPageFooter.jsp"%>