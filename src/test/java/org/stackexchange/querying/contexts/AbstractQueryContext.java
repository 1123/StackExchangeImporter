package org.stackexchange.querying.contexts;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

/**
 * The entities for querying are different from the entities for importing.
 * When importing, we do not care about the relations.
 * When querying, relations between entities are important.
 *
 * EntityManagers obviously allow only one type of entity for the same table.
 * Thus we need different entityManagers and entityManagerFactories for
 * querying and importing. This Context is used for querying.
 *
 * @return An entityManagerFactory that generates entityManagers that associate
 * the query entities supporting relations/foreign keys with the tables in the database.
 */

@Configuration
@ComponentScan("org.stackexchange.querying")
@EnableTransactionManagement // not sure if this is necessary.
public abstract class AbstractQueryContext {

    protected LocalContainerEntityManagerFactoryBean templateEntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean result = new LocalContainerEntityManagerFactoryBean();
        result.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
        Properties props = new Properties();
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.hbm2ddl.auto", "validate");
        props.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
        result.setJpaProperties(props);
        result.setPackagesToScan("org.stackexchange.querying");
        result.setPersistenceProvider(new HibernatePersistenceProvider());
        return result;
    }

    public abstract LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean();

    public abstract JpaTransactionManager transactionManager();

}
