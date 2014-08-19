package org.stackexchange.jpa.domain;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.stackexchange.dumps.importer.QueryContext;
import org.stackexchange.dumps.importer.TestConfig;
import org.stackexchange.querying.CommentR;
import org.stackexchange.querying.PostR;
import org.stackexchange.querying.UserR;
import org.stackexchange.querying.dao.CommentRDao;
import org.stackexchange.querying.dao.PostRDao;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { QueryContext.class })
public class CommentRDaoTest {

    @Inject
    private transient CommentRDao commentDao;

    @Inject
    private transient PostRDao postDao;

    /**
     * Create the sample data. Since the two objects mutually depend on each other, they cannot be created independently.
     *
     * @return the sample data.
     */

    private Pair<CommentR, PostR> sampleCommentAndPost() {
        CommentR comment = new CommentR();
        comment.id = 1111111111;
        PostR post = new PostR();
        post.id = 222222222;
        post.setComments(Arrays.asList(comment));
        comment.setPost(post);
        return new ImmutablePair<CommentR, PostR>(comment, post);
    }

    /**
     * 1) Create a comment and a post.
     * 2) Link them to each other.
     * 3) Create a user and link it to the comment.
     * 4) Store both post and comment.
     * 2) Test the count functionality of the CommentDao.
     *
     * 3) Create a copy of the stored comment with a new Id.
     * 4) Test the count functionality again.
     *
     */
    @Test
    @Transactional
    public void testComment() {
        long countBefore = commentDao.countComments();
        Pair<CommentR, PostR> pair = this.sampleCommentAndPost();
        pair.getLeft().setUser(new UserR(5));
        this.postDao.store(pair.getRight());
        this.commentDao.store(pair.getLeft());
        assertEquals(countBefore + 1L, commentDao.countComments());
        this.commentDao.createCopy(1,2);
        assertEquals(countBefore + 2L, commentDao.countComments());
    }

}
