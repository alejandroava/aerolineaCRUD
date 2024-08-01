package org.example.persistencia.imodel;

import org.example.entities.Reservacion;
import org.example.persistencia.interfaces.CreateModel;
import org.example.persistencia.interfaces.DeleteModel;
import org.example.persistencia.interfaces.ReadModel;
import org.example.persistencia.interfaces.UpdateModel;

import javax.swing.text.html.parser.Entity;

public interface IReservacionModel extends
        CreateModel <Reservacion>,
        ReadModel <Integer>,
        UpdateModel<Reservacion>,
        DeleteModel <Integer> {
}
