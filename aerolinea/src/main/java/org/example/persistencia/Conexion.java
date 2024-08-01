package org.example.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection connection = null;

    public static Connection openConnection(){
        String url= "jdbc:mysql://libreria-bdlibreria.i.aivencloud.com:27584/aerolineaBD";
        String user= "avnadmin";
        String password="AVNS_qYyQ9hIG_3ugWaXiFJi";

        try {
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("Conexion establecida");
        }catch (SQLException error){
            throw new RuntimeException(error.getMessage());
        }
        return connection;
    }

    public static void closeConnection(){
        try{
            if(connection != null){
                connection.close();
                System.out.println("Conexion cerrada");
            }
        }catch (SQLException error){
            throw new RuntimeException(error.getMessage());
        }
    }
}
