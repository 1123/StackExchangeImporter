package org.stackexchange.dumps.importer.posts;

import com.google.gson.Gson;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;import java.lang.System;

public class PostReaderTest {

    @Test
    public void test() throws JAXBException, IOException {
        PostReader postReader = new PostReader(PostReader.POSTS_FILE);
        while (postReader.hasNext()) {
            Post post = postReader.next();
            System.err.println(new Gson().toJson(post));
        }
        postReader.close();
    }

}
