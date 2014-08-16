package org.stackexchange.dumps.importer;

import org.junit.Test;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.stackexchange.dumps.importer.domain.Post;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestWithoutSpring {

    @Test
    public void test() throws IOException, JAXBException {
        GenericImporterImpl importer = new GenericImporterImpl();
        importer.setEntityManager(new TestConfig().entityManagerFactoryBean().getObject().createEntityManager());
        importer.importFile(Files.POSTS_FILE, Post.class);
    }

}
