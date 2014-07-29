package org.stackexchange.dumps.importer;

import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public class MainTest {

    @Test
    public void testPosts() throws FileNotFoundException, JAXBException {
        Main.main(new String[] {"posts", Files.POSTS_FILE });
    }

    @Test(expected = IllegalArgumentException.class)
    public void testImportTrash() throws FileNotFoundException, JAXBException {
        Main.main(new String[] {"trash", "trash_file" });
    }

    @Test
    public void testVotes() throws FileNotFoundException, JAXBException {
        Main.main(new String[] {"votes", Files.VOTES_FILE });
    }

}
