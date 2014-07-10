package org.stackexchange.dumps.importer.importing;

import org.junit.Test;
import org.stackexchange.dumps.importer.GenericImporter;
import org.stackexchange.dumps.importer.domain.Comment;
import org.stackexchange.dumps.importer.domain.SeUser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public class CommentImporterTest {

    private static final String COMMENTS_FILE = "src/test/resources/Comments.xml";

    @Test
    public void test() throws FileNotFoundException, JAXBException {
        GenericImporter.importFile(100l, COMMENTS_FILE, Comment.class);
    }

}
