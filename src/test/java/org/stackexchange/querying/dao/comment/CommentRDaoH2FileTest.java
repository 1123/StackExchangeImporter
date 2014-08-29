package org.stackexchange.querying.dao.comment;

import org.springframework.test.context.ContextConfiguration;
import org.stackexchange.querying.contexts.clean.H2FileEmptyDBQueryContext;

@ContextConfiguration(classes = { H2FileEmptyDBQueryContext.class })
public class CommentRDaoH2FileTest extends CommentRDaoTest {
}
