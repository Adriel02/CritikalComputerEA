<%-- 
    Document   : Tienda
    Created on : 22-feb-2018, 19:34:38
    Author     : Adriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="Stateful.Usuario" %>
<html>
    <head>
        <title>Critikal Computer</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Recursos/FondoCss.css">
        <link rel="stylesheet" href="Recursos/newcss.css">

    </head>
    <body>

        <%if (session.getAttribute("Usuario") != null) {%>
        <form action="/CritikalComputerEA-war/frontServlet" method="post">
            <div class="salir">
                <input type="hidden" name="command" value="cuenta.salir">
                <button type="submit" class="myButton" id="derecha">Cerrar Sesion</button>
            </div>
        </form>
        <a href="/CritikalComputerEA-war/Carrito.jsp" href="#" class="myButton" id="izquierda">Ver Carrito</a>
        <%}%>
        <jsp:include page="/WEB-INF/Parciales/Cabecera.jsp"></jsp:include>
        <%= ((Usuario)session.getAttribute("Usuario")).getNombre() %>
        <div >
            <a href="/CritikalComputerEA-war/Producto1.jsp"><img id="imagen" src="https://www.tuexperto.com/wp-content/uploads/2017/08/Acer_IFA_Predator_ORION_9000_02.png" ></a>
            <h3 style="color: white">Precio:1260€</h3>
        </div>
        <div>
            <a href="/CritikalComputerEA-war/Producto2.jsp"><img id="imagen" src="https://media.aws.alkosto.com/media/catalog/product/cache/6/image/69ace863370f34bdf190e4e164b6e123/4/7/4713883441544_7.png" ></a>
            <h3 style="color: white">Precio:540€</h3>
        </div>
        <div>
            <a href="/CritikalComputerEA-war/Producto3.jsp"><img id="imagen" src="https://m.media-amazon.com/images/S/aplus-media/vc/65d71b57-8820-4a75-8d8d-a765fea186d2.png" ></a>
            <h3 style="color: white">Precio:1450€</h3>
        </div>
        <jsp:include page="/WEB-INF/Parciales/PieDePagina.jsp"></jsp:include>

    </body>
</html>

