package org.stackexchange.dumps.importer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.stackexchange.dumps.importer.domain.*;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class ImporterTest {

    @Inject
    GenericImporter importer;

    @Test
    public void testPosts() throws FileNotFoundException, JAXBException {
        this.importer.importFile(Files.POSTS_FILE, Post.class);
    }

    @Test
    public void testBadges() throws FileNotFoundException, JAXBException {
        this.importer.importFile(Files.BADGES_FILE, Badge.class);
    }

    @Test
    public void testComments() throws FileNotFoundException, JAXBException {
        this.importer.importFile(Files.COMMENTS_FILE, Comment.class);
    }

    @Test
    public void testUsers() throws FileNotFoundException, JAXBException {
        this.importer.importFile(Files.USERS_FILE, SeUser.class);
    }

    @Test
    public void testVotes() throws FileNotFoundException, JAXBException {
        this.importer.importFile(Files.VOTES_FILE, Vote.class);
    }

    @Test
    public void testPostHistory() throws FileNotFoundException, JAXBException {
        this.importer.importFile(Files.POST_HISTORY_FILE, PostHistory.class);
    }

    @Test
    public void testTags() throws FileNotFoundException, JAXBException {
        this.importer.importFile(Files.TAG_FILE, Tag.class);
    }

    @Test
    public void testPostLinks() throws FileNotFoundException, JAXBException {
        this.importer.importFile(Files.POST_LINKS_FILE, PostLink.class);
    }

    @Test
    public void testDirectory() throws FileNotFoundException, JAXBException {
        this.importer.importDirectory(Files.DIRECTORY);
    }


}
