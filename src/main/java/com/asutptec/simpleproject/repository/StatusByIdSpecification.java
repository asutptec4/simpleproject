package com.asutptec.simpleproject.repository;

public class StatusByIdSpecification implements Specification {

    private static final String QUERY = "SELECT id, name FROM status WHERE id=%d";
    
    private long id;
    
    public StatusByIdSpecification(long id) {
	super();
	this.id = id;
    }

    @Override
    public String toSqlQuery() {
	return String.format(QUERY, id);
    }

}
