<%-- 
    Document   : Producto1
    Created on : 23-feb-2018, 0:09:12
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
                <img id="imagen" src="https://www.tuexperto.com/wp-content/uploads/2017/08/Acer_IFA_Predator_ORION_9000_02.png" ><br>
                Nombre:<input type="text" name="nombre" value="Producto 1" readonly>
                Precio:<input type="text" name="precio" value="1260" readonly>
                Descripcion:<input type="text" name="descripcion" value="Preparate porque el pc este es la puta bomba" readonly>
                <input type="hidden" name="command" value="AccionesCarrito.AddProduct">
            <%if (session.getAttribute("Usuario") != null) {%>
            <button type="submit" href="#" class="myButton" id="izquierda">Añadir al carrito</button>
            <%}%>
        </form>
        <jsp:include page="/WEB-INF/Parciales/PieDePagina.jsp"></jsp:include>
    </body>
</html>

