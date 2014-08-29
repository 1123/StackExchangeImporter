package org.stackexchange.querying.dao.comment;

import org.junit.Ignore;
import org.springframework.test.context.ContextConfiguration;
import org.stackexchange.querying.contexts.clean.H2InMemoryEmptyQueryContext;

@ContextConfiguration(classes = { H2InMemoryEmptyQueryContext.class })
public class CommentRDaoH2MemoryTest extends CommentRDaoTest {
}
