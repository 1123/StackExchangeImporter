package org.stackexchange.dumps.importer.posts;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class PostUnmarshaller {

    Unmarshaller unmarshaller;

    public PostUnmarshaller() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Post.class);
        unmarshaller = context.createUnmarshaller();
    }

    public Post unmarshal(String line) {
        try {
            Post post = (Post) unmarshaller.unmarshal(new StringReader(line));
            return post;
        } catch (JAXBException e) {
            System.err.println("could not parse line: " + line);
        }
        return null;
    }

}
