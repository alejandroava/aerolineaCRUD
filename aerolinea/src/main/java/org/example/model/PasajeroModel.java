package org.example.model;

import org.example.entities.Avion;
import org.example.entities.Pasajero;
import org.example.persistencia.Conexion;
import org.example.persistencia.imodel.IPasajeroModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PasajeroModel implements IPasajeroModel {
    @Override
    public Pasajero create(Pasajero request) {
        Pasajero pasajero=null;
        Connection connection = Conexion.openConnection();
        try {
            String SQLquery = "INSERT INTO (nombre,apellido,documento_identidad) VALUES(?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(SQLquery,PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,request.getNombre());
            preparedStatement.setString(2,request.getApellido());
            preparedStatement.setString(3,request.getDocumentoIdentidad());

            preparedStatement.execute();
            ResultSet result = preparedStatement.getResultSet();
            while (result.next()){
                pasajero = new Pasajero (result.getInt("id"),
                        result.getString("nombre"),
                        result.getString("apellido"),
                        result.getString("documento_identidad"));
            }

        }catch (SQLException error){
            throw new RuntimeException(error.getMessage());
        }
        Conexion.closeConnection();
        return pasajero;
    }
}
