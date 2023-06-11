package com.shobhit.reactive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shobhit.reactive.dao.EmployDao;
import com.shobhit.reactive.model.Employ;

import reactor.core.publisher.Flux;

@Service
public class EmployService {

	@Autowired
	private EmployDao employDao;

	public List<Employ> getEmploysStream() {
		return employDao.getEmploysStream();
	}

	public Flux<Employ> getEmploysFlux() {
		return employDao.getEmploysFlux();
	}
}
