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
        <link rel="stylesheet" href="Recursos/FondoCss.css">
        <link rel="stylesheet" href="Recursos/newcss.css">
        <link rel="stylesheet" href="Recursos/footer.css">

        <title>Critikal Computer</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/Parciales/Cabecera.jsp"></jsp:include>
            <a href="/CritikalComputerEA-war/Tienda.jsp" href="#" class="myButton" id="izquierda">Tienda</a><br>
            <h3>Usuarios Logeados: <%= Estadisticas.getUsuariosInicioSession()%></h3>
        <h3>Páginas visitadas.</h3>
        <% for (Map.Entry<String, Integer> entry : Estadisticas.getRegistroPagina().entrySet()) {%>
        <h4><%= entry.getKey()%> - <%= entry.getValue()%></h4> 
        <% }%>

        <h3>Componentes utilizados.</h3>
        <% for (Map.Entry<String, Integer> entry : Estadisticas.getRegistroComponentes().entrySet()) {%>
        <h4><%= entry.getKey()%> - <%= entry.getValue()%></h4>
        <%}%>

        <%-- 
         <h3>Apartado3</h3>
         <% for (Map.Entry<String, HashMap<String, Integer>> entry : Estadisticas.getRegistroComponentesUsuario().entrySet()) {%>
         <h1><%= entry.getKey()%>:</h1>
         <% for (Map.Entry<String, Integer> entry2 : entry.getValue().entrySet()) {%>
         <h2><%= entry2.getKey()%> - <%= entry2.getValue()%></h2>

        <% } %>
        <% }%>
        --%>
        <jsp:include page="/WEB-INF/Parciales/PieDePagina.jsp"></jsp:include>
    </body>
</html>
