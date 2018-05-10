<%-- 
    Document   : verProveedores
    Created on : 10-may-2018, 23:29:49
    Author     : Adriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.Proveedores"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
    <head>
        <title>CritikalComputer</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Recursos/loginCss.css">
        <link rel="stylesheet" href="Recursos/newcss.css">
    </head>
    <% List<Proveedores>proveedores=(List<Proveedores>)request.getAttribute("listaProveedores"); %>
    <body>
        <table>
            <tr><th>Nombre</th><th>Apellidos</th><th>Empresa</th><th>Eliminar</th></tr>
            <% for(int i = 0;i<proveedores.size();i++){%>
            <td><%= proveedores.get(i).getNombre() %></td>
            <td><%= proveedores.get(i).getApellidos()%></td>
            <td><%= proveedores.get(i).getEmpresa()%></td>
            <td><a href="/CritikalComputerEA-war/frontServlet?command=deleteProveedor&id=<%=proveedores.get(i).getId()%>">Eliminar</a></td>
            <%}%>
        </table>   
    </body>
</html>
