package org.stackexchange.dumps.importer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.Optional;

public class GenericUnmarshaller<T> {

    Unmarshaller unmarshaller;

    public GenericUnmarshaller(Class<T> cls) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(cls);
        unmarshaller = context.createUnmarshaller();
    }

    public Optional<T> unmarshal(String line) {
        try {
            T t = (T) unmarshaller.unmarshal(new StringReader(line));
            return Optional.of(t);
        } catch (JAXBException e) {
            System.err.println("could not parse line: " + line);
        }
        return Optional.empty();
    }

}
