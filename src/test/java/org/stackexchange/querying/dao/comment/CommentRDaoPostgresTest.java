package org.stackexchange.querying.dao.comment;

import org.springframework.test.context.ContextConfiguration;
import org.stackexchange.querying.contexts.clean.PostgresEmptyDbQueryContext;

@ContextConfiguration(classes = { PostgresEmptyDbQueryContext.class })
public class CommentRDaoPostgresTest extends CommentRDaoTest {
}
