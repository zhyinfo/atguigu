package com.zhy.java8;

public class FilterEmployeeForSalary implements MyPredicate<Employee> {

	@Override
	public boolean compare(Employee t) {
		return t.getSalary() >= 5000;
	}

}
