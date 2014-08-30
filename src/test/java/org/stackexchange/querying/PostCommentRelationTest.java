package org.stackexchange.querying;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.stackexchange.querying.contexts.prefilled.H2FileQueryContext;
import org.stackexchange.querying.contexts.prefilled.PostgresQueryContext;
import org.stackexchange.querying.dao.CommentRDao;
import org.stackexchange.querying.dao.PostRDao;
import org.stackexchange.querying.dao.UserRDao;

import javax.inject.Inject;
import javax.transaction.Transactional;

import static org.junit.Assert.*;

/**
 * This is an integration test. It is part fo the {@link QueryIntegrationTestSuite}.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PostgresQueryContext.class })
@Ignore // Setting this test to Ignore, since it is already run by the test suite.
public class PostCommentRelationTest {

    @Inject
    private transient CommentRDao commentDao;

    @Inject
    private transient PostRDao postDao;

    @Inject
    private transient UserRDao userDao;

    /**
     * Test that when retrieving comments, the corresponding post and user is also retrieved.
     */

    @Test
    @Transactional
    public void testComment() {
        CommentR comment = commentDao.find(8);
        assertNotNull(comment);
        assertNotNull(comment.getPost());
        assertNotNull(comment.getUser());
        assertTrue(comment.getPost().getBody().contains("opinion-based"));
        assertSame(comment.getUser().getBadges().get(0).id, 8);
    }

    /**
     * Test that when retrieving posts, the corresponding comments and the user are also retrieved.
     */

    @Test
    public void testPost() {
        PostR c = postDao.find(15);
        assertNotNull(c);
        assertFalse(c.getComments().isEmpty());
        assertNotNull(c.getUser());
    }

    /**
     * Test that the relations from Users to Posts and Comments are retrieved.
     */

    @Test
    @Transactional
    public void testUser() {
        UserR user = userDao.find(7);
        assertFalse(user.getComments().isEmpty());
        assertFalse(user.getPosts().isEmpty());
        assertFalse(user.getBadges().isEmpty());
    }

}
