package co.uceva.edu.base.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    private static String url="jdbc:sqlite:C:\\Users\\camil\\OneDrive\\Documentos\\PWBI2023\\hdominguezv-ejemplojakartaeeprime-2155c38b48c9\\identifier.sqlite";

    public static Connection getConnection(){

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            return DriverManager.getConnection(url,"","");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
