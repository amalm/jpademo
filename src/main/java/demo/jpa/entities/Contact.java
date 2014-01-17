package demo.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
public class Contact
{
    public enum ContactType
    {
        MAIL,
        PHONE
    }
    @Id
    @GeneratedValue
    private Long id;

    private ContactType type;
    private String setting;
    
    /**
     * For Hibernate...
     */
    public Contact()
    {
        this(null, null);
    }

    public Contact(ContactType type, String setting)
    {
        this.type = type;
        this.setting = setting;
    }
    
    public Long getId()
    {
        return id;
    }
    public ContactType getType()
    {
        return type;
    }
    public String getSetting()
    {
        return setting;
    }
    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }
}
