<%-- 
    Document   : Conexion
    Created on : 19-jun-2020, 15:23:22
    Author     : antonieta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Connection con= null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://node55592-env-6692497.jl.serv.net.mx:3306/carrito_basico", "root", "NDAfvx81118");
                System.out.println("Conectado");   
                } catch (Exception e) {
                    System.out.println("error: " + e);
                } 
        %>
    </body>
</html>
