package com.asutptec.simpleproject.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asutptec.simpleproject.domain.Status;
import com.asutptec.simpleproject.repository.AllStatusSpecification;
import com.asutptec.simpleproject.repository.BaseRepository;
import com.asutptec.simpleproject.repository.StatusByIdSpecification;
import com.asutptec.simpleproject.repository.StatusSpecification;

@Service("statusService")
public class StatusServiceImpl implements StatusService{

    private static final int FIRST_ELEMENT = 0;

    @Autowired
    private BaseRepository<Status> statusRepository;

    private StatusServiceImpl(BaseRepository<Status> statusRepository) {
	super();
	this.statusRepository = statusRepository;
    }

    @Override
    public Status save(Status object) {
	if (object.getId() != 0) {
	    statusRepository.update(object);
	} else {
	    statusRepository.add(object);
	}
	return statusRepository.query(new StatusSpecification(object)).get(FIRST_ELEMENT);
    }

    @Override
    public void remove(Status object) {
	if (object.getId() != 0) {
	    statusRepository.remove(object);
	}
    }

    @Override
    public Optional<Status> getById(long id) {
	List<Status> list = statusRepository.query(new StatusByIdSpecification(id));
	if (list.size() > 0) {
	    return Optional.of(list.get(FIRST_ELEMENT));
	} else {
	    return Optional.empty();
	}
    }

    @Override
    public Collection<Status> getAll() {
	return statusRepository.query(new AllStatusSpecification());
    }

}
