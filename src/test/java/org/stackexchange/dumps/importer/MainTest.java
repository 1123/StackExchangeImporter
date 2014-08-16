package org.stackexchange.dumps.importer;

import org.junit.Test;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public class MainTest {

    @Test
    public void testPosts() throws FileNotFoundException, JAXBException, ClassNotFoundException {
        Main.main(new String[] {"Post", Files.POSTS_FILE });
    }

    @Test(expected = ClassNotFoundException.class)
    public void testImportTrash() throws FileNotFoundException, JAXBException, ClassNotFoundException {
        Main.main(new String[] {"Trash", "Trash_file" });
    }

    @Test
    public void testVotes() throws FileNotFoundException, JAXBException, ClassNotFoundException {
        Main.main(new String[] {"Vote", Files.VOTES_FILE });
    }

}
