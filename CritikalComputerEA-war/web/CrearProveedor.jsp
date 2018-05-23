<%-- 
    Document   : CrearProveedor
    Created on : 10-may-2018, 23:21:02
    Author     : Adriel
--%>

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
    <body>
        <jsp:include page="/WEB-INF/Parciales/Cabecera.jsp"></jsp:include>

        <a href="/CritikalComputerEA-war/principalAdministrador.jsp" href="#" class="myButton">Inicio</a>

        <form action="/CritikalComputerEA-war/frontServlet" method="post">
            <div class="addUsuario">
                <h1>Crear Proveedor</h1>
                <hr>
                <label for="Nombre"><b>Nombre</b></label>
                <input type="text" placeholder="Nombre" name="name" required>
                <label for="Apellidos"><b>Apellidos</b></label>
                <input type="text" placeholder="Apellidos" name="apellidos" required>
                <label for=""><b>Empresa</b></label>
                <input type="text" placeholder="Empresa" name="empresa" required>

                <input type="hidden" name="command" value="AccionesProveedores.addProveedor"><br><br>
                <button type="submit">Añadir</button>
            </div>
        </form>
        <jsp:include page="/WEB-INF/Parciales/PieDePagina.jsp"></jsp:include>
    </body>
</html>
