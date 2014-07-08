package org.stackexchange.dumps.importer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.ImprovedNamingStrategy;

public class GenericWriter<T> {

    SessionFactory sessionFactory;
    Session session;

    public void open() {
        this.sessionFactory = new Configuration().setNamingStrategy(ImprovedNamingStrategy.INSTANCE)
                .configure() // configures settings from hibernate.cfg.xml
                .buildSessionFactory();
        this.session = sessionFactory.openSession();
        this.session.getTransaction().begin();
    }

    public void write(T t) {
        this.session.save(t);
    }

    public void close() {
        session.getTransaction().commit();
        session.close();
    }

}

