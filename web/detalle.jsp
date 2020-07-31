
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
  <a class="navbar-brand" href="ServletControlador.do?accion=Home">KuerpoEspin</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
        <div id="session1">
            <li class="nav-item">
           <a class="nav-link" href="#"><i class="fas fa-cart-plus">(<label style="color: darkorange">${contador}</label>)</i>Carrito</a>
            </li> 
        </div>
            <div>
                <li class="nav-item active">
          <a class="nav-link" href="ServletControlador.do?accion=MisDatos&id=${usuario.getIdUsuario()}">Mis Datos</a>
                  </li> 
            </div>    
    </ul>
  </div>
                
      <ul class="navbar-nav mr-auto" >
      <a style="color: #ffc107">
          Bienvenido ${usuario.getNombre()} ${usuario.getApellido()}
        </a>
    </ul>
</nav>
         
           <%-- ############# MUESTRA DETALLES DEL PRODUCTO SELECCIONADO ############### --%>    
     <br>
   <from action="ServletControlador.do" method="POST" enctype="multipart/form-data" >
        <div class="container mt-12" style="display: flex; align-items: center; justify-content: center">
            <div class="row">
                
                <br>
            
                    <div class="col-sm-12 text-center" >
                    <div class="card text-center">
                        <div class="card-header text-center">
                            <h2>Detalles del Producto</h2>
                        </div>
                        <div class="card-body text-center">
                            <div class="d-flex text-center">
                                <div class="col-sm-6 text-center">  
                                    <img src="${productos.getRuta()}" width="290" height="280" style="display: flex"/><br> 
                               <div class="d-flex text-center"> 
                                <div class="col-sm-12">
                                    <label>Stock: ${productos.getStock()}</label>     
                                </div>  
                            </div>
                                </div>
                           
                                <div class="col-sm-6">
                            <div class="d-flex"> 
                                <div class="col-sm-4">
                                    <label>Codigo:</label>     
                                </div>
                                 <div class="col-sm-8">
                                     <input type="text" name="txtCodigo" value="${productos.getCodigo()}" readonly="" class="form-control"><br>
                                 </div> 
                            </div>
                             <div class="d-flex"> 
                                <div class="col-sm-4">
                                    <label>Nombre:</label>     
                                </div>
                                 <div class="col-sm-8">
                                     <input type="text" name="txtNombre" value="${productos.getNombre()}" readonly="" class="form-control"><br>
                                 </div> 
                            </div> 
                             <div class="d-flex"> 
                                <div class="col-sm-4">
                                    <label>Descripcion:</label>     
                                </div>
                                 <div class="col-sm-8">
                                     <textarea name="txtDescripcion" rows="2" cols="2" readonly="" class="form-control">${productos.getDescripcion()}</textarea><br>
                                 </div> 
                            </div>
                            <div class="d-flex"> 
                                <div class="col-sm-4">
                                    <label>Precio:</label>     
                                </div>
                                 <div class="col-sm-8">
                                     <input type="text" name="txtPrecio" value="$.${productos.getPrecio()}0" readonly="" class="form-control"><br>
                                 </div> 
                            </div>  
                 
                                 
                                </div>
                              </div> 
                        </div>     
                            
                      
                        <div class="card-footer text-center">
                         
                            <div>
                                <a href="ServletControlador.do?accion=Comprar&id=${productos.getId()}" class="btn btn-outline-info">Agregar Carrito</a>
                                <a href="ServletControlador.do?accion=Home" class="btn btn-danger">Seguir Comprando</a>
                            </div>
                        </div>
                    </div>
                </div>
                     
                       
            </div>
        </div>  
    </from> 
            
        
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
