package com.shobhit.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shobhit.dao.EmployDao;
import com.shobhit.entity.Employ;
import com.shobhit.exception.InvalidDataException;
import com.shobhit.model.EmployRecord;
import com.shobhit.util.Convertor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployServiceImpl implements IEmployService {

	@Autowired
	private EmployDao employDao;

	@Override
	public EmployRecord addResource(EmployRecord employ) {
		log.info("-- addEmploy Service --");

		Employ entity = Convertor.convert(employ);
		entity = employDao.save(entity);
		employ = Convertor.convert(entity);

		return employ;
	}

	@Override
	public List<EmployRecord> listResources() {
		log.info("-- listEmploys Service --");

		List<Employ> entities = employDao.findAll();

		return entities.stream()
				.map(Convertor :: convert)
				.toList();
	}

	@Override
	public EmployRecord getResource(UUID id) {
		log.info("-- getEmploy Service --");

		Employ entity = employDao.findById(id).orElseThrow(() -> new InvalidDataException("Invalid UID - " + id));

		return Convertor.convert(entity);
	}

	@Override
	public EmployRecord updateResource(UUID id, EmployRecord employ) {
		log.info("-- updateEmploy Service --");

		Employ newEmploy = employDao.findById(id).orElseThrow(() -> new InvalidDataException("Invalid UID - " + id));
		newEmploy.setName(employ.name());
		newEmploy.setDesignation(employ.designation());
		newEmploy.setSalary(employ.salary());

		newEmploy = employDao.save(newEmploy);

		return Convertor.convert(newEmploy);
	}

	@Override
	public void deleteResource(UUID id) {
		log.info("-- deleteEmploy Service --");

		Employ employ = employDao.findById(id).orElseThrow(() -> new InvalidDataException("Invalid UID - " + id));
		employDao.delete(employ);
	}
}
