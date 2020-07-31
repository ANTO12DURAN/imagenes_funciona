package com.modeloDAO;

import com.modelo.Producto;
import com.modeloDAO.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author antonieta
 */
public class ProductoDAO {
 Connection con;
 PreparedStatement ps;
 ResultSet rs;
 int r=0;
 
 // ################################## LISTAS ####################################### //
  // ****************** LISTA SEGUN ID DEL PRODUCTO*******************************//
 public Producto listarIdProducto(int id){
       conexion cn=new conexion();
       Producto pro=new Producto();
       String sql="SELECT * FROM producto WHERE idProducto=?";
       try {
        con=cn.getConnection();
        ps=con.prepareStatement(sql); 
        ps.setInt(1, id);
        rs=ps.executeQuery();
        while(rs.next()){
                 pro.setId(rs.getInt(1));
                 pro.setCodigo(rs.getString(2));
                 pro.setNombre(rs.getString(3));
                 pro.setRuta(rs.getString(4));
                 pro.setDescripcion(rs.getString(5));
                 pro.setPrecio(rs.getDouble(6));
                 pro.setStock(rs.getInt(7));
                 pro.setStatus(rs.getString(8)); 
        }
     } catch (Exception e) {
     }
       
       return pro;
 }
 // lista segun el estado del producto "activo" o "eliminado"
  public ArrayList<Producto> listarSegunStatusProducto(String status){
          conexion cn=new conexion();
         ArrayList<Producto> productos=new ArrayList<Producto>();
         String sql="SELECT idproducto,codigo, nombre, ruta, descripcion, precio, stock, status" +
" from producto where status=?"; // falta where status='A' lo quite para pruebas
         try {
            con=cn.getConnection();
             ps=con.prepareStatement(sql); 
             ps.setString(1, status);
            rs = ps.executeQuery();
            while (rs.next()){
                Producto pro=new Producto();
                pro.setId(rs.getInt(1));
                pro.setCodigo(rs.getString(2));
                pro.setNombre(rs.getString(3));
                pro.setRuta(rs.getString(4));
                pro.setDescripcion(rs.getString(5));
                pro.setPrecio(rs.getDouble(6));
                pro.setStock(rs.getInt(7));
                pro.setStatus(rs.getString(8));
                
                productos.add(pro);
            }
         } catch (Exception e) {
            System.out.println("No se encontro Registro " + e);
            e.printStackTrace();
         }finally{
             cn.cerrar();
         }
        return productos; 
     } 
  // ****************** LISTAS PRODUCTOS ACTIVOS*******************************//  
 
