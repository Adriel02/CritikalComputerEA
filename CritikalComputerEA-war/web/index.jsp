<%-- 
    Document   : index
    Created on : 22-feb-2018, 13:27:18
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
        <form action="/CritikalComputerEA-war/frontServlet" method="post">
            <div class="login">
                <h1>Login</h1>
                <input type="text" name="nombre" placeholder="Usuario" required="required" autofocus="" />
                <input type="password" name="pass" placeholder="Contraseña" required="required" />
                <select name="tipo" required="required">
                    <option value="Administrador">Administrador</option>
                    <option value="Cliente">Cliente</option>
                </select>
                <input type="hidden" name="command" value="cuenta.login">
                <button type="submit" class="btn btn-primary btn-block btn-large" class="myButton">Entrar</button>
            </div>
        </form> 
        <form action="/CritikalComputerEA-war/Registro.jsp">
            <button type="hidden" class="myButton">Registrate aqui</button>
        </form>
        <%@include file="WEB-INF/Parciales/Cabecera.jsp" %>

    </body>
</html>
