package org.example.controller;

import org.example.entities.Vuelo;
import org.example.model.VueloModel;

import javax.swing.*;
import java.net.SocketImpl;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.util.List;

public class VueloController {
    VueloModel vueloModel;
    public VueloController (){
        this.vueloModel = new VueloModel();
    }
    public void create() throws ParseException {
        String destino = JOptionPane.showInputDialog("Ingrese el destino del vuelo");
        String fechaEntrada = JOptionPane.showInputDialog("Ingrese la fecha del vuelo(dd-MM-yyyy");
        SimpleDateFormat formatoSalida = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date fechautil = formatoSalida.parse(fechaEntrada);
        Date fechaSalida = new Date(fechautil.getTime());

        String horaEntrada = JOptionPane.showInputDialog("Ingrese la hora de salida del vuelo(HH:mm:ss");
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime horaSalidaLt = LocalTime.parse(horaEntrada,formatoHora);
        Time horaSalida = Time.valueOf(horaSalidaLt);

        int idAvion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del avion del vuelo"));

        Vuelo vuelo =new Vuelo(0,destino,fechaSalida,horaSalida,idAvion);
        Vuelo result = this.vueloModel.create(vuelo);
        JOptionPane.showMessageDialog(null, result.toString());
    }

    public void delete (){
        int id= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del vuelo"));
        //Avion avion = new Avion(id);
        vueloModel.delete(id);
    }
    public List<Vuelo> readByDestino(String destino){
        return this.vueloModel.readByDestino(destino);

    }
}
