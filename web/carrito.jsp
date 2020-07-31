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
  <a class="navbar-brand" href="#">KuerpoEspin</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
        <div id="session1">
             <li class="nav-item active">
          <a class="nav-link" href="ServletControlador.do?accion=Home">Seguir Comprando</a>
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
         <%--  **************************** CARRITO DE COMPRAS *********************************  --%>
        <br>
        
         <div class="d-flex"> 
           
            
                <div class="col-sm-12">
                    
                    <div class="card">
                        
                        <div class="card-body">
                            <div class="d-flex">
                                <div class="col-sm-2 mr-auto">
                                    <%
                                        Date date = new Date();
                                        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                        System.out.println("Fecha: "+dateFormat.format(date));
                                    %>
                                <label>Fecha :</label>
                                <input type="date" id="fch" name="txtFecha" value="<%=dateFormat.format(date)%>"  readonly="" class="form-control mr-auto">  
                                </div>
                                <div class="col-sm-3 ml-auto">
                                 <label>Nro.Control :</label>
                                <input type="text" name="txtNroSerie" value="${nroserie}" readonly="" class="form-control ml-auto">
                                </div>     
                            </div>
                             <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>ITEM</th>
                                <th>ARTICULO</th>
                                <th>DESCRIPCION</th>
                                <th>PRECIO</th>
                                <th>CANTIDAD</th>
                                <%--   <th>DESCUENTO</th> --%>
                                <th>SUBTOTAL</th>
                                <th>ACCIONES</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="car" items="${carrito}">
                            <tr>
                                <td>${car.getItem()}</td>
                                <td>${car.getIdProducto()}</td>
                                <td>${car.getDescripcionP()}</td>
                                <td>$.${car.getPrecioP()}0</td>
                                <td>
                                    <%--
                                    <center>${car.getCantidad()}</center>    
                                      --%>
                                    <input type="hidden" id="idpro" value="${car.getIdProducto()}">
                                    <input type="number" id="Cantidad" value="${car.getCantidad()}" class="form-control col-sm-3" min="1">
                      
                                </td>
                             <%--    <td>${car.getDescuento()}%</td> --%>
                                  <td>$.${car.getSubtotal()}0</td>  
                                <td class="parte01">
                                    <input type="hidden" id="idp" value="${car.getIdProducto()}">
                                    <a href="#" id="btnEliminar" >Eliminar</a>
                                   
                                </td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                        </div>
                        <div class="card-footer">
                               <div class="d-flex">
                        <div class="col-sm-8">
                            <label>SubTotal:</label>     
                        </div>
                    <div class="col-sm-4">
                        <input type="text" name="txtSubTotal" value="$.${totalPagar}0" readonly="" class="form-control ">
                    </div>  
                    </div>
                  
                    <div class="d-flex">
                        <div class="col-sm-8">
                            <label>Costo de Envio:</label> 
                        </div>
                         <div class="col-sm-4">
                            <input type="text" name="txtCostoEnvio" value="$.${costoEnvio}0" readonly="" class="form-control">
                        </div>
                        
                    </div>
                     <div class="d-flex">
                        <div class="col-sm-8">
                             <label>Total a Pagar:</label>
                        </div>
                         <div class="col-sm-4">
                             <input type="text" name="txtTotal" value="$.${total}0"  readonly="" class="form-control">
                        </div>
                     </div>
                       
                        <div class="card-footer"> 
                             <div class="d-flex">
    
                                 <div class="col-sm-2">
                                     <a href="ServletControlador.do?accion=TipoPago" class="btn btn-outline-info">
                                         Tipo de Pago
                                     </a>
                                </div> 
                                 <div class="col-sm-2">
                                     <input type="text" name="txtPago" value="${pago}"  readonly="" class="form-control">
                                </div>
                             
                                
                                 <div class="col-sm-2 ml-auto">
                                 
                                 <a href="ServletControlador.do?accion=GenerarCompra" class="btn btn-danger btn-block">Generar Compra</a>    
                                </div>
                            </div>
                               
                        </div>
                        
                        
                        </div>
                        
                    </div>
                        <br>
                            
                      </div> 
                           
                    </div>
        
     
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
   <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="js/funciones.js" type="text/javascript"></script>
    </body>
</html>
