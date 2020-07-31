/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modeloDAO;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author antonieta
 */
public class emailDAO {
     public boolean enviarCorreo(String de, String clave, String correo, String mensaje, String asunto){
        de =  "anto12duran@gmail.com";
        clave = "CELULAR3132353665";
        asunto = "Restablecer Contraseña";
         
         
        boolean enviado= false;
        try {
            String host = "smtp.gmail.com";
            
            Properties prop = System.getProperties();
            prop.put("mail.smtp.starttls.enable", "true");
            prop.put("mail.smtp.host", host);
            prop.put("mail.smtp.user", de);
            prop.put("mail.smtp.password", clave);
            prop.put("mail.smtp.port", 587);
            prop.put("mail.smtp.auth", "true");
            
            Session session = Session.getDefaultInstance(prop, null);
            
            MimeMessage message = new MimeMessage(session);
            
            message.setFrom(new InternetAddress(de));
            
            /*
            // ***********NOTA: para enviar correo electronico  masivo*************** //
            
            InternetAddress[] direcciones = new InternetAddress[para.length];
            for(int i=0; i<para.length; i++){
            direcciones[i] = new InternetAddress(para[i]);
            }
            for(int i=0; i<direcciones.length; i++){
                message.addRecipient(Message.RecipientType.TO, direcciones[i]);
            }
            */
            
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(correo));
            
            message.setSubject(asunto);
            message.setText(mensaje);
            
            Transport transport = session.getTransport("smtp");
            
            transport.connect(host, de, clave);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            
            enviado = true;
        } catch (Exception e) {
            e.printStackTrace();
        }return enviado;
    } 
}
