/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.modelo.Compra;
import com.modelo.Producto;
import com.modelo.Usuario;
import com.modeloDAO.CompraDAO;
import com.modeloDAO.GenerarCodigo;
import com.modeloDAO.ProductoDAO;
import com.modeloDAO.UsuarioDAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@MultipartConfig
public class ServletAdmin extends HttpServlet {
    
    ProductoDAO pdao=new ProductoDAO();
    ArrayList<Producto> productos=new ArrayList<>(); //Status A
    Producto p=new Producto();
    String status="A";
  
    String numerocodigo;   
    
    ArrayList<Usuario> usuarios = new ArrayList<>();
    UsuarioDAO usudao=new UsuarioDAO(); 
    Usuario usu=new Usuario();
    Usuario usuario=new Usuario();  
   
    CompraDAO comdao=new CompraDAO();
    Compra compra=new Compra();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String accion= request.getParameter("accion");  
        switch(accion){
            case "Home":
                request.setAttribute("usuario", usu);
                request.getRequestDispatcher("mantenimiento.jsp").forward(request, response);
                break;
            case "Ingresar":
                 String correo=request.getParameter("txtCorreo");
                String clave=request.getParameter("txtClave");
                usu = usudao.validarUsuarioAdmin(correo, clave);
                if(usu.getCorreo()!=null){
                     request.setAttribute("usuario", usu);
                    request.getRequestDispatcher("mantenimiento.jsp").forward(request, response); 
                        
                }else{
                      
                    request.getRequestDispatcher("loginAdmin.jsp").forward(request, response);  
                }
                break;
    // #########################         USUARIO         ####################################  
            case "RegistroUsuario":
                 request.getRequestDispatcher("registroUsuarioAdmin.jsp").forward(request, response);
                break;
            case "Registrar":
                 usuario=new Usuario();
                  //recibimos datos de la vista
                String nombre1 = request.getParameter("txtNombre");
                String apellido = request.getParameter("txtApellido");
                String correo3 = request.getParameter("txtCorreo");
                String dni = request.getParameter("txtDni");
                String clave3 = request.getParameter("txtClave");
                String telefono = request.getParameter("txtTelefono");
                String direccion = request.getParameter("txtDireccion");
                String perfil= request.getParameter("txtPerfil");
                String status2= "A";
                //comunicamos con modelo
                usuario.setNombre(nombre1);
                usuario.setApellido(apellido);
                usuario.setCorreo(correo3);
                usuario.setDni(dni);
                usuario.setClave(clave3);
                usuario.setTelefono(telefono);
                usuario.setDireccion(direccion);
                usuario.setPerfil(perfil);
                usuario.setStatus(status2);
                usudao.registroUsuario(usuario);
                 request.setAttribute("usuarios", usuario);
                 request.setAttribute("usuario", usu);
                        request.getRequestDispatcher("ServletAdmin.do?accion=ListaUsuario").forward(request, response); 
                break;
            case "ListaUsuario":
               ArrayList<Usuario> usuarios= usudao.listaUsuario();
                 request.setAttribute("usuarios", usuarios);
                 request.setAttribute("usuario", usu);
                request.getRequestDispatcher("listaUsuario.jsp").forward(request, response);  
               break;     
            case "ModificarUsuario":   
                int idusu1 = Integer.parseInt(request.getParameter("id"));
                 usuario = usudao.listaIdUsuario(idusu1);
                 // request.setAttribute("usuarios", usuario);
                request.setAttribute("usuario", usuario);
               request.getRequestDispatcher("modificarUsuarioAdmin.jsp").forward(request, response);
                break;
                 case "Actualizar Usuario":
               //recibimos datos de la vista
                usuario=new Usuario(); 
                int idUsuario5 = Integer.parseInt(request.getParameter("txtIdUsuario"));
                String nombre2 = request.getParameter("txtNombre");
                String apellido2 = request.getParameter("txtApellido");
                String correo4 = request.getParameter("txtCorreo");
                String dni1 = request.getParameter("txtDni");
                String clave4 = request.getParameter("txtClave");
                String telefono1 = request.getParameter("txtTelefono");
                String direccion1 = request.getParameter("txtDireccion");
                String perfil1 = request.getParameter("txtPerfil");
                String status3 = request.getParameter("txtStatus");
                //comunicamos con modelo
                usuario.setIdUsuario(idUsuario5);
                usuario.setNombre(nombre2);
                usuario.setApellido(apellido2);
                usuario.setCorreo(correo4);
                usuario.setDni(dni1);
                usuario.setClave(clave4);
                usuario.setTelefono(telefono1);
                usuario.setDireccion(direccion1);
                usuario.setPerfil(perfil1);
                usuario.setStatus(status3);
                usudao.ModificarUsuario(usuario);
                
                 request.setAttribute("usuarios", usuario);
                request.setAttribute("usuario", usu);
                 request.getRequestDispatcher("ServletAdmin.do?accion=ListaUsuario").forward(request, response); 
                break;   
                 case "EliminarUsuario":
                //usuario=new Usuario(); 
                int idusu2 = Integer.parseInt(request.getParameter("id"));
                usudao.EliminarUsuario(idusu2);
                request.setAttribute("usuarios", usuario);
                request.setAttribute("usuario", usu);
                request.getRequestDispatcher("ServletAdmin.do?accion=ListaUsuario").forward(request, response); 
                     break;
                 case "Buscar Usuario":
                     String dato2 = request.getParameter("txtBuscar");
                     List<Usuario> listaUsu = usudao.BuscarUsuario(dato2);
                     request.setAttribute("usuarios", listaUsu);
                     request.setAttribute("usuario", usu);
                     request.getRequestDispatcher("listaUsuario.jsp").forward(request, response);
                     break;
                 case "Estatus Usuario":
                     String status1= request.getParameter("txtStatus"); 
                     List<Usuario> listaU = usudao.listarSegunStatusUsuario(status1);
                     request.setAttribute("usuarios", listaU);
                     request.setAttribute("usuario", usu);
                     request.getRequestDispatcher("listaUsuario.jsp").forward(request, response);
                     break;
                 case "Imprimir Usuarios":
                request.setAttribute("usuario", usu);
                request.getRequestDispatcher("ServletAdmin.do?accion=ListaUsuario").forward(request, response);
                break;     
    // #########################         PRODUCTO          ####################################      
            case "RegistroProducto":
                 numerocodigo = pdao.GenerarCodigo();
                if(numerocodigo==null){
                    numerocodigo="0001";
                    request.setAttribute("nrocodigo", numerocodigo);
                } else{
                    int incrementar=Integer.parseInt(numerocodigo);
                    GenerarCodigo gc = new GenerarCodigo();
                    numerocodigo= gc.CodigoSerie(incrementar);
                    request.setAttribute("nrocodigo", numerocodigo);
                }     
                request.setAttribute("nrocodigo", numerocodigo);
                request.setAttribute("usuario", usu);
                request.getRequestDispatcher("registroProducto.jsp").forward(request, response);
                break;
                
            case "ListaProducto":
                 ArrayList<Producto> producto = pdao.listarProductoStatus();
                request.setAttribute("productos", producto);
                request.setAttribute("usuario", usu);
                request.getRequestDispatcher("listaProducto.jsp").forward(request, response);  
                break;
            case "Buscar Producto":
                 String dato1 = request.getParameter("txtBuscar");
                  List<Producto> listaP = pdao.BuscarProducto(dato1);
                request.setAttribute("productos", listaP);
                request.setAttribute("usuario", usu);
                request.getRequestDispatcher("listaProducto.jsp").forward(request, response);  
                break;
            case "Estatus": 
                String estatus= request.getParameter("txtStatus");
                List<Producto> listaS = pdao.listarSegunStatusProducto(estatus);
                request.setAttribute("productos", listaS);
                request.setAttribute("usuario", usu);
                request.getRequestDispatcher("listaProducto.jsp").forward(request, response);  
                break;
            case "EliminarProducto":
                int idpro4=Integer.parseInt(request.getParameter("id"));
                pdao.EliminarProducto(idpro4);
                request.setAttribute("productos", productos);
                request.setAttribute("usuario", usu);
                request.getRequestDispatcher("ServletAdmin.do?accion=ListaProducto").forward(request, response);
                break;
            case "ModificarProducto":
                 int idpro=Integer.parseInt(request.getParameter("id"));
                 p = pdao.listarIdProducto(idpro);
                request.setAttribute("producto", p);
                request.setAttribute("usuario", usu);
                request.getRequestDispatcher("modificarProducto.jsp").forward(request, response);
                break;
            case "Actualizar":
                int idProducto = Integer.parseInt(request.getParameter("txtId"));
                String codigo = request.getParameter("txtCodigo");
                String nombre = request.getParameter("txtNombre");
                String descripcion = request.getParameter("txtDescripcion");
                double precio = Double.parseDouble(request.getParameter("txtPrecio"));
                int stock = Integer.parseInt(request.getParameter("txtStock"));
                String status = request.getParameter("txtStatus");
                
                p.setId(idProducto);
                p.setCodigo(codigo);
                p.setNombre(nombre);
                p.setDescripcion(descripcion);
                p.setPrecio(precio);
                p.setStock(stock);
                p.setStatus(status);
                
                pdao.ActualizarProducto(p);
                request.setAttribute("usuario", usu);
                request.getRequestDispatcher("ServletAdmin.do?accion=ListaProducto").forward(request, response);
               break;
            case "Imprimir Productos":
                request.setAttribute("usuario", usu);
                request.getRequestDispatcher("ServletAdmin.do?accion=ListaProducto").forward(request, response);
                break;
// ############################################ VENTA ######################################################### // 
            case "ListaVenta":
                 List<Compra> listaCompra = comdao.listarCompra();
                 request.setAttribute("compra", listaCompra);
                 request.setAttribute("usuario", usu);
                request.getRequestDispatcher("listaVenta.jsp").forward(request, response);
                break; 
            case "Imprimir Reporte":
                request.setAttribute("usuario", usu);
                request.getRequestDispatcher("ServletAdmin.do?accion=ListaVenta").forward(request, response);
                break;
            case "Buscar Venta":
                 String dato3 = request.getParameter("txtBuscar");
                  List<Compra> listaCom = comdao.BuscarVenta(dato3);
                request.setAttribute("compra", listaCom);
                request.setAttribute("usuario", usu);
                request.getRequestDispatcher("listaVenta.jsp").forward(request, response);
                  
                break;
            
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
