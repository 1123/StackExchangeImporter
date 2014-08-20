package org.stackexchange.dumps.importer;

import org.springframework.stereotype.Service;
import org.stackexchange.dumps.importer.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GenericImporterImpl implements GenericImporter {

    @PersistenceContext(unitName="stackexchange")
    private EntityManager em;

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Override
    public <T> void importFile(String file, Class<T> t) throws FileNotFoundException, JAXBException {
        this.importFile(Long.MAX_VALUE, file, t);
    }

    private static Map<Class, String> classToFile() {
        Map<Class, String> result = new HashMap<Class, String>();
        result.put(Tag.class, "Tags.xml");
        result.put(Post.class, "Posts.xml");
        result.put(Vote.class, "Votes.xml");
        result.put(Comment.class, "Comments.xml");
        result.put(SeUser.class, "Users.xml");
        result.put(PostLink.class, "PostLinks.xml");
        result.put(PostHistory.class, "PostHistory.xml");
        result.put(Badge.class, "Badges.xml");
        return result;
    }

    @Transactional()
    @Override
    public void importDirectory(String directory) throws FileNotFoundException, JAXBException {
        @SuppressWarnings("unchecked")
        List<Class<?>> classes = Arrays.asList(Tag.class, Post.class, Vote.class, Comment.class, SeUser.class, PostLink.class, PostHistory.class, Badge.class);
        for (Class clazz : classes) {
            this.importFile(directory + "/" + classToFile().get(clazz), clazz);
        }
    }

    @Transactional()
    @Override
    public <T> void importFile(final long number, String file, Class<T> t)
            throws FileNotFoundException, JAXBException {
        GenericReader<T> genericReader = new GenericReader<T>(file, t);
        int count = 0;
        while (genericReader.hasNext() && count < number) {
            this.em.persist(genericReader.next());
            count++;
            if (count % 20 == 0) {
                this.em.flush();
                this.em.clear();
            }
            if (count % 1000 == 0) {
                System.err.println("Imported " + count + " entities");
            }
        }
        genericReader.close();
    }

}
