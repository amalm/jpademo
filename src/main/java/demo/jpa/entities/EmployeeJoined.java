package demo.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Base class CustomerInfo and GeneralInfo to provide a demo for base 
 * @author Anders Malmborg
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class EmployeeJoined {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    
    private String firstName;
    private String lastName;
    
    EmployeeJoined()
    {
    	this(null, null);
    }
    
	public EmployeeJoined(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Long getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
    

}
