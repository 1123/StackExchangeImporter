package org.stackexchange.dumps.importer;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("org.stackexchange.querying")
public class QueryContext {

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

    @Bean
    LocalContainerEntityManagerFactoryBean queryEntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean result = new LocalContainerEntityManagerFactoryBean();
        // result.setDataSource(this.h2DataSource());
        result.setDataSource(this.postgresDataSource());
        result.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
        Properties props = new Properties();
        props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL82Dialect");
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.generate_statistics", "true");
        props.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
        result.setJpaProperties(props);
        result.setPackagesToScan("org.stackexchange.querying");
        result.setPersistenceUnitName("stackexchangeQuerying");
        result.setPersistenceProvider(new HibernatePersistenceProvider());
        return result;
    }

    @Bean
    DataSource postgresDataSource() {
        BasicDataSource result = new BasicDataSource();
        result.setUsername("linse");
        result.setUrl("jdbc:postgresql://localhost:5432/query_test");
        result.setPassword("");
        result.setMaxActive(100);
        result.setMaxIdle(30);
        result.setMinIdle(0);
        result.setMaxWait(16000);
        result.setDriverClassName("org.postgresql.Driver");
        return result;
    }

    @Bean
    JpaTransactionManager transactionManager() {
        JpaTransactionManager result = new JpaTransactionManager();
        result.setDataSource(this.postgresDataSource());
        result.setEntityManagerFactory(this.queryEntityManagerFactoryBean().getObject());
        return result;
    }

    @Value("classpath:initdb.sql")
    private Resource schemaScript;

    @Bean
    public DataSourceInitializer dataSourceInitializer(final DataSource dataSource) {
        final DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource);
        initializer.setDatabasePopulator(databasePopulator());
        return initializer;
    }

    private DatabasePopulator databasePopulator() {
        final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(schemaScript);
        return populator;
    }

}
