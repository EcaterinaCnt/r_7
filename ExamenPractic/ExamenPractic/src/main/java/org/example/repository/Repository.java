package org.example.repository;

import java.util.List;

public interface Repository<E> {
    void addEntity(E entity);
    List<E> getAllEntities();
}
