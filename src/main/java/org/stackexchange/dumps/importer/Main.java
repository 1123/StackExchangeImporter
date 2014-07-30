package org.stackexchange.dumps.importer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

/**
 * This class can be used to start the importer from the command line, without any Java/Spring knowledge.
 */
public class Main {

    private enum FILE { posts, comments, users, votes, badges, post_history, tags, post_links }

    public static void main(String [] args) throws FileNotFoundException, JAXBException {
        if (args.length != 2)
            throw new RuntimeException("Exactly two arguments expected!");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ImporterContext.class);
        Importer importer = (Importer) context.getBean("importer");
        FILE file = FILE.valueOf(args[0]);
        switch (file) {
            case posts:
                importer.importPosts(args[1]);
                break;
            case comments:
                importer.importComments(args[1]);
                break;
            case users:
                importer.importUsers(args[1]);
                break;
            case votes:
                importer.importVotes(args[1]);
                break;
            case badges:
                importer.importBadges(args[1]);
                break;
            case post_history:
                importer.importPostHistory(args[1]);
                break;
            case tags:
                importer.importTags(args[1]);
                break;
            case post_links:
                importer.importPostLinks(args[1]);
                break;

        }
    }
}
