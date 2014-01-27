package demo.jpa.entities;

import javax.persistence.Entity;

@Entity
public class FullTimeEmployeeTablePerClass extends EmployeeTablePerClass {
	private Integer salary;

	public FullTimeEmployeeTablePerClass() {
		this(null, null, null);
	}
		
	public FullTimeEmployeeTablePerClass(String firstName, String lastName, Integer salary) {
		super(firstName, lastName);
		this.salary = salary;
	}

	public Integer getSalary() {
		return salary;
	}

}
