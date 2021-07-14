package com.shobhit.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@Setter

@EqualsAndHashCode
@ToString

@Data
@Entity
@Table(name = "EMPLOY")
public class Employ {

	@Id
	@GeneratedValue
	private int id;

	private String name;

	private String designation;

	private int salary;
}