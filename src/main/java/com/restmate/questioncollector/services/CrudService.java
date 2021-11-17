package com.restmate.questioncollector.services;

import java.util.Collection;
import java.util.Set;

public interface CrudService<T, ID> {

    Collection<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}
