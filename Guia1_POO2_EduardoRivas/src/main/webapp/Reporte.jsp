<%-- 
    Document   : Reporte
    Created on : Aug 6, 2016, 2:05:24 PM
    Author     : aerc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="PDF.jsp" method="POST" target="_black">
            <div class="col-sm-12 formEL">
                    <jsp:useBean id="Unid_Orga_Bean" class="com.sv.udb.Ctrl.UnidOrgaCtrl" scope="page" />
                    <select id="cmbUnidOrga" name="cmbUnidOrga">
                        <c:forEach items="${Unid_Orga_Bean.consTodo()}" var="fila">
                            <option value="${fila.CODI_UNID_ORGA}">${fila.NOMB_UNID}</option>
                        </c:forEach>
                    </select>
            </div>
            <input type="submit" value="Enviar">
        </form>
                    <br><br><br>
        <form action="PDF2.jsp" method="POST" target="_black">
            <div class="col-sm-12 formEL">
                    <jsp:useBean id="Pers" class="com.sv.udb.Ctrl.PersCtrl" scope="page" />
                    <select id="cmbPers" name="cmbPers">
                        <c:forEach items="${Pers.consTodo()}" var="fila">
                            <option value="${fila.codi_pers}">${fila.nomb_pers}</option>
                        </c:forEach>
                    </select>
            </div>
            <input type="submit" value="Enviar">
        </form>     
                    
        <form action="PDF3.jsp" method="POST" target="_black">
            <div class="col-sm-12 formEL">
                <input id="I" name="I" type="date">
                <input id="F" name="F" type="date">
            </div>
            <input type="submit" value="Enviar">
        </form>
    </body>
</html>
