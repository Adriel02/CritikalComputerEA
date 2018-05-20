<%-- 
    Document   : ModificarProducto
    Created on : 10-may-2018, 14:46:58
    Author     : Adriel
--%>

<%@page import="models.Producto"%>
<%@page import="models.Proveedores"%>
<%@page import="models.Ofertas"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
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
    <% List<Proveedores> proveedores = (List<Proveedores>) request.getAttribute("listaProveedores"); %>
    <% List<Ofertas> ofertas = (List<Ofertas>) request.getAttribute("listaOfertas"); %>
    <% Producto producto = (Producto) request.getAttribute("producto");%>
    <body>
        <a href="/CritikalComputerEA-war/principalAdministrador.jsp" href="#" class="myButton">Inicio</a>

        <form action="/CritikalComputerEA-war/frontServlet" method="POST">
            <input type="hidden" name="command" value="AccionesProducto.addProducto">
            <label for="Nombre"><b>Nombre</b></label>
            <input type="text" placeholder="Nombre" name="nombre" required value="<%=producto.getNombre()%>">
            <label for="precio"><b>Precio</b></label>
            <input type="text" placeholder="Precio" name="precio" required value="<%=producto.getPrecio()%>">
            <label for="descripcion"><b>Descripcion</b></label>
            <textarea name="descripcion" rows="6" cols="30"><%=producto.getDescripcion()%></textarea>
            <label for="proveedor"><b>Proveedor</b></label><br>
            <select name="proveedor" required="required">
                <%for (int i = 0; i < proveedores.size(); i++) {
                        if (producto.getProveedor().equals(String.valueOf(proveedores.get(i).getId()))) {%>
                <option value="<%=proveedores.get(i).getId()%>" selected><%=proveedores.get(i).getEmpresa()%></option>
                <%} else {%>
                <option value="<%=proveedores.get(i).getId()%>"><%=proveedores.get(i).getEmpresa()%></option>
                <%}%>

                <%}%>
            </select>
            <label for="oferta"><b>Oferta</b></label><br>
            <select name="oferta" required="required">
                <%for (int i = 0; i < ofertas.size(); i++) {
                        if (producto.getOferta() == (ofertas.get(i).getId())) {%>
                <option value="<%=ofertas.get(i).getId()%>" selected><%=ofertas.get(i).getDescuento()%>%</option>
                <%} else {%>
                <option value="<%=ofertas.get(i).getId()%>"><%=ofertas.get(i).getDescuento()%>%</option>
                <%}%>
                <%}%>
            </select>
        </form>
    </body>
</html>
