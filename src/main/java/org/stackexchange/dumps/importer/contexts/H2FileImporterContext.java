package org.stackexchange.dumps.importer.contexts;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

public class H2FileImporterContext extends AbstractImporterContext {

    @Bean
    public DataSource h2FileDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:file:/tmp/h2/db");
        return dataSource;
    }

    @Bean
    @Override
    LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean result = super.templateEntityManagerFactoryBean();
        result.getJpaPropertyMap().put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        result.setDataSource(this.h2FileDataSource());
        return result;
    }

    @Bean
    @Override
    JpaTransactionManager transactionManager() {
        JpaTransactionManager result = new JpaTransactionManager();
        result.setDataSource(this.h2FileDataSource());
        result.setEntityManagerFactory(this.localContainerEntityManagerFactoryBean().getObject());
        return result;
    }

}
