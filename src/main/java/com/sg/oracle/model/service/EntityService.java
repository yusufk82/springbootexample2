package com.sg.oracle.model.service;

import java.util.List;

public interface EntityService<E>
{
    List<E> findAll();

    E save(E entity);
}
