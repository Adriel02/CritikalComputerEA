<html>
    <head>
        <title>Critikal Computer</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Recursos/FondoCss.css">
        <link rel="stylesheet" href="Recursos/newcss.css">

    </head>
    <body>

        <form action="/CritikalComputerEA-war/frontServlet" method="post">
            <div class="salir">
                <input type="hidden" name="command" value="cuenta.salir">
                <button type="submit" class="myButton" id="derecha">Cerrar Sesion</button>
            </div>
        </form>
        <a href="/CritikalComputerEA-war/Log.jsp" href="#" class="myButton" id="izquierda">Log</a>
        <a href="/CritikalComputerEA-war/VerEstadisticas.jsp" href="#" class="myButton" id="izquierda">Ver Estadisticas</a>
        <a href="/CritikalComputerEA-war/CrearUsuario.jsp" href="#" class="myButton" id="izquierda">Crear Usuario</a>
        <a href="/CritikalComputerEA-war/CrearOferta.jsp" href="#" class="myButton" id="izquierda">Crear Oferta</a>
        <a href="/CritikalComputerEA-war/CrearProveedor.jsp" href="#" class="myButton" id="izquierda">Crear Proveedor</a>
        <a href="/CritikalComputerEA-war/CrearProducto.jsp" href="#" class="myButton" id="izquierda">Crear Producto</a>
        <br>
        <form action="/CritikalComputerEA-war/frontServlet" method="post">
            <input type="hidden" name="command" value="AccionesUsuario.MostrarUsuarios">
            <button type="submit" name="usuarios"> Ver Usuarios</button>
        </form>
        
        <form action="/CritikalComputerEA-war/frontServlet" method="post">
            <input type="hidden" name="command" value="AccionesOfertas.MostrarOfertas">
            <button type="submit" name="ofertas"> Ver OFERTAS</button>
        </form>
      
        
        <form action="/CritikalComputerEA-war/frontServlet" method="post">
            <input type="hidden" name="command" value="AccionesProveedores.MostrarProveedores">
            <button type="submit" name="proveedores"> Ver proveedores</button>
        </form>
      
        <jsp:include page="/WEB-INF/Parciales/PieDePagina.jsp"></jsp:include>

    </body>
</html>