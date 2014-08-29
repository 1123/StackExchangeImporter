package org.stackexchange.dumps.importer;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.stackexchange.dumps.importer.contexts.ImporterContext;

@Configuration
@ComponentScan("org.stackexchange.dumps.importer")
public class TestImporterContext extends ImporterContext {

}
