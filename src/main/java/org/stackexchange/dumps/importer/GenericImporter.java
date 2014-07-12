package org.stackexchange.dumps.importer;

import org.hibernate.Session;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public class GenericImporter {

    public static <T> void importFile(Session session, final long number, String file, Class<T> t)
            throws FileNotFoundException, JAXBException {
        GenericReader<T> genericReader = new GenericReader<T>(file, t);
        GenericWriter<T> genericWriter = new GenericWriter<T>(session);
        genericWriter.open();
        int count = 0;
        while (genericReader.hasNext() && count < number) {
            genericWriter.write(genericReader.next());
            count++;
        }
        genericWriter.close();
        genericReader.close();
    }

}
