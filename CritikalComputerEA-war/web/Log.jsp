<%-- 
    Document   : Log
    Created on : 05-abr-2018, 13:55:22
    Author     : Adriel
--%>

<%@page import="Singletons.Log"%>
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
        <a href="/CritikalComputerEA-war/Tienda.jsp" href="#" class="myButton" id="izquierda">Tienda</a><br>
            
        <%= Log.leerLog()%>
    </body>
</html>
