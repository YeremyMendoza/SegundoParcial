package com.dao;

import com.modelo.Producto;
import com.utils.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductosDAOImplementacion extends ConexionDB implements ProductoDAO {

    ArrayList<Producto> productos;
    Producto producto;
    String sql;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public void insert(Producto producto) throws Exception {
        this.conectar();
        sql = "insert into productos (descripcion, cantidad, precio) values (?, ?, ?)";
        ps = this.conn.prepareStatement(sql);
        ps.setString(1, producto.getDescripcion());
        ps.setInt(2, producto.getCantidad());
        ps.setFloat(3, producto.getPrecio());
        ps.executeUpdate();
    }

    @Override
    public void update(Producto producto) throws Exception {
        sql = "update productos set descripcion = ?, cantidad = ?, precio = ? where id = ?";
        ps = this.conn.prepareStatement(sql);
        ps.setString(1, producto.getDescripcion());
        ps.setInt(2, producto.getCantidad());
        ps.setFloat(3, producto.getPrecio());
        ps.setInt(4, producto.getId());
        ps.executeUpdate();
    }

    @Override
    public void delete(int id) throws Exception {
        this.conectar();
        sql = "delete from productos where id = ?";
        ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Producto getById(int id) throws Exception {
        producto = new Producto();
        this.conectar();
        sql = "select * from productos where id = ?";
        ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        while (rs.next()) {
            producto.setId(rs.getInt("id"));
            producto.setDescripcion(rs.getString("descripcion"));
            producto.setCantidad(rs.getInt("cantidad"));
            producto.setPrecio(rs.getFloat("precio"));
        }
        return producto;
    }

    @Override
    public List<Producto> getAll() throws Exception {
        productos = new ArrayList<Producto>();
        try {
            this.conectar();
            sql = "select * from productos";
            ps = this.conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                producto = new Producto();
                producto.setId(rs.getInt("id"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setCantidad(rs.getInt("cantidad"));
                producto.setPrecio(rs.getFloat("precio"));
                productos.add(producto);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            this.desconectar();
        }
        return productos;
    }

}
