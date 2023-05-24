<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.modelo.Producto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <p>SEGUNDO PARCIAL TEM-742</p>
            <p>NOMBRE: YEREMY BRAYAN CHOQUE MENDOZA</p>
            <p>CARNET: 6136265</p>
        </div>
        <h1>Gestion de productos</h1>
        <a href="Inicio?action=add">Nuevo Producto</a>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>DESCRIPCION</th>
                <th>CANTIDAD</th>
                <th>PRECIO</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="producto" items="${productos}">
                <tr>
                    <td>${producto.id}</td>
                    <td>${producto.descripcion}</td>
                    <td>${producto.cantidad}</td>
                    <td>${producto.precio}</td>
                    <td><a href="Inicio?action=edit&id=${producto.id}">Modificar</a></td>
                    <td><a href="Inicio?action=delete&id${producto.id}">Eliminar</a></td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>
