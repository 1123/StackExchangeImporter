package org.stackexchange.jpa.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.stackexchange.dumps.importer.QueryContext;
import org.stackexchange.querying.CommentR;
import org.stackexchange.querying.PostR;
import org.stackexchange.querying.dao.CommentRDao;
import org.stackexchange.querying.dao.PostRDao;

import javax.inject.Inject;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

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
