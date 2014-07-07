package org.stackexchange.dumps.importer.posts;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public class PostImporter {

    private static final String POSTS_FILE = "src/test/resources/Posts.xml";

    public static void main(String [] args) throws FileNotFoundException, JAXBException {
        importPosts(Long.MAX_VALUE);
    }

    public static void importPosts(final long number) throws FileNotFoundException, JAXBException {
        PostReader postReader = new PostReader(POSTS_FILE);
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
