package com.shobhit.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
	private int id;
	private String name;
	private String designation;
	private int salary;
}