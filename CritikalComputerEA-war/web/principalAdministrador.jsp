<%@page import="models.Usuarios"%>
<html>
    <head>
        <title>Critikal Computer</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Recursos/FondoCss.css">
        <link rel="stylesheet" href="Recursos/newcss.css">

    </head>
    <body>
        <%Usuarios usuario = (Usuarios) session.getAttribute("Usuario");%>
        <form action="/CritikalComputerEA-war/frontServlet" method="post">
            <div class="salir">
                <input type="hidden" name="command" value="cuenta.salir">
                <button type="submit" class="myButton" id="derecha">Cerrar Sesion</button>
            </div>
        </form>
        <a href="/CritikalComputerEA-war/Log.jsp" href="#" class="myButton" id="izquierda">Log</a>
        <a href="/CritikalComputerEA-war/VerEstadisticas.jsp" href="#" class="myButton" id="izquierda">Ver Estadisticas</a>
        <a href="/CritikalComputerEA-war/Carrito.jsp" href="#" class="myButton" id="izquierda">Ver Carrito</a>
        <br>
        <%if (usuario.getTipo().equals("Administrador")) {%>
        <%}%>
        <ul id="listaPrincipal">
            <h4>Elija una opción:</h4>
            <%if (usuario.getTipo().equals("Administrador")) {%>
            <li>
                <form action="/CritikalComputerEA-war/frontServlet" method="post">
                    <input type="hidden" name="command" value="AccionesUsuario.MostrarUsuarios">
                    <input type="hidden" name="indice" value="0">
                    <button type="submit" name="usuarios" class="myButton" > Ver Usuarios</button>
                </form>
            </li>
            <li>
                <form action="/CritikalComputerEA-war/frontServlet" method="post">
                    <input type="hidden" name="command" value="AccionesOfertas.MostrarOfertas">
                    <button type="submit" name="ofertas" href="#" class="myButton" > Ver OFERTAS</button>
                </form>
            </li>
            <li>
                <form action="/CritikalComputerEA-war/frontServlet" method="post">
                    <input type="hidden" name="command" value="AccionesVentas.MostrarVentas">
                    <button type="submit" name="ventas" href="#" class="myButton" > Ver Ventas</button>
                </form>
            </li>
            <li>
                <form action="/CritikalComputerEA-war/frontServlet" method="post">
                    <input type="hidden" name="command" value="AccionesProveedores.MostrarProveedores">
                    <button type="submit" name="proveedores" class="myButton" > Ver proveedores</button>
                </form>
            </li>
            <%}%>
            <li>
                <form action="/CritikalComputerEA-war/frontServlet" method="POST">
                    <input type="hidden" name="command" value="AccionesProducto.MostrarProductos">
                    <button type="submit" name="productos"  class="myButton"> Ver Productos</button>
                </form>
            </li>
            <li>
                <form action="/CritikalComputerEA-war/frontServlet" method="POST">
                    <input type="hidden" name="command" value="AccionesProducto.MostrarProductosCriteriaAPI">
                    <input type="hidden" name="criterio" value="abcd">
                    <button type="submit" name="productos" class="myButton"> Ver Productos ordenados</button>
                </form>
            </li>
            <li>
                <form action="/CritikalComputerEA-war/frontServlet" method="POST">
                    <input type="hidden" name="command" value="AccionesProducto.MostrarProductosCriteriaAPI">
                    <input type="hidden" name="criterio" value="asc">
                    <button type="submit" name="productos"  class="myButton"> Ver Productos ordenados por Precio ASC</button>
                </form>
            </li>
            <li>
                <form action="/CritikalComputerEA-war/frontServlet" method="POST">
                    <input type="hidden" name="command" value="AccionesProducto.MostrarProductosCriteriaAPI">
                    <input type="hidden" name="criterio" value="desc">
                    <button type="submit" name="productos"  class="myButton"> Ver Productos ordenados por Precio DESC</button>
                </form>
            </li>
        </ul>


    </body>
</html>