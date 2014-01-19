package demo.jpa.repositories;

import java.sql.SQLException;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Profile("oracle")
@EnableJpaRepositories(basePackages = {"demo.jpa.repositories"})
@EnableTransactionManagement
public class OracleRepositoryConfig
{
    @Bean
    public DataSource dataSource() throws SQLException
    {
        OracleDataSource dataSource = new OracleDataSource();
//        dataSource.setDriverClass(oracle.jdbc.OracleDriver.class);
        dataSource.setURL("jdbc:oracle:thin:@localhost:1521/XE");
        dataSource.setUser("demojpa");
//        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        // dataSource.setDriverClass(org.h2.Driver.class);
        // dataSource.setUrl("jdbc:h2:target/demo;AUTO_SERVER=TRUE");
        dataSource.setPassword("demojpa");
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws SQLException
    {
        EntityManagerFactory factory = entityManagerFactory().getObject();
        return new JpaTransactionManager(factory);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws SQLException
    {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan("demo.jpa.entities");
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(Boolean.TRUE);
        vendorAdapter.setShowSql(Boolean.TRUE);
        // vendorAdapter.setDatabase(Database.H2);
        vendorAdapter.setDatabase(Database.ORACLE);

        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
        return entityManagerFactoryBean;
    }

    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator()
    {
        return new HibernateExceptionTranslator();
    }
}