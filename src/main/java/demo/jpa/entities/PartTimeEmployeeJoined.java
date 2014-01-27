package demo.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="employeeId")
public class PartTimeEmployeeJoined extends EmployeeJoined {
	private Integer hourlyrates;

	private Integer period;

	public PartTimeEmployeeJoined() {
		this(null, null, null, null);
	}
		
	public PartTimeEmployeeJoined(String firstName, String lastName, Integer hourlyrates, Integer period) {
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
