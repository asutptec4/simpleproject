package com.asutptec.simpleproject.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.asutptec.simpleproject.domain.Status;

@Repository("statusRepository")
public class StatusRepository implements BaseRepository<Status> {
    
    private static final String ID = "id";

    private static final String NAME = "name";

    private static final String INSERT = "INSERT INTO status(id, name) VALUES (DEFAULT, ?)";

    private static final String UPDATE = "UPDATE status SET name = ? WHERE id = ?";

    private static final String DELETE = "DELETE FROM status WHERE id = ?";
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Status> mapper = new RowMapper<Status>() {

	@Override
	public Status mapRow(ResultSet rs, int rowNum) throws SQLException {
	    Status status = new Status();
	    status.setId(rs.getLong(ID));
	    status.setName(rs.getString(NAME));
	    return status;
	}
    };

    @Override
    public boolean add(Status object) {
	return jdbcTemplate.update(INSERT, object.getName()) > 0;
    }

    @Override
    public List<Status> query(Specification spec) {
	List<Status> list = jdbcTemplate.query(spec.toSqlQuery(), mapper);
	return list;
    }

    @Override
    public boolean remove(Status object) {
	return jdbcTemplate.update(DELETE, object.getId()) > 0;
    }

    @Override
    public boolean update(Status object) {
	return jdbcTemplate.update(UPDATE, object.getName(), object.getId()) > 0;
    }
}
