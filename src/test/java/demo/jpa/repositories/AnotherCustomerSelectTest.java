package demo.jpa.repositories;

import static junit.framework.Assert.assertEquals;

import java.util.Collections;

import org.apache.commons.lang.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.testng.annotations.Test;

import demo.jpa.entities.Address;
import demo.jpa.entities.Contact;
import demo.jpa.entities.Customer;

//@ContextConfiguration(locations="classpath:test.spring.xml")
@ContextConfiguration(locations="classpath:META-INF/jpa.spring.xml")
@TransactionConfiguration
@Test(groups="xmlConfig")
public class AnotherCustomerSelectTest extends AbstractTransactionalTestNGSpringContextTests
{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(AnotherCustomerSelectTest.class);
    @Autowired
    private CustomerRepository target;
    
    @Test
    public void findByLastName()
    {
    	Customer customer = new Customer("lastName", "firstName", Collections.<Address>emptySet(), Collections.<Contact>emptySet());
    	target.save(customer);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        customer = target.findByLastName("lastName");
        stopWatch.stop();
        LOGGER.info("findWithLastName duration:{}", stopWatch.toString());
        LOGGER.info("findWithLastName result:{}", customer.toString());
        assertEquals(customer.getAddresses().size(), 0);
    }

}
