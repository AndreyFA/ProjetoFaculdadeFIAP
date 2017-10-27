<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<div class="row login-panel">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-4 col-md-offset-4">
						<div class="jumbotron login-background">
							<div class="page-header">
								<img src="resources/img/logo.png" alt="" class="hidden-xs"><span
									class="fonte-titulo">HEALTH TRACK</span>
							</div>
							<div class="container-fluid">
								<div class="row">
									<div class="col-md-12">
										<form class="form-horizontal">
											<div class="form-group">
												<label for="login">E-mail</label> <input type="email"
													class="form-control tipoEmail" id="login" required>
											</div>
											<div class="form-group">
												<label for="senha">Senha</label> <input type="password"
													class="form-control" id="senha" required>
											</div>
										</form>
									</div>
									<div class="row">
										<div class="col-md-6">
											<div class="checkbox">
												<label for="manterConectado"> <input type="checkbox"
													id="manterConectado">Manter conectado
												</label>
											</div>
										</div>
										<div class="col-md-6 rememberPassword text-right">
											<span> <a href="rememberPassword.jsp">Esqueci a
													senha</a>
											</span>
										</div>
									</div>
									<br>
									<div class="row">
										<div class="col-md-12">
											<a href="dashboard.jsp" class="btn btn-primary"
												id="btnEntrar"> Entrar </a>
										</div>
									</div>
									<br>
									<div class="row">
										<div class="col-md-12 text-right">
											É novo por aqui? <a href="newAccount.jsp"> Cadastre-se </a>
										</div>
									</div>
								</div>
							</div>
						</div>
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