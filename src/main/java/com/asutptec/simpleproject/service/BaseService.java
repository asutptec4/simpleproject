package com.asutptec.simpleproject.service;

import java.util.Collection;
import java.util.Optional;

/**
 * Base service interface represent simple operation for manipulation with
 * domain objects.
 * 
 * @author Aliaksandr_Shyshonak
 *
 * @param <T> type of domain object
 */
public interface BaseService<T> {

    /**
     * Save new object to storage place.
     * 
     * @param object object to save
     * @return saved object
     */
    T save(T object);

    /**
     * Remove object from storage.
     * 
     * @param object object to remove
     */
    void remove(T object);

    /**
     * Return object by id from storage place.
     * 
     * @param id object's id
     * @return object from storage with required id
     */
    Optional<T> getById(long id);

    /**
     * Return all object stored in storage.
     * 
     * @return collection of domain object from storage
     */
    Collection<T> getAll();
}
