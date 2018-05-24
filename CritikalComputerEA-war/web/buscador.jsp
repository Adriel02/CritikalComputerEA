<html>
    <head>
        <title>Critikal Computer</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Recursos/FondoCss.css">
        <link rel="stylesheet" href="Recursos/newcss.css">

    </head>
    <body>
        <form action="/CritikalComputerEA-war/frontServlet" method="POST">
            <label for="Nombre"><b>Nombre</b></label>
            <input type="text" placeholder="Nombre Producto" name="nombre" required>
            <input type="hidden" name="command" value="AccionesProducto.buscador"><br><br>
        </form>

            <jsp:include page="/WEB-INF/Parciales/PieDePagina.jsp"></jsp:include>
            </body>
            </html>