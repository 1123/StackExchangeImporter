package org.stackexchange.dumps.importer.users;

import org.junit.Test;
import org.stackexchange.dumps.importer.GenericImporter;
import org.stackexchange.dumps.importer.GenericUnmarshaller;
import org.stackexchange.dumps.importer.posts.Post;

import javax.xml.bind.JAXBException;

import java.io.FileNotFoundException;

import static junit.framework.Assert.assertEquals;

public class UserImporterTest {

    private static final String USERS_FILE = "src/test/resources/Users.xml";

    @Test
    public void test() throws FileNotFoundException, JAXBException {
        GenericImporter.importFile(100l, USERS_FILE, SeUser.class);
    }

}
