package com.shobhit.entity;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "EMPLOY")
public class Employ {
	@Id
	@GeneratedValue
	@UuidGenerator
	private UUID id;
	private String name;
	private String designation;
	private int salary;
}