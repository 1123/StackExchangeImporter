package org.stackexchange.jpa.domain;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.stackexchange.dumps.importer.GenericImporter;
import org.stackexchange.dumps.importer.QueryContext;
import org.stackexchange.querying.CommentR;
import org.stackexchange.querying.PostR;
import org.stackexchange.querying.dao.CommentRDao;
import org.stackexchange.querying.dao.PostRDao;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { QueryContext.class })
public class PostCommentRelationTest {

    @Inject
    private transient GenericImporter importer;

    @Inject
    private transient CommentRDao commentDao;

    @Inject
    private transient PostRDao postDao;

    @Test
    @Transactional
    public void testComment() throws FileNotFoundException, JAXBException {
        CommentR comment = commentDao.find(8);
        assertNotNull(comment);
        assertNotNull(comment.getPost());
    }

    public void testPost() {
        PostR c = postDao.find(3);
        assertNotNull(c);
        assertFalse(c.getComments().isEmpty());
    }

}
