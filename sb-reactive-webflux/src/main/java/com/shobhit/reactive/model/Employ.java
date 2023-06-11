package com.shobhit.reactive.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employ {
	private int id;
	private String name;
	private String designation;
	private int salary;
}
