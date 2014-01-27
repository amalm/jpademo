package demo.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="employeeId")
public class FullTimeEmployeeJoined extends EmployeeJoined {
	private Integer salary;

	public FullTimeEmployeeJoined() {
		this(null, null, null);
	}
		
	public FullTimeEmployeeJoined(String firstName, String lastName, Integer salary) {
		super(firstName, lastName);
		this.salary = salary;
	}

	public Integer getSalary() {
		return salary;
	}

}
