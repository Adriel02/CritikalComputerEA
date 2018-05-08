<%-- 
    Document   : Carrito
    Created on : 22-feb-2018, 17:34:17
    Author     : Adriel
--%>

<%@page import="Stateful.Compra"%>
<%@page import="Stateful.Producto"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Critikal Computer</title>
        <link rel="stylesheet" href="Recursos/cssTabla.css">
        <link rel="stylesheet" href="Recursos/FondoCss.css">
        <link rel="stylesheet" href="Recursos/newcss.css">
        <link rel="stylesheet" href="Recursos/footer.css">

    </head>
    <body>
        <jsp:include page="/WEB-INF/Parciales/Cabecera.jsp"></jsp:include>
            <a href="/CritikalComputerEA-war/Tienda.jsp" href="#" class="myButton" id="izquierda">Tienda</a>
            <table>
                <tr>
                    <th></th>
                    <th>Cantidad</th>
                    <th>Precio</th>
                    <th>PrecioTotal</th>
                </tr>
            <%
                Compra compra = (Compra) session.getAttribute("Compra");
                for (Producto p : compra.getCompra().keySet()) {%>
            <tr>
                <td id="stilo2" style="width: 20%;text-align: center;"><%= p.getNombre()%></td>
                <td><%=compra.getCompra().get(p)%></td>
                <td><%= p.getPrecio()%>€</td>
                <td><%= p.getPrecio() * compra.getCompra().get(p)%>€</td>
            </tr>
            <%}%>
        </table>
        
        <jsp:include page="/WEB-INF/Parciales/PieDePagina.jsp"></jsp:include>

    </body>
</html>
