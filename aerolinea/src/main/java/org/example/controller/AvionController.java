package org.example.controller;

import org.example.entities.Avion;
import org.example.model.AvionModel;

import javax.swing.*;

public class AvionController {
    AvionModel avionModel;

    public AvionController(){
        this.avionModel = new AvionModel();
    }

    public void create(){
        String modelo = JOptionPane.showInputDialog("Ingrese el modelo del avion");
        int capacidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la capacidad del avion"));

        Avion avion = new Avion(0 ,modelo, capacidad);

        Avion result = this.avionModel.create(avion);
        JOptionPane.showMessageDialog(null, result.toString());
    }

    public void delete (){
        int id= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del avion"));
        //Avion avion = new Avion(id);
        avionModel.delete(id);
    }


}
