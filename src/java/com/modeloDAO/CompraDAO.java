/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modeloDAO;

import com.modelo.Carrito;
import com.modelo.Compra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author antonieta
 */
public class CompraDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r=0;
 // ############################### LISTAS ################################### //   
    // ****************** GENERA EL NUMERO DE SERIE DE LA VENTA ************//
    public String GenerarSerie(){
        conexion cn=new conexion();
        String numeroSerie="";
        String sql="SELECT max(nroserie) FROM compra";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql); 
            rs=ps.executeQuery();
            while(rs.next()){
                numeroSerie=rs.getString(1);
            }  
        } catch (Exception e) {
            System.out.println("error: " + e);
        }finally{
            cn.cerrar();
        }
        return numeroSerie;
    } 
    // ****   BUSCO EL IDCOMPRA MAXICO... para saber mi ultima venta **** //
     public String IdCompraMax(){
        conexion cn=new conexion(); 
        String idCompra="";
        String sql="SELECT max(idcompra) FROM compra";
        try {
             con=cn.getConnection();
             ps=con.prepareStatement(sql); 
             rs=ps.executeQuery();
             while(rs.next()){
                 idCompra=rs.getString(1);
             }
        } catch (Exception e) {
             System.out.println("error: " + e);
        }finally{
            cn.cerrar();
        }
        return idCompra;
}
    // ******* LISTA LA COMPRA SEGUN UN IDCOMPRA SELECCIONADO ************//
      public Compra listarIdCompra(int idCompra){
      conexion cn=new conexion();    
      Compra c=new Compra();
      String sql="SELECT * FROM compra WHERE idcompra=?";
       try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql); 
            ps.setInt(1, idCompra);
            rs=ps.executeQuery();
            while(rs.next()){
                c.setIdCompra(rs.getInt(1));
                c.setIdUsuario(rs.getInt(2));
                c.setTipoPago(rs.getString(3));
                c.setTotal(rs.getDouble(4));
                c.setFecha(rs.getString(5));
                c.setNroSerie(rs.getString(6));
                c.setCostoEnvio(rs.getDouble(7));
             
            }
       } catch (Exception e) {
            System.out.println("error: " + e);
       }finally{
           cn.cerrar();
       }
       return c;   
   }
      
    // *********************** LISTA DE COMPRAS ************************************ //  
      public List<Compra> listarCompra(){
          conexion cn=new conexion();
        String sql="SELECT compra.idcompra, usuario.nombre, usuario.apellido, compra.tipopago, compra.total, compra.fecha, compra.nroserie \n" +
"FROM compra, usuario WHERE compra.idusuario=usuario.idusuario;";
        List<Compra>lista=new ArrayList<>();
          try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
             while(rs.next()){
                 Compra com=new Compra();
                 com.setIdCompra(rs.getInt(1));
                 com.setUsuNombre(rs.getString(2));
                 com.setUsuApellido(rs.getString(3));
                 com.setTipoPago(rs.getString(4));
                 com.setTotal(rs.getDouble(5));
                 com.setFecha(rs.getString(6));
                 com.setNroSerie(rs.getString(7));           
                 lista.add(com);
             }
          } catch (Exception e) {
              System.out.println("Error" + e);
        }finally{
            cn.cerrar();
          }
        return lista;
      }
       // ********* para el campo BUSCAR... **** para administrador
      public List BuscarVenta(String texto){
          conexion cn=new conexion();
          List<Compra> lista=new ArrayList<>();
           String sql="SELECT nroserie, fecha, nombre, apellido, tipopago, total "
                   + "FROM compra, usuario WHERE compra.idusuario=usuario.idusuario and"
                   + " ( nombre like '%"+texto+"%'"
                   + " or apellido like '%"+texto+"%' "
                   + "or tipopago like '%"+texto+"%'"
                   + " or total like '%"+texto+"%'"
                   + "or fecha like '%"+texto+"%'"
                   + " or nroserie like '%"+texto+"%')";
          try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                 Compra com=new Compra();
                 com.setNroSerie(rs.getString(1));  
                 com.setFecha(rs.getString(2));
                  com.setUsuNombre(rs.getString(3));
                 com.setUsuApellido(rs.getString(4));
                 com.setTipoPago(rs.getString(5));
                 com.setTotal(rs.getDouble(6));        
                 lista.add(com);
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
           return lista;
      }
      
 // ########################## INSERTAR ###################################### //
     // *************** INSERTA DATOS A LA TABLA COMPRA *****************//
  public int GenerarVenta(Compra c){
      conexion cn=new conexion(); 
       String sql="INSERT INTO compra(idusuario,tipopago,total,fecha,nroserie,costoenvio) VALUES(?,?,?,?,?,?)";
        try {
              con=cn.getConnection();
              ps=con.prepareStatement(sql); 
              ps.setInt(1, c.getIdUsuario());
              ps.setString(2, c.getTipoPago());
              ps.setDouble(3, c.getTotal());
              ps.setString(4, c.getFecha());
              ps.setString(5, c.getNroSerie());
              ps.setDouble(6, c.getCostoEnvio());
              ps.executeUpdate(); 
       } catch (Exception e) {
            System.out.println("error: " + e);
       }finally{
            cn.cerrar();
        }
       return r;
   }     
    // ************* INSERTA DATOS A LA TABLA DETALLE **************// 
  public boolean GuardarDetalleVenta(Compra c, Carrito car){
       conexion cn=new conexion(); 
       String sql="INSERT INTO detalle(idcompra,idproducto,cantidad,subtotal) VALUES(?,?,?,?)";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql); 
            ps.setInt(1, c.getIdCompra());
            ps.setInt(2, car.getIdProducto());
            ps.setInt(3, car.getCantidad());
            ps.setDouble(4, car.getSubtotal());
            ps.executeUpdate(); 
            return true;
       } catch (Exception e) {
            System.out.println("error: " + e);
       }finally{
            cn.cerrar();
        }
       
       return false;
   }
   

}
