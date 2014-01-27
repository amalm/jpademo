package demo.jpa.repositories;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import demo.jpa.EmployeeDTO;
import demo.jpa.entities.EmployeeTablePerClass;
import demo.jpa.entities.FullTimeEmployeeTablePerClass;
import demo.jpa.entities.PartTimeEmployeeTablePerClass;

@ContextConfiguration(locations = "classpath:META-INF/jpa.spring.xml")
public class EmployeeTablePerClassRepositoryTest extends
		AbstractTransactionalTestNGSpringContextTests {
	@Autowired
	private EmployeeTablePerClassRepository target;

	@BeforeMethod()
	public void beforeMethod() {
		EmployeeTablePerClass employee = new PartTimeEmployeeTablePerClass(
				"firstName", "lastName", 1, 2);
		target.save(employee);
		employee = new FullTimeEmployeeTablePerClass("firstName", "lastName", 3);
		target.save(employee);

	}

	@Test
	public void findEmployee() {
		List<EmployeeTablePerClass> employees = target
				.findByLastName("lastName");

		assertEquals(employees.size(), 2);
		for (EmployeeTablePerClass e : employees) {
			assertEquals(e.getFirstName(), "firstName");
			if (e instanceof PartTimeEmployeeTablePerClass)
				assertEquals(
						((PartTimeEmployeeTablePerClass) e).getHourlyrates(),
						Integer.valueOf(1));
			else if (e instanceof FullTimeEmployeeTablePerClass)
				assertEquals(((FullTimeEmployeeTablePerClass) e).getSalary(),
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
