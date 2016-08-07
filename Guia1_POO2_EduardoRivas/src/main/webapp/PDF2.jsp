<%-- 
    Document   : PDF2
    Created on : Aug 6, 2016, 9:49:18 PM
    Author     : aerc
--%>

<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.io.File"%>
<%@page import="com.sv.udb.recursos.Conexion"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Connection con = new Conexion().getConn();
            File reportfile = new File (application.getRealPath("Pers.jasper"));
            
            Map parameter = new HashMap();
            
            String valor = request.getParameter("cmbPers");
            System.out.print(valor);
            parameter.put("Pers", valor);
            System.out.print("hodi"+parameter);
            byte[] bytes = JasperRunManager.runReportToPdf(reportfile.getPath(), parameter, con);
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(bytes, 0, bytes.length);
            outputStream.flush();
            outputStream.close();
        %>
    </body>
</html>
