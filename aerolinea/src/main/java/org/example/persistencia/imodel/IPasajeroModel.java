package org.example.persistencia.imodel;

import org.example.entities.Pasajero;
import org.example.persistencia.interfaces.*;

public interface IPasajeroModel extends
        CreateModel <Pasajero>,
        ReadModelByNombre <Pasajero>,
        UpdateModel <Pasajero>,
        DeleteModel <String> {
}
