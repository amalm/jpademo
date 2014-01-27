package demo.jpa;

public class EmployeeDTO {
    private String firstName;
    private String lastName;
    
    
	public EmployeeDTO(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}

}
