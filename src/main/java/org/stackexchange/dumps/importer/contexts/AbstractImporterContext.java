package org.stackexchange.dumps.importer.contexts;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.ejb.Local;
import javax.sql.DataSource;
import java.util.Properties;

public abstract class AbstractImporterContext {

    abstract LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean();

    LocalContainerEntityManagerFactoryBean templateEntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean result = new LocalContainerEntityManagerFactoryBean();
        result.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
        Properties props = new Properties();
        props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL82Dialect");
        props.put("hibernate.hbm2ddl.auto", "create");
        props.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
        result.setJpaProperties(props);
        result.setPackagesToScan("org.stackexchange.dumps.importer.domain");
        result.setPersistenceProvider(new HibernatePersistenceProvider());
        result.setPersistenceProviderClass(org.hibernate.jpa.HibernatePersistenceProvider.class);
        return result;
    }

    abstract JpaTransactionManager transactionManager();

}
