package org.example.persistencia.imodel;

import org.example.entities.Vuelo;
import org.example.persistencia.interfaces.CreateModel;
import org.example.persistencia.interfaces.DeleteModel;
import org.example.persistencia.interfaces.ReadModel;
import org.example.persistencia.interfaces.UpdateModel;

import java.sql.Date;

public interface IVueloModel extends
        CreateModel <Vuelo>,
        ReadModel<Vuelo>,
        UpdateModel<Date>,
        DeleteModel<Integer> {
}
