package org.example;

import org.example.controller.AvionController;
import org.example.controller.PasajeroController;
import org.example.controller.ReservacionController;
import org.example.controller.VueloController;
import org.example.entities.Pasajero;
import org.example.entities.Vuelo;
import org.example.persistencia.Conexion;

import javax.swing.*;
import java.text.ParseException;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ParseException {

        AvionController avionController = new AvionController();
        VueloController vueloController = new VueloController();
        PasajeroController pasajeroController = new PasajeroController();
        ReservacionController reservacionController=new ReservacionController();
        //vueloController.create();
        //vueloController.delete();
        //avionController.create();
        //avionController.delete();
        //pasajeroController.create();
        //pasajeroController.delete();
        //reservacionController.create();
        //reservacionController.delete();
        //String destinoVuelo = JOptionPane.showInputDialog("Ingrese el destino del vuelo");
        //List<Vuelo> vuelos = vueloController.readByDestino(destinoVuelo);
        //for (Vuelo vl : vuelos){
            //JOptionPane.showMessageDialog(null, vl.toString());
        //}
        String nombrePasajero = JOptionPane.showInputDialog("Ingrese el nombre del pasajero");
        List<Pasajero> pasajeros = pasajeroController.readByNombre(nombrePasajero);
        for(Pasajero p:pasajeros){
            JOptionPane.showMessageDialog(null,p.toString());
        }

    }
}
