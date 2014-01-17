package demo.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
public class Address
{
    @Id
    @GeneratedValue
    @SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
    private Long id;
    
    private String street;
    private String zip;
    private String city;
    
    /**
     * For Hibernate...
     */
    Address()
    {
        this(null, null, null);
    }
    
    public Address(String street, String zip, String city)
    {
        this.street = street;
        this.zip = zip;
        this.city = city;
    }
    
    public Long getId()
    {
        return id;
    }

    public String getStreet()
    {
        return street;
    }
    public String getZip()
    {
        return zip;
    }
    public String getCity()
    {
        return city;
    }

    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }
    
}

