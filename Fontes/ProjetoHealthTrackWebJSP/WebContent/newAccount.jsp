<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Health Track</title>
<link rel="stylesheet" href="resources/css/healthTrackTheme.css">
</head>
<body>
	<div class="container-fluid">
		<div class="page-header">
			<img src="resources/img/logo.png" alt="" class="hidden-xs"><span
				class="fonte-titulo">HEALTH TRACK</span>
		</div>
		<div class="container-fluid">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label for="nomeCompleto">Nome completo</label> <input
								type="number" class="form-control" id="nomeCompleto">
						</div>
						<div class="form-group">
							<label for="altura">Qual sua altura?</label> <input type="number"
								class="form-control tipoNumerico" id="altura">
						</div>
						<div class="form-group">
							<label for="dataInclusao">E-mail</label> <input type="email"
								class="form-control" id="dataInclusao">
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label for="dataNascimento">Qual sua data de nascimento?</label>
							<input type="date" class="form-control" id="dataNascimento">
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
					<div class="col-md-3">
						<div class="form-group">
							<label for="senhaNova">Você precisa de uma senha</label> <input
								type="password" class="form-control" id="senhaNova">
						</div>
						<div class="form-group">
							<label for="confirmarSenhaNova">Confirme sua senha</label> <input
								type="password" class="form-control" id="confirmarSenhaNova">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<button type="button" class="btn btn-success">
							<span></span> Confirmar
						</button>
						<a class="btn btn-default" href="login.jsp"> <span></span>
							Cancelar
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="resources/js/jquery-3.2.1.js"></script>
	<script src="resources/js/bootstrap.js"></script>
	<script src="resources/js/jquery-ui.min.js"></script>
	<script src="resources/js/jquery.mask.min.js"></script>
	<script src="resources/js/healthTrackScript.js"></script>
</body>
</html>