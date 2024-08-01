package org.example;

import org.example.controller.AvionController;
import org.example.controller.VueloController;
import org.example.persistencia.Conexion;

import javax.swing.*;
import java.text.ParseException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ParseException {

        AvionController avionController = new AvionController();
        VueloController vueloController = new VueloController();
        //vueloController.create();
        vueloController.delete();
        //avionController.create();

        //avionController.delete();
    }
}
