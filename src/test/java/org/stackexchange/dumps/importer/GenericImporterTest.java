package org.stackexchange.dumps.importer;

import org.junit.Test;
import org.stackexchange.dumps.importer.domain.*;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public class GenericImporterTest {
    private static final String POSTS_FILE = "src/test/resources/Posts.xml";

    @Test
    public void testPosts() throws FileNotFoundException, JAXBException {
        GenericImporter.importFile(100l, POSTS_FILE, Post.class);
    }

    private static final String BADGES_FILE = "src/test/resources/Badges.xml";

    @Test
    public void testBadges() throws FileNotFoundException, JAXBException {
        GenericImporter.importFile(100l, BADGES_FILE, Badge.class);
    }


    private static final String COMMENTS_FILE = "src/test/resources/Comments.xml";

    @Test
    public void testComments() throws FileNotFoundException, JAXBException {
        GenericImporter.importFile(100l, COMMENTS_FILE, Comment.class);
    }


    private static final String USERS_FILE = "src/test/resources/Users.xml";

    @Test
    public void testUsers() throws FileNotFoundException, JAXBException {
        GenericImporter.importFile(100l, USERS_FILE, SeUser.class);
    }

    private static final String VOTES_FILE = "src/test/resources/Votes.xml";

    @Test
    public void testVotes() throws FileNotFoundException, JAXBException {
        GenericImporter.importFile(100l, VOTES_FILE, Vote.class);
    }

}
