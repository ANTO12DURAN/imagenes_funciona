
<%@page import="javafx.scene.control.Alert"%>
<%@page import="com.modelo.Usuario"%>
<%@page import="com.modeloDAO.emailDAO"%>
<%@page import="com.modeloDAO.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/alertify.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/default.min.css" rel="stylesheet" type="text/css"/>
        <title>RESULTADO CORREO ELECTRONICO</title>
    </head>
    <body>
        
        <%
            UsuarioDAO usudao= new UsuarioDAO();
            Usuario usu= new Usuario();
            
           
            
            String de = request.getParameter("txtDe");
            String clave = request.getParameter("txtClave");
            String correo = request.getParameter("txtCorreo");
          // String mensaje = request.getParameter("txtMensaje");
            String asunto = request.getParameter("txtAsunto");
            
           usu = usudao.OlvidoClaveUsuario(correo);
            
           if(correo.length()==0){
               out.print("Campo vacio, por favor ingrese su correo\n"+" <a href='login.jsp'>Volver</a>");
           } else{
                if(usu.getCorreo()!=null){           
                
                request.setAttribute("usu", usu);
                 String mensaje = " HOLA  "+usu.getNombre()+" "+ usu.getApellido()+"\n Recuperacion de Clave: \n Correo: "+correo+"\n Clave:"+usu.getClave();
                 emailDAO email = new emailDAO();
            
            /*  // **********envio Correo Masivo****************** //
            
            String [] direcciones = {"correo n1","correo n2", "correo nN};
             boolean resultado = email.enviarCorreo(de, clave, direcciones, mensaje, asunto);
            
            */
            
            boolean resultado = email.enviarCorreo(de, clave, correo, mensaje, asunto);
            
            if(resultado){
             
                out.print("Correo electronico CORRECTAMENTE enviado\n"+" <a href='ServletControlador.do?accion=Home'>Volver</a>");
                
            }else{
                out.print("Correo electronico NO enviado\n"+"\n <a href='ServletControlador.do?accion=Home'>Volver</a>");
            }
            }
            else{
                out.print("El correo no se encuantra en el Sistema, Registrese!\n"+ " <a href='ServletControlador.do?accion=Home'>Volver</a>");
            }
            
           }
            
         %>   
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>  
<script src="js/alertify.min.js" type="text/javascript"></script>
    </body>
</html>
