<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Health Track</title>
<%@ include file="loadScriptsCSS.jsp"%>
</head>
<body>
	<div class="container-fluid">
		<div class="row login-panel">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-4 col-md-offset-4">
						<div class="jumbotron login-background">
							<div class="page-header">
								<img src="resources/img/logo.png" alt="" class="hidden-xs">
								<span class="fonte-titulo">HEALTH TRACK</span>
							</div>
							<div class="container-fluid">
							<c:if test="${not empty mensagemSucesso}">
								<div class="alert alert-success">${mensagemSucesso }</div>
							</c:if>
							<c:if test="${not empty mensagemErro}">
								<div class="alert alert-danger">${mensagemErro }</div>
							</c:if>
								<div class="row">
									<div class="col-md-12">
										<form class="form-horizontal" action="dashboard" method="post">
											<div class="form-group">
												<label for="login">E-mail</label> 
												<input type="email" class="form-control tipoEmail" id="login" name="email" required>
											</div>
											<div class="form-group">
												<label for="senha">Senha</label> 
												<input type="password" class="form-control" id="senha" name="senha" required>
											</div>
											<div class="row">
												<div class="col-md-12">
													<input type="submit" class="btn btn-primary" value="Entrar">
												</div>
											</div>
										</form>
									</div>
									<br>
									<br>
									<div class="row">
										<div class="col-md-12 text-right">
											É novo por aqui? <a href="novoUsuario.jsp"> Cadastre-se </a>
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
	<%@ include file="loadScriptsJS.jsp"%>
</body>
</html>