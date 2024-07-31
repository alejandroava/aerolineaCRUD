package org.example.model;

import org.example.entities.Avion;
import org.example.persistencia.Conexion;
import org.example.persistencia.imodel.IAvionModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AvionModel implements IAvionModel {
    @Override
    public Avion create(Avion request) {
        Avion avion=null;
        Connection connection = Conexion.openConnection();
        try {
            String SQLquery = "INSERT INTO (modelo,cadena) VALUES(?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(SQLquery,PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,request.getModelo());
            preparedStatement.setInt(2,request.getCapacidad());

            preparedStatement.execute();
            ResultSet result = preparedStatement.getResultSet();
            while (result.next()){
                avion = new Avion(result.getInt("id"),
                        result.getString("modelo"),
                        result.getInt("capacidad"));
            }

        }catch (SQLException error){
            throw new RuntimeException(error.getMessage());
        }
        Conexion.closeConnection();
        return avion;
    }

    @Override
    public Boolean delete(Integer integer) {
        return null;
    }
}
