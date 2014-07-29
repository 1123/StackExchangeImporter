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

    @Inject
    Importer importer;

    @Test
    public void testPosts() throws FileNotFoundException, JAXBException {
        this.importer.importPosts(Files.POSTS_FILE);
    }

    @Test
    public void testBadges() throws FileNotFoundException, JAXBException, FileNotFoundException {
        this.importer.importBadges(Files.BADGES_FILE);
    }

    @Test
    public void testComments() throws FileNotFoundException, JAXBException {
        this.importer.importComments(Files.COMMENTS_FILE);
    }

    @Test
    public void testUsers() throws FileNotFoundException, JAXBException {
        this.importer.importUsers(Files.USERS_FILE);
    }

    @Test
    public void testVotes() throws FileNotFoundException, JAXBException {
        this.importer.importVotes(Files.VOTES_FILE);
    }

    @Test
    public void testPostHistory() throws FileNotFoundException, JAXBException {
        this.importer.importPostHistory(Files.POST_HISTORY_FILE);
    }

}
