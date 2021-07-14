package com.shobhit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shobhit.common.Response;
import com.shobhit.common.ResponseType;
import com.shobhit.entity.Employ;
import com.shobhit.service.IEmployService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping (value = "/employ")
public class EmployController {

	@Autowired
	private IEmployService employService;

	@RequestMapping (value = "/", method = RequestMethod.POST)
	public Response<?> addEmploy(@RequestBody Employ employ) {
		log.info("-- addEmploy -- " + employ);

		employ = employService.addEmploy(employ);

		return new Response<>(ResponseType.SUCCESS, employ);
	}

	@RequestMapping (value = "/", method = RequestMethod.GET)
	public Response<?> listEmploys() {
		log.info("-- listEmploys Controller --");

		List<Employ> employs = employService.listEmploys();

		return new Response<>(ResponseType.SUCCESS, employs);
	}

	@RequestMapping (value = "/{id}", method = RequestMethod.GET)
	public Response<?> getEmploy(@PathVariable int id) {
		log.info("-- getEmploy Controller -- " + id);

		Employ employ = employService.getEmploy(id);

		return new Response<>(ResponseType.SUCCESS, employ);
	}

	@RequestMapping (value = "/{id}", method = RequestMethod.PUT)
	public Response<?> updateEmploy(@PathVariable int id, @RequestBody Employ employ) {
		log.info("-- updateEmploy -- " + employ);

		employ = employService.updateEmploy(id, employ);

		return new Response<>(ResponseType.SUCCESS, employ);
	}

	@RequestMapping (value = "/{id}", method = RequestMethod.DELETE)
	public Response<?> deleteEmploy(@PathVariable int id) {
		log.info("-- deleteEmploy Controller -- " + id);

		employService.deleteEmploy(id);

		return new Response<>(ResponseType.SUCCESS);
	}
}