    public List<Producto>listar() throws SQLException{
        conexion cn=new conexion();
        String sql="SELECT * FROM producto WHERE status='A'";
        List<Producto>lista=new ArrayList<>();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                 Producto p=new Producto();
                 p.setId(rs.getInt(1));
                 p.setCodigo(rs.getString(2));
                 p.setNombre(rs.getString(3));
                 p.setRuta(rs.getString(4));
                 p.setDescripcion(rs.getString(5));
                 p.setPrecio(rs.getDouble(6));
                 p.setStock(rs.getInt(7));
                 p.setStatus(rs.getString(8));
                 lista.add(p);
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }finally{
            con.close();
        }
        return lista;
    }      
 // ****************** LISTA TODOS LOS PRODUCTOS  *******************************//  
    
     public ArrayList<Producto> listarProductoStatus(){
          conexion cn=new conexion();
         ArrayList<Producto> productos=new ArrayList<Producto>();  
        String sql="SELECT * FROM producto";
        
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                 Producto p=new Producto();
                 p.setId(rs.getInt(1));
                 p.setCodigo(rs.getString(2));
                 p.setNombre(rs.getString(3));
                 p.setRuta(rs.getString(4));
                 p.setDescripcion(rs.getString(5));
                 p.setPrecio(rs.getDouble(6));
                 p.setStock(rs.getInt(7));
                 p.setStatus(rs.getString(8));
                 productos.add(p);
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
          return productos;
     }
     
       // ********* para el campo BUSCAR... **** para administrador
      public List BuscarProducto(String texto){
          conexion cn=new conexion();
          List<Producto> lista=new ArrayList<>();
           String sql="SELECT * FROM producto WHERE codigo like '%"+texto+"%' or nombre like '%"+texto+"%' or descripcion like '%"+texto+"%' or status like '%"+texto+"%'";
          try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                 Producto p=new Producto();
                 p.setId(rs.getInt(1));
                 p.setCodigo(rs.getString(2));
                 p.setNombre(rs.getString(3));
                 p.setRuta(rs.getString(4));
                 p.setDescripcion(rs.getString(5));
                 p.setPrecio(rs.getDouble(6));
                 p.setStock(rs.getInt(7));
                 p.setStatus(rs.getString(8));
                 lista.add(p);
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
           return lista;
      }
   // ****************** GENERAR CODIGO SERIE CARRITO *******************************//   
  public String GenerarCodigo(){
       conexion cn=new conexion();
        String numeroCodigo="";
        String sql="SELECT max(codigo) FROM producto";
        try {
        con=cn.getConnection();
        ps=con.prepareStatement(sql); 
            rs=ps.executeQuery();
            while(rs.next()){
                numeroCodigo=rs.getString(1);
            }  
        } catch (Exception e) {
             System.out.println("error: " + e);
        }finally{
            cn.cerrar();
        }
        return numeroCodigo;
    } 
 


// ################################ INSERTAR ######################################### // 
 // ****************** INSERTAR NUEVO PRODUCTO *******************************// 
    public int agregar(Producto p){
        conexion cn=new conexion();
        
        String sql="INSERT INTO producto(codigo,nombre,ruta,descripcion,precio,stock,status) VALUES(?,?,?,?,?,?,'A')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, p.getCodigo());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getRuta());
            ps.setString(4, p.getDescripcion());
            ps.setDouble(5, p.getPrecio());
            ps.setInt(6, p.getStock());
          
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error" + e);
        }finally{
            cn.cerrar();
        }
        return r;
    }
   
 
// ############################### UPDATE ############################################## //    
// ************************* MODIFIAR STOCK  ****************************************** //
    public int ActualizarStock(int idProducto, int stock){
        conexion cn=new conexion();
           int r=0;
         String sql="UPDATE producto SET stock=? WHERE idproducto=?";
         try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
              ps.setInt(1, stock);
              ps.setInt(2, idProducto);
              ps.executeUpdate();
                       
         } catch (Exception e) {
              System.out.println("error: " + e);
         }finally{
             cn.cerrar();
         }
         return r;
     }   

 // ****************** MODIFICAR PRODUCTO *******************************// 
    public int ActualizarProducto(Producto p){
        conexion cn=new conexion();
        
        String sql="UPDATE producto SET codigo=?,nombre=?,descripcion=?,precio=?,stock=?,status=? WHERE idproducto=?";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, p.getCodigo());
            ps.setString(2, p.getNombre());  
            ps.setString(3, p.getDescripcion());
            ps.setDouble(4, p.getPrecio());
            ps.setInt(5, p.getStock());
            ps.setString(6, p.getStatus());
            ps.setInt(7, p.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error" + e);
        }finally{
            cn.cerrar();
        }
        return r;
    }
   
// ############################## DELETE ############################################### //
// ************************* ELIMINA PRODUCTO ***************************************** //
     public boolean EliminarProducto(int idProducto){
         conexion cn=new conexion();
         String sql="DELETE FROM producto WHERE idproducto=?";
           try {
               con=cn.getConnection();
            ps=con.prepareStatement(sql);
              ps.setInt(1, idProducto);
               ps.executeUpdate();
               return true;
           } catch (Exception e) {
                System.err.println("error:" + e);
           }finally{
               cn.cerrar();
           }
           return false;
         }
}






   