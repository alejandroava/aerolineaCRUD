package org.example.persistencia.imodel;

import org.example.entities.Avion;
import org.example.persistencia.interfaces.CreateModel;
import org.example.persistencia.interfaces.DeleteModel;

public interface IAvionModel extends
        CreateModel <Avion>,
        DeleteModel <Integer> {
}
