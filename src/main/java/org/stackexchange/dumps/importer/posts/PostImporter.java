package org.stackexchange.dumps.importer.posts;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public class PostImporter {


    public static void main(String [] args) throws FileNotFoundException, JAXBException {
        importPosts(Long.parseLong(args[0]), args[1]);
    }

    public static void importPosts(final long number, String file) throws FileNotFoundException, JAXBException {
        PostReader postReader = new PostReader(file);
        PostWriter postWriter = new PostWriter();
        postWriter.open();
        int count = 0;
        while (postReader.hasNext() && count < number) {
            postWriter.write(postReader.next());
            count++;
        }
        postWriter.close();
        postReader.close();
    }

}
