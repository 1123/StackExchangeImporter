package org.stackexchange.dumps.importer.io;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.stackexchange.dumps.importer.GenericUnmarshaller;
import org.stackexchange.dumps.importer.GenericWriter;
import org.stackexchange.dumps.importer.domain.Post;

import javax.inject.Inject;
import javax.xml.bind.JAXBException;import java.lang.String;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/META-INF/spring/testContext.xml" })
public class PostWriterTest {

    @Inject
    SessionFactory sessionFactory;

    @Test
    public void test() throws JAXBException {
        GenericWriter<Post> postWriter = new GenericWriter<Post>(this.sessionFactory.openSession());
        String line = "<row Id=\"13\" PostId=\"23\" Text=\"Using /opt helps me keep track of the applications I've installed myself.\" CreationDate=\"2010-07-28T19:36:59.773\" UserId=\"10\" />";
        Post post = new GenericUnmarshaller<Post>(Post.class).unmarshal(line);
        postWriter.open();
        postWriter.write(post);
        postWriter.close();
    }

}
