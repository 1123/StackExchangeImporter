package org.stackexchange.querying.contexts.clean;

import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.stackexchange.querying.contexts.prefilled.PostgresQueryContext;

public class PostgresEmptyDbQueryContext extends PostgresQueryContext {

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
        result.setDataSource(this.postgresDataSource());
        return result;
    }

    @Override
    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager result = new JpaTransactionManager();
        result.setDataSource(this.postgresDataSource());
        result.setEntityManagerFactory(this.localContainerEntityManagerFactoryBean().getObject());
        return result;
    }

}
