package com.asutptec.simpleproject.repository;

import java.util.List;

/**
 * Base repository interface provide method for simple CRUD operation.
 * 
 * @author Aliaksandr_Shyshonak
 *
 * @param <T>
 *            type of domain object
 */
public interface BaseRepository<T> {

    /**
     * Add object to database.
     * 
     * @param object
     *            object for store
     * @return true if operation is successful.
     */
    boolean add(T object);

    /**
     * Makes a request to the database to receive objects according to the
     * specification.
     * 
     * @param spec
     *            query specification
     * @return collection of the object from database.
     */
    List<T> query(Specification spec);

    /**
     * Delete entity matched domain object.
     * 
     * @param object
     *            object to delete from database
     * @return true if operation is successful.
     */
    boolean remove(T object);

    /**
     * Update entity in database.
     * 
     * @param object
     *            object to update
     */
    boolean update(T object);
}
