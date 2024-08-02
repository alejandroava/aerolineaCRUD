package org.example.model;

import org.example.entities.Avion;
import org.example.entities.Pasajero;
import org.example.persistencia.Conexion;
import org.example.persistencia.imodel.IPasajeroModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PasajeroModel implements IPasajeroModel {
    @Override
    public Pasajero create(Pasajero request) {
        Pasajero pasajero=null;
        Connection connection = Conexion.openConnection();
        try {
            String SQLquery = "INSERT INTO Pasajero (nombre,apellido,documento_identidad) VALUES(?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(SQLquery,PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,request.getNombre());
            preparedStatement.setString(2,request.getApellido());
            preparedStatement.setString(3,request.getDocumentoIdentidad());

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected == 1){
                return request;
            }

        }catch (SQLException error){
            throw new RuntimeException(error.getMessage());
        }
        Conexion.closeConnection();
        return null;
    }

    @Override
    public Pasajero update(Pasajero request, int id) {
        return null;
    }

    @Override
    public void delete(String s) {
        Connection connection = Conexion.openConnection();

        try{
            String SQLquery = "DELETE FROM Pasajero where documento_identidad= ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(SQLquery);

            preparedStatement.setString(1, s);
            preparedStatement.execute();
            preparedStatement.close();

        }catch (SQLException error){
            throw new RuntimeException(error.getMessage());
        }
        Conexion.closeConnection();
    }

    @Override
    public List<Pasajero> readByNombre(String nombre) {
        Connection connection = Conexion.openConnection();
        List<Pasajero> pasajeros = new ArrayList<>();

        try{
            String sqlQuery = "SELECT * FROM Pasajero WHERE nombre = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,nombre);

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Pasajero pasajero = new Pasajero(resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido"),
                        resultSet.getString("documento_identidad"));
                pasajeros.add(pasajero);
            }
            preparedStatement.close();

        }catch (SQLException error){
            throw new RuntimeException();
        }
        return pasajeros;
    }
}
