package org.stackexchange.dumps.importer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.stackexchange.dumps.importer.domain.*;

import javax.persistence.EntityManagerFactory;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

/**
 * This class can be used to start the importer from the command line, without any Java/Spring knowledge.
 */
public class Main {

    public static void main(String [] args) throws FileNotFoundException, JAXBException, ClassNotFoundException {
        if (args.length != 2)
            throw new RuntimeException("Exactly two arguments expected!");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ImporterContext.class);
        GenericImporter importer = context.getBean(GenericImporter.class);
        Class clazz = Class.forName("org.stackexchange.dumps.importer.domain." + args[0]);
        importer.importFile(Long.MAX_VALUE, args[1], clazz);
    }
}
