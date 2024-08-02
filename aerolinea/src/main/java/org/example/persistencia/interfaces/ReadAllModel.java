package org.example.persistencia.interfaces;

import java.util.List;

public interface ReadAllModel <Entity> {
    public List<Entity> readAll (int id);
}
