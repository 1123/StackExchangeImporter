package org.stackexchange.dumps.importer;

import org.hibernate.Session;

public class GenericWriter<T> {

    Session session;

    public GenericWriter(Session session) {
        this.session = session;
    }

    public void open() {
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

