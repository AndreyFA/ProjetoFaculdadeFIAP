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
            <img src="resources/img/logo.png" alt="" class="hidden-xs"><span class="fonte-titulo">HEALTH TRACK</span>                     
        </div>
        <div class="container-fluid">
            <div class="col-md-12">
                 <h2>Esqueceu a senha? Relaxa! Nós te lembramos</h2>
                 <br>
                <div class="row">                           
                    <div class="col-md-4">                                 
                        <div class="form-group">
                            <label for="email">Só precisamos do seu e-mail de acesso</label>
                            <input type="email" class="form-control tipoEmail" id="email" required>
                        </div>                       
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <button type="button" class="btn btn-success btnFinaliza">
                            <span></span> Recuperar
                        </button>
                        <a class="btn btn-default" href="login.jsp">
                            <span></span> Cancelar
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