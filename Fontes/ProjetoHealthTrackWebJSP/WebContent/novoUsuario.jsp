<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Health Track</title>
<%@ include file="loadScriptsCSS.jsp" %>
</head>
<body>
	<div class="container-fluid">
		<div class="page-header">
			<img src="resources/img/logo.png" alt="" class="hidden-xs">
			<span class="fonte-titulo">HEALTH TRACK</span>
		</div>
		<div class="container-fluid">
			<div class="col-md-12">
				<form action="usuario" method="post">
					<input type="hidden" name="opcao" value="novoUsuario">
					<div class="row">					
						<div class="col-md-4">
							<div class="form-group">
								<label for="nomeCompleto">Nome completo</label> 
								<input class="form-control" id="nomeCompleto" name="nome">
							</div>
							<div class="form-group">
								<label for="altura">Qual sua altura?</label> 
								<input class="form-control tipoNumerico" id="altura" name="altura">
							</div>
							<div class="form-group">
								<label for="dataInclusao">E-mail</label> 
								<input type="email" class="form-control tipoEmail" id="dataInclusao" name="email">
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label for="dataNascimento">Qual sua data de nascimento?</label>
								<input class="form-control tipoCalendario" id="dataNascimento" name="dataNascimento">
							</div>
							<div class="form-group">
								<label for="genero">Qual seu gênero?</label> 
								<select class="form-control" id="genero" name="genero">
									<option value="M">Masculino</option>
									<option value="F">Feminino</option>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-3">
							<div class="form-group">
								<label for="senhaNova">Você precisa de uma senha</label> 
								<input type="password" class="form-control" id="senhaNova" name="senha">
							</div>
							<div class="form-group">
								<label for="confirmarSenhaNova">Confirme sua senha</label> 
								<input type="password" class="form-control" id="confirmarSenhaNova" name="confirmacaoSenha">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<input type="submit" class="btn btn-success" value="Confirmar">
							<a class="btn btn-default" href="login.jsp">Cancelar</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<%@ include file="loadScriptsJS.jsp" %>
</body>
</html>