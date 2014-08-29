package org.stackexchange.querying.contexts.clean;

import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.stackexchange.querying.contexts.prefilled.H2FileQueryContext;

public class H2FileEmptyDBQueryContext extends H2FileQueryContext {

    @Bean
    @Override
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean result = super.localContainerEntityManagerFactoryBean();
        result.getJpaPropertyMap().put("hibernate.hbm2ddl.auto", "create-drop");
        result.setDataSource(this.h2FileDataSource());
        return result;
    }

    @Bean
    @Override
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager result = new JpaTransactionManager();
        result.setDataSource(this.h2FileDataSource());
        result.setEntityManagerFactory(this.localContainerEntityManagerFactoryBean().getObject());
        return result;
    }


}
