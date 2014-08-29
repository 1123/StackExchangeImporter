package org.stackexchange.querying.dao.comment;

import org.springframework.stereotype.Component;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.stackexchange.querying.UserR;
import org.stackexchange.querying.CommentR;
import org.stackexchange.querying.PostR;
import org.stackexchange.querying.dao.CommentRDao;
import org.stackexchange.querying.dao.PostRDao;
import org.stackexchange.querying.dao.UserRDao;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Arrays;

@Component
@TransactionConfiguration(defaultRollback = false)
public class TestDataService {

    public static final int POST_ID = 222222222;
    public static final int COMMENT_ID = 1111111111;
    public static final int USER_ID = 5;

    @Inject
    private transient CommentRDao commentDao;

    @Inject
    private transient PostRDao postDao;

    @Inject
    private transient UserRDao userDao;

    @Transactional
    public void insertTestData() {
        CommentR comment = new CommentR();
        comment.id = COMMENT_ID;
        PostR post = new PostR();
        post.id = POST_ID;
        post.setComments(Arrays.asList(comment));
        comment.setPost(post);
        UserR user = new UserR(USER_ID);
        comment.setUser(user);
        user.setComments(Arrays.asList(comment));
        this.userDao.store(user);
        this.postDao.store(post);
        this.commentDao.store(comment);
    }

}
