<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link href="css/alertify.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/default.min.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>KuerpoEspin</title>
    </head>
    <body>
         <%--  **************************** MENU DE ADMINISTRADOR *********************************  --%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="ServletControlador.do?accion=Home"></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
        
           
        
      
    </ul>
  </div>
   
       <ul class="navbar-nav mr-auto" >
      <a style="color: #ffc107">
          Bienvenido ${usuario.getNombre()} ${usuario.getApellido()}
        </a>
    </ul>
</nav>
        
        
        
       
        <br>
      <div class="container mt-8"  style="display: flex; align-items: center; justify-content: center" >
            <div class="row">
                <form action="ServletControlador.do" method="POST" enctype="multipart/form-data">
                     <div class="col-sm-12">
                    <div class="card">
                        <div class="card-header text-center">
                            <h2>FORMA DE PAGO</h2>
                        </div>
                        <div class="card-body text-center">
                          <h5>Tienes 2 Formas de Pago:</h5>
                          <br><p>EFECTIVO: Este metodo se realiza contra/Entrega, con ello pagas tus productos cuando los recibes.</p> 
                          <br><p> TRANSFERENCIA: Por los momentos manejamos Bancolombia.</p> 
                                <h4>Selecciona tu tipo de Pago!!</h4><br>
                                 <h5>Pago:</h5>
                           
                            <select name="txtTipoPago" class="form-control">
                                <option>EFECTIVO</option>
                                <option>TRANSFERENCIA</option>
                            </select><br> 
                            <h6 class="text-center">Para mas informacion escribemos </h6>
                            <h5 class="text-center"> whatsapp: +573132353665</h5>
                            
                        </div>
                        <div class="card-footer text-center" enctype="multipart/form-data">
                            <div>
                                <input type="submit" name="accion" value="Pago">
                                <input type="submit" name="accion" value="Regresar"><br>
                            </div>
                        </div>
                    </div>
                  </div>
                </form>           
            </div>
        </div> 
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>  
<script src="js/alertify.min.js" type="text/javascript"></script>        
    </body>
</html>
