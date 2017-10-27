<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Health Track | Pressão arterial</title>
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
						<ol class="breadcrumb">
							<li><a href="dashboard.html">Dashboard</a></li>
							<li class="active">Minha pressão</li>
						</ol>
						<div class="row">
							<div class="col-md-12">
								<img class="icons" src="../img/Pressure.png" alt=""><span
									class="fonte-titulo"> Como está o coração?</span>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-md-12">
								<div class="table-responsive">
									<table class="table table-bordered">
										<thead>
											<tr>
												<th class="text-center">Pressão sistólica</th>
												<th class="text-center">Pressão diástolica</th>
												<th class="text-center">Data</th>
												<th class="text-center">Situação</th>
												<th class="text-center">Editar</th>
												<th class="text-center">Remover</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td class="text-center">123</td>
												<td class="text-center">84</td>
												<td class="text-center">01/04/2017</td>
												<td class="text-center">Normal</td>
												<td><a class="icone-tabela" href="#"
													data-toggle="modal" data-target="#modalEdicao"> <span
														class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
												</a></td>
												<td><a class="icone-tabela" href="#"
													data-toggle="modal" data-target="#modalRemocao"> <span
														class="glyphicon glyphicon-trash" aria-hidden="true"></span>
												</a></td>
											</tr>
											<tr>
												<td class="text-center">123</td>
												<td class="text-center">84</td>
												<td class="text-center">01/04/2017</td>
												<td class="text-center">Normal</td>
												<td><a class="icone-tabela" href="#"
													data-toggle="modal" data-target="#modalEdicao"> <span
														class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
												</a></td>
												<td><a class="icone-tabela" href="#"
													data-toggle="modal" data-target="#modalRemocao"> <span
														class="glyphicon glyphicon-trash" aria-hidden="true"></span>
												</a></td>
											</tr>
											<tr>
												<td class="text-center">123</td>
												<td class="text-center">84</td>
												<td class="text-center">01/04/2017</td>
												<td class="text-center">Normal</td>
												<td><a class="icone-tabela" href="#"
													data-toggle="modal" data-target="#modalEdicao"> <span
														class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
												</a></td>
												<td><a class="icone-tabela" href="#"
													data-toggle="modal" data-target="#modalRemocao"> <span
														class="glyphicon glyphicon-trash" aria-hidden="true"></span>
												</a></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-1">
								<button type="button" class="btn btn-primary"
									data-toggle="modal" data-target="#modalInclusao">
									<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
									Nova Medição
								</button>
							</div>
							<div class="col-md-3 col-md-offset-8">
								<nav aria-label="...">
									<ul class="pagination">
										<li class="disabled"><a href="#" aria-label="Previous"><span
												aria-hidden="true">&laquo;</span></a></li>
										<li><a href="#">1 <span class="sr-only">(current)</span></a></li>
										<li><a href="#">2 <span class="sr-only">(current)</span></a></li>
										<li><a href="#">3 <span class="sr-only">(current)</span></a></li>
										<li><a href="#">4 <span class="sr-only">(current)</span></a></li>
										<li><a href="#" aria-label="Next"><span
												aria-hidden="true">&raquo;</span></a></li>
									</ul>
								</nav>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal de Inclusão -->
	<div class="container-fluid modal fade" id="modalInclusao"
		tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Aposto que está
						ótima!</h4>
				</div>
				<div class="modal-body">
					<form action="">
						<div class="form-group">
							<label for="pressaoSistolicaInclusao">Pressão sistólica</label> <input
								type="text" class="form-control tipoNumerico"
								id="pressaoSistolicaInclusao" required>
						</div>
						<div class="form-group">
							<label for="pressaoDiastolicaInclusao">Pressão diastólica</label>
							<input type="text" class="form-control tipoNumerico"
								id="pressaoDiastolicaInclusao" required>
						</div>
						<div class="form-group">
							<label for="dataInclusao">Data</label> <input type="text"
								class="form-control tipoCalendario" id="dataInclusao" required>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<button type="button" class="btn btn-primary btnFinaliza">Salvar</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal de Edição -->
	<div class="container-fluid modal fade" id="modalEdicao" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Alterar pressão
						arterial</h4>
				</div>
				<div class="modal-body">
					<form action="">
						<div class="form-group">
							<label for="pressaoSistolicaInclusao">Pressão sistólica</label> <input
								type="text" class="form-control tipoNumerico"
								id="pressaoSistolicaEdicao" value="123" required>
						</div>
						<div class="form-group">
							<label for="pressaoDiastolicaInclusao">Pressão diastólica</label>
							<input type="text" class="form-control tipoNumerico"
								id="pressaoDiastolicaEdicao" value="84" required>
						</div>
						<div class="form-group">
							<label for="dataInclusao">Data</label> <input type="text"
								class="form-control tipoCalendario" id="dataEdicao"
								value="01-04-2017" required>
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
	<!-- Modal de Remoção -->
	<div class="container-fluid modal fade" id="modalRemocao" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Deseja realmente
						remover esse item?</h4>
				</div>
				<div class="modal-body">
					<form action="">
						<div class="form-group">
							<label for="pressaoSistolicaInclusao">Pressão sistólica</label> <input
								type="text" class="form-control tipoNumerico"
								id="pressaoSistolicaRemocao" value="123" disabled>
						</div>
						<div class="form-group">
							<label for="pressaoDiastolicaInclusao">Pressão diastólica</label>
							<input type="text" class="form-control tipoNumerico"
								id="pressaoDiastolicaRemocao" value="84" disabled>
						</div>
						<div class="form-group">
							<label for="dataInclusao">Data</label> <input type="text"
								class="form-control tipoCalendario" id="dataRemocao"
								value="01-04-2017" disabled>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<button type="button" class="btn btn-primary">Confirmar</button>
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