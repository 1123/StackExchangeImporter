package org.stackexchange.dumps.importer;

import org.hibernate.SessionFactory;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface Importer {

    public void setSessionFactory(SessionFactory sessionFactory);

    public void importPosts(String postsFile) throws FileNotFoundException, JAXBException;

    public void importBadges(String badgesFile) throws FileNotFoundException, JAXBException;

    public void importVotes(String votesFile) throws FileNotFoundException, JAXBException;

    public void importUsers(String usersFile) throws FileNotFoundException, JAXBException;

    public void importComments(String commentsFile) throws FileNotFoundException, JAXBException;
}

