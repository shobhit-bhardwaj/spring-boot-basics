package com.shobhit.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shobhit.common.Response;
import com.shobhit.entity.IGenericEntity;

public interface IGenericController<T extends IGenericEntity<T>> {

	@RequestMapping (value = "", method = RequestMethod.POST)
	public Response<?> addResource(@RequestBody T t);

	@RequestMapping (value = "", method = RequestMethod.GET)
	public Response<?> listResources();

	@RequestMapping (value = "/{id}", method = RequestMethod.GET)
	public Response<?> getResource(@PathVariable UUID id);

	@RequestMapping (value = "/{id}", method = RequestMethod.PUT)
	public Response<?> updateResource(@PathVariable UUID id, @RequestBody T t);

	@RequestMapping (value = "/{id}", method = RequestMethod.DELETE)
	public Response<?> deleteResource(@PathVariable UUID id);
}