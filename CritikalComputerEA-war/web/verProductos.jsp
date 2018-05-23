<%-- 
    Document   : verProductos
    Created on : 10-may-2018, 14:40:10
    Author     : Adriel
--%>

<%@page import="models.Ofertas"%>
<%@page import="java.util.HashMap"%>
<%@page import="models.Proveedores"%>
<%@page import="java.util.ArrayList"%>
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
        <link rel="stylesheet" href="Recursos/FondoCss.css">
        <link rel="stylesheet" href="Recursos/newcss.css">
    </head>
    <% List<Producto> productos = (List<Producto>) request.getAttribute("listaProductos");
        HashMap<Integer, Proveedores> mapaProveedores = (HashMap<Integer, Proveedores>) request.getAttribute("mapaProveedores");
        HashMap<Integer, Ofertas> mapaOfertas = (HashMap<Integer, Ofertas>) request.getAttribute("mapaOfertas");
        Usuarios usuario = (Usuarios) session.getAttribute("Usuario"); %>
    <body>
        <jsp:include page="/WEB-INF/Parciales/Cabecera.jsp"></jsp:include>
        <a href="/CritikalComputerEA-war/principalAdministrador.jsp" href="#" class="myButton">Inicio</a>

        <table>
            <tr><th>Nombre</th><th>Precio</th><th>PrecioDescuento</th><th>Descripcion</th><th>Proveedor</th><th>Oferta</th>
                    <%if (usuario.getTipo().equals("Administrador")) {%>
                <th>Eliminar</th><th>Modificar</th><th>Imagen</th></tr>
                    <%} else {%>
            <th>Añadir Producto</th><th>Imagen</th></tr>
                <%}%>
                <% for (int i = 0; i < productos.size(); i++) {%>
        <tr>
            <td><%= productos.get(i).getNombre()%></td>
            <td><%= productos.get(i).getPrecio()%> €</td>
            <td><%= (productos.get(i).getPrecio()) - (productos.get(i).getPrecio() * (mapaOfertas.get(productos.get(i).getOferta()).getDescuento())) / 100%> €</td>
            <td><%= productos.get(i).getDescripcion()%></td>
            <td><%= mapaProveedores.get(productos.get(i).getProveedor()).getEmpresa()%></td>
            <td><%= mapaOfertas.get(productos.get(i).getOferta()).getDescuento()%>%</td>
            <%if (usuario.getTipo().equals("Administrador")) {%>
            <td><a href="/CritikalComputerEA-war/frontServlet?command=AccionesProducto.deleteProducto&id=<%=productos.get(i).getId()%>" class="myButton">Eliminar</a></td>
            <td><a href="/CritikalComputerEA-war/frontServlet?command=AccionesProducto.seleccionarProducto&id=<%=productos.get(i).getId()%>" class="myButton">Modificar</a></td>
            <%} else {%>
            <td><a href="/CritikalComputerEA-war/frontServlet?command=AccionesCarrito.addCarrito&id=<%=productos.get(i).getId()%>" class="myButton">Añadir al carrito</a></td>
            <%}%>
            <td><img src="C:\Users\Adriel\Documents\Final Trabajo MDA\Final AS\CritikalComputerEA/<%= productos.get(i).getImagen() %>.png" width="150" height="150"></td>
        </tr>
        <%}%>
    </table> 
    <%if (usuario.getTipo().equals("Administrador")) {%>
    <a href="/CritikalComputerEA-war/frontServlet?command=AccionesProducto.seleccionadorOpciones" href="#" class="myButton" id="izquierda">Crear Producto</a><br>
    <%}%>
    <jsp:include page="/WEB-INF/Parciales/PieDePagina.jsp"></jsp:include>
</body>
</html>
