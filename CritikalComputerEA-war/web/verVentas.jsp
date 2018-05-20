<%-- 
    Document   : verOfertas
    Created on : 10-may-2018, 12:25:31
    Author     : Adriel
--%>

<%@page import="models.Ventas"%>
<%@page import="java.util.List"%>
<%@page import="models.Usuarios"%>
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
    <%List<Ventas> ventas = (List<Ventas>) request.getAttribute("listaVentas");
        Usuarios usuario = (Usuarios) session.getAttribute("Usuario");%>
    <body>
        <a href="/CritikalComputerEA-war/principalAdministrador.jsp" href="#" class="myButton">Inicio</a>

        <table>
            <tr><th>Usuario</th><th>Fecha</th><th>Precio Final</th><th>Eliminar</th></tr>
                    <% for (int i = 0; i < ventas.size(); i++) {%>
            <tr>
                <td><%= ventas.get(i).getUsuario()%></td>
                <td><%= ventas.get(i).getFecha()%></td>
                <td><%= ventas.get(i).getPreciototal() %> €</td>
                <td><a href="/CritikalComputerEA-war/frontServlet?command=AccionesVentas.deleteVenta&id=<%=ventas.get(i).getId()%>" class="myButton">Eliminar</a></td>
            </tr>
            <%}%>
        </table> 
    </body>
</html>