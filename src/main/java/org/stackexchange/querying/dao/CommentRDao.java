package org.stackexchange.querying.dao;

import org.springframework.stereotype.Repository;
import org.stackexchange.querying.CommentR;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;


@Repository
public class CommentRDao {

    @PersistenceContext
    private EntityManager em;

    public long countComments() {
        Query query = em.createQuery("SELECT COUNT(c) FROM CommentR c");
        return (Long) query.getSingleResult();
    }

    public void store(CommentR comment) {
        this.em.persist(comment);
    }

    public CommentR find(int id) {
        return this.em.find(CommentR.class, id);
    }
}
