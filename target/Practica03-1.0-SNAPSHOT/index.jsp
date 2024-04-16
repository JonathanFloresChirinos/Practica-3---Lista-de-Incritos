<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.Inscritos"%>
<%
    if (session.getAttribute("semi") == null) {
        ArrayList<Inscritos> lisaux = new ArrayList<Inscritos>();
        session.setAttribute("semi", lisaux);
    }
    ArrayList<Inscritos> list = (ArrayList<Inscritos>) session.getAttribute("semi");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de inscritos</h1>
        <table border="1" cellspacing="0">
            <tr>
                <td><a href="MainServlet?op=nuevo">Nuevo</a></td>
            </tr>
            <tr>
                <th>Id</th>
                <th>Fecha</th>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>Turno</th>
                <th>Seminarios</th>
                <th></th>
                <th></th>
            </tr>
            <%
                if (list != null) {
                    for (Inscritos item : list) {


            %>
            <tr>
                <td><%=item.getId()%></td>
                <td><%=item.getFecha()%></td>
                <td><%=item.getNombre()%></td>
                <td><%=item.getApellidos()%></td>
                <td><%=item.getTurno()%></td>
                <td><%=item.getSem1()+", "+item.getSem2()+", "
                        +item.getSem3()+", "+item.getSem4()%></td>
                <td><a href="MainServlet?op=editar&id=<%=item.getId()%>">Editar</a></td>
                <td><a href="MainServlet?op=eliminar&id=<%=item.getId()%>" 
                       onclick="return(confirm('Esta seguro de eliminar??'))">Eliminar</a></td>
            </tr>
            <%
                    }
                }
            %>
        </table>
    </body>
</html>
