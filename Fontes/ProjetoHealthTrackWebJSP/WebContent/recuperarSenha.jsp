<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	                <h2>Esqueceu a senha? Relaxa! Nós te lembramos</h2>
	                <br>
	                <form action="usuario" method="post">
	                	<input type="hidden" name="opcao" value="recuperarSenha">
	                	<div class="row">                           
		                    <div class="col-md-4">                                 
		                        <div class="form-group">
		                            <label for="email">Só precisamos do seu e-mail de acesso</label>
		                            <input type="email" class="form-control tipoEmail" id="email" name="email" required>
		                        </div>                       
		                    </div>
		                </div>
		                <div class="row">
		                    <div class="col-md-6">
		                    	<input type="submit" class="btn btn-success btnFinaliza" value="Recuperar">
		                        <a class="btn btn-default" href="login.jsp">Cancelar</a>
		                    </div>                        
		                </div>
	                </form>                
	            </div>
	            <div class="col-md-12">
	            	<c:if test="${not empty senha }">
	            		<span>
	            			${senha }
	            		</span>
	            	</c:if>
	            </div>               
	        </div>
	    </div>  
	    <%@ include file="loadScriptsJS.jsp" %>
	</body>
</html>