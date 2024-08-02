package org.example.persistencia.imodel;

import org.example.entities.Reservacion;
import org.example.persistencia.interfaces.*;

import javax.swing.text.html.parser.Entity;

public interface IReservacionModel extends
        CreateModel <Reservacion>,
        ReadModel <Integer>,
        UpdateModel<Reservacion>,
        DeleteModel <Integer>,
        ReadAllModel<Reservacion> {
}
