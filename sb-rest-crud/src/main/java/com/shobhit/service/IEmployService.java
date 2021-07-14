package com.shobhit.service;

import java.util.List;

import com.shobhit.entity.Employ;

public interface IEmployService {
	public Employ addEmploy(Employ employ);

	public List<Employ> listEmploys();

	public Employ getEmploy(int id);

	public Employ updateEmploy(int id, Employ employ);

	public void deleteEmploy(int id);
}