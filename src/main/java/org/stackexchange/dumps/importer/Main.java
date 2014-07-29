package org.stackexchange.dumps.importer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

/**
 * This class can be used to start the importer from the command line, without any Java/Spring knowledge.
 */
public class Main {

    public static void main(String [] args) throws FileNotFoundException, JAXBException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ImporterContext.class);
        Importer importer = (Importer) context.getBean("importer");
        importer.importPosts("src/test/resources/Posts.xml");
    }
}
