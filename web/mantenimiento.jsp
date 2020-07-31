<%-- 
    Document   : mantenimiento
    Created on : 18-jun-2020, 14:40:59
    Author     : antonieta
--%>

<%@page import="java.util.List"%>
<%@page import="com.modelo.Producto"%>
<%@page import="com.modeloDAO.ProductoDAO"%>
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
         
          <%-- ############# listado de productos activos ############### --%>       
        
        <%
            ProductoDAO pdao=new ProductoDAO();
           List<Producto>productos=pdao.listar();
               request.setAttribute("productos", productos);  
        %>    
       
            <div  class="container mt-4 text-center">
                <div class="row">
                    
             <c:forEach var="p" items="${productos}">
                 <div class="col-sm-4 text-center">
            <div class="card text-center">
                <div class="card-header text-center">
                    <h3>${p.getNombre()}</h3> 
                </div>
                <div class="card-body text-center">
                    ${p.getCodigo()} <br>
                    <img src="${p.getRuta()}" height="200" width="180"/><br>
                     ${p.getDescripcion()} 
                </div>
                <div class="card-footer text-center">
                    <a href="ServletAdmin.do?accion=ModificarProducto&id=${p.getId()}" class="btn btn-outline-primary">Modificar</a>
                </div>
            </div>
                </div>
                 </c:forEach>
           </div>   
        </div> 
        
        <br>
        
         <footer class="text-center">
        <a href="index.jsp" >Principal</a>
        </footer>
        
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>    
    </body>
</html>
