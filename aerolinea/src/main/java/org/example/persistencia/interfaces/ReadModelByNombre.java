package org.example.persistencia.interfaces;

import java.util.List;

public interface ReadModelByNombre <Entity> {
    public List<Entity> readByNombre(String nombre);
}
