package org.stackexchange.dumps.importer.contexts;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

public class H2InMemoryImpoterContext extends AbstractImporterContext {

    @Bean(destroyMethod = "shutdown")
    public EmbeddedDatabase h2DataSource() {
        return new EmbeddedDatabaseBuilder().
                setType(EmbeddedDatabaseType.H2).
                build();
    }

    @Override
    @Bean
    LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean result = super.templateEntityManagerFactoryBean();
        result.setDataSource(this.h2DataSource());
        return result;
    }

    @Bean
    @Override
    JpaTransactionManager transactionManager() {
        JpaTransactionManager result = new JpaTransactionManager();
        result.setDataSource(this.h2DataSource());
        result.setEntityManagerFactory(this.localContainerEntityManagerFactoryBean().getObject());
        return result;
    }
}
