package org.stackexchange.dumps.importer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.stackexchange.dumps.importer.domain.*;
import org.stackexchange.dumps.importer.services.GenericImporter;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestImporterContext.class })
@Transactional
public class ImporterTest {

    @Inject
    GenericImporter importer;

    @Test
    public void testPosts() throws FileNotFoundException, JAXBException {
        this.importer.importFile(BeerFiles.POSTS_FILE, Post.class);
    }

    @Test
    public void testBadges() throws FileNotFoundException, JAXBException {
        this.importer.importFile(BeerFiles.BADGES_FILE, Badge.class);
    }

    @Test
    public void testComments() throws FileNotFoundException, JAXBException {
        this.importer.importFile(BeerFiles.COMMENTS_FILE, Comment.class);
    }

    @Test
    public void testUsers() throws FileNotFoundException, JAXBException {
        this.importer.importFile(BeerFiles.USERS_FILE, SeUser.class);
    }

    @Test
    public void testVotes() throws FileNotFoundException, JAXBException {
        this.importer.importFile(BeerFiles.VOTES_FILE, Vote.class);
    }

    @Test
    public void testPostHistory() throws FileNotFoundException, JAXBException {
        this.importer.importFile(BeerFiles.POST_HISTORY_FILE, PostHistory.class);
    }

    @Test
    public void testTags() throws FileNotFoundException, JAXBException {
        this.importer.importFile(BeerFiles.TAG_FILE, Tag.class);
    }

    @Test
    public void testPostLinks() throws FileNotFoundException, JAXBException {
        this.importer.importFile(BeerFiles.POST_LINKS_FILE, PostLink.class);
    }

    @Test
    public void testDirectory() throws FileNotFoundException, JAXBException {
        this.importer.importDirectory(BeerFiles.DIRECTORY);
    }


}
