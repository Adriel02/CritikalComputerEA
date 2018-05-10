<%-- 
    Document   : CrearProducto
    Created on : 10-may-2018, 13:56:44
    Author     : Adriel
--%>

<%@page import="models.Ofertas"%>
<%@page import="models.Proveedores"%>
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
    <body>
        <form action="/CritikalComputerEA-war/frontServlet" method="POST">
            <input type="hidden" name="command" value="AccionesProducto.addProducto">
            <label for="Nombre"><b>Nombre</b></label>
            <input type="text" placeholder="Nombre" name="nombre" required>
            <label for="precio"><b>Precio</b></label>
            <input type="text" placeholder="Precio" name="precio" required>
            <label for="descripcion"><b>Descripcion</b></label>
            <textarea name="descripcion" rows="4" cols="30"></textarea>
            <label for="proveedor"><b>Proveedor</b></label><br>
            <select name="proveedor" required="required">
                <%for (int i = 0; i < proveedores.size(); i++) {%>
                <option value="<%=proveedores.get(i).getId()%>"><%=proveedores.get(i).getEmpresa()%></option>
                <%}%>
            </select>
            <label for="oferta"><b>Oferta</b></label><br>
            <select name="oferta" required="required">
                <%for (int i = 0; i < ofertas.size(); i++) {%>
                <option value="<%=ofertas.get(i).getId()%>"><%=ofertas.get(i).getDescuento()%>%</option>
                <%}%>
            </select>
        </form>
    </body>
</html>