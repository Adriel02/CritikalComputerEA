<%-- 
    Document   : CrearUsuario
    Created on : 10-may-2018, 11:47:39
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
                <h1>Crear Jugador</h1>
                <hr>
                <label for="Nombre"><b>Nombre</b></label>
                <input type="text" placeholder="Nombre" name="nombre" required>
                <label for="Apellidos"><b>Apellidos</b></label>
                <input type="text" placeholder="Apellidos" name="apellidos" required>
                <label for=""><b>Contraseña</b></label>
                <input type="text" placeholder="Contraseña" name="pass" required>
                <label for="tipo"><b>Tipo</b></label><br>
                <select name="tipo" required="required">
                    <option value="Administrador">Administrador</option>
                    <option value="Cliente">Cliente</option>
                </select>
                <input type="hidden" name="command" value="AccionesUsuario.addUsuario"><br><br>
                <button type="submit">Añadir</button>
            </div>
        </form>
    </body>
</html>
