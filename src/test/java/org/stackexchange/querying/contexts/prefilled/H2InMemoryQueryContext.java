package org.stackexchange.querying.contexts.prefilled;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.stackexchange.querying.contexts.AbstractQueryContext;

import javax.sql.DataSource;

public class H2InMemoryQueryContext extends AbstractQueryContext {

    @Bean
    public DataSource h2InMemoryDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:test");
        return dataSource;
    }

    @Bean
    @Override
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager result = new JpaTransactionManager();
        result.setDataSource(this.h2InMemoryDataSource());
        result.setEntityManagerFactory(this.localContainerEntityManagerFactoryBean().getObject());
        return result;
    }

    @Bean
    @Override
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean result = super.templateEntityManagerFactoryBean();
        result.getJpaPropertyMap().put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        result.setDataSource(this.h2InMemoryDataSource());
        return result;
    }
}
