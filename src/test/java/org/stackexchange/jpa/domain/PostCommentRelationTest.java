package org.stackexchange.jpa.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.stackexchange.querying.CommentR;
import org.stackexchange.querying.PostR;
import org.stackexchange.querying.UserR;
import org.stackexchange.querying.dao.CommentRDao;
import org.stackexchange.querying.dao.PostRDao;
import org.stackexchange.querying.dao.UserRDao;

import javax.inject.Inject;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { QueryContext.class })
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
    public void testComment() {
        CommentR comment = commentDao.find(8);
        assertNotNull(comment);
        assertNotNull(comment.getPost());
        assertNotNull(comment.getUser());
    }

    /**
     * Test that when retrieving posts, the corresponding comments and the user are also retrieved.
     */

    @Test
    public void testPost() {
        PostR c = postDao.find(16);
        assertNotNull(c);
        assertFalse(c.getComments().isEmpty());
        assertNotNull(c.getUser());
    }

    /**
     * Test that the relations from Users to Posts and Comments are retrieved.
     */

    @Test
    public void testUser() {
        UserR user = userDao.find(7);
        assertFalse(user.getComments().isEmpty());
        assertFalse(user.getPosts().isEmpty());
        assertFalse(user.getBadges().isEmpty());
    }

}
