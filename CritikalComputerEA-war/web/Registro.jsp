<%-- 
    Document   : Registro
    Created on : 25-feb-2018, 13:28:33
    Author     : Adriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Critikal Computer</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Recursos/cssRegistro.css">
    </head>
    <body>
            <form action="/CritikalComputerEA-war/frontServlet" method="post">
                <h1>Registro</h1>
                <fieldset>
                    <legend><span class="number">1</span> Rellenar la información</legend>
                    <label for="name">Usuario:</label>
                    <input type="text" name="nombre" placeholder="Usuario" required="required" autofocus="" />

                    <label for="mail">Correo Electrónico:</label>
                    <input type="email" id="mail" name="user_email" required="required">

                    <label for="password">Contraseña:</label>
                    <input type="password" name="pass" placeholder="Contraseña" required="required" />

                    <input type="hidden" name="command" value="cuenta.Registro">

                    <label>Edad:</label>
                    <input type="radio" id="under_13" value="under_13" name="user_age" required="required">
                    <label for="under_13" class="light">Menos de 18</label>

                    <input type="radio" id="over_13" value="over_13" name="user_age">
                    <label for="over_13" class="light">Mas de 18</label>
                    <button type="submit">Registrarse</button>
            </form>
        <jsp:include page="/WEB-INF/Parciales/PieDePagina.jsp"></jsp:include>

    </body>
</html>