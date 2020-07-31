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
  <a class="navbar-brand" href="#">KuerpoEspin</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
        
           
      
    </ul>
  </div>
   
       <ul class="navbar-nav mr-auto" >
           <a style="color: #ffc107" class="nav-link" href="ServletControlador.do?accion=Salir">Salir</a>
    </ul>
</nav>
        
       <br>
        
        <div class="container mt-12" style="display: flex; align-items: center; justify-content: center" >
            <div class="row">
                <form name="frmRegistro" action="ServletAdmin.do" method="POST" onsubmit="return validar_camposR()">
                     <div class="col-sm-12">
                    <div class="card">
                        <div class="card-header text-center">
                            <h4>MIS DATOS</h4>
                        </div>
                        <div class="card-body text-center">
                            <input type="hidden" name="txtIdUsuario" value="${usuario.getIdUsuario()}">
                            <div class="d-flex">
                                <div class="col-sm-3">
                                    <label>Nombre:</label>     
                                </div>
                                 <div class="col-sm-9">
                                     <input type="text" name="txtNombre" value="${usuario.getNombre()}"  class="form-control"><br>
                                 </div>  
                            </div>
                            <div class="d-flex"> 
                                <div class="col-sm-3">
                                    <label>Apellido:</label>     
                                </div>
                                 <div class="col-sm-9">
                                     <input type="text" name="txtApellido" value="${usuario.getApellido()}" class="form-control"><br>
                                 </div>  
                            </div>
                            <div class="d-flex">
                                
                                <div class="col-sm-3">
                                    <label>Correo:</label>     
                                </div>
                                 <div class="col-sm-9">
                                     <input type="email" name="txtCorreo" value="${usuario.getCorreo()}" class="form-control"><br>
                                 </div>  
                            </div>
                            <div class="d-flex"> 
                                <div class="col-sm-3">
                                    <label>Dni:</label>     
                                </div>
                                 <div class="col-sm-4">
                                     <input type="text" name="txtDni" value="${usuario.getDni()}" class="form-control">
                                 </div>  
                                <div class="col-sm-2">
                                    <label>Clave:</label>     
                                </div>
                                 <div class="col-sm-3">
                                     <input type="password" name="txtClave" value="${usuario.getClave()}" class="form-control"><br>
                                 </div> 
                            </div>
                            <div class="d-flex"> 
                                <div class="col-sm-3">
                                    <label>Telefono:</label>     
                                </div>
                                 <div class="col-sm-9">
                                     <input type="tel" name="txtTelefono" value="${usuario.getTelefono()}" class="form-control"><br>
                                 </div>  
                            </div>
                             <div class="d-flex"> 
                                <div class="col-sm-3">
                                    <label>Dirección:</label>     
                                </div>
                                 <div class="col-sm-9">
                                     <textarea name="txtDireccion" cols="10" class="form-control">${usuario.getDireccion()}</textarea><br>
                                 </div>  
                            </div>
                            <div class="d-flex"> 
                                <div class="col-sm-3">
                                    <label>Perfil:</label>     
                                </div>
                                 <div class="col-sm-9">
                                     <select name="txtPerfil" value="${usuario.getPerfil()}" class="form-control">
                                         <option style="color: tomato">${usuario.getPerfil()}</option>
                                         <option>CLIENTE</option>
                                         <option>ADMINISTRADOR</option>
                                     </select><br>
                                 </div>  
                            </div> 
                            <div class="d-flex"> 
                                <div class="col-sm-3">
                                    <label>Status:</label>     
                                </div>
                                 <div class="col-sm-9">
                                     <select name="txtStatus" value="${usuario.getStatus()}" class="form-control">
                                         <option style="color: tomato">${usuario.getStatus()}</option>
                                         <option value="A">ACTIVO</option>
                                         <option value="E">ELIMINADO</option>
                                     </select>
                                 </div>  
                            </div> 
                        </div>
                        <div class="card-footer text-center" enctype="multipart/form-data">
                            <div>
                                <a href="ServletAdmin.do?accion=ListaUsuario" class="btn btn-outline-info">Regresar</a>
                                <input type="submit" name="accion" value="Actualizar Usuario" class="btn btn-danger">
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
