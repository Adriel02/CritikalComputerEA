<%-- 
    Document   : verUsuarios
    Created on : 10-may-2018, 12:25:31
    Author     : Adriel
--%>

<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="javax.naming.NamingException"%>
<%@page import="javax.naming.Context"%>
<%@page import="operaciones.UsuariosFacade"%>
<%@page import="java.util.List"%>
<%@page import="models.Usuarios"%>
<%@page import="java.sql.ResultSet"%>
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
    <%  UsuariosFacade usuariosFacade = lookupUsuariosFacadeBean();
        int indice = (Integer) request.getAttribute("indice");
        List<Usuarios> usuarios = (List<Usuarios>) request.getAttribute("lista");
        Usuarios usuario = (Usuarios) session.getAttribute("Usuario");
        int maximo = usuariosFacade.count();
    %>
    <body>
        <a href="/CritikalComputerEA-war/principalAdministrador.jsp" href="#" class="myButton">Inicio</a>
        <table>
            <tr><th>ID</th><th>Nombre</th><th>Apellidos</th><th>Tipo</th><th>Eliminar</th></tr>
                    <% for (int i = 0; i < usuarios.size(); i++) {%>
            <tr>
                <td><%= usuarios.get(i).getId()%></td>
                <td><%= usuarios.get(i).getNombre()%></td>
                <td><%= usuarios.get(i).getApellidos()%></td>
                <td><%= usuarios.get(i).getTipo()%></td>
                <td><a href="/CritikalComputerEA-war/frontServlet?command=AccionesUsuario.deleteUsuario&id=<%=usuarios.get(i).getId()%>" class="myButton">Eliminar</a></td>
            </tr>
            <%}%>
        </table> 

        <div id="espaciadoabajo">
        <a href="/CritikalComputerEA-war/frontServlet?command=AccionesUsuario.MostrarUsuarios&indice=0" class="myButton"><<</a>
        <a href="/CritikalComputerEA-war/frontServlet?command=AccionesUsuario.MostrarUsuarios&indice=<%= minusTen(indice)%>" class="myButton"><</a>
        <a href="/CritikalComputerEA-war/frontServlet?command=AccionesUsuario.MostrarUsuarios&indice=<%= plusTen(indice, maximo)%>" class="myButton">></a>
        <a href="/CritikalComputerEA-war/frontServlet?command=AccionesUsuario.MostrarUsuarios&indice=<%=maximo - 3%>" class="myButton">>></a>
        </div>
        <br>
        <%if (usuario.getTipo().equals("Administrador")) {%>
        <a href="/CritikalComputerEA-war/CrearUsuario.jsp" href="#" class="myButton" id="izquierda" class="myButton">Crear Usuario</a>
        <%}%>
    </body>
</html>

<%!
    public static int minusTen(int indice) {
        int nuevoIndice = indice - 3;
        if (nuevoIndice < 0) {
            return 0;
        }
        return nuevoIndice;
    }

    public static int plusTen(int indice, int max) {
        int nuevoIndice = indice + 3;
        if (nuevoIndice > (max - 3)) {
            return (max - 3);
        }
        return nuevoIndice;

    }

    private UsuariosFacade lookupUsuariosFacadeBean() {
        try {
            Context c = new InitialContext();
            return (UsuariosFacade) c.lookup("java:global/CritikalComputerEA/CritikalComputerEA-ejb/UsuariosFacade!operaciones.UsuariosFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
%>
