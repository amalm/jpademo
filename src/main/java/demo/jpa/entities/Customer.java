package demo.jpa.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
public class Customer
{
    @Id
    @GeneratedValue
    private Long id;
    
    private String lastName;
    private String firstName;
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
    @JoinColumn(name="CUSTOMER_ID")
    private Set<Address> addresses;
    
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
    @JoinColumn(name="CUSTOMER_ID")
    private Set<Contact> contacts;

    /**
     * For Hibernate...
     */
    Customer()
    {
        this(null, null, null, null);
    }
    
    public Customer(String lastName, String firstName, Set<Address> addresses, Set<Contact> contacts)
    {
        this.lastName = lastName;
        this.firstName = firstName;
        this.addresses = addresses;
        this.contacts = contacts;
    }
    
    public Long getId()
    {
        return id;
    }

    public String getLastName()
    {
        return lastName;
    }
    public String getFirstName()
    {
        return firstName;
    }
    
    public Set<Address> getAddresses()
    {
        return addresses;
    }

    public Set<Contact> getContacts()
    {
        return contacts;
    }
    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }

}
