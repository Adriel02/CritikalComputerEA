<%-- 
    Document   : Carrito
    Created on : 22-feb-2018, 17:34:17
    Author     : Adriel
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="javax.naming.NamingException"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="operaciones.OfertasFacade"%>
<%@page import="models.Producto"%>
<%@page import="models.Ofertas"%>
<%@page import="Stateful.Carrito"%>
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
            <a href="/CritikalComputerEA-war/principalAdministrador.jsp" href="#" class="myButton" id="izquierda">Tienda</a>
            <table>
                <tr>
                    <th></th>
                    <th>Cantidad</th>
                    <th>Precio</th>
                    <th>PrecioTotal</th>
                    <th>Quitar Producto</th>
                </tr>
            <%
                Carrito carro = (Carrito) session.getAttribute("Carrito");
                double precioFinal = 0;
                List<Ofertas> listaOfertas = (List<Ofertas>) request.getAttribute("listaOfertas");
                System.out.println("fefefefe" + listaOfertas);
                for (Producto p : carro.getCarrito().keySet()) {%>
            <tr>
                <td id="stilo2" style="width: 20%;text-align: center;"><%= p.getNombre()%></td>
                <td><%=carro.getCarrito().get(p)%></td>
                <% for (int i = 0; i < listaOfertas.size(); i++) {
                        if (p.getOferta() == listaOfertas.get(i).getId()) {%>
                <td><%=(p.getPrecio() - (p.getPrecio() * (listaOfertas.get(i).getDescuento()) / 100))%>€</td>

                <td><%= (p.getPrecio() - (p.getPrecio() * (listaOfertas.get(i).getDescuento()) / 100)) * carro.getCarrito().get(p)%>€</td>
                <%}%>
                <%}%>
                <td><a href="/CritikalComputerEA-war/frontServlet?command=AccionesCarrito.EliminarProducto&id=<%=p.getId()%>" id="stilo1">Eliminar</a></td>
            </tr>
            <%}%>
        </table>
        <% for (int i = 0; i < listaOfertas.size(); i++) {
                for (Producto p : carro.getCarrito().keySet()) {
                    if (p.getOferta() == listaOfertas.get(i).getId()) {
                        precioFinal += (p.getPrecio() - (p.getPrecio() * (listaOfertas.get(i).getDescuento()) / 100)) * carro.getCarrito().get(p);
        %>
        <%}
                }
            }%>
        <h3>Precio Total a pagar: <%= precioFinal%>€</h3>

        <%if (carro.getCarrito().isEmpty() == false) {%>
        <a  href = "/CritikalComputerEA-war/frontServlet?command=AccionesCarrito.EliminarTodo" href = "#" class="myButton" id = "izquierda" > Vaciar Carrito</a >
        <%}%>
        <form action="/CritikalComputerEA-war/frontServlet" method="post">
            <div class="CompraCommand">
                <input type="hidden" name="command" value="cuenta.CompraCommand">            
                <button type="submit" href = "#" class="myButton" id = "derecha" > Comprar</button>
            </div>
        </form><br><br>
        <jsp:include page="/WEB-INF/Parciales/PieDePagina.jsp"></jsp:include>
    </body>
</html>

