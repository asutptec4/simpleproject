package com.asutptec.simpleproject.repository;

import com.asutptec.simpleproject.domain.Status;

public class StatusSpecification implements Specification {

    private static final String QUERY = "SELECT id, name FROM status WHERE name = '%s'";

    private Status status;

    public StatusSpecification(Status status) {
	super();
	this.status = status;
    }

    @Override
    public String toSqlQuery() {
	return String.format(QUERY, status.getName());
    }
}
