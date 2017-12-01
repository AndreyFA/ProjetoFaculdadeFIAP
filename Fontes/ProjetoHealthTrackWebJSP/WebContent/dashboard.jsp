<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="loadPageHeader.jsp"%>
<div class="container-fluid conteudo">
	<h1>Olá ${nomeUsuario }!</h1>
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
						${idade }<small> anos</small>
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
					<h1>
						<fmt:formatNumber type="number" maxFractionDigits="2" value="${IMC }"/>	
					</h1>
				</div>
				<div class="panel-footer text-center">
					<h4>${situacaoIMC }</h4>
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
						${peso }<small> kg</small>
					</h1>
				</div>
				<div class="panel-footer">
					<h4>Registrado em 
						<c:if test="${not empty dataUltimoPeso }">
							<fmt:formatDate value="${dataUltimoPeso.time }" pattern="dd/MM/yyyy"/>
						</c:if> 
					</h4>
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
						${pressaoSistolica }/${pressaoDiastolica }<small> mmHg</small>
					</h1>
				</div>
				<div class="panel-footer">
					<h4>Registrado em 
						<c:if test="${not empty dataUltimaPressao }">
							<fmt:formatDate value="${dataUltimaPressao.time }" pattern="dd/MM/yyyy"/>
						</c:if>
					</h4>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="loadPageFooter.jsp"%>