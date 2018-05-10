<%-- 
    Document   : verProductos
    Created on : 10-may-2018, 14:40:10
    Author     : Adriel
--%>

<%@page import="models.Usuarios"%>
<%@page import="models.Producto"%>
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
    <% List<Producto> productos = (List<Producto>) request.getAttribute("listaProductos"); %>
    <% Usuarios usuario = (Usuarios) request.getAttribute("Usuario"); %>
    <body>
        <table>
            <tr><th>Nombre</th><th>Precio</th><th>Descripcion</th>><th>Proveedor</th>><th>Oferta</th><th>Eliminar</th></tr>
                    <% for (int i = 0; i < productos.size(); i++) {%>
            <td><%= productos.get(i).getNombre()%></td>
            <td><%= productos.get(i).getPrecio()%></td>
            <td><%= productos.get(i).getDescripcion()%></td>
            <td><%= productos.get(i).getProveedor()%></td>
            <td><%= productos.get(i).getOferta()%></td>
            <%if (usuario.getTipo().equals("Administrador")) {%>
            <td><a href="/CritikalComputerEA-war/frontServlet?command=deleteProducto&id=<%=productos.get(i).getId()%>">Eliminar</a></td>
            <td><a href="/CritikalComputerEA-war/frontServlet?command=modificarProducto&id=<%=productos.get(i).getId()%>">Modificar</a></td>
            <%} else {%>
            <td><a href="/CritikalComputerEA-war/frontServlet?command=addCarrito&id=<%=productos.get(i).getId()%>">Añadir al carrito</a></td>
            <%}%>
            <%}%>
        </table>   
    </body>
</html>
