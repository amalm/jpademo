package demo.jpa.repositories;

import java.util.List;

import org.apache.commons.lang.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.testng.annotations.Test;

import demo.jpa.entities.Customer;

//@ContextConfiguration(loader=AnnotationConfigContextLoader.class, classes=RepositoryConfig.class)
@ContextConfiguration(locations="classpath:META-INF/jpa.spring.xml")
@TransactionConfiguration
public class CustomerSelectTest extends AbstractTransactionalTestNGSpringContextTests
{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerSelectTest.class);
    @Autowired
    private CustomerRepository target;
    
    @Test
    public void findByLastName()
    {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Customer customer = target.findByLastName("lastName");
        stopWatch.stop();
        LOGGER.info("findWithLastName duration:{}", stopWatch.toString());
        LOGGER.info("findWithLastName result:{}", customer.toString());
    }

}
