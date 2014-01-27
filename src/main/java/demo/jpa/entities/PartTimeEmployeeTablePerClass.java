package demo.jpa.entities;

import javax.persistence.Entity;

@Entity
public class PartTimeEmployeeTablePerClass extends EmployeeTablePerClass {
	private Integer hourlyrates;

	private Integer period;

	public PartTimeEmployeeTablePerClass() {
		this(null, null, null, null);
	}
		
	public PartTimeEmployeeTablePerClass(String firstName, String lastName, Integer hourlyrates, Integer period) {
		super(firstName, lastName);
		this.hourlyrates = hourlyrates;
		this.period = period;
	}

	public Integer getHourlyrates() {
		return hourlyrates;
	}

	public Integer getPeriod() {
		return period;
	}
}
