package org.stackexchange.dumps.importer.posts;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.ImprovedNamingStrategy;

public class PostWriter {

    SessionFactory sessionFactory;
    Session session;

    public void open() {
        this.sessionFactory = new Configuration().setNamingStrategy(ImprovedNamingStrategy.INSTANCE)
                .configure() // configures settings from hibernate.cfg.xml
                .buildSessionFactory();
        this.session = sessionFactory.openSession();
        this.session.getTransaction().begin();
    }

    public void write(Post post) {
        this.session.save(post);
    }

    public void close() {
        session.getTransaction().commit();
        session.close();
    }

}

