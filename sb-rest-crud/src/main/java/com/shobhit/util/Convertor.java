package com.shobhit.util;

import com.shobhit.entity.Employ;
import com.shobhit.model.EmployRecord;

public class Convertor {

	private Convertor() {
	}

	public static EmployRecord convert(Employ employ) {
		return new EmployRecord(employ.getId(), employ.getName(), employ.getDesignation(), employ.getSalary());
	}

	public static Employ convert(EmployRecord employ) {
		return new Employ(employ.id(), employ.name(), employ.designation(), employ.salary());
	}
}
