<%-- 
    Document   : carritoSinProducto
    Created on : 15-jun-2020, 18:06:31
    Author     : antonieta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>KuerpoEspin</title>
    </head>
    <body>
         <%--  **************************** MENU DE CLIENTES *********************************  --%>
        
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">KuerpoEspin</a>

  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
   <%--
      <ul class="navbar-nav mr-auto">
        <div id="session1">
            <li class="nav-item">
           <a class="nav-link" href="ServletControlador.do?accion=Carrito"><i class="fas fa-cart-plus">(<label style="color: darkorange">${contador}</label>)</i>Carrito</a>
            </li> 
        </div>
            <div>
                <li class="nav-item active">
          <a class="nav-link" href="ServletControlador.do?accion=MisDatos&id=${usuario.getIdUsuario()}">Mis Datos</a>
                  </li> 
            </div>   
    </ul>
   --%>
  </div>
                
      <ul class="navbar-nav mr-auto" >
      <a style="color: #ffc107">
          Bienvenido ${usuario.getNombre()} ${usuario.getApellido()}
        </a>
    </ul>
</nav>
        
        <%-- ################## CONTENIDO ################################# --%>
        <br>
        
      <div class="container mt-12" style="display: flex; align-items: center; justify-content: center" >
            <div class="row">
                <form action="ServletControlador.do" method="POST">
                     <div class="col-sm-12">
                    <div class="card">
                        <div class="card-header text-center">
                            <h4>Ups, No hay productos en tu carrito</h4>
                        </div>
                        <div class="card-body text-center">
                            
                                    <label>Agregar Productos al carrito</label>     
                                
                        </div>
                        <div class="card-footer text-center" enctype="multipart/form-data">
                            <div>
                                <input type="submit" name="accion" value="Home"><br>                               
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
    </body>
</html>
