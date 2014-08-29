package org.stackexchange.dumps.importer.contexts;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.stackexchange.dumps.importer.domain.Post;

/**
 * This class serves for switching contexts for testing and importing by exchanging the superclass.
 *
 * The following contexts are available for importing into a local postgres database, a H2 file-based database or a h2 in memory database.
 *
 * {@link org.stackexchange.dumps.importer.contexts.PostgresImporterContext}
 * {@link org.stackexchange.dumps.importer.contexts.H2FileImporterContext}
 * {@link org.stackexchange.dumps.importer.contexts.H2InMemoryImpoterContext}
 *
 */

@ComponentScan("org.stackexchange.dumps.importer.services")
@Configuration
@EnableTransactionManagement
public class ImporterContext extends PostgresImporterContext {

}
