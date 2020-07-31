<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>KuerpoEspin</title>
    </head>
    <body>
                <%--  **************************** MENU DE ADMINISTRADOR *********************************  --%>
        
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="ServletAdmin.do?accion=Home">KuerpoEspin</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
  
        <ul class="navbar-nav mr-auto" >
      <li class="nav-item dropdown" >
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Producto
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          
            <a class="dropdown-item" href="ServletAdmin.do?accion=RegistroProducto">Registrar</a> 
            <a class="dropdown-item" href="ServletAdmin.do?accion=ListaProducto">Listar</a> 
        </div>
      </li>
         </ul>
      <ul class="navbar-nav mr-auto" >
      <li class="nav-item dropdown" >
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Usuario
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
            <a class="dropdown-item" href="#">Agregar</a> 
             <a class="dropdown-item" href="#">Listar</a> 
        </div>
      </li>
      </ul>
       <ul class="navbar-nav mr-auto" >
      <li class="nav-item dropdown" >
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Venta
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
             <a class="dropdown-item" href="">Listar</a> 
        </div>
      </li>
        </ul>  
     
    </ul>
  </div>
      <ul class="navbar-nav mr-auto" >
          <li class="nav-item dropdown" >
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Bienvenido ${usuario.getNombre()} ${usuario.getApellido()}
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
            <a class="dropdown-item" href="ServletAdmin.do?accion=MisDatos&id=${usuario.getIdUsuario()}">Mis Datos</a> 
            <a class="dropdown-item" href="ServletAdmin.do?accion=Salir">Cerrar Sesión</a> 
        </div>
          </li>
      
    </ul>
</nav>
            
            <%-- ####################### CONTENIDO ############################# --%>
        
        <div class="container mt-5">
            <form action="ServletAdmin.do" class="col-md-9" method="POST">
                <div class="card">
                <div class="card-header text-center">
                    <h3>Actualizar Producto</h3>
                </div>
                <div class="card-body">
                     <div class="d-flex">
                          <input type="hidden" name="txtId" value="${producto.getId()}" >
                         <div class="col-sm-3">
                                <label>Codigo del Producto:</label>
                         </div>
                         <div class="col-sm-3">
                             <input type="text" name="txtCodigo" value="${producto.getCodigo()}" readonly="" class="form-control">
                             <br>
                         </div>
                     </div>   
                        <div class="d-flex">
                            <div class="col-sm-3">
                                 <label>Nombre del Producto:</label>
                            </div>
                      <div class="col-sm-9">
                          <input type="text" name="txtNombre" value="${producto.getNombre()}" class="form-control"><br>
                            </div>
                          </div>
                              <div class="d-flex">
                            <div class="col-sm-3">
                                <label>Descripcion:</label>
                            </div>
                      <div class="col-sm-9">
                          <input type="text" name="txtDescripcion" value="${producto.getDescripcion()}" class="form-control"><br>
                            </div>
                        
                          </div>
                             <div class="d-flex">
                                 <div class="col-sm-3">
                                       <label>Precio:</label>
                                 </div>
                                 <div class="col-sm-3">
                                     <input type="text" name="txtPrecio" value="${producto.getPrecio()}" class="form-control">
                                 </div>
                                 <div class="col-sm-3">
                                         <label>Stock:</label>
                                 </div>
                                 <div class="col-sm-3">
                                     <input type="number" name="txtStock" value="${producto.getStock()}" class="form-control"> <br>
                                 </div>
                             </div> 
                                 <div class="d-flex">
                         <div class="col-sm-3">
                                <label>Status:</label>
                         </div>
                         <div class="col-sm-3">
                             <select name="txtStatus" value="${producto.getStatus()}" class="form-control">
                                 <option style="color: #ffc107">${producto.getStatus()}</option>
                                 <option>A</option>
                                 <option>E</option>
                             </select>
                                
                             <br>
                         </div>
                     </div>   
                             <br>
                
            </div>
                                 <div class="card-footer text-center ">
                                     <input type="submit" class="btn btn-outline-primary" name="accion" value="Actualizar">
                </div>
                </div> 
            </form>
          
       
       
        </div>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>    
    </body>
</html>
