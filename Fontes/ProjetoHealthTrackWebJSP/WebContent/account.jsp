<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="loadPageHeader.jsp"%>
<div class="container-fluid conteudo">
	<ol class="breadcrumb">
		<li><a href="dashboard.html">Dashboard</a></li>
		<li class="active">Meus dados cadastrais</li>
	</ol>
	<div class="row">
		<div class="col-md-12">
			<h2>Meu dados</h2>
		</div>
	</div>
	<br>
	<div class="row">
		<div class="col-md-4">
			<div class="form-group">
				<label for="nomeCompleto">Nome completo</label> <input type="text"
					class="form-control" id="nomeCompleto" required>
			</div>
			<div class="form-group">
				<label for="altura">Qual sua altura?</label> <input type="text"
					class="form-control tipoNumerico" id="altura" required>
			</div>
			<div class="form-group">
				<label for="dataInclusao">E-mail</label> <input type="email"
					class="form-control tipoEmail" id="dataInclusao" required>
			</div>
		</div>
		<div class="col-md-4">
			<div class="form-group">
				<label for="dataNascimento">Qual sua data de nascimento?</label> <input
					type="text" class="form-control tipoCalendario" id="dataNascimento"
					required>
			</div>
			<div class="form-group">
				<label for="genero">Qual seu gênero?</label> <select
					class="form-control" id="genero">
					<option>Masculino</option>
					<option>Feminino</option>
				</select>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6">
			<button type="button" class="btn btn-success btnFinaliza"
				data-toggle="modal" data-target="#modalAlterar">
				<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
				Alterar
			</button>
			<button type="button" class="btn btn-default" data-toggle="modal"
				data-target="#modalSenha">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
				Alterar senha
			</button>
		</div>
	</div>
	<br>
</div>
<!-- Modal de Alterar senha -->
<div class="container-fluid modal fade" id="modalSenha" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Trocar senhar? Parece
					uma boa idéia!</h4>
			</div>
			<div class="modal-body">
				<form action="">
					<div class="form-group">
						<label for="senhaAtual">Sua senha atual</label> <input
							type="password" class="form-control"
							id="pressaoSistolicaInclusao" value="123456" required>
					</div>
					<div class="form-group">
						<label for="senhaNova">Sua nova senha</label> <input
							type="password" class="form-control" id="senhaNova" required>
					</div>
					<div class="form-group">
						<label for="confirmarSenhaNova">Confirme sua nova senha</label> <input
							type="password" class="form-control" id="confirmarSenhaNova"
							required>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
				<button type="button" class="btn btn-primary btnFinaliza">Confirmar</button>
			</div>
		</div>
	</div>
</div>
<%@ include file="loadPageFooter.jsp"%>