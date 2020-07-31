
package com.controlador;

import com.modelo.Carrito;
import com.modelo.Compra;
import com.modelo.Producto;
import com.modelo.Usuario;
import com.modeloDAO.CompraDAO;
import com.modeloDAO.Fecha;
import com.modeloDAO.GenerarSerie;
import com.modeloDAO.ProductoDAO;
import com.modeloDAO.UsuarioDAO;
import com.modeloDAO.emailDAO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig
public class ServletControlador extends HttpServlet {
    
    Usuario usu=new Usuario();
    UsuarioDAO usudao=new UsuarioDAO(); 

    CompraDAO cdao=new CompraDAO();
    Compra c=new Compra();
    String numeroserie;
    String pago;
    
    
    ProductoDAO pdao=new ProductoDAO();
    Producto p=new Producto();
    
    ArrayList<Carrito> listaCarrito=new ArrayList<>();
    Carrito  car;
    double total=0.0;
    double totalPagar=0.0;
    double costoEnvio=0.0;
    int cantidad;
    int item=1;
    int pos;
    int idp;
    boolean res;
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       String accion= request.getParameter("accion");
          
        switch(accion){
            case "Home":
                request.setAttribute("usuario", usu);
                request.setAttribute("contador", listaCarrito.size());
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
// ###################################### USUARIO #################################################### //               
          
             case "Ingresar":
                 //recibimos datos de la vista
                String correo=request.getParameter("txtCorreo");
                String clave=request.getParameter("txtClave");
                usu = usudao.validarUsuario(correo,clave);              
                if(usu.getCorreo()!=null){
                      request.setAttribute("contador", listaCarrito.size());
                        request.setAttribute("usuario", usu);
                        if(listaCarrito.size()==0){
                            request.setAttribute("usuario", usu);
                            request.getRequestDispatcher("ServletControlador.do?accion=Home").forward(request, response);  
                        }else{
                            request.setAttribute("usuario", usu);
                             request.getRequestDispatcher("ServletControlador.do?accion=Carrito").forward(request, response); 
                        }  
                }else{
                    request.setAttribute("usuario", usu);
                    request.getRequestDispatcher("login.jsp").forward(request, response);  
                }
                break;
               case "olvidoClave":
                String correo1 = request.getParameter("txtPara");
                String mensaje = request.getParameter("txtMensaje");
               usu = usudao.OlvidoClaveUsuario(correo1);
                if(usu.getCorreo()==null){
                    out.print("Por favor, ingresa un correo");
                }else if(usu.getCorreo()!= null){
                     emailDAO email = new emailDAO();   
                     out.print("CORREO ENVIADO");
                }else {
                      emailDAO email = new emailDAO();   
                    out.print("CORREO NO ENVIADO");
                }  
                break;
            case "Salir":
                //me regresa al index con la sesion de usuario null y el carrito vacio
                String correo2 = null;
                String clave1 = null;
                usu.setCorreo(correo2);
                usu.setClave(clave1);
                usu = usudao.validarUsuario(correo2, clave1);
                listaCarrito.clear();
                request.setAttribute("usuario", usu);
                request.getRequestDispatcher("ServletControlador.do?accion=Home").forward(request, response);
                break;
             case "Regresar":
                //me regresa al index con el carrito en 0
                listaCarrito.clear();
                pago=null;
               // usu =usudao.validarUsuario(null, null);
                request.setAttribute("usuario", usu);
                request.getRequestDispatcher("ServletControlador.do?accion=Home").forward(request, response);
                break;    
            case "Registrarse":
                //recibimos datos de la vista
                String nombre = request.getParameter("txtNombre");
                String apellido = request.getParameter("txtApellido");
                String correo3 = request.getParameter("txtCorreo");
                String dni = request.getParameter("txtDni");
                String clave3 = request.getParameter("txtClave");
                String telefono = request.getParameter("txtTelefono");
                String direccion = request.getParameter("txtDireccion");
                String perfil="CLIENTE";
                String status1="A";
                //comunicamos con modelo
                usu.setNombre(nombre);
                usu.setApellido(apellido);
                usu.setCorreo(correo3);
                usu.setDni(dni);
                usu.setClave(clave3);
                usu.setTelefono(telefono);
                usu.setDireccion(direccion);
                usu.setPerfil(perfil);
                usu.setStatus(status1);
                usudao.registroUsuario(usu);
                usu = usudao.validarUsuario(correo3,clave3);   
                
                        request.setAttribute("usuario", usu);
                        request.getRequestDispatcher("ServletControlador.do?accion=Home").forward(request, response); 
                break;
                 case "MisDatos":
                     
                if(usu.getIdUsuario()!=0){
                    int idusu = Integer.parseInt(request.getParameter("id"));
                      usu = usudao.listaIdUsuario(idusu); 
                    request.setAttribute("usuario", usu);
                    request.getRequestDispatcher("misDatos.jsp").forward(request, response);
                } else {
              
               request.setAttribute("usuario", usu);
               request.getRequestDispatcher("login.jsp").forward(request, response);
                }
                break;
           case "ModificarUsuario":
                 int idusu1 = Integer.parseInt(request.getParameter("id"));
                 usu = usudao.listaIdUsuario(idusu1);
               
                request.setAttribute("usuario", usu);
               request.getRequestDispatcher("modificarUsuario.jsp").forward(request, response);
               break;
           case "Actualizar":
               //recibimos datos de la vista
               
                int idUsuario = Integer.parseInt(request.getParameter("txtIdUsuario"));
                String nombre1 = request.getParameter("txtNombre");
                String apellido2 = request.getParameter("txtApellido");
                String correo4 = request.getParameter("txtCorreo");
                String dni1 = request.getParameter("txtDni");
                String clave4 = request.getParameter("txtClave");
                String telefono1 = request.getParameter("txtTelefono");
                String direccion1 = request.getParameter("txtDireccion");
                String perfil1=usu.getPerfil();
                String status2="A";
                //comunicamos con modelo
                usu.setIdUsuario(idUsuario);
                usu.setNombre(nombre1);
                usu.setApellido(apellido2);
                usu.setCorreo(correo4);
                usu.setDni(dni1);
                usu.setClave(clave4);
                usu.setTelefono(telefono1);
                usu.setDireccion(direccion1);
                usu.setPerfil(perfil1);
                usu.setStatus(status2);
                usudao.ModificarUsuario(usu);
                
      
                    request.setAttribute("usuario", usu);
                    request.getRequestDispatcher("ServletControlador.do?accion=Home").forward(request, response); 
             
               break;
// ##################################### CARRITO ###################################################### // 
            case "Detalle":
                 int idpro=Integer.parseInt(request.getParameter("id"));
                   p =  pdao.listarIdProducto(idpro);
                   request.setAttribute("productos", p);
                   request.setAttribute("usuario", usu);
                   request.setAttribute("contador", listaCarrito.size());
                   request.getRequestDispatcher("detalle.jsp").forward(request, response);
                break;
             case "AgregarCarrito":
                pos=0; //para saber la posicion
                cantidad=1;
                idp=Integer.parseInt(request.getParameter("id"));
                p=pdao.listarIdProducto(idp); //buscamos
                if(listaCarrito.size()>0){
                    
                    for (int i = 0; i < listaCarrito.size(); i++) {
                        if(idp==listaCarrito.get(i).getIdProducto()){
                            pos=i; //estamos conociendo la posicion del producto seleccionado
                        }
                    }
                    if(idp==listaCarrito.get(pos).getIdProducto()){
                        cantidad=listaCarrito.get(pos).getCantidad()+cantidad;
                        
                        double subtotal=listaCarrito.get(pos).getPrecioP()*cantidad;
                        listaCarrito.get(pos).setCantidad(cantidad);
                        listaCarrito.get(pos).setSubtotal(subtotal);
                    }else{
                        item= item+1;
                        car=new Carrito();  //vamos a guardar en carrito los datos del producto!
                        car.setItem(item);
                        car.setIdProducto(p.getId());
                        car.setNombreP(p.getNombre());
                        car.setDescripcionP(p.getDescripcion());
                        car.setPrecioP(p.getPrecio());
                        car.setCantidad(cantidad);
                        car.setSubtotal(cantidad *p.getPrecio());
                        listaCarrito.add(car);
                    }
                }else{
                item= item+1;
                car=new Carrito();  //vamos a guardar en carrito los datos del producto!
                car.setItem(item);
                car.setIdProducto(p.getId());
                car.setNombreP(p.getNombre());
                car.setDescripcionP(p.getDescripcion());
                car.setPrecioP(p.getPrecio());
                car.setCantidad(cantidad);
                car.setSubtotal(cantidad *p.getPrecio());
                listaCarrito.add(car);    
                } 
                
              
                request.setAttribute("usuario", usu);
                request.setAttribute("carrito", listaCarrito);
                request.setAttribute("contador", listaCarrito.size());
                request.getRequestDispatcher("ServletControlador.do?accion=Home").forward(request, response);
                break;
                
            case "Carrito":
               if(listaCarrito.size()==0){
                    request.getRequestDispatcher("carritoSinProducto.jsp").forward(request, response);
                }else
                total=0.0;     
                totalPagar=0.0;
                for (int i = 0; i < listaCarrito.size(); i++) {
                    totalPagar=totalPagar+listaCarrito.get(i).getSubtotal(); //suma la columna subtotal
                       
                        if(totalPagar>100000){
                            costoEnvio=0.05; //calcula el 10% 
                         costoEnvio=costoEnvio*totalPagar; //saca el 10% del subtotal
                        }else{
                            costoEnvio=0.1; //calcula el 10% 
                         costoEnvio=costoEnvio*totalPagar; //saca el 10% del subtotal
                        } 
                   
                   total=totalPagar+costoEnvio;
                }
                
                  
                numeroserie = cdao.GenerarSerie();
                if(numeroserie==null){
                    numeroserie="00000001";
                    request.setAttribute("nroserie", numeroserie);
                } else{
                    int incrementar=Integer.parseInt(numeroserie);
                    GenerarSerie gs=new GenerarSerie();
                    numeroserie= gs.NumeroSerie(incrementar);
                    request.setAttribute("nroserie", numeroserie);
                }
               
               
             
                request.setAttribute("usuario", usu);
                request.setAttribute("nroserie", numeroserie);
                request.setAttribute("carrito", listaCarrito);
                request.setAttribute("contador", listaCarrito.size());
                request.setAttribute("total", total );
                request.setAttribute("costoEnvio", costoEnvio);
                request.setAttribute("totalPagar", totalPagar);
                request.getRequestDispatcher("carrito.jsp").forward(request, response);
              
                break;   
                case "Comprar":
                pos=0; //para saber la posicion
                 cantidad= 1;
                 
                idp=Integer.parseInt(request.getParameter("id"));
                p=pdao.listarIdProducto(idp); //buscamos
                if(listaCarrito.size()>0){
                    for (int i = 0; i < listaCarrito.size(); i++) {
                        if(idp==listaCarrito.get(i).getIdProducto()){
                            pos=i; //estamos conociendo la posicion del producto seleccionado
                        }
                    }
                    if(idp==listaCarrito.get(pos).getIdProducto()){
                        cantidad=listaCarrito.get(pos).getCantidad()+cantidad;
                        double subtotal=listaCarrito.get(pos).getPrecioP()*cantidad;
                        listaCarrito.get(pos).setCantidad(cantidad);
                        listaCarrito.get(pos).setSubtotal(subtotal);
                    }else{
                        item= item+1;
                        car=new Carrito();  //vamos a guardar en carrito los datos del producto!
                        car.setItem(item);
                        car.setIdProducto(p.getId());
                        car.setNombreP(p.getNombre());
                        car.setDescripcionP(p.getDescripcion());
                        car.setPrecioP(p.getPrecio());
                        car.setCantidad(cantidad);
                        car.setSubtotal(cantidad *p.getPrecio());
                        listaCarrito.add(car);
                    }
                }else{
                item= item+1;
                car=new Carrito();  //vamos a guardar en carrito los datos del producto!
                car.setItem(item);
                car.setIdProducto(p.getId());
                car.setNombreP(p.getNombre());
                car.setDescripcionP(p.getDescripcion());
                car.setPrecioP(p.getPrecio());
                car.setCantidad(cantidad);
                car.setSubtotal(cantidad *p.getPrecio());
                listaCarrito.add(car);    
                } 
               
                costoEnvio=0;
                   for (int i = 0; i < listaCarrito.size(); i++) {
                    totalPagar=totalPagar+listaCarrito.get(i).getSubtotal(); //suma la columna subtotal
                       
                        if(totalPagar>100000){
                            costoEnvio=0.05; //calcula el 10% 
                         costoEnvio=costoEnvio*totalPagar; //saca el 10% del subtotal
                        }else{
                            costoEnvio=0.1; //calcula el 10% 
                         costoEnvio=costoEnvio*totalPagar; //saca el 10% del subtotal
                        } 
                   
                   total=totalPagar+costoEnvio;
                }
                 
                  numeroserie = cdao.GenerarSerie();
                if(numeroserie==null){
                    numeroserie="00000001";
                    request.setAttribute("nroserie", numeroserie);
                } else{
                    int incrementar=Integer.parseInt(numeroserie);
                    GenerarSerie gs=new GenerarSerie();
                    numeroserie= gs.NumeroSerie(incrementar);
                    request.setAttribute("nroserie", numeroserie);
                }
                
                request.setAttribute("nroserie", numeroserie);
                request.setAttribute("usuario", usu);
                request.setAttribute("total", total );
                request.setAttribute("costoEnvio", costoEnvio);
                request.setAttribute("totalPagar", totalPagar);
                request.setAttribute("carrito", listaCarrito);
                request.setAttribute("contador", listaCarrito.size());
                request.getRequestDispatcher("carrito.jsp").forward(request, response);
                 break; 
                 
             case "Delete":
                int idproducto= Integer.parseInt(request.getParameter("idp"));
                for (int i = 0; listaCarrito.size() < 10; i++) {
                    if(listaCarrito.get(i).getIdProducto()==idproducto){
                        listaCarrito.remove(i);
                    }
                }
             
                request.setAttribute("nroserie", numeroserie);
                request.getRequestDispatcher("carrito.jsp").forward(request, response);
                break;
            case "ActualizarCantidad":
                      int idpro1 = Integer.parseInt(request.getParameter("idp"));
                      int cant = Integer.parseInt(request.getParameter("Cantidad"));
                      for (int i = 0; i < listaCarrito.size(); i++) {
                          if(listaCarrito.get(i).getIdProducto()== idpro1){
                              listaCarrito.get(i).setCantidad(cant);
                              double st= listaCarrito.get(i).getPrecioP()*cant;
                              listaCarrito.get(i).setSubtotal(st);
                              
                          }
                      }
                       
                      break;    
 // ##################################### TIPO PAGO ################################################## //
            case "TipoPago":          
                request.getRequestDispatcher("tipoPago.jsp").forward(request, response);
                   break;
                  case "Pago":
                //leemos la vista
                pago= request.getParameter("txtTipoPago");
               
                   
                request.setAttribute("pago", pago);
                request.getRequestDispatcher("ServletControlador.do?accion=Carrito").forward(request, response); 
                 
                break; 
                
 // ######################################  COMPRA  ################################################### //                     
    case "GenerarCompra": 
                 
               String fecha =  Fecha.FechaActual();
               
                //actualiza el stock del producto
                  for (int i = 0; i < listaCarrito.size(); i++) {
                    p=new Producto();
                    int cantidad=listaCarrito.get(i).getCantidad();
                    int idProducto=listaCarrito.get(i).getIdProducto();
                    pdao=new ProductoDAO();
                    p=pdao.listarIdProducto(idProducto);
                    int stockActual= (p.getStock() - cantidad);
                    pdao.ActualizarStock(idProducto, stockActual);
                }          
                
              
                if(usu.getIdUsuario()==0){
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
                if(pago==null){
                        request.getRequestDispatcher("tipoPago.jsp").forward(request, response);
                    }
                if((usu.getIdUsuario()!=0)&&(pago!=null)){
           //guardar compra
               c.setIdUsuario(usu.getIdUsuario());
               c.setTipoPago(pago);
               c.setTotal(total);
               c.setFecha(fecha);
               c.setNroSerie(numeroserie);
               c.setCostoEnvio(costoEnvio);
               cdao.GenerarVenta(c);
              
                //guardar detalle 
               int idc=Integer.parseInt(cdao.IdCompraMax());
                for (int i = 0; i < listaCarrito.size(); i++) {
                    car=new Carrito();
                    c.setIdCompra(idc);
                    car.setIdProducto(listaCarrito.get(i).getIdProducto());
                    car.setCantidad(listaCarrito.get(i).getCantidad());
                    car.setSubtotal(listaCarrito.get(i).getSubtotal());
                    cdao.GuardarDetalleVenta(c, car);  
                }
                
            }
                 
                 request.getRequestDispatcher("compraExitosa.jsp").forward(request, response); 
                
                break;       
    case "comprobanteReporte":
            listaCarrito.clear();
            pago=null;
          //  usu =usudao.validarUsuario(null, null);
            request.setAttribute("usuario", usu);
        request.getRequestDispatcher("comprobanteReport.jsp").forward(request, response);
        
        break;
 // ##################################### DEFAILT  ##################################################### //               
     default:
                
                request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
