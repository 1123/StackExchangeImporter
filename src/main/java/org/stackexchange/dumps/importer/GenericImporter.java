package org.stackexchange.dumps.importer;

import org.stackexchange.dumps.importer.posts.Post;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public class GenericImporter {

    public static void main(String [] args) throws FileNotFoundException, JAXBException {
        importFile(Long.parseLong(args[0]), args[1], Post.class);
    }

    public static <T> void importFile(final long number, String file, Class<T> t) throws FileNotFoundException, JAXBException {
        GenericReader<T> genericReader = new GenericReader<T>(file, t);
        GenericWriter<T> genericWriter = new GenericWriter<T>();
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
