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
import org.stackexchange.querying.dao.CommentRDao;
import org.stackexchange.querying.dao.PostRDao;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Arrays;

import static org.junit.Assert.assertSame;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { QueryContext.class })
public class JpaTransactionTest {

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
        comment.id = 1;
        PostR post = new PostR();
        post.id = 2;
        post.setComments(Arrays.asList(comment));
        comment.setPost(post);
        return new ImmutablePair<CommentR, PostR>(comment, post);
    }

    /**
     * Create a comment and a post, link them to each other, then store both.
     * Test the count functionality of the CommentDao.
     *
     * Create a copy of the stored comment with a new Id. Test the count functionality again.
     *
     */
    @Test
    @Transactional
    public void testComment() {
        assertSame(0L, commentDao.countComments());
        Pair<CommentR, PostR> pair = this.sampleCommentAndPost();
        this.postDao.store(pair.getRight());
        this.commentDao.store(pair.getLeft());
        assertSame(1L, commentDao.countComments());
        this.commentDao.createCopy(1,2);
        assertSame(2L, commentDao.countComments());
    }

}
