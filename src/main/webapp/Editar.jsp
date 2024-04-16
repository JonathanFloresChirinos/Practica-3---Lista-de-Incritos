<%@page import="com.emergentes.modelo.Inscritos"%>
<%
    Inscritos ins = (Inscritos) request.getAttribute("obj");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registro en Seminarios</h1>
        <form method="post" action="MainServlet?id=<%=ins.getId()%>">
            <table>
                <tr>
                    <th>Datos</th>
                    <th></th>
                    <th></th>
                    <th>Seminarios Disponibles</th>
                </tr>
                <tr>
                    <td>Fecha</td>
                    <td><input type="date" name="fecha" value="<%= ins.getFecha()%>"></td>
                    <td></td>
                    <td rowspan="5">
                        <input type="checkbox" name="sem1" value="Inteligencia Artificial">Inteligencia Artificial<br>
                        <input type="checkbox" name="sem2" value="Machine Learning">Machine Learning<br>
                        <input type="checkbox" name="sem3" value="Simulacion con Arena">Simulación con Arena<br>
                        <input type="checkbox" name="sem4" value="Robotica Educativa">Robotica Educativa<br>
                    </td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre"value="<%= ins.getNombre()%>"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>Apellidos</td>
                    <td><input type="text" name="apellidos"value="<%= ins.getApellidos()%>"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>Turno</td>
                    <td><input type="radio" name="turno" value="Mañana">Mañana
                        <input type="radio" name="turno" value="Tarde">Tarde
                        <input type="radio" name="turno" value="Noche">Noche
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td><input type="submit" value="Registrar"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
