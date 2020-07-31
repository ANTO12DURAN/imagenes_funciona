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
        <%--  **************************** MENU DE ADMINISTRADOR *********************************  --%>
 <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="ServletControlador.do?accion=Home">KuerpoEspin</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
</nav>
        
       <br>
        
        <div class="container mt-12" style="display: flex; align-items: center; justify-content: center" >
            <div class="row">
                <form name="frmRegistro" action="ServletAdmin.do" method="POST" onsubmit="return validar_camposR()">
                     <div class="col-sm-12">
                    <div class="card">
                        <div class="card-header text-center">
                            <h4>REGISTRAR NUEVO USUARIO</h4>
                        </div>
                        <div class="card-body text-center">
                            <input type="hidden" name="txtIdUsuario" value="">
                            <div class="d-flex">
                                <div class="col-sm-3">
                                    <label>Nombre:</label>     
                                </div>
                                 <div class="col-sm-9">
                                     <input type="text" name="txtNombre" class="form-control"><br>
                                 </div>  
                            </div>
                            <div class="d-flex"> 
                                <div class="col-sm-3">
                                    <label>Apellido:</label>     
                                </div>
                                 <div class="col-sm-9">
                                     <input type="text" name="txtApellido" class="form-control"><br>
                                 </div>  
                            </div>
                            <div class="d-flex">
                                
                                <div class="col-sm-3">
                                    <label>Correo:</label>     
                                </div>
                                 <div class="col-sm-9">
                                     <input type="email" name="txtCorreo" class="form-control"><br>
                                 </div>  
                            </div>
                            <div class="d-flex"> 
                                <div class="col-sm-3">
                                    <label>Dni:</label>     
                                </div>
                                 <div class="col-sm-4">
                                     <input type="text" name="txtDni" class="form-control">
                                 </div>  
                                <div class="col-sm-2">
                                    <label>Clave:</label>     
                                </div>
                                 <div class="col-sm-3">
                                     <input type="password" name="txtClave" class="form-control"><br>
                                 </div> 
                            </div>
                            <div class="d-flex"> 
                                <div class="col-sm-3">
                                    <label>Telefono:</label>     
                                </div>
                                 <div class="col-sm-9">
                                     <input type="tel" name="txtTelefono" class="form-control"><br>
                                 </div>  
                            </div>
                             <div class="d-flex"> 
                                <div class="col-sm-3">
                                    <label>Dirección:</label>     
                                </div>
                                 <div class="col-sm-9">
                                     <textarea name="txtDireccion" cols="10"  class="form-control"></textarea><br>
                                 </div>  
                            </div>
                               <div class="d-flex"> 
                                <div class="col-sm-3">
                                    <label>Perfil:</label>     
                                </div>
                                 <div class="col-sm-9">
                                     <select name="txtPerfil" class="form-control">
                                         <option>ADMINISTRADOR</option>
                                         <option>CLIENTE</option>
                                     </select><br>
                                 </div>  
                            </div>
                            <div class="d-flex"> 
                                <div class="col-sm-3">
                                    <label>Status:</label>     
                                </div>
                                 <div class="col-sm-9">
                                     <select name="txtStatus" class="form-control"> 
                                         <option value="A">ACTIVO</option>
                                         <option value="E">ELIMINADO</option>
                                     </select>
                                 </div>  
                            </div> 
                        </div>
                        <div class="card-footer text-center" enctype="multipart/form-data">
                            <div>
                                
                                <input type="submit" name="accion" value="Registrar" class="btn btn-outline-primary">
                                <a href="ServletAdmin.do?accion=ListaUsuario" class="btn btn-outline-danger">Regresar</a>
                                
                            </div>
                        </div>
                    </div>
                </div>
                </form>     
           
            </div>
        </div> 
        <!--script validar campos not null -->
        <script>
            function validar_camposR(){
                nombre = document.frmRegistro.txtNombre.value;
                apellido = document.frmRegistro.txtApellido.value;
                correo = document.frmRegistro.txtCorreo.value;
                dni = document.frmRegistro.txtDni.value;
                clave = document.frmRegistro.txtClave.value;
                telefono = document.frmRegistro.txtTelefono.value;
                direccion = document.frmRegistro.txtDireccion.value;
                if(nombre.length == 0 || apellido.length == 0 || correo.length == 0 || dni.length == 0 || clave.length == 0 || telefono.length == 0 || direccion.length == 0){
                    alertify.alert("Campos vacios", "Debe llenar todos los campos!").set('label', 'ok');
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



