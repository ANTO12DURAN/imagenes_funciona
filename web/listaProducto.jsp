<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>KuerpoEspin</title>
        <style>
            @media print{
                .accion, .btn{
                    display: none;
                }
            }
        </style>
            
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
            <a class="dropdown-item" href="ServletAdmin.do?accion=RegistroUsuario">Agregar</a> 
             <a class="dropdown-item" href="ServletAdmin.do?accion=ListaUsuario">Listar</a> 
        </div>
      </li>
      </ul>
       <ul class="navbar-nav mr-auto" >
      <li class="nav-item dropdown" >
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Venta
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
             <a class="dropdown-item" href="ServletAdmin.do?accion=ListaVenta">Listar</a> 
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
            <%-- *****************************  CONTENIDO ******************************  --%>
             <br>
    <from>
        
   
             
             <div class="container mt-3">
                   <div class="navbar">
                        <a href="ServletAdmin.do?accion=RegistroProducto" class="btn btn-outline-info">Registrar Producto</a>  
                       <form class="form-inline" action="ServletAdmin.do" method="POST">
                           <input type="search" name="txtBuscar" class="form-control" >
                           <input type="submit" name="accion" value="Buscar Producto" class="btn btn-outline-success">
                       </form>
                       <form class="form-inline" action="ServletAdmin.do" method="POST">
                          <select name="txtStatus" class="form-control">
                                <option value="A">ACTIVO</option>
                                <option value="E">ELIMINADO</option>
                          </select>
                           <input type="submit" name="accion" value="Estatus" class="btn btn-outline-danger">
                       </form>
                   </div>
                   
               </div>  
                                 
            <div class="d-flex"> 
                      
                <div class="col-sm-12">
                    <div class="card">
                        
                        <div class="card-body">
                            
                    <form action="ServletAdmin.do" method="POST" enctype="multipart/form-data">
                                
                                         <img src="img/kuerpoEspin.jpg" height="90" width="80" />
                                         <h3>LISTA DE PRODUCTOS</h3>
                <div class="table-response">
                        <table class="table table-hover">
                            <tr>
                                
                                <th>CODIGO</th>
                                <th>NOMBRE</th>
                                <th>IMAGEN</th>
                                <th>DESCRIPCION</th>
                                <th>PRECIO</th>       
                                <th>STOCK</th>
                                <th>ESTATUS</th>
                                <th class="accion">ACCIONES</th>
                            </tr>
                            <tbody>
                                <c:forEach var="p" items="${productos}">
                             <tr>
                                
                                <td>${p.getCodigo()}</td>
                                <td>${p.getNombre()}</td>
                                <td><img src="${p.getRuta()}" height="90" width="80"/></td>
                                <td>${p.getDescripcion()}</td>
                                <td>$.${p.getPrecio()}0</td>
                              
                                <td>${p.getStock()}</td>
                                <td>${p.getStatus()}</td>
                                <td class="accion">
                                     <a href="ServletAdmin.do?accion=EliminarProducto&id=${p.getId()}">Eliminar</a><br>
                                    <a href="ServletAdmin.do?accion=ModificarProducto&id=${p.getId()}">Modificar</a><br>                                   
                                </td>     
                             </tr>
                                </c:forEach>
                            
                            </tbody>
                        </table>                         
                </div>                                
                   </form> 
                        </div>
                        <div class="card-footer" style="text-align: center" >
                            <form action="ServletAdmin.do" method="POST">
                                <input type="Submit" class="btn btn-danger" name="accion" value="Imprimir Ventas" target="_blank" onclick="window.print()">
                            </form>
                        </div>
                    </div>
            </div>  
        </div>
               
                 
             
    
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
