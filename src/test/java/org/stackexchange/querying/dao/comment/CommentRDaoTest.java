package org.stackexchange.querying.dao.comment;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.stackexchange.querying.UserR;
import org.stackexchange.querying.CommentR;
import org.stackexchange.querying.dao.CommentRDao;
import org.stackexchange.querying.dao.PostRDao;
import org.stackexchange.querying.dao.UserRDao;

import javax.inject.Inject;
import javax.transaction.Transactional;

import static org.junit.Assert.*;

/**
 * This class tests the orm mapping of comments, posts and users.
 *
 * This test does not need any setup besides the contents of the before method.
 */

@RunWith(SpringJUnit4ClassRunner.class)
public abstract class CommentRDaoTest {

    @Inject
    private transient CommentRDao commentDao;

    @Inject
    private transient PostRDao postDao;

    @Inject
    private transient UserRDao userDao;

    @Inject
    private transient TestDataService testDataService;

    @Before
    public void before() {
        this.testDataService.insertTestData();
    }

    @Test
    @Transactional
    public void testComment() {
        CommentR foundComment = this.commentDao.find(TestDataService.COMMENT_ID);
        assertNotNull(foundComment);
        assertNotNull(foundComment.getUser());
        assertSame(foundComment.getUser().id, TestDataService.USER_ID);
        UserR foundUser = this.userDao.find(TestDataService.USER_ID);
        assertNotNull(foundUser);
        assertNotNull(foundUser.getComments());
        assertSame(foundUser.getComments().size(), 1);
        assertTrue(foundUser.getComments().get(0).id == TestDataService.COMMENT_ID);
    }

}
