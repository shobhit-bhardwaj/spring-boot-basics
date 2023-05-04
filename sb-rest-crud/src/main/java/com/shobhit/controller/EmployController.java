package com.shobhit.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shobhit.common.Response;
import com.shobhit.common.ResponseType;
import com.shobhit.entity.Employ;
import com.shobhit.model.EmployRecord;
import com.shobhit.service.IEmployService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping (value = "/employ")
public class EmployController implements IGenericController<EmployRecord> {

	@Autowired
	private IEmployService employService;

	public Response<EmployRecord> addResource(EmployRecord employ) {
		log.info("-- addEmploy -- " + employ);

		employ = employService.addResource(employ);

		return new Response<>(ResponseType.SUCCESS, employ);
	}

	public Response<List<EmployRecord>> listResources() {
		log.info("-- listEmploys Controller --");

		List<EmployRecord> employs = employService.listResources();

		return new Response<>(ResponseType.SUCCESS, employs);
	}

	public Response<EmployRecord> getResource(UUID id) {
		log.info("-- getEmploy Controller -- " + id);

		EmployRecord employ = employService.getResource(id);
		if(employ == null)
			return new Response<>(ResponseType.RECORD_NOT_FOUND, employ);

		return new Response<>(ResponseType.SUCCESS, employ);
	}

	public Response<EmployRecord> updateResource(UUID id, EmployRecord employ) {
		log.info("-- updateEmploy -- " + employ);

		employ = employService.updateResource(id, employ);
		if(employ == null)
			return new Response<>(ResponseType.RECORD_NOT_FOUND, employ);

		return new Response<>(ResponseType.SUCCESS, employ);
	}

	public Response<EmployRecord> deleteResource(UUID id) {
		log.info("-- deleteEmploy Controller -- " + id);

		employService.deleteResource(id);

		return new Response<>(ResponseType.SUCCESS);
	}
}