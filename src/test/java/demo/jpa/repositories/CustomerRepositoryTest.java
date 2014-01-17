package demo.jpa.repositories;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.testng.annotations.Test;

import demo.jpa.entities.Address;
import demo.jpa.entities.Contact;
import demo.jpa.entities.Contact.ContactType;
import demo.jpa.entities.Customer;

@ContextConfiguration(loader=AnnotationConfigContextLoader.class, classes=RepositoryConfig.class)
@TransactionConfiguration(defaultRollback=false)
public class CustomerRepositoryTest extends AbstractTransactionalTestNGSpringContextTests
{
    @Autowired
    private CustomerRepository target;
    
    /**
     * Check configuration.
     */
    @Test
    public void saveRead()
    {
        Set<Address> addresses = new HashSet<Address>(Arrays.asList(new Address("street1", "zip1", "city1"),
                                                new Address("street2", "zip2", "city2")));
        Set<Contact> contacts = new HashSet<Contact>(Arrays.asList(new Contact(ContactType.MAIL, "setting@server.com")));
        Customer customer = new Customer("lastName2", "firstName", addresses, contacts);
        customer = target.save(customer);
        customer = target.findOne(customer.getId());
        assertEquals(customer.getAddresses().size(), 2);
        assertEquals(customer.getContacts().size(), 1);
    }
    @Test
    public void saveOne()
    {
        Customer customer = new Customer("lastName", "firstName", Collections.<Address> emptySet(), Collections.<Contact> emptySet());
        customer = target.save(customer);
    }
}
