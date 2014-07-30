package org.stackexchange.dumps.importer;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.ImprovedNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.stackexchange.dumps.importer.domain.*;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("org.stackexchange")
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
    LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean result = new LocalSessionFactoryBean();
        // you may swith between Postgres, H2 Datasources by commenting out one of the following lines:
        result.setDataSource(this.h2DataSource());
        // result.setDataSource(this.postgresDataSource());
        result.setMappingLocations();
        result.setAnnotatedClasses(Post.class, Comment.class, SeUser.class, Vote.class, Badge.class, PostHistory.class, Tag.class);
        Properties hibernateProperties = new Properties();
        // TODO: the dialect should be dependent on the selected datasource. PostgresDialect seems to work with H2 currently,
        // but this may cause trouble in the future.
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL82Dialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        hibernateProperties.setProperty("hibernate.generate_statistics", "true");
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create");
        result.setHibernateProperties(hibernateProperties);
        result.setNamingStrategy(new ImprovedNamingStrategy());
        return result;
    }

}
