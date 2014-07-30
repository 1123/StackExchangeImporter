package org.stackexchange.dumps.importer.io;

import com.google.gson.Gson;
import org.junit.Test;
import org.stackexchange.dumps.importer.Files;
import org.stackexchange.dumps.importer.GenericReader;
import org.stackexchange.dumps.importer.domain.Post;

import javax.xml.bind.JAXBException;
import java.io.IOException;import java.lang.System;

public class PostReaderTest {

    @Test
    public void test() throws JAXBException, IOException {
        GenericReader<Post> postReader = new GenericReader<Post>(Files.POSTS_FILE, Post.class);
        while (postReader.hasNext()) {
            Post post = postReader.next();
        }
        postReader.close();
    }

}
