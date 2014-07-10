package org.stackexchange.dumps.importer.importing;

import org.junit.Test;
import org.stackexchange.dumps.importer.GenericImporter;
import org.stackexchange.dumps.importer.domain.Post;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

/**
 * Created with IntelliJ IDEA.
 * User: linse
 * Date: 7/7/14
 * Time: 14:40
 * To change this template use File | Settings | File Templates.
 */
public class PostImporterTest {

    private static final String POSTS_FILE = "src/test/resources/Posts.xml";

    @Test
    public void test() throws FileNotFoundException, JAXBException {
        GenericImporter.importFile(100l, POSTS_FILE, Post.class);
    }
}
