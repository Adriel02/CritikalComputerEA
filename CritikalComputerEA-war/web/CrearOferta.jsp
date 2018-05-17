<%-- 
    Document   : CrearOferta
    Created on : 10-may-2018, 13:39:51
    Author     : Adriel
--%>

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
        <h1></h1>
        <form action="/CritikalComputerEA-war/frontServlet" method="post">
            <div class="addUsuario">
                <h1>Crear Oferta</h1>
                <hr>
                <label for="Nombre"><b>Nombre</b></label>
                <input type="text" placeholder="Nombre" name="nombre" required>
                <label for="Apellidos"><b>Descuento</b></label>
                <input type="text" placeholder="Descuento" name="descuento" required>
                
                <input type="hidden" name="command" value="AccionesOfertas.addOferta"><br><br>
                <button type="submit">Añadir</button>
            </div>
        </form>
    </body>
</html>
