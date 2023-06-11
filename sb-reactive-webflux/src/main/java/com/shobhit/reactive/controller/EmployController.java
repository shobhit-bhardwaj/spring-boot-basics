package com.shobhit.reactive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shobhit.reactive.model.Employ;
import com.shobhit.reactive.service.EmployService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping (value = "/employ")
public class EmployController {

	@Autowired
	private EmployService employService;

	@GetMapping("/stream")
	public List<Employ> getEmploysStream() {
		return employService.getEmploysStream();
	}

	@GetMapping(value = "/flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Employ> getEmploysFlux() {
		return employService.getEmploysFlux();
	}
}
