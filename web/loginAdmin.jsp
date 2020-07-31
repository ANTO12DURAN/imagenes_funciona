<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/alertify.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/default.min.css" rel="stylesheet" type="text/css"/>
        <title>KuerpoEspin</title>
    </head>
    <body>
        
        <%-- ****************************   MENU *************************************** --%>
        
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="ServletControlador.do?accion=Home">KuerpoEspin</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
</nav>
        
        <br>
        
        <div class="container mt-12" style="display: flex; align-items: center; justify-content: center" >
            <div class="row">
                <form name="frmLogin" action="ServletAdmin.do" method="POST" onsubmit="return validar_campos()">
                     <div class="col-sm-12">
                    <div class="card">
                        <div class="card-header text-center">
                            <h4>INGRESAR</h4>
                        </div>
                        <div class="card-body text-center">
                            <input type="hidden" name="txtIdUsuario" value="">
                            <div class="d-flex">
                                <div class="col-sm-3">
                                    <label>CORREO:</label>     
                                </div>
                            <div class="col-sm-9">
                                <input type="email" name="txtCorreo" class="form-control">  
                            </div>  
                            </div>
                            <div class="d-flex">
                                <div class="col-sm-3">
                                    <label>CLAVE:</label>     
                                </div><br>
                            <div class="col-sm-9">
                                <input type="password" name="txtClave" class="form-control">
                            </div>  
                            </div>
                        </div>
                        <div class="card-footer text-center" enctype="multipart/form-data">
                            <div>
                                
                                <input type="submit" name="accion" value="Ingresar"><br>
                                
                                
                            </div>
                        </div>
                    </div>
                </div>
                </form>     
           
            </div>
        </div> 
        <!--script validar campos not null -->
        <script>
            function validar_campos(){
                correo = document.frmLogin.txtCorreo.value;
                clave = document.frmLogin.txtClave.value;
                if(correo.length == 0 || clave.length == 0){
                    alertify.alert("Campos vacios", "Ingrese sus datos, por favor!").set('label', 'ok');
                    return false;
                } else {
                    return true;
                }
            }
           
        </script>
      
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>  
<script src="js/alertify.min.js" type="text/javascript"></script>
    </body>
</html>


