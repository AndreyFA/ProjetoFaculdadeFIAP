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
	                <h2>Aqui está sua senha!</h2>
	                <br>
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