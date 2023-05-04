package com.shobhit.service;

import java.util.List;
import java.util.UUID;

public interface IGenericService<T> {
	public T addResource(T t);

	public List<T> listResources();

	public T getResource(UUID id);

	public T updateResource(UUID id, T t);

	public void deleteResource(UUID id);
}