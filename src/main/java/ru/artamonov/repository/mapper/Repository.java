package ru.artamonov.repository.mapper;

import java.util.List;

/**
 * Base repository interface it defines the basic methods of working with the database
 * @param <T> entity class
 * @param <K> entity primary key class
 */
public interface Repository <T, K>{
    T findById(K id);
    List<T> findAll();
    void insert(T t);
    void update(K id, T t);
    void remove(K id);
}
