<%-- 
    Document   : VerEstadisticas
    Created on : 05-abr-2018, 11:02:32
    Author     : Adriel
--%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="Singletons.Estadisticas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/Parciales/Cabecera.jsp"></jsp:include>
        <h1>Usuarios Logeados: <%= Estadisticas.getUsuariosInicioSession()%></h1>
        
        <h3>Apartado1</h3>
        <% for (Map.Entry<String, Integer> entry : Estadisticas.getRegistroPagina().entrySet()) {%>
        <h1><%= entry.getKey()%> - <%= entry.getValue()%></h1> 
        <% }%>

        <h3>Apartado2</h3>
        <% for (Map.Entry<String, Integer> entry2 : Estadisticas.getRegistroComponentes().entrySet()) {%>
        <h1><%= entry2.getKey()%> - <%= entry2.getValue()%></h1>
        <%}%>

        <h3>Apartado3</h3>
        <% for (Map.Entry<String, HashMap<String, Integer>> entry : Estadisticas.getRegistroComponentesUsuario().entrySet()) {%>
        <h1><%= entry.getKey()%>:</h1>
        <% for (Map.Entry<String, Integer> entry2 : entry.getValue().entrySet()) { %>
        <h2><%= entry2.getKey() %> - <%= entry2.getValue() %></h2>
        
        <% } %>
        <% }%>

        <jsp:include page="/WEB-INF/Parciales/PieDePagina.jsp"></jsp:include>
    </body>
</html>
