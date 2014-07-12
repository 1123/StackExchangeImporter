package org.stackexchange.dumps.importer;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.Iterator;
import java.util.function.Consumer;

public class GenericReader <T> implements Iterator<T> {

    BufferedReader bufferedReader;
    private T nextItem;
    GenericUnmarshaller<T> genericUnmarshaller;

    public GenericReader(String path, Class<T> t) throws FileNotFoundException, JAXBException {
        File file = new File(path);
        this.genericUnmarshaller = new GenericUnmarshaller<T>(t);
        this.bufferedReader = new BufferedReader(new FileReader(file));
        this.nextItem = this.nextInternal();
    }

    public void close() {
        try {
            this.bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private T nextInternal() {
        String line;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                T t = this.genericUnmarshaller.unmarshal(line);
                if (t != null) return t;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        return (nextItem != null);
    }

    @Override
    public T next() {
        T result = nextItem;
        this.nextItem = this.nextInternal();
        return result;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void forEachRemaining(Consumer<? super T> action) {
        throw new UnsupportedOperationException();
    }
}

