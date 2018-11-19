package com.asutptec.simpleproject.repository;

/**
 * Provide interface to form specialized SQL query.
 * 
 * @author Aliaksandr_Shyshonak
 *
 */
public interface Specification {

    /**
     * Method form SQL query based on special parameters.
     * 
     * @return String represent SQL query.
     */
    String toSqlQuery();
}
