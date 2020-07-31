<%-- 
    Document   : comprobanteReport
    Created on : 18-jun-2020, 10:55:00
    Author     : antonieta
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.*"%>
<%@page import="java.io.*"%>

<%@page import="net.sf.jasperreports.engine.*" %>
<%@page import="net.sf.jasperreports.view.JRDesignViewer" %>

<%@page import="javax.servlet.ServletResponse" %>
<%@include file="Conexion.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            int parametro = Integer.parseInt(request.getParameter("id"));
            File reportfile = new File(application.getRealPath("reportes/report_Compra_id.jasper"));
            
            Map parametros = new HashMap();
            //arreglo de bytes
            parametros.put("id", parametro);
            byte[] bytes = JasperRunManager.runReportToPdf(reportfile.getPath(), parametros, con);
            
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            ServletOutputStream outputstream = response.getOutputStream();
            outputstream.write(bytes,0,bytes.length);
            
            outputstream.flush();
            outputstream.close();
        %>
    </body>
   
   
</html>
