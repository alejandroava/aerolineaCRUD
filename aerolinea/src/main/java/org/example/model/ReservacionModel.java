package org.example.model;

import org.example.entities.Pasajero;
import org.example.entities.Reservacion;
import org.example.entities.Vuelo;
import org.example.persistencia.Conexion;
import org.example.persistencia.imodel.IReservacionModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservacionModel implements IReservacionModel {
    @Override
    public Reservacion create(Reservacion request) {
        Reservacion reservacion=null;
        Connection connection = Conexion.openConnection();
        try {
            String SQLquery = "INSERT INTO Reservacion (id_pasajero,id_vuelo,fecha,asiento) VALUES(?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(SQLquery,PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1,request.getIdPasajero());
            preparedStatement.setInt(2,request.getIdVuelo());
            preparedStatement.setDate(3,request.getFechaReservacion());
            preparedStatement.setString(4,request.getAsiento());

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
            String SQLquery = "DELETE FROM Reservacion where id= ?;";
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
    public Reservacion update(Reservacion request, int id) {
        return null;
    }


    @Override
    public List<Integer> readByDestino(String destino) {
        return List.of();
    }

    @Override
    public List<Reservacion> readAll(int id) {
        Connection connection = Conexion.openConnection();
        List<Reservacion> reservaciones = new ArrayList<>();

        try{
            String sqlQuery = "SELECT * FROM Reservaciones;";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Reservacion reservacion = new Reservacion(resultSet.getInt("id"),
                        resultSet.getInt("id_pasajero"),
                        resultSet.getInt("id_vuelo"),
                        resultSet.getDate("fecha"),
                        resultSet.getString("asiento"));
                reservaciones.add(reservacion);
            }
            preparedStatement.close();
        }catch (SQLException error){
            throw new RuntimeException();
        }
        return reservaciones;
    }
}
