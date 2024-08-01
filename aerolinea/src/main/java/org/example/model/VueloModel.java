package org.example.model;

import org.example.entities.Vuelo;
import org.example.persistencia.imodel.IVueloModel;

import java.sql.Date;

public class VueloModel implements IVueloModel {
    @Override
    public Vuelo create(Vuelo request) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public String readById(int id) {
        return "";
    }

    @Override
    public Date update(Date request, int id) {
        return null;
    }
}
