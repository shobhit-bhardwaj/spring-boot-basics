package com.shobhit.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@Setter

@Data
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "EMPLOY")
public class Employ implements IGenericEntity<Employ> {
	private static final long serialVersionUID = 1L;

	@Id
	@Type (type = "uuid-char")
	@GeneratedValue (generator = "uuid2")
	@GenericGenerator (name = "uuid2", strategy = "uuid2")
	private UUID id;
	private String name;
	private String designation;
	private int salary;
}