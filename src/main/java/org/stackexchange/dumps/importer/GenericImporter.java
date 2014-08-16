package org.stackexchange.dumps.importer;

import org.springframework.transaction.annotation.Propagation;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

import static org.springframework.transaction.annotation.Propagation.*;

/**
 * Created by linse on 8/12/14.
 */
public interface GenericImporter {
    <T> void importFile(String file, Class<T> t) throws FileNotFoundException, JAXBException;

    void importDirectory(String directory) throws FileNotFoundException, JAXBException;

    <T> void importFile(long number, String file, Class<T> t)
            throws FileNotFoundException, JAXBException;
}
