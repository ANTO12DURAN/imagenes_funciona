
package com.modeloDAO;

import com.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    
    
 // ########################### LISTA ########################################## //   
     // **************** LOGIN CLIENTES ************************************* //
    public Usuario validarUsuario(String correo, String clave){
        conexion cn=new conexion();
        Usuario usu=new Usuario();
         String sql="SELECT * FROM usuario WHERE correo=? and clave=? and status='A'";
         try {
          con=cn.getConnection();
          ps=con.prepareStatement(sql);    
          ps.setString(1,correo);
          ps.setString(2, clave);
          rs = ps.executeQuery();   
        if(rs.next()){
            usu.setIdUsuario(rs.getInt(1));
            usu.setNombre(rs.getString(2));
            usu.setApellido(rs.getString(3));
            usu.setCorreo(rs.getString(4));
            usu.setClave(rs.getString(5));
            usu.setTelefono(rs.getString(6));
            usu.setDireccion(rs.getString(7));
            usu.setDni(rs.getString(8));
            usu.setPerfil(rs.getString(9));
            usu.setStatus(rs.getString(10));
        }
         } catch (Exception e) {
         }finally{
            cn.cerrar();
        }
         return usu;
     }
     // **************** LOGIN ADMINISTRADOR ************************************* //
    public Usuario validarUsuarioAdmin(String correo, String clave){
        conexion cn=new conexion();
        Usuario usu=new Usuario();
         String sql="SELECT * FROM usuario WHERE correo=? and clave=? and perfil='ADMINISTRADOR' and status='A'";
         try {
          con=cn.getConnection();
          ps=con.prepareStatement(sql);    
          ps.setString(1,correo);
          ps.setString(2, clave);
          rs = ps.executeQuery();   
        if(rs.next()){
            usu.setIdUsuario(rs.getInt(1));
            usu.setNombre(rs.getString(2));
            usu.setApellido(rs.getString(3));
            usu.setCorreo(rs.getString(4));
            usu.setClave(rs.getString(5));
            usu.setTelefono(rs.getString(6));
            usu.setDireccion(rs.getString(7));
            usu.setDni(rs.getString(8));
            usu.setPerfil(rs.getString(9));
            usu.setStatus(rs.getString(10));
        }
         } catch (Exception e) {
         }finally{
            cn.cerrar();
        }
         return usu;
     }
     // ****************** lista segun el id de usuario ********** //  
    public Usuario listaIdUsuario(int idUsuario){
        conexion cn=new conexion();
        Usuario usu=new Usuario();
        String sql="SELECT * FROM usuario WHERE idusuario=?";
          try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql); 
            ps.setInt(1, idUsuario);
            rs = ps.executeQuery();
            while(rs.next()){
            usu.setIdUsuario(rs.getInt(1));
            usu.setNombre(rs.getString(2));
            usu.setApellido(rs.getString(3));
            usu.setCorreo(rs.getString(4));
            usu.setClave(rs.getString(5));
            usu.setTelefono(rs.getString(6));
            usu.setDireccion(rs.getString(7));
            usu.setDni(rs.getString(8));
            usu.setPerfil(rs.getString(9));
            usu.setStatus(rs.getString(10));
            }
          } catch (Exception e) {
               System.out.print(e);
        } finally{
            cn.cerrar();
          }
         return usu; 
      }
    // ****************** lista USUARIO ********** //  
    public ArrayList<Usuario> listaUsuario(){
        conexion cn=new conexion();
       ArrayList<Usuario> usuarios=new ArrayList<Usuario>();
        String sql="SELECT * FROM usuario";
          try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql); 
            rs = ps.executeQuery();
            while(rs.next()){
            Usuario usu=new Usuario();   
            usu.setIdUsuario(rs.getInt(1));
            usu.setNombre(rs.getString(2));
            usu.setApellido(rs.getString(3));
            usu.setCorreo(rs.getString(4));
            usu.setClave(rs.getString(5));
            usu.setTelefono(rs.getString(6));
            usu.setDireccion(rs.getString(7));
            usu.setDni(rs.getString(8));
            usu.setPerfil(rs.getString(9));
            usu.setStatus(rs.getString(10));
            usuarios.add(usu);
            }
          } catch (Exception e) {
               System.out.print(e);
        } finally{
            cn.cerrar();
          }
         return usuarios; 
      }
      // ********* para el campo BUSCAR... **** para administrador
      public List BuscarUsuario(String texto){
          conexion cn=new conexion();
          List<Usuario> lista=new ArrayList<>();
           String sql="SELECT * FROM usuario WHERE nombre like '%"+texto+"%' or apellido like '%"+texto+"%' or correo like '%"+texto+"%'  or telefono like '%"+texto+"%'  or direccion like '%"+texto+"%'  or dni like '%"+texto+"%' or perfil like '%"+texto+"%'";
          try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
            Usuario usu=new Usuario();   
            usu.setIdUsuario(rs.getInt(1));
            usu.setNombre(rs.getString(2));
            usu.setApellido(rs.getString(3));
            usu.setCorreo(rs.getString(4));
            usu.setClave(rs.getString(5));
            usu.setTelefono(rs.getString(6));
            usu.setDireccion(rs.getString(7));
            usu.setDni(rs.getString(8));
            usu.setPerfil(rs.getString(9));
            usu.setStatus(rs.getString(10));
            lista.add(usu);
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
           return lista;
      }
      
      // lista segun el estado del usuario "activo" o "eliminado"
  public ArrayList<Usuario> listarSegunStatusUsuario(String status){
          conexion cn=new conexion();
         ArrayList<Usuario> usuarios=new ArrayList<Usuario>();
         String sql="SELECT * FROM usuario where status=?"; 
         try {
            con=cn.getConnection();
             ps=con.prepareStatement(sql); 
             ps.setString(1, status);
            rs = ps.executeQuery();
            while (rs.next()){
            Usuario usu=new Usuario();   
            usu.setIdUsuario(rs.getInt(1));
            usu.setNombre(rs.getString(2));
            usu.setApellido(rs.getString(3));
            usu.setCorreo(rs.getString(4));
            usu.setClave(rs.getString(5));
            usu.setTelefono(rs.getString(6));
            usu.setDireccion(rs.getString(7));
            usu.setDni(rs.getString(8));
            usu.setPerfil(rs.getString(9));
            usu.setStatus(rs.getString(10));
            usuarios.add(usu);
                
            }
         } catch (Exception e) {
            System.out.println("No se encontro Registro " + e);
            e.printStackTrace();
         }finally{
             cn.cerrar();
         }
        return usuarios; 
     } 
      
     // **************** lista envio correo usuario *******************//
    public Usuario OlvidoClaveUsuario(String correo){
       conexion cn=new conexion();
        Usuario usu=new Usuario();
        String sql="SELECT * FROM usuario WHERE correo=? status='A'";
        try {
         con=cn.getConnection();
         ps=con.prepareStatement(sql); 
         ps.setString(1,correo);
         rs = ps.executeQuery();   
        if(rs.next()){
            usu.setIdUsuario(rs.getInt(1));
            usu.setNombre(rs.getString(2));
            usu.setApellido(rs.getString(3));
            usu.setCorreo(rs.getString(4));
            usu.setClave(rs.getString(5));
            usu.setTelefono(rs.getString(6));
            usu.setDireccion(rs.getString(7));
            usu.setDni(rs.getString(8));
            usu.setPerfil(rs.getString(9));
            usu.setStatus(rs.getString(10));
        }
        } catch (Exception e) {
             System.out.print(e);
        }finally{
            cn.cerrar();
        }
        return usu;
    }  
    
