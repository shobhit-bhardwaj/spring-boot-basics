package com.shobhit.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.shobhit.common.Response;

public interface IGenericController<T> {

	@PostMapping
	public Response<T> addResource(@RequestBody T t);

	@GetMapping
	public Response<List<T>> listResources();

	@GetMapping (value = "/{id}")
	public Response<T> getResource(@PathVariable UUID id);

	@PutMapping (value = "/{id}")
	public Response<T> updateResource(@PathVariable UUID id, @RequestBody T t);

	@DeleteMapping (value = "/{id}")
	public Response<T> deleteResource(@PathVariable UUID id);
}