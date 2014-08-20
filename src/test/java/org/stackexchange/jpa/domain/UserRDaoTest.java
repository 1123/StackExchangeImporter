package org.stackexchange.jpa.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.stackexchange.querying.dao.CommentRDao;

import javax.inject.Inject;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { QueryContext.class })
public class UserRDaoTest {

    @Inject
    private transient CommentRDao userRDao;

    @Test
    public void test() {
    }

}