// ######################## CRUD USUARIO ################################### //
   // *********** CREACION DE USUARIO **************//
    public boolean registroUsuario(Usuario usu){
        conexion cn=new conexion();
        
        String sql="INSERT INTO usuario(nombre,apellido,correo,clave,telefono,direccion,dni,perfil,status)VALUES(?,?,?,?,?,?,?,?,?)";
        try{
           con=cn.getConnection();
           ps=con.prepareStatement(sql);
           ps.setString(1, usu.getNombre());
           ps.setString(2, usu.getApellido());
           ps.setString(3, usu.getCorreo());
           ps.setString(4, usu.getClave());
           ps.setString(5, usu.getTelefono());
           ps.setString(6, usu.getDireccion());
           ps.setString(7, usu.getDni());
           ps.setString(8, usu.getPerfil());
           ps.setString(9, usu.getStatus());
           ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    // ************** MODIFICACION DEL USUARIO ******************* //
     public boolean ModificarUsuario(Usuario usu){
        conexion cn=new conexion();
        
        String sql="UPDATE usuario SET nombre=?,apellido=?,correo=?,clave=?,telefono=?,direccion=?, dni=?,perfil=?, status=? WHERE idusuario=?";
        try{
           con=cn.getConnection();
           ps=con.prepareStatement(sql);
           ps.setString(1, usu.getNombre());
           ps.setString(2, usu.getApellido());
           ps.setString(3, usu.getCorreo());
           ps.setString(4, usu.getClave());
           ps.setString(5, usu.getTelefono());
           ps.setString(6, usu.getDireccion());
           ps.setString(7, usu.getDni());
           ps.setString(8, usu.getPerfil());
           ps.setString(9, usu.getStatus());
           ps.setInt(10, usu.getIdUsuario());
           ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("error: " + e);
        }
        return false;
    }
      // ************** ELIMINAR USUARIO ******************* //
     public boolean EliminarUsuario(int idUsuario){
        conexion cn=new conexion();
        
        String sql="DELETE FROM usuario WHERE idusuario=?";
         try {
               con=cn.getConnection();
            ps=con.prepareStatement(sql);
              ps.setInt(1, idUsuario);
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
