<%-- 
    Document   : verUsuarios
    Created on : 10-may-2018, 12:25:31
    Author     : Adriel
--%>

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
    <% List<Usuarios> usuarios = (List<Usuarios>) request.getAttribute("lista"); 
    Usuarios usuario = (Usuarios) session.getAttribute("Usuario");%>
    <body>
        <a href="/CritikalComputerEA-war/principalAdministrador.jsp" href="#" class="myButton">Inicio</a>
        <table>
            <tr><th>Nombre</th><th>Apellidos</th><th>Tipo</th><th>Eliminar</th></tr>
                    <% for (int i = 0; i < usuarios.size(); i++) {%>
            <tr>
                <td><%= usuarios.get(i).getNombre()%></td>
                <td><%= usuarios.get(i).getApellidos()%></td>
                <td><%= usuarios.get(i).getTipo()%></td>
                <td><a href="/CritikalComputerEA-war/frontServlet?command=AccionesUsuario.deleteUsuario&id=<%=usuarios.get(i).getId()%>" class="myButton">Eliminar</a></td>
            </tr>
            <%}%>
        </table> 
        <%if (usuario.getTipo().equals("Administrador")) {%>
        <a href="/CritikalComputerEA-war/CrearUsuario.jsp" href="#" class="myButton" id="izquierda" class="myButton">Crear Usuario</a>
        <%}%>
    </body>
</html>
