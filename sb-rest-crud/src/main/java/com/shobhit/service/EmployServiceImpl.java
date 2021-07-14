package com.shobhit.service;

import java.util.List;

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
	public Employ addEmploy(Employ employ) {
		log.info("-- addEmploy Service --");

		return employDao.save(employ);
	}

	@Override
	public List<Employ> listEmploys() {
		log.info("-- listEmploys Service --");

		return employDao.findAll();
	}

	@Override
	public Employ getEmploy(int id) {
		log.info("-- getEmploy Service --");

		return employDao.findById(id).orElse(null);
	}

	@Override
	public Employ updateEmploy(int id, Employ employ) {
		log.info("-- updateEmploy Service --");

		Employ newEmploy = employDao.findById(id).orElse(null);
		if(newEmploy != null) {
			newEmploy.setName(employ.getName());
			newEmploy.setDesignation(employ.getDesignation());
			newEmploy.setSalary(employ.getSalary());

			return employDao.save(newEmploy);
		}

		return null;
	}

	@Override
	public void deleteEmploy(int id) {
		log.info("-- deleteEmploy Service --");

		employDao.deleteById(id);
	}
}