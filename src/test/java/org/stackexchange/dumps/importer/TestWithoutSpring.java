package org.stackexchange.dumps.importer;

import org.junit.Test;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestWithoutSpring {

    private static final String POSTS_FILE = "src/test/resources/Posts.xml";

    @Test
    public void test() throws IOException, JAXBException {
        LocalSessionFactoryBean factory = new TestConfig().sessionFactory();
        factory.afterPropertiesSet();
        Importer importer = new ImporterImpl();
        importer.setSessionFactory(factory.getObject());
        importer.importPosts(POSTS_FILE);
    }

}
