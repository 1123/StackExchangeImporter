package org.stackexchange.dumps.importer.posts;

import org.junit.Test;
import org.stackexchange.dumps.importer.GenericUnmarshaller;
import org.stackexchange.dumps.importer.GenericWriter;

import javax.xml.bind.JAXBException;import java.lang.String;

public class PostWriterTest {

    @Test
    public void test() throws JAXBException {
        GenericWriter<Post> postWriter = new GenericWriter<Post>();
        String line = "<row Id=\"13\" PostId=\"23\" Text=\"Using /opt helps me keep track of the applications I've installed myself.\" CreationDate=\"2010-07-28T19:36:59.773\" UserId=\"10\" />";
        Post post = new GenericUnmarshaller<Post>(Post.class).unmarshal(line);
        postWriter.open();
        postWriter.write(post);
        postWriter.close();
    }

}
