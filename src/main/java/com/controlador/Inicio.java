package com.controlador;

import com.dao.ProductoDAO;
import com.dao.ProductosDAOImplementacion;
import com.modelo.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Inicio", urlPatterns = {"/Inicio"})
public class Inicio extends HttpServlet {

    Producto producto;
    ProductoDAO dao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                try {
            int id;
            Producto producto = new Producto();
            String action = request.getParameter("action") != null ? request.getParameter("action") : "view";
            ProductoDAO dao = new ProductosDAOImplementacion();

            switch (action) {
                case "add":
                    request.setAttribute("producto", producto);
                    request.getRequestDispatcher("editar.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    producto = dao.getById(id);
                    request.setAttribute("producto", producto);
                    request.getRequestDispatcher("editar.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("Inicio");
                    break;
                case "view":
                    List<Producto> productos = dao.getAll();
                    request.setAttribute("productos", productos);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }

        } catch (Exception ex) {
                    System.out.println("Error: " + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        dao = new ProductosDAOImplementacion();
        int id = Integer.parseInt(request.getParameter("id"));
        String descripcion = request.getParameter("descripcion");
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        float precio = Float.parseFloat(request.getParameter("precio"));

        producto = new Producto();
        producto.setId(id);
        producto.setDescripcion(descripcion);
        producto.setCantidad(cantidad);
        producto.setPrecio(precio);

        try {
            if (id == 0) {
                dao.insert(producto);
            } else {
                dao.update(producto);
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        response.sendRedirect("Inicio");
    }
}
