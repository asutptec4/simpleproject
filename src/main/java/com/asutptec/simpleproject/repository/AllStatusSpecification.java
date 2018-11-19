package com.asutptec.simpleproject.repository;

public class AllStatusSpecification implements Specification {

    private static final String QUERY = "SELECT id, name FROM status";
    
    @Override
    public String toSqlQuery() {
	return QUERY;
    }
}
