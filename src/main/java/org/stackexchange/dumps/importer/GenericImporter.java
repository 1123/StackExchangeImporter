package org.stackexchange.dumps.importer;

import org.hibernate.Session;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public class GenericImporter {

    public static <T> void importFile(Session session, final long number, String file, Class<T> t)
            throws FileNotFoundException, JAXBException {
        GenericReader<T> genericReader = new GenericReader<T>(file, t);
        int count = 0;
        while (genericReader.hasNext() && count < number) {
            session.save(genericReader.next());
            count++;
            if (count % 20 == 0) {
                session.flush();
                session.clear();
            }
            if (count % 1000 == 0) {
                System.err.println("Imported " + count + " entities");
            }
        }
        session.close();
        genericReader.close();
    }

}
