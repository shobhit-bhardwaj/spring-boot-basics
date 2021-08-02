package com.shobhit.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shobhit.dao.IEmployDao;
import com.shobhit.entity.Employ;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployServiceImpl implements IEmployService {

	@Autowired
	private IEmployDao employDao;

	@Override
	public Employ addResource(Employ employ) {
		log.info("-- addEmploy Service --");

		return employDao.save(employ);
	}

	@Override
	public List<Employ> listResources() {
		log.info("-- listEmploys Service --");

		return employDao.findAll();
	}

	@Override
	public Employ getResource(UUID id) {
		log.info("-- getEmploy Service --");

		return employDao.findById(id).orElse(null);
	}

	@Override
	public Employ updateResource(UUID id, Employ employ) {
		log.info("-- updateEmploy Service --");

		Optional<Employ> employOptional = employDao.findById(id);
		if(employOptional.isPresent()) {
			Employ newEmploy = employOptional.get();
			newEmploy.setName(employ.getName());
			newEmploy.setDesignation(employ.getDesignation());
			newEmploy.setSalary(employ.getSalary());

			return employDao.save(newEmploy);
		}

		return null;
	}

	@Override
	public void deleteResource(UUID id) {
		log.info("-- deleteEmploy Service --");

		employDao.deleteById(id);
	}
}