package org.stackexchange.dumps.importer.io;

import org.junit.Test;
import org.stackexchange.dumps.importer.BeerFiles;
import org.stackexchange.dumps.importer.services.GenericReader;
import org.stackexchange.dumps.importer.domain.Post;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class PostReaderTest {

    @Test
    public void test() throws JAXBException, IOException {
        GenericReader<Post> postReader = new GenericReader<Post>(BeerFiles.POSTS_FILE, Post.class);
        while (postReader.hasNext()) {
            Post post = postReader.next();
        }
        postReader.close();
    }

}
