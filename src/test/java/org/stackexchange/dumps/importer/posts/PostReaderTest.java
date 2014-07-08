package org.stackexchange.dumps.importer.posts;

import com.google.gson.Gson;
import org.junit.Test;
import org.stackexchange.dumps.importer.GenericReader;

import javax.xml.bind.JAXBException;
import java.io.IOException;import java.lang.System;

public class PostReaderTest {

    private static final String POSTS_FILE = "src/test/resources/Posts.xml";

    @Test
    public void test() throws JAXBException, IOException {
        GenericReader<Post> postReader = new GenericReader<Post>(POSTS_FILE, Post.class);
        while (postReader.hasNext()) {
            Post post = postReader.next();
            System.err.println(new Gson().toJson(post));
        }
        postReader.close();
    }

}
