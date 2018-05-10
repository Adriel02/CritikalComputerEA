<%-- 
    Document   : verUsuarios
    Created on : 10-may-2018, 12:25:31
    Author     : Adriel
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>CritikalComputer</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Recursos/loginCss.css">
        <link rel="stylesheet" href="Recursos/newcss.css">
    </head>
    <body>
        <h1>Hello World!</h1>
        <table>
            <tr><th>Nombre</th><th>Apellidos</th><th>Tipo</th><th colspan="2">Opciones</th></tr>
            <%
                ResultSet rs = (ResultSet) request.getAttribute("noRs");
                if (rs != null) {
                    while (rs.next()) {%>
                <td><%=rs.getString("NOMBRE")%></td>
                <td><%=rs.getString("APELLIDO")%></td>
                <td><%=rs.getString("tipo")%></td>
            
        <%}
            %>
        </table>   
        <%}
        %>
    </body>
</html>
