<%-- 
    Document   : Producto2
    Created on : 23-feb-2018, 0:09:32
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
        <link rel="stylesheet" href="Recursos/FondoCss.css">
        <link rel="stylesheet" href="Recursos/newcss.css">
                <link rel="stylesheet" href="Recursos/footer.css">


    </head>
    <body>

        <a href="/CritikalComputerEA-war/Tienda.jsp" href="#" class="myButton" id="izquierda">Tienda</a>
        <jsp:include page="/WEB-INF/Parciales/Cabecera.jsp"></jsp:include>
            <form action="/CritikalComputerEA-war/frontServlet" method="post">
                <img id="imagen"src="https://media.aws.alkosto.com/media/catalog/product/cache/6/image/69ace863370f34bdf190e4e164b6e123/4/7/4713883441544_7.png"><br>
                Nombre:<input type="text" name="nombre" value="Producto 2" readonly>
                Precio:<input type="text" name="precio" value="540" readonly>
                Descripcion<input type="text" name="Descripcion" value="Preparate porque el pc este es la puta bomba" readonly>
                <input type="hidden" name="command" value="AccionesCarrito.AddProduct">
            <%if (session.getAttribute("Usuario") != null) {%>
            <button type="submit" href="#" class="myButton" id="izquierda">Añadir al carrito</button>
            <%}%>
        </form>
        <jsp:include page="/WEB-INF/Parciales/PieDePagina.jsp"></jsp:include>

    </body>
</html>
