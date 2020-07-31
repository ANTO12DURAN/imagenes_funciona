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
       
        <div class="container mt-4" style="display: flex; align-items: center; justify-content: center">
           <form action="resultadoOlvidoClave.jsp" method="POST" name="frmLogin">
                <div class="col-sm-12">
                    <div class="card">
                        <div class="card-header text-center">
                             <h3>OlVIDO SU CONTRASEÑA</h3>
                        </div>   
                        <div class="card-body text-center">
          
                <P>Por favor, Escriba su correo en el campo a continuacion...</p>
                    <p>En el se le enviará la contraseña registrada</P>
                
                    <td>CORREO: </td>
                    <td><input type="text" name="txtCorreo"></td>
               
               
                        <input type="hidden" name="txtMensaje" value="Recuperar Clave:
                             correo: ${usu.getCorreo()}
                             clave: ${usu.getClave()} ">   
                   
                        </div>   
                    <div class="card-footer text-center">
                         <input type="submit" name="" value="Enviar">
                    </div>   
                    </div>
                        
                 </div>   
          
        </form> 
        </div>
        
                     
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>  
<script src="js/alertify.min.js" type="text/javascript"></script>
    </body>
</html>


