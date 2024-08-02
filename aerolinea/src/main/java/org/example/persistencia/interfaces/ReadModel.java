package org.example.persistencia.interfaces;

import java.util.ArrayList;
import java.util.List;

public interface ReadModel <Entity>{
    public List<Entity> readByDestino(String destino);
}
