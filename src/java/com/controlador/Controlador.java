/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.modelo.Producto;
import com.modeloDAO.ProductoDAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class Controlador extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       String accion = request.getParameter("accion");
       Producto p=new Producto();
       ProductoDAO pdao=new ProductoDAO();
      
       switch(accion){
           case "Guardar":
               ArrayList<String>lista=new ArrayList<>();
               try {
                   //se capturan todos los datos del formulario 
                   FileItemFactory file=new DiskFileItemFactory();
                   ServletFileUpload fileUpload=new ServletFileUpload(file);
                   List items=fileUpload.parseRequest(request);  
                   //recorremos mediante un for
                   for (int i = 0; i < items.size(); i++) {
                       FileItem fileItem=(FileItem)items.get(i);
                       if(!fileItem.isFormField()){ //capturar el campo que cague el archivo
                            File f=new File("D:\\NetBeansProjects\\Imagenes_funciona\\web\\img\\" + fileItem.getName());
                            
                            fileItem.write(f); 
                            p.setRuta("img\\"+ fileItem.getName());
                            
                       }else{
                           lista.add(fileItem.getString());
                       }
                   }
                   p.setCodigo(lista.get(0));
                   p.setNombre(lista.get(1));
                   p.setDescripcion(lista.get(2));
                   p.setPrecio(Double.parseDouble(lista.get(3)));
                   p.setStock(Integer.parseInt(lista.get(4)));
                  
                   pdao.agregar(p);
               } catch (Exception e) {
                   System.err.println("Error" + e);
               }
               
                request.getRequestDispatcher("ServletAdmin.do?accion=ListaProducto").forward(request, response);
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
