package org.stackexchange.querying.contexts.clean;

import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.stackexchange.querying.contexts.prefilled.H2InMemoryQueryContext;
import org.stackexchange.querying.contexts.prefilled.PostgresQueryContext;

public class H2InMemoryEmptyQueryContext extends H2InMemoryQueryContext {

    /**
     * The EntityManagerFactoryBean is the same as the one of the PostgresQueryContext
     * only that the schema is dropped at the beginning.
     *
     * @return a Factory for the entityManager.
     */

    @Override
    @Bean
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean result = super.localContainerEntityManagerFactoryBean();
        result.getJpaPropertyMap().put("hibernate.hbm2ddl.auto", "create-drop");
        result.setDataSource(this.h2InMemoryDataSource());
        return result;
    }

    @Override
    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager result = new JpaTransactionManager();
        result.setDataSource(this.h2InMemoryDataSource());
        result.setEntityManagerFactory(this.localContainerEntityManagerFactoryBean().getObject());
        return result;
    }

}
