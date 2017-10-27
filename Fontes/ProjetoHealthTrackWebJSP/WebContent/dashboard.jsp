<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Health Track | Dashboard</title>
<link rel="stylesheet" href="resources/css/healthTrackTheme.css">
</head>
<body>
	<div class="container-fluid">
		<div class="page-header">
			<img src="resources/img/logo.png" alt="" class="hidden-xs"><span
				class="fonte-titulo">HEALTH TRACK</span>
		</div>
		<div class="container-fluid">
			<div class="row">
				<%@ include file="menu.jsp"%>
				<hr class="visible-xs visible-sm">
				<div class="col-md-11">
					<div class="container-fluid conteudo">
						<h1>Olá usuário!</h1>
						<h4>Seja bem-vindo ao seu Dashboard.</h4>
						<br>
						<div class="row">
							<div class="col-md-6">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h3>Sua idade é</h3>
									</div>
									<div class="panel-body text-center">
										<h1>
											25<small> anos</small>
										</h1>
									</div>
									<div class="panel-footer">
										<h4>De pura saúde!</h4>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h3>Seu indíce de massa corporal (IMC) é</h3>
									</div>
									<div class="panel-body text-center">
										<h1>22,3</h1>
									</div>
									<div class="panel-footer text-center">
										<h4>Normal</h4>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h3>Seu peso</h3>
									</div>
									<div class="panel-body text-center">
										<h1>
											68,25<small> kg</small>
										</h1>
									</div>
									<div class="panel-footer">
										<h4>Registrado em 01/04/2017</h4>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h3>Sua pressão arterial</h3>
									</div>
									<div class="panel-body text-center">
										<h1>
											123/85<small> mmHg</small>
										</h1>
									</div>
									<div class="panel-footer">
										<h4>Registrado em 01/04/2017</h4>
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