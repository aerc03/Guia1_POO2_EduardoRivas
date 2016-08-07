<%-- 
    Document   : Conexion
    Created on : Aug 6, 2016, 5:58:46 PM
    Author     : aerc
--%>

<%@page import="java.sql.DriverManager"%>
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
            Connection con = null;
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/regivisitas", "root", "");
                out.print("Bien.");
            }
            catch (Exception ex)
            {
                out.print("Error: "+ex.getMessage());
            }
        %>
    </body>
</html>
