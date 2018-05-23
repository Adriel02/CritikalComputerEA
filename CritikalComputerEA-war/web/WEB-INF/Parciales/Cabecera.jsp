<%@page import="Singletons.Log"%>
<%@page import="Singletons.Estadisticas"%>
<header>
    <img src="C:\Users\Adriel\Documents\Final Trabajo MDA\Final AS\CritikalComputerEA/cc.png" width="50" height="50">
    <h1>Critikal Computer</h1>
</header>
<% Estadisticas.incrementarRegistroPagina(request.getRequestURI());     %>
<% Log.guardarJSP(request.getRequestURI());         %>