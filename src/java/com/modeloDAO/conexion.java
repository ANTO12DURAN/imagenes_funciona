package com.modeloDAO;

import java.sql.Connection;
import java.sql.DriverManager;


public class conexion {
    Connection con;
    String url = "jdbc:mysql://node55592-env-6692497.jl.serv.net.mx:3306/carrito_basico";
    String user = "root";
    String pass = "NDAfvx81118";
    
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Conectado");
        } catch (Exception e) {
            System.out.println("error" + e);
        } return con;
    }
    public void cerrar(){
        con = null;
    }
}

