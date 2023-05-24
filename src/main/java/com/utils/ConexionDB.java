
package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {
    static public String driver= "com.mysql.cj.jdbc.Driver";
    static public String url = "jdbc:mysql://localhost:3306/db_almacen";
    static public String user = "root";
    static public String password = "Mendoza740";
    
    protected Connection conn = null;
    
    public ConexionDB(){
        System.out.println("Hola baquero");
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            if(conn != null){
             System.out.println("Conexion exitosa");   
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en el driver " + ex.getMessage());
        } catch (SQLException ex){
            System.out.println("Error al conectar " + ex.getMessage());
        }
    }
    public Connection conectar(){
        return conn;
    }
    public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexion " + ex.getMessage());
        }
    }
}
