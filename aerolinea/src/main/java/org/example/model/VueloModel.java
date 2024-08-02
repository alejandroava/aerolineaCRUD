package org.example.model;

import org.example.entities.Vuelo;
import org.example.persistencia.Conexion;
import org.example.persistencia.imodel.IVueloModel;

import javax.swing.text.html.parser.Entity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VueloModel implements IVueloModel {
    @Override
    public Vuelo create(Vuelo request) {
        Vuelo vuelo = null;
        Connection connection = Conexion.openConnection();
        try {
            String SQLquery = "INSERT INTO Vuelo (destino,fecha_salida,hora_salida,id_avion) VALUES(?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(SQLquery,PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,request.getDestino());
            preparedStatement.setDate(2,request.getFechaSalida());
            preparedStatement.setTime(3,request.getHoraSalida());
            preparedStatement.setInt(4,request.getIdAvion());
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
    public void delete(Integer id) {
        Connection connection = Conexion.openConnection();

        try{
            String SQLquery = "DELETE FROM Vuelo where id= ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(SQLquery);

            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            preparedStatement.close();

        }catch (SQLException error){
            throw new RuntimeException(error.getMessage());
        }
        Conexion.closeConnection();
    }


    @Override
    public Date update(Date request, int id) {
        return null;
    }

    @Override
    public List<Vuelo> readByDestino(String destino) {
        Connection connection = Conexion.openConnection();
        Vuelo vuelo = null;
        List<Vuelo> vuelos = new ArrayList<>();
        try {
            String sqlQuery = "SELECT * FROM Vuelo WHERE destino = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setString(1,destino);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()){
                vuelo = new Vuelo(result.getInt("id"),
                        result.getString("destino"),
                        result.getDate("fecha_salida"),
                        result.getTime("hora_salida"),
                        result.getInt("id_avion"));
                vuelos.add(vuelo);
            }

            preparedStatement.close();

        }catch (SQLException error){
            throw new RuntimeException();
        }
        return vuelos;

    }
}
