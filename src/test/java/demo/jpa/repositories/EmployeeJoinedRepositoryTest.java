package demo.jpa.repositories;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import demo.jpa.EmployeeDTO;
import demo.jpa.entities.EmployeeJoined;
import demo.jpa.entities.FullTimeEmployeeJoined;
import demo.jpa.entities.PartTimeEmployeeJoined;

@ContextConfiguration(locations = "classpath:META-INF/jpa.spring.xml")
public class EmployeeJoinedRepositoryTest extends
		AbstractTransactionalTestNGSpringContextTests {
	@Autowired
	private EmployeeJoinedRepository target;

	@BeforeMethod()
	public void beforeMethod()
	{
		PartTimeEmployeeJoined partTimeEmployeeJoined = new PartTimeEmployeeJoined(
				"firstName", "lastName", 1, 2);
		target.save(partTimeEmployeeJoined);
		FullTimeEmployeeJoined fullTimeEmployeeJoined = new FullTimeEmployeeJoined("firstName", "lastName", 3);
		target.save(fullTimeEmployeeJoined);

	}
	@Test
	public void findEmployee() {
		List<EmployeeJoined> employees = target.findByLastName("lastName");

		assertEquals(employees.size(), 2);
		for (EmployeeJoined e : employees) {
			assertEquals(e.getFirstName(), "firstName");
			if (e instanceof PartTimeEmployeeJoined)
				assertEquals(
						((PartTimeEmployeeJoined) e).getHourlyrates(),
						Integer.valueOf(1));
			else if (e instanceof FullTimeEmployeeJoined)
				assertEquals(((FullTimeEmployeeJoined) e).getSalary(),
						Integer.valueOf(3));
		}
	}

	@Test
	public void findMinimalEmployeeByLastName() {
		List<EmployeeDTO> employees = target.findMinimalEmployeeByLastName("lastName");

		assertEquals(employees.size(), 2);
		for (EmployeeDTO e : employees) {
			assertEquals(e.getFirstName(), "firstName");
		}
	}
}
