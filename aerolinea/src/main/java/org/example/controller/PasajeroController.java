package org.example.controller;

import org.example.entities.Pasajero;
import org.example.model.PasajeroModel;

import javax.swing.*;
import java.util.List;

public class PasajeroController {
    PasajeroModel pasajeroModel;

    public PasajeroController(){
        this.pasajeroModel = new PasajeroModel();
    }

    public void create(){
        String nombre = JOptionPane.showInputDialog("Imgrese el nombre del pasajero");
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del pasajero");
        String documentoIdentidad = JOptionPane.showInputDialog("Ingrese el documento de identidad");

        Pasajero pasajero= new Pasajero(0,nombre,apellido,documentoIdentidad);
        Pasajero result = this.pasajeroModel.create(pasajero);

        JOptionPane.showMessageDialog(null,result.toString());

    }
    public void delete (){
        String documentoIdentidad= JOptionPane.showInputDialog("Ingrese el documento de identidad  del pasajero");
        //Avion avion = new Avion(id);
        pasajeroModel.delete(documentoIdentidad);
    }
    public List<Pasajero> readByNombre(String nombre){
        return this.pasajeroModel.readByNombre(nombre);
    }
}
