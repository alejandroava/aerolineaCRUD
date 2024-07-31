package org.example.persistencia.interfaces;

public interface UpdateModel <Entity> {
    public Entity update (Entity request , int id);
}
