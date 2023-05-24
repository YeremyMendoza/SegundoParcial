<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nuevo | editar</h1>
        <form action="Inicio" method="post">
            <input type="hidden" name="id" value="${producto.id}">
            <table border="1">
                <tr>
                    <td>DESCRIPCION</td>
                    <td><input type="text" name="descripcion" value="${producto.descripcion}"></td>
                </tr>
                <tr>
                    <td>CANTIDAD</td>
                    <td><input type="number" name="cantidad" value="${producto.cantidad}"></td>
                </tr>
                <tr>
                    <td>PRECIO</td>
                    <td><input type="number" name="precio" value="${producto.precio}"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Enviar"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
