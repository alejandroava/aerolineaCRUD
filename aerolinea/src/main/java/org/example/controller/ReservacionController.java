package org.example.controller;

import org.example.entities.Reservacion;
import org.example.model.ReservacionModel;

import javax.swing.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ReservacionController {
    ReservacionModel reservacionModel;

    public ReservacionController (){
        this.reservacionModel = new ReservacionModel();
    }
    public void create() throws ParseException {
        int idPasajero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del pasajero"));
        int idVuelo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del vuelo"));

        String fechaEntrada = JOptionPane.showInputDialog("Ingrese la fecha del vuelo(DD-MM-YYYY");
        SimpleDateFormat formatoFecha = new SimpleDateFormat("DD-mm-yyyy");
        java.util.Date fechautil = formatoFecha.parse(fechaEntrada);
        Date fechaReservacion = new Date(fechautil.getTime());

        String asiento = JOptionPane.showInputDialog("Ingrese el asiento de la reservacion");

        Reservacion reservacion = new Reservacion(0,idPasajero,idVuelo,fechaReservacion,asiento);
        Reservacion result = this.reservacionModel.create(reservacion);
        JOptionPane.showMessageDialog(null,result.toString());
    }
    public void delete (){
        int id= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la reservacion"));
        //Avion avion = new Avion(id);
        reservacionModel.delete(id);
    }
}
