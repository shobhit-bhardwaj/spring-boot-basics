package com.shobhit.model;

import java.util.UUID;

public record EmployRecord(UUID id, String name, String designation, int salary) {
	public EmployRecord {
	}
}
