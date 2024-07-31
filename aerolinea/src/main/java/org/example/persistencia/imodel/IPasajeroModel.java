package org.example.persistencia.imodel;

import org.example.entities.Pasajero;
import org.example.persistencia.interfaces.CreateModel;
import org.example.persistencia.interfaces.DeleteModel;
import org.example.persistencia.interfaces.ReadModel;
import org.example.persistencia.interfaces.UpdateModel;

public interface IPasajeroModel extends
        CreateModel <Pasajero>,
        ReadModel <String>,
        UpdateModel <Pasajero>,
        DeleteModel <Pasajero> {
}
