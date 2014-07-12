package org.stackexchange.dumps.importer;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.stackexchange.dumps.importer.domain.*;

import javax.inject.Inject;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

@Service
public class ImporterImpl implements Importer {

    @Inject
    SessionFactory sessionFactory;

    @Override
    public void importPosts(String postsFile) throws FileNotFoundException, JAXBException {
        GenericImporter.importFile(this.sessionFactory.openSession(), Long.MAX_VALUE, postsFile, Post.class);
    }

    @Override
    public void importBadges(String badgesFile) throws FileNotFoundException, JAXBException {
        GenericImporter.importFile(this.sessionFactory.openSession(), Long.MAX_VALUE, badgesFile, Badge.class);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void importVotes(String votesFile) throws FileNotFoundException, JAXBException {
        GenericImporter.importFile(this.sessionFactory.openSession(), Long.MAX_VALUE, votesFile, Vote.class);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void importUsers(String usersFile) throws FileNotFoundException, JAXBException {
        GenericImporter.importFile(this.sessionFactory.openSession(), Long.MAX_VALUE, usersFile, SeUser.class);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void importComments(String commentsFile) throws FileNotFoundException, JAXBException {
        GenericImporter.importFile(this.sessionFactory.openSession(), Long.MAX_VALUE, commentsFile, Comment.class);
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
