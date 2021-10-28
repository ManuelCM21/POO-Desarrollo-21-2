package Conexion;

import java.sql.*;

public class ConexionMySql {

    Connection conexion = null;
    String userDB = "root";
    String passwordDB = "";
    String url;

    public Connection conexionDB() {
        try {
            url = "jdbc:mysql://localhost:3307/poo-crud-persona";
            conexion = DriverManager.getConnection(url, userDB, passwordDB);
        } catch (SQLException e) {
            e.getMessage();
        }
        return conexion;
    }
    
    /* (13-14)
    try{
        Class.forName(com.mysql.jdbc.driver);
    }catch (SQLException e){
        e.getMessage();
    }
    */
}
