package ru.artamonov.service;

/**
 * Classes that implement this interface are responsible for processing information received from the database
 * @param <T> entity class
 * @param <K> entity id class
 */
public interface Service <T, K>{
    T save(T t);
    T findById(K id);

}
