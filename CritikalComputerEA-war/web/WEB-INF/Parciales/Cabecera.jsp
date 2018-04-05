<%@page import="Singletons.Log"%>
<%@page import="Singletons.Estadisticas"%>
<header>
    <h1>Critikal Computer</h1>
</header>
<% Estadisticas.incrementarRegistroPagina(request.getRequestURI());     %>
<% Log.guardarJSP(request.getRequestURI());         %>