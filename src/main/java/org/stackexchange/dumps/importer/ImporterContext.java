package org.stackexchange.dumps.importer;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("org.stackexchange.dumps.importer")
@EnableTransactionManagement
public class ImporterContext {

    @Bean(destroyMethod = "shutdown")
    public EmbeddedDatabase h2DataSource() {
        return new EmbeddedDatabaseBuilder().
                setType(EmbeddedDatabaseType.H2).
                build();
    }

    @Bean
    DataSource postgresDataSource() {
        BasicDataSource result = new BasicDataSource();
        result.setUsername("linse");
        result.setUrl("jdbc:postgresql://localhost:5432/test");
        result.setPassword("");
        result.setMaxActive(100);
        result.setMaxIdle(30);
        result.setMinIdle(0);
        result.setMaxWait(16000);
        result.setDriverClassName("org.postgresql.Driver");
        return result;
    }

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean result = new LocalContainerEntityManagerFactoryBean();
        // result.setDataSource(this.h2DataSource());
        result.setDataSource(this.postgresDataSource());
        result.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
        Properties props = new Properties();
        props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL82Dialect");
        props.put("hibernate.hbm2ddl.auto", "create");
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.generate_statistics", "true");
        props.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
        result.setJpaProperties(props);
        result.setPackagesToScan("org.stackexchange.dumps.importer.domain");
        result.setPersistenceUnitName("stackexchange");
        result.setPersistenceProvider(new HibernatePersistenceProvider());
        result.setPersistenceProviderClass(org.hibernate.jpa.HibernatePersistenceProvider.class);
        return result;
    }

    @Bean
    JpaTransactionManager transactionManager() {
        JpaTransactionManager result = new JpaTransactionManager();
        result.setDataSource(this.h2DataSource());
        result.setEntityManagerFactory(this.entityManagerFactoryBean().getObject());
        return result;
    }
}
