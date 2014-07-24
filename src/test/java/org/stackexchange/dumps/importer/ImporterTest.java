package org.stackexchange.dumps.importer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class ImporterTest {
    private static final String POSTS_FILE = "src/test/resources/Posts.xml";

    @Inject
    Importer importer;

    @Test
    public void testPosts() throws FileNotFoundException, JAXBException {
        this.importer.importPosts(POSTS_FILE);
    }

    private static final String BADGES_FILE = "src/test/resources/Badges.xml";

    @Test
    public void testBadges() throws FileNotFoundException, JAXBException, FileNotFoundException {
        this.importer.importBadges(BADGES_FILE);
    }

    private static final String COMMENTS_FILE = "src/test/resources/Comments.xml";

    @Test
    public void testComments() throws FileNotFoundException, JAXBException {
        this.importer.importComments(COMMENTS_FILE);
    }


    private static final String USERS_FILE = "src/test/resources/Users.xml";

    @Test
    public void testUsers() throws FileNotFoundException, JAXBException {
        this.importer.importUsers(USERS_FILE);
    }

    private static final String VOTES_FILE = "src/test/resources/Votes.xml";

    @Test
    public void testVotes() throws FileNotFoundException, JAXBException {
        this.importer.importVotes(VOTES_FILE);
    }

}
