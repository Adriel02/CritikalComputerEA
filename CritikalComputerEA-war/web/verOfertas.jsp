<%-- 
    Document   : verOfertas
    Created on : 10-may-2018, 12:25:31
    Author     : Adriel
--%>

<%@page import="models.Ofertas"%>
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
        <link rel="stylesheet" href="Recursos/FondoCss.css">
        <link rel="stylesheet" href="Recursos/newcss.css">
    </head>
    <%List<Ofertas> ofertas = (List<Ofertas>) request.getAttribute("listaOfertas");
        Usuarios usuario = (Usuarios) session.getAttribute("Usuario");%>
    <body>
        <jsp:include page="/WEB-INF/Parciales/Cabecera.jsp"></jsp:include>

            <a href="/CritikalComputerEA-war/principalAdministrador.jsp" href="#" class="myButton">Inicio</a>

            <table>
                <tr><th>Nombre</th><th>Descuento</th><th>Eliminar</th></tr>
                    <% for (int i = 0; i < ofertas.size(); i++) {%>
            <tr>
                <td><%= ofertas.get(i).getNombre()%></td>
                <td><%= ofertas.get(i).getDescuento()%></td>
                <td><a href="/CritikalComputerEA-war/frontServlet?command=AccionesOfertas.deleteOferta&id=<%=ofertas.get(i).getId()%>" class="myButton">Eliminar</a></td>
            </tr>
            <%}%>
        </table> 
        <%if (usuario.getTipo().equals("Administrador")) {%>
        <a href="/CritikalComputerEA-war/CrearOferta.jsp" href="#" class="myButton" id="izquierda">Crear Oferta</a><br>
        <%}%>
        <jsp:include page="/WEB-INF/Parciales/PieDePagina.jsp"></jsp:include>
    </body>
</html>