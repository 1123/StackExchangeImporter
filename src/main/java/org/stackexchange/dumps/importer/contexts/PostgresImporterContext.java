package org.stackexchange.dumps.importer.contexts;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

public class PostgresImporterContext extends AbstractImporterContext {

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

    @Override
    @Bean
    LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean result = super.templateEntityManagerFactoryBean();
        result.setDataSource(this.postgresDataSource());
        return result;
    }

    @Bean
    @Override
    JpaTransactionManager transactionManager() {
        JpaTransactionManager result = new JpaTransactionManager();
        result.setDataSource(this.postgresDataSource());
        result.setEntityManagerFactory(this.localContainerEntityManagerFactoryBean().getObject());
        return result;
    }

}
